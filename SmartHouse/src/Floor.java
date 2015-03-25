import java.util.ArrayList;

public class Floor {
	
	//declare variables
	private String nameFl;
	private ArrayList<Room> roomList = new ArrayList<>();

	public void finalize() throws Throwable {

	}

	public Floor(){
		
		//set name of floor
		nameFl = "FLOOR";
	}

	public Floor(String newName){
		
		//set name of floor
		nameFl = newName;
	}

	public void addRoom(String nameRm){
		
		//add floor to list
		roomList.add(new Room(nameRm));
	}

	public String getName(){
		
		//return name of floor
		return nameFl;
	}

	public ArrayList<Room> getRoomList(){
		
		//return list
		return roomList;
	}

	public void removeRoom(int index){
		
		//remove room from list
		roomList.remove(index);
	}

	public void setName(String newName){
		
		//set name of floor
		nameFl = newName;
	}
}//end Floor