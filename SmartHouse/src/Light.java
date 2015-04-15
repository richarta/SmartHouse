import java.io.Serializable;


/**
 * @author Shane
 *
 */
public class Light implements Serializable{

	private String nameLg;
	private boolean lightStatus;

	public void finalize() throws Throwable {

	}
	public Light(){
		nameLg = "Light";
		lightStatus = false;
	}
	
	public Light(String nameLg){
		this.nameLg = nameLg;
		lightStatus = false;
	}

	public void setName(String nameLg){
		this.nameLg = nameLg;
		User.saveHouseStatus();
	}

	public String getName(){
		return nameLg;
		
	}

	public void setStatus(boolean lightStatus){
		this.lightStatus = lightStatus;
		User.saveHouseStatus();
	}

	public boolean getStatus(){
		return lightStatus;
	}

}
