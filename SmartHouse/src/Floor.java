import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Abraham Richart
 * Floor Class
 * @created 24 March 2015
 * @version 0.1
 *
 */
public class Floor implements Serializable{
	
	//declare variables
	private String nameFl;
	private ArrayList<Room> roomList = new ArrayList<>();

	public void finalize() throws Throwable {

	}

	/**
	 * Floor constructor with no arguments 
	 * Creates floor with the name of FLOOR
	 */
	public Floor(){
		
		//set name of floor
		nameFl = "FLOOR";
	}

	/**Floor constructor with String argument
	 * Creates floor with name of argument
	 * @param newName - Name of Floor
	 */
	public Floor(String newName){
		
		//set name of floor
		nameFl = newName;
	}

	/**Add Room to Floor method
	 * @param nameRm - Name of room to be added to the floor
	 */
	public void addRoom(String nameRm){
		
		//add floor to list
		roomList.add(new Room(nameRm));
	}

	/**Get Name of Floor method
	 * @return - Name of Floor
	 */
	public String getName(){
		
		//return name of floor
		return nameFl;
	}

	/**Get Room List method
	 * @return List of Rooms on the Floor
	 */
	public ArrayList<Room> getRoomList(){
		
		//return list
		return roomList;
	}

	/**Remove Room from Floor method
	 * @param index - Room index to remove from Room List
	 */
	public void removeRoom(int index){
		
		//remove room from list
		roomList.remove(index);
	}

	/**Set Floor name method
	 * @param newName - New name of Floor
	 */
	public void setName(String newName){
		
		//set name of floor
		nameFl = newName;
	}
}//end Floor