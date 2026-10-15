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
