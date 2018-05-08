package blatt04;

import AlgoTools.IO;

public class Caesar {

    public static void main(String[] args) {
        // Deklaration aller Variablen
        String kryptotext;
        int[] anzahl = new int[26];
        int ordSchluessel = 0;
        int pos;
        char zeichen;
        int ordZeichen;
        char kryptoZeichen;
        String klartext = "";

        // Eingabe eines Textes, der aus mehr als 0 Zeichen besteht
        do {
            kryptotext = IO.readString();
        } while (kryptotext.length() == 0);
        // Wandel alle Buchstaben in Grossbuchstaben um
        kryptotext = kryptotext.toLowerCase();

        // Zeichen zählen
        for (pos = 0; pos < kryptotext.length(); pos++) {
            zeichen = kryptotext.charAt(pos);
            if (zeichen >= 'a' && zeichen <= 'z') {
                ordZeichen = (int) zeichen - (int) 'a';
                anzahl[ordZeichen] = anzahl[ordZeichen] + 1;
            }
        }

        // Maximum finden
        for (pos = 0; pos < anzahl.length; pos++) {
            if (anzahl[pos] > anzahl[ordSchluessel]) {
                ordSchluessel = pos;
            }
        }
        // Das 'e' vom Schluessel abziehen, da wir ein 'a' als Schluessel nutzen
        ordSchluessel = ordSchluessel - 4;

        // Fuer jedes Zeichen im kryptotext
        for (pos = 0; pos < kryptotext.length(); pos = pos + 1) {
            zeichen = kryptotext.charAt(pos);

            // Wenn das Zeichen ein Buchstabe des lateinischen Alphabetes ist
            if (zeichen >= 'a' && zeichen <= 'z') {
                // Wandel das Zeichen in eine Zahl, zwischen 0 und 25, um
                ordZeichen = (int) zeichen - 'a';
                // Subtrahiere die Ordnungszahl des Schluessels und sorge, mit dem Modulus von 26, dafuer das die Zahl immer noch zwischen 0 und 25 ist
                ordZeichen = (ordZeichen - ordSchluessel + 26) % 26;
                // Wandel die Ordnungszahl wieder in einen Buchstaben um
                kryptoZeichen = (char) (ordZeichen + (int) 'a');
                // Hänge den Buchstaben an den klartext an
                klartext = klartext + kryptoZeichen;
            } else {
                klartext = klartext + zeichen;
            }
        }

        // Gebe den klartext aus
        IO.println("Klartext: " + klartext);
    }
}
