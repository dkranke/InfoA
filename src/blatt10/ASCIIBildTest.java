package blatt10;

import AlgoTools.IO;

// System zum testen ob die Klassen ASCIIPicture und FloodFill so funktionieren wie sie sollen
public class ASCIIBildTest {

    public static void main(String[] args) {
        // Variablen einlesen
        int width, height;
        do {
            width = IO.readInt("Bitte eine Breite: ");
        } while (width < 1);
        do {
            height = IO.readInt("Bitte eine Hoehe: ");
        } while (height < 1);

        // Ein ASCII-Bild erstellen und ausgeben
        ASCIIPicture picture = new ASCIIPicture(width, height);
        picture.printPicture();
        IO.println();

        // Endlosschleife, um das ASCII-Bild zu manipulieren
        while (true) {
            // Welche Art der Manipulaion soll gemacht werden? Oder soll das Programm beendet werden
            // Für alle Aktionen wurde ein Kürzel hinzugefügt (großer Buchstabe) um das Testen zu beschleunigen
            String action;
            do {
                action = IO.readString("Bitte Befehl ('Set', 'Floodfill' oder 'eXit'): ");
                action = action.toLowerCase();
            } while (!(action.equals("set") || action.equals("floodfill") ||
                    action.equals("exit") || action.equals("s") || action.equals("f") ||
                    action.equals("x"))
                    );

            // Falls das Programm beendet werden soll beende es jetzt
            if (action.equals("exit") || action.equals("x")) {
                return;
            }

            // Sonst lese die Argumente für die Befehle ein
            int x, y;
            do {
                x = IO.readInt("Bitte x-Koordinate: ");
            } while (x < 0 || x >= width);
            do {
                y = IO.readInt("Bitte y-Koordinate: ");
            } while (y < 0 || y >= height);
            char color = IO.readChar("Bitte Farbe eingeben: ");

            // Wenn nur ein Pixel verändert werden soll, passe es mithilfe der Argumente an
            if (action.equals("set") || action.equals("s")) {
                picture.setColor(x, y, color);
            }
            // Sonst soll eine Fläche gefüllt werden, dann tue dies
            else {
                FloodFill.floodFill(picture, x, y, color);
            }

            // Nach der Manipulation gebe das Ergebnis aus (und beginne von vorne)
            picture.printPicture();
            IO.println();
        }
    }
}
