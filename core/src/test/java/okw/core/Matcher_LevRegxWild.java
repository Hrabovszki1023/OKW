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

package okw.core;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

@Tag("AllCoreTests")
public class Matcher_LevRegxWild {

	/**
	 * Passed
	 */
	@Test
	public void LevenshteinMatch_1() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zolo" );
		fpALActuell.add( "mona" );
		fpALActuell.add( "Hanno" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( true, Matcher.LevenshteinMatch( fpALActuell, fpALExpected, 1 ) );
	}

	/**
	 * Passed
	 */
	@Test
	public void LevenshteinMatch_1_1() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanna" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( true, Matcher.LevenshteinMatch( fpALActuell, fpALExpected, 1 ) );

	}
	
	/**
	 * Fail: Array-Size is OK but one String has diffs in L-distance.
	 */
	@Test
	public void LevenshteinMatch_2() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zolo" );
		fpALActuell.add( "mona" );
		fpALActuell.add( "Hanno" );

		fpALExpected.add( "ZoliI" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( false, Matcher.LevenshteinMatch( fpALActuell, fpALExpected, 1 ) );

	}
	
	/**
	 * Fail: Array-Size is OK but one String has diffs in L-distance.
	 */
	@Test
	public void LevenshteinMatch_3() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zolo" );
		fpALActuell.add( "mona" );
		fpALActuell.add( "Hanno" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( false, Matcher.LevenshteinMatch( fpALActuell, fpALExpected, 0 ) );

	}
	
	/**
	 * Fail: Array-Size is OK but one String has diffs in L-distance.
	 */
	@Test
	public void LevenshteinMatch_4() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanno" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );

		assertEquals( false, Matcher.LevenshteinMatch( fpALActuell, fpALExpected, 0 ) );

	}
	
	/**
	 * Passed
	 */
	@Test
	public void RegexMatch_1() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanna" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( true, Matcher.RegexMatch( fpALActuell, fpALExpected ) );

	}
	
	/**
	 * fail
	 */
	@Test
	public void RegexMatch_2() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( false, Matcher.RegexMatch( fpALActuell, fpALExpected ) );

	}
	
	/**
	 * fail
	 */
	@Test
	public void RegexMatch_3() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanna" );

		fpALExpected.add( ".*oli" );
		fpALExpected.add( ".*ono" );
		fpALExpected.add( ".*anna" );

		assertEquals( false, Matcher.RegexMatch( fpALActuell, fpALExpected ) );
	}
	
	/**
	 * Passed
	 */
	@Test
	public void WildcardMatch_1() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanna" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( true, Matcher.WildcardMatch(fpALActuell, fpALExpected ) );

	}
	
	/**
	 * fail
	 */
	@Test
	public void WildcardMatch_2() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );

		fpALExpected.add( "Zoli" );
		fpALExpected.add( "Mona" );
		fpALExpected.add( "Hanna" );

		assertEquals( false, Matcher.WildcardMatch( fpALActuell, fpALExpected ) );

	}
	
	/**
	 * fail
	 */
	@Test
	public void WildcardMatch_3() 
	{
		ArrayList<String> fpALActuell = new ArrayList<String>();
		ArrayList<String> fpALExpected = new ArrayList<String>();
		
		fpALActuell.add( "Zoli" );
		fpALActuell.add( "Mona" );
		fpALActuell.add( "Hanna" );

		fpALExpected.add( "Zol*" );
		fpALExpected.add( "*ono" );
		fpALExpected.add( "*anna" );

		assertEquals( false, Matcher.WildcardMatch( fpALActuell, fpALExpected ) );

	}
}
