package blatt06;

import AlgoTools.IO;

public class Passwort {

    public static void main(String[] args) {
        IO.println("Ermittel das Passwort fuer getText...");
        String getText = getPasswort();
        IO.println("Ermittel das Passwort fuer getSuperSecretText...");
        String getSuperSecretText = getSuperSecretPasswort();
        IO.println();
        IO.println();
        IO.println("Das Passwort fuer getText lautet '" + getText + "'!");
        IO.println("Die Ausgabe ist: " + Secret.getText(getText));
        IO.println();
        IO.println();
        IO.println("Das Passwort fuer getSuperSecretText lautet '" + getSuperSecretText + "'!");
        IO.println("Die Ausgabe ist: " + Secret.getSuperSecretText(getSuperSecretText));
    }

    public static String getPasswort() {
        char[] array = new char[5];
        for (int i = 0; i < array.length; i++) {
            array[i] = 'a';
        }

        String passwort;
        while (true) {
            array[array.length - 1]++;

            passwort = "";
            for (int i = array.length - 1; i > 0; i--) {
                // Wenn ein Zeichen nicht mehr im Bereich ist,
                // inkrementiere das vorherige
                if (array[i] > 'z') {
                    array[i] = 'a';
                    array[i - 1]++;
                }

                // Passwort zum String
                passwort = array[i] + passwort;
            }
            passwort = array[0] + passwort;
            if (array[0] > 'z') return "";

            if (Secret.getText(passwort).length() > 0) {
                return passwort;
            }
        }
    }

    public static String getSuperSecretPasswort() {
        char[] array = new char[1];
        for (int i = 0; i < array.length; i++) {
            array[i] = 'a';
        }

        String passwort;
        while (true) {
            array[array.length - 1]++;

            passwort = "";
            for (int i = array.length - 1; i > 0; i--) {
                // Wenn ein Zeichen nicht mehr im Bereich ist,
                // inkrementiere das vorherige
                if (array[i] > 'z') {
                    array[i] = 'a';
                    array[i - 1]++;
                }

                // Passwort zum String
                passwort = array[i] + passwort;
            }
            // Passwort zum String
            passwort = array[0] + passwort;
            // Erweitere das Array um ein Zeichen
            if (array[0] > 'z') {
                array = new char[array.length + 1];

                for (int i = 0; i < array.length; i++) {
                    array[i] = 'a';
                }
            } else {
                if (Secret.getSuperSecretText(passwort).length() > 0) {
                    return passwort;
                }
            }
        }
    }
}
