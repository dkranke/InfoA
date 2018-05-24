package blatt07;

import AlgoTools.IO;

/**
 * Diese Klasse führt die Verwendung von mehreren Operationen vor.
 * <p>
 * Es wird eine Schildkröte dargestellt und durch Kommandos vom Nutzer
 * gesteuert.
 * Sie hinterlässt eine Spur aus ASCII Zeichen ('#'), auf die sie nicht wieder
 * laufen kann.
 * <p>
 * Globale Variablen werden verwendet, um die Position und Richtung der
 * Schildkröte zu speichern.
 */
public class ASCIITurtle {

    // Die Größe der Welt
    static int rows = 30;
    static int columns = 40;

    // Die Welt
    static char[][] world;

    // Die Position und Richtung der Schildkröte
    static int posX;
    static int posY;
    static int deltaX;
    static int deltaY;

    // Dauer, die gewartet werden soll
    static int duration = 250;

    // TODO a)
    // Globale Variable die angibt ob der Stift unten oder oben ist
    static boolean isPenDown = true;
    // TODO b)
    // Globale Variable für v*
    static boolean repeat = false;

    /**
     * Diese Operation bereitet die Welt vor. Sie wird mit Leerzeichen gefüllt.
     * <p>
     * Der Parameter frame gibt an, ob ein Rahmen gezeichnet werden soll oder nicht.
     */
    public static void prepareWorld(boolean frame) {
        int row, column;

        // Fülle Welt mit Leerzeichen
        for (row = 0; row < world.length; row = row + 1) {
            for (column = 0; column < world[row].length; column = column + 1) {
                world[row][column] = ' ';
            }
        }

        // Falls kein Rahmen gezeichnet werden soll, ist man fertig.
        if (!frame) {
            return;
        }

        // Zeichne den Rahmen
        // Zeichne erste und letzte Spalte
        for (row = 0; row < rows; row = row + 1) {
            world[row][0] = '#';
            world[row][columns - 1] = '#';
        }

        // Zeichne erste und letzte Zeile
        for (column = 0; column < columns; column = column + 1) {
            world[0][column] = '#';
            world[rows - 1][column] = '#';
        }
    }

    /**
     * Diese Operation stellt die Welt dar. Es wird die Schildkröte an ihrer
     * aktuellen Position in der aktuellen Richtung gezeichnet.
     */
    public static void showWorld() {
        int row, column;

        // Löschen den Screen
        IO.clearScreen();

        // Stelle die Welt Zeichen für Zeichen dar.
        for (row = 0; row < world.length; row = row + 1) {
            for (column = 0; column < world[row].length; column = column + 1) {
                // Ist die Schildkröte an dieser Position?
                if ((row == posY) && (column == posX)) {
                    if ((deltaX == 0) && (deltaY == 1)) {
                        IO.print("v");
                    } else if ((deltaX == 0) && (deltaY == -1)) {
                        IO.print("^");
                    } else if ((deltaX == 1) && (deltaY == 0)) {
                        IO.print(">");
                    } else if ((deltaX == -1) && (deltaY == 0)) {
                        IO.print("<");
                    } else {
                        IO.print("?");
                    }
                } else {
                    IO.print(world[row][column]);
                }
            }
            IO.println();
        }
    }

    /**
     * Drehe die Schildkröte um 90 Grad nach rechts.
     */
    public static void turnRight() {
        int altX = deltaX;
        int altY = deltaY;

        deltaX = -altY;
        deltaY = altX;
    }

    /**
     * Drehe die Schildkröte um 90 Grad nach links.
     */
    public static void turnLeft() {
        int altX = deltaX;
        int altY = deltaY;

        deltaX = altY;
        deltaY = -altX;
    }

    /**
     * Lasse die Schildkröte einen Schritt in ihre aktuelle Richtung machen.
     * <p>
     * Dabei wird geprüft, ob das neue Feld betreten werden kann, also
     * ob dort ein '#' ist.
     */
    public static void go() {
        // TODO b)
        // Gehe einmal (v) oder solange bis eine Wand gefunden wurde (v*)
        do {
            // Berechne die neue Position
            int neuX = (posX + deltaX + columns) % columns;
            int neuY = (posY + deltaY + rows) % rows;

            // Gehe auf die neue Position wenn möglich
            if (world[neuY][neuX] != '#') {
                // TODO a)
                // Hinterlasse nur eine Spur wenn der Stift unten ist
                if (isPenDown) {
                    world[posY][posX] = '#';
                }
                posX = neuX;
                posY = neuY;
            }
            // TODO b)
            // Wenn einer Wand gefunden wurde höre auf
            else {
                repeat = false;
            }

            // Nach Musterlösung in Übung: Ausgabe nach jedem Zwischenschritt
            /* if (repeat) {
            // Zeige den neuen Zustand und warte
                showWorld();
                wait(duration);
            } */
        } while (repeat);
    }

