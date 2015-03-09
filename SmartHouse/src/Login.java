import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Login extends JPanel implements ActionListener {

	public Login(){

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
	loginB.addActionListener(this); 
	
	register.setBounds(268, 204, 80, 25);
	mainPanel.add(register);
	register.addActionListener(this); 
	
	JLabel lblUsername = new JLabel("Username");
	lblUsername.setBounds(101, 137, 61, 14);
	mainPanel.add(lblUsername);
	
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginB)
		{
			this.setVisible(false);
			SelectionMenu menu = new SelectionMenu();
			menu.setVisible(true);
		}
		if(e.getSource() == register)
		{
			this.setVisible(false);
			Personalize setup = new Personalize();
			setup.setVisible(true);
		}
	}
	


}//end Login
