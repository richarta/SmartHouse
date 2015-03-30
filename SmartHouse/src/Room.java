import java.util.ArrayList;
import java.util.List;


//Shane was here

/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:26 PM
 */
public class Room {

	private ArrayList<Door> doorList = new ArrayList<>();
	private ArrayList<Faucet> faucetList = new ArrayList<>();
	private ArrayList<Light> lightList = new ArrayList<>();
	private String nameRm;
	private ArrayList<Radio> radioList = new ArrayList<>();
	private ArrayList<Television> televisionList = new ArrayList<>();
	private ArrayList<Window> windowList = new ArrayList<>();
	public Thermostat m_Thermostat;
	public Window m_Window;
	public Door m_Door;
	public Television m_Television;
	public Radio m_Radio;
	public Faucet m_Faucet;
	public Light m_Light;



	public void finalize() throws Throwable {

	}
	public Room(){
		
		//set default name of room
		nameRm = "ROOM";
	}

	/**
	 * 
	 * @param nameRm
	 */
	public Room(String nameRm){
		
		//set name of room
		setName(nameRm);
	}

	/**
	 * 
	 * @param nameDr
	 */
	public void addThermostat(String nameTh){
		m_Thermostat = new Thermostat(nameTh);
	}
	
	public void addDoor(String nameDr){
		doorList.add(new Door(nameDr));
	}

	/**
	 * 
	 * @param nameFa
	 */
	public void addFaucet(String nameFa){
		faucetList.add(new Faucet(nameFa));
	}

	/**
	 * 
	 * @param nameLg
	 */
	public void addLight(String nameLg){
		lightList.add(new Light(nameLg));
	}

	/**
	 * 
	 * @param nameRd
	 */
	public void addRadio(String nameRd){
		radioList.add(new Radio(nameRd));
	}

	/**
	 * 
	 * @param nameTv
	 */
	public void addTelevision(String nameTv){
		televisionList.add(new Television(nameTv));
	}

	/**
	 * 
	 * @param nameWd
	 */
	public void addWindow(String nameWd){
		windowList.add(new Window(nameWd));
	}
	
	public Thermostat getThermostat(){
		return m_Thermostat;
	}
	
	public ArrayList<Door> getDoorList(){
		
		//return door list
		return doorList;
	}

	public ArrayList<Faucet> getFaucetList(){
		
		//return door list
		return faucetList;
	}

	public ArrayList<Light> getLightList(){
		
		//return light list
		return lightList;
	}

	public ArrayList<Radio> getListRadio(){

		//return radio list
		return radioList;
	}

	public String getName(){
		return nameRm;
	}

	public ArrayList<Television> getTelevisionList(){

		//return television list
		return televisionList;
	}

	public List<Window> getWindowList(){

		//return window list
		return windowList;
	}

	/**
	 * 
	 * @param nameDr
	 */
	public void removeDoor(String nameDr){

	}

	/**
	 * 
	 * @param nameFa
	 */
	public void removeFaucet(String nameFa){

	}

	/**
	 * 
	 * @param nameLg
	 */
	public void removeLight(String nameLg){

	}

	/**
	 * 
	 * @param nameRd
	 */
	public void removeRadio(String nameRd){

	}

	/**
	 * 
	 * @param nameTv
	 */
	public void removeTelevision(String nameTv){

	}

	/**
	 * 
	 * @param nameWd
	 */
	public void removeWindow(String nameWd){

	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){
		nameRm = newName;
	}
}//end Room