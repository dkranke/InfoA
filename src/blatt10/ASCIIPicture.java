package blatt10;

import AlgoTools.IO;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ASCIIPicture {

    // Private Variablen nach Aufgabenstellung
    private int width, height;
    private char[][] picture;

    // Konstruktor um ein ASCII-Bild mit einer bestimmten Maße zu erstellen und mit Standartwerten zu befüllen
    public ASCIIPicture(int width, int height) {
        this.width = width;

        this.height = height;
        picture = new char[height][width];

        initPicture("stack.png");
    }

    // Methode um das Bild mit dem Standartmuster zu befüllen
    private void initPicture() {
        for (int y = 0; y < picture.length; y++) {
            for (int x = 0; x < picture[y].length; x++) {
                if (x == y) {
                    picture[y][x] = '#';
                } else {
                    picture[y][x] = ' ';
                }
            }
        }
    }

    private void initPicture(String path) {
        char[] c = {' ', 0xB0, 0xB1, 0xB2, 0xDB};
        try {
            Image i = ImageIO.read(new File(path)).getScaledInstance(width, height, Image.SCALE_SMOOTH);
            BufferedImage bI = new BufferedImage(i.getWidth(null), i.getHeight(null), BufferedImage.TYPE_INT_ARGB);
            bI.createGraphics().drawImage(i, 0, 0, null);

            for (int y = 0; y < picture.length; y++) {
                for (int x = 0; x < picture[y].length; x++) {
                    int argb = bI.getRGB(x, y);
                    int r = (argb >> 16) & 0xff;
                    int g = (argb >> 8) & 0xff;
                    int b = argb & 0xff;
                    int brightness = (int) Math.sqrt(0.299 * r * r + 0.587 * g * g + 0.114 * b * b);
                    int index = brightness / 52;
                    picture[y][x] = c[index];
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    // Getter für die Breite, Höhe und der Farbe eines bestimmten Pixels
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public char getColor(int x, int y) {
        if (x < 0 || y < 0 || y >= picture.length || x >= picture[y].length) {
            return 0;
        } else {
            return picture[y][x];
        }
    }

    // Setter, um ein Pixel im Bild zu verändern
    public void setColor(int x, int y, char newColor) {
        if (x >= 0 && y >= 0 && y < picture.length && x < picture[y].length) {
            picture[y][x] = newColor;
        }
    }

    // Gebe das gespeicherte Bild in der Konsole aus
    public void printPicture() {
        for (int y = 0; y < picture.length; y++) {
            for (int x = 0; x < picture[y].length; x++) {
                IO.print(picture[y][x]);
            }
            IO.println();
        }
    }
}