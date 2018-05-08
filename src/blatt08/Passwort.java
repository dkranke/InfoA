package blatt08;

import AlgoTools.IO;

public class Passwort {

    // Passwort: raava
    public static void main(String[] args) {
        // Optionale Eingabe eines Prefix, wenn keine Angabe erfolgt wird "" genutzt
        String prefix = "";
        if (args.length > 0) {
            prefix = args[0];
        }

        // Wiederhole solange bis ein Passwort gefunden wurde
        boolean found = false;
        int i = 0;
        while (!found) {
            IO.println("Suche nach Passwoertern mit '" + prefix + "' + " + i + " Zeichen...");
            // Versuche ein gültiges Passwort der Länge (prefix +) i zu finden
            found = crack(prefix, i);
            // Erhöhe die Passwort-Länge um 1
            i++;
        }
    }

    // Methodenkopf aus der Aufgabenstellung
    private static boolean crack(String prefix, int additionalLength) {
        // Sonderfall: Ist additionalLength = 0
        if (additionalLength == 0) {
            // Prüfe ob prefix das richtige Passwort ist
            boolean found = SecretAgain.getText(prefix).length() > 0;
            // Wenn ja:
            if (found) {
                IO.println();
                // Gebe das Passwort und den Text aus
                IO.println("Passwort gefunden: " + prefix);
                IO.println("Text: " + SecretAgain.getText(prefix));
            }
            return found;
        }

        // Für jeden Kleinbuchstaben (alternativ: for i von 0 bis < 26 und char suffix = 'a' + i)
        for (char suffix = 'a'; suffix <= 'z'; suffix++) {
            // Hänge das Zeichen an die Prefix an
            String passwort = prefix + suffix;

            // Soll das Passwort aus noch mehr Zeichen bestehen?
            if (additionalLength > 0) {
                // Wenn ja: Hänge die restlichen Zeichen an und prüfe das Passwort
                boolean found = crack(passwort, additionalLength - 1);
                if (found)
                    return true;
            }
        }

        // Wenn kein gültiges Passwort gefunden werden konnte gebe false zurück
        return false;
    }
}
