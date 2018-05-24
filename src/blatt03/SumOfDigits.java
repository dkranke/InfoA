package blatt03;

import AlgoTools.IO;

public class SumOfDigits {

    public static void main(String[] args) {

    /*Zeichenkette einlesen
      jedes Zeichen als Ziffer interpretieren -> also jedes Zeichen zu int
      Ziffern aufaddiert ausgeben
    */

        String eingabe;
        int i;
        int ausgabe = 0;
        int wirkliche_zahl;

        eingabe = IO.readString("Eingabe: ");

        //von zeichen zu zeichen gehen und als zahl interpretieren
        for (i = 0; i < eingabe.length(); i++) {
            char zeichen = eingabe.charAt(i);
            int zahl = (int) zeichen;
            wirkliche_zahl = (zahl - 50) + 2;
            ausgabe = ausgabe + wirkliche_zahl;

        }
        //  ergebnis = ausgabe
        IO.print(ausgabe);

    }

}
