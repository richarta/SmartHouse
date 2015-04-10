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
	 * 
	 * @param nameTv name of television
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

	public int getChannel(){
		return channel;
	}

	public String getName(){
		return nameTv;
	}

	public boolean getStatus(){
		return status;
	}

	public int getVolume(){
		return volume;
	}

	/**
	 * 
	 * @param newChannel new channel of television
	 * @return 
	 */
	public void setChannel(int newChannel){
		channel = newChannel;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newName new name of television
	 * @return 
	 */
	public void setName(String newName){
		nameTv = newName;
		User.saveHouseStatus();
	}

	/**
	 * @param newStatus new status of television
	 */
	public void setStatus(boolean newStatus){
		status = newStatus;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newVolume new volume of television
	 * @return 
	 */
	public void setVolume(int newVolume){
		volume = newVolume;
		User.saveHouseStatus();
	}
}//end Television