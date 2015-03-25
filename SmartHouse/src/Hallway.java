import java.util.List;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @author Abraham
 * @version 1.0
 * @created 26-Feb-2015 6:23:15 PM
 */
public class Hallway {

	private List<Light> lightList;
	private String nameHw;
	public Light m_Light;

	private JFrame jframe = new JFrame();

	public void finalize() throws Throwable {

	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public void Hallway(){
		jframe.setTitle("Hallway");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 
	 * @param nameHw
	 */
	public void Hallway(String nameHw){

	}

	/**
	 * 
	 * @param nameLg
	 */
	public void addLight(String nameLg){

	}

	public List<Light> getLightList(){
		return null;
	}

	public String getName(){
		return "";
	}

	/**
	 * 
	 * @param nameLg
	 */
	public void removeLight(String nameLg){

	}

	/**
	 * 
	 * @param newName
	 */
	public void setName(String newName){

	}
}//end Hallway