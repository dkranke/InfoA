public class ArrayStack {

    // ADT-Array für den ArrayStack
    private Object[] data;

    // Konstruktor von ArrayStack
    // Weißt data einen leeren ADT-Array zu
    public ArrayStack() {
        data = new Object[0];
    }

    // Gibt zurück ob der ArrayStack leer ist
    public boolean isEmpty() {
        return data.length == 0;
    }

    // Gibt das oberste Element vom Stack zurück,
    // ohne das es entfernt wird.
    public Object top() {
        // Falls der Stack leer ist gebe 'nichts' zurück
        if (isEmpty()) {
            return null;
        }
        // Sonst gebe das oberste Element zurück
        else {
            return data[data.length - 1];
        }
    }

    // Fügt ein neues Element zu dem Stack hinzu
    public void push(Object d) {
        // Lege einen neuen ADT-Array an,
        // der ein Element größer ist als der alte data-Array
        Object[] newData = new Object[data.length + 1];

        // Kopiere die vorhanden Elemente in den neuen Array
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }

        // Füge das neue Element am Ende der Liste hinzu
        newData[data.length] = d;

        // Überschreibe den alten data-Array mit dem neuen
        data = newData;
    }

    // Gibt wie top() das oberste Element vom Stack zurück,
    // nur entfernt es den Wert aus dem Stack
    public Object pop() {
        // Falls der Stack leer ist tue nix und gebe 'nichts' zurück
        if (isEmpty()) {
            return null;
        }
        // Sonst
        else {
            // Lege einen neuen ADT-Array an,
            // der ein Element kleiner ist als der alte data-Array
            Object[] newData = new Object[data.length - 1];

            // Kopiere die vorhanden Elemente in den neuen Array,
            // außer dem Element das zurückgegeben wird
            for (int i = 0; i < newData.length; i++) {
                newData[i] = data[i];
            }

            // Puffer das Element,
            // um es ausgeben zu können nachdem data überschrieben wurde
            Object buffer = data[newData.length];

            // Überschreibe den alten data-Array mit dem neuen
            data = newData;

            // Gebe das gepufferte Element zurück
            return buffer;
        }
    }
}
