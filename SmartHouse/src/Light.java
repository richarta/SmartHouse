
/**
 * @author Shane
 *
 */
public class Light {

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

	public void setlightName(String nameLg){
		this.nameLg = nameLg;
		User.saveHouseStatus();
	}

	public String getlightName(){
		return nameLg;
		
	}

	public void setLightStatus(boolean lightStatus){
		this.lightStatus = lightStatus;
		User.saveHouseStatus();
	}

	public boolean getLightStatus(){
		return lightStatus;
	}

}