import AlgoTools.IO;

public class QuickSort {

    // Methode zum Partitionieren eines Arrays, innerhalb bestimmter Grenzen
    public static int partition(int array[], int links, int rechts) {
        // Benötigte Variablen deklarieren und initialisieren
        int pivot, i, j, temp;
        pivot = array[rechts];
        i = links;
        j = rechts - 1;
        // Solange wie die linke Grenze kleiner-gleich die rechte Grenze ist (Überlaufschutz)
        while (i <= j) {
            // Wenn das Element am Index i größer als das Pivot-Element ist, verschiebe es auf die linke Seite
            if (array[i] > pivot) {
                // Tausche die Werte auf der linken und rechten Grenze
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;

                // Verschiebe die rechte Grenze
                j--;
            }
            // Verschiebe die linke Grenze
            else {
                i++;
            }
        }

        // Packe das fertig sortierte Element in außerhalb des noch zu sortierenden Bereiches
        temp = array[i];
        array[i] = array[rechts];
        array[rechts] = temp;

        // Gebe das Pivot-Element zurück
        return i;
    }

    // Methode die aufgerufen wird um sortRecursive mit Initialwerten zu starten
    public static void sort(int array[]) {
        // Sortiere den Array
        sortRecursive(array, 0, array.length);
    }

    public static void sortRecursive(int array[], int links, int rechts) {
        // Rekursionsanfang: Wenn links >= rechts
        if (links < rechts) {
            // Partitioniere den Array innerhalb der Grenzen und sortiere beide Seiten
            int i = partition(array, links, rechts - 1);
            sortRecursive(array, links, i - 1);
            sortRecursive(array, i + 1, rechts - 1);
        }
    }

    public static void main(String[] args) {
        // Einen int-Array einlesen
        int[] array;
        do {
            array = IO.readInts("Bitte einen int-Array eingeben: ");
        } while (array.length < 2);

        // Den Array aufsteigend sortieren
        sort(array);

        // Den sortieren Array ausgeben (kompatibel mit 'alten' AlgoTools)
        IO.print("Ergebnis: ");
        for (int i = 0; i < array.length; i++)
            IO.print(array[i] + " ");
        IO.println();
    }
}
