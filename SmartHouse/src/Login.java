import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class Login extends JFrame 
{

	public Login(){
	JFrame frame = new JFrame();
	frame.setSize(500, 297);
		
	SpringLayout sl_mainPanel = new SpringLayout();
	JPanel mainPanel = new JPanel(sl_mainPanel);


	JButton loginB = new JButton("Login");
	JLabel userPass = new JLabel("Password");
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, userPass, -101, SpringLayout.SOUTH, mainPanel);
	JButton register = new JButton("Register");
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, register, -89, SpringLayout.SOUTH, mainPanel);
	JTextField userField = new JTextField(20);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, loginB, -125, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.WEST, loginB, 0, SpringLayout.WEST, userField);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, loginB, -28, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, register, 0, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, userPass, 0, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.EAST, register, 0, SpringLayout.EAST, userField);
	sl_mainPanel.putConstraint(SpringLayout.EAST, userPass, 0, SpringLayout.EAST, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, userField, 132, SpringLayout.NORTH, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, userField, -101, SpringLayout.SOUTH, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.EAST, userField, -136, SpringLayout.EAST, mainPanel);

	JPasswordField passField = new JPasswordField(20);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, passField, -64, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.WEST, passField, 0, SpringLayout.WEST, userField);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, passField, -3, SpringLayout.NORTH, userField);
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
	sl_mainPanel.putConstraint(SpringLayout.NORTH, lblUsername, 5, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblUsername, -17, SpringLayout.NORTH, userPass);
	sl_mainPanel.putConstraint(SpringLayout.EAST, lblUsername, 0, SpringLayout.EAST, userField);
	lblUsername.setBounds(101, 137, 61, 14);
	mainPanel.add(lblUsername);
	
	frame.getContentPane().add(mainPanel);
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
