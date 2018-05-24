package blatt03;

import AlgoTools.IO;

public class Palindrom {

    public static void main(String[] args) {


        String wort;
        int haelfte;
        boolean wort_ist_ein_palindrom = true;
        /*
            wort einlesen -> speichern in String
            hälfte der wortlänge berechnen -> speichern in int
            überprüfen, ob palindrom:
                dann schleife für i = 0 bis zur hälfte der Länge:
                    buchstabe an stelle i vergleichen mit buchstaben an stelle (länge - 1 - i)
                        wenn nicht gleich, dann kein palindomr
        */
        do {
            wort = IO.readString("Bitte ein Wort eingeben: ");
        } while (wort.length() == 0);//ausschließen dass nur enter gedrückt wird

        haelfte = wort.length() / 2;

        for (int i = 0, j = 0; i < haelfte; i++) {
            j = wort.length() - 1 - i;
            if (wort.charAt(i) != wort.charAt(j)) {
                wort_ist_ein_palindrom = false;
                break;
            }
        }

        if (wort_ist_ein_palindrom) {
            IO.println(wort + " ist ein Palindrom.");
        } else {
            IO.println(wort + " ist kein Palindrom.");
        }


    }
}
