

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public abstract class User {

	private static House house;
	public static String username;
	private static String pass;
	public Login m_Login;

	public User(){

	}

	public void finalize() throws Throwable {

	}

	
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
	
	public static void setHouse(House newHouse){
		
		//Set House
		house = newHouse;
	}
	
	public static void setUsername(String user) throws FileNotFoundException{
		
		//Set username
		username = user;
		
		//create text file with username title
		File file = new File(username + ".txt");
		if(file.exists()){
			
		}
		else{
			PrintWriter printwriter = new PrintWriter(file);
			printwriter.close();
		}
	}
	
	public static void setPassword(String nPass) throws FileNotFoundException{
		
		//Set password
		pass = nPass;
		
		//write password to file
		PrintWriter printwriter = new PrintWriter(username + ".txt");
		printwriter.print(pass);
		printwriter.close();
	}
	
	public boolean checkUsername(String u)
	{
		return true;
	}
	
	/**
	 * @author Timothy Bernier
	 * @param u - username from login to compare to .txt file name
	 * @param p - password from login to compare to .txt password
	 * @return - boolean to confirm if login matches .txt parameters
	 * @throws IOException - check for fileNotFoundException, if found login failed
	 */
	public static boolean checkLogin(String u, String p) throws IOException
	{
		try{
		File file = new File (u + ".txt");
		FileReader inputFile = new FileReader(file);
		BufferedReader bufferReader = new BufferedReader(inputFile);
		if(bufferReader.readLine().equals(p)){
			openHouseStatus(u);
			bufferReader.close();
			return true;
		}
		else
			return false;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
		
	}
}//end User
