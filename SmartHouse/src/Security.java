import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;




/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:27 PM
 */
public class Security extends JFrame {

	private boolean doors;
	private boolean lockdown;
	private boolean windows;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Security frame = new Security();
				frame.setVisible(true);
			}
		});
	}
	
	public Security(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Security Controls");

		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new BorderLayout());


		JPanel	panel1 = new JPanel();
		JPanel	panel2 = new JPanel();
		JPanel	panel3 = new JPanel();
		
		
		ArrayList<JPanel> panelList = new ArrayList<JPanel>();
		panelList.add(panel1);
		panelList.add(panel2);
		panelList.add(panel3);
		
		JTabbedPane tabPane = new JTabbedPane();
		
		int nFloor = 3;
		for (int i=0; i<nFloor; i++){
			tabPane.addTab( "Floor "+ (i+1), panelList.get(i));
			mainPanel.add(tabPane);}
	}

	public void floorPanel(JPanel panel)
	{
		
	}
	
	public void finalize() throws Throwable {	}
	//public Sec.Alert(){	}

	//public Sec.Control.Doors(){	}

	//public Sec.Control.Lockdown(){	}

	//public Sec.Control.Windows(){	}

	//public Sec.Menu.Button(){	}
}//end Security