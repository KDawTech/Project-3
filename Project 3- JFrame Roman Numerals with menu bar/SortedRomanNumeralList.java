public class SortedRomanNumeralList extends RomanNumeralList {

    public SortedRomanNumeralList() {
    }

    
    
    /** 
     * @param name
     */
    public void add(String name) {

        RomanNumeralNode newNode = new RomanNumeralNode(name);// addNode() function
        RomanNumeralNode pos = head;// Set the position to the head of the list
        RomanNumeral k = new RomanNumeral(name);
        while (pos.next != null && k.compareTo(pos.next.data)) {
            // or compareTo
            pos = pos.next;// next node
        }
        if (pos.next == null) {
            append(name);
            // head = newNode;
            // tail = newNode;
        }
        RomanNumeral l = new RomanNumeral(pos.next.data);// Create a new RomanNumeral object with the data from the next node
        if (l.compareTo(newNode.data)) {// compareTo node to positon
            newNode.next = pos.next;
            pos.next = newNode;
        }

    }
}

