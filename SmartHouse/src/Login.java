/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Timothy Bernier
 * Date: 09 March 2015
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class Login extends JFrame 
{

	private String user;
	private String pass;
	
	public Login(){
	JFrame frame = new JFrame();
	frame.setSize(500, 297);
		
	SpringLayout sl_mainPanel = new SpringLayout();
	JPanel mainPanel = new JPanel(sl_mainPanel);


	JButton loginB = new JButton("Login");
	JLabel userPass = new JLabel("Password");
	sl_mainPanel.putConstraint(SpringLayout.WEST, userPass, 77, SpringLayout.WEST, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, userPass, -173, SpringLayout.SOUTH, mainPanel);
	JButton register = new JButton("Register");
	register.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		}
	});
	sl_mainPanel.putConstraint(SpringLayout.WEST, register, 244, SpringLayout.WEST, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, register, -161, SpringLayout.SOUTH, mainPanel);
	JTextField userField = new JTextField(20);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, loginB, -100, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, userField, 60, SpringLayout.NORTH, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.WEST, userField, 164, SpringLayout.WEST, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, userField, -173, SpringLayout.SOUTH, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, loginB, -125, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.WEST, loginB, 0, SpringLayout.WEST, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, register, 0, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, userPass, 0, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.EAST, register, 0, SpringLayout.EAST, userField);
	sl_mainPanel.putConstraint(SpringLayout.EAST, userPass, 0, SpringLayout.EAST, userField);

	JPasswordField passField = new JPasswordField(20);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, passField, -64, SpringLayout.NORTH, userField);
	sl_mainPanel.putConstraint(SpringLayout.WEST, passField, 0, SpringLayout.WEST, userField);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, passField, -75, SpringLayout.NORTH, userField);
	mainPanel.setLayout(null);
	mainPanel.setVisible(true);
	
	userField.setBounds(188, 82, 160, 25);
	mainPanel.add(userField);
	

	userPass.setBounds(101, 118, 80, 25);
	mainPanel.add(userPass);

	
	passField.setBounds(188, 118, 160, 25);
	mainPanel.add(passField);

	loginB.setBounds(188, 154, 80, 25);
	mainPanel.add(loginB);
	
	loginB.addMouseListener(new MouseAdapter(){
		public void mouseClicked(MouseEvent e){
			
			//Check username/pass
			user = userField.getText();
			pass = passField.getText();
						
			try {
				if(loginCheck(user, pass))
				{
					frame.setVisible(false);
					//open main menu
					SelectionMenu menu = new SelectionMenu();
					User.openHouseStatus(user);
				}
				else{
					JOptionPane.showMessageDialog(null, "You have entered an invalid username or password.", "alert", JOptionPane.ERROR_MESSAGE);				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}); 
	
	register.setBounds(268, 154, 80, 25);
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
	sl_mainPanel.putConstraint(SpringLayout.WEST, lblUsername, 77, SpringLayout.WEST, mainPanel);
	sl_mainPanel.putConstraint(SpringLayout.SOUTH, lblUsername, -89, SpringLayout.NORTH, userPass);
	sl_mainPanel.putConstraint(SpringLayout.EAST, lblUsername, 0, SpringLayout.EAST, userField);
	lblUsername.setBounds(101, 87, 61, 14);
	mainPanel.add(lblUsername);
	
	frame.getContentPane().add(mainPanel);
	frame.setVisible(true);
	}

	public boolean loginCheck(String u, String p) throws IOException{
		 if(User.checkLogin(u, p))
		 {
			 return true;
		 }
		 else 
			 return false;

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
