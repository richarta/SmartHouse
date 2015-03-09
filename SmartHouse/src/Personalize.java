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
	
	//Declare needed variables for scope of methods
	private static String nameHS;
	private static JFrame framePersonalize = new JFrame("Personalize");
	private static JLabel labelHS = new JLabel();
	public static JTabbedPane paneFloor = new JTabbedPane();
	public static JTabbedPane paneRoom = new JTabbedPane();
	public static JTabbedPane paneAdditions = new JTabbedPane();
	private static JPanel panelFloor = new JPanel();
	private static JPanel panelRoom = new JPanel();
	private static int floorCounter = 1, roomCounter = 1;
	
	public Personalize() {
	
/*		//Make username and password frame and pane
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
			
		//Add labels, text fields, and button to pane in flow order
		panelUNPW.add(labelUsername);
		panelUNPW.add(textfieldUsername);
		panelUNPW.add(labelPassword);
		panelUNPW.add(textfieldPassword);
		
		//Add space label for spring layout left of save button
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
		frameUNPW.setResizable(false);
		
		//Create listener for save button
		buttonSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//dispose username and password GUI
				frameUNPW.dispose();
				
				//Move to new GUI
				addHouse();

				//Save username and password in database
			}
		});*/
		
	}

	public void finalize() throws Throwable {

	}
	
	public static void changeHouseGUI(){
		
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
		changeNameHS.getContentPane().add(panelNameHS);
		
		//Adjust frame
		changeNameHS.pack();
		changeNameHS.setVisible(true);
		changeNameHS.setLocationRelativeTo(null);
		changeNameHS.setResizable(false);
		
		//Add Listener
		btSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//change nameHS
				nameHS = tfNewName.getText();
				
				//change the house label
				labelHS.setText(tfNewName.getText());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameHS.dispose();
				framePersonalize.setVisible(true);
			}
		});
	}

	public static void addFloor(String nameFL){
		
		//Set title of next index to name of floor
		paneFloor.setTitleAt(floorCounter, nameFL);
		paneFloor.setEnabledAt(floorCounter, true);
		
		//Create new panel for created floors
		JPanel panelFLC = new JPanel();
		JButton btRemoveFL = new JButton("Remove Floor");
		JButton btChangeNameFL = new JButton("Change Floor Name");
		SpringLayout sl_panelFLC = new SpringLayout();
		sl_panelFLC.putConstraint(SpringLayout.NORTH, btRemoveFL, 5, SpringLayout.NORTH, panelFLC);
		sl_panelFLC.putConstraint(SpringLayout.NORTH, btChangeNameFL, 0, SpringLayout.NORTH, btRemoveFL);
		sl_panelFLC.putConstraint(SpringLayout.WEST, btChangeNameFL, 6, SpringLayout.EAST, btRemoveFL);
		panelFLC.setLayout(sl_panelFLC);
		panelFLC.add(btRemoveFL);
		panelFLC.add(btChangeNameFL);
		
		//Add buttons labels and text fields for room panel
		JPanel panelRoom = new JPanel();
		SpringLayout sl_panelRoom = new SpringLayout();
		panelRoom.setLayout(sl_panelRoom);
		JLabel label = new JLabel("Room Name: ");
		sl_panelRoom.putConstraint(SpringLayout.NORTH, label, 9, SpringLayout.NORTH, panelRoom);
		sl_panelRoom.putConstraint(SpringLayout.WEST, label, 5, SpringLayout.WEST, panelRoom);
		panelRoom.add(label);
		JTextField tfNameRM = new JTextField(20);
		sl_panelRoom.putConstraint(SpringLayout.NORTH, tfNameRM, 6, SpringLayout.NORTH, panelRoom);
		sl_panelRoom.putConstraint(SpringLayout.WEST, tfNameRM, 81, SpringLayout.WEST, panelRoom);
		JButton btAddRM = new JButton("Add Room");
		sl_panelRoom.putConstraint(SpringLayout.SOUTH, tfNameRM, 0, SpringLayout.SOUTH, btAddRM);
		sl_panelRoom.putConstraint(SpringLayout.EAST, tfNameRM, -6, SpringLayout.WEST, btAddRM);
		sl_panelRoom.putConstraint(SpringLayout.NORTH, btAddRM, -4, SpringLayout.NORTH, label);
		sl_panelRoom.putConstraint(SpringLayout.EAST, btAddRM, -7, SpringLayout.EAST, panelRoom);
		sl_panelRoom.putConstraint(SpringLayout.WEST, btAddRM, -112, SpringLayout.EAST, panelRoom);
		panelRoom.add(tfNameRM);
		panelRoom.add(btAddRM);
		
		//Develop room tabbed pane tabs
		JTabbedPane paneRoom = new JTabbedPane();
		sl_panelFLC.putConstraint(SpringLayout.WEST, btRemoveFL, 0, SpringLayout.WEST, paneRoom);
		sl_panelFLC.putConstraint(SpringLayout.WEST, paneRoom, 0, SpringLayout.WEST, panelFLC);
		sl_panelFLC.putConstraint(SpringLayout.SOUTH, paneRoom, 95, SpringLayout.NORTH, panelFLC);
		sl_panelFLC.putConstraint(SpringLayout.EAST, paneRoom, 0, SpringLayout.EAST, panelFLC);
		sl_panelFLC.putConstraint(SpringLayout.NORTH, paneRoom, 33, SpringLayout.NORTH, panelFLC);
		paneRoom.addTab("Add Room", panelRoom);
		paneRoom.addTab(null, null);
		paneRoom.addTab(null, null);
		paneRoom.addTab(null, null);
		paneRoom.addTab(null, null);
		paneRoom.addTab(null, null);
		
		//Disable tabs set aside for room creation
		for(int i = 1; i <= 5; ++i){
			paneRoom.setEnabledAt(i, false);
		}
		
		//add tabbed pane to the flc panel
		panelFLC.add(paneRoom);
		
		//Add to current index
		paneFloor.setComponentAt(floorCounter, panelFLC);
		
		//Set newly made floor as current index
		paneFloor.setSelectedIndex(floorCounter);
		
		//increment floor counter
		++floorCounter;
		
		//Do not allow more floors to be added after allowable tabs have been filled
		if (floorCounter == 6){
			paneFloor.setEnabledAt(0, false);
		}

		framePersonalize.setBounds(0,0,460,200);
		framePersonalize.setLocationRelativeTo(null);
		framePersonalize.setResizable(false);
		
		//Listener to change floor name
		btChangeNameFL.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Set personalize frame to invisible
				framePersonalize.setVisible(false);
				
				//Call method to change name
				changeFloor();
			}
		});
		
		//Listener to remove floor
		btRemoveFL.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//remove tab
				paneFloor.remove(paneFloor.getSelectedIndex());
				
				//add new tab
				paneFloor.addTab(null, null);
				paneFloor.setEnabledAt(5, false);
				paneFloor.setSelectedIndex(0);
				
				//decrement floor counter
				--floorCounter;
			}
		});
		
		//Listener to add room
		btAddRM.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//create room object
				
				//call add room method
				addRoom(tfNameRM.getText());
				
				//set room text field to nothing
				tfNameRM.setText("");
			}
		});
	}
	
	public static void addRoom(String nameRM){
		
	}

	public static void changeRoom(){
		
	}
	
	public static void changeFloor(){
		
		//Create frame, panel and layout for change name GUI
		JFrame changeNameFL = new JFrame("Change Floor Name");
		JPanel panelNameFL = new JPanel();
		panelNameFL.setLayout(new FlowLayout());
		
		//Create and add Components
		JTextField tfNewName = new JTextField(20);
		JButton btSave = new JButton("Save");
		panelNameFL.add(new JLabel("New name of Floor: "));
		panelNameFL.add(tfNewName);
		panelNameFL.add(btSave);
		
		//Add panel to frame
		changeNameFL.getContentPane().add(panelNameFL);
		
		//Adjust frame
		changeNameFL.pack();
		changeNameFL.setVisible(true);
		changeNameFL.setLocationRelativeTo(null);
		changeNameFL.setResizable(false);
		
		//Add Listener
		btSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Change Name of Floor
				paneFloor.setTitleAt(paneFloor.getSelectedIndex(), tfNewName.getText());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameFL.dispose();
				framePersonalize.setVisible(true);
			}
		});
	}

	public static void addHouse(){
		
		//Create house panel
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
		framePersonalize.getContentPane().add(panelHouse);
		
		//Make frame visible, adjust size, and put in middle of screen
		framePersonalize.setVisible(true);
		framePersonalize.pack();
		framePersonalize.setLocationRelativeTo(null);
		framePersonalize.setResizable(false);
		
		//Save house listener
		btSaveHouse.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Get String from text field
				nameHS = tfHouse.getText();
				
				//Remove Components from house panel
				panelHouse.remove(labelHouse);
				panelHouse.remove(tfHouse);
				panelHouse.remove(btSaveHouse);
				
				//Create and add new components to house panel
				JButton btChangeHouse = new JButton("Change");
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
				
				//Create tabbed pane within house panel and add floor panel to tab
				sl_panelHouse.putConstraint(SpringLayout.EAST, btChangeHouse, -10, SpringLayout.EAST, paneFloor);
				sl_panelHouse.putConstraint(SpringLayout.NORTH, paneFloor, 33, SpringLayout.NORTH, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.WEST, paneFloor, 0, SpringLayout.WEST, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.EAST, paneFloor, 0, SpringLayout.EAST, panelHouse);
				sl_panelHouse.putConstraint(SpringLayout.SOUTH, paneFloor, 0, SpringLayout.SOUTH, panelHouse);
				JLabel labelFloor = new JLabel("Floor Name: ");
				JTextField tfFloor = new JTextField(20);
				JButton btAddFloor = new JButton("Add Floor");
				SpringLayout sl_panelFloor = new SpringLayout();
				sl_panelFloor.putConstraint(SpringLayout.SOUTH, tfFloor, 0, SpringLayout.SOUTH, btAddFloor);
				sl_panelFloor.putConstraint(SpringLayout.WEST, btAddFloor, -114, SpringLayout.EAST, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.EAST, btAddFloor, -7, SpringLayout.EAST, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.NORTH, tfFloor, -3, SpringLayout.NORTH, labelFloor);
				sl_panelFloor.putConstraint(SpringLayout.WEST, tfFloor, 0, SpringLayout.EAST, labelFloor);
				sl_panelFloor.putConstraint(SpringLayout.EAST, tfFloor, -6, SpringLayout.WEST, btAddFloor);
				sl_panelFloor.putConstraint(SpringLayout.NORTH, btAddFloor, -4, SpringLayout.NORTH, labelFloor);
				sl_panelFloor.putConstraint(SpringLayout.NORTH, labelFloor, 9, SpringLayout.NORTH, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.WEST, labelFloor, 10, SpringLayout.WEST, panelFloor);
				panelFloor.setLayout(sl_panelFloor);
				panelFloor.add(labelFloor);
				panelFloor.add(tfFloor);
				panelFloor.add(btAddFloor);
				
				//Add tabs for limited amount of floors
				paneFloor.addTab("Add Floor", panelFloor);
				paneFloor.addTab(null, null);
				paneFloor.addTab(null, null);
				paneFloor.addTab(null, null);
				paneFloor.addTab(null, null);
				paneFloor.addTab(null, null);
				
				//Disable tabs meant for other floors
				for(int i = 1; i <= 5; ++i){
					paneFloor.setEnabledAt(i, false);
				}
				
				//add tabbed pane to house panel
				panelHouse.add(paneFloor);
				
				//Set up pane on screen
				framePersonalize.setBounds(0, 0, 415, 150);
				framePersonalize.setLocationRelativeTo(null);
				framePersonalize.setResizable(false);
				
				//Listener to change house name
				btChangeHouse.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						//Set personalize frame to invisible
						framePersonalize.setVisible(false);
						
						//Call method to change name
						changeHouseGUI();
					}
				});
				
				btAddFloor.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Create floor class
						
						//Run Add floor method
						addFloor(tfFloor.getText());
						
						//Delete text in textfield
						tfFloor.setText("");
					}
				});
			}
		});
		
		//add exit listener
		framePersonalize.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
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
			
		//Add labels, text fields, and button to pane in flow order
		panelUNPW.add(labelUsername);
		panelUNPW.add(textfieldUsername);
		panelUNPW.add(labelPassword);
		panelUNPW.add(textfieldPassword);
		
		//Add space label for spring layout left of save button
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
		frameUNPW.setResizable(false);
		
		//Create listener for save button
		buttonSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//dispose username and password GUI
				frameUNPW.dispose();
				
				//Move to new GUI
				addHouse();

				//Save username and password in database
			}
		});
	}

}//end Personalize