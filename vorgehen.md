# Vorgehen

## Marktanalyse

Wer die Smart Factory will, muss drei Kernaufgaben lösen: Benötigt werden die Akzeptanz der Belegschaft, die Vernetzung aller Maschinen sowie die Fähigkeit, Big Data in Smart Data zu verwandeln. In Verbindung mit einer integrierten Cloudfähigen IT-Plattform für Smart Shop sowie für Smart Home Top Floor wird die synchrone Echtzeit-Steuerung weltweiter Anlagenverbünde möglich. Auf diese Weise lassen sich Produktivitätsgewinne im zweistelligen Bereich erreichen.

Smart Shop/Home bezeichnet den Einsatz von technischen Systemen, automatisierten Verfahren und vernetzten, ferngesteuerten Geräten in Wohnräumen und Häusern. Die Funktionen dienen vornehmlich dazu, die Lebensqualität und den Wohnkomfort zu erhöhen. Weitere Ziele sind eine erhöhte Sicherheit und effizientere Energienutzung auf Grundlage vernetzter und fernsteuerbarer Geräte. Die Kommunikation und Steuerung der Smart Home/Shop Technik erfolgt dabei über gängige Funkstandards wie WLAN, Bluetooth, ZigBee oder Z-Wave. Die Zentrale wird auch als Hub oder Gateway bezeichnet. Geräte starten, steuern und überwachen selbstständig je nach Szenario und Programmierung bestimmte Abläufe im Haushalt sowie in Supermarken. Interoperabilität ist das Zauberwort. Sind Geräte untereinander interoperabel, können Sie miteinander kommunizieren. Nur dann aktiviert sich die Alarmanlage, wenn die Rolläden nach unten fahren. Nur dann schaltet sich die Heizung aus, wenn das Fenster geöffnet wird. Ist keine Interoperabiltät zwischen den Elementen gegeben, ist das Home schlichtweg nicht smart. Wie verwandelt sich das Zuhause ins Smart Home und das Supermarkt ins Smart Shop? Die Installation und Einrichtung der benötigten Komponenten lässt sich auch ohne technische Fachkenntnisse erreichen/umsetzen. Folgende Aspekte sollten bei der Planung beachtet werden: 

* Benötigt wird ein Internetanschluss und WLAN
* Smartphone oder Tablet eignen sich am besten zur Steuerung und Überwachung der Geräte
* Ein kabelloses Netzwerk ist zeitgemäß, komfortabel und elegant, die Übertragung per Kabel allerdings sicherer
* Sollen die Geräte über die Zentrale programmierbar und interoperabel sein oder reicht eine Lösung, die alleinstehend nutzbar ist?
* Sind alle Geräte mit demselben Funkstandard \(z.B. WLAN\) verbunden?
* Die Zentrale sollte so platziert werden, dass alle anzusteuernden Geräte innerhalb ihres Reichweitenradius liegen

### Touchpoints zwischen Smart Shop und Smart Home:

Seit Jahrzehnten helfen unterschiedlichste IT-Plattformen dabei, den Alltag des Menschen angenehmer zu gestalten, Abläufe zu beschleunigen und so Zeit und Arbeit zu sparen. Welche zusätzlichen Vorteile bringt da Smart Home/Shop? Ohne Smart Home muss der Mensch sämtliche Impulse für die Maschinen setzen, er muss Abläufe manuell starten und jedes Gerät einzeln zum passenden Zeitpunkt aktivieren. Smart Home nimmt ihm diese Arbeit ab, indem es Komponenten miteinander kommunizieren lässt weitere Vorteile hat Amazon schafft mit seinem neuen Shop-Konzept Amazon Go den lästigsten Teil beim Einkauf ab. Das Bezahlen an der Kasse. Schlange stehen war gestern. Möglich macht das "Sensor Fusion" Amazon Go, der neue Convenience-Store für Lebensmittel, Snacks und Getränke in Seattle \(2131 Seventh Avenue\) ist vermutlich weltweit der fortschrittlichste Supermarkt. Denn er kommt ohne klassische Kassen aus. Die Kunden checken per App und QR-Code-Scan im Laden ein, Sensoren – Amazon raunt im Video von „Sensor Fusion“ - erkennen, welche Produkte aus dem Regal genommen werden. Die Technik erlaubt, dass der Kunde den Laden dann einfach mit der Ware verlassen kann. Die Abrechnung erfolgt wiederum per App. Vorerst können nur Amazon-Mitarbeiter den Laden und seine Technik testen. Amazon selbst begnügt sich mit nebulösen Schlagworten, spricht von “computer vision, sensor fusion and deep learning” und lässt lediglich durchblicken, dass man Technologien einsetze, wie man sie von selbstfahrenden Autos kennt. Kameras und eine Kombination unterschiedlicher Sensoren füttern also einen lernenden Algorithmus, der erkennen soll, welche Produkte Kunden aus dem Regal nehmen – oder wieder zurückstellen. Die Daten über den Nutzer spielen nämlich womöglich eine zentrale Rolle für die künstliche Intelligenz des lernenden Algorithmus und die Erkennung der Artikel.

