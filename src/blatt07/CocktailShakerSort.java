package blatt07;

import AlgoTools.IO;

public class CocktailShakerSort {

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
     * Diese Operation sortiert ein Integer-Array
     * mithilfe des CocktailShaker-Sort-Algorithmus
     */
    public static void sort(int[] array) {
        //Variablendeklaration
        boolean vor = true;
        int i = 0, fertigSortiert = 0, temp;

        while (fertigSortiert < array.length) {
            if (vor) { //Tauscht immer wenn das nachfolgende Element kleiner ist: trägt so das größte Element an den Rand
                while (i < array.length - 1 - (fertigSortiert + 1) / 2) {
                    if (array[i] > array[i + 1]) {
                        temp = array[i];
                        array[i] = array[i + 1];
                        array[i + 1] = temp;
                    }
                    i++;
                }
            } else { //Analog
                while (i > fertigSortiert / 2) {
                    if (array[i] < array[i - 1]) {
                        temp = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = temp;
                    }
                    i--;
                }
            }
            fertigSortiert++;
            vor = !vor;
        }
    }


    /**
     * Die Hauptoperation von CocktailShakerSort.
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
        // CocktailShaker-Sort-Algorithmus implementieren.
        sort(array);


        // Ausgabe des sortierten Arrays
        IO.print("Sortiertes Array: ");
        printArray(array);

        IO.println();
    }
}
