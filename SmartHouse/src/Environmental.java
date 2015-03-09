// 15-03-09 QUIZ PUSH
import java.util.ArrayList;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.*;


public class Environmental extends JFrame {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Environmental frame = new Environmental();
				frame.setVisible(true);
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Environmental() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setTitle("Environmental Controls");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		getContentPane().add(mainPanel);


		JPanel	panel1 = new JPanel();
		JPanel	panel2 = new JPanel();
		JPanel	panel3 = new JPanel();
		
		floorPanel(panel1);
		floorPanel(panel2);
		floorPanel(panel3);
		
		ArrayList<JPanel> panelList = new ArrayList<JPanel>();
		panelList.add(panel1);
		panelList.add(panel2);
		panelList.add(panel3);
		
		JTabbedPane tabPane = new JTabbedPane();
		
		int nFloor = 3;
		for (int i=0; i<nFloor; i++){
			tabPane.addTab( "Floor "+ (i+1), panelList.get(i));
			mainPanel.add(tabPane);
		}

	}
	

	public void floorPanel(JPanel panel){ // Later, it would get parameter 'int nFloor'
		//Later, it would get by method
		int nLight = 3;
		String [] lightName = new String[nLight]; 
		lightName[0] = "Light1";
		lightName[1] = "Light2";
		lightName[2] = "Light3";
		
		int nFaucet = 2;
		String [] faucetName = new String[nFaucet]; 
		faucetName[0] = "Faucet1";
		faucetName[1] = "FFFaucet2";
		
		//Make panel
		panel.setLayout(null);

		// First Column
		JLabel tempLabel = new JLabel("Temerature (70F)");
		tempLabel.setBounds(65,10,200,23);
		panel.add(tempLabel);
		
		JSlider tempSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 70);
		tempSlider.setPaintLabels(true);
		tempSlider.setPaintTicks(true);
		tempSlider.setPaintTrack(true);
		tempSlider.setMajorTickSpacing(20);
		tempSlider.setMinorTickSpacing(5);
		tempSlider.setBounds(10,40,200,50);
		
		tempSlider.addChangeListener(new ChangeListener(){
			public void stateChanged (ChangeEvent e){
	            tempLabel.setText("Temerature (" + tempSlider.getValue() + "F)");
			}
		});
		
		panel.add(tempSlider);
		
		JButton psBtn = new JButton("Power Saver");
		psBtn.setBounds(10, 360, 200, 23);
		panel.add(psBtn);

		JButton menuBtn = new JButton("Menu");
		menuBtn.setBounds(10, 390, 200, 23);
		panel.add(menuBtn);
		
		// Second Column
		JLabel lightLabel = new JLabel("Lights");
		lightLabel.setBounds(400,10,200,23);
		panel.add(lightLabel);
		
		for(int k=0; k<nLight; k++){
			JCheckBox checkBox = new JCheckBox(lightName[k]);
			checkBox.setBounds(385,40+30*k,200,23);
			panel.add(checkBox);
		}
		// Third Column
		JLabel faucetLabel = new JLabel("Faucets");
		faucetLabel.setBounds(620,10,200,23);
		panel.add(faucetLabel);
		
		for(int k=0; k<nFaucet; k++){
			JCheckBox checkBox = new JCheckBox(faucetName[k]);
			checkBox.setBounds(605,40+30*k,200,23);
			panel.add(checkBox);
		}
		
	}
}