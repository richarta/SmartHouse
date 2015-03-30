

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class User {

	private static House house;
	private static String username;
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
	
	public static void saveHouseStatus(){
		
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

	public static void openHouseStatus(String username){
		
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
	
	public static House getHouse(){
		
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
	
	public boolean checkUsername(String u)
	{
		return true;
	}
	
	public static boolean checkLogin(String u, String p) throws IOException
	{
		try{
		FileReader inputFile = new FileReader(u + ".txt");
		BufferedReader bufferReader = new BufferedReader(inputFile);
		if(bufferReader.readLine().equals(p)){
			return true;
		}
		else
			return false;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
	}
}//end User
