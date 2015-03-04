package System;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:17 PM
 */
public abstract class House {

	private List<Floor> floorList;
	private String nameHs;
	private String nameTh;
	private User m_User;
	public Entertainment m_Entertainment;
	public Security m_Security;
	public Thermostat m_Thermostat;
	public Floor m_Floor;



	public void finalize() throws Throwable {

	}
	public void House(){

	}

	/**
	 * 
	 * @param nameHs
	 */
	public void House(String nameHs){

	}

	/**
	 * 
	 * @param nameFl
	 */
	public void addFloor(String nameFl){

	}

	/**
	 * 
	 * @param nameTh
	 */
	public void addThermostat(String nameTh){

	}

	public List<Floor> getFloorList(){
		return null;
	}

	/**
	 * 
	 * @param nameHs
	 */
	public String getName(nameHs){
		return "";
	}

	/**
	 * 
	 * @param nameFl
	 */
	public void removeFloor(String nameFl){

	}

	/**
	 * 
	 * @param nameTh
	 */
	public void removeThermostat(String nameTh){

	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){

	}
}//end House