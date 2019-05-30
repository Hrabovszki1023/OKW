package okw.core;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Matcher_LevRegxWild {

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
