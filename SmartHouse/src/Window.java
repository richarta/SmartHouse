import java.io.Serializable;


/**
 * @author Shane
 *
 */
public class Window implements Serializable{

	private boolean lockWid;
	private boolean closed;
	private String nameWid;

	public void finalize() throws Throwable {

	}
	public Window(){
		nameWid = "Window";
		lockWid = true;
		closed = true;
	}
	
	public Window(String nameWid){
		this.nameWid = nameWid;
		lockWid = true;
		closed = true;
	}
	
	public boolean getClosed(){
		return closed;
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
	
	public void setClosed(boolean newClosed){
		closed = newClosed;
		User.saveHouseStatus();
	}
	
	public void setName(String name){
		this.nameWid = name;
		User.saveHouseStatus();
	}
}
