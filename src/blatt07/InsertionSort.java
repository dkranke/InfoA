package blatt07;

import AlgoTools.IO;

public class InsertionSort {

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
     * Die Hauptoperation von InsertionSort.
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


        // Hier wird die Operation sort() aufgerufen. Diese soll den
        // Insertion-Sort-Algorithmus implementieren.
        sort(array);


        // Ausgabe des sortierten Arrays
        IO.print("Sortiertes Array: ");
        printArray(array);

        IO.println();
    }

    // O(n²), da er im Worst-Case alle mit allen Vergleichen muss
    // Im Best-Case O(n)
    public static int[] sort(int[] array) {
        int i, j, temp;
        // Für jedes Element im Array
        for (i = 1; i < array.length; i++) {
            // Speichere den Wert ab
            temp = array[i];
            j = i;
            // Falls der Wert kleiner ist als das Element j-1 verschiebe dessen Wert
            while (j > 0 && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            // Wenn kein größeres Element mehr gefunden werden kann, füge das Element dort ein
            array[j] = temp;
        }

        // Gebe den sortierten Array wieder zurück
        return array;
    }
}
