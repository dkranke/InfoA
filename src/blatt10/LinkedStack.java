package blatt10;

/**
 * Ein Stack, der mit Verweisen implementiert ist, ähnlich einer Linked List.
 */
public class LinkedStack {
    private Element top;

    /**
     * Erstellt einen leeren Stack.
     */
    public LinkedStack() {
        top = null;
    }

    /**
     * Gibt `true` zurück, genau dann wenn dieser Stack keine Elemente enthält.
     */
    public boolean isEmpty() {
        return this.top == null;
    }

    /**
     * Legt das gegebene Element oben auf den Stack.
     */
    public void push(Object d) {
        this.top = new Element(d, this.top);
    }

    /**
     * Gibt das oberste Objekt zurück ohne es zu entfernen. Falls der Stack
     * leer ist, wird `null` zurückgegeben.
     */
    public Object top() {
        if (this.top == null) {
            return null;
        }
        return this.top.getObject();
    }

    /**
     * Entfernt das oberste Objekt des Stacks und gibt es zurück.
     * <p>
     * Diese Methode darf nicht aufgerufen werden, wenn der Stack leer ist.
     * Sonst knallts.
     */
    public Object pop() {
        Object out = this.top();
        this.top = this.top.getNext();

        return out;
    }
}
