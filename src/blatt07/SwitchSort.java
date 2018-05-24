package blatt07;

import AlgoTools.IO;

public class SwitchSort {

    /**
     * Diese Operation gibt ein Integer-Array auf der Konsole aus.
     */
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            IO.print(" " + array[i]);
        }
        IO.println();
    }


    /**
     * Diese Operation liest ein Integer-Array und gibt dieses nur dann zurück,
     * wenn dieses mindestens die Länge 1 hat.
     */
    public static int[] readArray() {
        // Variablendeklaration
        int[] array;

        // Sicheres Einlesen des Arrays
        do {
            array = IO.readInts("Unsortiertes Array: ");
        } while (array.length == 0);
        return array;
    }


    /**
     * Die Hauptoperation von SwitchSort.
     * Hier erfolgt die Variablendeklaration des (un-)sortierten Arrays und
     * ansonsten nur die Operationsaufrufe.
     */
    public static void main(String[] args) {
        IO.println();

        // Variablendeklaration
        int[] array;

        // Einlesen des zu sortierenden Integer-Arrays
        array = readArray();

        // Ausgabe des ursprünglichen Arrays
        IO.print("Unsortiertes Array: ");
        printArray(array);


        // Hier wird die Operation sort() aufgerufen. Diese implementiert den
        // Switch-Sort-Algorithmus.
        sort(array);


        // Ausgabe des sortierten Arrays
        IO.print("Sortiertes Array: ");
        printArray(array);

        IO.println();
    }

    // O(n²) immer, egal wie die Sortierung ist
    public static int[] sort(int[] array) {
        int n = array.length;
        int i = n - 1;
        int j, m, temp;

        // Solange i > 0 ist
        while (i > 0) {
            // Zähle wieviele Elemente größer als Element i ist
            m = 0;
            for (j = 0; j < n; j++) {
                if (array[j] > array[i]) {
                    m++;
                }
            }

            // Tausche Elemente i und n-m
            temp = array[i];
            array[i] = array[n - m - 1];
            array[n - m - 1] = temp;

            // Wenn m == n - i  ist senke i
            if (m == n - i - 1) {
                i--;
            }
        }

        // Gebe den sortierten Array zurück
        return array;
    }
}
