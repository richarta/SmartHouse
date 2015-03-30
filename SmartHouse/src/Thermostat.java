


/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Thermostat {

	private String nameTh;
	private int temperature;



	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param nameTh name of thermostat
	 */
	public Thermostat(String nameTh){
		this.nameTh = nameTh;
		temperature = 80;
	}

	public Thermostat(){
		nameTh = "Thermostat";
		temperature = 80;
	}

	public String getName(){
		return nameTh;
	}

	public int getTemp(){
		return temperature;
	}

	/**
	 * 
	 * @param newName new name of thermostat
	 * @return 
	 */
	public void setName(String newName){
		nameTh = newName;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newTemp new temperature of thermostat
	 * @return 
	 */
	public void setTemp(int newTemp){
		temperature = newTemp;
		User.saveHouseStatus();
	}
}//end Thermostat