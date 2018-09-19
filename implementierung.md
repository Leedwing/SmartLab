# Implementierung

## Einkaufslisten-App

**Bezeichnung:** Einkaufslistengenerator

**Betriebssystem:** Android

**Anforderungen an die App:**

·         Anzeige und Verwaltung einer Einkaufsliste

·         Anzeige und Verwaltung eines Warenkorbs

·         Anzeige einer Einkaufs – und Verbrauchshistorie der jeweiligen Produkte im Warenkorb

·         Berechnung der kumulativen Verbrauchswahrscheinlichkeit, der jeweiligen Produkte im Warenkorb

·         Farbliche und Prozentuale Anzeige der Verbrauchswahrscheinlichkeit der Produkte im Warenkorb

·         Aufnahme des Kauf – und Verbrauchsdatums bei Verwaltung der Einkaufsliste und des Warenkorbs und die Speicherung der Daten in einer MySQL Datenbank.

·         Automatisches setzen von Produkte im Warenkorb auf die Einkaufsliste, die einen höheren Verbrauchswahrscheinlichkeitswert haben als der festgelegte Schwellwert

·         Erzeugung und Anzeige eines QR-Codes, welcher den Benutzernamen / Anmeldename enthält. \(Für die Registrierung an der Kasse\)

·         Anzeige und Bearbeitung der Daten sind Benutzer -/ Kundenspezifisch

**Startmaske**

![](.gitbook/assets/1.png)

Abbildung 1: Startmaske

In Abbildung 1 ist die Startmaske zu sehen, die beim Öffnen der App angezeigt wird. Bevor die App die Maske erzeugt, mit all ihren Oberflächenkomponenten, baut sie eine Verbindung zu einer MySQL Datenbank auf. Grund dafür ist, dass erst alle relevanten benutzerspezifischen Daten, wie Warenkorb, Einkaufsliste und Historie, geladen werden. Um zu verhindern, dass während der Bedienung weniger Datenbankzugriffe getätigt werden. Dadurch steigt die Perfomance der Applikation. Verbindungen zur Datenbank werden nur aufgebaut, um eventuell relevante Updates in der Datenbank durchzuführen, beim neuen Laden einer Maske oder beim Öffnen einer neuen Maske.

Eine weitere Operation die, die App beim Erzeugen der Startmaske ausführt, ist die Berechnung der kumulativen Verbrauchswahrscheinlichkeit der jeweiligen Produkte im Warenkorb. Die Berechnung vorher auszuführen bringt den Vorteil, dass das Öffnen des Warenkorbs und die Anzeige der Maske, die die Verbrauchswahrscheinlichkeit der jeweiligen Produkte darstellt, schnell laufen. Längere Ladezeiten zwischen den Operationen, werden den User voraussichtlich mehr stören als eine längere Ladezeit beim Starten der App.

Um die kumulative Wahrscheinlichkeit zu berechnen, wird bei der Implementierung eine „Math“ Java-Bibliothek benötigt, die Methoden besitzt, die es ermöglichen die Standardabweichung zu berechnen und aus der Standardabweichung und dem Erwartungswert die Verteilungsfunktion zu bilden. Die Verteilungsfunktion wird auf Basis der Verbrauchsdaten und den MHD-Daten der jeweiligen Produkte erzeugt. Die Verbrauchsdaten des jeweiligen Users, sind eine Auflistung von „Verbrauch in Tagen“ Werten, also Werte die sich aus der Differenz vom Verbrauchsdatum und vom Kaufdatum gebildet werden. Die kumulative Wahrscheinlichkeit pro Produkt wird dann, mit Hilfe der erzeugten Verteilungsfunktion und den abgelaufenen Tagen seit dem letzten Einkauf \(Today\(\) – KaufDatum\(\)\) berechnet.

**Vorschau Coding:**

