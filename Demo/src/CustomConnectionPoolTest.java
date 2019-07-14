import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.connectionpool.CustomConnectionPool;
import com.connectionpool.CustomConnectionPoolImpl;

/**
 * 
 */

/**
 * @author Hitesh
 *
 */
public class CustomConnectionPoolTest {

	private int INIT = 2;
	CustomConnectionPool pool;
	@Before
	public void setUp() throws Exception {
		System.out.println("Setup");
		pool = new CustomConnectionPoolImpl("org.hsqldb.jdbcDriver", "jdbc:hsqldb:mem:testdb", "hitesh", "123", INIT, 6);
	}

	@After
	public void tearDown() throws Exception {
		pool = null;
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNullDriver() throws SQLException {
		pool = new CustomConnectionPoolImpl(null, "localhost", "hitesh", "123", 2, 6);
	}

	@Test
	public void testPoolInit(){
		Assert.assertTrue("inital pool size", INIT == pool.getNumberOfAvailableConnections());
	}
	@Test
	public void testGetConnection() {
		fail("Not yet implemented");
	}

}
