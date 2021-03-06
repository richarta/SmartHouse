/**
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * @author: Young J. Park
 * Date: 01 April 2015
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
 
public class Environmental{

	// Initialize
	private House house;
	private int nFloor;
    private int iFloorChoosed;
    private int iRoomChoosed;
    private JFrame EnvFrm = new JFrame();
    private JFrame helpf = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel dirLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    JButton helpbtn = new JButton("Help");
    
    public Environmental() {
    	
    	// Call House
    	User.openHouseStatus();
    	house = User.getHouse();
    	nFloor = house.getFloorList().size();
    	
    	// Initialize the frame
    	EnvFrm.getContentPane().setLayout(null);
    	EnvFrm.setResizable(false);
        
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
    	            		User.openHouseStatus();
    	            		house = User.getHouse();
    	            		
    	            		// Get floor and room index
	    	            	iFloorChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(0));
	    	            	iRoomChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(1));
	    	            	
	    	            	// Remove JPanel
	    	            	EnvFrm.remove(panel);
	    	            	EnvFrm.repaint();
	    	            	EnvFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = generateEnvRoomPanel(iFloorChoosed,iRoomChoosed);
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
            	helpf.setVisible(false);
            	new SelectionMenu();
            }
        });
		EnvFrm.getContentPane().add(menuBtn);
		
		
		// Main menu label
		dirLabel.setBounds(0, 100, 802, 40);
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
				help();
			}
		});
		EnvFrm.getContentPane().add(helpbtn);
		
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
    	JLabel tempLabel = new JLabel("Temerature (" + house.getThermostat().getTemp() + "F)");
    	JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 20, 100, house.getThermostat().getTemp());
    	JLabel lightLabel = new JLabel("Lights");
    	JLabel faucetLabel = new JLabel("Faucets");
        JLabel actionLabel = new JLabel("");
        JButton setBtn = new JButton("Set Temperature");
    	JButton psBtn = new JButton("Power Saver");
    	ArrayList <JRadioButton> offBtnList = new ArrayList<JRadioButton>();
    	ImageIcon img_lightON = new ImageIcon("icon/light_on.png");
    	ImageIcon img_lightOFF = new ImageIcon("icon/light_off.png");
    	ImageIcon img_faucetON = new ImageIcon("icon/faucet_on.png");
    	ImageIcon img_faucetOFF = new ImageIcon("icon/faucet_off.png");
    	
		panel.setLayout(null);
		
		// Set labels;
		lightLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lightLabel.setBounds(33, 20, 90, 20);
		panel.add(lightLabel);
		
		faucetLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		faucetLabel.setBounds(305, 20, 90, 20);
		panel.add(faucetLabel);
		
		actionLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		actionLabel.setBounds(480, 410, 300, 23);
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
	            tempLabel.setText("Temerature (" + tempSlider.getValue() + "F)");
			}
		});
		panel.add(tempSlider);
		
		setBtn.setBackground(new Color(50, 50, 113));
		setBtn.setForeground(Color.WHITE);
		setBtn.setBounds(615,110,130,20);
		setBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	actionLabel.setText("Desired temperature is changed ");
            	house.getThermostat().setTemp(tempSlider.getValue());
            }
        });
		panel.add(setBtn);
		
		// Power saver
		psBtn.setBackground(new Color(60, 179, 113));
		psBtn.setForeground(Color.BLACK);
		psBtn.setBounds(305, 350, 200, 30);
		psBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		house.getThermostat().setTemp(70);
        		tempSlider.setValue(70);
        		tempLabel.setText("Temerature (70F)");
		
        		for (int i=0; i<offBtnList.size(); i++){
        			offBtnList.get(i).setSelected(true);
        		}
        		
        		for (int i=0; i<room.getFaucetList().size(); i++){
        			room.getFaucetList().get(i).setStatus(false);
        		}
        		
        		for (int i=0; i<room.getLightList().size(); i++){
        			room.getLightList().get(i).setStatus(false);
        		}
        		
        		actionLabel.setText("Power Saver is activated ");
            }
        });
		panel.add(psBtn);
		
		// Lights
		for(int k=0; k<room.getLightList().size(); k++){
			Light light = room.getLightList().get(k);
			JLabel lightlbl = new JLabel(room.getLightList().get(k).getName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JLabel imageLight = new JLabel(light.getStatus() ? img_lightON : img_lightOFF);
			
			lightlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(lightlbl);
			
			imageLight.setBounds(27, 59+30*k, 15, 15);
			panel.add(imageLight);
			
			onButton.setBounds(175, 55+30*k, 51, 25);
			onButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageLight.setIcon(img_lightON);
	            		light.setStatus(true);

	            		actionLabel.setText(light.getName() + " is ON ");
	            	}
	            }
	        });
			panel.add(onButton);

			offButton.setBounds(230, 55+30*k, 63, 25);
			offButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageLight.setIcon(img_lightOFF);
	            		light.setStatus(false);
	            		
	            		actionLabel.setText(light.getName() + " is OFF ");
	            	}
	            }
	        });
			offBtnList.add(offButton);
			panel.add(offButton);
			
			if (light.getStatus())
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
			
			onButton.setBounds(453, 55+30*k, 51, 25);
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

			offButton.setBounds(508, 55+30*k, 63, 25);
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
    
    /**
     * Pop-up help
     */
    private void help(){
		helpf.setTitle("HELP - Environmental Control");
		helpf.setSize(640, 240);
		helpf.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("<Hello and welcome to your SmartHouse Environmentnal Control Panel!>");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl1.setBounds(0,13,622,15);
		helpf.getContentPane().add(lbl1, BorderLayout.NORTH);
		
		JLabel lbl2 = new JLabel("You can change settings that include lights, faucets, temperature and power saver mode.");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl2.setBounds(0, 41, 622, 15);
		helpf.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("[Light] You can turn on/off the lights.");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl3.setBounds(0, 90, 622, 15);
		helpf.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("[Faucet] You can turn on/off the faucets.");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl4.setBounds(0, 110, 622, 15);
		helpf.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("[Thermostat] You can adjust temperature.");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl5.setBounds(0, 130, 622, 15);
		helpf.getContentPane().add(lbl5);
		
		JLabel lbl6 = new JLabel("[Power saver] Turn off every light and faucet. Adjust room temperature as 70F");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl6.setBounds(0, 150, 622, 15);
		helpf.getContentPane().add(lbl6);
		
		helpf.setVisible(true);
    }
}