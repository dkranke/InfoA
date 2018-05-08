package blatt04;

import AlgoTools.IO;

public class Rule90 {

    public static void main(String[] args) {

        int[] eingabe;
        int zeitschritte;
        int i;


        do {
            eingabe = IO.readInts("Initiales System eingeben: ");
        } while (eingabe.length == 0);

        do {
            zeitschritte = IO.readInt("Anzahl Zeitschritte eingeben: ");
        } while (zeitschritte < 0);

        //eingabe in boolean Array umwandeln
        boolean[] zellen = new boolean[eingabe.length];
        for (i = 0; i < eingabe.length; i++) {
            zellen[i] = eingabe[i] > 0;//warum das mit der 0?
        }

        IO.println();

        //erste zeile
        for (i = 0; i < eingabe.length; i++) {
            if (zellen[i]) {//true
                IO.print('@'); //1 = lebendig
            } else {//false
                IO.print('.'); //0 = tot
            }
        }

        IO.println();

        for (int j = 0; j < zeitschritte; j++) {//damit so oft durch wie zeitschritte eingegeben
            boolean[] neue_zeile = new boolean[eingabe.length];//für jede zeile neuer Array

            for (int k = 0; k < neue_zeile.length; k++) {//für den block hatte ich Hilfe
                boolean links = zellen[(k - 1 + eingabe.length) % eingabe.length];//man muss es wie ein kreis sehen
                boolean rechts = zellen[(k + 1 + eingabe.length) % eingabe.length];
                neue_zeile[k] = links ^ rechts; // nur wenn eine Nachbarzelle am leben ist wird die aktuelle lebendig

            }

            zellen = neue_zeile;//array zellen überschreiben mit array neue_zeile

            for (i = 0; i < eingabe.length; i++) {
                if (zellen[i]) {
                    IO.print("@");
                } else {
                    IO.print(".");
                }
            }
            IO.println(); //damit zeitschritte untereinander
        }


    }

}
