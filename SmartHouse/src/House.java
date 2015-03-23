import java.util.List;




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
		
		//add floor to floor list
		floorList.add(new Floor(nameFl));
	}

	/**
	 * 
	 * @param nameTh
	 */
	public void addThermostat(String nameTh){

	}

	public List<Floor> getFloorList(){
		//return floorList
		return floorList;
	}

	/**
	 * 
	 * @param nameHs
	 */
	public String getName(){
		return "";
	}

	/**
	 * 
	 * @param nameFl
	 */
	public void removeFloor(int index){
		
		//remove floor at selected index
		floorList.remove(index);
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