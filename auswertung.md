# Simulation und Auswertung

## Definitionen

Im folgenden werden die in der Simulation verwendeten Hilfsmittel und Bausteine dargestellt, um die Aussagekraft der Simulation und derer Ergebnisse zu veranschaulichen. Die folgenden Definitionen sind Teil der durchgeführten Simulation und bieten die Grundlage zum Verständnis der nachfolgenden Simulationsdokumentation.

### Bewertungskriterien

Bevor wir mit der Simulation begannen, definierten wir zuerst die der Simulation zu Grunde gelegten Bewertungskriterien. Bewertet werden soll allgemein gesagt die Nützlichkeit der vorgestellten Applikationen im Bezug auf den Einkaufsprozess.  
Da unsere Applikation\(en\) den Einkaufsprozess anhand einer digitalen Einkaufsliste verbessern, liegt der Fokus auf der Korrektheit der automatisch generierten Einkaufsliste. D.h. uns interessiert das sogenannte Delta zwischen der automatisch generierten Einkaufsliste \(Ist-Liste\) und der optimales Einkaufliste \(Soll-Liste\) um die Korrektheit der Liste überhaupt bewerten zu können.  
Um die Korrektheit zwischen den zwei Listen einheitlich zu messen, haben wir folgende Metriken festgelegt:

* Anzahl der Produkte auf Soll-Liste, die auf der Ist-Liste fehlen
* Anzahl der Produkte auf Ist-Liste, die nicht auf Soll-Liste stehen

### Persona

Entspricht in diesem Zusammenhang bestimmten Konsum- & Verbrauchsdaten über eine bestimmte Person oder einen Personenkreis. Eine Persona definiert sich dabei durch eine Menge von Produkten die regelmäßig \(oder auch unregelmäßig\) gekauft werden, mit zusätzlicher Angabe des durchschnittlichen Verbrauchs in Form von Intervallen. Zusätzlich zu den Verbrauchs-/Bedarfsinformationen wird eine Einkaufshäufigkeit in Form eines Intervalls angegeben. D.h. zusammengefasst ist für bestimmte Produkte deren Bedarfshäufigkeit in einer Persona definiert, sowie auch dessen allgemeint Einkaufshäufigkeit \(in gleicher Form\).

Die folgende Tabelle veranschaulicht dies am Beispiel einer Sportler-Persona:

| Produkt | Bedarfshäufigkeit \(Sportler\) |
| :--- | :---: |
| Butter | 25 - 30 Tage |
| Milch |  7 - 14 Tage |
| Käse | 10 - 15 Tage |
| Salami |  7 - 10 Tage |

| Einkaufshäufigkeit \(Sportler\) | 7 - 14 Tage |
| :--- | :--- |


### Smart Integration Matrix

Die Smart Integration Matrix zeigt die in unserem Szenario möglichen Varianten wie eine Einkaufsliste befüllt werden kann. Dabei sind für die drei definierten Möglichkeiten \('Manuell', 'Smart Home' & 'Smart Shop'\) jeweils Qualitätsstufen angegeben, welche das Maß der Qualität der Nutzung der drei Verwaltungsmöglichkeiten darstellt.   
Diese Qualitätsstufen können Werte zwischen 0 und 3 annehmen, wobei eine '0' bedeute, dass diese Komponente nicht verwendet wird und eine '3' einer sehr sorgfältigen Verwendung entspricht.

Die Tabelle der möglichen Werte ist im Folgenden dargestellt: 

|  | **App** |    | **Smart Home** | **Smart Shop** | **Qapp** | **Qhome** | **Qshop** |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| Mögliche Werte: | 0 / 1 |    | 0 / 1 | 0 / 1 | 0 / 1 / 2 / 3 | 0 / 1 / 2 / 3 | 0 / 1 / 2 / 3 |

Die möglichen Werte \(0 / 1\) in Spalte App, Smart Home und Smart Shop geben an, ob die Komponente verwendet wird. Die in Spalten Qapp, Qhome & Qshop angegebenen Qualitätsmaße geben an, wie gut eine bestimmte Komponente verwendet wird. Die Quaitätsstufen sind bestimmten Aufnahme-Wahrscheinlichkeiten zugeordnet. Diese Aufnahme-Wahrscheinlichkeit gibt an, mit welcher Wahrscheinlichkeit ein Produkt zum Zeitpunkt des Verbrauchs oder des Ablaufs durch die entsprechende Komponente vom Nutzer in die Einkaufliste aufgenommen wird.  
Dieser Zuordnung ist in folgender Tabelle dargestellt:

| Qualitätsstufe | Beschreibung | Aufnahme-Wahrscheinlichkeit |
| :--- | :--- | :--- |
| 0 | keine Verwendung | 0% |
| 1 | gelegentliche Verwendung | 33% |
| 2 | mittelmäßige Verwendung | 66% |
| 3 | sorgfältige Verwendung | 99% |

In der Simulation verwenden wir diese Matrix, um verschiedenste Verhaltensweisen bezüglich der Pflege des Einkaufszettels der Nutzer nachstellen zu können. Anhand der Simulation kann anschließend der Nutzen unserer Anwendungen für die verschiedensten Verhaltensweisen gemessen werden. Auf Basis dieser Simulation können zudem geeignete Nutzungsstrategien der vorhandenen Technologien empfohlen werden, um die Präzision des Zettels zu verschärfen.

## Simulationsaufbau

## Simulationsergebnisse



