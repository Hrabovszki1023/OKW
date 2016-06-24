package okw.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Matcher_LevenshteinMatchTest {

  @Parameters(name = "{index}: LevenshteinDistance(>{0}<, >{1}< ) = >{2}<")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { 
        { "",   "",   0, true }, 
        { "",   "",   1, true },
        
        { "a",  "",   1, true },
        { "a",  "",   0, false },

        { "a",  "b",  1, true }, 
        { "",   "a",  1, true }, 
        { "",   "a",  1, true },
        { "ab", "a",  1, true }, 
        { "a",  "ab", 1, true },
        { "a",  "ab", 2, true },
        { "a",  "ab", 0, false },
        
        { "Hrabovszki", "Hrabovszki", 0, true },
        { "rabovszki", "Hrabovszki", 1, true },
        { "Hrabovszki", "rabovszki", 1, true },
        { "Hrabovzki", "Hrabovszki", 1, true },
        { "Hrabovszki", "Hrabovzki", 1, true },
        { "HraboXszki", "Hrabovszki", 1, true },
        { "Hrabovszki", "HraboXszki", 1, true } });
  }

  private String fString1;
  private String fString2;

  private int fDistanceTolerance;

  private Boolean fexpectedResult;
  
  // parameters pass via this constructor
  public Matcher_LevenshteinMatchTest(String String1, String String2,
      int DistanceTolerance, boolean expectedResult) {

    fString1 = String1;
    fString2 = String2;

    fDistanceTolerance = DistanceTolerance;
    
    fexpectedResult = expectedResult;
  }

  @Test
  public void tc_LevenshteinDistance_1() {

    assertEquals(fexpectedResult,
        Matcher.LevenshteinMatch(fString1, fString2, fDistanceTolerance));
  }

}
