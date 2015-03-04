package System;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:37 PM
 */
public abstract class User {

	private String floorFile;
	private House house;
	private String houseFile;
	public Login m_Login;

	public User(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 * @param status
	 * @param typeDv
	 */
	public int addDevice(String nameRm, String nameDv, String [] status, int typeDv){
		return 0;
	}

	/**
	 * 
	 * @param floor
	 * @param nameRm
	 */
	public addRoom(int floor, String nameRm){

	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 * @param newStatus
	 */
	public int changeDvStatus(String nameRm, String nameDv, String [] newStatus){
		return 0;
	}

	/**
	 * 
	 * @param floor
	 * @param newNameRm
	 */
	public int changeRoomName(int floor, String newNameRm){
		return 0;
	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 */
	public int deleteDevice(String nameRm, String nameDv){
		return 0;
	}

	/**
	 * 
	 * @param floor
	 * @param nameRm
	 */
	public int deleteRoom(int floor, String nameRm){
		return 0;
	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 */
	public String [] getDvStatus(String nameRm, String nameDv){
		return null;
	}

	public String getHouseName(){
		return "";
	}

	/**
	 * 
	 * @param nameHs
	 */
	public setHouseName(String nameHs){

	}
}//end User