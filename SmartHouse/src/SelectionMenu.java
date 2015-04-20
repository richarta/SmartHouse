
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.Color;

	/**
	 * @author Shane
	 */
	public class SelectionMenu extends JPanel{
		
		private House house;
		
		public SelectionMenu() {
			
			
			JFrame frame;
			JButton envrbtn,secbtn,entbtn;
			JPanel panel;
			
			panel = new JPanel();
			panel.setVisible(true);
			
			frame = new JFrame("Main Menu");
			frame.setSize(368, 429);
			frame.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			ImageIcon img_tvON = new ImageIcon("icon/tv_on.png");
			entbtn = new JButton("Entertainment");
			entbtn.setIcon(img_tvON);
			entbtn.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 14));
			entbtn.setBounds(90, 245, 159, 50);
			panel.add(entbtn);
			
			JButton helpbtn = new JButton("Help");
			helpbtn.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 11));
			helpbtn.setBounds(260, 342, 82, 38);
			panel.add(helpbtn);
			
			ImageIcon img_lightON = new ImageIcon("icon/light_on.png");
			envrbtn = new JButton("Environmental");
			envrbtn.setIcon(img_lightON);
			envrbtn.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 14));
			envrbtn.setBounds(90, 123, 159, 50);
			panel.add(envrbtn);
			
			JButton logout = new JButton("LogOut");
			logout.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 11));
			logout.setBounds(10, 342, 82, 38);
			panel.add(logout);
			
			ImageIcon img_doorLocked = new ImageIcon("icon/door_locked.png");
			secbtn = new JButton("Security");
			secbtn.setIcon(img_doorLocked);
			secbtn.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 14));
			secbtn.setBounds(90, 184, 159, 50);
			panel.add(secbtn);
			
			try{
			house = User.getHouse();
			String houseName = new  String(house.getName());
			JLabel housenm = new JLabel(houseName);
			housenm.setFont(new java.awt.Font("Segoe UI Light", java.awt.Font.PLAIN, 24));
			housenm.setForeground(Color.BLACK);
			housenm.setBackground(Color.BLACK);
			housenm.setBounds(0,33,352,50);
			housenm.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(housenm);
			}catch (NullPointerException e){
				System.out.println("No house name");
			}
			
			frame.setLocationRelativeTo(null);
			
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
			helpf.setLocationRelativeTo(null);
			
		}
		

	}

	