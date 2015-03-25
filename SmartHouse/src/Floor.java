import java.util.ArrayList;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:14 PM
 */
public class Floor {

	private String nameFl;
	private ArrayList<Room> roomList = new ArrayList<>();
	public Hallway m_Hallway;
	public Room m_Room;



	public void finalize() throws Throwable {

	}

	public Floor(){

	}

	public Floor(String newName){
		
		//set name of floor
		nameFl = newName;
	}

	public void addRoom(String nameRm){

	}

	public String getName(){
		
		//return name of floor
		return nameFl;
	}

	public ArrayList<Room> getRoomList(){
		
		//return list
		return roomList;
	}

	public void removeRoom(String nameRm){

	}

	public void setName(String newName){
		
		//set name of floor
		nameFl = newName;
	}
}//end Floor