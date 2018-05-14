/**
 * Eine Queue die mit Verweisen implementiert ist, ähnlich einer Linked List.
 */
public class LinkedQueue {
    private Element front;
    private Element back;

    /**
     * Erstellt eine leere Queue.
     */
    public LinkedQueue() {
        front = null;
        back = null;
    }

    /**
     * Gibt `true` zurück, genau dann wenn diese Queue keine Elemente enthält.
     */
    public boolean isEmpty() {
        return this.front == null;
    }

    /**
     * Fügt das gegebene Element an den Schwanz der Schlange an.
     */
    public void enqueue(Object d) {
        Element newElem = new Element(d);
        if (this.back == null) {
            this.front = newElem;
        } else {
            this.back.setNext(newElem);
        }
        this.back = newElem;
    }

    /**
     * Gibt das Objekt am Kopf der Queue zurück, ohne es zu entfernen. Falls
     * die Queue leer ist, wird `null` zurückgegeben.
     */
    public Object peek() {
        if (this.front == null) {
            return null;
        }
        return this.front.getObject();
    }

    /**
     * Entfernt das Element am Kopf der Schlange und gibt es zurück.
     * <p>
     * Diese Methode darf nicht aufgerufen werden, wenn die Queue leer ist.
     * Sonst knallts.
     */
    public Object dequeue() {
        Object out = this.peek();
        this.front = this.front.getNext();
        if (this.front == null) {
            this.back = null;
        }

        return out;
    }
}
