/*
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Young J. Park
 * Date: 1 April 2015
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
	private House house = new House();
	//private House house = User.getHouse();
		
	private int nFloor = 2;
	// private int nFloor = house.getFloorList().size();
	
    private int iFloorChoosed;
    private int iRoomChoosed;
    private JFrame SecFrm = new JFrame();
    private JMenuBar menuBar = new JMenuBar();
    private ButtonGroup grop = new ButtonGroup();
    private ArrayList<JMenu> menus = new ArrayList<JMenu>();
    private JPanel panel = new JPanel();
    private JPanel [][] roomPanels = new JPanel[nFloor][10];
    private JButton menuBtn = new JButton("Return to Menu");
    private JLabel roomLabel = new JLabel("Select the Room from Menu");
    private final JPanel panel_2 = new JPanel();
    JButton helpbtn = new JButton("Help");
    
    public Security() {	    	
    	// Sample House
    	house.addFloor("Floor1");
    	house.addFloor("Floor2");
    	house.getFloorList().get(0).addRoom("dining");
    	house.getFloorList().get(0).addRoom("Living");
    	house.getFloorList().get(1).addRoom("bed");
    	house.getFloorList().get(0).getRoomList().get(0).addDoor("Dor");
    	house.getFloorList().get(0).getRoomList().get(0).addDoor("Dor2");
    	house.getFloorList().get(0).getRoomList().get(1).addDoor("Door");
    	house.getFloorList().get(0).getRoomList().get(1).addDoor("Door2");
    	house.getFloorList().get(1).getRoomList().get(0).addDoor("Dooor");
    	house.getFloorList().get(1).getRoomList().get(0).addDoor("Dooor2");
    	house.getFloorList().get(0).getRoomList().get(0).addWindow("Window1");
    	house.getFloorList().get(0).getRoomList().get(0).addWindow("Window2");
    	house.getFloorList().get(0).getRoomList().get(1).addWindow("Window3");
    	house.getFloorList().get(1).getRoomList().get(0).addWindow("Window4");
    	house.getFloorList().get(1).getRoomList().get(0).addWindow("Window5");
    	house.getFloorList().get(1).getRoomList().get(0).addWindow("Window6");
    	
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
	    	            	
	    	            	roomLabel.setText("["+house.getFloorList().get(0).getName()+"] " + house.getFloorList().get(iFloorChoosed).getRoomList().get(iRoomChoosed).getName() + " is selected]");
	    	            	roomLabel.setBounds(610, 410, 200, 23);
	    	        		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
	    	        		SecFrm.getContentPane().add(roomLabel);
	    	        		
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
		
		// room label
		roomLabel.setBounds(180, 100, 500, 40);
		roomLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		SecFrm.getContentPane().add(roomLabel);
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
    	JButton lockBtn = new JButton("Lock Down");
    	ArrayList <JRadioButton> lockBtnList = new ArrayList<JRadioButton>();
    	ImageIcon img_doorON = new ImageIcon("door_on.png");
    	ImageIcon img_doorOFF = new ImageIcon("door_off.png");
    	ImageIcon img_windowON = new ImageIcon("window_on.png");
    	ImageIcon img_windowOFF = new ImageIcon("window_off.png");
    	
		panel.setLayout(null);
		
		// Set labels;
		doorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		doorLabel.setBounds(27, 30, 90, 16);
		panel.add(doorLabel);
		
		windowLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		windowLabel.setBounds(305, 30, 90, 16);
		panel.add(windowLabel);
		
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
            }
        });
		panel.add(lockBtn);
		
		// Doors
		for(int k=0; k<room.getDoorList().size(); k++){
			Door door = room.getDoorList().get(k);
			JLabel doorlbl = new JLabel(room.getDoorList().get(k).getName());
			JRadioButton unlockButton = new JRadioButton("Unlock");
			JRadioButton lockButton = new JRadioButton("Lock");
			ButtonGroup group = new ButtonGroup();
			JLabel imageDoor = new JLabel(img_doorOFF);
			
			doorlbl.setBounds(47, 59+30*k, 150, 16);		
			panel.add(doorlbl);
			
			imageDoor.setBounds(27, 59+30*k, 15, 15);
			panel.add(imageDoor);
			
			unlockButton.setBounds(115, 55+30*k, 70, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageDoor.setIcon(img_doorON);
	            		door.setLock(true);
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(190, 55+30*k, 63, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		imageDoor.setIcon(img_doorOFF);
	            		door.setLock(false);
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			if (door.getLock())
				unlockButton.setSelected(true);
			else
				lockButton.setSelected(true);
			
			group.add(unlockButton);
			group.add(lockButton);
		}
		
		// Windows
		for(int k=0; k<room.getWindowList().size(); k++){
			Window window = room.getWindowList().get(k);
			JLabel windowlbl = new JLabel(room.getWindowList().get(k).getName());
			JRadioButton unlockButton = new JRadioButton("Unlock");
			JRadioButton lockButton = new JRadioButton("Lock");
			ButtonGroup group = new ButtonGroup();
			JLabel imageWindow = new JLabel(img_windowOFF);
			
			windowlbl.setBounds(305, 59+30*k, 150, 16);		
			panel.add(windowlbl);
			
			imageWindow.setBounds(365, 59+30*k, 15, 15);
			panel.add(imageWindow);
			
			unlockButton.setBounds(393, 55+30*k, 70, 25);
			unlockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		window.setLock(true);
	            		imageWindow.setIcon(img_windowON);
	            	}
	            }
	        });
			panel.add(unlockButton);

			lockButton.setBounds(460, 55+30*k, 63, 25);
			lockButton.addItemListener(new ItemListener() {
	            public void itemStateChanged(ItemEvent e) {
	            	if(e.getStateChange() == ItemEvent.SELECTED){
	            		window.setLock(false);
	            		imageWindow.setIcon(img_windowOFF);
	            	}
	            }
	        });
			lockBtnList.add(lockButton);
			panel.add(lockButton);
			
			if (window.getLock())
				unlockButton.setSelected(true);
			else
				lockButton.setSelected(true);
			
			group.add(unlockButton);
			group.add(lockButton);
		}
		
		return panel;
	}
}

// Andrew's Code
/**
import java.awt.BorderLayout; 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Color;
import java.awt.SystemColor;

public class Security extends JFrame
{
	public void finalize() throws Throwable {	}
	
	private static JFrame frame = new JFrame("Security");


	//Temporary main for testing
	/*public static void main(String[] args) {
		new Security();

	}
	private ArrayList<JMenu> menus = new ArrayList<JMenu>();
	private ArrayList<JPanel> floorPanel = new ArrayList<JPanel>();
	private int iFloorChoosed;
	private int nFloor=3;//House.getfloorlist.size();
	private String name1= "door ";
	private String name2= "window ";

	JButton menubtn;
	JButton lockdown;
	JPanel center;
	JPanel east;
	JPanel south;

	public Security()
	{
		JFrame frame;
		frame.getContentPane().setLayout(new BorderLayout());

		for(int i=0;i<nFloor;i++)
		{
			//create tab for floor
			JMenu fileMenu = new JMenu("Floor"+(i+1));
			menus.add(fileMenu);
			//create panel for this tab
			JPanel panel = new JPanel();
			floorPanel.add(panel); 
			//add doors to panel

			for(int k=0;k<User.getHouse().getFloorList().get(i).getRoomList().get(j).getDoorList().size();k++)
			{
				String name=User.getHouse().getFloorList().get(i).getRoomList().get(j).getDoorList().get(k).getName()
						panel.add(addItem(name1+k));
			}
			//add windows to panel
			for(int k=0;k<User.getHouse().getFloorList().get(i).getRoomList().get(j).getWindowList().size();k++)
			{
				String name=User.getHouse().getFloorList().get(i).getRoomList().get(j).getDoorList().get(k).getName()
						panel.add(addItem(name2+k));
			}




			// Generate menu-item for each Floor
			JRadioButtonMenuItem radioBtnMenu = new JRadioButtonMenuItem();
			radioBtnMenu.setName("Floor "+i); // give a name to room. e.g. Second room on first floor is "12". Third room of second floor is "23"

			// If you click each room, JFrame shows a panel for the selected room
			radioBtnMenu.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED){

						// Get floor and room index
						iFloorChoosed = Character.getNumericValue(radioBtnMenu.getName().charAt(0));


						// Remove JPanel
						frame.remove(panel);
						frame.repaint();
						frame.revalidate();

						// Show new JPanel

						panel.setBounds(0, 0, 800, 500);


						frame.getContentPane().add(panel);
						frame.repaint();
						frame.revalidate();
					}
				}
			});

			// Group buttons and add into menu

			fileMenu.add(radioBtnMenu);
		}

		// Add menu into menu bar
		//	menus.add(fileMenu);




		//Create and set up the window.

		center = floorPanel.get(1);
		center.setVisible(true);
		east = new JPanel();
		east.setVisible(true);
		south = new JPanel();
		south.setVisible(true);

		frame = new JFrame("Security");





		frame.getContentPane().add(south, BorderLayout.SOUTH);
		frame.getContentPane().add(east, BorderLayout.EAST);
		frame.getContentPane().add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(0,1));
		menubtn=new JButton("Menu");
		lockdown=new JButton("Lockdown");
		lockdown.setPreferredSize(new Dimension(100,75));
		menubtn.setPreferredSize(new Dimension(100,75));
		east.add(lockdown);east.add(menubtn);
		south.add(new JTextField(40));

		frame.setSize(new Dimension(636, 345));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		//Display the window
		frame.pack();
		frame.setVisible(true);
	}


	//public Sec.Alert(){	}

	//public Sec.Control.Doors(){	}

	//public Sec.Control.Lockdown(){	}

	//public Sec.Control.Windows(){	}

	//public Sec.Menu.Button(){	}

	private static JPanel addItem(String d)
	{
		//Create items
		JPanel item = new JPanel(new FlowLayout());
		item.setPreferredSize(new Dimension(400, 50));
		item.add(new JLabel(d+"  "));
		JRadioButton lock = new JRadioButton("Lock");
		JRadioButton unlock = new JRadioButton("Unlock");
		JRadioButton open = new JRadioButton("open");
		JRadioButton close = new JRadioButton("Close");
		ButtonGroup group = new ButtonGroup();
		group.add(lock);
		group.add(unlock);
		ButtonGroup group2 = new ButtonGroup();
		group2.add(open);
		group2.add(close);
		item.add(lock);
		item.add(unlock);
		item.add(close);
		item.add(open);
		item.setVisible(true);
		return item;
	}
}
*/