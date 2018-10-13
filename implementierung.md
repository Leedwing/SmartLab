# Implementierung

## Einkaufslisten-App

**Bezeichnung:** Einkaufslistengenerator

**Betriebssystem:** Android

**Anforderungen an die App:**

* Anzeige und Verwaltung einer Einkaufsliste
* Anzeige und Verwaltung eines Warenkorbs
* Anzeige einer Einkaufs- und Verbrauchshistorie der jeweiligen Produkte im Warenkorb
* Berechnung der kumulativen Verbrauchswahrscheinlichkeit, der jeweiligen Produkte im Warenkorb
* Farbliche und prozentuale Anzeige der Verbrauchswahrscheinlichkeit der Produkte im Warenkorb
* Aufnahme des Kauf- und Verbrauchsdatums bei Verwaltung der Einkaufsliste und des Warenkorbs und die Speicherung der Daten in einer MySQL Datenbank
* Automatisches setzen von Produkte im Warenkorb auf die Einkaufsliste, die einen höheren Verbrauchswahrscheinlichkeitswert haben als der festgelegte Schwellwert
* Erzeugung und Anzeige eines QR-Codes, welcher den Benutzernamen / Anmeldename enthält. \(Für die Registrierung an der Kasse\)
* Anzeige und Bearbeitung der Daten sind Benutzer- bzw. Kundenspezifisch

**Startmaske**

![Abbildung 3.1: Startmaske](.gitbook/assets/1.png)

In _Abbildung 3.1_ ist die Startmaske zu sehen, die beim Öffnen der App angezeigt wird. Bevor die App die Maske erzeugt, mit all ihren Oberflächenkomponenten, baut sie eine Verbindung zu einer MySQL Datenbank auf. Grund dafür ist, dass erst alle relevanten benutzerspezifischen Daten, wie Warenkorb, Einkaufsliste und Historie, geladen werden, um zu verhindern, dass während der Bedienung zu viele Datenbankzugriffe getätigt werden, wodurch die Perfomance der Applikation steigt. Verbindungen zur Datenbank werden minimiert, indem nur relevante oder benötigte Updates in oder von der Datenbank übermittelt werden, wie z.B. beim Neuladen oder beim Öffnen einer neuen Maske.

Eine weitere Operation welche die App beim Erzeugen der Startmaske ausführt, ist die Berechnung der kumulativen Verbrauchswahrscheinlichkeit der jeweiligen Produkte im Warenkorb. Die Berechnung vorher auszuführen bringt den Vorteil, dass das Öffnen des Warenkorbs und die Anzeige der Maske, welche die Verbrauchswahrscheinlichkeit der jeweiligen Produkte darstellt, performanter durchgeführt werden können. Dies wurde eingeführt, da längere Ladezeiten zwischen den Operationen, vom User als mehr störend empfunden werden, als eine längere Ladezeit beim Starten der App.

Um die kumulative Wahrscheinlichkeit zu berechnen, wird bei der Implementierung eine „Math“ Java-Bibliothek benötigt, welche Methoden besitzt, die es ermöglichen eine empirische Verteilung \(relative Häufigkeit\) zu berechnen und daraus anschließend die kumulative Wahrscheinlichkeit in Form einer Verteilungsfunktion zu bilden.   
Die Verteilungsfunktion wird auf Basis der Verbrauchsdaten und den MHD-Daten der jeweiligen Produkte erzeugt. Die Verbrauchsdaten des jeweiligen Users, sind eine Sammlung von „Verbrauch in Tagen“-Werten, also Werten die aus der Differenz vom Verbrauchsdatum und vom Kaufdatum gebildet werden. Die kumulative Wahrscheinlichkeit pro Produkt wird dann, mit Hilfe der erzeugten Verteilungsfunktion und den abgelaufenen Tagen seit dem letzten Einkauf \(Today\(\) - KaufDatum\(\)\) berechnet.

**Vorschau Coding:**

