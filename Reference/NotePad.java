import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.*;

public class NotePad  {
	
	boolean textEditable = true;
	

    public NotePad() throws BadLocationException {	
		
		String fileName = "write.txt";
		
		Color mygray = new Color(245, 245, 245); 
        JFrame frame = new JFrame();
        DefaultStyledDocument document = new DefaultStyledDocument();
        JTextPane pane = new JTextPane(document);
        JPanel mainPanel = new JPanel();
        JButton buttonSaveEdit = new JButton("Save");
		
		GridLayout layout = new GridLayout(10,1);
		mainPanel.setLayout(layout);
		
        buttonSaveEdit.setPreferredSize(new Dimension(100, 40));
		JButton buttonLoad = new JButton("Load");
		buttonLoad.setPreferredSize(new Dimension(100, 40));
		buttonLoad.setMaximumSize(new Dimension(100, 40));
		buttonLoad.setMinimumSize(new Dimension(100, 40));
		
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane.setPreferredSize(new Dimension(200, 200));
		JScrollPane paneScrollPane = new JScrollPane(pane);
        paneScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        paneScrollPane.setPreferredSize(new Dimension(250, 155));
        paneScrollPane.setMinimumSize(new Dimension(10, 10));
        mainPanel.add(buttonSaveEdit);
		mainPanel.add(buttonLoad);
        frame.getContentPane().add(paneScrollPane, BorderLayout.CENTER);
        frame.getContentPane().add(mainPanel, BorderLayout.WEST);
		
		
		
		// Extract the string contents, and open the website page included by '[' ']'
		pane.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
               return;
            }
            if (e.getClickCount() != 2) {
               return;
            }

            int offset = pane.viewToModel(e.getPoint());

            try {
               int rowStart = Utilities.getRowStart(pane, offset);
               int rowEnd = Utilities.getRowEnd(pane, offset);
               String selectedLine = pane.getText().substring(rowStart, rowEnd);
               System.out.println(selectedLine);
			   // String Website = StringExtract(selectedLine);
			   // OpenWebsite(Website);

            } catch (BadLocationException e1) {
               e1.printStackTrace();
            }

         }
      });
		
        StyleContext context = new StyleContext();
        // build a style
        Style style = context.addStyle("NotePad", null);
        // set some style properties
		 StyleConstants.setFontSize(style, 20);
        StyleConstants.setForeground(style, Color.BLACK);
		StyleConstants.setFontFamily(style, "Arial");
		 //StyleConstants.setFont(style, "Arial");
        document.insertString(0, "Four: success \n", style);
        //StyleConstants.setForeground(style, Color.RED);
        document.insertString(0, "Three: error \n", style);
        //document.insertString(0, "Two: error \n", style);

        //StyleConstants.setForeground(style, Color.BLACK);
        // add some data to the document
       // document.insertString(0, "One: success \n", style);
	   
	   
		
		

		
		buttonSaveEdit.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 	  
			//int lines = pane.getLineCount();
			if (textEditable){
				textEditable = false;
				buttonSaveEdit.setText("Edit");
				pane.setBackground(mygray);
				pane.setEditable(false);
			} else {
				textEditable = true;
				buttonSaveEdit.setText("Save");
				pane.setEditable(true);
				pane.setBackground(Color.white);
			}
			
			try {
			String content = pane.getDocument().getText(0, pane.getDocument().getLength());
			
			int indexStart = 0;
			int indexEnd = content.indexOf("\n");
			String contDisp = "";
			int offset = 0;
			
			pane.setText("");
			
			ProcResult result = new ProcResult();
			while (indexEnd != -1){
				
				contDisp = content.substring(indexStart,indexEnd);
				if (contDisp.length() > 1){
					result = procString(contDisp);
					System.out.println(result.dispStr + "  " + result.returnCode);
				}
				
				indexStart = indexEnd + 1;
				indexEnd = content.indexOf("\n", indexEnd+1);
				
				if ( result.returnCode == 2){
					StyleConstants.setForeground(style, Color.RED);
				} else {
					StyleConstants.setForeground(style, Color.BLACK);
				}
				
				document.insertString(pane.getDocument().getLength(), result.dispStr+"\n", style);
			}
			int contLen = content.length();
			//System.out.println("indexStart = " + indexStart + "contLen = " + contLen );
			if (indexStart < contLen){
				contDisp = content.substring(indexStart,indexEnd);
				//System.out.println(contDisp + indexStart );
			}
			
			
			// System.out.println(content);
			// int i = pane.getDocument().getLength();
			// System.out.println(i);
			
			 try {
            FileWriter fileWriter =
                new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write(content);
           
            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }	
			} 
			catch (BadLocationException ee) {
				//handle exception
			}	
	
			  } 
		} );
		
		
		// Open file and display in the JTextPane
		 buttonLoad.addActionListener(new java.awt.event.ActionListener(){ 
		  public void actionPerformed(java.awt.event.ActionEvent evt) { 	  
				FileDialog fd = new FileDialog(frame, "open", FileDialog.LOAD);  
				fd.setVisible(true);  
				String strFile = fd.getDirectory() + fd.getFile();  
				//System.out.println(strFile);
				String line = null;
				String content = "";
				if (strFile != null) {  
					try {  
						 pane.setText("");
						 FileReader fileReader = new FileReader(strFile);
						BufferedReader bufferedReader = new BufferedReader(fileReader); 
						  while((line = bufferedReader.readLine()) != null) {
								content = content + line + "\n";
								// i = i + 1;
								// document.insertString(i, line, style);
								// document.insertString(i, "\n", style);
							}   
						document.insertString(0, content, style);
						
						 bufferedReader.close();      
					} catch (Exception e) {  
						System.out.println("open fail");  
					}  
				}  
			  } 
		} );



        //  StyleConstants.setForeground(style, Color.blue);

        frame.pack();
        frame.setVisible(true);

    }
	
	public class ProcResult {
			int returnCode;
			String dispStr;    // etc
		}
		
	public ProcResult procString(String content) {
			ProcResult result = new ProcResult();
			result.dispStr = content;
			
			if (content.substring(0,1).compareTo("[") == 0){
				result.returnCode = 2;
				result.dispStr = removeCharAt(result.dispStr,"[");
				result.dispStr = removeCharAt(result.dispStr,"]");
			} else {
				result.returnCode = 1;
				result.dispStr = "Disp";
			}
			
			//System.out.println(content.substring(0,1).compareTo("["));  
			// result.returnCode = 1;
			// result.dispStr = "Disp";
			
			return result;
		
		}
		
	public static String removeCharAt(String s, String h) {
		int index = s.indexOf(h);
		String result = s;
		while (index != -1){
			if (index != (result.length()-1)){
				result = result.substring(0,index) + result.substring(index+1);
			} else {
				result = result.substring(0,index);
			}
		index = result.indexOf(h);
		}	
		return result;			
   }
	

    public static void main(String[] args) throws BadLocationException {
        new NotePad();
    }
}