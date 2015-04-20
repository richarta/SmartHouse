import java.io.Serializable;

/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Door implements Serializable{

	private boolean lock;
	private String nameDr;



	public void finalize() throws Throwable {

	}
	public Door() {
		lock = true;
		nameDr = "Door";
	}

	/**
	 * @param nameDr the name of a door
	 */
	public Door(String nameDr){
		lock = true;
		this.nameDr = nameDr;
	}

	/**
	 * @return the lock state of a door
	 */
	public boolean getLock(){
		return lock;
	}

	/**
	 * @return the name of a door
	 */
	public String getName(){
		return nameDr;
	}

	/**
	 * @param newLock new lock state of a door
	 * Set lock state of a door
	 */
	public void setLock(boolean newLock){
		lock = newLock;
		User.saveHouseStatus();
	}

	/**
	 * @param newName new name of a door
	 * Set name of a door
	 */
	public void setName(String newName){
		nameDr = newName;
		User.saveHouseStatus();
	}
}//end Door
