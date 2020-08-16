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

package okw;


import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import okw.exceptions.*;
import okw.log.*;


@Tag("AllCoreHelperTests")
public class OKW_HelperTest
    {

	/// \copydoc CurrentObject::Log()
	public static Logger_Sngltn Log;

		//@BeforeAll
        public static void myTestFixtureSetUp()
        {
			Log = Logger_Sngltn.getInstance();
            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.init();

            //Log.AddLogger(new Log2Console());
            Log.setDebugMode(false);
        }

        @Test
        public void tcBoolean2String_false()
        {
            String actual = "false";
            String expected = "false";

            actual = OKW_Helper.Boolean2String(false);
            assertEquals( expected, actual);
        }

        @Test
        public void tcBoolean2String_true()
        {
            String actual = "true";
            String expected = "true";

            actual = OKW_Helper.Boolean2String(true);
            assertEquals(expected, actual);
        }

        @Test
        public void tcGetLeftFromDelimiterMultipleCharacterDelemeter() throws XPathExpressionException
        {
            assertEquals("AAAA", OKW_Helper.getLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 1));
            assertEquals("AAAAGGBBBB", OKW_Helper.getLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 2));
        }

        @Test
        public void tcGetLeftFromDelimiterNumber() throws XPathExpressionException
        {
            assertEquals("AAAA", OKW_Helper.getLeftFromDelimiterNumber("AAAACBBBB", "C", 1));
        }

        @Test
        public void tcGetLeftFromDelimiterNumber_2() throws XPathExpressionException
        {
            assertEquals("AAAACBBBB", OKW_Helper.getLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2));
        }

        @Test
        public void tcGetLeftFromDelimiterNumber_2a() throws XPathExpressionException
        {
            assertEquals("AAAA", OKW_Helper.getLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 1));
        }

        @Test
        public void tcGetLeftFromDelimiterNumber_OKWDelimiterCountOutOfRangeException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 3);
                fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("The split-position(=3) is outside of valid range [1...2]!", e.getMessage());
                //Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void tcGetLeftFromDelimiterNumber_OKWDelimiterCountOutOfRangeException_0()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0);
                fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("The split-position(=0) is outside of valid range [1...2]!", e.getMessage());
                //pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void tcGetLeftFromDelimiterNumber_OKWDelimiterIsEmptyException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "", 1);
                fail();
            }
            catch (IllegalArgumentException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("Delimiter is empty!", e.getMessage());
                ////Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void tcGetRightFromDelimiterNumber_ExceptionEmptyDelemiter()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getRightFromDelimiterNumber("AAAAGGBBBBGGDDDD", "", 1);
                fail();
            }
            catch (IllegalArgumentException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("Delimiter is empty!", e.getMessage());
                //Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void tcGetRigthFromDelimiterNumber_OKWDelimiterCountOutOfRangeException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getRightFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 3);
                fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("The split-position(=3) is outside of valid range [1...2]!", e.getMessage());
                //Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void tcGetRigthFromDelimiterNumber_OKWDelimiterCountOutOfRangeException_0()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.getRightFromDelimiterNumber( "AAAAGGBBBBGGDDDD", "GG", 0 );
                fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                assertEquals("The split-position(=0) is outside of valid range [1...2]!", e.getMessage());
                //Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei leeren ListStings.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_0_0_Wert()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// \brief
        /// Test auf den Vergleich auf Unterschied:
        /// List_1: 2 Wert - List_2 zwei Werte.
        /// 
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_10_9Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Wert_2");

            List_1.add("Wert_3");
            List_2.add("Wert_3");

            List_1.add("Wert_4");
            List_2.add("Wert_4");

            List_1.add("Wert_5");
            List_2.add("Wert_5");

            List_1.add("Wert_6");
            List_2.add("Wert_6");

            List_1.add("Wert_7");
            List_2.add("Wert_7");

            List_1.add("Wert_8");
            List_2.add("Wert_8");

            List_1.add("Wert_9");
            List_2.add("Wert_9");

            List_1.add("Wert_10");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich auf Unterschied:
        /// List_1: 1 - List_2 0 Werte.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_1_0_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert, die unterschiedlich.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_1_1_DiffWert_1()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Diff");

            Boolean expected = false;
            Boolean actual;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_1_1_Wert()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich auf Unterschied:
        /// List_1: 1 - List_2 2 Werte.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_1_2_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");

            List_2.add("Wert_1");
            List_2.add("Wert_2");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich auf Unterschied:
        /// List_1: 2 - List_2 1 Werte.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_2_1_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_1.add("Wert_2");

            List_2.add("Wert_2");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert, die unterschiedlich.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_2_2_DiffWert_2()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Diff");

            Boolean expected = false;
            Boolean actual;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_2_2_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Wert_2");

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit je drei Werten.
        /// der unterschiedlich.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void tcListStringCompare_3_3_DiffWert_2()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Diff");

            List_1.add("Wert_3");
            List_2.add("Wert_3");

            Boolean expected = false;
            Boolean actual;

            actual = OKW_Helper.compareListString(List_1, List_2);
            assertEquals(expected, actual);
        }

        @Test
        public void tcListStringConcat_With1CharacterSeparator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.concatListString(Input, "/");

            assertEquals("", actual);

            // 1-Wert
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.concatListString(Input, "/");

            assertEquals("Hase", actual);

            // 2-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.concatListString(Input, "/");

            assertEquals("Hase/Fuchs", actual);

            // 3-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.concatListString(Input, "/");

            assertEquals("Hase/Fuchs/Bär", actual);
        }

        @Test
        public void tcListStringConcat_WithMultipleCharacterSeparator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("", actual);

            // 1-Wert W
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("Hase", actual);

            // 2-Werte WW
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("Hase${SEP}Fuchs", actual);

            // 3-Werte WWW
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("Hase${SEP}Fuchs${SEP}Bär", actual);

            // 3-Werte WLW
            Input.clear();
            Input.add("Hase");
            Input.add("");
            Input.add("Bär");

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("Hase${SEP}${SEP}Bär", actual);

            // 3-Werte LWL
            Input.clear();
            Input.add("");
            Input.add("Fuchs");
            Input.add("");

            actual = OKW_Helper.concatListString(Input, "${SEP}");

            assertEquals("${SEP}Fuchs${SEP}", actual);
        }

        @Test
        public void tcListStringConcat_WithOut_Separator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.concatListString(Input, "");

            assertEquals("", actual);

            // 1-Wert
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.concatListString(Input, "");

            assertEquals("Hase", actual);

            // 2-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.concatListString(Input, "");

            assertEquals("HaseFuchs", actual);

            // 3-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.concatListString(Input, "");

            assertEquals("HaseFuchsBär", actual);
        }



        @Test
        public void tcMatchStr_SMS_CaseSensitve()
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.matchString("*Hase*", "Fux, hASE, bär");
            assertEquals(expected, actual);
        }

        @Test
        public void tcMatchStr_SM_CaseSensitve()
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.matchString("*Hase, bär", "Fux, Hase, Bär");
            assertEquals(expected, actual);
        }

        @Test
        public void tcRemoveBeginEndQuotations()
        {
            assertEquals("", OKW_Helper.removeBeginEndQuotations("\"\""));
            assertEquals("A", OKW_Helper.removeBeginEndQuotations("\"A\""));
            assertEquals("ABC", OKW_Helper.removeBeginEndQuotations("\"ABC\""));
        }

        @Test
        public void tcRemoveBeginEndQuotations_TestMethod2()
        {
            assertEquals("\"", OKW_Helper.removeBeginEndQuotations("\"\"\""));
            assertEquals("A\"", OKW_Helper.removeBeginEndQuotations("\"A\"\""));
        }

        /// \brief
        /// Prüft ob innen liegende Anführungsstriche erhalten bleiben.
        /// TF 1: keine Anführungstriche am Anfang und Ende aber in der Mitte.
        /// TF 2: Mit Anführungstriche am Anfang und Ende und in der Mitte.
        /// 
        @Test
        public void tcRemoveBeginEndQuotations_TestMethod3()
        {
            assertEquals("Fuchs \"liebt\" Hase", OKW_Helper.removeBeginEndQuotations("Fuchs \"liebt\" Hase"));
            assertEquals("Fuchs \"liebt\" Hase", OKW_Helper.removeBeginEndQuotations("\"Fuchs \"liebt\" Hase\""));
        }

        @Test
        public void tcStrArray2ListStr_1Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            String[] Input = { "Wert1" };
            
            // Keinwert
            actual = OKW_Helper.StringArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");

            assertEquals(expected, actual);
        }

        @Test
        public void tcStrArray2ListStr_2Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
        	String[] Input = new String[] { "Wert1", "Wert2" };

            // Keinwert
            actual = OKW_Helper.StringArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");
            expected.add("Wert2");

            assertEquals(expected, actual);
        }

        @Test
        public void tcStrArray2ListStr_3Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
        	String[] Input = new String[] { "Wert1", "Wert2", "Natloz" };

            // Keinwert
            actual = OKW_Helper.StringArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");
            expected.add("Wert2");
            expected.add("Natloz");

            assertEquals(expected, actual);
        }

        @Test
        public void tcStrArray2ListStr_NoValue()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
            String[] Input = { };

            // Keinwert
            actual = OKW_Helper.StringArray2ListStr(Input);

            expected.clear();

            assertEquals(expected, actual);
        }

        @Test
        public void tcString2Boolean_false() throws XPathExpressionException
        {
            Boolean actual = true;
            Boolean expected = true;

            actual = OKW_Helper.String2Boolean("true");
            assertEquals(expected, actual);
        }

        @Test
        public void tcString2Boolean_true() throws XPathExpressionException
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.String2Boolean("false");
            assertEquals(expected, actual);
        }

        @Test
        public void tcString2Boolean_false_lower() throws XPathExpressionException
        {
            Boolean actual = true;
            Boolean expected = false;

            actual = OKW_Helper.String2Boolean("False");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("FALSE");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("falsE");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("FaLsE");
            assertEquals(expected, actual);
        }

        @Test
        public void tcString2Boolean_true_lower() throws XPathExpressionException
        {
            Boolean actual = false;
            Boolean expected = true;

            actual = OKW_Helper.String2Boolean("True");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("TRUE");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("truE");
            assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("TruE");
            assertEquals(expected, actual);
        }

        @Test
        public void tcString2Boolean_true_OKWNotAllowedValueException()
        {
            try
            {
                OKW_Helper.String2Boolean("Uschi");
                fail();
            }
            catch (OKWNotAllowedValueException e)
            {
                OKWLanguage.getInstance().setLanguage("en");
                // Richtige Exception wurde ausgeloest daher Pass!
                
                String Expected = "Value 'Uschi' is not allowd here! Valid values are: 'true' or 'false'";
                String Actual = e.getMessage();
                
                assertEquals(Expected, Actual);
            }
            catch (Exception e)
            {
            	Log.LogPrint("Exception nicht erwartet: '" + e.getMessage() + "'");
                fail();
            }
        }

        @Test
        public void tcStrSplit()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            // Keinwert
            actual = OKW_Helper.splitString("", "/");
            expected.clear();
            expected.add("");

            assertEquals(expected, actual);

            // 1
            actual = OKW_Helper.splitString("Root", "/");

            expected.clear();
            expected.add("Root");

            assertEquals(expected, actual);

            // 1t
            actual = OKW_Helper.splitString("Root/", "/");

            expected.clear();
            expected.add("Root");
            expected.add("");
            assertEquals(expected, actual);

            // t1
            actual = OKW_Helper.splitString("/SubDir_1", "/");

            expected.clear();
            expected.add("");
            expected.add("SubDir_1");

            assertEquals(expected, actual);

            // 1t1
            actual = OKW_Helper.splitString("Root/SubDir_1", "/");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");

            assertEquals(expected, actual);

            // 1tt1
            actual = OKW_Helper.splitString("Root//Datei", "/");

            expected.clear();
            expected.add("Root");
            expected.add("");
            expected.add("Datei");

            assertEquals(expected, actual);

            // 1t1t1t1
            actual = OKW_Helper.splitString("Root/SubDir_1/SubDir_2/Datei", "/");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");
            expected.add("SubDir_2");
            expected.add("Datei");

            assertEquals(expected, actual);
        }

        @Test
        public void tcStrSplit_Wert()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            // Keinwert
            actual = OKW_Helper.splitString("", "${WERT}");
            expected.clear();
            expected.add("");

            assertEquals(expected, actual);

            // 1
            actual = OKW_Helper.splitString("Root", "{WERT}");

            expected.clear();
            expected.add("Root");

            assertEquals(expected, actual);

            // 1t
            actual = OKW_Helper.splitString("Root${WERT}", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("");
            assertEquals(expected, actual);

            // t1
            actual = OKW_Helper.splitString("${WERT}SubDir_1", "${WERT}");

            expected.clear();
            expected.add("");
            expected.add("SubDir_1");

            assertEquals(expected, actual);

            // 1t1
            actual = OKW_Helper.splitString("Root${WERT}SubDir_1", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");

            assertEquals(expected, actual);

            // 1tt1
            actual = OKW_Helper.splitString("Root${WERT}${WERT}Datei", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("");
            expected.add("Datei");

            assertEquals(expected, actual);

            // 1t1t1t1
            actual = OKW_Helper.splitString("Root${WERT}SubDir_1${WERT}SubDir_2${WERT}Datei", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");
            expected.add("SubDir_2");
            expected.add("Datei");

            assertEquals(expected, actual);
        }

    }