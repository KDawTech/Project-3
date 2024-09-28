

public class RomanNumeral {// getRomanNumeral() returns the Roman Numeral stored in this object
    public String romanNumeral;
    public int arabicValue;

    
  
    public RomanNumeral(String romanNumeral) {
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);
    }
  
    
    /** 
     * @param romanNumeral
     * @return int
     */
    public static int convertToArabic(String romanNumeral) throws IllegalRomanNumeralException {
        if (!romanNumeral.matches("[MDCLXVI]+")) { // Check if the Roman Numeral is valid
            System.err.println("Invalid Roman Numeral: " + romanNumeral ); // Print error message to console
           // throw new IllegalRomanNumeralException("Invalid Roman numeral: " + romanNumeral + " is not a valid Roman numeral");
        }
        // Implement the logic to convert the Roman Numeral to Arabic value here
        int arabicValue = 0;//intialize arabic value 
  
        for (int i = 0; i < romanNumeral.length(); i++) {// For each character in the romanNumeral
  
            char currentChar = romanNumeral.charAt(i);// Get the current char
  
            switch (currentChar) {
                case 'M':
                    arabicValue += 1000;//M=1000
                    break;
                case 'D':
                    arabicValue += 500;// D=500
                    break;
                case 'C':
                    if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'M') {
                        arabicValue += 900;// Operation add values
                        i++;
                    } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'D') {
                        arabicValue += 400;
                        i++;
                    } else {
                        arabicValue += 100;
                    }
                    break;
                case 'L':
                    arabicValue += 50;
                    break;
                case 'X':
                    if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'C') {
                        arabicValue += 90;
                        i++;
                    } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'L') {
                        arabicValue += 40;
                        i++;
                    } else {
                        arabicValue += 10;
                    }
                    break;
                case 'V':
                    arabicValue += 5;
                    break;
                case 'I':
                    if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'X') {
                        arabicValue += 9;
                        i++;
                    } else if (i < romanNumeral.length() - 1 && romanNumeral.charAt(i + 1) == 'V') {
                        arabicValue += 4;
                        i++;
                    } else {
                        arabicValue += 1;
                    }
                    break;
            }
        }
        return arabicValue;
        
        // return arabicValue;
  
    }
  
  
    
    /** 
     * @return String
     */
    public String getRomanNumeral() {
        return romanNumeral;
    }
  
    public void setRomanNumeral(String romanNumeral) {// setRomanNumeral() sets the Roman Numeral stored in this object and also calculates its Arabic Value
        this.romanNumeral = romanNumeral;
        this.arabicValue = convertToArabic(romanNumeral);
    }
  
    public int getArabicValue() {
        return arabicValue;
    }
  
    public boolean equals(Object other) {// equals() checks if two Roman Numerals are equal
        if (!(other instanceof RomanNumeral)) {
            return false;
        }
        RomanNumeral otherRomanNumeral = (RomanNumeral) other;
        return this.romanNumeral.equals(otherRomanNumeral.getRomanNumeral())
                && this.arabicValue == otherRomanNumeral.getArabicValue();
    }
  
    public String toString() {
        return "Roman Numeral: " + this.romanNumeral + ", Arabic Value: " + this.arabicValue;
    }
  
    public boolean compareTo(String other) {// compareTo() compares the Arabic Value of this Roman Numeral with another Roman Numeral
       
        return (this.arabicValue > convertToArabic(other));
     }


   
   }
  
