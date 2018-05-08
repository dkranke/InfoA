package blatt02;

import AlgoTools.IO;

public class Pyramide {

    public static void main(String[] args) {
        int h;
        do { // Solange h < 2 oder h > 42
            h = IO.readInt("Höhe: "); // Lese eine Zahl ein und speichere sie in h
        } while (h < 2 || h > 42);

        for (int i = 0; i < h; i++) { // Wiederhole h mal (mit i von 0 zu h)
            // Die Sterne passend für die Pyramide einrücken
            for (int j = 0; j < h - i - 1; j++) { // Wiederhole h-i-1 mal (mit j von 0 zu h-i-1)
                IO.print(" "); // Gebe ein Leerzeichen aus
            }

            // Die Sterne für die Pyramide ausgeben (Linke Sterne + Mitte + Rechte Sterne)
            for (int j = 0; j < i * 2 + 1; j++) { // Wiederhole i*2+1 mal (mit j von 0 zu i*2+1)
                IO.print("*"); // Gebe einen Stern aus
            }
            IO.println(); // Führe einen Zeilenumbruch durch
        }
    }
}
