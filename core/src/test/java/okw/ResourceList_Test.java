package okw;

import java.util.Collection;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ResourceList_Test {

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
		
			Pattern pattern = Pattern.compile(".*okw.*properties.*.properties");

		    final Collection<String> list = ResourceList.getResources(pattern);
			for (final String name : list)
			{
				System.out.println(name);
			}
		}
}
