import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class CarosiJunitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass: Preparing to run unit tests...\n");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass:Exiting unit tests...\n");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp:Starting a test\n");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown:Test complete\n\n");
	}

	@Test
	public void testDoorlock() {
		Door door =new Door();
		assertEquals(door.getLock(),true);
	}

	@Test
	public void testDoorUnlock() {
		Door door =new Door();
		door.setLock(false);
		assertEquals(door.getLock(),false);
	}	
	@Test
	public void testWindowlock() {
		Window window =new Window();
		assertEquals(window.getLock(),true);
	}

	@Test
	public void testWindowUnlock() {
		Window window =new Window();
		window.setLock(false);
		assertEquals(window.getLock(),false);
	}	
	
	
}
