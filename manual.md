# Bedienungsanleitung – Schnapsen

## Starten

**In IntelliJ IDEA:** `src/Main.java` öffnen und auf den grünen Run-Button neben `main` klicken. Die Ein- und Ausgabe läuft im Run-Fenster unten.

**Im Terminal** (im Projektordner):

```
javac -d out src/*.java
java -cp out Main
```

Voraussetzung: Java (JDK 21 oder neuer).

## Ablauf (aktueller Stand)

1. Das Programm mischt die 20 Karten und teilt aus. Du und der Computer bekommt je 5 Karten.
2. Angezeigt werden:
   - die **Trumpfkarte** (sie bestimmt die Trumpffarbe),
   - die Anzahl der Karten im **Talon** (10, inklusive Trumpfkarte),
   - die Kartenanzahl des **Computers** (seine Karten bleiben verdeckt).
3. Danach wird Stich für Stich gespielt. Du spielst beim ersten Stich aus.
   - **Du bist am Ausspielen:** Du siehst deine Hand, nummeriert ab 1. Hinter jeder Karte steht ihr Punktewert in Klammern. Bei `Welche Karte spielst du?` tippst du die Nummer ein und drückst **Enter**. Danach legt der Computer seine Karte.
   - **Der Computer ist am Ausspielen:** Zuerst siehst du seine Karte (`Computer spielt aus: ...`), danach wählst du deine Antwortkarte.
4. Nach jedem Stich zeigt das Programm, wer ihn gewinnt und wie viele Punkte er bringt, danach den **Punktestand**.
   - Die ausgespielte Karte gewinnt, außer die Antwortkarte hat dieselbe Farbe und einen höheren Rang, oder sie ist Trumpf und die ausgespielte Karte nicht.
   - Wer den Stich gewinnt, bekommt die Punkte beider Karten und spielt als Nächstes aus.
5. Das Spiel endet, sobald eine Seite **66 Punkte** hat. Diese Seite gewinnt. Hat niemand 66 Punkte, wenn alle Karten gespielt sind, gewinnt, wer den **letzten Stich** gemacht hat.

Im Moment wird noch nicht vom Talon nachgezogen. Ein Spiel hat deshalb 5 Stiche. Nachziehen, Ansagen, Zudrehen und ein klügerer Computergegner folgen in späteren Features (siehe `features.md`).

## Beispiel

Die Zahlen hinter `Welche Karte spielst du?` sind deine Eingaben.

```
Trumpf: Herz König (4)
Talon: 10 Karten (inklusive Trumpfkarte)
Computer: 5 Karten (verdeckt)

Deine Hand:
1. Schelle Unter (2)
2. Herz Ass (11)
3. Laub Unter (2)
4. Schelle Ober (3)
5. Herz Ober (3)
Welche Karte spielst du? (1-5): 1
Du spielst: Schelle Unter (2)
Computer spielt: Schelle Ass (11)
Der Computer gewinnt den Stich (13 Punkte).
Punktestand: Du 0 – Computer 13

Computer spielt aus: Herz Unter (2)
Deine Hand:
1. Herz Ass (11)
2. Laub Unter (2)
3. Schelle Ober (3)
4. Herz Ober (3)
Welche Karte spielst du? (1-4): 1
Du spielst: Herz Ass (11)
Du gewinnst den Stich (13 Punkte).
Punktestand: Du 13 – Computer 13

...

Deine Hand:
1. Herz Ober (3)
Welche Karte spielst du? (1-1): 1
Du spielst: Herz Ober (3)
Computer spielt: Eichel Ass (11)
Du gewinnst den Stich (14 Punkte).
Punktestand: Du 46 – Computer 13

Spielende!
Niemand hat 66 Punkte erreicht, deshalb gewinnt, wer den letzten Stich gemacht hat.
Du gewinnst das Spiel mit 46 Punkten.
```

Im ersten Stich gewinnt der Computer, weil sein Schelle Ass höher ist als dein Schelle Unter. Im zweiten Stich gewinnst du, weil dein Herz Ass (Trumpf) höher ist als sein Herz Unter.

## Falsche Eingaben

- Buchstaben oder Kommazahlen (z. B. `abc`, `2.5`): `Ungültige Eingabe. Bitte eine Zahl eingeben.`
- Zahlen außerhalb des Bereichs (z. B. `0` oder `6`): `Ungültige Zahl. Bitte eine Zahl von 1 bis 5 eingeben.` (die obere Grenze ist die Anzahl deiner Karten)

In beiden Fällen wirst du einfach noch einmal gefragt.

## Kartenwerte

| Karte | Punkte |
|-------|--------|
| Ass   | 11     |
| Zehn  | 10     |
| König | 4      |
| Ober  | 3      |
| Unter | 2      |