    /**
     * Diese Operation führt eine Sequenz cmds von Kommandos aus.
     * Jedes Kommando ist ein Zeichen:
     * - 'v': Gehe vorwärts
     * - 'r': Drehe nach rechts
     * - 'l': Drehe nach links
     * <p>
     * Nach jedem Kommando wird die Welt neu ausgegeben und kurz gewartet.
     */
    public static void execute(String cmds) {
        int pos;
        char command;
        // TODO
        char argument;

        // Durchlaufe cmds zeichenweise
        for (pos = 0; pos < cmds.length(); pos = pos + 1) {
            command = cmds.charAt(pos);

            // TODO b)
            // Entweder wähle das nächste Zeichen in cmds als argument
            // oder wähle ein ungültiges Element
            if (pos < cmds.length() - 1) {
                argument = cmds.charAt(pos + 1);
            } else {
                argument = ' ';
            }

            // TODO c)
            // Wenn das argument eine Zahl ist
            if (argument >= '0' && argument <= '9') {
                // "Kopiere" die Zahl aus dem String cmds raus
                String numberOfExecutions = "";
                do {
                    numberOfExecutions += argument;
                    pos++;
                    if (pos < cmds.length() - 1) {
                        argument = cmds.charAt(pos + 1);
                    } else {
                        argument = ' ';
                    }
                } while (argument >= '0' && argument <= '9');

                // Führe moveSteps aus
                moveSteps(command, numberOfExecutions);
            }
            // Führe alle Kommandos aus
            else {
                switch (command) {
                    case 'l':
                        turnLeft();
                        break;
                    case 'r':
                        turnRight();
                        break;
                    case 'v':
                        // TODO b)
                        // Wenn ein Stern angegebenen wurde gehe bis zur nächsten Wand
                        if (argument == '*') {
                            pos++;
                            repeat = true;
                        }
                        go();
                        break;
                    // TODO a)
                    // Wenn das Kommando ein 'p' ist heben den Stift an, oder setze ihn ab (Invertierung)
                    case 'p':
                        isPenDown = !isPenDown;
                        break;
                }
            }

            // Zeige den neuen Zustand und warte
            showWorld();
            wait(duration);
        }
    }

    /**
     * Diese Operation lässt das Programm die angegebenen Zeit in Millisekunden
     * warten. Das ist in Java etwas umständlich.
     */
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    /**
     * Das Hauptprogramm stellt die Ausgangsbedingung her und lässt den Nutzer
     * anschließend Sequenzen von Kommandos eingeben, die ausgeführt werden.
     * <p>
     * Gibt der Nutzer ein einzelnes 'E' ein, wird das Programm beendet.
     */
    public static void main(String[] args) {
        String cmd;

        // Lege das Array an
        world = new char[rows][columns];

        // Bereite die Ausgangssituation vor
        // Rahmen -> true / kein Rahmen -> false
        prepareWorld(true);
        posX = columns / 2;
        posY = rows / 2;
        deltaX = 0;
        deltaY = -1;

        // Frage den Nutzer nach Kommandos
        do {
            showWorld();
            cmd = IO.readString("Kommandos [vlr] oder Ende [e]: ");
            execute(cmd);
        } while (!cmd.equals("e"));
    }

    // TODO c)
    public static void moveSteps(char command, String numberOfExecutions) {
        // moveSteps nur weiter ausführen, wenn comannd Entweder l, v oder r ist
        if (command == 'l' || command == 'v' || command == 'r') {

            // Konvertiere den Zahlen-String in eine Zahl (nach StringToInt.java von Blatt 3)
            int zahl = 0;
            for (int i = 0; i < numberOfExecutions.length(); i++) {
                zahl = zahl * 10 + numberOfExecutions.charAt(i) - '0';
            }

            // Optimierung für l & r (4 mal drehen ist wieder gradeaus)
            /* if (command == 'l' || command == 'r') {
                zahl = zahl % 4;
            } */

            // Wiederhole das Kommando x mal, indem das Kommando alleine von der execute-Methode ausgeführt wird
            // (Einfacher und lesbarer als die Execute-Methode wie bei der goStar-Methode einfach rein zu kopieren)
            for (int i = 1; i <= zahl; i++) {
                execute(command + "");
            }
        }
    }
}
