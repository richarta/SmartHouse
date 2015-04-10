/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park, Andrew
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
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;
 

public class Security{
	
	// Test Launching GUI
	/**
	public static void main(String[] args) {
       new Security();
    } //*/
	
	// Initialize
	private House house;		
	private int nFloor;
    private int iFloorChoosed;
    private int iRoomChoosed;
    private JFrame SecFrm = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels;
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel dirLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    JButton helpbtn = new JButton("Help");
    
    public Security() {	    	
    	// Call House
    	house = User.getHouse();
    	nFloor = house.getFloorList().size();
    	roomPanels = new JPanel[nFloor][10];
    	
    	//
    	SecFrm.getContentPane().setLayout(null);
    	SecFrm.setResizable(false);
    	SecFrm.getContentPane().setLayout(null);
    	SecFrm.setResizable(false);
       
        // Generate a panel for each room
        for (int i=0; i<nFloor; i++){
        	for(int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
        	roomPanels[i][j] = generateSecRoomPanel(i,j);
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
	    	            	SecFrm.remove(panel);
	    	            	SecFrm.repaint();
	    	            	SecFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = roomPanels[iFloorChoosed][iRoomChoosed];
	    	            	panel.setBounds(0, 0, 800, 500);
	    	            	
	    	            	// Change the title to show room selected
	    	            	String s = house.getFloorList().get(iFloorChoosed).getName()+", " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName();
	    	            	SecFrm.setTitle("Environmental Controls - " + s);
	    	        		
	    	        		dirLabel.setVisible(false);
	    	        		
	    	            	SecFrm.getContentPane().add(panel);
	    	            	SecFrm.repaint();
	    	            	SecFrm.revalidate();
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
        SecFrm.setJMenuBar(menuBar);
        SecFrm.getContentPane().add(panel);
		menuBtn.setBackground(SystemColor.info);
		menuBtn.setForeground(Color.BLACK);
        
        // 'return to menu' button
		menuBtn.setBounds(20, 410, 150, 23);
		menuBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	SecFrm.setVisible(false);
            	new SelectionMenu();
            }
        });
		SecFrm.getContentPane().add(menuBtn);
		
		// Main menu label
		dirLabel.setBounds(180, 100, 500, 40);
		dirLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		SecFrm.getContentPane().add(dirLabel);
		
		// Border
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.GRAY, null));
		panel_2.setBounds(12, 391, 778, 2);
		SecFrm.getContentPane().add(panel_2);
		
		// help button
		helpbtn.setBounds(330, 410, 150, 23);
		helpbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				SelectionMenu.help();
			}
		});
		SecFrm.add(helpbtn);
		
        // Set Frame
        SecFrm.setTitle("Security Controls");
        SecFrm.setLocation(120, 120);
        SecFrm.setSize(820,530);
        SecFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SecFrm.setVisible(true);
    }
    

    /**
     * @param iFloor index of Floor
     * @param iRoom index of room
     * @return JPanel of Security control of the i-th room on i-th floor
     */
    public JPanel generateSecRoomPanel(int iFloor, int iRoom){
    	Room room = house.getFloorList().get(iFloor).getRoomList().get(iRoom);
    	JPanel panel = new JPanel();
    	JLabel doorLabel = new JLabel("Doors");
    	JLabel windowLabel = new JLabel("Windows");
    	JLabel actionLabel = new JLabel("");
    	JButton lockBtn = new JButton("Lock Down");
    	ArrayList <JRadioButton> lockBtnList = new ArrayList<JRadioButton>();
    	ImageIcon img_doorUnlocked = new ImageIcon("icon/door_unlocked.png");
    	ImageIcon img_doorLocked = new ImageIcon("icon/door_locked.png");
    	ImageIcon img_windowUnlocked = new ImageIcon("icon/window_unlocked.png");
    	ImageIcon img_windowLocked = new ImageIcon("icon/window_locked.png");
    	
		panel.setLayout(null);
		
		// Set labels;
		doorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		doorLabel.setBounds(27, 30, 90, 16);
		panel.add(doorLabel);
		
		windowLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		windowLabel.setBounds(405, 30, 90, 16);
		panel.add(windowLabel);
		
		actionLabel.setFont(new Font("Tahoma", Font.ITALIC, 13));
		actionLabel.setBounds(580, 410, 200, 23);
		actionLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		panel.add(actionLabel);
		
		// Lockdown
		lockBtn.setBackground(new Color(60, 179, 113));
		lockBtn.setForeground(Color.BLACK);
		lockBtn.setBounds(305, 350, 200, 30);
		lockBtn.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	for (int i=0; i<lockBtnList.size(); i++){
            		lockBtnList.get(i).setSelected(true);
            	}
            		
            	for (int i=0; i<room.getWindowList().size(); i++){
            		room.getWindowList().get(i).setLock(false);
            	}
            		
            	for (int i=0; i<room.getDoorList().size(); i++){
            		room.getDoorList().get(i).setLock(false);
            	}
            	
            	actionLabel.setText("Lockdown is activated ");
            }
        });
		panel.add(lockBtn);
		
		// Doors
		for(int k=0; k<room.getDoorList().size(); k++){
			Door door = room.getDoorList().get(k);
			JLabel doorlbl = new JLabel(room.getDoorList().get(k).getName());
			JRadioButton unlockButton = new JRadioButton("Unlocked");
			JRadioButton lockButton = new JRadioButton("Locked");
			ButtonGroup group = new ButtonGroup();
			JLabel imageDoor = new JLabel(door.getLock() ? img_doorLocked : img_doorUnlocked);
			
			doorlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(doorlbl);
			
			imageDoor.setBounds(27, 59+30*k, 15, 15);
			panel.add(imageDoor);
			
			unlockButton.setBounds(115, 55+30*k, 85, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageDoor.setIcon(img_doorUnlocked);
	            		door.setLock(false);
	            		actionLabel.setText(door.getName() + " is unlocked ");
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(200, 55+30*k, 85, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageDoor.setIcon(img_doorLocked);
	            		door.setLock(true);
	            		actionLabel.setText(door.getName() + " is locked ");
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			if (door.getLock())
				lockButton.setSelected(true);
			else
				unlockButton.setSelected(true);
			
			group.add(unlockButton);
			group.add(lockButton);
		}
		
		// Windows
		for(int k=0; k<room.getWindowList().size(); k++){
			Window window = room.getWindowList().get(k);
			JLabel windowlbl = new JLabel(room.getWindowList().get(k).getName());
			JRadioButton unlockButton = new JRadioButton("Unlocked");
			JRadioButton lockButton = new JRadioButton("Locked");
			ButtonGroup group = new ButtonGroup();
			JLabel imageWindow = new JLabel(window.getLock() ? img_windowLocked : img_windowUnlocked);
			
			windowlbl.setBounds(425, 59+30*k, 150, 16);		
			panel.add(windowlbl);
			
			imageWindow.setBounds(405, 59+30*k, 15, 15);
			panel.add(imageWindow);
			
			unlockButton.setBounds(495, 55+30*k, 85, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		window.setLock(false);
	            		imageWindow.setIcon(img_windowUnlocked);
	            		actionLabel.setText(window.getName() + " is unlocked ");
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(580, 55+30*k, 85, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		window.setLock(true);
	            		imageWindow.setIcon(img_windowLocked);
	            		actionLabel.setText(window.getName() + " is locked ");
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			if (window.getLock())
				lockButton.setSelected(true);
			else
				unlockButton.setSelected(true);
			
			group.add(unlockButton);
			group.add(lockButton);
		}
		
		actionLabel.setText("");
		return panel;
	}
}