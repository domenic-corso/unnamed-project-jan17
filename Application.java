import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import java.awt.Font;

public class Application {

    public static void main (String[] args) {
    	try{
    		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    		init();
    	}catch(Exception e){
    		System.out.println("Cannot load frame");
    	}
    }

    	private static void init(){
    		JFrame frame = new JFrame(); 
        	JButton button = new JButton("Save File");
        	button.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					fileSave();
				}
        		
        	});
        	JTextField text = new JTextField();
        	text.setToolTipText("Enter a question here");
        	frame.getContentPane().add(text);
        	text.setBounds(74,84,318,71);
        	
        	JLabel lbl = new JLabel("TEACH YOURSELF");
        	lbl.setFont(new Font("Tahoma", Font.BOLD, 15));
        	lbl.setHorizontalAlignment(SwingConstants.CENTER);
        	frame.getContentPane().add(lbl);
        	lbl.setBounds(115,11,245,71);
        	
        	button.setBounds(180,198,100, 40);
        	frame.getContentPane().add(button);
        	
        	frame.setSize(500,500);
        	frame.getContentPane().setLayout(null);
        	frame.setVisible(true);
        	
    	}
    	
    	public static void fileSave(){
    		// parent component of the dialog
    		JFrame parentFrame = new JFrame();
    		 
    		JFileChooser fileChooser = new JFileChooser();
    		fileChooser.setDialogTitle("Specify a file to save");   
    		 
    		int userSelection = fileChooser.showSaveDialog(parentFrame);
    		 
    		if (userSelection == JFileChooser.APPROVE_OPTION) {
    		    File fileToSave = fileChooser.getSelectedFile();
    		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
    		    try(FileWriter fw = new FileWriter(fileToSave+".txt")) {
    					fw.write("Testing");
    		    } catch (IOException efile) {
    				efile.printStackTrace();
    			}
    		}
    	}
}
