import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import javax.swing.JTextField;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RichartJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@SuppressWarnings("static-access")
	@Test
	public void testFloor() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		assertEquals("First", personalize.getHouse().getFloorList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testRoom() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		assertEquals("Kitchen", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testDoorAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("Front");
		personalize.setTextField(tfAddition);
		
		personalize.addDoor();
		
		assertEquals("Front", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getDoorList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testWindowAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("Bay");
		personalize.setTextField(tfAddition);
		
		personalize.addWindow();
		
		assertEquals("Bay", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getWindowList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testTVAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("56 inch");
		personalize.setTextField(tfAddition);
		
		personalize.addTV();
		
		assertEquals("56 inch", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getTelevisionList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testLightAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("Overhead");
		personalize.setTextField(tfAddition);
		
		personalize.addLight();
		
		assertEquals("Overhead", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getLightList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testRadioAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("Kitchen Radio");
		personalize.setTextField(tfAddition);
		
		personalize.addRadio();
		
		assertEquals("Kitchen Radio", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getRadioList().get(0).getName());
		
	}
	@SuppressWarnings("static-access")
	@Test
	public void testFaucetAddition() {
		
		Personalize personalize = new Personalize();
		
		JTextField tf = new JTextField();
		tf.setText("First");
		personalize.setTfNameFL(tf);
		
		personalize.addFloor();
		
		JTextField tfRoom = new JTextField();
		tfRoom.setText("Kitchen");
		personalize.setTfNameRM(tfRoom);
		
		personalize.addRoom();
		
		JTextField tfAddition = new JTextField();
		tfAddition.setText("Sink");
		personalize.setTextField(tfAddition);
		
		personalize.addFaucet();
		
		assertEquals("Sink", personalize.getHouse().getFloorList().get(0).getRoomList().get(0).getFaucetList().get(0).getName());
		
	}
}
