import java.io.Serializable;




/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:12 PM
 */
public class Faucet implements Serializable{

	private String nameFa;
	private boolean status;



	public void finalize() throws Throwable {

	}
	public Faucet(){
		nameFa ="Faucet";
		status = false;
	}

	/**
	 * 
	 * @param nameFa
	 * @return 
	 */
	public Faucet(String nameFa){
		this.nameFa = nameFa;
		status = false;
	}

	public String getName(){
		return nameFa;
	}

	public boolean getStatus(){
		return status;
	}

	/**
	 * 
	 * @param newName
	 * @return 
	 */
	public void setName(String newName){
		nameFa = newName;
		User.saveHouseStatus();
	}

	public void setStatus(boolean newStatus){
		status = newStatus;
		User.saveHouseStatus();
	}
}//end Faucet