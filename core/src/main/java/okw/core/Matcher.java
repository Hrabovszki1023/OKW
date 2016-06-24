package okw.core;

public class Matcher {
  
  public static int LevenshteinDistance(String a, String b) {
      a = a.toLowerCase();
      b = b.toLowerCase();
      // i == 0
      int [] costs = new int [b.length() + 1];
      for (int j = 0; j < costs.length; j++)
          costs[j] = j;
      for (int i = 1; i <= a.length(); i++) {
          // j == 0; nw = lev(i - 1, j)
          costs[0] = i;
          int nw = i - 1;
          for (int j = 1; j <= b.length(); j++) {
              int cj = Math.min(1 + Math.min(costs[j], costs[j - 1]), a.charAt(i - 1) == b.charAt(j - 1) ? nw : nw + 1);
              nw = costs[j];
              costs[j] = cj;
          }
      }
      return costs[b.length()];
  }
  
  public static boolean LevenshteinMatch(String fpsActuell, String fpsExpected, int fpiDistance)
  {
    Boolean lvbReturn = false;
    
    int lviDistanceActuell = LevenshteinDistance( fpsActuell, fpsExpected);
    
    
    if ( lviDistanceActuell <= fpiDistance )
    {
      lvbReturn = true;
    }
    
    return lvbReturn;
  }

  
  /**
   * @param fpsActuell Text to test
   * @param fpsExpected (Wildcard) pattern to test
   * @return True if the text matches the wildcard pattern
   */
  public static boolean WildcardMatch(String fpsActuell, String fpsExpected)
  {
    return fpsActuell.matches(fpsExpected.replace("?", ".").replace("*", ".*").replace("#", "\\d"));
  }
  
  public static boolean RegexMatch(String fpsActuell, String fpsExpectedRegex)
  {
       boolean lvb_Return = false;
      
       lvb_Return = fpsActuell.matches(fpsExpectedRegex);
      
       return lvb_Return;
  }
}