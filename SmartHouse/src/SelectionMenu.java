import javax.swing.*;
import java.awt.BorderLayout;

	public class SelectionMenu{
		
		public SelectionMenu() {
			
			JFrame frame;
			JButton envrbtn,secbtn,entbtn;
			JPanel panel;
			
			panel = new JPanel();
			
			envrbtn = new JButton("Environmental");
			envrbtn.setBounds(50,50,100,50);
			secbtn = new JButton("Security");
			secbtn.setBounds(200,200,200,200);
			entbtn = new JButton("Entertainment");
			entbtn.setBounds(300,300,300,300);
			
			panel.add(envrbtn);
			panel.add(secbtn);
			panel.add(entbtn);
			panel.setVisible(true);
			
			frame = new JFrame("Main Menu");
			frame.setSize(800, 600);
			
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

