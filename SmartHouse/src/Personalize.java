/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 05 March 2015
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Personalize extends JPanel {

	public House m_House;
	public Login m_Login;

	public Personalize(){
		
		//Make username and password frame and pane
		JFrame frameUNPW = new JFrame("Username and Password");
		JPanel panelUNPW = new JPanel();
		
		//Create button, textfields, and labels
		JButton buttonSave = new JButton("Save");
		JLabel labelUsername = new JLabel("Username:");
		JLabel labelPassword = new JLabel("Password:");
		JTextField textfieldUsername = new JTextField(20);
		JTextField textfieldPassword = new JTextField(20);
		
		//Set layout for pane
		panelUNPW.setLayout(new FlowLayout());
		
		//Add labels, textfields, and button to pane in flow order
		panelUNPW.add(labelUsername);
		panelUNPW.add(textfieldUsername);
		panelUNPW.add(labelPassword);
		panelUNPW.add(textfieldPassword);
		panelUNPW.add(buttonSave);
		
		//Add pane to frame
		frameUNPW.getContentPane().add(panelUNPW);
		
		//Set size of size, location, and visibility of frameUNPW
		frameUNPW.setSize(287, 125);
		frameUNPW.setLocationRelativeTo(null);
		frameUNPW.setVisible(true);
		
		//Create listener for save button
		buttonSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Move to new GUI
				addHouse();
				
				//Hide username and password GUI
				frameUNPW.setVisible(false);
				
				//Save username and password in datase
			}
		});
	}

	public void finalize() throws Throwable {

	}
	public void add(){

	}

	public void addFloors(){

	}

	public static void addHouse(){
		
		//Make addHouse GUI with House tab and pane
		JFrame framePersonalize = new JFrame("Personalize");
		JTabbedPane panePersonalize = new JTabbedPane();
		JPanel panelHouse = new JPanel();
		
		//Create button, textfields and labels
		JButton buttonAddFloor = new JButton("Add Floor");
		JButton buttonSaveHouse = new JButton("Save");
		JButton buttonChange = new JButton("Change House Name");
		JLabel labelHouseName = new JLabel("House Name:");
		JTextField textfieldHouseName = new JTextField(20);
		
		//Set layout for panel
		panelHouse.setLayout(new FlowLayout());
		
		//Set bounds and add buttons textfields and labels to pane
		panelHouse.add(labelHouseName);
		panelHouse.add(textfieldHouseName);
		panelHouse.add(buttonSaveHouse);
				
		//Add tab with house panel
		panePersonalize.addTab("House", panelHouse);
		
		//Add tab pane to frame
		framePersonalize.getContentPane().add(panePersonalize);
		
		//Set size, location, and visibility of pane
		framePersonalize.pack();
		framePersonalize.setLocationRelativeTo(null);
		framePersonalize.setVisible(true);
		
		//Listener for save button
		buttonSaveHouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Adjust House pane 
				
				//Create Panel for the Floor tab and set it as the index
				JPanel panelFloor = new JPanel();
				panePersonalize.addTab("Floors", panelFloor);
				panePersonalize.setSelectedIndex(1);
			}
		});
	}

	public void remove(){

	}
}//end Personalize