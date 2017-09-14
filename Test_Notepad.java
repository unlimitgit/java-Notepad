/* 
 * Test_Notepad.java 
 * 
 * Created on __DATE__, __TIME__ 
 */  
 
//package com.test;  
  
import java.awt.*;  
import java.io.*;  
import java.net.URI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
  
import javax.swing.JOptionPane;  
  
/** 
 * 
 * @author  __USER__ 
 */  
public class Test_Notepad extends javax.swing.JFrame {  
  
    /** Creates new form Test_Notepad */  
    public Test_Notepad(String name) {  
        super(name);  
        initComponents();		
        setLocation(250, 200);  
		setSize(500, 500);
    }  
  
    /** This method is called from within the constructor to 
     * initialize the form. 
     * WARNING: Do NOT modify this code. The content of this method is 
     * always regenerated by the Form Editor. 
     */  
    //GEN-BEGIN:initComponents  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">  
    private void initComponents() {  
  
        jScrollPane1 = new javax.swing.JScrollPane();  
        jTextArea1 = new javax.swing.JTextArea();  
        jMenuBar1 = new javax.swing.JMenuBar();  
        jMenu1 = new javax.swing.JMenu();  
        jMenuItem1 = new javax.swing.JMenuItem();  
        jMenuItem2 = new javax.swing.JMenuItem();  
        jMenuItem3 = new javax.swing.JMenuItem();  
        jMenuItem4 = new javax.swing.JMenuItem();  
        jSeparator1 = new javax.swing.JSeparator();  
        jSeparator2 = new javax.swing.JSeparator();  
        jMenuItem6 = new javax.swing.JMenuItem();  
        jMenu2 = new javax.swing.JMenu();  
        jMenuItem7 = new javax.swing.JMenuItem();  
        jMenuItem8 = new javax.swing.JMenuItem();  
        jMenuItem9 = new javax.swing.JMenuItem();  
        jMenuItem10 = new javax.swing.JMenuItem();  
        jMenuItem11 = new javax.swing.JMenuItem();  
  
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);  
		
		// Extract the string contents, and open the website page included by '[' ']'
		jTextArea1.addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (e.getButton() != MouseEvent.BUTTON1) {
               return;
            }
            if (e.getClickCount() != 2) {
               return;
            }

            int offset = jTextArea1.viewToModel(e.getPoint());

