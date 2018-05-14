/**
 * Diese Klasse repräsentiert ein Element für alle verketteten ADTs, wie List.
 */
public class Element {

    // Attribute
    private Object data;
    private Element next;

    // Konstruktor 1
    public Element(Object data) {
        this.data = data;
        this.next = null;
    }

    // Konstruktor 2
    public Element(Object data, Element next) {
        this.data = data;
        this.next = next;
    }

    /**
     * Diese Operation liefert das Objekt, auf welches dieses ELement verweist.
     */
    public Object getObject() {
        return this.data;
    }

    /**
     * Diese Operation fügt diesem Element einen Verweis auf dessen Objekt hinzu.
     */
    public void setObject(Object data) {
        this.data = data;
    }

    /**
     * Diese Operation liefert das nächste Element, auf welches dieses Element
     * verweist.
     */
    public Element getNext() {
        return this.next;
    }

    /**
     * Diese Operation fügt diesem Element einen Verweis auf das nächste ELement
     * hinzu.
     */
    public void setNext(Element next) {
        this.next = next;
    }


}
