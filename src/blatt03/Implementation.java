package blatt03;

import AlgoTools.IO;

public class Implementation {

    public static void main(String[] args) {

        int anzahl;
        char zeichen;
        // "" braucht man, weil man sonst nicht addieren kann
        String ergebnis = "";

        //anzahl und zeichen einlesen lassen (immer wieder)
        //ergebnis speichern
        do {
            do {
                anzahl = IO.readInt("Anzahl: ");
            } while (anzahl < 0);

            // warum das if?? -> wenn 0 eingegeben wird, wird abgebrochen
            if (anzahl != 0) {
                zeichen = IO.readChar("Zeichen: ");

                // anzahl mal zeichen zum ergebnis hinzufügen
                //Zwischenergebnis wird gespeichert!!
                for (int i = 0; i < anzahl; i++) {
                    ergebnis = ergebnis + zeichen;
                }

            }

        } while (anzahl > 0);

        //ergebnis ausgeben
        IO.println(ergebnis);

    }

}
