/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park
 * Date: 09 April 2015
 */

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;
 
public class Environmental{
	
	// Test Launching GUI
	/**
	public static void main(String[] args) {
       new Environmental();
   } //*/
	
	// Initialize
	private House house = new House();
	//private House house = User.getHouse();
		
	private int nFloor = 2;
	// private int nFloor = house.getFloorList().size();
	
    private int iFloorChoosed;
    private int iRoomChoosed;
    private JFrame EnvFrm = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels = new JPanel[nFloor][10];
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel dirLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    boolean [][] powersaver = new boolean[nFloor][10];
    JButton helpbtn = new JButton("Help");
    
    public Environmental() {	    	
    	// Sample House
    	house.addFloor("Floor1");
    	house.addFloor("Floor2");
    	house.getFloorList().get(0).addRoom("dining");
    	house.getFloorList().get(0).addRoom("Living");
    	house.getFloorList().get(1).addRoom("bed");
    	house.getFloorList().get(0).getRoomList().get(0).addThermostat("Thermo");
    	house.getFloorList().get(0).getRoomList().get(1).addThermostat("Thermo");
    	house.getFloorList().get(1).getRoomList().get(0).addThermostat("Thermo");
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
    	EnvFrm.getContentPane().setLayout(null);
    	EnvFrm.setResizable(false);
       
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
        	roomPanels[i][j] = generateEnvRoomPanel(i,j);
        	}
        }
        
     // For each floor
        for (int i=0; i<nFloor; i++){
    		// Generate menu for each floor
        	JMenu fileMenu = new JMenu(house.getFloorList().get(i).getName());
        	menus.add(fileMenu);
        	
        	// For each room
        	for(int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
        		// Generate menu-item for each room
        		JRadioButtonMenuItem radioBtnMenu = new JRadioButtonMenuItem(house.getFloorList().get(i).getRoomList().get(j).getName());
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
   	            	
	    	            	// Change the title to show room selected
	    	            	String s = house.getFloorList().get(iFloorChoosed).getName()+", " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName();
	    	            	EnvFrm.setTitle("Environmental Controls - " + s);
	    	        		
	    	        		dirLabel.setVisible(false);
	    	        		
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
		
		// Main menu label
		dirLabel.setBounds(180, 100, 500, 40);
		dirLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		EnvFrm.getContentPane().add(dirLabel);
		
		// Border
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		panel_2.setBounds(12, 391, 778, 2);
		EnvFrm.getContentPane().add(panel_2);
		
		// help button
		helpbtn.setBounds(330, 410, 150, 23);
		helpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				SelectionMenu.help();
			}
		});
		EnvFrm.add(helpbtn);
		
        // Set Frame
        EnvFrm.setTitle("Environmental Controls");
        EnvFrm.setLocation(120, 120);
        EnvFrm.setSize(820,530);
        EnvFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EnvFrm.setVisible(true);
    }
    

    /**
     * @param iFloor index of Floor
     * @param iRoom index of room
     * @return JPanel of Environmental control of the i-th room on i-th floor
     */
    public JPanel generateEnvRoomPanel(int iFloor, int iRoom){
    	Room room = house.getFloorList().get(iFloor).getRoomList().get(iRoom);
    	JPanel panel = new JPanel();
    	JLabel tempLabel = new JLabel("Temerature (" + room.getThermostat().getTemp() + "F)");
    	JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 20, 100, room.getThermostat().getTemp());
    	JLabel lightLabel = new JLabel("Lights");
    	JLabel faucetLabel = new JLabel("Faucets");
        JLabel actionLabel = new JLabel("");
    	JButton psBtn = new JButton("Power Saver is OFF");
    	ArrayList <JRadioButton> offBtnList = new ArrayList<JRadioButton>();
    	ImageIcon img_lightON = new ImageIcon("light_on.png");
    	ImageIcon img_lightOFF = new ImageIcon("light_off.png");
    	ImageIcon img_faucetON = new ImageIcon("faucet_on.png");
    	ImageIcon img_faucetOFF = new ImageIcon("faucet_off.png");
    	
		panel.setLayout(null);
		
		// Set labels;
		lightLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lightLabel.setBounds(33, 20, 90, 20);
		panel.add(lightLabel);
		
		faucetLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		faucetLabel.setBounds(305, 20, 90, 20);
		panel.add(faucetLabel);
		
		actionLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		actionLabel.setBounds(580, 410, 200, 23);
		actionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(actionLabel);
		
		// Thermostat
		tempLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		tempLabel.setBounds(615,20,200,23);
		panel.add(tempLabel);
		
		tempSlider.setPaintLabels(true);
		tempSlider.setPaintTicks(true);
		tempSlider.setPaintTrack(true);
		tempSlider.setMajorTickSpacing(20);
		tempSlider.setMinorTickSpacing(5);
		tempSlider.setBounds(580,50,200,50);
		tempSlider.addChangeListener(new ChangeListener(){
			public void stateChanged (ChangeEvent e){
				room.getThermostat().setTemp(tempSlider.getValue());
	            tempLabel.setText("Temerature (" + tempSlider.getValue() + "F)");
	            actionLabel.setText("Temperature was changed ");
			}
		});
		panel.add(tempSlider);
		
		// Powersaver
		powersaver[iFloor][iRoom] = false;
		psBtn.setBackground(SystemColor.inactiveCaption);
		psBtn.setForeground(Color.BLACK);
		psBtn.setBounds(305, 350, 200, 30);
		psBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	if (powersaver[iFloor][iRoom]) {
            		powersaver[iFloor][iRoom] = false;
            		psBtn.setText("Power Saver is OFF");
            		psBtn.setBackground(SystemColor.inactiveCaption);
            		
            		actionLabel.setText("Power Saver is deactivated ");
            	}
            	else {
            		powersaver[iFloor][iRoom] = true;
            		psBtn.setText("Power Saver is ON");
            		psBtn.setBackground(new Color(60, 179, 113));
            		
            		room.getThermostat().setTemp(70);
            		tempSlider.setValue(70);
            		tempLabel.setText("Temerature (70F)");
  		
            		for (int i=0; i<offBtnList.size(); i++){
            			offBtnList.get(i).setSelected(true);
            		}
            		
            		for (int i=0; i<room.getFaucetList().size(); i++){
            			room.getFaucetList().get(i).setStatus(false);
            		}
            		
            		for (int i=0; i<room.getLightList().size(); i++){
            			room.getLightList().get(i).setLightStatus(false);
            		}
            		
            		actionLabel.setText("Power Saver is activated ");
            	}
            }
        });
		panel.add(psBtn);
		
		// Lights
		for(int k=0; k<room.getLightList().size(); k++){
			Light light = room.getLightList().get(k);
			JLabel lightlbl = new JLabel(room.getLightList().get(k).getlightName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JLabel imageLight = new JLabel(light.getLightStatus() ? img_lightON : img_lightOFF);
			
			lightlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(lightlbl);
			
			imageLight.setBounds(27, 59+30*k, 15, 15);
			panel.add(imageLight);
			
			onButton.setBounds(115, 55+30*k, 51, 25);
			onButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageLight.setIcon(img_lightON);
	            		light.setLightStatus(true);

	            		actionLabel.setText(light.getlightName() + " is ON ");
	            	}
	            }
	        });
			panel.add(onButton);

			offButton.setBounds(170, 55+30*k, 63, 25);
			offButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageLight.setIcon(img_lightOFF);
	            		light.setLightStatus(false);
	            		
	            		actionLabel.setText(light.getlightName() + " is OFF ");
	            	}
	            }
	        });
			offBtnList.add(offButton);
			panel.add(offButton);
			
			if (light.getLightStatus())
				onButton.setSelected(true);
			else
				offButton.setSelected(true);
			
			group.add(onButton);
			group.add(offButton);
		}
		// Faucets
		for(int k=0; k<room.getFaucetList().size(); k++){
			Faucet faucet = room.getFaucetList().get(k);
			JLabel faucetlbl = new JLabel(room.getFaucetList().get(k).getName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JLabel imageFaucet = new JLabel(faucet.getStatus() ? img_faucetON : img_faucetOFF);
			
			faucetlbl.setBounds(325, 59+30*k, 150, 16);		
			panel.add(faucetlbl);
			
			imageFaucet.setBounds(305, 59+30*k, 15, 15);
			panel.add(imageFaucet);
			
			onButton.setBounds(393, 55+30*k, 51, 25);
			onButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		faucet.setStatus(true);
	            		imageFaucet.setIcon(img_faucetON);
	            		
	            		actionLabel.setText(faucet.getName() + " is ON ");
	            	}
	            }
	        });
			panel.add(onButton);

			offButton.setBounds(448, 55+30*k, 63, 25);
			offButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		faucet.setStatus(false);
	            		imageFaucet.setIcon(img_faucetOFF);
	            		
	            		actionLabel.setText(faucet.getName() + " is OFF ");
	            	}
	            }
	        });
			offBtnList.add(offButton);
			panel.add(offButton);
			
			if (faucet.getStatus())
				onButton.setSelected(true);
			else
				offButton.setSelected(true);
			
			group.add(onButton);
			group.add(offButton);
		}
		
		actionLabel.setText("");
		return panel;
	}
}