import java.io.Serializable;

/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Thermostat implements Serializable{

	private String nameTh;
	private int temperature;



	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param nameTh name of a thermostat
	 */
	public Thermostat(String nameTh){
		this.nameTh = nameTh;
		temperature = 80;
	}

	public Thermostat(){
		nameTh = "Thermostat";
		temperature = 80;
	}

	/**
	 * @return the name of a thermostat
	 */
	public String getName(){
		return nameTh;
	}

	/**
	 * @return the temperature of a thermostat 
	 */
	public int getTemp(){
		return temperature;
	}

	/**
	 * 
	 * @param newName new name of a thermostat
	 * @return the name of a thermostat
	 */
	public void setName(String newName){
		nameTh = newName;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newTemp new temperature of a thermostat
	 * Set temperature of a thermostat
	 */
	public void setTemp(int newTemp){
		temperature = newTemp;
		User.saveHouseStatus();
	}
}//end Thermostat