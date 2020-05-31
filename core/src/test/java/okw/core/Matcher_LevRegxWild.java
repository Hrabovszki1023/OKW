package okw.core;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
