/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 05 March 2015
 */

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

import javax.swing.*;

public class Personalize extends JPanel{
	
	//Declare needed variables for scope of methods
	private static String nameHS;
	private static JFrame framePersonalize = new JFrame("Personalize");
	private static JLabel labelHS = new JLabel();
	private static JTextField tfNameRM, tfNameFL, textField;
	private static JComboBox<String> cbFloors = new JComboBox<String>();
	private static JComboBox<String> cbRooms = new JComboBox<String>();
	private static JComboBox<String> cbAdditions = new JComboBox<String>();
	private static House house = new House();
	
	public Personalize() {		
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
		frameUNPW.setSize(323, 133);
		frameUNPW.setLocationRelativeTo(null);
		frameUNPW.setVisible(true);
		frameUNPW.setResizable(false);
		
		//Create listener for save button
		buttonSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Pass username and password textfield to user method
				try {
					User.setUsername(textfieldUsername.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					User.setPassword(textfieldPassword.getText());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//dispose username and password GUI
				frameUNPW.dispose();
				
				//Move to new GUI
				addHouse();
				
				//Save username and password in database
				
			}
		});
	}

	public void finalize() throws Throwable {

	}
	
	public static void changeHouseGUI(){
		
		//Create frame, panel and layout for change name GUI
		JFrame changeNameHS = new JFrame("Change House Name");
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
				
				//change name in house class
				house.setName(tfNewName.getText());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameHS.dispose();
				framePersonalize.setEnabled(true);
				framePersonalize.setVisible(true);
			}
		});
	}

	public static void addFloor(){
		
		//add floor in house class
		house.addFloor(tfNameFL.getText());
		
		//Add floor to combo box
		cbFloors.addItem(tfNameFL.getText());
		
		//Erase text from floor name text field
		tfNameFL.setText("");
		
		//Set newly created floor as selected index
		cbFloors.setSelectedIndex(cbFloors.getItemCount() - 1);
	}
	
	public static void removeFloor(){
		
		//Remove floor from house class
		house.removeFloor(cbFloors.getSelectedIndex());
		
		//Remove floor from combo box
		cbFloors.removeItem(cbFloors.getSelectedItem());
	}
	
	public static void changeFloorGUI(){
		
		//Create frame, panel and layout for change floor GUI
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
				
				//change name of floor in house class
				house.getFloorList().get(cbFloors.getSelectedIndex()).setName(tfNewName.getText());
				
				//Change item in combo box
				cbFloors.insertItemAt(tfNewName.getText(), cbFloors.getSelectedIndex());
				cbFloors.removeItemAt(cbFloors.getSelectedIndex());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameFL.dispose();
				framePersonalize.setEnabled(true);
				framePersonalize.setVisible(true);
			}
		});
	}
	
	public static void addRoom(){
		
		//add room to house class
		house.getFloorList().get(cbFloors.getSelectedIndex()).addRoom(tfNameRM.getText());
		
		//Add room to combo box
		cbRooms.addItem(tfNameRM.getText());
		cbRooms.setSelectedIndex(cbRooms.getItemCount() - 1);
		
		//Erase text from room name text field
		tfNameRM.setText("");
	}

	public static void removeRoom(){
		
		//Remove room from house class
		house.getFloorList().get(cbFloors.getSelectedIndex()).removeRoom(cbRooms.getSelectedIndex());
		
		//Remove room from combo box
		cbRooms.removeItem(cbRooms.getSelectedItem());
	}
	
	public static void changeRoomGUI(){
		
		//Create frame, panel and layout for change floor GUI
		JFrame changeNameRM = new JFrame("Change Room Name");
		JPanel panelNameRM = new JPanel();
		panelNameRM.setLayout(new FlowLayout());
		
		//Create and add Components
		JTextField tfNewName = new JTextField(20);
		JButton btSave = new JButton("Save");
		panelNameRM.add(new JLabel("New name of Room: "));
		panelNameRM.add(tfNewName);
		panelNameRM.add(btSave);
		
		//Add panel to frame
		changeNameRM.getContentPane().add(panelNameRM);
		
		//Adjust frame
		changeNameRM.pack();
		changeNameRM.setVisible(true);
		changeNameRM.setLocationRelativeTo(null);
		changeNameRM.setResizable(false);
		
		//Add Listener
		btSave.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				//Change name in house class
				house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).setName(tfNewName.getText());
				
				//Change item in combo box
				cbRooms.insertItemAt(tfNewName.getText(), cbRooms.getSelectedIndex());
				cbRooms.removeItemAt(cbRooms.getSelectedIndex());
				
				//Hide the change name GUI and display the personalize GUI
				changeNameRM.dispose();
				framePersonalize.setEnabled(true);
				framePersonalize.setVisible(true);
			}
		});
	}
	
	public static void addDoor(){
		
		//add door to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addDoor(textField.getText());
	}
	
	public static void removeDoor(){
		
	}
	
	public static void changeDoorGUI(){
		
	}
	
	public static void addWindow(){
		
		//add window to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addWindow(textField.getText());
	}
	
	public static void removeWindow(){
		
	}
	
	public static void changeWindowGUI(){
		
	}
	
	public static void addTV(){
		
		//add television to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addTelevision(textField.getText());
	}
	
	public static void removeTV(){
		
	}
	
	public static void changeTVGUI(){
		
	}
	
	public static void addLight(){
		
		//add light to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addLight(textField.getText());
	}
	
	public static void removeLight(){
		
	}
	
	public static void changeLightGUI(){
		
	}
	
	public static void addRadio(){
		
		//add radio to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addRadio(textField.getText());
	}
	
	public static void removeRadio(){
		
	}
	
	public static void changeRadioGUI(){
		
	}
	
	public static void addFaucet(){
		
		//add faucet to house instance
		house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).addFaucet(textField.getText());
	}
	
	public static void removeFaucet(){
		
	}
	
	public static void changeFaucetGUI(){
		
	}
	
	public static void addHouse(){
		
		//Create house panel
		JPanel panelPersonalize = new JPanel();
		panelPersonalize.setLayout(new FlowLayout());
		
		//Set exit on close
		framePersonalize.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create components for initial GUI
		JLabel labelHouse = new JLabel("House Name: ");
		JTextField tfHouse = new JTextField(20);
		JButton btSaveHouse = new JButton("Save");
		
		//Add components to House panel
		panelPersonalize.add(labelHouse);
		panelPersonalize.add(tfHouse);
		panelPersonalize.add(btSaveHouse);
		framePersonalize.getContentPane().add(panelPersonalize);
		
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
				
				//Set house name
				house.setName(tfHouse.getText());
				
				//Add thermostat to house
				house.addThermostat("Thermostat");
				
				//Remove Components from personalize panel
				panelPersonalize.removeAll();
				
				//Adjust personalize frame
				framePersonalize.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				SpringLayout springLayout = new SpringLayout();
				framePersonalize.getContentPane().setLayout(springLayout);
				
				//Create House Panel and add to personalize frame
				JLabel lblHouseName = new JLabel("House Name: ");
				springLayout.putConstraint(SpringLayout.NORTH, lblHouseName, 13, SpringLayout.NORTH, framePersonalize.getContentPane());
				springLayout.putConstraint(SpringLayout.WEST, lblHouseName, 10, SpringLayout.WEST, framePersonalize.getContentPane());
				framePersonalize.getContentPane().add(lblHouseName);
				
				labelHS.setText(nameHS);
				springLayout.putConstraint(SpringLayout.NORTH, labelHS, 0, SpringLayout.NORTH, lblHouseName);
				springLayout.putConstraint(SpringLayout.WEST, labelHS, 6, SpringLayout.EAST, lblHouseName);
				framePersonalize.getContentPane().add(labelHS);
				
				JButton btChangeHouse = new JButton("Change House Name");
				springLayout.putConstraint(SpringLayout.NORTH, btChangeHouse, 10, SpringLayout.NORTH, framePersonalize.getContentPane());
				springLayout.putConstraint(SpringLayout.NORTH, labelHS, 4, SpringLayout.NORTH, btChangeHouse);
				springLayout.putConstraint(SpringLayout.EAST, btChangeHouse, -10, SpringLayout.EAST, framePersonalize.getContentPane());
				framePersonalize.getContentPane().add(btChangeHouse);
				
				//Create and add floor panel to personalize panel
				JPanel panelFloor = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panelFloor, 10, SpringLayout.SOUTH, btChangeHouse);
				springLayout.putConstraint(SpringLayout.SOUTH, panelFloor, 130, SpringLayout.NORTH, btChangeHouse);
				springLayout.putConstraint(SpringLayout.WEST, panelFloor, 0, SpringLayout.WEST, framePersonalize.getContentPane());
				springLayout.putConstraint(SpringLayout.EAST, panelFloor, 0, SpringLayout.EAST, framePersonalize.getContentPane());
				framePersonalize.getContentPane().add(panelFloor);
				
				SpringLayout sl_panelFloor = new SpringLayout();
				panelFloor.setLayout(sl_panelFloor);
				
				JLabel lblNewFloor = new JLabel("New Floor: ");
				sl_panelFloor.putConstraint(SpringLayout.NORTH, lblNewFloor, 11, SpringLayout.NORTH, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.WEST, lblNewFloor, 10, SpringLayout.WEST, panelFloor);
				panelFloor.add(lblNewFloor);
				
				tfNameFL = new JTextField();
				sl_panelFloor.putConstraint(SpringLayout.NORTH, tfNameFL, 11, SpringLayout.NORTH, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.WEST, tfNameFL, 6, SpringLayout.EAST, lblNewFloor);
				panelFloor.add(tfNameFL);
				tfNameFL.setColumns(10);
				
				JButton btnAddFloor = new JButton("Add Floor");
				sl_panelFloor.putConstraint(SpringLayout.EAST, tfNameFL, -6, SpringLayout.WEST, btnAddFloor);
				sl_panelFloor.putConstraint(SpringLayout.NORTH, btnAddFloor, 8, SpringLayout.NORTH, panelFloor);
				sl_panelFloor.putConstraint(SpringLayout.EAST, btnAddFloor, -10, SpringLayout.EAST, panelFloor);
				panelFloor.add(btnAddFloor);
				
				sl_panelFloor.putConstraint(SpringLayout.NORTH, cbFloors, 6, SpringLayout.SOUTH, tfNameFL);
				sl_panelFloor.putConstraint(SpringLayout.WEST, cbFloors, 0, SpringLayout.WEST, tfNameFL);
				sl_panelFloor.putConstraint(SpringLayout.EAST, cbFloors, 0, SpringLayout.EAST, tfNameFL);
				panelFloor.add(cbFloors);
				
				JButton btnRemoveFL = new JButton("Remove Selected Floor");
				sl_panelFloor.putConstraint(SpringLayout.NORTH, btnRemoveFL, 6, SpringLayout.SOUTH, cbFloors);
				sl_panelFloor.putConstraint(SpringLayout.WEST, btnRemoveFL, 0, SpringLayout.WEST, lblNewFloor);
				panelFloor.add(btnRemoveFL);
				btnRemoveFL.setEnabled(false);
				
				JButton btnChangeFL = new JButton("Change Selected Floor Name");
				sl_panelFloor.putConstraint(SpringLayout.NORTH, btnChangeFL, 6, SpringLayout.SOUTH, cbFloors);
				sl_panelFloor.putConstraint(SpringLayout.EAST, btnChangeFL, 0, SpringLayout.EAST, btnAddFloor);
				panelFloor.add(btnChangeFL);
				btnChangeFL.setEnabled(false);
				
				//Create Panel for adding a room
				JPanel panelRoom = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panelRoom, 10, SpringLayout.SOUTH, panelFloor);
				springLayout.putConstraint(SpringLayout.WEST, panelRoom, 0, SpringLayout.WEST, panelFloor);
				springLayout.putConstraint(SpringLayout.SOUTH, panelRoom, 105, SpringLayout.SOUTH, panelFloor);
				springLayout.putConstraint(SpringLayout.EAST, panelRoom, 0, SpringLayout.EAST, panelFloor);
				framePersonalize.getContentPane().add(panelRoom);
				SpringLayout sl_panelRoom = new SpringLayout();
				panelRoom.setLayout(sl_panelRoom);
				
				JLabel lblNewRoom = new JLabel("New Room: ");
				sl_panelRoom.putConstraint(SpringLayout.NORTH, lblNewRoom, 10, SpringLayout.NORTH, panelRoom);
				sl_panelRoom.putConstraint(SpringLayout.WEST, lblNewRoom, 10, SpringLayout.WEST, panelRoom);
				panelRoom.add(lblNewRoom);
				
				JButton btnAddRoom = new JButton("Add Room");
				sl_panelRoom.putConstraint(SpringLayout.NORTH, btnAddRoom, -4, SpringLayout.NORTH, lblNewRoom);
				panelRoom.add(btnAddRoom);
				
				tfNameRM = new JTextField();
				sl_panelRoom.putConstraint(SpringLayout.NORTH, tfNameRM, -3, SpringLayout.NORTH, lblNewRoom);
				sl_panelRoom.putConstraint(SpringLayout.WEST, tfNameRM, 2, SpringLayout.EAST, lblNewRoom);
				sl_panelRoom.putConstraint(SpringLayout.EAST, tfNameRM, -6, SpringLayout.WEST, btnAddRoom);
				panelRoom.add(tfNameRM);
				tfNameRM.setColumns(10);
				
				sl_panelRoom.putConstraint(SpringLayout.NORTH, cbRooms, 6, SpringLayout.SOUTH, tfNameRM);
				sl_panelRoom.putConstraint(SpringLayout.WEST, cbRooms, 0, SpringLayout.WEST, tfNameRM);
				sl_panelRoom.putConstraint(SpringLayout.EAST, cbRooms, 0, SpringLayout.EAST, tfNameRM);
				panelRoom.add(cbRooms);
				
				JButton btnRemoveRM = new JButton("Remove Room");
				sl_panelRoom.putConstraint(SpringLayout.WEST, btnRemoveRM, 0, SpringLayout.WEST, lblNewRoom);
				panelRoom.add(btnRemoveRM);
				btnRemoveRM.setEnabled(false);
				
				JButton btnChangeRoomName = new JButton("Change Room Name");
				sl_panelRoom.putConstraint(SpringLayout.NORTH, btnChangeRoomName, 6, SpringLayout.SOUTH, cbRooms);
				sl_panelRoom.putConstraint(SpringLayout.EAST, btnAddRoom, 0, SpringLayout.EAST, btnChangeRoomName);
				sl_panelRoom.putConstraint(SpringLayout.WEST, btnChangeRoomName, 130, SpringLayout.EAST, btnRemoveRM);
				sl_panelRoom.putConstraint(SpringLayout.EAST, btnChangeRoomName, -10, SpringLayout.EAST, panelRoom);
				sl_panelRoom.putConstraint(SpringLayout.NORTH, btnRemoveRM, 0, SpringLayout.NORTH, btnChangeRoomName);
				panelRoom.add(btnChangeRoomName);
				btnChangeRoomName.setEnabled(false);
				
				//Add Additions panel
				JPanel panelAdditions = new JPanel();
				springLayout.putConstraint(SpringLayout.NORTH, panelAdditions, 6, SpringLayout.SOUTH, panelRoom);
				springLayout.putConstraint(SpringLayout.SOUTH, panelAdditions, -39, SpringLayout.SOUTH, framePersonalize.getContentPane());
				springLayout.putConstraint(SpringLayout.WEST, panelAdditions, 0, SpringLayout.WEST, framePersonalize.getContentPane());
				springLayout.putConstraint(SpringLayout.EAST, panelAdditions, 0, SpringLayout.EAST, panelFloor);
				framePersonalize.getContentPane().add(panelAdditions);
				SpringLayout sl_panelAdditions = new SpringLayout();
				panelAdditions.setLayout(sl_panelAdditions);
				
				JButton btnAdd = new JButton("Add");
				panelAdditions.add(btnAdd);
				
				JButton btnRemove = new JButton("Remove");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, btnRemove, 0, SpringLayout.NORTH, btnAdd);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, btnRemove, 6, SpringLayout.EAST, btnAdd);
				panelAdditions.add(btnRemove);
				
				JButton btnChangeNM = new JButton("Change Name");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, btnChangeNM, 0, SpringLayout.NORTH, btnAdd);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, btnChangeNM, 6, SpringLayout.EAST, btnRemove);
				panelAdditions.add(btnChangeNM);
				
				sl_panelAdditions.putConstraint(SpringLayout.WEST, btnAdd, 0, SpringLayout.WEST, cbAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.EAST, cbAdditions, -137, SpringLayout.EAST, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, cbAdditions, 10, SpringLayout.NORTH, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, cbAdditions, 10, SpringLayout.WEST, panelAdditions);
				panelAdditions.add(cbAdditions);
				
				//add components to addition combo box and set the door as the selected item
				cbAdditions.addItem("Door");
				cbAdditions.addItem("Window");
				cbAdditions.addItem("Light");
				cbAdditions.addItem("Television");
				cbAdditions.addItem("Radio");
				cbAdditions.addItem("Faucet");
				cbAdditions.setSelectedIndex(0);
				
				JLabel lblAddition = new JLabel("Door: ");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, lblAddition, 0, SpringLayout.NORTH, cbAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, lblAddition, 6, SpringLayout.EAST, cbAdditions);
				panelAdditions.add(lblAddition);
				
				JLabel lblAdditionName = new JLabel("");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, lblAdditionName, 6, SpringLayout.SOUTH, lblAddition);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, lblAdditionName, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(lblAdditionName);
				
				textField = new JTextField();
				sl_panelAdditions.putConstraint(SpringLayout.EAST, textField, -137, SpringLayout.EAST, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, textField);
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, cbAdditions);
				panelAdditions.add(textField);
				textField.setColumns(10);
				
				JLabel label = new JLabel("");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblAdditionName);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label);
				
				JLabel label_1 = new JLabel("");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, label);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label_1);
				
				JLabel label_2 = new JLabel("");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label_2);
				
				JButton btnFinish = new JButton("Finish");
				springLayout.putConstraint(SpringLayout.NORTH, btnFinish, 5, SpringLayout.SOUTH, panelAdditions);
				springLayout.putConstraint(SpringLayout.EAST, btnFinish, -5, SpringLayout.EAST, panelAdditions);
				framePersonalize.getContentPane().add(btnFinish);
				btnFinish.setEnabled(false);
				
				//Format personalize frame
				framePersonalize.setBounds(0, 0, 450, 175);
				framePersonalize.setVisible(true);
				framePersonalize.setLocationRelativeTo(null);
				
				//Listener to change house name
				btChangeHouse.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Disable personalize frame
						framePersonalize.setEnabled(false);
						
						//Call method to change name
						changeHouseGUI();
					}
				});
				
				//Listener to add Floor
				btnAddFloor.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Disable add floor button when fifth floor is being added
						if (house.getFloorList().size() == 4){
							btnAddFloor.setEnabled(false);
						}
						
						//Call add floor method
						addFloor();
						
						//Enable change floor name and remove floor button
						btnChangeFL.setEnabled(true);
						btnRemoveFL.setEnabled(true);
						
						//Change frame size
						framePersonalize.setBounds(0, 0, 450, 280);
						framePersonalize.setLocationRelativeTo(null);
					}
				});
				
				//Listener to remove floor
				btnRemoveFL.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Remove room panel and disable change and remove floor and button if no more floors will be left
						if(house.getFloorList().size() == 1){
							framePersonalize.setBounds(0, 0, 450, 175);
							framePersonalize.setLocationRelativeTo(null);
							btnChangeFL.setEnabled(false);
							btnRemoveFL.setEnabled(false);
						}
						
						//Enable add floor button if there a floor can be added
						if(house.getFloorList().size() == 5){
							btnAddFloor.setEnabled(true);
						}
						
						//Call remove floor method
						removeFloor();
					}
				});
				
				//Change floor listener
				btnChangeFL.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Disable personalize frame
						framePersonalize.setEnabled(false);
						
						//Call change floor name method
						changeFloorGUI();
					}
				});
				
				//Add Room Listener
				btnAddRoom.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Disable add floor button when fifth floor is being added
						if (house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().size() == 4){
							btnAddRoom.setEnabled(false);
						}
						
						//Call add floor method
						addRoom();
						
						//Enable change floor name and remove floor button
						btnChangeRoomName.setEnabled(true);
						btnRemoveRM.setEnabled(true);
						btnFinish.setEnabled(true);
						
						//Change frame size
						framePersonalize.setBounds(0, 0, 450, 440);
						framePersonalize.setLocationRelativeTo(null);
						
						//set addition selected listener
						cbAdditions.setSelectedIndex(0);
					}
				});

				//Remove room listener
				btnRemoveRM.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Remove room panel and disable change and remove floor and button if no more floors will be left
						if(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().size() == 1){
							framePersonalize.setBounds(0, 0, 450, 280);
							framePersonalize.setLocationRelativeTo(null);
							btnChangeRoomName.setEnabled(false);
							btnRemoveRM.setEnabled(false);
							btnFinish.setEnabled(false);
						}
						
						//Enable add room button if there is a room that can be added
						if(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().size() == 5){
							btnAddRoom.setEnabled(true);
						}
						
						//Call remove floor method
						removeRoom();
					}
				});

				//Change room listener
				btnChangeRoomName.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Disable personalize frame
						framePersonalize.setEnabled(false);
						
						//Call change floor name method
						changeRoomGUI();
					}
				});

				//Finish listener
				btnFinish.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Save house
						User.setHouse(house);
						User.saveHouseStatus();
						
						//call selection menu class
						new SelectionMenu();
						
						//dispose of personalization frame
						framePersonalize.dispose();
					}
				});
				
				//Set up listener for add button
				btnAdd.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						switch(cbAdditions.getSelectedIndex()){
						case 0: //Door
							addDoor();
							textField.setText("");
							break;
						case 1: //Window
							addWindow();
							textField.setText("");
							break;
						case 2: //Light
							addLight();
							textField.setText("");
							break;
						case 3: //Television
							addTV();
							textField.setText("");
							break;
						case 4: //Radio
							addRadio();
							textField.setText("");
							break;
						case 5: //Faucet
							addFaucet();
							textField.setText("");
							break;
						}
					}
				});
				
				//Set up proper rooms in room combo box when a floor is selected
				cbFloors.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent e){
						
						if (e.getStateChange() == ItemEvent.SELECTED){
							
							//get room information from house class
							if (house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().size() == 0){
								
								//Enable change floor name and remove floor button
								btnChangeRoomName.setEnabled(false);
								btnRemoveRM.setEnabled(false);
								
								//Change frame size
								framePersonalize.setBounds(0, 0, 450, 280);
								framePersonalize.setLocationRelativeTo(null);
								cbRooms.removeAllItems();
							}
							else {
								
								//Enable change floor name and remove floor button
								btnChangeRoomName.setEnabled(true);
								btnRemoveRM.setEnabled(true);
								
								//Change frame size
								framePersonalize.setBounds(0, 0, 450, 440);
								framePersonalize.setLocationRelativeTo(null);
								
								cbRooms.removeAllItems();
								for (int i = 0; i < house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().size(); ++i){
									cbRooms.addItem(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(i).getName());
								}
							}
						}
					}
				});

				//Set up proper item additions combo box
				cbAdditions.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						
						if (event.getStateChange() == ItemEvent.SELECTED){
							
							//Change name of Addition label
							lblAddition.setText(cbAdditions.getItemAt(cbAdditions.getSelectedIndex()) + ": ");
							
							//Add names of additions to panel
							switch(cbAdditions.getSelectedIndex()){
							
							case 0: //Door
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int d = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().size();
								switch(d){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getDoorList().get(3).getName());
									break;
								}
								break;
							case 1: //Window
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int w = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().size();
								switch(w){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getWindowList().get(3).getName());
									break;
								}
								break;
							case 2: //Light
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int l = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().size();
								switch(l){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getLightList().get(3).getName());
									break;
								}
								break;
							case 3: //Television
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int tv = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().size();
								switch(tv){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getTelevisionList().get(3).getName());
									break;
								}
								break;
							case 4: //Radio
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int r = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().size();
								switch(r){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getRadioList().get(3).getName());
									break;
								}
								break;
							case 5: //Faucet
								
								//Remove addition names
								lblAdditionName.setText("");
								label.setText("");
								label_1.setText("");
								label_2.setText("");
								
								int f = house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().size();
								switch(f){
								case 0:
									break;
								case 1:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(0).getName());
									break;
								case 2:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(1).getName());
									break;
								case 3:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(2).getName());
									break;
								case 4:
									lblAdditionName.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(0).getName());
									label.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(1).getName());
									label_1.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(2).getName());
									label_2.setText(house.getFloorList().get(cbFloors.getSelectedIndex()).getRoomList().get(cbRooms.getSelectedIndex()).getFaucetList().get(3).getName());
									break;
								}
								break;
							}
						}
					}
				});
			
			}
		});
	}
}//end Personalize
