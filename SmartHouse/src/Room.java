package System;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:26 PM
 */
public class Room {

	private List<Door> doorList;
	private List<Faucet> faucetList;
	private List<Light> lightList;
	private String nameRm;
	private List<Radio> radioList;
	private List<Television> televisionList;
	private List<Window> windowList;
	public Window m_Window;
	public Door m_Door;
	public Television m_Television;
	public Radio m_Radio;
	public Faucet m_Faucet;
	public Light m_Light;



	public void finalize() throws Throwable {

	}
	public void Room(){

	}

	/**
	 * 
	 * @param nameRm
	 */
	public void Room(String nameRm){

	}

	/**
	 * 
	 * @param nameDr
	 */
	public void addDoor(String nameDr){

	}

	/**
	 * 
	 * @param nameFa
	 */
	public void addFaucet(String nameFa){

	}

	/**
	 * 
	 * @param nameLg
	 */
	public void addLight(String nameLg){

	}

	/**
	 * 
	 * @param nameRd
	 */
	public void addRadio(String nameRd){

	}

	/**
	 * 
	 * @param nameTv
	 */
	public void addTelevision(String nameTv){

	}

	/**
	 * 
	 * @param nameWd
	 */
	public void addWindow(String nameWd){

	}

	public List<Door> getDoorList(){
		return null;
	}

	public List<Faucet> getFaucetList(){
		return null;
	}

	public List<Light> getLightList(){
		return null;
	}

	public List<Radio> getListRadio(){
		return null;
	}

	public String getName(){
		return "";
	}

	public List<Television> getTelevisionList(){
		return null;
	}

	public List<Window> getWindowList(){
		return null;
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

	}
}//end Room