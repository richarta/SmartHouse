import static org.junit.Assert.*; 
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author YoungJin Park
 *
 */
public class parkJUnitTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass: Preparing to run unit tests...\n");
	
		User.setUsername("smp");
		User.openHouseStatus();
		
		new Entertainment();
		
		System.out.println("Select menu from menu bar in upper side of window; Floor1 -> Living Room");
		System.out.println("Do it by 15s\n");
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		System.out.println("This is a JUnit test for TV control button.\nYou need to turn 'ON' TV in Living Room on Floor 1.\n");
		System.out.println("Do it by 10s.");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time is done.\n");
		assertEquals(true,User.getHouse().getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus());
	}
	
	@Test
	public void turnOffTvTest() {
		System.out.println("This is a JUnit test for TV control button.\nYou need to turn 'OFF' TV in Living Room on Floor 1.\n");
		System.out.println("Do it by 10s.");
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Time is done.\n");
		assertEquals(false,User.getHouse().getFloorList().get(0).getRoomList().get(2).getTelevisionList().get(0).getStatus());
	}
}
