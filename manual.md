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
   - die Kartenanzahl des **Computers** (seine Karten bleiben verdeckt),
   - **deine Hand**, nummeriert von 1 bis 5. Hinter jeder Karte steht ihr Punktewert in Klammern.
3. Du wirst gefragt: `Welche Karte spielst du? (1-5):`
   Tippe die Nummer der Karte ein und drück **Enter**.
4. Das Programm zeigt deine Karte und die Karte des Computers. Danach siehst du deine restliche Hand (4 Karten).

Im Moment wird nur ein einzelner Zug gespielt. Danach endet das Programm. Stichauswertung, Punkte und Nachziehen folgen in späteren Features (siehe `features.md`).

## Beispiel

```
Trumpf: Schelle Ober (3)
Talon: 10 Karten (inklusive Trumpfkarte)
Computer: 5 Karten (verdeckt)

Deine Hand:
1. Eichel Unter (2)
2. Laub Unter (2)
3. Schelle Unter (2)
4. Schelle König (4)
5. Laub Ass (11)
Welche Karte spielst du? (1-5): 2
Du spielst: Laub Unter (2)
Computer spielt: Eichel Ass (11)
```

## Falsche Eingaben

- Buchstaben oder Kommazahlen (z. B. `abc`, `2.5`): `Ungültige Eingabe. Bitte eine Zahl eingeben.`
- Zahlen außerhalb des Bereichs (z. B. `0` oder `6`): `Ungültige Zahl. Bitte eine Zahl von 1 bis 5 eingeben.`

In beiden Fällen wirst du einfach noch einmal gefragt.

## Kartenwerte

| Karte | Punkte |
|-------|--------|
| Ass   | 11     |
| Zehn  | 10     |
| König | 4      |
| Ober  | 3      |
| Unter | 2      |
