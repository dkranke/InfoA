package blatt02;

import AlgoTools.IO;

public class DezBin {

    public static void main(String[] args) {

        int k; // Eingabe: k >= 0

        do { // Solange wie k kleiner 0 ist
            // Lese eine Zahl ein und speichere sie in der Variable k.
            k = IO.readInt("Geben Sie eine Zahl ein, die größer-gleich 0 ist: ");
        } while (k < 0);

        do { // Solange wie k größer als 0 ist
            IO.print(k % 2); // Berechne den Modulo von k / 2 und gebe ihn aus
            k = k / 2; // Teile k durch 2 und speichere das Ergebnis in k
        } while (k > 0);

        IO.println(); // Gebe einen Zeilenumbruch aus
    }
}
