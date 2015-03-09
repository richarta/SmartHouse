/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 06 March 2015
 */

public class SmartHouseApp {
	public static void main(String[] args){
		
		//Run Login Page without creating a Login object
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login login = new Login();
			}
		});
	}
}//end SmartHouse App