
/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Television {

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
		channel = 10;
		status = false;
		volume = 50;
	}

	public Television(){
		nameTv = "Television";
		channel = 10;
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
	}

	/**
	 * 
	 * @param newName new name of television
	 * @return 
	 */
	public void setName(String newName){
		nameTv = newName;
	}

	/**
	 * @param newStatus new status of television
	 */
	public void setStatus(boolean newStatus){
		status = newStatus;
	}

	/**
	 * 
	 * @param newVolume new volume of television
	 * @return 
	 */
	public void setVolume(int newVolume){
		volume = newVolume;
	}
}//end Television