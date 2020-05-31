package okw;

import java.util.Collection;
import java.util.regex.Pattern;

import org.junit.jupiter.api.*;

@Tag("AllCoreHelperTests")
public class ResourceList_Test {

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
