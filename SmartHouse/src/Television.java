import java.io.Serializable;


/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Television implements Serializable{

	private int channel;
	private String nameTv;
	private boolean status;
	private int volume;

	public void finalize() throws Throwable {

	}
	/**
	 * @param nameTv name of a television
	 */
	public Television(String nameTv){
		this.nameTv = nameTv;
		channel = 100;
		status = false;
		volume = 50;
	}

	public Television(){
		nameTv = "Television";
		channel = 100;
		status = false;
		volume = 50;
	}

	/**
	 * @return the channel of a television
	 */
	public int getChannel(){
		return channel;
	}

	/**
	 * @return the name of a television 
	 */
	public String getName(){
		return nameTv;
	}

	/**
	 * @return the status of a television
	 */
	public boolean getStatus(){
		return status;
	}

	/**
	 * @return the volume of a television
	 */
	public int getVolume(){
		return volume;
	}

	/**
	 * 
	 * @param newChannel new channel of a television
	 * Set channel of a television
	 */
	public void setChannel(int newChannel){
		channel = newChannel;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newName new name of a television
	 * Set name of a television
	 */
	public void setName(String newName){
		nameTv = newName;
		User.saveHouseStatus();
	}

	/**
	 * @param newStatus new status of a television
	 */
	public void setStatus(boolean newStatus){
		status = newStatus;
		User.saveHouseStatus();
	}

	/**
	 * @param newVolume new volume of a television
	 * Set volume of a television
	 */
	public void setVolume(int newVolume){
		volume = newVolume;
		User.saveHouseStatus();
	}
}//end Television