package blatt04;

import AlgoTools.IO;

public class MaximumSuche {

    public static void main(String[] args) {


        int i;
        int[] eingabe;
        int max = 0;
        int max2 = 0;
        int h;
        int zahl1 = 0;
        int zahl2 = 0;

        do {
            eingabe = IO.readInts("Bitte ein Integer-Array: ");
        } while (eingabe.length < 2);


        //von vorne nach hinten durch Array
        //zahl als max speichern
        //schauen, ob nächste zahl größer ist als bisheriges max, wenn ja, max überschreiben

        for (i = 0; i < eingabe.length; i++) {
            if (eingabe[i] > zahl1) {
                zahl1 = eingabe[i];
                max = i;
            }

        }

        IO.println("Das Maximum ist " + zahl1 + " an der Stelle " + max);


        //Zweitgroesste zahl finden
        //mit bisherigen max vergleichen, wenn größte zahl, aber kleiner zahl1, dann Zweitgroesste

        for (h = 0; h < eingabe.length; h++) {
            if ((eingabe[h] > zahl2) && (eingabe[h] < zahl1)) {
                zahl2 = eingabe[h];
                max2 = h;
            }
        }


        IO.println("Der Zweitgroesste Wert ist " + zahl2 + " an der Stelle " + max2);


    }

}