public double computeKumulativeWahrscheinlichkeit\(ArrayList&lt;Integer&gt; produktDaten,  int **abgelaufeneTage**\) {

        double erwartungsWert = this.computeErwartungswert\(produktDaten\);

        double standardAbweichung = this.computeStandardAbw\(produktDaten\);

        //Verteiluntsfunktion wird gebaut

        NormalDistribution normDist = new NormalDistribution\(erwartungsWert, standardAbweichung\);

        //Wahrscheinlichkeit, dass ein Produkt nach höchstens n-1 Tagen verbraucht wird: P\(x&lt;n\)

        double cumulWahrscheinlichkeit = normDist.cumulativeProbability\(**abgelaufeneTage**\);

        return cumulWahrscheinlichkeit;

    }

**Warenkorb**

![](.gitbook/assets/2.PNG)

Abbildung 2: Warenkorb                                                                                     ****

Wie in Abbildung 1 zu sehen öffnet sich durch betätigen des „Warenkorb“ Buttons die Warenkorbmaske, die in Abbildung 2 zu sehen ist. Wie man direkt sehen kann sind die jeweiligen Produkte mit ihrer Verbrauchswahrscheinlichkeit und einer Farbe \(rot, grün oder gelb\) markiert. Wie schon erwähnt werden die Wahrscheinlichkeiten schon beim Starten der App berechnet und den Produkten zugewiesen.

In welchen Farben die Produkte markiert werden hängt davon ab, ob die Wahrscheinlichkeiten über und unter festgelegten Schwellwerte liegen:

à Grün steht für x &lt;= 50%

à Gelb steht für 50% &lt; x &lt; 90%

à Rot steht für x &gt;= 90%

Die Farben sollen für den User eine Hilfestellung sein, um besser zu erkennen wie der Bestand seiner Produkte ist. Dafür nutzt die App ein Ampelsystem. Rot soll klar machen das, das jeweilige Produkt mit einer hohen Wahrscheinlichkeit verbraucht ist und auf die Einkaufsliste gesetzt werden sollte. Gelb soll eine kleine Warnung geben das, das Produkt eventuell beim nächsten oder übernächsten Einkauf,  auf die Einkaufsliste gesetzt werden sollte. Die Grüne Markierung kennzeichnet, dass der Bestand mit einer sehr hohen Wahrscheinlichkeit ausreichend ist.

Die App beinhaltet jedoch die Funktion, dass wenn ein Produkt im roten Bereich liegt, es automatisch auf die Einkaufsliste gesetzt wird. Das nimmt dem User die Arbeit ab, die jeweiligen Produkte manuell in die Einkaufsliste zu setzen. Wenn ein Produkt vom Warenkorb auf die Einkaufsliste gesetzt wird, dann wird das als Verbrauchsdatum gewertet und in die Historie bzw. Datenbank aufgenommen.

Der Warenkorb kann natürlich auch manuell bedient werden, indem eines der Produkte über den RadioButton markiert wird und einer der drei Buttons betätigt wird, wie in Abbildung 3 zu sehen:

·         **DELETE BUTTON:** Produkt wird aus dem Warenkorb entfernt

·         **NEW BUTTON:** Ein neues Produkt kann im Warenkorb aufgenommen werden

·         **ADD BUTTON:** Produkt wird in die Einkaufsliste gesetzt, als Verbrauchsdatum aufgenommen und in der Historie eingetragen. Zusätzlich wird noch ein Eintrag in die Verbrauchsstatistik durchgeführt, d.h. die Zeitspanne vom letzten Kaufdatum des Produktes, bis zum aufgenommen Verbrauchsdatum wird eingetragen.

à **Diese Funktion wird von der Amazon Alexa, die den Smart Home Bereich repräsentiert, auch ausgeführt.**

**Einkaufsliste**

![](.gitbook/assets/3.PNG)

Abbildung 3 Öffnen und Anzeigen Einkaufsliste

