package blatt10;

public class FloodFill {

    // Floodfill Algorithmus, umgesetzt nach den Folien
    public static void floodFill(ASCIIPicture picture, int x, int y, char newColor) {
        // Erstellen einen Queue um die zu verarbeitenden Pixel zu speichern
        LinkedQueue pixel = new LinkedQueue();

        // Erkenne die zu ersetzende Farbe
        char oldColor = picture.getColor(x, y);

        // Packe die Initialen Koordinaten in den Queue
        pixel.enqueue(new Coord(x, y));

        // Solange der Queue nicht leer ist
        while (!pixel.isEmpty()) {
            // Rufe Koordinaten aus dem Queue ab
            Coord coord = (Coord) pixel.dequeue();
            x = coord.x();
            y = coord.y();

            // Wenn die Farbe die gleiche ist wie ursprünglich der initiale Pixel und
            // Reihe die umgebenen Pixel in den Queue ein
            if (picture.getColor(x, y) == oldColor) {
                picture.setColor(x, y, newColor);

                pixel.enqueue(new Coord(x - 1, y));
                pixel.enqueue(new Coord(x, y + 1));
                pixel.enqueue(new Coord(x + 1, y));
                pixel.enqueue(new Coord(x, y - 1));
            }
        }
    }

    // Container um Koordinaten in dem Queue zu speichern,
    // dadurch ersparen wir uns die Arbeit die Koordinaten richtig zu encodieren
    private static class Coord {
        private int x, y;

        // Konstrukter um nur lesbare Koordinaten zu erstellen
        Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Getter der Koordinaten
        public int x() {
            return x;
        }

        public int y() {
            return y;
        }
    }
}
