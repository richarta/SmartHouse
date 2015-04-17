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


public class SecurityTest {

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
	public void turnOnTvTest() {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		System.out.println("This is a JUnit test for TV control button.\nYou need to turn on TV in Living Room on Floor 1.\n");
		System.out.println("----Direction-----------------------------------------------");
		System.out.println("Login with ID: smp, PW: pass.");
		System.out.println("Entertainment -> Floor1, Living Room -> Turn on the TV");
		System.out.println("Do it by 45s.");
		System.out.println("------------------------------------------------------------");
		
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time is done.\n");
		
		assertEquals(true,User.getHouse().getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus());
	}
	
	@Test
	public void turnOffTvTest() {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		System.out.println("This is a JUnit test for TV control button.\nYou need to turn off TV in Living Room on Floor 1.\n");
		System.out.println("----Direction-----------------------------------------------");
		System.out.println("Login with ID: smp, PW: pass.");
		System.out.println("Entertainment -> Floor1, Living Room -> Turn off the TV");
		System.out.println("Do it by 45s.");
		System.out.println("------------------------------------------------------------");
		
		try {
			Thread.sleep(45000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time is done.\n");
		
		assertEquals(false,User.getHouse().getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus());
	}
}
