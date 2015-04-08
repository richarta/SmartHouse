
/**
 * @author YoungJin
 * @version 1.0
 * @created 25-Mar-2015
 */
public class Door {

	private boolean lock;
	private String nameDr;



	public void finalize() throws Throwable {

	}
	public Door() {
		lock = true;
		nameDr = "Door";
	}

	/**
	 * 
	 * @param nameDr
	 */
	public Door(String nameDr){
		lock = true;
		this.nameDr = nameDr;
	}

	public boolean getLock(){
		return lock;
	}

	public String getName(){
		return nameDr;
	}

	/**
	 * @param newLock new lock state
	 */
	public void setLock(boolean newLock){
		lock = newLock;
		User.saveHouseStatus();
	}

	/**
	 * 
	 * @param newName new name of door
	 */
	public void setName(String newName){
		nameDr = newName;
		User.saveHouseStatus();
	}
}//end Door
