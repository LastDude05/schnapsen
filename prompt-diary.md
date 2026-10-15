# Prompt-Diary – Schnapsen

Jeder Eintrag enthält Datum, Werkzeug, den Prompt (wörtlich), das Ergebnis und meine eigene Bewertung. Neue Einträge kommen ans Ende.

---

## 0 · 2026-10-15 · Projektidee
- **Werkzeug:** Claude (claude.ai)
- **Prompt:** „Empfehle mir ein Semesterprojekt.“ (mit Screenshots der Kursvorgaben)
- **Ergebnis:** Vorschlag: Schnapsen als Konsolenspiel, mit Begründung und Feature-Liste. Alternativen: Textadventure, Sudoku.
- **Meine Bewertung:**

## 1 · 2026-10-15 · Projekt-Setup
- **Werkzeug:** Claude (claude.ai)
- **Prompt:** „Machen wir so: Ich werde mit Claude Code in IntelliJ Idea arbeiten. Sag mir was ich machen soll damit ich den Zwischenstand/Endergbnis für die Abgabe habe.“
- **Ergebnis:** Schritt-für-Schritt-Anleitung sowie Vorlagen für README.md, features.md, AGENTS.md und dieses Prompt-Diary.
- **Meine Bewertung:**

## 2 · 2026-10-15 · Feature 1: Kartendeck erzeugen und mischen
- **Werkzeug:** Claude Code
- **Prompt:** „Setze Feature 1 aus features.md um (Kartendeck erzeugen und mischen). Zeig mir zuerst einen kurzen Plan: welche Dateien, welcher Record, welche Methoden. Warte auf mein OK. Zum Testen soll Main das gemischte Deck einmal auf der Konsole ausgeben.“
- **Ergebnis:** Neu angelegt: `src/Card.java` (Record mit `label()`), `src/Deck.java` (erzeugt 20 Karten mit zwei verschachtelten Schleifen und mischt per Fisher-Yates) und `src/Main.java` (gibt das gemischte Deck nummeriert aus). Getestet durch zwei Programmläufe: jeweils 20 verschiedene Karten, zusammen 120 Punkte, und die Reihenfolge war bei beiden Läufen unterschiedlich.
- **Meine Bewertung:**

## 3 · 2026-10-15 · Diary und Commit nach jedem Auftrag
- **Werkzeug:** Claude Code
- **Prompt:** „Bite aktualisiere jedes mal prompt-diary.md und commit.“
- **Ergebnis:** Ab jetzt hängt Claude Code nach jedem Auftrag einen Eintrag an `prompt-diary.md` an und macht danach einen Commit. Die Änderungen aus Feature 1 und diese beiden Diary-Einträge wurden gemeinsam committet.
- **Meine Bewertung:**

## 4 · 2026-10-15 · Push nach jedem Auftrag
- **Werkzeug:** Claude Code
- **Prompt:** „push auch direkt jedes mal“
- **Ergebnis:** Ab jetzt pusht Claude Code nach jedem Auftrag direkt nach dem Commit auf `origin/master`. Der Commit zu Feature 1 und dieser Eintrag wurden gepusht.
- **Meine Bewertung:**

## 5 · 2026-10-15 · Feature 2: Austeilen
- **Werkzeug:** Claude Code
- **Prompt:** „Setze Feature 2 um: Spieler und Computer bekommen je 5 Karten, die nächste Karte wird als Trumpf aufgedeckt, der Rest bleibt als Talon. Gib zum Test die Hand des Spielers, die Trumpfkarte und die Anzahl der Talonkarten aus. Die Hand des Computers bleibt verdeckt.“
- **Ergebnis:** In `Deck.java` gibt es zwei neue Methoden: `drawCard()` zieht die oberste Karte, `revealTrump()` deckt sie auf und legt sie ganz nach unten. Die neue Datei `Game.java` enthält Talon, beide Hände (Arrays mit Zähler) und die Trumpfkarte und teilt in `deal()` aus. `Main.java` zeigt die Hand des Spielers, den Trumpf, die Talon-Größe (10) und die Kartenanzahl des Computers an. Getestet durch zwei Programmläufe und einen temporären Prüfcode mit 1000 Durchläufen: immer 20 verschiedene Karten, 120 Punkte, 10 Talonkarten, und die Trumpfkarte wird als letzte gezogen.
- **Meine Bewertung:**

## 6 · 2026-10-15 · Feature 3: Ausspielen
- **Werkzeug:** Claude Code
- **Prompt:** „Setze Feature 3 um: Zeig dem Spieler seine Hand nummeriert (1–5) und lass ihn per Zahl eine Karte ausspielen. Bei Buchstaben oder Zahlen außerhalb des Bereichs: Fehlermeldung und neu fragen. Die gespielte Karte verschwindet aus der Hand. Der Computer spielt vorerst einfach seine erste Karte. Die Stichauswertung (Feature 4) noch nicht bauen.“
- **Ergebnis:** In `Game.java` gibt es `playPlayerCard(index)` und `playComputerCard()`: Sie nehmen die Karte aus der Hand, und die Karten dahinter rücken nach vorne. `Main.java` hat jetzt `printHand()` und `readCardNumber()` mit Prüfung über `hasNextInt()` und wiederholter Abfrage. Getestet mit eingegebenen Werten: `abc`, `0`, `6`, `-2` und `2.5` führen zu einer Fehlermeldung und neuer Abfrage, gültige Zahlen 1, 3, 4 und 5 spielen die richtige Karte, danach hat die Hand 4 Karten. Ein temporärer Prüfcode bestätigte, dass auch beim Computer die erste Karte entfernt wird.
- **Meine Bewertung:**