Das Konzept eignet sich nicht nur für Lebensmittel, sondern lässt sich auch auf andere Branchen wie Waschmaschine, Lampen oder Kaffeeautomaten übertragen. Haushaltsgeräte lassen sich via Zeitsteuerung kontrollieren. Geräte wie Bewegungsmelder, Kameras, Rollläden oder Thermostate lösen vom Nutzer programmierte Abläufe aus. Herzstück des Smart Home ist die Zentrale, mit der unterschiedliche smarte Komponenten verbunden und per PC, Smartphone oder Tablet steuerbar gemacht werden übertragen. Da der Kunde das Smartphone einsetzen muss, um sich Zugang zum Laden zu verschaffen, ist er auch offener für weitere mobile Informationen \(aka Angebote\) per App. Durch die Verknüpfung mit der App sammelt Amazon Daten über das OfflineEinkaufsverhalten. Diese Informationen können wiederum für Online-Angebote genutzt werden. Umgekehrt lässt sich analysieren, welche Online-Offerten Einfluss auf das stationäre Einkaufsverhalten haben.

## Entwicklung des Geschäftsmodells

### Idee/App-Vorstellung:

Smart Home und Smart Shop ist eine super Sache zur Erhöhung des Komforts, der Einbruchsicherheit und der Energieeinsparung. Die technische Revolution im Supermarkt sowie Zuhause ist eher unauffällig. Sie wird deutlich dadurch, dass viele Informationen digital zu mir kommen.

 **Idee:** Erstellung einer intelligenten digitalen Einkaufsliste mit folgenden Funktionen:

* dynamische Anpassung der Liste
* Kategorisierung der Produkte nach Dringlichkeit

Diese Funktionen werden anhand folgender Informationen realisiert:

* Kaufverhalten des Users
* Haltbarkeitsdaten gekaufter Produkte
* Verbrauchsdaten gekaufter Produkte

### Wie bestimme ich eine Wahrscheinlichkeit ob ein Produkt gebraucht wird?

Verschiedene Anwendungsfälle sind möglich, aber wir konzentrieren uns auf den Teilprozess "Einkaufsliste ausfüllen" des Einkaufsprozesses.

![](.gitbook/assets/image%20%286%29.png)

* Smart Home: Erfassung von Verbrauchsdaten über Smart Home Geräte \(Alexa\).
* Smart Shop: Erfassung von Ablaufdaten von Produkten / Produktgruppen und Lieferung von Einkaufsdaten eines Verbrauchers über Smart-Shop-Geräte.
* Einkaufsliste Applikation: Zusammenführung von Ablauf- und Verbrauchsdaten mit dem Einkauf und Bestimmung der Wahrscheinlichkeiten der Produktnachfrage und Verwendung von Wahrscheinlichkeiten zum automatischen Füllen der Einkaufsliste nach definierten Regeln.

#### Methods:

Die dargestellten Wahrscheinlichkeitsfunktionen sind nur ein kleiner Teil aller vorhandenen Funktionen.

![](.gitbook/assets/image%20%288%29.png)

  
Um zu überprüfen, ob eine allgemeine Wahrscheinlichkeitsfunktion \(Dichte\) der gegebenen Datenverteilung ähnlich ist, gibt es verschiedene Möglichkeiten.Diese können z.B. sein:

* Optische Prüfung \(Vergleich beider Funktionen optisch\)
* Kolmogorow-Smirnow-Test
* Anderson-Darling-Test
* Chi-Quadrat-Test

#### Beispiel: Normalwahrscheinlichkeitsverteilung:

