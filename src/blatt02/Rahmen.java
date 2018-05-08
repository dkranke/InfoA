package blatt02;

import AlgoTools.IO;

public class Rahmen {

    public static void main(String[] args) {
        int m, n;

        do { // Solange m < 3 oder m > 42
            // Lesen eine Zahl ein und speichere sie in m
            m = IO.readInt("Bitte eine Spaltenanzahl: ");
        } while (m < 3 || m > 42);

        do { // Solange n < 3 oder n > 42
            // Lesen ein Zahl ein und speichere sie in n
            n = IO.readInt("Bitte eine Zeilenanzahl: ");
        } while (n < 3 || n > 42);
        IO.println(); // Gebe einen Zeilenumbruch aus

        // Gebe den oberen Teil aus
        // Wiederhole so oft, wie der Rahmen breit sein soll
        for (int i = 0; i < m; i++) {
            IO.print("*"); // Gebe einen Stern aus
        }
        IO.println(); // Gebe einen Zeilenumbruch aus

        // Gebe den mittleren Teil aus
        // Wiederhole so oft, wie Höhe - 2
        for (int j = 1; j < n - 1; j++) {
            IO.print("*"); // Geben den ersten Stern in der Zeile aus
            // Gebe die Leerzeichen in der Mitte der Zeile aus
            // Wiederhole so oft wie Breite - 2
            for (int i = 1; i < m - 1; i++) {
                IO.print(" "); // Gebe ein Leerzeichen aus
            }
            IO.println("*"); // Gebe den letzten Stern aus und mache einen Zeilenumbruch
        }

        // Gebe den unteren Teil aus
        // Wiederhole so oft, wie der Rahmen breit sein soll
        for (int i = 0; i < m; i++) {
            IO.print("*"); // Gebe einen Stern aus
        }
        IO.println(); // Gebe einen Zeileumbruch aus
    }
}
