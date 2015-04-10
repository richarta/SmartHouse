import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LoginTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		User.setUsername("test");
		User.setPassword("abc123");
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
	public void testCorrectLogin() throws IOException{
		try{
			assertEquals(true, User.checkLogin("test", "abc123"));
		}
		catch(IOException e){
			fail("Login failed due to no file");
		}
	}

}
