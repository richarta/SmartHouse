
/**
 * @author Shane
 *
 */
public class Window {

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