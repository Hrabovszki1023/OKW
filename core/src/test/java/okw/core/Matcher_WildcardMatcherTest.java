package okw.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Matcher_WildcardMatcherTest {

  @Parameters(name = "{index}: WildCardMatch(\"{0}\", \"{1}\" ) = >{2}<")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { 
        { "", "", true },
        { "", "*", true },
        { "", "?", false },
        { "", "#", false },
        { "", "a", false }, 
        { "", "abcde", false },
        
        { "a", "a", true },
        { "a", "*", true },
        { "a", "*a", true },
        { "a", "a*", true },
        { "a", "?", true },
        { "a", "?a", false },
        { "a", "a?", false },
        { "a", "#", false },

        { "a", "b", false },
        { "a", "1", false },
        { "a", "", false },
        { "a", "b", false }, 
        { "a", "ab", false },
        { "a", "??", false },
        
        { "1", "a", false },
        { "2", "*", true },
        { "3", "?", true },
        { "4", "#", true },
        
        { "a", "b", false },
        { "a", "1", false },
        { "a", "", false },
        { "a", "b", false }, 
        { "a", "ab", false },
        
        { "ab", "a", false },
        { "ab", "a*", true },
        { "ab", "*a*", true },
        { "ab", "ab*", true },
        { "ab", "a*b", true },
        { "ab", "a*b*", true },
        { "ab", "*a*b", true },
        { "ab", "*a*b*", true },

        
        { "ab", "a?", true },
        { "ab", "?b", true },
        { "ab", "*a?", true },
        { "ab", "?b*", true },

        { "ab", "a#", false },
        { "ab", "#b", false },

        { "ab", "a??", false },
        { "ab", "??b", false },
        { "ab", "?b?", false },
        { "ab", "*a??", false },
        { "ab", "??b*", false },

        { "12", "##", true },
        { "a12", "a##", true },
        { "a12", "?##", true },
        { "a12", "*##", true },
        { "12b", "##b", true },
        { "12b", "##?", true },
        { "12b", "##*", true },

        { "10:20", "10:##", true },
        { "12:20", "##:20", true },
        { "12:20", "##:##", true },
        
        { "Hrabovszki", "Hrabovszki", true },
        
        { "rabovszki", "?rabovszki", false },
        { "Hrabovszki", "*rabovszki", true },
        { "Hrabovzki", "Hrabovszki", false },
        { "Hrabovszki", "Hrabovzki", false },
        { "HraboXszki", "Hrabovszki", false },
        { "Hrabovszki", "HraboXszki", false } });
  }

  private String fString1;
  private String fString2;

  private boolean fexpected;

  // parameters pass via this constructor
  public Matcher_WildcardMatcherTest(String String1, String String2,
      boolean expected) {

    fString1 = String1;
    fString2 = String2;

    fexpected = expected;
  }

  @Test
  public void tc_LevenshteinDistance_1() {

    assertEquals(fexpected,
        Matcher.WildcardMatch(fString1, fString2));

  }

}
