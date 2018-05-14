import AlgoTools.IO;

/**
 * Diese Klasse dient zum Testen der Klasse ArrayStack.
 */
public class ArrayStackTest {

    public static void main(String[] args) {
        IO.println();

        ArrayStack stack = new ArrayStack();

        IO.println("Der neu konstruierte Stack ist leer: " + stack.isEmpty());

        stack.push(new Object());
        IO.print("Nach einer Push-Operation ist der Stack nicht leer: ");
        IO.println(!stack.isEmpty());

        stack.pop();
        IO.print("Nach einer Push-Pop-Operation ist der Stack unverändert, ");
        IO.print("also wieder leer: ");
        IO.println(stack.isEmpty());

        Object x = new Object();
        stack.push(x);
        IO.print("Nach der Push-Operation mit dem Objekt x, ");
        IO.print("liefert die Top-Operation das Objekt x: ");
        IO.println(x.equals(stack.top()));

        IO.print("Die Pop-Operation liefert das Objekt x ...: ");
        IO.println(x.equals(stack.pop()));

        IO.print("und entfernt dieses zugleich, sodass der Stack anschließend ");
        IO.print("wieder leer ist: ");
        IO.println(stack.isEmpty());

        IO.println();

    }
}
