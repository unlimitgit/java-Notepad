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
  
public class NoteBook {
	
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
		
		// Define the color and size of the panel 
		buttonPanel.setPreferredSize(new Dimension(30, 100));
		buttonPanel.setBackground(customGray);
		mainPanel.setPreferredSize(new Dimension(800, 100));
		mainPanel.setBackground(Color.white);
		messagePanel.setPreferredSize(new Dimension(30, 100));
		messagePanel.setBackground(customGray);
		
		// Add panels to frame
	    frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_START);
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		frame.getContentPane().add(messagePanel, BorderLayout.PAGE_END);
		
		frame.pack();
        frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
        new NoteBook();
	}
	
}

	