Wie in Abbildung 3 sehr gut zu sehen ist, dass Produkte, die rot markiert bzw. die Verbrauchswahrscheinlichkeit über dem Schwellwert von 90% liegt, automatisch auf die Einkaufsliste gesetzt werden \(Siehe Abbildung 4: Butter, Joghurt und Salami\).

Die Einkaufliste kann auch, wie der Warenkorb, manuell bedient werden. Durch markieren eines Produktes, durch den RadioButton, kann das Produkt entweder von der Liste gelöscht oder abgehackt werden. Diese Funktionen sind in den beiden Buttons „DELETE“ und „CHECK“ eingebettet:

·         **DELETE BUTTON:** Markiertes Produkt wird aus der Liste gelöscht, bspw. Weil das Produkt ausversehen auf die Einkaufsliste gesetzt wurde.

·         **CHECK BUTTON:** Das Markierte Produkt wird aus der Liste entfernt und als „Eingekauft“ deklariert, das bedeutet es wird zusätzlich das Kaufdatum aufgenommen und für das ausgewählt Produkt in der Historie aufgenommen

**à Diese Funktion wird vom Smarten Kassensystem beim Bezahlvorgang automatisch übernommen. \(SmartShop\)**

**Kauf- und Verbrauchshistorie**

![](.gitbook/assets/4.PNG)

![](.gitbook/assets/5.PNG)

Abbildung 5 Kauf- und Verbrauchshistorie

Eine weitere Funktion die, die App besitzt ist, wie in Abbildung 5 zu sehen, die Anzeige ein Einkaufs-und Verbrauchshistorie. Das heißt, es wird für jedes Produkt sein letztes Kaufdatum und das letzte Verbrauchsdatum angezeigt. Diese Information hilft dem User eine Übersicht zu bekommen über seinen Warenkorb und sie dienen zur Grundlage für die Berechnung des Kauf- und Verbrauchsverhaltens des Users.

**Anmelde - / Registrierungsmaske**

Abbildung 6 Anmelde- / Registrierungsmaske

Durch die in Abbildung 6 zu sehende Funktion der App, ist es möglich sich einen User definierten QR-Code anzeigen zu lassen. Die App erzeugt den QR Code selbst. Dadurch wird es für die User möglich sich bspw. An einem Kassensystem zu registrieren, in dem QR Code ist der Vor – und Nachname enthalten.

Für die Erzeugung eines QR-Codes benötigt die App eine zXing Java-Bibliothek, die importiert werden muss. Diese Bibliothek enthält die wichtigen Klassen „QRCodeWriter“ und „BitMatrix“, die es ermöglichen den gewünschten String zu kodieren und den QRCode in einer Bitmap zu erzeugen, die in einen ImageView eingefügt wird.

**Vorschau Coding:**

QRCodeWriter writer = new QRCodeWriter\(\);

try

{

            //Erzeugung einer BitMatrix mit angegeben String

            BitMatrix bitMatrix = writer.encode\(vorname + " " + name, BarcodeFormat.QR\_CODE, 512\);

            int width = bitMatrix.getWidth\(\);

            int height = bitMatrix.getHeight\(\);

            Bitmap bmp = Bitmap.createBitmap\(width, height, Bitmap.Config.RGB\_565\);

            //Erzeugung des QRCodes in einer Bitmap

            for \(int x = 0; x &lt; width; x++\)

           {

                for \(int y = 0; y &lt; height; y++\)

 {

                    bmp.setPixel\(x, y, bitMatrix.get\(x, y\) ? Color.BLACK : Color.WHITE\);

                }

            }

            \(\(ImageView\) findViewById\(R.id.imageView\_qrcode\)\).setImageBitmap\(bmp\);

 }

 catch \(WriterException e\)

 {

            e.printStackTrace\(\);

 }

## Smart Home Integration via Amazon Alexa

## Smart Shop Integration via smartem Kassensystem

