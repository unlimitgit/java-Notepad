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
  
public class NoteBook {
	
	// Define parameters
	boolean searchVisible = true;
	
	public NoteBook() {
		
		
		
		// Define its own color
		Color customGray = new Color(245, 245, 245); 
		
		// Create frame as main display interface
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//Create TextPane
		DefaultStyledDocument document = new DefaultStyledDocument();
        JTextPane textPane = new JTextPane(document);
		
		//Create button panel, mainPanel, and message Panel
		//Refer to readme.docx for further information
		JPanel buttonPanel = new JPanel();
		JPanel mainPanel = new JPanel();
		JPanel messagePanel = new JPanel();
		JPanel searchPanel = new JPanel();
		
			
		// Define the color and size of the panel 
		buttonPanel.setPreferredSize(new Dimension(30, 100));
		buttonPanel.setBackground(customGray);
		mainPanel.setPreferredSize(new Dimension(800, 100));
		mainPanel.setBackground(Color.white);
		searchPanel.setPreferredSize(new Dimension(800, 50));
		searchPanel.setBackground(Color.YELLOW);
		messagePanel.setPreferredSize(new Dimension(30, 100));
		messagePanel.setBackground(customGray);
		
		// Add buttons	
		JButton buttonSaveEdit = new JButton("Save");
		JButton buttonSearch = new JButton("Disable search");
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(buttonSaveEdit);
		buttonPanel.add(buttonSearch);
		buttonSaveEdit.setAlignmentX(Component.LEFT_ALIGNMENT);
		buttonSearch.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Add panels to frame
	    frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		frame.getContentPane().add(searchPanel, BorderLayout.LINE_END);
		frame.getContentPane().add(messagePanel, BorderLayout.PAGE_END);
		
		frame.pack();
        frame.setVisible(true);
		
		// Enable/disable search result panel, controlled by buttonSearch
		buttonSearch.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 
				if (searchVisible){
					searchVisible = false;
					buttonSearch.setText("Enable search");
					frame.getContentPane().remove(searchPanel); 
				} else {
					searchVisible = true;
					buttonSearch.setText("Disable search");
					frame.getContentPane().add(searchPanel, BorderLayout.LINE_END); 					
				}
				
				frame.invalidate();
                frame.validate();				
			  } 
		} );
		
		
		
	}
	
	public static void main(String[] args) {
        new NoteBook();
	}
	
}

	