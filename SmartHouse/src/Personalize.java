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
	public Personalize() {
	
/*
		public House m_House;
		public Login m_Login;
		
		//Make username and password frame and pane
		JFrame frameUNPW = new JFrame("Username and Password");
		JPanel panelUNPW = new JPanel();
		
		//Create button, textfields, and labels
		JButton buttonSave = new JButton("Save");
		JLabel labelUsername = new JLabel("Username:");
		JLabel labelPassword = new JLabel("Password:");
		JTextField textfieldUsername = new JTextField(20);
		JTextField textfieldPassword = new JTextField(20);
		SpringLayout sl_panelUNPW = new SpringLayout();
		
		//Adjust Placement of components
		sl_panelUNPW.putConstraint(SpringLayout.WEST, buttonSave, 196, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, textfieldUsername);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, labelPassword, 0, SpringLayout.EAST, labelUsername);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, labelUsername, -6, SpringLayout.WEST, textfieldUsername);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, labelPassword, 6, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, textfieldUsername, 8, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, textfieldUsername, -12, SpringLayout.NORTH, textfieldPassword);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, textfieldPassword, 87, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, labelUsername, 6, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, textfieldUsername, 87, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, buttonSave, 93, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, textfieldUsername, -10, SpringLayout.EAST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, textfieldPassword, -10, SpringLayout.EAST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, textfieldPassword, 38, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, buttonSave, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, labelPassword, 34, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, labelPassword, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, labelUsername, 0, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, labelUsername, 34, SpringLayout.NORTH, panelUNPW);
		panelUNPW.setLayout(sl_panelUNPW);
		
		//Add labels, textfields, and button to pane in flow order
		panelUNPW.add(labelUsername);
		panelUNPW.add(textfieldUsername);
		panelUNPW.add(labelPassword);
		panelUNPW.add(textfieldPassword);
	
		JLabel label = new JLabel("");
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, label, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, label, 102, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, label, 137, SpringLayout.WEST, panelUNPW);
		panelUNPW.add(label);
		panelUNPW.add(buttonSave);
	
		//Add pane to frame
		frameUNPW.getContentPane().add(panelUNPW);
	
		//Set size of size, location, and visibility of frameUNPW
		frameUNPW.setSize(323, 142);
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
		});*/
		
		//Make addHouse GUI with House tab and pane
		JFrame framePersonalize = new JFrame("Personalize");
		JTabbedPane panePersonalize = new JTabbedPane();
		JPanel panelHouse = new JPanel();
		
		//Create button, textfields and labels
		JButton buttonSaveHouse = new JButton("Save");
		JLabel labelHouseName = new JLabel("House Name:");
		JTextField textfieldHouseName = new JTextField(20);
		
		//Set layout for panel
		panelHouse.setLayout(new FlowLayout());
		
		JButton buttonChange = new JButton("Change House Name");
		panelHouse.remove(textfieldHouseName);
		panelHouse.remove(buttonSaveHouse);
		panelHouse.remove(labelHouseName);
		panelHouse.add(new JLabel("House Name: "));
		panelHouse.add(new JLabel("nameHouse"));
		panelHouse.add(buttonChange);
		
		JLabel labelFloorName = new JLabel("Floor Name:");
		JTextField textfieldFloorName = new JTextField(20);
		JButton buttonAddFloor = new JButton("Add Floor");
		JPanel panelFloor = new JPanel();
		panePersonalize.addTab("Floors", panelFloor);
		panePersonalize.setSelectedIndex(1);
		panelFloor.setLayout(new FlowLayout());
		panelFloor.add(labelFloorName);
		panelFloor.add(textfieldFloorName);
		panelFloor.add(buttonAddFloor);
		
		//Add buttons text fields and labels to pane
/*		panelHouse.add(labelHouseName);
		panelHouse.add(textfieldHouseName);
		panelHouse.add(buttonSaveHouse);*/
			
		//Add tab with house panel
		panePersonalize.addTab("House", panelHouse);
		
		//Add tab pane to frame
		framePersonalize.getContentPane().add(panePersonalize);
		
		//Set size, location, and visibility of pane
		framePersonalize.pack();
		framePersonalize.setLocationRelativeTo(null);
		framePersonalize.setVisible(true);
	}

	public void finalize() throws Throwable {

	}

	public static void addFloor(JFrame framePersonalize, JTabbedPane panePersonalize){
		
		//Adjust floor panel
		JPanel panelRoom = new JPanel();
		panePersonalize.addTab("Rooms", panelRoom);
		panePersonalize.setSelectedIndex(2);
	}

	public static void addHouse(){
		
		//Make addHouse GUI with House tab and pane
		JFrame framePersonalize = new JFrame("Personalize");
		JTabbedPane panePersonalize = new JTabbedPane();
		JPanel panelHouse = new JPanel();
		
		//Create button, text fields and labels
		JButton buttonSaveHouse = new JButton("Save");
		JLabel labelHouseName = new JLabel("House Name:");
		JTextField textfieldHouseName = new JTextField(20);
		
		//Set layout for panel
		panelHouse.setLayout(new FlowLayout());
		
		//Add buttons text fields and labels to pane
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
				
				//Get information from text field and store it
				String nameHouse = textfieldHouseName.getText();
				
				//Adjust House Pane 
				JButton buttonChange = new JButton("Change House Name");
				panelHouse.remove(textfieldHouseName);
				panelHouse.remove(buttonSaveHouse);
				panelHouse.remove(labelHouseName);
				panelHouse.add(new JLabel("House Name: "));
				panelHouse.add(new JLabel(nameHouse + " "));
				panelHouse.add(buttonChange);
				framePersonalize.pack();
				
				//Create Panel for the Floor tab and set it as the index
				JPanel panelFloor = new JPanel();
				JLabel labelFloorName = new JLabel("Floor Name:");
				JTextField textfieldFloorName = new JTextField(20);
				JButton buttonAddFloor = new JButton("Add Floor");
				panePersonalize.addTab("Floors", panelFloor);
				panePersonalize.setSelectedIndex(1);
				panelFloor.setLayout(new FlowLayout());
				panelFloor.add(labelFloorName);
				panelFloor.add(textfieldFloorName);
				panelFloor.add(buttonAddFloor);
				framePersonalize.pack();
				
				//Listener for add floor button
				buttonAddFloor.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						addFloor(framePersonalize, panePersonalize);
					}
				});
				
				//Update User Class
				
				//Listener for change house name button
			}
		});
	}

	public static void main(String[] args){
		//Make username and password frame and pane
		JFrame frameUNPW = new JFrame("Username and Password");
		JPanel panelUNPW = new JPanel();
			
		//Create button, textfields, and labels
		JButton buttonSave = new JButton("Save");
		JLabel labelUsername = new JLabel("Username:");
		JLabel labelPassword = new JLabel("Password:");
		JTextField textfieldUsername = new JTextField(20);
		JTextField textfieldPassword = new JTextField(20);
		SpringLayout sl_panelUNPW = new SpringLayout();
			
		//Adjust Placement of components
		sl_panelUNPW.putConstraint(SpringLayout.WEST, buttonSave, 196, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, buttonSave, 0, SpringLayout.EAST, textfieldUsername);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, labelPassword, 0, SpringLayout.EAST, labelUsername);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, labelUsername, -6, SpringLayout.WEST, textfieldUsername);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, labelPassword, 6, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, textfieldUsername, 8, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, textfieldUsername, -10, SpringLayout.NORTH, textfieldPassword);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, textfieldPassword, 87, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, labelUsername, 6, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, textfieldUsername, 87, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, buttonSave, 93, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, textfieldUsername, -10, SpringLayout.EAST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, textfieldPassword, -10, SpringLayout.EAST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, textfieldPassword, 38, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, buttonSave, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, labelPassword, 28, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, labelPassword, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, labelUsername, 0, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, labelUsername, 34, SpringLayout.NORTH, panelUNPW);
		panelUNPW.setLayout(sl_panelUNPW);
			
		//Add labels, textfields, and button to pane in flow order
		panelUNPW.add(labelUsername);
		panelUNPW.add(textfieldUsername);
		panelUNPW.add(labelPassword);
		panelUNPW.add(textfieldPassword);
		
		JLabel label = new JLabel("");
		sl_panelUNPW.putConstraint(SpringLayout.NORTH, label, 68, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.SOUTH, label, 102, SpringLayout.NORTH, panelUNPW);
		sl_panelUNPW.putConstraint(SpringLayout.EAST, label, 137, SpringLayout.WEST, panelUNPW);
		panelUNPW.add(label);
		panelUNPW.add(buttonSave);
		
		//Add pane to frame
		frameUNPW.getContentPane().add(panelUNPW);
		
		//Set size of size, location, and visibility of frameUNPW
		frameUNPW.setSize(323, 142);
		frameUNPW.setLocationRelativeTo(null);
		frameUNPW.setVisible(true);
		
		//Create listener for save button
		buttonSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Move to new GUI
				addHouse();
				
				//Hide username and password GUI
				frameUNPW.setVisible(false);
				
				//Save username and password in database
			}
		});
	}

}//end Personalize