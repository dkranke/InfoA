package blatt05;

import AlgoTools.IO;

public class ISBN13 {

    public static void main(String[] args) {
        int zaehler;
        int pruefziffer = 0;
        int[] isbn = IO.readInts("Bitte ISBN mit Pruefziffer (einzelne Ziffern durch Leerzeichen trennen): ", 13);
        IO.println();

        // Prüfziffer berechnen
        for (zaehler = 0; zaehler < 12; zaehler = zaehler + 2) {
            int zahl1 = isbn[zaehler];
            int zahl3 = isbn[zaehler + 1] * 3;
            pruefziffer = pruefziffer + zahl1 + zahl3;
        }

        // Wir wollen nur die letzte Stelle der Prüfziffer behalten
        pruefziffer = pruefziffer % 10;

        // Und diese muss von 10 abgezogen werden
        pruefziffer = 10 - pruefziffer;

        // Stimmt die Prüfziffer mit der berechneten überein? Wenn ja, dann
        if (pruefziffer == isbn[12]) {
            IO.println("Die Pruefziffer der eingegebenen ISBN ist korrekt!");
        }
        // Sonst
        else {
            IO.println("Die Pruefziffer der eingegebenen ISBN-13 ist nicht korrekt!");
            IO.println();

            IO.print("Die korrekte ISBN-13 ist: ");
            for (zaehler = 0; zaehler < 12; zaehler++) {
                IO.print(isbn[zaehler] + " ");
            }
            IO.println(pruefziffer);
        }
    }
}
