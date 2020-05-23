package okw;

import static org.junit.Assert.*;
import org.junit.Test;

public class OKW_TimeOut_Test {

	@Test
	public final void tc_Konstruktor()

	{

		OKW_TimeOut myUschi = new OKW_TimeOut(1, 500);

		// TO ist 1 Sec
		assertEquals((Integer) 1, myUschi.getTO());

		// PT ist 500ms
		assertEquals((Integer) 500, myUschi.getPT());

		// Anzahl der MaxZyklen ist 2
		assertEquals((Integer) 2, myUschi.getMaxCount());

	}

	@Test
	public final void tc_Konstruktor_1()

	{

		OKW_TimeOut myUschi = new OKW_TimeOut(1, 1000);

		// TO ist 1 Sec
		assertEquals((Integer) 1, myUschi.getTO());

		// PT ist 500ms
		assertEquals((Integer) 1000, myUschi.getPT());

		// Anzahl der MaxZyklen ist 2
		assertEquals((Integer) 1, myUschi.getMaxCount());

	}

	@Test
	public final void tc_Konstruktor_3()

	{

		OKW_TimeOut myUschi = new OKW_TimeOut(1, 1100);

		// TO ist 1 Sec
		assertEquals((Integer) 1, myUschi.getTO());

		// PT ist 500ms
		assertEquals((Integer) 1100, myUschi.getPT());

		// Anzahl der MaxZyklen ist 2
		assertEquals((Integer) 0, myUschi.getMaxCount());

	}

	@Test
	public final void tc_setTO()

	{

		OKW_TimeOut myUschi = new OKW_TimeOut(1, 500);

		assertEquals((Integer) 1, myUschi.getTO());
		assertEquals((Integer) 500, myUschi.getPT());
		assertEquals((Integer) 2, myUschi.getMaxCount());

		myUschi.setTO(2);

		assertEquals((Integer) 2, myUschi.getTO());
		assertEquals((Integer) 500, myUschi.getPT());
		assertEquals((Integer) 4, myUschi.getMaxCount());

	}

	@Test
	public final void tc_setPT()
	{

		OKW_TimeOut myUschi = new OKW_TimeOut(2, 500);

		assertEquals((Integer) 2, myUschi.getTO());
		assertEquals((Integer) 500, myUschi.getPT());
		assertEquals((Integer) 4, myUschi.getMaxCount());

		myUschi.setPT(1000);
		
		assertEquals((Integer) 2, myUschi.getTO());
		assertEquals((Integer) 1000, myUschi.getPT());
		assertEquals((Integer) 2, myUschi.getMaxCount());

	}

	@Test
	public final void tc_toString()

	{
		OKW_TimeOut myUschi = new OKW_TimeOut(1, 500);
		assertEquals("PT: 500ms, TO: 1s", myUschi.toString());

		myUschi = new OKW_TimeOut(1, 1000);
		assertEquals("PT: 1000ms, TO: 1s", myUschi.toString());

		myUschi = new OKW_TimeOut(1, 2000);
		assertEquals("PT: 2000ms, TO: 1s", myUschi.toString());

	}
}