```text
// Berechnet die kumulative Wahrscheinlichkeit aus einer empirische Verteilungsfunktion 
public double cumulativeProbability(double[] produktDaten, double abgelaufeneTage) {
	EmpiricalDistribution empDist = new EmpiricalDistribution();
	empDist.load(produktDaten);
	
	double cumulativeProbability = empDist.cumulativeProbability(abgelaufeneTage);
	return cumulativeProbability;
}
```

**Warenkorb**

![Abbildung 3.2: Warenkorb ](.gitbook/assets/2.PNG)

Wie in _Abbildung 3.2_ zu sehen öffnet sich durch betätigen des „Warenkorb“-Buttons die Warenkorbmaske. Wie man direkt sehen kann sind die jeweiligen Produkte mit ihrer Verbrauchswahrscheinlichkeit und einer Farbe \(rot, grün oder gelb\) markiert. Wie schon erwähnt werden die Wahrscheinlichkeiten schon beim Starten der App berechnet und den Produkten zugewiesen.

In welchen Farben die Produkte markiert werden hängt davon ab, ob die Wahrscheinlichkeiten über und unter festgelegten Schwellwerten liegen:

| Farbe | Wertebereich |
| :--- | :--- |
| Grün | x &lt;= 50% |
| Gelb | 50% &lt; x &lt; 90% |
| Rot | x &gt;= 90% |

Die Farben sollen für den User eine Hilfestellung sein, um besser zu erkennen wie der Bestand seiner Produkte ist. Dafür nutzt die App ein Ampelsystem. Rot soll klar machen das, das jeweilige Produkt mit einer sehr hohen Wahrscheinlichkeit verbraucht ist und auf die Einkaufsliste gesetzt werden sollte. Gelb soll eine kleine Warnung geben das, das Produkt eventuell beim nächsten oder übernächsten Einkauf,  auf die Einkaufsliste gesetzt werden sollte. Die Grüne Markierung kennzeichnet, dass der Bestand mit einer sehr hohen Wahrscheinlichkeit ausreichend ist.

Die App beinhaltet jedoch die Funktion, dass wenn ein Produkt im roten Bereich liegt, es automatisch auf die Einkaufsliste gesetzt wird. Das nimmt dem User die Arbeit ab, die jeweiligen Produkte manuell in die Einkaufsliste zu setzen. Wenn ein Produkt vom Warenkorb auf die Einkaufsliste gesetzt wird, dann wird dieser Zeitpunkt als Verbrauchsdatum gewertet und in die Verbrauchshistorie bzw. Datenbank aufgenommen.

Der Warenkorb kann natürlich auch manuell bedient werden, indem eines der Produkte über den RadioButton markiert wird und einer der folgenden drei Buttons betätigt wird, wie in _Abbildung 3.3_ zu sehen:

* **DELETE BUTTON:** Produkt wird aus dem Warenkorb entfernt
* **NEW BUTTON:** Ein neues Produkt kann im Warenkorb aufgenommen werden
* **ADD BUTTON:** Produkt wird in die Einkaufsliste gesetzt, als Verbrauchsdatum aufgenommen und in der Historie eingetragen. Zusätzlich wird noch ein Eintrag in die Verbrauchsstatistik durchgeführt, d.h. die Zeitspanne vom letzten Kaufdatum des Produktes, bis zum aufgenommen Verbrauchsdatum wird erfasst.
* _**Diese Funktionen werden unabhängig vom verwendeten Kanal zur Erfassung \(wie z.B. Amazon Alexa\), ebenfalls ausgeführt.**_ 

**Einkaufsliste**