Angenommen, wir haben festgestellt, dass unsere Daten \(fast\) normalverteilt sind. Nun können wir die entsprechende Wahrscheinlichkeitsdichtefunktion für unsere Daten berechnen.

* Wahrscheinlichkeitsdichtefunktion f \(einer Variablen x\) \[Normalverteilung\]:

![](.gitbook/assets/image%20%281%29.png)

* Erwarteter Wert E \(einer Variablen X\):

![](.gitbook/assets/image%20%289%29.png)

* Abweichung σ² und Standardabweichung σ \(einer Variablen X\):

![](.gitbook/assets/image%20%287%29.png)

#### Kumulative Wahrscheinlichkeitsverteilungsfunktion:

Nachdem wir eine Wahrscheinlichkeitsfunktion \(Dichte\) aufgebaut haben, müssen wir die Funktion in eine kumulative Wahrscheinlichkeitsfunktion umwandeln. Mit dieser Funktion kann dann bestimmt werden, bis wann ein Produkt wieder gekauft werden muss. Dies kann mit Hilfe der folgenden Formel erfolgen: kumulative Wahrscheinlichkeitsverteilungsfunktion P\(X ≤ x\):

![](.gitbook/assets/image%20%282%29.png)

Ablaufdaten als Datenbasis:

In diesem Fall hängt die Wahrscheinlichkeit, dass ein Produkt gekauft werden muss, nur von den Ablaufdaten des Produkts ab. Basierend auf einem Satz von Ablaufdaten eines Produkts ist es möglich, zu bestimmen, mit welcher Wahrscheinlichkeit ein Produkt zu einem bestimmten Zeitpunkt abläuft, indem die Wahrscheinlichkeitsfunktion \(Dichte\) oder die kumulative Wahrscheinlichkeitsfunktion aufgebaut wird. Das heißt, je mehr Daten verfügbar sind, desto genauer kann die Wahrscheinlichkeit bestimmt werden.Informationen, die von:

* Manuelle Erfassung
* Smart Shop
  * Große Menge an Ablaufdaten verfügbar
  * Langzeitstatistik denkbar
* Smart Home
  * Smart Home Geräte können das Datum verfolgen

Beispiel für Ablaufdaten:

Angesichts der folgenden Ablaufdaten für ein bestimmtes Produkt: 01.07.2018, 15.07.2018, 01.07.2018, 01.07.2018, 15.07.2018. Zur einfacheren Berechnung übertragen wir diese Daten in, Tage bis   Ablaufdatum:  1 Tag, 15 Tage, 1 Tag, 1 Tag, 15 Tage \(angenommen heute ist 30.06.2017\):

![](.gitbook/assets/image%20%283%29.png)

* Stark verbreitet
* Keine Übereinstimmung der allgemeinen Wahrscheinlichkeitsverteilung \(Näherung nicht sinnvoll\)
* Verwendung der relativen Häufigkeit der Daten zur Erzeugung einer Wahrscheinlichkeitsfunktion

So beschlossen wir nun, die kumulative Wahrscheinlichkeitsverteilung basierend auf den Daten \(und ihrer relativen Häufigkeit\) aufzubauen. Für das angegebene Beispiel würde die Funktion so aussehen:

![](.gitbook/assets/image%20%284%29.png)

Verbrauchsdaten als Datenbasis:

In diesem fall hängt die Wahrscheinlichkeit, dass ein Produkt gekauft werden muss, nur vom Verhalten des Verbrauchers ab. Dieses Verhalten wird in Form von Verbrauchsdaten geliefert. Das heißt, die Daten enthalten Informationen darüber, wie lange es dauert, bis ein Produkt von einem bestimmten Verbraucher/Haushalt konsumiert wird. Basierend auf einem Satz von Verbrauchsdaten eines Produkts ist es möglich, zu bestimmen, mit welcher Wahrscheinlichkeit ein Produkt bis zu einem bestimmten Datum verbraucht wird, indem die Wahrscheinlichkeitsfunktion \(Dichte\) oder die kumulative Wahrscheinlichkeitsfunktion aufgebaut wird. Wie bereits erwähnt, bedeutet dies, dass je mehr Daten verfügbar sind, desto genauer kann die Wahrscheinlichkeit bestimmt werden. 

