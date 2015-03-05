/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 05 March 2015
 */

import java.awt.*;
import javax.swing.*;

public class Personalize extends JPanel{

	public House m_House;
	public Login m_Login;

	public Personalize(){

	}

	public void finalize() throws Throwable {

	}
	public void add(){

	}

	public void addFloors(){

	}

	public void addHouse(){

	}

	public void remove(){

	}
	
	public static void main(String[] args){
		
		//Make username and password frame and pane
		JFrame framePersonalize = new JFrame("Username and Password");
		JPanel panelPersonalize = new JPanel();
		
		//Create button, textfields, and labels
		JButton buttonSave = new JButton("Save");
		JLabel labelUsername = new JLabel("Username");
		JLabel labelPassword = new JLabel("Password");
		JTextField textfieldUsername = new JTextField(20);
		JTextField textfieldPassword = new JTextField(20);
		
		//Set layout for pane
		panelPersonalize.setLayout(new FlowLayout());
		
		//Add labels, textfields, and button to pane in flow order
		panelPersonalize.add(labelUsername);
		panelPersonalize.add(textfieldUsername);
		panelPersonalize.add(labelPassword);
		panelPersonalize.add(textfieldPassword);
		panelPersonalize.add(buttonSave);
		
		//Add pane to frame
		framePersonalize.add(panelPersonalize);
		
		//Set size of pane and make visible
		framePersonalize.setSize(300, 175);
		framePersonalize.setVisible(true);
	}
}//end Personalize