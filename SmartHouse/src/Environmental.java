/*
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park
 * Date: 11 March 2015
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
	/**
	Wpublic static void main(String[] args) {
       new Environmental();
   } //*/
	
	// Initialize
	private int nFloor = 3;
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
    
    public Environmental() {	    	
    	EnvFrm.getContentPane().setLayout(null);
    	EnvFrm.setResizable(false);
    	// These would be given by parameter later
        nRoom[0] = 2;
        nRoom[1] = 1;
        nRoom[2] = 3;
        
        nameRoom[0][0] = "Dining";
        nameRoom[0][1] = "Room";
        nameRoom[1][0] = "Living";
        nameRoom[2][0] = "Bed1";
        nameRoom[2][1] = "Bed2";
        nameRoom[2][2] = "Bed3";
        
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<nRoom[i]; j++){
        	roomPanels[i][j] = generateRoomPanel(i,j);
        	}
        }
        roomPanels[0][1] = generateRoomPanel2(0,0); // Different Panel for test
        
     // For each floor
        for (int i=0; i<nFloor; i++){
    		// Generate menu for each floor
        	JMenu fileMenu = new JMenu("Floor " + (i+1));
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
	    	            	
	    	            	roomLabel.setText("[Floor "+ (iFloorChoosed+1) +", " + nameRoom[iFloorChoosed][iRoomChoosed] + " is selected]");
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
        EnvFrm.setTitle("Environmental Controls");
        EnvFrm.setLocation(120, 120);
        EnvFrm.setSize(820,530);
        EnvFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EnvFrm.setVisible(true);
    }

    public JPanel generateRoomPanel(int iFloor, int iRoom){ // Later, it would get parameter 'int nFloor'
		//Later, it would get by method
    	JPanel panel = new JPanel();
    	
		int nLight = 3;
		String [] lightName = new String[nLight]; 
		lightName[0] = "Light1";
		lightName[1] = "Light2";
		lightName[2] = "Light3";
		
		int nFaucet = 2;
		String [] faucetName = new String[nFaucet]; 
		faucetName[0] = "Faucet1";
		faucetName[1] = "FFFaucet2";
		
		//Make panel
		panel.setLayout(null);

		// First Column
		JLabel tempLabel = new JLabel("Temerature (70F)");
		tempLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tempLabel.setBounds(65,20,200,23);
		panel.add(tempLabel);
		
		JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
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
		
		JButton psBtn = new JButton("Power Saver");
		psBtn.setBounds(305, 350, 200, 30);
		panel.add(psBtn);
		
		// Second Column
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
    
    public JPanel generateRoomPanel2(int iFloor, int iRoom){ // Later, it would get parameter 'int nFloor'
		//Later, it would get by method

    	JPanel panel = new JPanel();
    	
		int nLight = 2;
		String [] lightName = new String[nLight]; 
		lightName[0] = "BBBasdht1";
		lightName[1] = "asdfdft2";
		
		int nFaucet = 5;
		String [] faucetName = new String[nFaucet]; 
		faucetName[0] = "Fafet1";
		faucetName[1] = "FFbwecet2";
		faucetName[2] = "123bwecet3";
		faucetName[3] = "ABbwecet4";
		faucetName[4] = "@@bwecet5";
		
		//Make panel
		panel.setLayout(null);

		// First Column
		JLabel tempLabel = new JLabel("Temasdture (70F)");
		tempLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tempLabel.setBounds(65,20,200,23);
		panel.add(tempLabel);
		
		JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
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
		
		JButton psBtn = new JButton("Power Saver");
		psBtn.setBounds(305, 350, 200, 30);
		panel.add(psBtn);
		
		// Second Column
		JLabel lightLabel = new JLabel("Lights");
		lightLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lightLabel.setBounds(400,20,200,23);
		panel.add(lightLabel);
		
		ArrayList<JRadioButton> lArray = new ArrayList<JRadioButton>();
		for(int k=0; k<nLight; k++){
			JRadioButton button = new JRadioButton(lightName[k]);
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
		
		// Third Column
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