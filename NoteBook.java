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
  
public class NoteBook {
	
	// Define parameters
	boolean searchVisible = false;  		// Related to search engine
	boolean textEditable = true;			// The main panel editable or not
	
	public NoteBook() {
			
		// Define its own color
		Color customGray = new Color(230, 230, 230); 
		
		// Create frame as main display interface
		String textFrame = "Notebook with Java";
		JFrame frame = new JFrame(textFrame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon imgIcon = new ImageIcon("icon.jpg");
		frame.setIconImage(imgIcon.getImage());
			
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
		DefaultStyledDocument textDoc = new DefaultStyledDocument();
        JTextPane textPane = new JTextPane(textDoc);
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
		buttonSearch.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 
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
		buttonTest.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 
				frame.setTitle("Test");			
			  } 
		} );
		
		
	}
	
	public static void main(String[] args) {
        new NoteBook();
	}
	
}

	