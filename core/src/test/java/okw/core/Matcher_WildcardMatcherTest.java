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
public class Matcher_WildcardMatcherTest {

    @ParameterizedTest
    @CsvSource( value =  {
       " '', '', true ",
        " '', '*', true ",
        " '', '?', false ",
        " '', '#', false ",
        " '', 'a', false ", 
        " '', 'abcde', false ",
        " 'a', 'a', true ",
        " 'a', '*', true ",
        " 'a', '*a', true ",
        " 'a', 'a*', true ",
        " 'a', '?', true ",
        " 'a', '?a', false ",
        " 'a', 'a?', false ",
        " 'a', '#', false ",
        " 'a', 'b', false ",
        " 'a', '1', false ",
        " 'a', '', false ",
        " 'a', 'b', false ", 
        " 'a', 'ab', false ",
        " 'a', '??', false ",
        " '1', 'a', false ",
        " '2', '*', true ",
        " '3', '?', true ",
        " '4', '#', true ",
        " 'a', 'b', false ",
        " 'a', '1', false ",
        " 'a', '', false ",
        " 'a', 'b', false ", 
        " 'a', 'ab', false ",
        " 'ab', 'a', false ",
        " 'ab', 'a*', true ",
        " 'ab', '*a*', true ",
        " 'ab', 'ab*', true ",
        " 'ab', 'a*b', true ",
        " 'ab', 'a*b*', true ",
        " 'ab', '*a*b', true ",
        " 'ab', '*a*b*', true ",
        " 'ab', 'a?', true ",
        " 'ab', '?b', true ",
        " 'ab', '*a?', true ",
        " 'ab', '?b*', true ",
        " 'ab', 'a#', false ",
        " 'ab', '#b', false ",
        " 'ab', 'a??', false ",
        " 'ab', '??b', false ",
        " 'ab', '?b?', false ",
        " 'ab', '*a??', false ",
        " 'ab', '??b*', false ",
        " '12', '##', true ",
        " 'a12', 'a##', true ",
        " 'a12', '?##', true ",
        " 'a12', '*##', true ",
        " '12b', '##b', true ",
        " '12b', '##?', true ",
        " '12b', '##*', true ",
        " '10:20', '10:##', true ",
        " '12:20', '##:20', true ",
        " '12:20', '##:##', true ",
        " 'Hrabovszki', 'Hrabovszki', true ",
        " 'rabovszki', '?rabovszki', false ",
        " 'Hrabovszki', '*rabovszki', true ",
        " 'Hrabovzki', 'Hrabovszki', false ",
        " 'Hrabovszki', 'Hrabovzki', false ",
        " 'HraboXszki', 'Hrabovszki', false ",
        " 'Hrabovszki', 'HraboXszki', false "} )
  public void tc_WildcardMatch( String String1,
                  String String2,
                  boolean expected )
  {
    assertEquals( expected, Matcher.WildcardMatch( String1, String2 ));
  }
}
