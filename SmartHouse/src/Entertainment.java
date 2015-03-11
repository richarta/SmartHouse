import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;




/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:08 PM
 */
public class Entertainment extends JFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Environmental frame = new Environmental();
				frame.setVisible(true);
			}
		});
	}
	
	private boolean mood;
	private boolean stereo;
	private String tele;

	public Entertainment(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Entertainment Controls");

		JPanel mainPanel = new JPanel();
		getContentPane().add(mainPanel);
		mainPanel.setLayout(new GridLayout(3,2));


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
			mainPanel.add(tabPane);
		}
	}

	public void finalize() throws Throwable {	}
	//public Ent.Control.Mood(){	}

	//public Ent.Control.Stereo(){	}

	//public Ent.Control.Tele(){	}

	//public Ent.Menu.Button(){	}
}//end Entertainment