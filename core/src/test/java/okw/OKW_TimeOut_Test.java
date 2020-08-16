/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2020, IT-Beratung Hrabovszki
  www.OpenKeyWord.de
============================================================================== 

This file is part of OpenKeyWord.

OpenKeyWord is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

OpenKeyWord is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with OpenKeyWord.  If not, see <http://www.gnu.org/licenses/>.

Diese Datei ist Teil von OpenKeyWord.

OpenKeyWord ist Freie Software: Sie können es unter den Bedingungen
der GNU General Public License, wie von der Free Software Foundation,
Version 3 der Lizenz oder (nach Ihrer Wahl) jeder späteren
veröffentlichten Version, weiterverbreiten und/oder modifizieren.

OpenKeyWord wird in der Hoffnung, dass es nützlich sein wird, aber
OHNE JEDE GEWÄHRLEISTUNG, bereitgestellt; sogar ohne die implizite
Gewährleistung der MARKTFÄHIGKEIT oder EIGNUNG FÜR EINEN BESTIMMTEN ZWECK.
Siehe die GNU General Public License für weitere Details.

Sie sollten eine Kopie der GNU General Public License zusammen mit 
OpenKeyWord erhalten haben. Wenn nicht, siehe <http://www.gnu.org/licenses/>.
*/

package okw;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@Tag("AllCoreHelperTests")
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