import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class struttJunit {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before Class has ran");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After Class has ran");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Test Begins");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test Ends");
	}

	/**Test
	 * This will open a created house and test that the user inputed boolean equals the expected boolean for a light
	 */
	@Test
	public void test() {
		User.openHouseStatus("shane");
		assertEquals(false,User.getHouse().getFloorList().get(0).getRoomList().get(0).getLightList().get(0).getStatus());
	}
	
	/**Test1
	 * This will open a created house and test that the user inputed boolean equals the expected boolean for a faucet
	 */
	@Test
	public void test1() {
		User.openHouseStatus("shane");
		assertEquals(true,User.getHouse().getFloorList().get(0).getRoomList().get(0).getFaucetList().get(0).getStatus());
	}
	

}
