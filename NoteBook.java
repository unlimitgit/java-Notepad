/*
The Notebook in java for real development.
*/  

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.FileDialog;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.BufferedReader;

import javax.swing.text.*;
  
public class NoteBook {
	
	// Define parameters
	boolean searchVisible = false;  		// Related to search engine
	boolean textEditable = true;			// The main panel editable or not
	
	JFrame frame ;
	JTextPane textPane;
	DefaultStyledDocument textDoc;  
	Style style;
	
	private NoteBook()  {
			
		// Define its own color
		Color customGray = new Color(230, 230, 230); 
		
		// Create frame as main display interface
		String textFrame = "Notebook with Java";
		frame = new JFrame(textFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imgIcon = new ImageIcon("icon.jpg");
		frame.setIconImage(imgIcon.getImage());
		
		//Create Menubar
		JMenuBar menuBar = createMenuBar();
		frame.setJMenuBar(menuBar);
		
		//Create button panel, mainPanel, and message Panel
		//Refer to readme.docx for further information
		JPanel buttonPanel = new JPanel();		
			
		// Add buttons
        JButton buttonSaveEdit = new JButton("Save");
		JButton buttonSearch = new JButton("Enable search");
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(buttonSaveEdit);
		buttonPanel.add(buttonSearch);
		buttonSaveEdit.setAlignmentX(Component.LEFT_ALIGNMENT);
		buttonSearch.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		// This button is only for temporary test, will remove in the official version.
		JButton buttonTest = new JButton("Test");
		buttonPanel.add(buttonTest);
		buttonTest.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		
		// Add textpane and searchPane
		textDoc = new DefaultStyledDocument();
        textPane = new JTextPane(textDoc);
		textPane.setPreferredSize(new Dimension(800, 100));
		JScrollPane textScrollPane = new JScrollPane(textPane);
        textScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        textScrollPane.setPreferredSize(new Dimension(250, 155));
        textScrollPane.setMinimumSize(new Dimension(10, 10));
		
		DefaultStyledDocument searchDoc = new DefaultStyledDocument();
        JTextPane searchPane = new JTextPane(searchDoc);
		searchPane.setPreferredSize(new Dimension(800, 100));
		searchPane.setBackground(customGray);
		JScrollPane searchScrollPane = new JScrollPane(searchPane);
        searchScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        searchScrollPane.setPreferredSize(new Dimension(250, 155));
        searchScrollPane.setMinimumSize(new Dimension(10, 10));
		searchPane.setEditable(false);
		
		DefaultStyledDocument messageDoc = new DefaultStyledDocument();
        JTextPane messagePane = new JTextPane(messageDoc);
		//messagePane.setPreferredSize(new Dimension(100, 100));
		messagePane.setBackground(customGray);
		messagePane.setEditable(false);
		
		
		// Add panels to frame
	    frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(textScrollPane, BorderLayout.CENTER);
		//frame.getContentPane().add(searchScrollPane, BorderLayout.LINE_END);
		frame.getContentPane().add(messagePane, BorderLayout.PAGE_END);
		
		frame.pack();
        frame.setVisible(true);
		
		// Enable/disable search result panel, controlled by buttonSearch
		buttonSearch.addActionListener(new ActionListener(){ 
		  public void actionPerformed(ActionEvent evt) { 
				if (searchVisible){
					searchVisible = false;
					buttonSearch.setText("Enable search");
					frame.getContentPane().remove(searchScrollPane); 
				} else {
					searchVisible = true;
					buttonSearch.setText("Disable search");
					frame.getContentPane().add(searchScrollPane, BorderLayout.LINE_END); 					
				}
				
				frame.invalidate();
                frame.validate();				
			  } 
		} );
		
		// This button is only for temporary test, will remove in the official version.
		buttonTest.addActionListener(new ActionListener(){ 
		  public void actionPerformed(ActionEvent evt) { 
				frame.setTitle("Test");			
			  } 
		} );
		
		
	}
	
	public JMenuBar createMenuBar() {
		// Create Menu
		JMenuBar menuBar = new JMenuBar();
		
		//Build file menu
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		//New file
        JMenuItem menuItemNew = new JMenuItem("New Notebook");
        menuItemNew.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
                menuItemNewActionPerformed(evt);  
            }  
        });  
        menuFile.add(menuItemNew);
		
		//Load file
        JMenuItem menuItemLoad = new JMenuItem("Load Notebook");
        menuItemLoad.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
               menuItemLoadActionPerformed(evt);  
            }  
        });  
        menuFile.add(menuItemLoad);
		
		menuFile.addSeparator();
		
		//Exit system
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent evt) {  
               menuItemExitActionPerformed(evt);  
            }  
        });  
        menuFile.add(menuItemExit);
		
		
		//Build edit menu
		JMenu menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);

        		
		return menuBar;
	}
	
	private void menuItemNewActionPerformed(ActionEvent evt) {  
        // TODO add your handling code here:  
        
    }  
	
	private void menuItemLoadActionPerformed(ActionEvent evt) {  
        // TODO add your handling code here:  
		FileDialog fd = new FileDialog(frame, "Open", FileDialog.LOAD);  
        fd.setVisible(true);  
        String strFile = fd.getDirectory() + fd.getFile(); 		
		String line = null;
        if (strFile != null) {  
            try {  
                textPane.setText("");
				FileReader fileReader = new FileReader(strFile);
				BufferedReader bufferedReader = new BufferedReader(fileReader); 
				while((line = bufferedReader.readLine()) != null) {
						textDoc.insertString(textPane.getDocument().getLength(), line+"\n", style);
					}   
				bufferedReader.close();      
            } catch (Exception e) {  
               
            }  
        }  
        
    }  
	
	private void menuItemExitActionPerformed(ActionEvent evt) {  
        // TODO add your handling code here:  
       System.exit(0);   // Exit the whole system.
    }  
	
	public static void main(String[] args) {
        new NoteBook();
	}
	
}

	