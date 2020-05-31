/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
@Tag("AllCoreTests")
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
