/*
    ==============================================================================
    Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

import java.util.ArrayList;

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
   * @return True if the text matches the LevenshteinMatch pattern
   */
  public static boolean LevenshteinMatch(ArrayList<String> fpALActuell, ArrayList<String> fpALExpected, int fpiDistance)
  {
    boolean lvb_Return = true;

    Integer ActualSize = (Integer)fpALActuell.size();
    Integer ExpectedSize = (Integer)fpALExpected.size();
    
    if( ActualSize.equals( ExpectedSize ))
    {
      
      for (int i = 0; i < fpALActuell.size(); i++)
      {
        if ( ! Matcher.LevenshteinMatch(fpALActuell.get(i), fpALExpected.get(i), fpiDistance ) )
        {
          lvb_Return = false;
          break;
        }
      }
    }
    else
    {
      lvb_Return = false;
    }
    
    return lvb_Return;
  }  

  
  /**
   * @param fpsActuell Text to test
   * @param fpsExpected (Wildcard) pattern to test
   * @return True if the text matches the wildcard pattern
   */
  public static boolean WildcardMatch(String fpsActuell, String fpsExpected)
  {
    boolean lvb_Return = false;
    
    lvb_Return = fpsActuell.matches(fpsExpected.replace("?", ".").replace("*", ".*").replace("#", "\\d"));
   
    return lvb_Return;
  }

  
  /**
   * @param fpsActuell Text to test
   * @param fpsExpected (Wildcard) pattern to test
   * @return True if the text matches the wildcard pattern
   */
  public static boolean WildcardMatch(ArrayList<String> fpALActuell, ArrayList<String> fpALExpected)
  {
    boolean lvb_Return = true;

    Integer ActualSize = (Integer)fpALActuell.size();
    Integer ExpectedSize = (Integer)fpALExpected.size();
    
    if( ActualSize.equals( ExpectedSize ))
    {
      
      for (int i = 0; i < fpALActuell.size(); i++)
      {
        if ( ! Matcher.WildcardMatch(fpALActuell.get(i), fpALExpected.get(i)) )
        {
        	lvb_Return = false;
        	break;
        }
      }
    }
    else
    {
    	lvb_Return = false;
    }
    
    return lvb_Return;
  }  
  
  
  public static boolean RegexMatch(String fpsActuell, String fpsExpectedRegex)
  {
       boolean lvb_Return = false;
      
       lvb_Return = fpsActuell.matches(fpsExpectedRegex);
      
       return lvb_Return;
  }
  
  /**
   * @param fpsActuell Text to test
   * @param fpsExpected (Wildcard) pattern to test
   * @return True if the text matches the wildcard pattern
   */
  public static boolean RegexMatch(ArrayList<String> fpALActuell, ArrayList<String> fpALExpected)
  {
    boolean lvb_Return = true;

    Integer ActualSize = (Integer)fpALActuell.size();
    Integer ExpectedSize = (Integer)fpALExpected.size();
    
    if( ActualSize.equals( ExpectedSize ))
    {
      
      for (int i = 0; i < fpALActuell.size(); i++)
      {
        if ( ! Matcher.RegexMatch(fpALActuell.get(i), fpALExpected.get(i)) )
        {
        	lvb_Return = false;
        	break;
        }
      }
    }
    else
    {
    	lvb_Return = false;
    }
    
    return lvb_Return;
  }  
}