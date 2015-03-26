/*
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park
 * Date: 12 March 2015
 */

import java.awt.BorderLayout; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;
 
public class Entertainment{
	
	// Test Launching GUI
	/**
	public static void main(String[] args) {
       new Environmental();
   } //*/
	
	// Initialize
	private House house = new House();
	private int nFloor = 2;
	// private House house = User.getHouse();
	// private int nFloor = house.getFloorList().size();
	
	private int [] nRoom = new int[nFloor];
    private int iFloorChoosed;
    private int iRoomChoosed;
	private String [][] nameRoom = new String[nFloor][10];
    private JFrame EntFrm = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels = new JPanel[nFloor][10];
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel roomLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    boolean [][] powersaver = new boolean[nFloor][10];
    
    public Entertainment() {
    	// Sample House
    	house.addFloor("Floor1");
    	house.addFloor("Floor2");
    	house.getFloorList().get(0).addRoom("dining");
    	house.getFloorList().get(0).addRoom("Living");
    	house.getFloorList().get(1).addRoom("bed");
    	house.getFloorList().get(0).getRoomList().get(0).addRadio("Radio1");
    	house.getFloorList().get(0).getRoomList().get(0).addRadio("Radio2");
    	house.getFloorList().get(0).getRoomList().get(1).addRadio("Radio3");
    	house.getFloorList().get(1).getRoomList().get(0).addRadio("Radio4");
    	house.getFloorList().get(1).getRoomList().get(0).addRadio("Radio5");
    	house.getFloorList().get(1).getRoomList().get(0).addRadio("Radio6");
    	house.getFloorList().get(0).getRoomList().get(0).addTelevision("TV@1");
    	house.getFloorList().get(0).getRoomList().get(1).addTelevision("TV@2");
    	house.getFloorList().get(0).getRoomList().get(1).addTelevision("TV@3");
    	house.getFloorList().get(0).getRoomList().get(1).addTelevision("TV@4");
    	house.getFloorList().get(1).getRoomList().get(0).addTelevision("TV@5");
    	house.getFloorList().get(1).getRoomList().get(0).addTelevision("TV@6");
    	
    	//
    	EntFrm.getContentPane().setLayout(null);
    	EntFrm.setResizable(false);
    	
    	//Initialize
    	for (int i=0; i<nFloor; i++){
    		nRoom[i] = house.getFloorList().get(i).getRoomList().size();
    		for (int j=0; j<nRoom[i]; j++){
    			nameRoom[i][j] = house.getFloorList().get(0).getRoomList().get(j).getName();
    		}
    	}
       
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<nRoom[i]; j++){
        	roomPanels[i][j] = generateEntRoomPanel(i,j);
        	}
        }
        
     // For each floor
        for (int i=0; i<nFloor; i++){
    		// Generate menu for each floor
        	JMenu fileMenu = new JMenu(house.getFloorList().get(0).getName());
        	menus.add(fileMenu);
        	
        	// For each room
        	for(int j=0; j<nRoom[i]; j++){
        		// Generate menu-item for each room
        		JRadioButtonMenuItem radioBtnMenu = new JRadioButtonMenuItem(nameRoom[i][j]);
        		radioBtnMenu.setName(i+""+j); // give a name to room. e.g. Second room on first floor is "12". Third room of second floor is "23"
        		
        		// If you click each room, JFrame shows a panel for the selected room
        		radioBtnMenu.addItemListener(new ItemListener() {
    	            public void itemStateChanged(ItemEvent e) {
    	            	if (e.getStateChange() == ItemEvent.SELECTED){
	    	            	
    	            		// Get floor and room index
	    	            	iFloorChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(0));
	    	            	iRoomChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(1));
	    	            	
	    	            	// Remove JPanel
	    	            	EntFrm.remove(panel);
	    	            	EntFrm.repaint();
	    	            	EntFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = roomPanels[iFloorChoosed][iRoomChoosed];
	    	            	panel.setBounds(0, 0, 800, 500);
	    	            	
	    	            	roomLabel.setText("["+house.getFloorList().get(0).getName()+"] " + nameRoom[iFloorChoosed][iRoomChoosed] + " is selected]");
	    	            	roomLabel.setBounds(610, 410, 200, 23);
	    	        		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	    	        		EntFrm.getContentPane().add(roomLabel);
	    	        		
	    	            	EntFrm.getContentPane().add(panel);
	    	            	EntFrm.repaint();
	    	            	EntFrm.revalidate();
    	            	}
    	            }
    	        });
        		
        		// Group buttons and add into menu
        		grop.add(radioBtnMenu);
        		fileMenu.add(radioBtnMenu);
        	}
        	
        	// Add menu into menu bar
        	menuBar.add(fileMenu);
        }

        // Set every component
        EntFrm.setJMenuBar(menuBar);
        EntFrm.getContentPane().add(panel);
		menuBtn.setBackground(SystemColor.info);
		menuBtn.setForeground(Color.BLACK);
        
        // 'return to menu' button
		menuBtn.setBounds(20, 410, 150, 23);
		menuBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EntFrm.setVisible(false);
            	new SelectionMenu();
            }
        });
		EntFrm.getContentPane().add(menuBtn);
		
		// room label
		roomLabel.setBounds(180, 100, 500, 40);
		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		EntFrm.getContentPane().add(roomLabel);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		panel_2.setBounds(12, 391, 778, 2);
		
		EntFrm.getContentPane().add(panel_2);
		
        // Set Frame
        EntFrm.setTitle("Entertainment Controls");
        EntFrm.setLocation(120, 120);
        EntFrm.setSize(820,530);
        EntFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EntFrm.setVisible(true);
    }

    public JPanel generateEntRoomPanel(int iFloor, int iRoom){
    	// Initialize
    	JPanel panel = new JPanel();
		int nRadio = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getListRadio().size();
		String [] radioName = new String[nRadio]; 
		for(int i=0; i<nRadio; i++){
			radioName[i] = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getListRadio().get(i).getName();
		}
	
		int nTV = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getTelevisionList().size();
		String [] TVName = new String[nTV]; 
		for(int i=0; i<nTV; i++){
			TVName[i] = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getTelevisionList().get(i).getName();
		}
		
		//
        JLabel lblVolume = new JLabel("Volume");
        JLabel tvLabel = new JLabel("Televisions");
		JLabel radioLabel = new JLabel("Radio");
		JLabel lblVolume_2 = new JLabel("Volume");
		
		tvLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tvLabel.setBounds(27, 30, 90, 16);
		panel.add(tvLabel);
		
		radioLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioLabel.setBounds(27, 206, 90, 16);
		panel.add(radioLabel);
		
		lblVolume.setBounds(470, 31, 51, 16);
		lblVolume_2.setBounds(470, 206, 51, 16);
		panel.add(lblVolume);
		panel.add(lblVolume_2);
		
		//Make panel
		panel.setLayout(null);

		// TVs
		for(int k=0; k<nTV; k++){
			JLabel tvlbl = new JLabel(TVName[k]);
			tvlbl.setBounds(27, 59+30*k, 150, 16);		
			/*
			tvlbl.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	System.out.print(button.getText());
	            	System.out.println(e.getStateChange() == ItemEvent.SELECTED ? " SELECTED" : " DESELECTED");
	            }
	        });*/
			panel.add(tvlbl);
			
			JRadioButton onButton = new JRadioButton("On");
			onButton.setBounds(215, 55+30*k, 51, 25);
			panel.add(onButton);
			
			JRadioButton offButton = new JRadioButton("Off");
			offButton.setBounds(270, 55+30*k, 63, 25);
			panel.add(offButton);

			ButtonGroup group = new ButtonGroup();
			group.add(onButton);
			group.add(offButton);
			
			JSlider volSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
			volSlider.setSize(130, 23);
			volSlider.setLocation(430, 57+30*k);
			panel.add(volSlider);
		}
		
		// Radio		
		for(int k=0; k<nRadio; k++){
			JLabel radiolbl = new JLabel(radioName[k]);
			radiolbl.setBounds(27, 235+30*k, 150, 16);
			panel.add(radiolbl);
			
			JRadioButton onButton = new JRadioButton("On");
			onButton.setBounds(215, 231+30*k, 51, 25);
			panel.add(onButton);
			
			JRadioButton offButton = new JRadioButton("Off");
			offButton.setBounds(270, 231+30*k, 63, 25);
			panel.add(offButton);
			
			ButtonGroup group = new ButtonGroup();
			group.add(onButton);
			group.add(offButton);
			
			JSlider volSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
			volSlider.setSize(130, 23);
			volSlider.setLocation(430, 232+30*k);
			panel.add(volSlider);
		}
		
		return panel;
	}
    
    // Test Panel
    public JPanel generateTestRoomPanel(int iFloor, int iRoom){ // Later, it would get parameter 'int nFloor'
		//Later, it would get by method

    	JPanel panel = new JPanel();
    	
		int nRadio = 2;
		String [] radioName = new String[nRadio]; 
		radioName[0] = "BBBasdht1";
		radioName[1] = "asdfdft2";
		
		int nTV = 5;
		String [] TVName = new String[nTV]; 
		TVName[0] = "Fafet1";
		TVName[1] = "FFbwecet2";
		TVName[2] = "123bwecet3";
		TVName[3] = "ABbwecet4";
		TVName[4] = "@@bwecet5";
		
		//Make panel
		panel.setLayout(null);

		// First Column
		// TVs
		JLabel TVLabel = new JLabel("TVs");
		TVLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		TVLabel.setBounds(60,20,200,23);
		panel.add(TVLabel);
		
		ArrayList<JRadioButton> fArray = new ArrayList<JRadioButton>();
		for(int k=0; k<nTV; k++){
			JRadioButton button = new JRadioButton(TVName[k]);
			button.setBounds(50,50+30*k,200,23);
			button.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	System.out.print(button.getText());
	            	System.out.println(e.getStateChange() == ItemEvent.SELECTED ? " SELECTED" : " DESELECTED");
	            }
			});
			
			fArray.add(button);
			panel.add(button);
		}
		
		powersaver[iFloor][iRoom] = false;
		JButton psBtn = new JButton("Power Saver ON");
		psBtn.setBackground(new Color(60, 179, 113));
		psBtn.setForeground(Color.BLACK);
		psBtn.setBounds(305, 350, 200, 30);
		psBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (powersaver[iFloor][iRoom]) {
            		powersaver[iFloor][iRoom] = false;
            		psBtn.setText("Power Saver ON");
            		psBtn.setBackground(new Color(60, 179, 113));
            	}
            	else {
            		powersaver[iFloor][iRoom] = true;
            		psBtn.setText("Power Saver OFF");
            		psBtn.setBackground(SystemColor.inactiveCaption);
            		
            	}
            }
        });
		panel.add(psBtn);
		
		// Second Column
		JLabel radioLabel = new JLabel("Radios");
		radioLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioLabel.setBounds(400,20,200,23);
		panel.add(radioLabel);
		
		ArrayList<JRadioButton> lArray = new ArrayList<JRadioButton>();
		for(int k=0; k<nRadio; k++){
			JRadioButton button = new JRadioButton(radioName[k]);
			button.setBounds(390,50+30*k,200,23);
			button.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	System.out.print(button.getText());
	            	System.out.println(e.getStateChange() == ItemEvent.SELECTED ? " SELECTED" : " DESELECTED");
	            }
	        });
		
			lArray.add(button);
			panel.add(button);
		}
		
		return panel;
    }
}