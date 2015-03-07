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
	private static JFrame framePersonalize = new JFrame("Personalize");
	private static JLabel labelHS = new JLabel();
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
		
	}

	public void finalize() throws Throwable {

	}
	
	public static void changeNameGUI(){
		
		//Create frame, panel and layout for change name GUI
		JFrame changeNameHS = new JFrame("Change Name");
		JPanel panelNameHS = new JPanel();
		panelNameHS.setLayout(new FlowLayout());
		
		//Create and add Components
		JTextField tfNewName = new JTextField(20);
		JButton btSave = new JButton("Save");
		panelNameHS.add(new JLabel("New name of House: "));
		panelNameHS.add(tfNewName);
		panelNameHS.add(btSave);
		
		//Add panel to frame
		changeNameHS.add(panelNameHS);
		
		//Adjust frame
		changeNameHS.pack();
		changeNameHS.setVisible(true);
		changeNameHS.setLocationRelativeTo(null);
		
		//Add Listener
		btSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//change the house label
				labelHS.setText(tfNewName.getText());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameHS.setVisible(false);
				framePersonalize.setVisible(true);
			}
		});
	}

	public static void addFloor(){
		
	}

	public static void addHouse(){
		
		//Create frame tabbed panes and panels
		JTabbedPane panePersonalize = new JTabbedPane();
		JPanel panelHouse = new JPanel();
		panelHouse.setLayout(new FlowLayout());
		
		//Create components for initial GUI
		JLabel labelHouse = new JLabel("House Name: ");
		JTextField tfHouse = new JTextField(20);
		JButton btSaveHouse = new JButton("Save");
		
		//Add components to House panel
		panelHouse.add(labelHouse);
		panelHouse.add(tfHouse);
		panelHouse.add(btSaveHouse);
		panePersonalize.addTab("House", panelHouse);
		framePersonalize.getContentPane().add(panePersonalize);
		
		//Make frame visible, adjust size, and put in middle of screen
		framePersonalize.setVisible(true);
		framePersonalize.pack();
		framePersonalize.setLocationRelativeTo(null);
		
		//Save house listener
		btSaveHouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				//Get String from text field
				String nameHS = tfHouse.getText();
				
				panelHouse.remove(labelHouse);
				panelHouse.remove(tfHouse);
				panelHouse.remove(btSaveHouse);
				
				JButton btChangeHouse = new JButton("Change Name");
				SpringLayout sl_panelHouse = new SpringLayout();
				panelHouse.setLayout(sl_panelHouse);
				JLabel labelHSName = new JLabel("House Name: ");
				sl_panelHouse.putConstraint(SpringLayout.NORTH, btChangeHouse, -4, SpringLayout.NORTH, labelHSName);
				sl_panelHouse.putConstraint(SpringLayout.NORTH, labelHSName, 9, SpringLayout.NORTH, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.WEST, labelHSName, 10, SpringLayout.WEST, panelHouse);
				panelHouse.add(labelHSName);
				labelHS.setText(nameHS);
				sl_panelHouse.putConstraint(SpringLayout.WEST, labelHS, 6, SpringLayout.EAST, labelHSName);
				sl_panelHouse.putConstraint(SpringLayout.EAST, labelHS, -123, SpringLayout.EAST, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.WEST, btChangeHouse, 6, SpringLayout.EAST, labelHS);
				sl_panelHouse.putConstraint(SpringLayout.NORTH, labelHS, 0, SpringLayout.NORTH, labelHSName);
				panelHouse.add(labelHS);
				panelHouse.add(btChangeHouse);
				
				JTabbedPane paneFloor = new JTabbedPane();
				sl_panelHouse.putConstraint(SpringLayout.EAST, btChangeHouse, 0, SpringLayout.EAST, paneFloor);
				sl_panelHouse.putConstraint(SpringLayout.NORTH, paneFloor, 33, SpringLayout.NORTH, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.WEST, paneFloor, 5, SpringLayout.WEST, panelHouse);
				JPanel panelFloor = new JPanel();
				panelFloor.setLayout(new FlowLayout());
				JLabel labelFloor = new JLabel("Floor Name: ");
				JTextField tfFloor = new JTextField(20);
				JButton btAddFloor = new JButton("Add Floor");
				panelFloor.add(labelFloor);
				panelFloor.add(tfFloor);
				panelFloor.add(btAddFloor);
				paneFloor.addTab("Floors", panelFloor);
				panelHouse.add(paneFloor);
				
				framePersonalize.setBounds(0, 0, 435, 170);
				framePersonalize.setLocationRelativeTo(null);
				
				//Listener to change house name
				btChangeHouse.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						//Set personalize frame to invisible
						framePersonalize.setVisible(false);
						
						//Call method to change name
						changeNameGUI();
					}
				});
				
				btAddFloor.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						//Run Add floor method
						addFloor();
					}
				});
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