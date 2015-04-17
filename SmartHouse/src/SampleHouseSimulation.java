/**
 * Course: SE 300-01 
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * @author: Young J. Park
 * Date: 10 April 2015
 */

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SampleHouseSimulation {
	private static JFrame sample = new JFrame();
	private static JFrame securityAlarm = new JFrame();
	private static JLabel r1Light1 = new JLabel("");
	private static JLabel r1Door1 = new JLabel("");
	private static JLabel r1Window1 = new JLabel("");
	private static JLabel kitLight1 = new JLabel("");
	private static JLabel kitWindow1 = new JLabel("");
	private static JLabel kitFaucet1 = new JLabel("");
	private static JLabel livTV1 = new JLabel("");
	private static JLabel livLight1 = new JLabel("");
	private static JLabel livDoor1 = new JLabel("");
	private static JLabel livRadio1 = new JLabel("");
	private static JLabel livWindow1 = new JLabel("");
	private static JLabel livWindow2 = new JLabel("");
	private static JLabel lblNewLabel = new JLabel("");
	private static JLabel temp = new JLabel("Temperature");
	private static JLabel houseTemp = new JLabel("");
	private static House house;
	private static int houseCT = -100;
	private static ImageIcon iconLON = new ImageIcon("samplehouse/light_on.png");
	private static ImageIcon iconLOFF = new ImageIcon("samplehouse/light_off.png");
	private static ImageIcon iconFON = new ImageIcon("samplehouse/faucet_on.png");
	private static ImageIcon iconFOFF = new ImageIcon("samplehouse/faucet_off.png");
	private static ImageIcon iconTON = new ImageIcon("samplehouse/tv_on.png");
	private static ImageIcon iconTOFF = new ImageIcon("samplehouse/tv_off.png");
	private static ImageIcon iconRON = new ImageIcon("samplehouse/radio_on.png");
	private static ImageIcon iconROFF = new ImageIcon("samplehouse/radio_off.png");
	private static ImageIcon iconWUL = new ImageIcon("samplehouse/window_unlock.png");
	private static ImageIcon iconWL = new ImageIcon("samplehouse/window_lock.png");
	private static ImageIcon iconDUL = new ImageIcon("samplehouse/door_unlock.png");
	private static ImageIcon iconDL = new ImageIcon("samplehouse/door_lock.png");
	private static ImageIcon iconBG = new ImageIcon("samplehouse/floor1.jpg");
	
	public static void main (String [] args){
		buildHouse();
		
		while(true){
			changeStatus();
			
			/*
			double r = Math.random();
			if (r < 0.1){
				System.out.println(r);
				popUpSecurityAlarm();
			}*/
		}
	}
	
	/**
	 * Builds GUI for sample house simulation
	 */
	private static void buildHouse(){
		// Build house panel
		sample.setVisible(true);
		sample.setResizable(false);
		sample.setSize(880, 519); //646,519
		sample.setTitle("Sample House Simulation");
		sample.getContentPane().setLayout(null);
		sample.addWindowListener(new WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent arg0) {
				System.out.println("Simulation Closed");
				System.exit(0);
			}
        });
		
		// Set the locations of icon
		r1Light1.setIcon(iconLOFF);
		r1Light1.setBounds(197, 273, 50, 50);
		sample.getContentPane().add(r1Light1);

		kitLight1.setIcon(iconLOFF);
		kitLight1.setBounds(197, 13, 50, 50);
		sample.getContentPane().add(kitLight1);

		livTV1.setIcon(iconTOFF);
		livTV1.setBounds(432, 318, 50, 50);
		sample.getContentPane().add(livTV1);

		kitFaucet1.setIcon(iconFOFF);
		kitFaucet1.setBounds(12, 147, 50, 50);
		sample.getContentPane().add(kitFaucet1);

		livLight1.setIcon(iconLOFF);
		livLight1.setBounds(578, 13, 50, 50);
		sample.getContentPane().add(livLight1);

		r1Window1.setIcon(iconWL);
		r1Window1.setBounds(12, 318, 50, 50);
		sample.getContentPane().add(r1Window1);
	
		kitWindow1.setIcon(iconWL);
		kitWindow1.setBounds(12, 70, 50, 50);
		sample.getContentPane().add(kitWindow1);
	
		r1Door1.setIcon(iconDL);
		r1Door1.setBounds(231, 347, 50, 50);
		sample.getContentPane().add(r1Door1);

		livDoor1.setIcon(iconDL);
		livDoor1.setBounds(291, 417, 50, 50);
		sample.getContentPane().add(livDoor1);
	
		livRadio1.setIcon(iconROFF);
		livRadio1.setBounds(334, 117, 50, 50);
		sample.getContentPane().add(livRadio1);
		
		livWindow1.setIcon(iconWL);
		livWindow1.setBounds(578, 147, 50, 50);
		sample.getContentPane().add(livWindow1);	
		
		livWindow2.setIcon(iconWL);
		livWindow2.setBounds(578, 273, 50, 50);
		sample.getContentPane().add(livWindow2);		
		
		temp.setBounds(695,15,120,20);
		temp.setHorizontalAlignment(SwingConstants.CENTER);
		temp.setFont(new Font("Tahoma", Font.BOLD, 15));
		sample.getContentPane().add(temp);
		
		houseTemp.setBounds(645,55,220,20);
		houseTemp.setHorizontalAlignment(SwingConstants.CENTER);
		houseTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		sample.getContentPane().add(houseTemp);
		
		
		lblNewLabel.setIcon(iconBG);
		lblNewLabel.setBounds(0, 0, 640, 480);
		sample.getContentPane().add(lblNewLabel);
	}
	
	/**
	 * Updates the status of sample house
	 */
	private static void changeStatus(){	
		// Wait for changing
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Open sample house
		try {
			//open file
			FileInputStream saveFile = new FileInputStream("smp.sav");
			
			//open input stream
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			//read object
			house = (House) save.readObject();

			//close file
			save.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// System.out.println("reached here");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Set temperature
		if (houseCT == -100)
			houseCT = house.getThermostat().getTemp();
		else if(houseCT < house.getThermostat().getTemp())
			houseCT++;
		else if(houseCT > house.getThermostat().getTemp())
			houseCT--;
		
		if (houseCT == house.getThermostat().getTemp())
			houseTemp.setFont(new Font("Tahoma", Font.BOLD, 13));
		else
			houseTemp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		houseTemp.setText("House Temperature = "+ houseCT +"F");
		
		// Set icons
		if (house.getFloorList().get(0).getRoomList().get(0).getLightList().get(0).getStatus())
			r1Light1.setIcon(iconLON);
		else
			r1Light1.setIcon(iconLOFF);
		
		if (house.getFloorList().get(0).getRoomList().get(0).getDoorList().get(0).getLock())
			r1Door1.setIcon(iconDL);
		else
			r1Door1.setIcon(iconDUL);
		
		if (house.getFloorList().get(0).getRoomList().get(0).getWindowList().get(0).getLock())
			r1Window1.setIcon(iconWL);
		else
			r1Window1.setIcon(iconWUL);
		
		if (house.getFloorList().get(0).getRoomList().get(1).getLightList().get(0).getStatus())
			kitLight1.setIcon(iconLON);
		else
			kitLight1.setIcon(iconLOFF);
		
		if (house.getFloorList().get(0).getRoomList().get(1).getWindowList().get(0).getLock())
			kitWindow1.setIcon(iconWL);
		else
			kitWindow1.setIcon(iconWUL);
		
		if (house.getFloorList().get(0).getRoomList().get(1).getFaucetList().get(0).getStatus())
			kitFaucet1.setIcon(iconFON);
		else
			kitFaucet1.setIcon(iconFOFF);
			
		if (house.getFloorList().get(0).getRoomList().get(2).getLightList().get(0).getStatus())
			livLight1.setIcon(iconLON);
		else
			livLight1.setIcon(iconLOFF);
		
		if (house.getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus())
			livTV1.setIcon(iconTON);
		else
			livTV1.setIcon(iconTOFF);
		
		if (house.getFloorList().get(0).getRoomList().get(2).getRadioList().get(0).getStatus())
			livRadio1.setIcon(iconRON);
		else
			livRadio1.setIcon(iconROFF);
		
		if (house.getFloorList().get(0).getRoomList().get(2).getDoorList().get(0).getLock())
			livDoor1.setIcon(iconDL);
		else
			livDoor1.setIcon(iconDUL);
		
		if (house.getFloorList().get(0).getRoomList().get(2).getWindowList().get(0).getLock())
			livWindow1.setIcon(iconWL);
		else
			livWindow1.setIcon(iconWUL);
		
		if (house.getFloorList().get(0).getRoomList().get(2).getWindowList().get(1).getLock())
			livWindow2.setIcon(iconWL);
		else
			livWindow2.setIcon(iconWUL);
	}
	
	/*
	private static void popUpSecurityAlarm(){
		// Initialize the panel
		securityAlarm.setVisible(true);
		securityAlarm.setTitle("Security Alarm");
		securityAlarm.setSize(450, 100);
		securityAlarm.getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Invader Found! Lock all the doors and windows");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbl1.setBounds(0,15,422,15);
		securityAlarm.getContentPane().add(lbl1, BorderLayout.NORTH);
		
		// Lock all the doors and windows
		for (int i =0; i<house.getFloorList().size(); i++){
			for (int j=0; j<house.getFloorList().get(i).getRoomList().size(); j++){
				for (int k1=0; k1<house.getFloorList().get(i).getRoomList().get(j).getDoorList().size(); k1++)
					house.getFloorList().get(i).getRoomList().get(j).getDoorList().get(k1).setLock(true);
				for (int k2=0; k2<house.getFloorList().get(i).getRoomList().get(j).getWindowList().size(); k2++)
					house.getFloorList().get(i).getRoomList().get(j).getWindowList().get(k2).setLock(true);
			}
		}
		
		// Save the change
		try {
			FileOutputStream saveFile = new FileOutputStream("smp.sav");
			
			//create object to save objects to file
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			
			//save floor information
			save.writeObject(house);
			
			//close file
			save.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
