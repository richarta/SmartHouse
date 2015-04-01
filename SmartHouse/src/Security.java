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

/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:27 PM
 */
public class Security extends JFrame
{
	public void finalize() throws Throwable {	}
	
	private static JFrame frame = new JFrame("Security");


	//Temporary main for testing
	/*public static void main(String[] args) {
		new Security();

	}*/
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
		/**
		lock.addButtonListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){if e.getStateChange()==ItemEvent.SELECTED){}}};
		unlock.addButtonListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){if e.getStateChange()==ItemEvent.SELECTED){}}};
		close.addButtonListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){if e.getStateChange()==ItemEvent.SELECTED){}}};
		open.addButtonListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e){if e.getStateChange()==ItemEvent.SELECTED){}}};
			*/
		return item;
	}
}