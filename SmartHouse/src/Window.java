import java.io.Serializable;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:39 PM
 */
public class Window implements Serializable{

	private boolean lockWid;
	private String nameWid;

	public void finalize() throws Throwable {

	}
	public Window(){
		nameWid = "Window";
		lockWid = true;
	}
	
	public Window(String nameWid){
		this.nameWid = nameWid;
		lockWid = true;
	}
	
	public boolean getLock(){
		return lockWid;
	}

	public String getName(){
		return nameWid;
	}

	public void setLock(boolean lock){
		this.lockWid = lock;
		User.saveHouseStatus();
	}
	
	public void setName(String name){
		this.nameWid = name;
		User.saveHouseStatus();
	}
}