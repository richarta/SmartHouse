
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.GridLayout;
import java.awt.CardLayout;

	public class SelectionMenu extends JPanel{
		
		private static JFrame frame = new JFrame("Main Menu");
		//Tim added comment for hands on quiz
		
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

				}
			});
			
			frame.setVisible(true);
			
		}
		
		public static void main(String[] args){

			new SelectionMenu();

		}

	}

	