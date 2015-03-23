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
	private static int floorCounter = 0, roomCounter = 0;
	private static JTextField tfNameRM, tfNameFL;
	private static JComboBox<String> cbFloors = new JComboBox<String>();
	private static JComboBox<String> cbRooms = new JComboBox<String>();
	private static JComboBox<String> cbAdditions = new JComboBox<String>();
	private static House house;
	
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
				
				//Hide the change name GUI and display the personalize GUI
				changeNameHS.dispose();
				framePersonalize.setEnabled(true);
				framePersonalize.setVisible(true);
			}
		});
	}

	public static void addFloor(String nameFL){
		
		//Add floor to combo box
		cbFloors.addItem(tfNameFL.getText());
		cbFloors.setSelectedIndex(cbFloors.getItemCount() - 1);
		
		//Erase text from floor name text field
		tfNameFL.setText("");
		
		//add floor to house class
		house.addFloor(nameFL);
	}
	
	public static void removeFloor(){
		
		//Remove floor from combo box
		cbFloors.removeItem(cbFloors.getSelectedItem());
		
		//Remove floor from house class
		
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
	
	public static void addRoom(String nameRM){
		
		//Add floor to combo box
		cbRooms.addItem(tfNameRM.getText());
		cbRooms.setSelectedIndex(cbRooms.getItemCount() - 1);
		
		//Erase text from floor name text field
		tfNameRM.setText("");	
	}

	public static void removeRoom(){
		
		//Remove floor from combo box
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
	
	public static void changeFloor(){
		
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
				
				//add components to addition combo box
				cbAdditions.addItem("Door");
				cbAdditions.addItem("Window");
				cbAdditions.addItem("Light");
				cbAdditions.addItem("Television");
				cbAdditions.addItem("Radio");
				cbAdditions.addItem("Faucet");
				
				JLabel lblAddition = new JLabel("Addition Name: ");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, lblAddition, 0, SpringLayout.NORTH, cbAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, lblAddition, 6, SpringLayout.EAST, cbAdditions);
				panelAdditions.add(lblAddition);
				
				JLabel lblAdditionName = new JLabel("Specific Name");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, lblAdditionName, 6, SpringLayout.SOUTH, lblAddition);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, lblAdditionName, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(lblAdditionName);
				
				JTextField textField = new JTextField();
				sl_panelAdditions.putConstraint(SpringLayout.EAST, textField, -137, SpringLayout.EAST, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, textField, 10, SpringLayout.WEST, panelAdditions);
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, btnAdd, 6, SpringLayout.SOUTH, textField);
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, cbAdditions);
				panelAdditions.add(textField);
				textField.setColumns(10);
				
				JLabel label = new JLabel("Specific Name");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label, 6, SpringLayout.SOUTH, lblAdditionName);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label);
				
				JLabel label_1 = new JLabel("Specific Name");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label_1, 6, SpringLayout.SOUTH, label);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label_1, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label_1);
				
				JLabel label_2 = new JLabel("Specific Name");
				sl_panelAdditions.putConstraint(SpringLayout.NORTH, label_2, 6, SpringLayout.SOUTH, label_1);
				sl_panelAdditions.putConstraint(SpringLayout.WEST, label_2, 0, SpringLayout.WEST, lblAddition);
				panelAdditions.add(label_2);
				
				JButton btnFinish = new JButton("Finish");
				springLayout.putConstraint(SpringLayout.NORTH, btnFinish, 5, SpringLayout.SOUTH, panelAdditions);
				springLayout.putConstraint(SpringLayout.EAST, btnFinish, -5, SpringLayout.EAST, panelAdditions);
				framePersonalize.getContentPane().add(btnFinish);
				btnFinish.setEnabled(true);
				
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
						if (floorCounter == 4){
							btnAddFloor.setEnabled(false);
						}
						
						//Call add floor method
						addFloor(tfNameFL.getText());
						
						//Increment floor counter
						++floorCounter;
						
						//Enable change floor name and remove floor button
						btnChangeFL.setEnabled(true);
						btnRemoveFL.setEnabled(true);
						
						//Change frame size
						if (roomCounter == 0){
							framePersonalize.setBounds(0, 0, 450, 280);
							framePersonalize.setLocationRelativeTo(null);
						}
						else {
							framePersonalize.setBounds(0, 0, 450, 440);
							framePersonalize.setLocationRelativeTo(null);
						}
					}
				});
				
				//Listener to remove floor
				btnRemoveFL.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Remove room panel and disable change and remove floor and button if no more floors will be left
						if(floorCounter == 1){
							framePersonalize.setBounds(0, 0, 450, 175);
							framePersonalize.setLocationRelativeTo(null);
							btnChangeFL.setEnabled(false);
							btnRemoveFL.setEnabled(false);
						}
						
						//Enable add floor button if there a floor can be added
						if(floorCounter == 5){
							btnAddFloor.setEnabled(true);
						}
						
						//Call remove floor method
						removeFloor();
						
						//Decrement floor counter
						--floorCounter;
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
						if (roomCounter == 4){
							btnAddRoom.setEnabled(false);
						}
						
						//Call add floor method
						addRoom(tfNameFL.getText());
						
						//Increment floor counter
						++roomCounter;
						
						//Enable change floor name and remove floor button
						btnChangeRoomName.setEnabled(true);
						btnRemoveRM.setEnabled(true);
						
						//Change frame size
						framePersonalize.setBounds(0, 0, 450, 440);
						framePersonalize.setLocationRelativeTo(null);
					}
				});

				//Remove room listener
				btnRemoveRM.addMouseListener(new MouseAdapter(){
					public void mouseClicked(MouseEvent e){
						
						//Remove room panel and disable change and remove floor and button if no more floors will be left
						if(roomCounter == 1){
							framePersonalize.setBounds(0, 0, 450, 280);
							framePersonalize.setLocationRelativeTo(null);
							btnChangeRoomName.setEnabled(false);
							btnRemoveRM.setEnabled(false);
						}
						
						//Enable add floor button if there a floor can be added
						if(roomCounter == 5){
							btnAddRoom.setEnabled(true);
						}
						
						//Call remove floor method
						removeRoom();
						
						//Decrement floor counter
						--roomCounter;
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
						
						//call selection menu class
						new SelectionMenu();
						
						//dispose of personalization frame
						framePersonalize.dispose();
					}
				});
			}
		});
	}
}//end Personalize