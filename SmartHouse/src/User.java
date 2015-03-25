

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
	
	public void saveHouseStatus(){
		
		//Open file in try block
		try {
			FileOutputStream saveFile = new FileOutputStream(username + ".sav");
			
			//create object to save objects to file
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			
			//save floor information
			save.writeObject(house);
			
			//close file
			save.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void openHouseStatus(){
		
		try {
			
			//open file
			FileInputStream saveFile = new FileInputStream(username + ".sav");
			
			//open input stream
			ObjectInputStream save = new ObjectInputStream(saveFile);
			
			//read object
			house = (House) save.readObject();
			
			//close file
			save.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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