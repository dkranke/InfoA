package blatt03;

import AlgoTools.IO;

public class SumOfNumbers {

    public static void main(String[] args) {

        //string einlesen
        String eingabe;
        String ausgabe = "";
        int i;
        int zahl = 0;
        int ziffer;
        int ergebnis = 0;

        eingabe = IO.readString("Bitte eine durch Kommata getrennte Zahlenfolge eingeben: ");

        for (i = 0; i < eingabe.length(); i++) {
            ziffer = (int) eingabe.charAt(i) - 48;

            //wenn char ein komma: ,=44 -> 44-48=-4
            if (ziffer != -4) {
                zahl = zahl * 10 + ziffer;
            } else {
                ergebnis = ergebnis + zahl;
                zahl = 0;
            }
        }

        ergebnis = ergebnis + zahl;
        IO.println(ergebnis);

    }
}
