# AGENTS.md – Anweisungen für KI-Coding-Agenten

## Projekt

Schnapsen (österreichisches Kartenspiel, 2 Personen, 20 Karten) als Java-Konsolenanwendung: Mensch gegen Computer.
Es ist ein Semesterprojekt in einem Programmierkurs. Ich (Student) muss den Code verstehen und erklären können, deshalb geht Lesbarkeit vor Eleganz.

- Feature-Liste mit Status: `features.md`
- Projektbeschreibung: `README.md`
- Prompt-Tagebuch: `prompt-diary.md`

## Erlaubte Sprachmittel (Kursvorgabe, verbindlich)

Die Vorgabe des Kurses lautet: "The project should use structured programming in Java including records or simple classes. No abstractions, inheritance, Collections or other higher level Java features may be used."

Erlaubt:
- primitive Typen, `String`, `static final`-Konstanten
- `if`/`else`, `switch`, `while`, `do-while`, `for`, for-each über Arrays
- Arrays mit fester Größe plus Zähler (z. B. `Card[] hand` und `int handSize`)
- `record`s für Daten, z. B. `record Card(String suit, String rank, int points)`
- einfache Klassen mit Feldern und Methoden (auch `static`)
- `java.util.Scanner` für Eingaben, `java.util.Random` für Zufall
- `System.out.println` und `System.out.printf`

Verboten:
- `List`, `ArrayList`, `Map`, `HashMap`, `Set`, `Collections` (auch nicht `Collections.shuffle`), `List.of`, `Arrays.asList`
- Hilfsmethoden aus `java.util.Arrays` (Sortieren, Suchen usw. mit eigenen Schleifen lösen)
- `extends`, `implements`, `interface`, `abstract`, `sealed`
- Generics, Lambdas, Streams, Methodenreferenzen, `Optional`
- `enum` (stattdessen `String`-Konstanten)
- `var`
- `try`/`catch` für Programmlogik (Zahleneingaben mit `scanner.hasNextInt()` prüfen)
- externe Bibliotheken

Wenn ein verbotenes Sprachmittel nötig scheint: Stopp. Erklär mir das Problem und schlag eine Lösung mit erlaubten Mitteln vor.

## Code-Struktur

- Quellcode liegt in `src/`, im Default-Package (kein `package`-Statement).
- Einstiegspunkt ist `src/Main.java` mit klassischem `public static void main(String[] args)`. Keine Kurzform `void main()` und kein `IO.println`.
- Wenige, klar benannte Dateien, z. B. `Card.java` (record), `Deck.java`, `Game.java`, `Main.java`. Eine neue Datei nur, wenn sie eine eigene klare Aufgabe hat.
- Bezeichner auf Englisch, Konsolentexte auf Deutsch.
- Kommentare nur dort, wo die Logik nicht offensichtlich ist (z. B. Stichauswertung).

## Kompilieren und testen

- Kompilieren: `javac -d out src/*.java`
- Ausführen: `java -cp out Main`
- Mit vorgegebener Eingabe testen (Bash): `printf "1\n2\n" | java -cp out Main`
- Nach jeder Änderung kompilieren und das betroffene Feature mindestens einmal durchspielen. Sag mir am Ende, was du getestet hast und mit welchem Ergebnis.

## Arbeitsweise

- Pro Auftrag genau ein Feature aus `features.md`. Nichts vorwegnehmen, keine Extras, keine "Verbesserungen" an Code, der nicht zum Auftrag gehört.
- Bei größeren Features zuerst einen kurzen Plan zeigen (Dateien, Methoden, Ablauf) und auf mein OK warten.
- Wenn eine Spielregel unklar ist oder es Varianten gibt: frag mich, statt zu raten.
- Nach Abschluss eines Features:
  1. In `features.md` den Status des Features auf `[x]` setzen.
  2. Einen Eintrag ans Ende von `prompt-diary.md` anhängen (Format unten).
- Kein `git commit`, kein `git push` und kein Löschen von Dateien. Das mache ich selbst.

## Format für prompt-diary.md

Nach jedem Auftrag diesen Block ans Ende von `prompt-diary.md` anhängen. Den Prompt wörtlich übernehmen. Die Zeile "Meine Bewertung" leer lassen, die fülle ich selbst aus.

```markdown
## <laufende Nr.> · <JJJJ-MM-TT> · <kurzer Titel>
- **Werkzeug:** Claude Code
- **Prompt:** „<Prompt wörtlich>“
- **Ergebnis:** <1–3 Sätze: was wurde geändert, welche Dateien, wie getestet>
- **Meine Bewertung:**
```

## Spielregeln Schnapsen (Grundlage für die Umsetzung)

Karten und Werte:
- 20 Karten in 4 Farben: Herz, Schelle, Eichel, Laub.
- Je Farbe: Ass (11), Zehn (10), König (4), Ober (3), Unter (2). Summe aller Karten: 120 Punkte.
- Rangfolge innerhalb einer Farbe: Ass > Zehn > König > Ober > Unter.

Geben:
- Spieler und Computer bekommen je 5 Karten.
- Die nächste Karte wird aufgedeckt und bestimmt die Trumpffarbe. Sie liegt offen unter dem Talon und wird als letzte Karte gezogen.
- Der Talon hat zu Beginn 10 Karten (inklusive der offenen Trumpfkarte).

Stich:
- Die ausgespielte Karte gewinnt, außer die Antwortkarte hat dieselbe Farbe und einen höheren Rang, oder die Antwortkarte ist Trumpf und die ausgespielte Karte nicht.
- Der Stichgewinner bekommt die Punkte beider Karten, zieht zuerst eine Karte vom Talon, danach der andere. Der Stichgewinner spielt als Nächstes aus.
- Solange der Talon offen ist, gibt es keinen Farb- oder Stichzwang.
- Ist der Talon leer oder zugedreht, gilt Farbzwang (Farbe bedienen) und Stichzwang (wenn möglich höher bedienen; kann man nicht bedienen, muss man wenn möglich mit Trumpf stechen).

Ansagen:
- Wer am Ausspielen ist und König und Ober einer Farbe hält, kann ansagen: 20 Punkte, in der Trumpffarbe 40 Punkte. Eine der beiden Karten muss sofort ausgespielt werden.
- Angesagte Punkte zählen erst, sobald die Seite mindestens einen Stich hat.

Spielende:
- Ein Spiel endet, sobald eine Seite 66 oder mehr Punkte hat. Diese Seite gewinnt.
- Erreicht niemand 66, gewinnt die Seite mit dem letzten Stich.
- Spielpunkte für den Sieger: 1 (Gegner hat mindestens 33 Punkte), 2 (Gegner unter 33, "Schneider"), 3 (Gegner hat keinen Stich, "Schwarz").
- Eine Partie ("Bummerl") gewinnt, wer zuerst 7 Spielpunkte hat.

Austausch des Trumpf-Unters und Zudrehen: Diese Regeln haben Varianten. Details (z. B. ab wie vielen Karten im Talon erlaubt) vor der Umsetzung mit mir klären.
