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
import javax.swing.JComponent;
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

public class Entertainment{
	
	// Test Launching GUI
	/**
	public static void main(String[] args) {
       new Entertainment();
    } //*/
	
	// Initialize
	private House house;
	private int nFloor;
    private int iFloorChoosed;
    private int iRoomChoosed;
    private int nMaxRoom = 0;
    private JFrame EntFrm = new JFrame();
    private JFrame helpf = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels;
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel dirLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    JButton helpbtn = new JButton("Help");
    
    public Entertainment() {
    	// Call House
    	house = User.getHouse();
    	nFloor = house.getFloorList().size();
    	
    	// Find the max number of room in one floor, and make roomPanel list
    	for (int i=0; i<nFloor; i++){
    		if  (house.getFloorList().get(i).getRoomList().size() > nMaxRoom)
    			nMaxRoom = house.getFloorList().get(i).getRoomList().size();
    	}
    	roomPanels = new JPanel[nFloor][nMaxRoom];
    	
    	// Initialize the frame
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
	    	            	
	    	            	// Change the title to show room selected
	    	            	String s = house.getFloorList().get(iFloorChoosed).getName()+", " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName();
	    	            	EntFrm.setTitle("Environmental Controls - " + s);
	    	        		
	    	        		dirLabel.setVisible(false);
	    	        		
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
            	helpf.setVisible(false);
            	new SelectionMenu();
            }
        });
		EntFrm.getContentPane().add(menuBtn);
		
		// Main menu label
		dirLabel.setBounds(0, 100, 802, 40);
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dirLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		EntFrm.getContentPane().add(dirLabel);
		
		// Border
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		panel_2.setBounds(12, 391, 778, 2);
		EntFrm.getContentPane().add(panel_2);
		
		// help button
		helpbtn.setBounds(330, 410, 150, 23);
		helpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				help();
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
		JLabel actionLabel = new JLabel("");
		JButton psBtn = new JButton("Power Saver");
		ArrayList <JRadioButton> offBtnList = new ArrayList<JRadioButton>();
		ImageIcon img_tvON = new ImageIcon("icon/tv_on.png");
    	ImageIcon img_tvOFF = new ImageIcon("icon/tv_off.png");
    	ImageIcon img_radioON = new ImageIcon("icon/radio_on.png");
    	ImageIcon img_radioOFF = new ImageIcon("icon/radio_off.png");
		
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
		
		actionLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		actionLabel.setBounds(580, 410, 200, 23);
		actionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(actionLabel);
		
		// Power saver
		psBtn.setBackground(new Color(60, 179, 113));
		psBtn.setForeground(Color.BLACK);
		psBtn.setBounds(305, 350, 200, 30);
		psBtn.addActionListener (new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<offBtnList.size(); i++){
					offBtnList.get(i).setSelected(true);
				}

				for (int i=0; i<room.getTelevisionList().size(); i++){
					room.getTelevisionList().get(i).setStatus(false);
				}

				for (int i=0; i<room.getRadioList().size(); i++){
					room.getRadioList().get(i).setStatus(false);
				}

				actionLabel.setText("Power Saver is activated ");
				
			}
		});
		panel.add(psBtn);
		
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
			JLabel imagetv = new JLabel(TV.getStatus() ? img_tvON : img_tvOFF);
			
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
	            		actionLabel.setText(TV.getName() + " is ON ");
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
	            		actionLabel.setText(TV.getName() + " is OFF ");
	            	}
	            }
	        });
			offBtnList.add(offButton);
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
		           actionLabel.setText(TV.getName() + " volume changed ");
				}
			});
			panel.add(volSlider);

			chnSlider.setSize(130, 23);
			chnSlider.setLocation(630, 57+30*k);
			chnSlider.addChangeListener(new ChangeListener(){
				public void stateChanged (ChangeEvent e){
		           TV.setChannel(chnSlider.getValue());
		           actionLabel.setText(TV.getName() + " channel changed ");
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
		for(int k=0; k<room.getRadioList().size(); k++){
			Radio Radio = room.getRadioList().get(k);
			JLabel radiolbl = new JLabel(room.getRadioList().get(k).getName());
			JRadioButton onButton = new JRadioButton("On");
			JRadioButton offButton = new JRadioButton("Off");
			ButtonGroup group = new ButtonGroup();
			JSlider volSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, Radio.getVolume());
			JSlider chnSlider = new JSlider(JSlider.HORIZONTAL, 0, 200, Radio.getChannel());
			JLabel chnLabel = new JLabel(""+chnSlider.getValue());
			JLabel imageRadio = new JLabel(Radio.getStatus() ? img_radioON : img_radioOFF);
			
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
	            		actionLabel.setText(Radio.getName() + " is ON ");
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
	            		actionLabel.setText(Radio.getName() + " is OFF ");
	            	}
	            }
	        });
			offBtnList.add(offButton);
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
		           actionLabel.setText(Radio.getName() + " volume changed ");
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
		           actionLabel.setText(Radio.getName() + " channel changed ");
				}
			});
			panel.add(chnSlider);			
		}
		
		actionLabel.setText("");
		return panel;
	}

    /**
     * Pop-up help.
     */
    private void help(){
		helpf.setTitle("HELP - Entertainmnet Control");
		helpf.setSize(640, 220);
		helpf.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("<Hello and welcome to your SmartHouse Entertainment Control Panel!>");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl1.setBounds(0,13,622,15);
		helpf.getContentPane().add(lbl1, BorderLayout.NORTH);
		
		JLabel lbl2 = new JLabel("You can change settings that include televisions, radios, and lock down mode.");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl2.setBounds(0, 41, 622, 15);
		helpf.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("[Television] You can turn on/off or change channel and volume of televisions.");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl3.setBounds(0, 90, 622, 15);
		helpf.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("[Radio] You can turn on/off or change channel and volume of radios.");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl4.setBounds(0, 110, 622, 15);
		helpf.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("[Power saver] Turn off every televsion and radio.");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl5.setBounds(0, 130, 622, 15);
		helpf.getContentPane().add(lbl5);
		
		helpf.setVisible(true);
    }
}