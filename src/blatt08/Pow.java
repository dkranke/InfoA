package blatt08;

import AlgoTools.IO;

public class Pow {

    public static void main(String[] args) {
        // Werte einlesen
        float b = IO.readFloat("Basis: ");
        int p = IO.readInt("Exponent: ");
        IO.println();

        // Berechne den potenzierten Wert
        float pow = pow(b, p);
        IO.println("Ergebnis von " + b + "^" + p + ": " + pow);
    }

    // Potenziert eine Zahl
    // Methodenkopf nach Aufgabenstellung
    public static float pow(float b, int p) {
        // Sonderfall: Wenn Potenz = 0 gebe 1 zurück
        if (p == 0) return 1;
            // Wenn p > 1 gebe den potenzierten Wert aus (via Rekursion)
        else if (p > 1)
            return b * pow(b, p - 1);
            // Wenn p < 0 gebe 1 / potenzierten Wert (p negiert)
        else if (p < 0)
            return 1 / pow(b, -p);
            // Wenn p == 1 ist gebe b zurück
        else
            return b;
    }
}
