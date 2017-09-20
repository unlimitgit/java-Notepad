/*
Create a java script to test JTextArea and JTextPane.
Edit in the JTextArea. After pressing save button, display the contents in JTextPane
Origin date: 09/20/2017
*/

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class TextAreaPane {
	
   static boolean paneArea = false ;
   
   public TextAreaPane() throws BadLocationException {
		JFrame frame = new JFrame();
		JTextArea area = new JTextArea();
		JTextPane pane = new JTextPane();
        JPanel mainPanel = new JPanel();
		String buttonDisplay = "Save";
		JButton button = new JButton(buttonDisplay);
        button.setPreferredSize(new Dimension(100, 40));
		mainPanel.add(button);
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        area.setPreferredSize(new Dimension(200, 200));		
		JScrollPane paneScrollPane = new JScrollPane(area);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));        
        frame.getContentPane().add(paneScrollPane, BorderLayout.CENTER);
		  frame.getContentPane().add(mainPanel, BorderLayout.WEST);
      
		
		pane.setPreferredSize(new Dimension(200, 200));	
		JScrollPane paneScrollPane1 = new JScrollPane(pane);
        paneScrollPane1.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane1.setPreferredSize(new Dimension(250, 155));
        paneScrollPane1.setMinimumSize(new Dimension(10, 10));
        frame.getContentPane().add(paneScrollPane1, BorderLayout.CENTER);
      
		
		area.setVisible(true);
		pane.setVisible(false);
		
		button.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 
		  
		    int lines = area.getLineCount();
			area.setVisible(false);	
		    pane.setVisible(true);
			
			try{// Traverse the text in the JTextArea line by line
				for(int i = 0; i < lines; i ++){
					int start = area.getLineStartOffset(i);
					int end = area.getLineEndOffset(i);
					// Implement method processLine
					Document doc = pane.getDocument();
					doc.insertString(doc.getLength(), area.getText(start, end-start), null);
					System.out.println(area.getText(start, end-start));

				}
			}catch(BadLocationException e){
				// Handle exception as you see fit
			}
			
			
			} 
		} );
		
		
		
		frame.pack();
        frame.setVisible(true);
	
   }
   
    
   
  
   
   public static void main(String[] args) throws BadLocationException {
        new TextAreaPane();
    }

}