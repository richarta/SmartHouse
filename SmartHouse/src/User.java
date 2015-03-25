

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
	
	public House getHouse(){
		
		//return house
		return house;
	}
	
	public void setHouse(House newHouse){
		
		//Set House
		house = newHouse;
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