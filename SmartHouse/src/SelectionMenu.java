
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
			
			entbtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e1) {
					frame.setVisible(false);
					new Entertainment();
					
				}
			});

			secbtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e1) {
					frame.setVisible(false);
					new Security();
					
				}
			});
			
			envrbtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e2) {
					frame.setVisible(false);
					new Environmental();
				}
			});
			
			logout.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e3) {
					frame.setVisible(false);
					new Login();
				}
			});
			
			helpbtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e4) {
					
					help();
				}
			});
			
			frame.setVisible(true);
			
		}
		
		public static void help(){
			
			JPanel help = new JPanel();
			JFrame helpf = new JFrame();
			
			helpf = new JFrame("Help");
			helpf.setSize(850, 150);
			
			JLabel label1 = new JLabel("Hello and welcome to your SmartHouse remote! Once you have personlized your house, get started by clicking one of the Main Menu buttons.");
			label1.setVerticalTextPosition(JLabel.TOP);
			label1.setHorizontalTextPosition(JLabel.CENTER);
			help.add(label1);
			
			
			JLabel label3 = new JLabel("The Envronmental button will allow you to change settings that include power, lighting, utilities, and power saver mode");
			label1.setVerticalTextPosition(JLabel.BOTTOM);
			label1.setHorizontalTextPosition(JLabel.LEFT);	
			help.add(label3);
			
			JLabel label4 = new JLabel("The Security button will allow you to change settings that include doors, windows, and lockdown mode");
			label1.setVerticalTextPosition(JLabel.BOTTOM);
			label1.setHorizontalTextPosition(JLabel.CENTER);
			help.add(label4);
			
			JLabel label5 = new JLabel("The Entertainment button will allow you to change settings that include electronics, lighting, and power saver mode");
			label1.setVerticalTextPosition(JLabel.BOTTOM);
			label1.setHorizontalTextPosition(JLabel.RIGHT);
			help.add(label5);
			
			helpf.getContentPane().add(help);
			help.setVisible(true);
			helpf.setVisible(true);
			
			
		}
		
		public static void main(String[] args){

			new SelectionMenu();

		}

	}

	