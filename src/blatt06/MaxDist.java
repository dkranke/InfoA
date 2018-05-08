package blatt06;

import AlgoTools.IO;

public class MaxDist {

    public static void main(String[] args) {
        int[] eingabe;
        int min = 0;
        int max = 0;
        int abstand;

        do {
            eingabe = IO.readInts("Bitte einen Integer-Array: ");
        } while (eingabe.length == 0);

        for (int i = 1; i < eingabe.length; i++) {
            if (eingabe[i] > eingabe[max]) {
                max = i;
            }
            if (eingabe[i] < eingabe[min]) {
                min = i;
            }
        }
        IO.println("Elemente mit dem größten Abstand: " + eingabe[max] + " und " + eingabe[min]);
    }
}
