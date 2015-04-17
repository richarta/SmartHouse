/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 24 March 2015
 */ 

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Abraham Richart
 * House Class
 * @created 24 March 2015
 * @version 0.1
 *
 */
public class House implements Serializable{
	
	//Declare variables
	private ArrayList<Floor> floorList = new ArrayList<>();
	private String nameHs;
	private Thermostat thermostat = new Thermostat();
	private boolean combat = false;
	
	public void finalize() throws Throwable {

	}
	
	/**
	 * House constructor with no arguments 
	 */
	public House(){
		
		//set basic name of house
		nameHs = "HOUSE";
		addThermostat("Thermostat");
	}

	/**Add Floor to House method
	 * @param nameFl - Name of Floor to be added to Floor List
	 * @return void
	 */
	public void addFloor(String nameFl){
		
		//add floor to list
		floorList.add(new Floor(nameFl));
	}

	/**Add Thermostat to House method
	 * @param nameTh - Name of Thermostat
	 * @return void
	 */
	public void addThermostat(String nameTh){
		
		//set name for thermostat
		thermostat.setName(nameTh);
	}

	/**Get Floor List of House Method
	 * @return List of Floors for the House
	 */
	public ArrayList<Floor> getFloorList(){
		
		//return floorList
		return floorList;
	}

	/**Get House Thermostat method
	 * @return House Thermostat
	 */
	public Thermostat getThermostat(){
		
		//return thermostat
		return thermostat;
	} 
	
	/**Get House Name method
	 * @return Name of House
	 */
	public String getName(){
		
		//return house name
		return nameHs;
	}

	/**Remove Floor from house method
	 * @param index - Floor List index to be removed
	 */
	public void removeFloor(int index){
		
		//remove floor at selected index
		floorList.remove(index);
	}
	
	/**Set name of House Method
	 * @param newName - New name of House
	 */
	public void setName(String newName){
		
		//set name of house
		nameHs = newName;
	}
	
	public boolean getCombat(){
		return combat;
	}
	
	public void setCombat(boolean newCombat){
		combat = newCombat;
	}
}//end House