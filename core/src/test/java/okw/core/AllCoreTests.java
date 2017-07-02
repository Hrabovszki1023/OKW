/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith( Suite.class )
@SuiteClasses(
{ CurrentObject_Test.class,
  EN_Keywords_ANTLR_Test.class,
  EN_Keywords_DELETE_Test.class,
  EN_Keywords_Empty_Test.class,
  EN_Keywords_IGNORE_Test.class,
  EN_Keywords_Test.class,
  EN_OKWFrameObjectChildNotFoundException_Test.class,
  EN_OKWFrameObjectMethodNotImplemented_Test.class,
  EN_OKWFrameObjectParentNotFoundException_Test.class,
  EN_OKWNotAllowedValueException_Test.class,
  EN_OKWNotAllowedValueException_Keywords_IGNORE.class,
  EN_VerifyCaption_OKWVerifyingFailsException_Test.class,
  EN_VerifyExists_OKWVerifyingFailsException_Test.class,
  EN_VerifyLabel_OKWVerifyingFailsException_Test.class,
  EN_VerifySelectedValue_OKWVerifyingFailsException_Test.class,
  EN_VerifyTablecellValue_OKWVerifyingFailsException_Test.class,
  EN_VerifyTooltip_OKWVerifyingFailsException_Test.class,
  EN_VerifyValue_OKWVerifyingFailsException_Test.class,
  FrameObjectDictionary_Test.class,
  Matcher_LevenshteinDistanceTest.class,
  Matcher_LevenshteinMatchTest.class,
  Matcher_RegexMatcherTest.class,
  Matcher_WildcardMatcherTest.class } )

/** \~german
* Test-Suite enthält alle Core-Unittest Test-Klassen.
* 
* Test-Klassen der Suite:
* 
*  - CurrentObject_Test.class,
*  - EN_Keywords_ANTLR_Test.class, 
*  - EN_Keywords_DELETE_Test.class, 
*  - EN_Keywords_Empty_Test.class,
*  - EN_Keywords_IGNORE_Test.class,
*  - EN_Keywords_Test.class,
*  - EN_OKWFrameObjectChildNotFoundException_Test.class,
*  - EN_OKWFrameObjectMethodNotFoundException_Test.class,
*  - EN_OKWFrameObjectParentNotFoundException_Test.class,
*  - EN_OKWNotAllowedValueException_Test.class,
*  - EN_VerifyCaption_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyExists_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyLabel_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyTooltip_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyValue_OKWVerifyingFailsException_Test.class,
*  - FrameObjectDictionary_Test.class,
*  - Matcher_LevenshteinDistanceTest.class,
*  - Matcher_LevenshteinMatchTest.class,
*  - Matcher_RegexMatcherTest.class,
*  - Matcher_WildcardMatcherTest.class
* 
* \~english
* Test-Suite holds following Core-Unittest TestClasses.
* 
* TestClasses of the Suite:
* 
*  - CurrentObject_Test.class,
*  - EN_Keywords_ANTLR_Test.class, 
*  - EN_Keywords_DELETE_Test.class, 
*  - EN_Keywords_Empty_Test.class,
*  - EN_Keywords_IGNORE_Test.class,
*  - EN_Keywords_Test.class,
*  - EN_OKWFrameObjectChildNotFoundException_Test.class,
*  - EN_OKWFrameObjectMethodNotFoundException_Test.class,
*  - EN_OKWFrameObjectParentNotFoundException_Test.class,
*  - EN_OKWNotAllowedValueException_Test.class,
*  - EN_VerifyCaption_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyExists_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyLabel_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyTooltip_OKWVerifyingFailsException_Test.class,
*  - EN_VerifyValue_OKWVerifyingFailsException_Test.class,
*  - FrameObjectDictionary_Test.class,
*  - Matcher_LevenshteinDistanceTest.class,
*  - Matcher_LevenshteinMatchTest.class,
*  - Matcher_RegexMatcherTest.class,
*  - Matcher_WildcardMatcherTest.class
* 
* \~
* \author Zoltán Hrabovszki
* \date 2016-10-25
 */
public class AllCoreTests
{

}
