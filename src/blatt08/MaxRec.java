package blatt08;

import AlgoTools.IO;

public class MaxRec {

    public static void main(String[] args) {
        // Array einlesen (Es macht nur Sinn ein maximum zu suchen, wenn es mindestens 2 Elemente gibt)
        int[] array;
        do {
            array = IO.readInts("Bitte einen Array eingeben: ");
        } while (array.length < 2);
        IO.println();

        // Suche das Maximum und gebe es aus
        int max = max(array, 0);
        IO.println("Gefundenes Maximum: " + max);
    }

    // Sucht das Maximum aus einem Array
    // Rekursive Maximum-Suche
    public static int max(int[] array, int start) {
        // Gibt es nach dem start-Index noch weitere Elemente?
        // Wenn ja: Finde das Maximum zwischen der nächsten Elemente und den aktuellen
        if (start < array.length - 1) {
            int max = max(array, start + 1);
            return array[start] < max ? max : array[start];
        }
        // Wenn nein, gebe das aktuelle Element als maximum zurück
        else {
            return array[start];
        }
    }
}
