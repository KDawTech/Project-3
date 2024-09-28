//wordlist.java
public class RomanNumeralList {

    // Initializing Node with null value

    public RomanNumeralNode head = new RomanNumeralNode(" ");// arbitary string//testing sting on first line
    

    public class Word {
        private String data;

       
        public Word(String name) { // constructor
            data = name;
        }

        // compareTo method accepts a Word variable and compares two strings
        public int compareTo(Word other) {
            return this.data.compareTo(other.data);// or compareToignorecase

        }

        public String toString() {
            return data + " ";
        }
    }

    

    
    /** 
     * @param word
     */
    public void append(String word) {
        RomanNumeralNode newNode = new RomanNumeralNode(word);

        if (head == null) {
            newNode.next = head;
            newNode = head;

            // tail = newNode;
        } else {
            RomanNumeralNode pos = head; // for traversing

            while (pos.next != null) {
                pos = pos.next; // move to the next node
            }
            newNode.next = pos.next;
            pos.next = newNode;
        }

    }

    
    
    /** 
     * @return String
     */
    public String toString() {
        String data = " ";

        RomanNumeralNode newNode = head;
        
        while (newNode.next !=  null) {
            
            RomanNumeral j= new RomanNumeral( newNode.next.data);
            

            data += String.valueOf(j.getArabicValue()) + " \n";
           
            newNode = newNode.next;
        }
        return data;
    }

    // public void add(String name) {//this
}
// }//this
