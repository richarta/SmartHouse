
import javax.swing.*;


public class Login extends JPanel {

	public Login(){
	SpringLayout sl_mainPanel = new SpringLayout();
	JPanel mainPanel = new JPanel(sl_mainPanel);
	JButton loginB = new JButton("Login");
	JLabel userName = new JLabel("Username");
	JLabel userPass = new JLabel("Password");
	JButton register = new JButton("Register");
	JTextField userField = new JTextField(20);
	sl_mainPanel.putConstraint(SpringLayout.NORTH, userField, 42, SpringLayout.SOUTH, register);
	sl_mainPanel.putConstraint(SpringLayout.WEST, userField, 67, SpringLayout.WEST, mainPanel);
	JPasswordField passField = new JPasswordField(20);
	

	
	userName.setBounds(10, 10, 80, 25);
	mainPanel.add(userField);
	
	userField.setBounds(100, 10, 160, 25);
	mainPanel.add(userField);
	

	userPass.setBounds(10, 40, 80, 25);
	mainPanel.add(userPass);

	
	passField.setBounds(100, 40, 160, 25);
	mainPanel.add(passField);


	loginB.setBounds(10, 80, 80, 25);
	mainPanel.add(loginB);
	
	register.setBounds(180, 80, 80, 25);
	mainPanel.add(register);
	
	
	

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
	
	public static void main(String[] args){
		JFrame frame = new JFrame();
		Login newLog = new Login();
		frame.getContentPane().add(newLog);
		frame.setSize(800, 600);
		frame.setVisible(true);
		
	}
}//end Login