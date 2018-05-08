package blatt06;

import AlgoTools.IO;

public class Unique {

    public static void main(String[] args) {
        int[] eingabe;
        boolean unique = true;

        do {
            eingabe = IO.readInts("Bitte ein Integer-Array");
        } while (eingabe.length == 0);

        for (int i = 0; i < eingabe.length && unique; i++) {
            for (int j = i + 1; j < eingabe.length && unique; j++) {
                if (eingabe[i] == eingabe[j]) {
                    unique = false;
                }
            }
        }

        if (unique) {
            IO.println("Alle Elemente kommen nur einmal vor!");
        } else {
            IO.println("Es kommen einige Elemente doppelt vor!");
        }
    }
}
