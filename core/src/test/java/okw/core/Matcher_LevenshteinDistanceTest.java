package okw.core;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Matcher_LevenshteinDistanceTest {

  @Parameters(name = "{index}: LevenshteinDistance(>{0}<, >{1}< ) = >{2}<")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][] { { "", "", 0 }, { "a", "", 1 },
        { "a", "b", 1 }, { "", "a", 1 }, { "", "a", 1 },
        { "ab", "a", 1 }, { "a", "ab", 1 },

        { "Hrabovszki", "Hrabovszki", 0 },
        { "rabovszki", "Hrabovszki", 1 },
        { "Hrabovszki", "rabovszki", 1 },
        { "Hrabovzki", "Hrabovszki", 1 },
        { "Hrabovszki", "Hrabovzki", 1 },
        { "HraboXszki", "Hrabovszki", 1 },
        { "Hrabovszki", "HraboXszki", 1 } });
  }

  private String fString1;
  private String fString2;

  private int fexpectedDistance;

  // parameters pass via this constructor
  public Matcher_LevenshteinDistanceTest(String String1, String String2,
      int expectedDistance) {

    fString1 = String1;
    fString2 = String2;

    fexpectedDistance = expectedDistance;
  }

  @Test
  public void tc_LevenshteinDistance_1() {

    assertEquals(fexpectedDistance,
        Matcher.LevenshteinDistance(fString1, fString2));

  }

}