Zum Beispiel: Angesichts der folgenden Verbrauchsdaten für ein bestimmtes Produkt: 2,3,4,4,4,4,5,5,5,5,6,5,6,6,6,6,7,7,8 \(Tage\)

![](.gitbook/assets/image%20%2811%29.png)

  
In der Abbildung sehen wir, wie die Daten verteilt sind. Wie wir sehen können, sieht die Verteilung der Daten ähnlich aus eine normale Verteilung.Deshalb werden wir eine Approximation der Wahrscheinlichkeitsfunktion unter Verwendung der Normalverteilungsfunktion erstellen.

Wir haben uns entschieden, die Wahrscheinlichkeitsfunktion oder die kumulative Wahrscheinlichkeitsfunktion aufzubauen, indem wir sie mit Hilfe der Normalverteilungsfunktion approximieren. Um die Wahrscheinlichkeitsdichtefunktion zu erhalten, müssen wir zunächst den Erwartungswert und die Standardabweichung/varianz bestimmen:

![](.gitbook/assets/image%20%2810%29.png)

Nachdem wir die Wahrscheinlichkeitsdichtefunktion erstellt haben, können wir darüber integrieren, um die kumulative Wahrscheinlichkeitsverteilungsfunktion zu erhalten.Die Wahrscheinlichkeitsdichtefunktion kann uns die Wahrscheinlichkeit mitteilen, dass ein Produkt genau jetzt verbraucht wird. Für unseren Anwendungsfall wird also die kumulative Wahrscheinlichkeitsverteilungsfunktion benötigt, weil wir nicht die Wahrscheinlichkeit wissen wollen, dass ein Produkt genau jetzt konsumiert wird, sondern wir wollen jetzt wissen, wie die Wahrscheinlichkeit ist, dass es bisher konsumiert wird.

### Welchen Mehrwert liefert Smart Shop?

In einer Welt mit sofortigem Zugriff auf Informationen, wo der Wettbewerb nur einen Klick entfernt ist, die Gewinnung und Bindung von Kunden ist von entscheidender Bedeutung für die Überleben Mobile Technologien können helfen, das Ziel zu erreichen. diese Ziele durch die Verbesserung der Einkaufsmöglichkeiten zu erreichen. Erfahrung und Informationsbeschaffung und Intimität mit den Kunden. Dies wird den Einzelhändlern neue Möglichkeiten eröffnen und Hersteller, mit denen sie sich stärker befassen sollten.

#### Idee : Erstellung  intelligentes Kassensystem:

wir haben uns entschieden ein intelligentes Kassensystem zu erstellen mit folgenden Anforderungen:

* Möglichkeit für Kundenanmeldung via QR-Code
* Anzeige aller Produkte
* Anzeige aller Produkte die abgescannt oder ausgewählt wurden
* Möglichkeit Produkte via Barcode abzuscannen
* Nach dem Bezahlvorgang :

  * Sollen alle ausgewählten Produkte vom Einkaufzettel gestrichen werden
  * Produkte die noch nicht im Warenkorb eingetragen sind , sollen eingetragen werden
  * Das Kaufdatum der Produkte soll aufgenommen werden

### Welchen Mehrwert liefert Smart Home?

Bevor wir uns darauf konzentrieren, wie Smart Home unsere Einkaufsprozesse optimieren kann, geben wir einen kurzen Überblick darüber und über seine Möglichkeiten. Der Smart-Home-Markt ist einer der am schnellsten wachsenden Märkte der Welt. Smart-Home-Geräte sind bereits in fast jedem Aspekt des Wohnens integriert, zum Beispiel: Unterhaltung, Sicherheit, Hauswirtschaft, Überwachung usw.Diese Geräte verbessern die Prozesse, indem sie zusätzliche Dienste bereitstellen oder den Aufwand für bestimmte Aufgaben reduzieren. Diese schnelle Entwicklung wird durch eine schnelle Verbesserung von Software und Hardware ermöglicht.

Viele Prozesse können mithilfe von Smart Home verbessert werden. In diesem Abschnitt konzentrieren wir uns jedoch auf die Verbesserung des Einkaufsprozesses.

![](.gitbook/assets/unbenannt.PNG)

