/*
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park
 * Date: 12 March 2015
 */

import java.awt.BorderLayout; 
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
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
       new Entertainment();
    } //*/
	
	// Initialize
	
	private House house = new House();
	//private House house = User.getHouse();
	
	private int nFloor = 2;
	// private int nFloor = house.getFloorList().size();
	
    private int iFloorChoosed;
    private int iRoomChoosed;
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
    JButton helpbtn = new JButton("Help");
    
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
    	
    	EntFrm.getContentPane().setLayout(null);
    	EntFrm.setResizable(false);
       
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
        	roomPanels[i][j] = generateEntRoomPanel(i,j);
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
	    	            	EntFrm.remove(panel);
	    	            	EntFrm.repaint();
	    	            	EntFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = roomPanels[iFloorChoosed][iRoomChoosed];
	    	            	panel.setBounds(0, 0, 800, 500);
	    	            	
	    	            	roomLabel.setText("["+house.getFloorList().get(0).getName()+"] " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName() + " is selected]");
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
		
		// help button
		helpbtn.setBounds(330, 410, 150, 23);
		helpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				SelectionMenu.help();
			}
		});
		EntFrm.add(helpbtn);
				
        // Set Frame
        EntFrm.setTitle("Entertainment Controls");
        EntFrm.setLocation(120, 120);
        EntFrm.setSize(820,530);
        EntFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        EntFrm.setVisible(true);
    }

    /**
     * @param iFloor index of Floor
     * @param iRoom index of room
     * @return JPanel of Entertainment control of the i-th room on i-th floor
     */
    public JPanel generateEntRoomPanel(int iFloor, int iRoom){

    	JPanel panel = new JPanel();
        JLabel lblVolume = new JLabel("Volume");
        JLabel tvLabel = new JLabel("Televisions");
		JLabel radioLabel = new JLabel("Radio");
		JLabel lblVolume_2 = new JLabel("Volume");
		JLabel lblChannel = new JLabel("Channel");
		JLabel lblChannel_2 = new JLabel("Channel");
		ImageIcon img_tvON = new ImageIcon("tv_on.png");
    	ImageIcon img_tvOFF = new ImageIcon("tv_off.png");
    	ImageIcon img_radioON = new ImageIcon("radio_on.png");
    	ImageIcon img_radioOFF = new ImageIcon("radio_off.png");
		
		Room room = house.getFloorList().get(iFloor).getRoomList().get(iRoom);
		
		// Set labels
		panel.setLayout(null);
		
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
		
		lblChannel.setBounds(670, 31, 51, 16);
		lblChannel_2.setBounds(670, 206, 51, 16);
		panel.add(lblChannel);
		panel.add(lblChannel_2);
		

		// TVs
		for(int k=0; k<room.getTelevisionList().size(); k++){
			Television TV = room.getTelevisionList().get(k);
			JLabel tvlbl = new JLabel(room.getTelevisionList().get(k).getName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JSlider volSlider = new JSlider(JSlider.HORIZONTAL, 0, 2000, TV.getVolume());
			JSlider chnSlider = new JSlider(JSlider.HORIZONTAL, 0, 2000, TV.getChannel());
			JLabel chnLabel = new JLabel(""+chnSlider.getValue());
			JLabel imagetv = new JLabel(img_tvOFF);
			
			tvlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(tvlbl);
			
			imagetv.setBounds(27, 59+30*k, 15, 15);
			panel.add(imagetv);
			
			onButton.setBounds(215, 55+30*k, 51, 25);
			onButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imagetv.setIcon(img_tvON);
	            		TV.setStatus(true);
	            	}
	            }
	        });
			panel.add(onButton);

			offButton.setBounds(270, 55+30*k, 63, 25);
			offButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imagetv.setIcon(img_tvOFF);
	            		TV.setStatus(false);
	            	}
	            }
	        });
			panel.add(offButton);
			
			if (TV.getStatus())
				onButton.setSelected(true);
			else
				offButton.setSelected(true);
			
			group.add(onButton);
			group.add(offButton);
			
			volSlider.setSize(130, 23);
			volSlider.setLocation(430, 57+30*k);
			volSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		           TV.setVolume(volSlider.getValue());
				}
			});
			panel.add(volSlider);

			chnSlider.setSize(130, 23);
			chnSlider.setLocation(630, 57+30*k);
			chnSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		           TV.setChannel(chnSlider.getValue());
				}
			});
			panel.add(chnSlider);
			
			chnLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chnLabel.setBounds(765, 57+30*k, 90, 16);
			panel.add(chnLabel);
			
			chnSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		            chnLabel.setText(""+chnSlider.getValue());
				}
			});
		}
		
		// Radio		
		for(int k=0; k<room.getListRadio().size(); k++){
			Radio Radio = room.getListRadio().get(k);
			JLabel radiolbl = new JLabel(room.getListRadio().get(k).getName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JSlider volSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, Radio.getVolume());
			JSlider chnSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, Radio.getChannel());
			JLabel chnLabel = new JLabel(""+chnSlider.getValue());
			JLabel imageRadio = new JLabel(img_radioOFF);
			
			radiolbl.setBounds(47, 235+30*k, 150, 16);
			panel.add(radiolbl);
			
			imageRadio.setBounds(27, 235+30*k, 15, 15);
			panel.add(imageRadio);
			
			onButton.setBounds(215, 231+30*k, 51, 25);
			onButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageRadio.setIcon(img_radioON);
	            		Radio.setStatus(true);
	            	}
	            }
	        });
			panel.add(onButton);
						
			offButton.setBounds(270, 231+30*k, 63, 25);
			offButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageRadio.setIcon(img_radioOFF);
	            		Radio.setStatus(false);
	            	}
	            }
	        });
			panel.add(offButton);
						
			group.add(onButton);
			group.add(offButton);
			
			if (Radio.getStatus())
				onButton.setSelected(true);
			else
				offButton.setSelected(true);	
						
			volSlider.setSize(130, 23);
			volSlider.setLocation(430, 232+30*k);
			volSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		           Radio.setVolume(volSlider.getValue());
				}
			});
			panel.add(volSlider);
				
			chnLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
			chnLabel.setBounds(765, 232+30*k, 90, 16);
			panel.add(chnLabel);
			
			chnSlider.setSize(130, 23);
			chnSlider.setLocation(630, 232+30*k);
			chnSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		           Radio.setChannel(chnSlider.getValue());
		           chnLabel.setText(""+chnSlider.getValue());
				}
			});
			panel.add(chnSlider);			
		}
		
		return panel;
	}
}