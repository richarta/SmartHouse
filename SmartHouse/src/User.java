


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:37 PM
 */
public abstract class User {

	private String floorFile;
	private House house;
	private String houseFile;
	private String username;
	private String pass;
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
	public void addDevice(String nameRm, String nameDv, String status, int typeDv){
		
	}

	/**
	 * 
	 * @param floor
	 * @param nameRm
	 * @return 
	 */
	public void addRoom(int floor, String nameRm){

	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 * @param newStatus
	 */
	public void changeDvStatus(String nameRm, String nameDv, String [] newStatus){
		
	}

	/**
	 * 
	 * @param floor
	 * @param newNameRm
	 */
	public void changeRoomName(int floor, String newNameRm){
		
	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 */
	public void deleteDevice(String nameRm, String nameDv){
	
	}

	/**
	 * 
	 * @param floor
	 * @param nameRm
	 */
	public void deleteRoom(int floor, String nameRm){
		
	}

	/**
	 * 
	 * @param nameRm
	 * @param nameDv
	 */
	public String getDvStatus(String nameRm, String nameDv){
		return null;
	}

	public String getHouseName(){
		return null;
	}

	/**
	 * 
	 * @param nameHs
	 * @return 
	 */
	public void setHouseName(String nameHs){

	}
	
	public void setUsername(String user){
		username = user;		
	}
	
	public void setPassword(String nPass)
	{
		pass = nPass;
	}
	
	public String getUsername(String u)
	{
		return username;
	}
	
	public String getPass(String p)
	{
		return pass;
	}
}//end User