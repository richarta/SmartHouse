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

	@Test
	public void test() {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Login login = new Login();
				login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		});
		
		System.out.println("Login with ID: smp, PW: pass.");
		System.out.println("Entertainment -> Floor1, Living Room -> Turn on the TV");
		System.out.println("Do it by 20s.");
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time is done. JUnit test starts");
		
		assertEquals(true,User.getHouse().getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus());
	}
}
