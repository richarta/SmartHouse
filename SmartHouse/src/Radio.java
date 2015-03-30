
/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Radio {

	private int channel;
	private String nameRd;
	private boolean status;
	private int volume;

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param nameRd name of Radio
	 */
	public Radio(String nameRd){
		this.nameRd = nameRd;
		channel = 100;
		status = false;
		volume = 50;
	}

	public Radio(){
		nameRd = "Radio";
		channel = 100;
		status = false;
		volume = 50;
	}

	public int getChannel(){
		return channel;
	}

	public String getName(){
		return nameRd;
	}

	public boolean getStatus(){
		return status;
	}

	public int getVolume(){
		return volume;
	}

	/**
	 * 
	 * @param newChannel new channel of radio
	 * @return 
	 */
	public void setChannel(int newChannel){
		channel = newChannel;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newName new name of radio
	 * @return 
	 */
	public void setName(String newName){
		nameRd = newName;
		User.saveHouseStatus();
	}

	/**
	 * @param newStatus new status of radio
	 */
	public void setStatus(boolean newStatus){
		status = newStatus;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newVolume new volume of radio
	 * @return 
	 */
	public void setVolume(int newVolume){
		volume = newVolume;
		User.saveHouseStatus();
	}
}//end Radio