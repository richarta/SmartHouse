import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Abraham Richart
 * Room Class
 * @created 24 March 2015
 * @version 0.1
 *
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
	
	
	/**Room constructor with no argument
	 * Creates Room with name of ROOM
	 */
	public Room(){
		
		//set default name of room
		nameRm = "ROOM";
	}

	/**Room constructor with a String argument
	 * Creates Room with the name of the arguement
	 * @param nameRm - Name of Room
	 */
	public Room(String nameRm){
		
		//set name of room
		setName(nameRm);
	}
	
	/**Add Door to Room method
	 * @param nameDr - name of Door to be added to Room
	 */
	public void addDoor(String nameDr){
		
		//Add door to door list
		doorList.add(new Door(nameDr));
	}

	/**Add Faucet to Room method
	 * @param nameFa - name of Faucet to add to Room
	 */
	public void addFaucet(String nameFa){
		faucetList.add(new Faucet(nameFa));
	}

	/**Add Light to Room method
	 * @param nameLg - name of Light to add to Room
	 */
	public void addLight(String nameLg){
		lightList.add(new Light(nameLg));
	}

	/**Add Radio to Room method
	 * @param nameRd - name of Radio to add to Room
	 */
	public void addRadio(String nameRd){
		radioList.add(new Radio(nameRd));
	}

	/**Add TV to Room method
	 * @param nameTv - name of TV to add to Room
	 */
	public void addTelevision(String nameTv){
		televisionList.add(new Television(nameTv));
	}

	/**Add Window to Room method
	 * @param nameWd - name of Window to add to Room
	 */
	public void addWindow(String nameWd){
		windowList.add(new Window(nameWd));
	}
	
	/**Get Door List method
	 * @return List of Doors for the Room
	 */
	public ArrayList<Door> getDoorList(){
		
		//return door list
		return doorList;
	}

	/**Get Faucet List method
	 * @return List of Faucets for the Room
	 */
	public ArrayList<Faucet> getFaucetList(){
		
		//return door list
		return faucetList;
	}

	/**Get Light List method
	 * @return List of Lights for the Room
	 */
	public ArrayList<Light> getLightList(){
		
		//return light list
		return lightList;
	}

	/**Get Radio List method
	 * @return List of Radios for the Room
	 */
	public ArrayList<Radio> getRadioList(){

		//return radio list
		return radioList;
	}

	/**Get name of Room method
	 * @return name of Room
	 */
	public String getName(){
		return nameRm;
	}

	/**Get Television List method
	 * @return List of Televisions for the Room
	 */
	public ArrayList<Television> getTelevisionList(){

		//return television list
		return televisionList;
	}

	/**Get Window List method
	 * @return List of Windows for the Room
	 */
	public List<Window> getWindowList(){
		
		//return window list
		return windowList;
	}

	/**Remove Door from Room method
	 * @param index - Index of Door List to be removed
	 */
	public void removeDoor(int index){
		getDoorList().remove(index);
	}

	/**Remove Faucet from Room method
	 * @param index - Index of Faucet List to be removed
	 */
	public void removeFaucet(int index){
		getFaucetList().remove(index);
	}

	/**Remove Light from Room method
	 * @param index - Index of Light List to be removed
	 */
	public void removeLight(int index){
		getLightList().remove(index);
	}

	/**Remove Radio from Room method
	 * @param index - Index of Radio List to be removed
	 */
	public void removeRadio(int index){
		getRadioList().remove(index);
	}

	/**Remove Television from Room method
	 * @param index - Index of Television List to be removed
	 */
	public void removeTelevision(int index){
		getTelevisionList().remove(index);
	}

	/**Remove Window from Room method
	 * @param index - Index of Window List to be removed
	 */
	public void removeWindow(int index){
		getWindowList().remove(index);
	}

	/**Set name of Room method
	 * @param newName - new name of Room
	 */
	public void setName(String newName){
		nameRm = newName;
	}
}//end Room