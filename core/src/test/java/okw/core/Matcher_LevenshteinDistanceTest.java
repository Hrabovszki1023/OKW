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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


@Tag("AllCoreTests")
public class Matcher_LevenshteinDistanceTest {

  @ParameterizedTest
  @CsvSource( value = { " '', '', 0 ",
      " 'a', '', 1 ",
      " 'a', 'b', 1 ",
      " '', 'a', 1 ",
      " '', 'a', 1 ",
      " 'ab', 'a', 1 ",
      " 'a', 'ab', 1 ",
      " 'Hrabovszki', 'Hrabovszki', 0 ",
      " 'rabovszki', 'Hrabovszki', 1 ",
      " 'Hrabovszki', 'rabovszki', 1 ",
      " 'Hrabovzki', 'Hrabovszki', 1 ",
      " 'Hrabovszki', 'Hrabovzki', 1 ",
      " 'HraboXszki', 'Hrabovszki', 1 ",
  " 'Hrabovszki', 'HraboXszki', 1 " })
  public void tc_LevenshteinDistance_1( String String1, String String2, int expectedDistance )
  {
    assertEquals( expectedDistance, Matcher.LevenshteinDistance(String1, String2));
  }
}
