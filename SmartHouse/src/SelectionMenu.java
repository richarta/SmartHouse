import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

	public class SelectionMenu extends JPanel{
		
		public SelectionMenu() {
			

			JFrame frame;
			JButton envrbtn,secbtn,entbtn;
			JPanel panel;
			
			panel = new JPanel();
			panel.setVisible(true);
			
			frame = new JFrame("Main Menu");
			frame.setSize(800, 600);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			

			entbtn = new JButton("Entertainment");
			entbtn.setBounds(475, 211, 125, 50);
			panel.add(entbtn);
			
			JButton helpbtn = new JButton("Help");
			helpbtn.setBounds(337, 485, 100, 50);
			panel.add(helpbtn);
			envrbtn = new JButton("Environmental");
			envrbtn.setBounds(175, 211, 125, 50);
			panel.add(envrbtn);
			
			JButton logout = new JButton("LogOut");
			logout.setBounds(337, 424, 100, 50);
			panel.add(logout);

			secbtn = new JButton("Security");
			secbtn.setBounds(325, 211, 125, 50);
			panel.add(secbtn);

			frame.setVisible(true);
			
		}
		
	//	public void finalize() throws Throwable {

	//	}
	//	public Sel.Ent.Button(){

		//}

		//public Sel.env.Button(){

		//}

		//public Sel.Sec.Button(){
			
		//}
		public static void main(String[] args){

			new SelectionMenu();

		}


	}

