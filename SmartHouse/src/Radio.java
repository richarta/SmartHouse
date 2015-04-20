import java.io.Serializable;

/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Radio implements Serializable{

	private int channel;
	private String nameRd;
	private boolean status;
	private int volume;

	public void finalize() throws Throwable {

	}
	/**
	 * @param nameRd the name of a radio
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

	/**
	 * @return the channel of a radio
	 */
	public int getChannel(){
		return channel;
	}

	/**
	 * @return the name of a radio
	 */
	public String getName(){
		return nameRd;
	}

	/**
	 * @return the status (on/off) of a radio
	 */
	public boolean getStatus(){
		return status;
	}

	/**
	 * @return the volume of a radio
	 */
	public int getVolume(){
		return volume;
	}

	/** 
	 * @param newChannel new channel of a radio
	 */
	public void setChannel(int newChannel){
		channel = newChannel;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newName new name of a radio
	 * @return 
	 */
	public void setName(String newName){
		nameRd = newName;
		User.saveHouseStatus();
	}

	/**
	 * @param newStatus new status of a radio
	 * Set status of a radio
	 */
	public void setStatus(boolean newStatus){
		status = newStatus;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newVolume new volume of a radio
	 * Set volume of a radio
	 */
	public void setVolume(int newVolume){
		volume = newVolume;
		User.saveHouseStatus();
	}
}//end Radio