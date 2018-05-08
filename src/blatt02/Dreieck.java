package blatt02;

import AlgoTools.IO;

public class Dreieck {

    public static void main(String[] args) {
        int h;
        do { // Solange h < 2 oder h > 42
            h = IO.readInt("Höhe: "); // Lese eine Zahl ein und speichere sie in h
        } while (h < 2 || h > 42);

        for (int i = 1; i <= h; i++) { // Wiederhole h mal (von 1 bis h)
            for (int j = 1; j <= i; j++) { // Wiederhole i mal (von 1 bis i)
                IO.print("*"); // Gebe einen Stern aus
            }
            IO.println(); // Gebe einen Zeilenumbruch aus
        }
    }
}
