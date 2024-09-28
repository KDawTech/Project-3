import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ConvertMenuHandler implements ActionListener {// ConvertMenuHandler class for action performed method 
    public RomanNumeralGUI jframe;

    public ConvertMenuHandler(RomanNumeralGUI gui) {// constructor for ConvertMenuHandler
        jframe = gui;
    }

    
    /** 
     * @param Arabic")
     */
    public void actionPerformed(ActionEvent event) {// action performed method for ConvertMenuHandler class  
        String command = event.getActionCommand();
        if (command.equals("Roman to Arabic")) {
            String romanNumeral = JOptionPane.showInputDialog(jframe, "Enter a Roman Numeral");// input dialog box for Roman Numeral 
            try {
                RomanNumeral r = new RomanNumeral(romanNumeral);
                int arabicValue = r.getArabicValue();
                if (arabicValue == 0) { // Check if Arabic value is 0
                    throw new IllegalRomanNumeralException("Invalid input: " + romanNumeral); // Throw exception if Arabic value is 0
                }
                JOptionPane.showMessageDialog(jframe, "The Arabic value is " + arabicValue);// output dialog box for Arabic value 
            } catch (IllegalRomanNumeralException ex) {
               // JOptionPane.showMessageDialog(jframe, ex.getMessage());
            } catch (NumberFormatException ex) {
                System.err.println("Invalid input");// error message for invalid input 
            }
        }
    }
}




    




















// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JOptionPane;

// public class ConvertMenuHandler implements ActionListener {
//     public RomanNumeralGUI gui;

//     public ConvertMenuHandler(RomanNumeralGUI gui) {
//         this.gui = gui;
//     }

//     public void actionPerformed(ActionEvent e) {
//         String menuName = e.getActionCommand();
//         if (menuName.equals("Roman to Arabic")) {
//              String romanNumeral = JOptionPane.showInputDialog(null, "Enter a Roman Numeral");
//             try {
//                 RomanNumeral r = new RomanNumeral(romanNumeral);
//                 JOptionPane.showMessageDialog(null, "The Arabic value is " + r.getArabicValue());
//             } catch (IllegalRomanNumeralException ex) {
//                 JOptionPane.showMessageDialog(null, ex.getMessage());
//             }
//         }
//     }


// }
