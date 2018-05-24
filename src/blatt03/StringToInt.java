package blatt03;

import AlgoTools.IO;

public class StringToInt {

    public static void main(String[] args) {

        String kette;
        int i; //position
        int ausgabe = 0;
        int zaehler = 1;

        //string einlesen
        kette = IO.readString("Eingabe: ");

        //String zu int (von hinten nach vorne)
        for (i = kette.length() - 1; i >= 0; i--) {
            char zeichen = kette.charAt(i);
            int zahl = (int) zeichen;

            ausgabe = ausgabe + (zahl - 48) * zaehler; //oder: ausgabe = ausgabe + (kette.charAt(i) - '0') * zaehler;
            zaehler = zaehler * 10; //für multipl., also dass mal 1, mal 10, mal 100, ...
        }

        //ergebnis wird verdoppelt
        IO.print(ausgabe * 2);
    }
}
