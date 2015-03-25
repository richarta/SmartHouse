


/**
 * @author YoungJin
 * @version 1.0
 * @created 26-Mar-2015
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
		this.temperature = 70;
	}

	public Thermostat(){
		this.nameTh = "Thermostat";
		this.temperature = 70;
	}

	public String getName(){
		return this.nameTh;
	}

	public int getTemp(){
		return this.temperature;
	}

	/**
	 * 
	 * @param newName new name of thermostat
	 * @return 
	 */
	public void setName(String newName){
		this.nameTh = newName;
	}

	/**
	 * 
	 * @param newTemp new temperature of thermostat
	 * @return 
	 */
	public void setTemp(int newTemp){
		this.temperature = newTemp;
	}
}//end Thermostat