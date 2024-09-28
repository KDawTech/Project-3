public class UnsortedRomanNumeralList extends RomanNumeralList {

    
    
    /** 
     * @param name
     */
    public void add(String name) {
        append(name);// append unsorted

    }
    
    /** 
     * @return String
     */
    // This method returns a String representation of the current object.
public String toString() {
    // Initialize an empty String variable called "data".
    String data = " ";
    
    RomanNumeralNode newNode = head;
    
    while (newNode.next !=  null) {
        // Create a new RomanNumeral object called "j", passing in the data from the next node in the linked list.
        RomanNumeral j= new RomanNumeral( newNode.next.data);
        // Append the Arabic value of the RomanNumeral object to the "data" variable, followed by a newline character.
        data += String.valueOf(j.getArabicValue()) + " \n";
        // Set "newNode" equal to the next node in the linked list.
        newNode = newNode.next;
    }
    
    return data;
}

}
