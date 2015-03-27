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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;
 
public class Environmental{
	
	// Test Launching GUI
	///**
	public static void main(String[] args) {
       new Environmental();
   } //*/
	
	// Initialize
	private House house = new House();
	private int nFloor = 2;
	private int [] nRoom = new int[nFloor];
    private int iFloorChoosed;
    private int iRoomChoosed;
	private String [][] nameRoom = new String[nFloor][10];
    private JFrame EnvFrm = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels = new JPanel[nFloor][10];
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel roomLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    boolean [][] powersaver = new boolean[nFloor][10];
    
    public Environmental() {	    	
    	// Sample House
    	house.addFloor("Floor1");
    	house.addFloor("Floor2");
    	house.getFloorList().get(0).addRoom("dining");
    	house.getFloorList().get(0).addRoom("Living");
    	house.getFloorList().get(1).addRoom("bed");
    	house.getFloorList().get(0).getRoomList().get(0).addLight("Light1");
    	house.getFloorList().get(0).getRoomList().get(0).addLight("Light2");
    	house.getFloorList().get(0).getRoomList().get(1).addLight("Light3");
    	house.getFloorList().get(1).getRoomList().get(0).addLight("Light4");
    	house.getFloorList().get(1).getRoomList().get(0).addLight("Light5");
    	house.getFloorList().get(1).getRoomList().get(0).addLight("Light6");
    	house.getFloorList().get(0).getRoomList().get(0).addFaucet("Faucet@1");
    	house.getFloorList().get(0).getRoomList().get(1).addFaucet("Faucet@2");
    	house.getFloorList().get(0).getRoomList().get(1).addFaucet("Faucet@3");
    	house.getFloorList().get(0).getRoomList().get(1).addFaucet("Faucet@4");
    	house.getFloorList().get(1).getRoomList().get(0).addFaucet("Faucet@5");
    	house.getFloorList().get(1).getRoomList().get(0).addFaucet("Faucet@6");
    	
    	//
    	EnvFrm.getContentPane().setLayout(null);
    	EnvFrm.setResizable(false);
    	
    	//Initialize
    	for (int i=0; i<nFloor; i++){
    		nRoom[i] = house.getFloorList().get(i).getRoomList().size();
    		for (int j=0; j<nRoom[i]; j++){
    			nameRoom[i][j] = house.getFloorList().get(i).getRoomList().get(j).getName();
    		}
    	}
       
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<nRoom[i]; j++){
        	roomPanels[i][j] = generateEnvRoomPanel(i,j);
        	}
        }
        
     // For each floor
        for (int i=0; i<nFloor; i++){
    		// Generate menu for each floor
        	JMenu fileMenu = new JMenu(house.getFloorList().get(i).getName());
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
	    	            	EnvFrm.remove(panel);
	    	            	EnvFrm.repaint();
	    	            	EnvFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = roomPanels[iFloorChoosed][iRoomChoosed];
	    	            	panel.setBounds(0, 0, 800, 500);
	    	            	
	    	            	roomLabel.setText("["+house.getFloorList().get(0).getName()+"] " + nameRoom[iFloorChoosed][iRoomChoosed] + " is selected]");
	    	            	roomLabel.setBounds(610, 410, 200, 23);
	    	        		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	    	        		EnvFrm.getContentPane().add(roomLabel);
	    	        		
	    	            	EnvFrm.getContentPane().add(panel);
	    	            	EnvFrm.repaint();
	    	            	EnvFrm.revalidate();
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
        EnvFrm.setJMenuBar(menuBar);
        EnvFrm.getContentPane().add(panel);
		menuBtn.setBackground(SystemColor.info);
		menuBtn.setForeground(Color.BLACK);
        
        // 'return to menu' button
		menuBtn.setBounds(20, 410, 150, 23);
		menuBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	EnvFrm.setVisible(false);
            	new SelectionMenu();
            }
        });
		
		EnvFrm.getContentPane().add(menuBtn);
		
		// room label
		roomLabel.setBounds(180, 100, 500, 40);
		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		EnvFrm.getContentPane().add(roomLabel);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		panel_2.setBounds(12, 391, 778, 2);
		
		EnvFrm.getContentPane().add(panel_2);
		
        // Set Frame
        EnvFrm.setTitle("Entertainment Controls");
        EnvFrm.setLocation(120, 120);
        EnvFrm.setSize(820,530);
        EnvFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EnvFrm.setVisible(true);  
    }
    

    public JPanel generateEnvRoomPanel(int iFloor, int iRoom){ // Later, it would get parameter 'int nFloor'
		//Make panel
    	JPanel panel = new JPanel();
		panel.setLayout(null);
    	
		int nLight = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getLightList().size();
		String [] lightName = new String[nLight]; 
		for (int i = 0 ; i< nLight; i++){
			lightName[i] = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getLightList().get(i).getlightName();
		}
		
		int nFaucet = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getFaucetList().size();
		String [] faucetName = new String[nFaucet];
		for (int i = 0 ; i< nFaucet; i++){
			faucetName[i] = house.getFloorList().get(iFloor).getRoomList().get(iRoom).getFaucetList().get(i).getName();
		}
		
		// First Column
		// Thermostat
		JLabel tempLabel = new JLabel("Temerature (70F)");
		tempLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tempLabel.setBounds(65,20,200,23);
		panel.add(tempLabel);
		
		JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 20, 100, 70);
		tempSlider.setPaintLabels(true);
		tempSlider.setPaintTicks(true);
		tempSlider.setPaintTrack(true);
		tempSlider.setMajorTickSpacing(20);
		tempSlider.setMinorTickSpacing(5);
		tempSlider.setBounds(30,50,200,50);
		tempSlider.addChangeListener(new ChangeListener(){
			public void stateChanged (ChangeEvent e){
	            tempLabel.setText("Temerature (" + tempSlider.getValue() + "F)");
			}
		});
		panel.add(tempSlider);
		
		// Powersaver
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
		// Lights
		JLabel lightLabel = new JLabel("Lights");
		lightLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lightLabel.setBounds(400,20,200,23);
		panel.add(lightLabel);
		
		ArrayList<JRadioButton> lArray = new ArrayList<JRadioButton>();
		for(int k=0; k<nLight; k++){
			JRadioButton button = new JRadioButton(lightName[k]);
			button.setBounds(390,50+30*k,100,23);
			button.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	System.out.print(button.getText());
	            	System.out.println(e.getStateChange() == ItemEvent.SELECTED ? " SELECTED" : " DESELECTED");
	            }
	        });
			lArray.add(button);
			panel.add(button);
		}
		
		// Third Column
		// Faucets
		JLabel faucetLabel = new JLabel("Faucets");
		faucetLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		faucetLabel.setBounds(640,20,200,23);
		panel.add(faucetLabel);
		
		ArrayList<JRadioButton> fArray = new ArrayList<JRadioButton>();
		for(int k=0; k<nFaucet; k++){
			JRadioButton button = new JRadioButton(faucetName[k]);
			button.setBounds(630,50+30*k,200,23);
			button.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	System.out.print(button.getText());
	            	System.out.println(e.getStateChange() == ItemEvent.SELECTED ? " SELECTED" : " DESELECTED");
	            }
			});
			
			fArray.add(button);
			panel.add(button);
		}
		
		return panel;
	}
}