![Abbildung 3.3: &#xD6;ffnen und Anzeigen Einkaufsliste](.gitbook/assets/3.PNG)

Wie in _Abbildung 3.3_ sehr gut zu sehen ist, werden Produkte, die rot markiert bzw. bei denen die Verbrauchswahrscheinlichkeit über dem Schwellwert von 90% liegen, automatisch auf die Einkaufsliste gesetzt.

Die Einkaufliste kann auch, wie der Warenkorb, manuell bedient werden. Durch markieren eines Produktes, durch den RadioButton, kann das Produkt entweder von der Liste gelöscht oder abgehakt werden.   
Diese Funktionen sind durch die beiden Buttons „DELETE“ und „CHECK“ realisiert:

* **DELETE BUTTON:** Markiertes Produkt wird aus der Liste gelöscht, bspw. Weil das Produkt ausversehen auf die Einkaufsliste gesetzt wurde.
* **CHECK BUTTON:** Das Markierte Produkt wird aus der Liste entfernt und als „Eingekauft“ deklariert, das bedeutet es wird zusätzlich das Kaufdatum aufgenommen und für das ausgewählt Produkt in der Historie aufgenommen
* _**Diese Funktion wird vom Smarten Kassensystem beim Zahlvorgang automatisch übernommen. \(Smart Shop\)**_

**Kauf- und Verbrauchshistorie**

![Abbildung 3.4: Kauf- und Verbrauchshistorie](.gitbook/assets/4.PNG)

Eine weitere Funktion welche die App besitzt ist, wie in _Abbildung 3.4_ zu sehen, die Anzeige einer Einkaufs- und Verbrauchshistorie. Das heißt, es wird für jedes Produkt sein letztes Kaufdatum und das letzte Verbrauchsdatum angezeigt. Diese Information hilft dem User eine Übersicht über seinen Warenkorb zu bekommen und dienen zusätzlich als Grundlage für die Berechnung des Kauf- und Verbrauchsverhaltens des Users.

**Anmelde - / Registrierungsmaske**

![Abbildung 3.5: Anmelde- / Registrierungsmaske](.gitbook/assets/5.PNG)

Die in _Abbildung 3.5_ dargestellte Funktion der App, bietet dem Nutzer die Möglichkeit sich einen User definierten QR-Code anzeigen zu lassen. Die App erzeugt den QR-Code selbst. Dadurch wird es für die User möglich sich bspw. an einem Kassensystem zu authentifizieren.

Für die Erzeugung eines QR-Codes benötigt die App eine zXing-Java-Bibliothek, die importiert werden muss. Diese Bibliothek enthält die wichtigen Klassen „QRCodeWriter“ und „BitMatrix“, die es ermöglichen den gewünschten String zu kodieren und den QRCode in einer Bitmap zu erzeugen, welche anschließend in einen ImageView eingefügt wird.

**Vorschau Coding**

```text
QRCodeWriter writer = new QRCodeWriter();
try
{
    // Erzeugung einer BitMatrix mit angegeben String
    BitMatrix bitMatrix = writer.encode(vorname + " " + name, BarcodeFormat.QR_CODE, 512, 512);

    int width = bitMatrix.getWidth();
    int height = bitMatrix.getHeight();
    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);

    // Erzeugung des QRCodes in einer Bitmap
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            bmp.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
        }
    }
    
    // Einfügen in ImageView
    ((ImageView) findViewById(R.id.imageView_qrcode)).setImageBitmap(bmp);

}
catch (WriterException e)
{
    e.printStackTrace();
}
```

## Smart Home Integration via Amazon Alexa

**Bezeichnung:** Shop Node

**Anforderung an den Alexa-Skill:**

* Verbindung zu einer MySQL Datenbank
* Bearbeitung einer Einkaufsliste \(Löschen und Hinzufügen von Produkten\)
* Das Abfragen einer Einkaufliste
* Aufnahme des Verbrauchsdatum beim Hinzufügen eines Produktes auf die Einkaufliste
* Aufnahme „Verbrauch in Tagen“ eines Produktes und hinzufügen in die Verbrauchsstatistik     

Die Alexa Skill Entwicklung lässt sich in zwei Schichten unterteilen. Einmal das Frontend \(Interaction Model\) und auf der anderen Seite das Backend \(Hosted Service\). Die beiden Schichten werden durch den Alexa Voice Service miteinander verbunden.

Das Interaction Model beschreibt die Kommunikation zwischen dem User und dem Alexa Voice Service. Die Kommunikation muss immer einem bestimmten Schema entsprechen. Kleinere Abweichungen vom definierten Schema können toleriert werden.

Unter dem Hosted Service versteht man das Backend. Hier wird der Funktionscode in der serverseitigen Plattform „Node.js“ mit der Programmiersprache „JavaScript“ geschrieben. Der Code wird in der Cloud ausgeführt, wenn Alexa mittels Spracheingabe aufgerufen wird.

**Entwicklung des Amazon Alexa Skills mit JavaScript über AWS Lamda**

Im Code sind mehrere sogenannte Intents hinterlegt, welche per passendem Sprachbefehl aufgerufen werden können. Intents sind vergleichbar mit Methoden die bspw. durch ein Button Klick ausgeführt werden. Beim Aufruf können auch bestimmte Informationen \(in diesem Fall Produkte\) per Variable übergeben werden.  Die Intents und Variablen müssen im Amazon Developer Tool definiert werden. Die Intelligenz wird dann im Programmcode, im AWS Lamda Tool, ausprogrammiert.

![](.gitbook/assets/unbenannt4.PNG)

Abbildung 3.6: Ansicht , Intentdefiniton über das Amazon Developer Tool

In Abbildung 3.6 ist zu sehen wie ein Intent definiert wird, in diesem Beispiel der AddIntent. Man erzeugt ihn über das Amazon Developer Tool und bezeichnet ihn sinngerecht. Zusätzlich werden noch Utterances und Slot Types \(Variablen\) definiert. Sie werden benötigt um den Intent auszuführen.

Die Intelligenz des AddIntent wird dann in der Lamda Management Console ausprogrammiert.

```text
 'AddIntent': function () {//-------------------------------------------------------------------------------------------------
    //------------------
        //this.emit(':tell', 'Ich bin im AddIntent');
        
        this.attributes.mode = MODES.ADD;
        
        if(this.event.request.intent.slots.product)
        {
            const product = this.event.request.intent.slots.product.value.toLowerCase();
            this.attributes.product = product;
            this.emit(':ask', 'Wollen Sie ' + product + ' auf die Einkaufsliste setzen ?', 'Wollen sie ' + product + 'hinzufügen ?');
        }
        else
        {
            this.emit(':tell', 'ERROR_MESSAGE');
        }
    }
```

Abbildung 3.7: AddIntent

In der Abbildung 3.7 ist zu sehen wie der AddIntent ausprogrammiert wird. Es wird der Modus gesetzt und definiert was Alexa zum Client sagen soll, wenn der AddIntent ausgeführt wird. Abhängig von der Antwort reagiert Alexa.

**Notwendige Intents um die Anforderungen an den Skill zu erfüllen:**

* **GeneratorIntent:** Startet den Skill und sorgt dafür, dass Alexa Anweisungen zur Einkaufsliste entgegen nimmt. "Alexa, starte Shop Note"
* **AddIntent:** Alexa wurde um Hinzufügen eines Produktes gebeten und fragt nach einer Bestätigung der Aktion. "Füge \[Produkt\] zur Liste hinzu." , "\[Produkt\] hinzufügen"
* **RemoveIntent:** Alexa wurde gebeten, ein Produkt von der Liste zu entfernen und bittet um Bestätigung. "\[Produkt\] entfernen!", "Alexa, ich habe \[Produkt\] eingekauft
* **ListIntent:** Alexa wurde gebeten, die Einkaufsliste auszugeben. "Einkaufsliste ausgeben", "Liste abfragen"
* **EinkaufslisteLeerenIntent:** Alexa wurde gebeten, die Einkaufsliste zu löschen und fragt nach Bestätigung. "Liste leeren", "Alexa, ich war einkaufen"
* **CanelIntent:** Beendet die Eingabe von Daten. „Beenden“

Der Aufruf eines Intent wird weiterverarbeitet, indem eine dynamische URL erzeugt wird, die per GET-Request aufgerufen wird. Als command wird das jeweils zum Befehl gehörende Kommando ausgewählt, als Parameter **product** wird das genannte Produkt verwendet, welches von Alexa per Spracherkennung eingesetzt wird. Die Bestätigung erfolgt jeweils per **Ja** oder **Nein.**

Nach dem GET-Request wartet der Intent auf Antwort vom Webserver und kann diese weiter verarbeiten. In der Regel wird ein Teil der Antwort ausgelesen, bzw. bei Erfolgsmeldung eine Bestätigung der Aktion ausgegeben.

**Entwicklung des Backends**

Aufrufe am Apache Webserver werden per GET-Request durchgeführt, welcher drei Parameter über die URL empfängt:

* user
* command
* product

Ein beispielhafter Request sieht wie folgt aus: [http://xxxx/einkaufslistengenerator.php?user=fabio&command=add&product=salami](http://xxxx/einkaufslistengenerator.php?user=fabio&command=add&product=salami)​

Bei Aufruf dieser URL würde mit dem User "fabio" das Produkt "salami" zum Warenkorb hinzugefügt werden. Folgende Commands werden vom Webserver erkannt:

* **add -** Fügt ein neues Product der Liste hinzu.
* **remove** - Entfernt ein Produkt von der Liste
* **list** - gibt die vollständige Liste aus
* **reset** - leert die Liste vollständig.

Beim Aufruf der URL wartet Alexa auf einen Callback vom Server \(siehe Abbildung 3.8\). Die Anfrage wird erst abgeschlossen, wenn der Webserver eine response verschickt. Im Falle der Aktionen **add, remove** und **reset** wird lediglich nach Abschluss der serverseitigen Verarbeitung eine Erfolgsmeldung versendet, im Falle von **list** besteht die Response aus einer Liste aller Produktbezeichnungen.

```text
function getResult(user, url, callback) {
    //   ---------
    var result = "";
    //var path = 'var/wwww/html/einkaufslistengenerator.php?user=' + user;
    var path = '/einkaufslistengenerator.php?user=' + user;
    //var path = '/einkaufslistengenerator.php?';
    
    if (url) {
        path += url;
    }
    
    const options = {
        host: '95.179.151.124',
        path: path,
        method: 'GET'
    };
    
    
     HTTP.get(options, response => {
        response.setEncoding('utf8');
        var responseString = '';
        
        response.on('data', data => {
            responseString += data;
            console.log(responseString);
        });
        
        response.on('end', () => {
            const json = JSON.parse(responseString); // {'result': 'ivo'};
            console.log(callback(json.result));
            callback(json.result); // z.B. 'ivo', ['a', 'b', 'c']
        });
    });
    
    return result;
}
```

Abbildung 3.8: Response und Callback Defintion

## Smart Shop Integration via smartem Kassensystem

**Betriebssystem:** Android

**Anforderung an das Kassensystem:**

* Möglichkeit für Kundenanmeldung via QR-Code
* Anzeige aller Produkte
* Anzeige aller Produkte die abgescannt oder ausgewählt wurden, in listenform
* Möglichkeit Produkte via Barcode abzuscannen
* Nach dem Bezahlvorgang , sollen alle ausgewählten Produkte vom Einkaufzettel gestrichen werden, Produkte die noch nicht im Warenkorb eingetragen sind , sollen eingetragen werden und das Kaufdatum der Produkte soll aufgenommen werden  

**Startmaske**

![](.gitbook/assets/6.PNG)

Abbildung 3.9: Startmaske Kassensystem

In Abbildung 3.9 ist die Startmaske des Smarten Kassensystems zu sehen. Wie man sieht gibt es zwei Modi. Einmal die Möglichkeit die Kasse direkt zu öffnen ohne Anmeldung des Kunden und die andere Möglichkeit ist es den Kunden sich anmelden zu lassen bevor die Kasse angezeigt wird.

* **KUNDEN LOGIN Button:** Eine neue Maske öffnet sich und es besteht die Möglichkeit den Kunden via QR-Code, sich anmelden zu lassen. Bevor die Kassenmaske anzeigt wird, wird eine Verbindung zu einer MySQL Datenbank aufgebaut. Es werden alle kundenspezifischen Daten geladen \(Warenkorb\) und alle relevanten Produktdaten
* Dies kann in der Doku nicht veranschaulicht werden, da die Abbildungen von einem Android Emulator stammen. Mit diesem ist es nicht möglich ein Kamerabild zu zeigen, somit auch kein QR-Code oder Barcode Scann möglich, da diese über die Kamera gemacht wird
* **KASSE Button:** Die Kassenmaske wird geöffnet. Es wird eine Verbindung zu einer MySQL Datenbank aufgebaut und alle relevanten Produktdaten geladen.

**Kasse**

![](.gitbook/assets/unbenannt1.PNG)

Abbildung 3.10: Kassenmaske

In Abbildung 3.10 ist die Kassenmaske zu sehen. Die Maske ist in 2 Fragmente aufgeteilt.

In **Fragment 1** werden die ausgewählten Produkte aufgelistet. Sie werden entweder durch den Barcode Scan oder durch klicken eines Buttons aus Fragment 2, auf die Liste gesetzt.

* **DELETE BUTTON:** Wenn ein Produkt ausversehen auf die Liste gesetzt wird, kann durch markieren des Produktes mittels des RadioButtons und betätigen des DELETE Buttons, ein Produkt aus der Liste entfernt werden
*  **BEZAHLEN BUTTON:** Die Funktion des Bezahl Buttons ist davon abhängig ob ein Kunde angemeldet ist oder nicht. Wenn kein Kunde angemeldet ist, dann wird nur die Produktliste geleert, der Bezahlvorgang abgeschlossen und die Startmaske anzeigt. Wenn ein Kunde angemeldet ist passiert einiges mehr im Hintergrund. Das Kassensystem baut eine Verbindung zu einer MySQL Datenbank auf, um die Produkte die auf der Liste sind von der Einkaufsliste des Kunden zu streichen, da diese dann als „eingekauft“ gelten. Gleichzeitig wird das Kaufdatum der jeweiligen Produkte in der Historie eingetragen. Zusätzlich werden Produkte die auf der Produktliste sind, jedoch nicht im Warenkorb des Kunden, seinem Warenkorb automatisch hinzugefügt.

![](.gitbook/assets/unbenannt2.PNG)

Abbildung 3.11: Automatisch Produkt in Warenkorb einfügen

Zum genaueren Verständnis, der Warenkorb beinhaltet die Produkte die der Kunde im Laufe der Zeit mindestens 1-mal eingekauft hat bzw. Produkte die der Kunde generell einkauft.

**Fragment 2**  ist nochmal in zwei Segmente aufgeteilt. Jedes Segment ist eine Möglichkeit ein Produkt auf die Produktliste zu setzen. Zum einen ist es möglich durch klicken des Buttons **SCAN,** der einen Barcode Scanner öffnet, ein Produkt via Barcode auf die Liste zu setzen und zum anderen ist es möglich durch ein Button klick. Für jedes Produkt aus der Datenbank wird dynamisch, bei der Erzeugung der Oberfläche, ein Button generiert. Wird ein Produkt ausgewählt, sei es vom Barcode Scanner oder durch den Button, wird der Button entschärft, sodass Produkte nicht doppelt auf die Liste gesetzt werden \(siehe Abbildung 7, Käse, Joghurt und Milch\).

Die dynamisch erzeugten Buttons werden mit zwei verschiedenen Farben markiert, wie in Abbildung 3.11 zu sehen. Die grün markierten Buttons bedeuten ein Kunde ist angemeldet und das diese Produkte sich im Warenkorb des Kunden befinden. Die gelb markierten Buttons bedeuten, wenn ein Kunde angemeldet ist, dass diese Produkte nicht im Warenkorb eingetragen sind. Wenn kein Kunde angemeldet ist, sind logischerweise alle Buttons gelb. \(siehe Abbildung 3.12\)

![](.gitbook/assets/8.PNG)

Abbildung 3.12: Ansicht des Kassensystems, wenn kein Kunde angemeldet ist

