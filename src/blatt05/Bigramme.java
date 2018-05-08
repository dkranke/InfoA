package blatt05;

import AlgoTools.IO;

public class Bigramme {
    public static void main(String[] args) {
        int[][] anzahl = new int[26][26];
        String text;
        int zaehler1, zaehler2;
        char c1, c2;
        int index1 = 0, index2 = -1;
        char zeichen;
        int max = 0;

        // Text einlesen
        do {
            text = IO.readLine("Bitte einen String eingeben: ");
        } while (text.length() < 2);
        text = text.toLowerCase();
        IO.println();

        // Bigramme zählen
        for (zaehler1 = 0; zaehler1 < text.length() - 1; zaehler1++) {
            c1 = text.charAt(zaehler1);
            c2 = text.charAt(zaehler1 + 1);
            if (c1 >= 'a' && c2 >= 'a' && c1 <= 'z' && c2 <= 'z') {
                index1 = c1 - 'a';
                index2 = c2 - 'a';
                anzahl[index1][index2] = anzahl[index1][index2] + 1;
            }
        }

        // Finde den größten Wert in dem multi-dimensionalen Array
        for (zaehler1 = 0; zaehler1 < anzahl.length; zaehler1++) {
            for (zaehler2 = 0; zaehler2 < anzahl[zaehler1].length; zaehler2++) {
                if (anzahl[zaehler1][zaehler2] > max) {
                    index1 = zaehler1;
                    index2 = zaehler2;
                    max = anzahl[zaehler1][zaehler2];
                }
            }
        }

        if (max > 0) {
            // Konvertiere die Indexe in Buchstaben
            c1 = (char) (index1 + (int) 'a');
            c2 = (char) (index2 + (int) 'a');
            IO.println("Das Bigramm _" + c1 + c2 + "_ kommt " + anzahl[index1][index2] + " mal vor.");

            // Mache das Frage/Antwort Spiel
            do {
                IO.println();
                text = IO.readLine("Bitte Bigramm eingeben (oder nichts zum abbrechen): ");
                text.toLowerCase();
                IO.println();
                if (text.length() == 2) {
                    c1 = text.charAt(0);
                    c2 = text.charAt(1);
                    if (c1 >= 'a' && c2 >= 'a' && c1 <= 'z' && c2 <= 'z') {
                        index1 = c1 - 'a';
                        index2 = c2 - 'a';
                        IO.println("Das Bigramm _" + text + "_ kommt " + anzahl[index1][index2] + " vor.");
                    }
                }
            } while (text.length() > 0);
        }
        // Sonst melde das es keine Bigramme gibt
        else {
            IO.println("Es gibt keine gueltigen Bigramme!");
        }
    }
}
