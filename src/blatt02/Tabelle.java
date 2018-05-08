package blatt02;

import AlgoTools.IO;

public class Tabelle {

    public static void main(String[] args) {

        int k;
        //kein unerlaubter wert
        do {
            //wert einlesen lassen
            k = IO.readInt("gegebener Wert: ");
        } while (k < 1);

        IO.println();

        //Ueberschrift ausgeben lassen
        IO.print("     |");
        for (int zaehler = 1; zaehler <= k; zaehler++) {
            //rechtsbuendig zahl ausgeben
            IO.print(zaehler, 4);
        }
        IO.println();

        //Rahmen ausgeben
        IO.print("----+");
        for (int zaehler = 1; zaehler <= k; zaehler++) {
            IO.print("----");
        }
        //letzter strich
        IO.println("-");

        //zeilen ausgeben
        for (int zeile = 1; zeile <= k; zeile++) {
            IO.print(zeile, 4);
            IO.print("|");

            //spalte ausgeben
            for (int spalte = 1; spalte <= k; spalte++) {
                //modulus rechtbuendug ausgeben
                IO.print(zeile % spalte, 4);
            }
            IO.println();
        }
    }
}
