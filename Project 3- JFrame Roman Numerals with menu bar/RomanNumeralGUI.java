//wordgui.java
import java.awt.Color;
import javax.swing.*;

public class RomanNumeralGUI extends JFrame {

    public RomanNumeralGUI(String title, int height, int width ) {// constructor for RomanNumeralGUI class     
        setTitle(title);
        setSize(height, width);
        setLocation(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        createMenuBar();
        setVisible(true);
    }

    private void createMenuBar() {
        ConvertMenuHandler rss = new ConvertMenuHandler(this);// Create ConvertMenuHandler object 
        FileMenuHandler fmh = new FileMenuHandler(this, rss);// Create FileMenuHandler object   
        
        // Create file menu and add menu items
        JMenu fileMenu = new JMenu("File");// Create file menu
        fileMenu.setForeground(Color.red);
        JMenuItem item = new JMenuItem("Open");// Create menu item
        item.setBackground(Color.pink);
        item.addActionListener(fmh);// Add action listener to menu item 
        fileMenu.add(item);
        fileMenu.addSeparator();
        item = new JMenuItem("Quit");// Create menu item  
        item.setBackground(Color.GRAY);
        item.addActionListener(fmh);
        fileMenu.add(item);

        // Create convert menu and add menu items
        JMenu convertMenu = new JMenu("Convert");// Create convert menu  
        convertMenu.setForeground(Color.ORANGE);
        item = new JMenuItem("Roman to Arabic");// Create menu item 
        item.setBackground(Color.CYAN);
        item.addActionListener(rss);
        convertMenu.add(item);

        // Create menu bar and add menus
        JMenuBar menuBar = new JMenuBar();// Create menu bar 
        menuBar.add(fileMenu);
        menuBar.add(convertMenu);
        setJMenuBar(menuBar);
    }
}