            try {
               int rowStart = Utilities.getRowStart(jTextArea1, offset);
               int rowEnd = Utilities.getRowEnd(jTextArea1, offset);
               String selectedLine = jTextArea1.getText().substring(rowStart, rowEnd);
               System.out.println(selectedLine);
			   String Website = StringExtract(selectedLine);
			   OpenWebsite(Website);

            } catch (BadLocationException e1) {
               e1.printStackTrace();
            }

         }
      });
	   
       
  
        jTextArea1.setColumns(40);  
        jTextArea1.setRows(5);  
        jScrollPane1.setViewportView(jTextArea1);  
		
		 // Set font 	  
	    Font font = new Font("Verdana", Font.BOLD, 12);
		jTextArea1.setFont(font);
		jTextArea1.setForeground(Color.BLUE);
		
		jTextArea1.append("Test 1;");
		
		jTextArea1.setForeground(Color.RED);
		jTextArea1.append("Test 2;");
		
  
        jMenu1.setText("\u6587\u4ef6");  
        jMenu1.setMinimumSize(new java.awt.Dimension(70, 50));  
  
        jMenuItem1.setText("\u65b0\u5efa");  
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                jMenuItem1ActionPerformed(evt);  
            }  
        });  
        jMenu1.add(jMenuItem1);  
  
        jMenuItem2.setText("\u6253\u5f00");  
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                jMenuItem2ActionPerformed(evt);  
            }  
        });  
        jMenu1.add(jMenuItem2);  
  
        jMenuItem3.setText("\u4fdd\u5b58");  
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                jMenuItem3ActionPerformed(evt);  
            }  
        });  
        jMenu1.add(jMenuItem3);  
  
        jMenuItem4.setText("\u53e6\u5b58\u4e3a");  
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                jMenuItem4ActionPerformed(evt);  
            }  
        });  
        jMenu1.add(jMenuItem4);  
        jMenu1.add(jSeparator1);  
        jMenu1.add(jSeparator2);  
  
        jMenuItem6.setText("\u9000\u51fa");  
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {  
            public void actionPerformed(java.awt.event.ActionEvent evt) {  
                jMenuItem6ActionPerformed(evt);  
            }  
        });  
        jMenu1.add(jMenuItem6);  
  
       jMenuBar1.add(jMenu1);  
  
        jMenu2.setText("\u7f16\u8f91");  
  
        jMenuItem7.setText("\u64a4\u9500");  
        jMenu2.add(jMenuItem7);  
  
        jMenuItem8.setText("\u526a\u5207");  
        jMenu2.add(jMenuItem8);  
  
        jMenuItem9.setText("\u590d\u5236");  
        jMenu2.add(jMenuItem9);  
  
        jMenuItem10.setText("\u7c98\u8d34");  
        jMenu2.add(jMenuItem10);  
  
        jMenuItem11.setText("\u5220\u9664");  
        jMenu2.add(jMenuItem11);  
  
        jMenuBar1.add(jMenu2);  
  
        setJMenuBar(jMenuBar1);  
  
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(  
                getContentPane());  
        getContentPane().setLayout(layout);  
        layout.setHorizontalGroup(layout.createParallelGroup(  
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(  
                jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400,  
                Short.MAX_VALUE));  
        layout.setVerticalGroup(layout.createParallelGroup(  
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(  
                jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279,  
                Short.MAX_VALUE));  
  
        pack();  
    }// </editor-fold>  
    //GEN-END:initComponents  
	
	public static String  StringExtract(String str) { 		
		String result = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
		return result;	     
	}
	
	public static void OpenWebsite(String str) {
		URI uri = URI.create(str);
		try{
			java.awt.Desktop.getDesktop().browse(uri);
		}catch(IOException e){
		
		}
	}
  
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {  
        // TODO add your handling code here:  
        jTextArea1.setText(null);  
    }  
  
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {  
        // TODO add your handling code here:  
            FileDialog fd = new FileDialog(this, "另存为", FileDialog.SAVE);  
            fd.setVisible(true);  
            String string1 = jTextArea1.getText();  
            String stringfile = fd.getDirectory()+fd.getFile();  
            BufferedWriter bWriter = null;  
            try {  
                bWriter = new BufferedWriter(new FileWriter(stringfile));  
                bWriter.write(string1);   
                bWriter.close();   
            } catch (Exception e) {  
                // TODO Auto-generated catch block  
                System.out.println("保存失败");  
            }   
    }  
  
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {  
        // TODO add your handling code here:  
        String FileName = JOptionPane.showInputDialog("请输入保存的文件名：");  
        String string1 = jTextArea1.getText();  
        if (FileName != null) {  
            BufferedWriter bWriter = null;  
            try {  
                bWriter = new BufferedWriter(new FileWriter(new File(FileName)));  
                bWriter.write(string1);  
                bWriter.close();  
            } catch (Exception e) {  
                System.out.println("保存失败");  
            }  
        }  
    }  
  
    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {  
        // TODO add your handling code here:  
        int result = JOptionPane.showConfirmDialog(null, "退出前是否保存？");  
        if (result == JOptionPane.YES_OPTION) {  
            String FileName = JOptionPane.showInputDialog("请输入保存的文件名：");  
            String string1 = jTextArea1.getText();  
            if (FileName != null) {  
                BufferedWriter bWriter = null;  
                try {  
                    bWriter = new BufferedWriter(new FileWriter(new File(  
                            FileName)));  
                    bWriter.write(string1);  
                    bWriter.close();  
                } catch (Exception e) {  
                    System.out.println("保存失败");  
                }  
            }  
            System.exit(0);  
        } else if (result == JOptionPane.NO_OPTION) {  
            System.exit(0);  
        }  
    }  
  
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {  
        // TODO add your handling code here:  
        FileDialog fd = new FileDialog(this, "打开", FileDialog.LOAD);  
        fd.setVisible(true);  
        String strFile = fd.getDirectory() + fd.getFile();  
        if (strFile != null) {  
            try {  
                FileInputStream fis = new FileInputStream(strFile);  
                byte[] buf = new byte[10 * 1024];  
                int len = fis.read(buf);  
                jTextArea1.append(new String(buf, 0, len));  
                fis.close();  
            } catch (Exception e) {  
                System.out.println("打开失败");  
            }  
        }  
    }  
  
    public void SaveNotepad() {  
        String FileName = JOptionPane.showInputDialog("请输入保存的文件名：");  
        String string1 = jTextArea1.getText();  
        if (FileName != null) {  
            BufferedWriter bWriter = null;  
            try {  
                bWriter = new BufferedWriter(new FileWriter(new File(FileName)));  
                bWriter.write(string1);  
                bWriter.close();  
                //              Thread.sleep(1000);  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    /** 
     * @param args the command line arguments 
     */  
    public static void main(String args[]) {  
        java.awt.EventQueue.invokeLater(new Runnable() {  
            public void run() {  
                Test_Notepad notepad = new Test_Notepad("决Jue的记事本");  
                notepad.setVisible(true);  
            }  
        });  
    }  
  
    //GEN-BEGIN:variables  
    // Variables declaration - do not modify  
    private javax.swing.JMenu jMenu1;  
    private javax.swing.JMenu jMenu2;  
    private javax.swing.JMenuBar jMenuBar1;  
    private javax.swing.JMenuItem jMenuItem1;  
    private javax.swing.JMenuItem jMenuItem10;  
    private javax.swing.JMenuItem jMenuItem11;  
    private javax.swing.JMenuItem jMenuItem2;  
    private javax.swing.JMenuItem jMenuItem3;  
    private javax.swing.JMenuItem jMenuItem4;  
    private javax.swing.JMenuItem jMenuItem6;  
    private javax.swing.JMenuItem jMenuItem7;  
    private javax.swing.JMenuItem jMenuItem8;  
    private javax.swing.JMenuItem jMenuItem9;  
    private javax.swing.JScrollPane jScrollPane1;  
    private javax.swing.JSeparator jSeparator1;  
    private javax.swing.JSeparator jSeparator2;  
    private javax.swing.JTextArea jTextArea1;  
    // End of variables declaration//GEN-END:variables  
  
}  