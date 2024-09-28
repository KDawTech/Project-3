
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener {
    RomanNumeralGUI jframe;
    
    public FileMenuHandler(RomanNumeralGUI gui, ConvertMenuHandler v) {// constructor for FileMenuHandler class
        jframe=gui;// set jframe to gui 
    }

    
    /** 
     * @param JFileChooser.APPROVE_OPTION
     */
    public void actionPerformed(ActionEvent event) {// action performed method for FileMenuHandler class 
        String command = event.getActionCommand();
        if (command.equals("Open")) {// if command is Open 
            openFile();
        } else if (command.equals("Quit")) {// if command is Quit 
            System.exit(0);
        }
    }

    private void openFile() {// open file method 
        JFileChooser chooser;
        int status;
        chooser = new JFileChooser();
        status = chooser.showOpenDialog(null);
        if (status == JFileChooser.APPROVE_OPTION) {
            readSource(chooser.getSelectedFile());
            jframe.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");// error message for open file dialog canceled 
        }
    }

    public boolean isValidRomanNumeral( String str){// method to check if Roman Numeral is valid 
        String romanNumeral = str.toUpperCase();
        boolean isValid = true;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char ch = romanNumeral.charAt(i);
            if (ch != 'I' && ch != 'V' && ch != 'X' && ch != 'L' && ch != 'C' && ch != 'D' && ch != 'M') {// check if Roman Numeral is valid 
                isValid = false;
                break;
            }
        }
        return isValid;// return isValid 
    }
    private void readSource(File chosenFile) {// read source method THAT READS THE FILE AND PRINTS IT OUT 
        
        String chosenFileName=chosenFile.getAbsolutePath();

        
        TextFileInput inFile = new TextFileInput(chosenFileName);
        UnsortedRomanNumeralList a = new UnsortedRomanNumeralList();
        SortedRomanNumeralList b = new SortedRomanNumeralList();
        
        Container myContentPane = jframe.getContentPane();
         myContentPane.setLayout(new GridLayout(1, 3));
        TextArea textArea1 = new TextArea();
        TextArea textArea2 = new TextArea();
        TextArea textArea3 = new TextArea();
        textArea1.setEditable(false);
        textArea2.setEditable(false);
        textArea3.setEditable(false);

        myContentPane.add(textArea1);
        myContentPane.add(textArea2);
        myContentPane.add(textArea3);

        textArea1.setText("Original Roman Numeral List:" + "\n");
        textArea2.setText("Unsorted Roman Numeral List" + "\n");
        textArea3.setText("Sorted Roman Numeral List:" + "\n");
        textArea1.setBackground(Color.GRAY);
        textArea2.setBackground(Color.cyan);
        textArea3.setBackground(Color.yellow);
        
        
        String line = inFile.readLine();
        while (line != null) {// while line is not null then read the line 
           
            StringTokenizer tn = new StringTokenizer(line, "," );   
            

            while (tn.hasMoreTokens()) {
                
                String word = tn.nextToken();
                if (!word.isEmpty() && isValidRomanNumeral(word)) {
                String name = new String(word);
                textArea1.append(word + "\n");
                //c+=name + "\n"; 
                
        
        
                a.add(name);// add name to unsorted list
                b.add(name);// add name to sorted list 
                }  
                else {
                    System.err.println("Invalid Roman Numeral: " + word);// error message for invalid Roman Numeral which is not I, V, X, L, C, D, or M
                }
            }
            line = inFile.readLine();
        }
               
            // settextArea(textArea1, textArea2, textArea3, a, b);
                 textArea2.append(a.toString());// print out the unsorted list that was read from the file
                 textArea3.append(b.toString());// print out the sorted list 
                    jframe.setVisible(true);
                   
            }
     
            
        }
    

    












































// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.*;
// import java.io.*;
// import java.util.StringTokenizer;

// public class FileMenuHandler implements ActionListener {
//    RomanNumeralGUI jframe;
//     ConvertMenuHandler convert;

//     public FileMenuHandler(RomanNumeralGUI gui, ConvertMenuHandler v) {
//         jframe=gui;
//         convert=v;

//     }

//     public void actionPerformed(ActionEvent event) {
//         String command  = event.getActionCommand();
//         if (command.equals("Open")) {
//             openFile();
//         } else if (command.equals("Quit")) {
//             System.exit(0);
//         }
            
       
//     }

//     private void openFile() {
//         JFileChooser chooser;
//         int status;
//         chooser = new JFileChooser();
//         status = chooser.showOpenDialog(null);
//         if (status == JFileChooser.APPROVE_OPTION)
//             readSource(chooser.getSelectedFile());
//         else
//             JOptionPane.showMessageDialog(null, "Open File dialog canceled");
//     }

//     private void readSource(File chosenFile) {
//         String chosenFileName=chosenFile.getAbsolutePath();
        
//         UnsortedRomanNumeralList a = new UnsortedRomanNumeralList();
//         SortedRomanNumeralList b = new SortedRomanNumeralList();
//         String c = "";
//         TextFileInput inFile = new TextFileInput(chosenFileName);
        
        
       
//         int subscript = 1;
//         Container myContentPane = jframe.getContentPane();
//         TextArea textArea1 = new TextArea();
//         TextArea textArea2 = new TextArea();
//         TextArea textArea3 = new TextArea();
//         textArea1.setEditable(false);
//         textArea2.setEditable(false);
//         textArea3.setEditable(false);
//         //TextArea mySubscripts = new TextArea();
//         myContentPane.add(textArea1, BorderLayout.EAST);
//         myContentPane.add(textArea2, BorderLayout.CENTER);
//         myContentPane.add(textArea3, BorderLayout.WEST);
//         textArea3.setText("Orginal Roman Numeral List:" + " \n");
//         textArea1.setText("Sorted Roman Numeral List:" + " \n");
//         textArea2.setText("Unsorted Roman Numeral List:" + " \n");
//          String line = inFile.readLine();
//         while (line != null) {
//            // String name = new String(word);
//            StringTokenizer tn = new StringTokenizer(line, ",");
           
//             // textArea3.append(Integer .toString(subscript++) + " " + word + "\n");
//             // textArea2.append(a.toString() + " " + name + "\n");

//            //a is the unsorted list from Project 3.java

//            while (tn.hasMoreTokens()) {   
            
          
                  
//             //Split the line by commas that are seperated by spaces 
//            String word = tn.nextToken();
//           // Split the line by commas that are seperated by spaces
//            String name = new String(word);
//            c+=name + "\n";
           



          
//            a.add(name);
//            b.add(name);
//            //System.out.println(a);//testing

//          //System.out.println(b);//testing
//            textArea3.append("\n"+c);
//         textArea2.append(a.toString());
//         textArea1.append(b.toString());

//            }

            

//             //b is the sorted list from Project 3.java

//             line = inFile.readLine();




//         }
//         jframe.setVisible(true);
//     }
// }

        

        


    



     




        


   





