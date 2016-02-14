package okw;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class OKW_HandleException
{

	public static void StopRunning( Exception e, Class<?> fpClass )
	{

		final ByteArrayOutputStream stream = new ByteArrayOutputStream();
		e.printStackTrace(new PrintStream(stream));

		System.out.println("=================================================================================");
		System.out.println("= Exception during initialization of Class >>" + fpClass.getName() + "<<! Stop running!");
		System.out.println("=================================================================================");
		System.out.println(stream);

		System.exit(1);
	}
}
