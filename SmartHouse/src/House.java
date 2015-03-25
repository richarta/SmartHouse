/*
 * Course: SE 300-01
 * Term: Spring 2015
 * Assignment: SmartHouse Project
 * Author: Abraham Richart
 * Date: 24 March 2015
 */

import java.util.ArrayList;

public class House{
	
	//Declare variables
	private ArrayList<Floor> floorList = new ArrayList<>();
	private String nameHs;
	private Thermostat thermostat = new Thermostat();

	public void finalize() throws Throwable {

	}
	
	public House(){
		
		//set basic name of house
		nameHs = "HOUSE";
	}

	public void addFloor(String nameFl){
		
		//add floor to list
		floorList.add(new Floor(nameFl));
	}

	public void addThermostat(String nameTh){
		
		//set name for thermostat
		thermostat.setName(nameTh);
	}

	public ArrayList<Floor> getFloorList(){
		
		//return floorList
		return floorList;
	}

	public Thermostat getThermostat(){
		
		//return thermostat
		return thermostat;
	} 
	
	public String getName(){
		
		//return house name
		return nameHs;
	}

	public void removeFloor(int index){
		
		//remove floor at selected index
		floorList.remove(index);
	}
	
	public void setName(String newName){
		
		//set name of house
		nameHs = newName;
	}
}//end House