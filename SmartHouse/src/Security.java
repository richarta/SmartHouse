import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;




/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:27 PM
 */
public class Security extends JFrame {

	private static JFrame frame = new JFrame("Security");

	public static void main(String[] args) {
		new Security();
	}

	public Security(){JFrame frame;
	JButton lockdown;
	JPanel center;
	JPanel east;
	JPanel south;
	//Create and set up the window.

	center = new JPanel();
	center.setVisible(true);
	east = new JPanel();
	east.setVisible(true);
	south = new JPanel();
	south.setVisible(true);

	frame = new JFrame("Security");

	frame.setSize(new Dimension(800, 600));
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	frame.getContentPane().setLayout(new BorderLayout());


	frame.getContentPane().add(south, BorderLayout.SOUTH);
	frame.getContentPane().add(east, BorderLayout.EAST);
	frame.getContentPane().add(center, BorderLayout.CENTER);
	center.setLayout(new GridLayout(0,1));
	center.add(new JLabel("Doors"),BorderLayout.CENTER);
	center.add(addItem("door1"),BorderLayout.CENTER);
	center.add(addItem("door2"),BorderLayout.CENTER);
	center.add(addItem("door3"),BorderLayout.CENTER);
	center.add(new JLabel("Window"),BorderLayout.CENTER);
	center.add(addItem("Window1"),BorderLayout.CENTER);
	center.add(addItem("Window2"),BorderLayout.CENTER);
	lockdown=new JButton("Lockdown");
	lockdown.setPreferredSize(new Dimension(100,175));
	east.add(lockdown);
	south.add(new JTextField(40));

	//Display the window
	frame.pack();
	frame.setVisible(true);
	}
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

	public void finalize() throws Throwable {	}
	//public Sec.Alert(){	}

	//public Sec.Control.Doors(){	}

	//public Sec.Control.Lockdown(){	}

	//public Sec.Control.Windows(){	}

	//public Sec.Menu.Button(){	}
}//end Security