#Project 3
Project info-
Use a GUI to open the file for displaying the Roman numerals 
Modify your RomanNumeralGUI so that it will be a complete JFrame with a menu bar and menus. 
There should be two menus: one called File and another called Convert. The File menu should have 
the menu items Open and Quit. The  Convert menu should have one menu item that says “Roman to 
Arabic”. When chosen, a dialog box should be displayed asking the user to type in a Roman numeral. 
After receiving the Roman numeral, another dialog box should display the Arabic value. If the Roman 
numeral is not valid (see below) a dialog box should say so. 
You will need a handler for the File menu, and another handler for the Convert menu. As mentioned in 
lecture, be sure when opening a file with the file menu handler that your ask for the absolute path to the 
file rather than just its file name (getAbsolutePath() rather than getName()). 
Create an exception for illegal Roman numerals 
Create a class called IllegalRomanNumeralException that extends IllegalArgumentException as shown 
in lecture. This exception should be thrown by the constructor of a RomanNumeral if there is an invalid 
character (e.g., not M,D,X, etc.) in the Roman numeral. Illegal Roman numerals should be printed to 
the console, not placed in the GUI. This exception may be thrown when constructing a Roman numeral 
read from the file, or when trying to convert from Roman to Arabic.
