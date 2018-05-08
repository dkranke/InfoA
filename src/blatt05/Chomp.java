package blatt05;

import AlgoTools.IO;

// 5.5
public class Chomp {

    public static void main(String[] args) {
        // 5.5.1
        int m; // Spalten
        int n; // Zeilen
        char[][] spielfeld;
        int y, x;
        // 5.5.3
        char spieler = 'A';

        // 5.5.1
        // Eingaben einlesen
        do {
            m = IO.readInt("Spaltenanzahl > 5: ");
        } while (m < 6);

        do {
            n = IO.readInt("Zeilenanzahl > 2: ");
        } while (n < 3);
        IO.println();

        // Spielfeld erstellen und mit Startwerten füllen
        spielfeld = new char[n][m];
        for (y = 0; y < n; y++) {
            for (x = 0; x < m; x++) {
                spielfeld[y][x] = '.';
            }
        }

        // 5.5.2
        // Hauptschleife
        do {
            // Gebe das Spielfeld aus
            // Gebe die oberste Zeile aus
            IO.print("      ");
            for (x = 0; x < m; x++) {
                IO.print(x, 3);
            }
            IO.println();

            // Gebe die zweite Zeile aus
            IO.print("    +-");
            for (x = 0; x < m; x++) {
                IO.print("---");
            }
            IO.println();

            // Gebe das Spielfeld aus
            for (y = 0; y < n; y++) {
                IO.println("    |");

                IO.print(y, 3);
                IO.print(" | ");
                for (x = 0; x < m; x++) {
                    IO.print(spielfeld[y][x], 3);
                }
                IO.println();
            }
            IO.println();
            IO.println();

            // 5.5.3
            // Eingabe
            do {
                do {
                    x = IO.readInt("Spieler " + spieler + ", waehle eine Spalte (0-" + (m - 1) + "): ");
                } while (x < 0 || x > m - 1);

                do {
                    y = IO.readInt("Spieler " + spieler + ", waehle eine Zeile (0-" + (n - 1) + "): ");
                } while (y < 0 || y > n - 1);
                IO.println();

                if (spielfeld[y][x] != '.') {
                    IO.println("Fehler! Zelle bereits belegt, bitte waehle eine leere Zelle.");
                    IO.println();
                }
            } while (spielfeld[y][x] != '.');

            // Berechne das neue Spielfeld
            for (int i = y; i < n; i++) {
                for (int j = x; j < m; j++) {
                    if (spielfeld[i][j] == '.') {
                        spielfeld[i][j] = spieler;
                    }
                }
            }

            // Wechsle den Spieler
            if (spieler == 'A') {
                spieler = 'B';
            } else {
                spieler = 'A';
            }
        } while (spielfeld[0][0] == '.');

        IO.println("SPIELER " + spieler + " HAT GEWONNEN!");
    }
}