* Der User benötigt  5 oder 6 Clicks auf seinem Smartphone, um ein Produkt auf die digitale Einkaufsliste zu setzen
* Zuvor besteht die Möglichkeit , dass der User das Smartphone, in dem Moment, in der er ein Produkt auf die Einkaufsliste setzen will, nicht zu Hand hat. Er muss es erst suchen.
* Das bedeutet von dem Wunsch, ein Produkt auf die Einkaufsliste zu setzen und bis das Produkt auf der digitalen Einkaufsliste ist, müssen viele Steps durchlaufen werden. Vielen Usern ist das ein zu großer Aufwand und werden deshalb die Software nicht nutzen

 Lösung: Smart Home Devices sind die Lösung um diesen Vorgang zu vereinfachen und zu beschleunigen.Wir haben die Technologien im Smart Home Bereich analysiert und bewertet welche für den Bestands und Kontrollprozess hilfreich sind:

![](.gitbook/assets/image%20%2812%29.png)

Amazon Alexa:

* Verwaltet eine digital Shopping List mit Sprachsteuerung
* Dadurch entfällt die manuelle Verwaltung : Mit der Sprachsteuerung beispielsweise kann ein Produkt mit nur einem Befehl auf die Einkaufsliste gesetzt werden, anstatt zuerst das Smartphone auszupacken, die Einkaufslisten-App zu öffnen und das richtige Produkt hinzuzufügen
* Aufnahme des Verbrauchsdatum beim Hinzufügen eines Produktes auf die Einkaufliste
* Aufnahme „Verbrauch in Tagen“ eines Produktes und hinzufügen in die Verbrauchsstatistik  

Smarter Kühlschrank:

* Anzeige des tatsächlichen Bestands im Kühlschrank
* Automatisches hinzufügen von Produkten auf eine digitale Einkaufsliste wenn Produkt ausgeht.

Wir haben uns für voice- vontrol bei der Realisierung entschieden weil der Smart-Fridge von der Technologie noch nicht so ausgereift ist bzw. wenn noch zu teuer und selbst entwickelte Apps können nicht bestückt werden.

### Fusion von Smart Home und Smart Shop:

Im Artikel "Towards a definition of the Internet of Things \(IoT\)" von IEEE Internet of Thing gibt es viele Definitionen dieses Ausdrucks aus verschiedenen Gruppen. IoT-SRA \(Internet of Things Strategic Research Agenda\) bietet eine Definition des IoT, die auf drei Perspektiven basiert. IoT muss sein Dinge orientiert, was bedeutet, dass die Dinge Identitäten haben, um in einem intelligenten Raum zu funktionieren und Schnittstellen zur Kommunikation mit der Umgebung zu verwenden. Internetorientiert, d.h. Existenz einer globalen Netzwerkinfrastruktur zur Verknüpfung von physischen und virtuellen Objekten mit Hilfe von Daten- und Kommunikationsmöglichkeiten. Semantisch orientiert, d.h. IoT-Ressourcen, Informationsmodelle, Datenanbieter und Verbraucher müssen interoperabel sein.

#### Architektur:

#### Architektur: Stufe 1

![](.gitbook/assets/1.PNG)

  


In dieser Architekturebene muss der Benutzer seinen Standard-Einkaufswagen in der App manuell eingeben. Mindesthaltbarkeitsdaten werden auch manuell aus verschiedenen Geschäften gesammelt und in einer Datenbank gespeichert.Die Komponente "Einkaufslistengenerator" ermittelt anhand dieser Daten, welches Produkt auf der Einkaufsliste stehen soll.

#### Architektur: Stufe 2

![](.gitbook/assets/2%20%281%29.PNG)

  


Diese Ebene zeigt ein Architekturbeispiel einer ergänzenden Anwendung. Sobald die Zahlung abgeschlossen ist, bietet der Smart Shop-Bereich  verbraucherspezifische Daten über gekaufte Produkte. Diese Daten werden über die Komponente "Einkaufslisten-Generator"  verwendet, um eine verbraucherspezifische Standard-Einkaufskarte und -Verbrauch zu erzeugen, was zur Optimierung der Einkaufslistengenerierung beiträgt.

#### Architektur: Stufe 3

![](.gitbook/assets/3%20%281%29.PNG)

  


Diese Ebene zeigt ein Architekturbeispiel einer übergreifenden Anwendung.Smart Home liefert die zusätzlichen Echtzeitverbrauchsdaten des Verbrauchers.Die beiden Bereiche Smart Home und Smart Shop liefern Eingabedaten zur Optimierung der Einkaufsliste.



  










 

  










  


  








 



