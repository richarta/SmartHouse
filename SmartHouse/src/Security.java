/**
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * @author: Young J. Park, Andrew
 * Date: 17 April 2015
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
 
public class Security{
	
	// Initialize
	private House house;		
	private int nFloor;
    private int iFloorChoosed;
    private int iRoomChoosed;
    private JFrame SecFrm = new JFrame();
    private JFrame helpf = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel dirLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    private JButton helpbtn = new JButton("Help");
    private JButton armbtn = new JButton("Arm");
    private JButton disarmbtn = new JButton("Disarm");
    private JLabel actionLabel = new JLabel("");
    private boolean visibled = false;
    private int option;
    private Object[] options = {"Lock Down House", "Dismiss"};
    
    public Security() {	    	
    	
    	// Call House
    	User.openHouseStatus();
    	house = User.getHouse();
    	nFloor = house.getFloorList().size();
    	
    	// Initialize the frame
    	SecFrm.getContentPane().setLayout(null);
    	SecFrm.setResizable(false);
    	SecFrm.getContentPane().setLayout(null);
    	SecFrm.setResizable(false);
        
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
    	            		visibled = false;
    	            		
    	            		// Get floor and room index
	    	            	iFloorChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(0));
	    	            	iRoomChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(1));
	    	            	
	    	            	// Remove JPanel
	    	            	SecFrm.remove(panel);
	    	            	SecFrm.repaint();
	    	            	SecFrm.revalidate();
	    	            	
	    	            	// Show new JPanel
	    	            	panel = generateSecRoomPanel(iFloorChoosed,iRoomChoosed);
	    	            	panel.setBounds(0, 0, 800, 500);
	    	            	
	    	            	// Change the title to show room selected
	    	            	String s = house.getFloorList().get(iFloorChoosed).getName()+", " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName();
	    	            	SecFrm.setTitle("Security Controls - " + s);
	    	        		
	    	        		dirLabel.setVisible(false);
	    	        		
	    	            	SecFrm.getContentPane().add(panel);
	    	            	SecFrm.repaint();
	    	            	SecFrm.revalidate();
	    	            	visibled = true;
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
            	helpf.setVisible(false);
            	new SelectionMenu();
            }
        });
		SecFrm.getContentPane().add(menuBtn);
		
		// Main menu label
		dirLabel.setBounds(0, 100, 802, 40);
		dirLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
				help();
			}
		});
		SecFrm.add(helpbtn);		

		// arm button
		armbtn.setBounds(20, 440, 150, 23);
		armbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				house.setCombat(true);
				User.saveHouseStatus();
				actionLabel.setText("House is armed ");
			}
		});
		SecFrm.add(armbtn);

		// disarm button
		disarmbtn.setBounds(330, 440, 150, 23);
		disarmbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e4) {
				house.setCombat(false);
				actionLabel.setText("House is disarmed ");
				User.saveHouseStatus();
			}
		});
		SecFrm.add(disarmbtn);

        // Set Frame
        SecFrm.setTitle("Security Controls");
        SecFrm.setLocation(120, 120);
        SecFrm.setSize(820,530);
        SecFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SecFrm.setVisible(true);
        visibled = true;
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
		windowLabel.setBounds(27, 206, 90, 16);
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
					room.getWindowList().get(i).setLock(true);
				}

				for (int i=0; i<room.getDoorList().size(); i++){
					room.getDoorList().get(i).setLock(true);
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
			JRadioButton openButton = new JRadioButton("Open");
			JRadioButton closeButton = new JRadioButton("Close");
			ButtonGroup group2 = new ButtonGroup();
			ButtonGroup group = new ButtonGroup();
			JLabel imageDoor = new JLabel(door.getLock() ? img_doorLocked : img_doorUnlocked);
			
			doorlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(doorlbl);
			
			imageDoor.setBounds(27, 59+30*k, 15, 15);
			panel.add(imageDoor);
			
			
			unlockButton.setBounds(200, 55+30*k, 90, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		boolean first = true;
	            		if(house.getCombat() && visibled && first){
	            			option = JOptionPane.showOptionDialog(null, "Break in Alert", "Warning",
	            					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
	            					null, options, options[0]); 
	            			if (option == 0){
	            				first = false;
	            				
	            				// Lock all the doors and windows
	            				for (int i =0; i<house.getFloorList().size(); i++){
	            					for (int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
	            						for (int k1=0; k1<house.getFloorList().get(i).getRoomList().get(j).getDoorList().size(); k1++){
	            							house.getFloorList().get(i).getRoomList().get(j).getDoorList().get(k1).setLock(true);
	            							house.getFloorList().get(i).getRoomList().get(j).getDoorList().get(k1).setClosed(true);
	            						}
	            						for (int k2=0; k2<house.getFloorList().get(i).getRoomList().get(j).getWindowList().size(); k2++){
	            							house.getFloorList().get(i).getRoomList().get(j).getWindowList().get(k2).setLock(true);
	            							house.getFloorList().get(i).getRoomList().get(j).getWindowList().get(k2).setClosed(true);
	            						}
	            					}
	            				}
	            				
	            				for (int i=0; i<lockBtnList.size(); i++){
	                        		lockBtnList.get(i).setSelected(true);
	                        	}
	                        	
	                        	actionLabel.setText("Lock everything ");
	            			}
	            			else if (option == 1){
	            				actionLabel.setText("Warning was dismissed");
	            				imageDoor.setIcon(img_doorUnlocked);
		            			door.setLock(false);
		            			actionLabel.setText(door.getName() + " is unlocked ");
	            			}
	            		}
	            		
	            		else{
	            			imageDoor.setIcon(img_doorUnlocked);
	            			door.setLock(false);
	            			actionLabel.setText(door.getName() + " is unlocked ");
	            		}
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(300, 55+30*k, 90, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){ 	
	            		if(!door.getClosed()){
	            			unlockButton.setSelected(true);
	            		}
	            		else{
	            			imageDoor.setIcon(img_doorLocked);
	            			door.setLock(true);
	            			actionLabel.setText(door.getName() + " is locked ");
	            		}
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			openButton.setBounds(400,55+30*k,90,25);
			openButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		if(door.getLock()){
	            			closeButton.setSelected(true);
	            		}
	            		else{
	            			door.setClosed(false);
	            			actionLabel.setText(door.getName() + " is open ");
	            		}
	            	}
	            }
	        });
			panel.add(openButton);
			
			closeButton.setBounds(500,55+30*k,90,25);
			closeButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		door.setClosed(true);
	            		actionLabel.setText(door.getName() + " is closed ");
	            	}
	            }
	        });
			lockBtnList.add(closeButton);
			panel.add(closeButton);
			
			if (door.getClosed())
				closeButton.setSelected(true);
			else
				openButton.setSelected(true);
			
			group2.add(closeButton);
			group2.add(openButton);
			
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
			JRadioButton openButton = new JRadioButton("Open");
			JRadioButton closeButton = new JRadioButton("Close");
			ButtonGroup group2 = new ButtonGroup();
			ButtonGroup group = new ButtonGroup();
			JLabel imageWindow = new JLabel(window.getLock() ? img_windowLocked : img_windowUnlocked);
			
			windowlbl.setBounds(47, 235+30*k, 150, 16);		
			panel.add(windowlbl);
			
			imageWindow.setBounds(27, 235+30*k, 15, 15);
			panel.add(imageWindow);
			
			unlockButton.setBounds(200, 231+30*k, 90, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		boolean first = true;
	            		if(house.getCombat() && visibled && first){
		            		
	            			option = JOptionPane.showOptionDialog(null, "Break in Alert", "Warning",
	            					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
	            					null, options, options[0]); 
	            			if (option == 0){
	            				first = false;
	            				
	            				// Lock all the doors and windows
	            				for (int i =0; i<house.getFloorList().size(); i++){
	            					for (int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
	            						for (int k1=0; k1<house.getFloorList().get(i).getRoomList().get(j).getDoorList().size(); k1++){
	            							house.getFloorList().get(i).getRoomList().get(j).getDoorList().get(k1).setLock(true);
	            							house.getFloorList().get(i).getRoomList().get(j).getDoorList().get(k1).setClosed(true);
	            						}
	            						for (int k2=0; k2<house.getFloorList().get(i).getRoomList().get(j).getWindowList().size(); k2++){
	            							house.getFloorList().get(i).getRoomList().get(j).getWindowList().get(k2).setLock(true);
	            							house.getFloorList().get(i).getRoomList().get(j).getWindowList().get(k2).setClosed(true);
	            						}
	            					}
	            				}
	            				
	            				for (int i=0; i<lockBtnList.size(); i++){
	                        		lockBtnList.get(i).setSelected(true);
	                        	}
	                        	
	                        	actionLabel.setText("Lock everything ");
	            			}
	            			else if (option == 1){
	            				actionLabel.setText("Warning was dismissed");
	            				window.setLock(false);
	    	            		imageWindow.setIcon(img_windowUnlocked);
	    	            		actionLabel.setText(window.getName() + " is unlocked ");
	            			}
	            		}
	            		
	            		else{
	            			window.setLock(false);
		            		imageWindow.setIcon(img_windowUnlocked);
		            		actionLabel.setText(window.getName() + " is unlocked ");
	            		}
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(300, 231+30*k, 90, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		if(!window.getClosed()){
	            			unlockButton.setSelected(true);
	            		}
	            		else{
	            			window.setLock(true);
	            			imageWindow.setIcon(img_windowLocked);
	            			actionLabel.setText(window.getName() + " is locked ");
	            		}
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			openButton.setBounds(400,231+30*k,90,25);
			openButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		if(window.getLock()){
	            			closeButton.setSelected(true);
	            		}
	            		else{
	            			window.setClosed(false);
	            			actionLabel.setText(window.getName() + " is open ");
	            		}
	            	}
	            }
	        });
			panel.add(openButton);
			
			closeButton.setBounds(500,231+30*k,90,25);
			closeButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		window.setClosed(true);
	            		actionLabel.setText(window.getName() + " is closed ");
	            	}
	            }
	        });
			lockBtnList.add(closeButton);
			panel.add(closeButton);
			
			if (window.getClosed())
				closeButton.setSelected(true);
			else
				openButton.setSelected(true);
			
			group2.add(closeButton);
			group2.add(openButton);
			
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
    
    /**
     * Pop-up help.
     */
    private void help(){
		helpf.setTitle("HELP - Security Control");
		helpf.setSize(640, 220);
		helpf.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("<Hello and welcome to your SmartHouse Security Control Panel!>");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl1.setBounds(0,13,622,15);
		helpf.getContentPane().add(lbl1, BorderLayout.NORTH);
		
		JLabel lbl2 = new JLabel("You can change settings that include doors, windows, and lock down mode.");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl2.setBounds(0, 41, 622, 15);
		helpf.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("[Doors] You can lock/unlock of doors.");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl3.setBounds(0, 90, 622, 15);
		helpf.getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("[Windows] You can lock/unlock of windows.");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl4.setBounds(0, 110, 622, 15);
		helpf.getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("[Lock down] Lock every door and window.");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lbl5.setBounds(0, 130, 622, 15);
		helpf.getContentPane().add(lbl5);
		
		helpf.setVisible(true);
    }
}