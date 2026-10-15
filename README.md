# Schnapsen – Konsolenspiel in Java

**Autor:** Erol Bilyalov

## Worum es geht

Schnapsen ist ein österreichisches Kartenspiel für zwei Personen mit 20 Karten. In diesem Projekt spielt man in der Konsole gegen den Computer. Ziel eines Spiels ist es, als Erster 66 Punkte zu erreichen, durch gewonnene Stiche und Ansagen (20er und 40er).

## Technische Rahmenbedingungen

- Java (JDK 21 oder neuer), reine Konsolenanwendung
- Strukturierte Programmierung mit Records und einfachen Klassen: keine Vererbung, keine Abstraktionen, keine Collections (Details in `AGENTS.md`)
- Entwickelt mit IntelliJ IDEA und Claude Code (agentisches Programmieren)

## Starten

In IntelliJ IDEA: `src/Main.java` öffnen und auf den grünen Run-Button klicken.

Oder im Terminal im Projektordner:

```
javac -d out src/*.java
java -cp out Main
```

## Projektdateien

- `features.md`: nummerierte Feature-Liste mit Umsetzungsstand
- `AGENTS.md`: Anweisungen für den KI-Agenten
- `prompt-diary.md`: Tagebuch der verwendeten Prompts mit eigener Bewertung

## Aktueller Stand

Siehe `features.md`.
