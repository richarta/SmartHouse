import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:26 PM
 */
public class Room implements Serializable{

	private ArrayList<Door> doorList = new ArrayList<>();
	private ArrayList<Faucet> faucetList = new ArrayList<>();
	private ArrayList<Light> lightList = new ArrayList<>();
	private String nameRm;
	private ArrayList<Radio> radioList = new ArrayList<>();
	private ArrayList<Television> televisionList = new ArrayList<>();
	private ArrayList<Window> windowList = new ArrayList<>();

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

	public ArrayList<Radio> getRadioList(){

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
	 * @param index
	 * 
	 * Removes Door in Door list at specified index
	 */
	public void removeDoor(int index){
		getDoorList().remove(index);
	}

	/**
	 * 
	 * @param nameFa
	 */
	public void removeFaucet(int index){
		getFaucetList().remove(index);
	}

	/**
	 * 
	 * @param nameLg
	 */
	public void removeLight(int index){
		getLightList().remove(index);
	}

	/**
	 * 
	 * @param nameRd
	 */
	public void removeRadio(int index){
		getRadioList().remove(index);
	}

	/**
	 * 
	 * @param nameTv
	 */
	public void removeTelevision(int index){
		getTelevisionList().remove(index);
	}

	/**
	 * 
	 * @param nameWd
	 */
	public void removeWindow(int index){
		getWindowList().remove(index);
	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){
		nameRm = newName;
	}
}//end Room