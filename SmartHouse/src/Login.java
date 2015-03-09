import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Login extends JFrame 
{

	public Login(){
	JFrame frame = new JFrame();
	frame.setSize(800, 600);
		
	SpringLayout sl_mainPanel = new SpringLayout();
	JPanel mainPanel = new JPanel(sl_mainPanel);


	JButton loginB = new JButton("Login");
	JLabel userPass = new JLabel("Password");
	JButton register = new JButton("Register");
	JTextField userField = new JTextField(20);

	JPasswordField passField = new JPasswordField(20);
	mainPanel.setLayout(null);
	mainPanel.setVisible(true);
	
	userField.setBounds(188, 132, 160, 25);
	mainPanel.add(userField);
	

	userPass.setBounds(101, 168, 80, 25);
	mainPanel.add(userPass);

	
	passField.setBounds(188, 168, 160, 25);
	mainPanel.add(passField);

	loginB.setBounds(188, 204, 80, 25);
	mainPanel.add(loginB);
	
	loginB.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
			//Check username and pass
			
			//if correct hide login
			frame.setVisible(false);
			//open main menu
			SelectionMenu menu = new SelectionMenu();
			
		}
	}); 
	
	register.setBounds(268, 204, 80, 25);
	mainPanel.add(register);
	register.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
			//hide login
			frame.setVisible(false);
			
			//create setup menu
			Personalize setup = new Personalize();
		}
	}); 
	
	JLabel lblUsername = new JLabel("Username");
	lblUsername.setBounds(101, 137, 61, 14);
	mainPanel.add(lblUsername);
	
	frame.add(mainPanel);
	frame.setVisible(true);
	}

	public void finalize() throws Throwable {

	}
	public void logincheck(){

	}

	public void loginfail(){

	}

	public void loginsucceed(){

	}

	public void personalizeHousefile(){

	}

	public void selectionPage(){

	}

	


}//end Login
