/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

import org.junit.*;
import static org.junit.Assert.*;

import okw.exceptions.*;
import okw.log.*;


public class OKW_HelperTest
    {

	/// \copydoc CurrentObject::Log()
	public static Logger_Sngltn Log;

		//@BeforeClass
        public static void myTestFixtureSetUp()
        {
			Log = Logger_Sngltn.getInstance();
            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.Init();

            //Log.AddLogger(new Log2Console());
            Log.setDebugMode(false);
        }

        @Test
        public void TC_Boolean2String_false()
        {
            String actual = "false";
            String expected = "false";

            actual = OKW_Helper.Boolean2String(false);
            assertEquals( expected, actual);
        }

        @Test
        public void TC_Boolean2String_true()
        {
            String actual = "true";
            String expected = "true";

            actual = OKW_Helper.Boolean2String(true);
            assertEquals(expected, actual);
        }

        @Test
        public void TC_GetLeftFromDelimiterMultipleCharacterDelemeter() throws XPathExpressionException
        {
            assertEquals("AAAA", OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 1));
            assertEquals("AAAAGGBBBB", OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 2));
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber() throws XPathExpressionException
        {
            Assert.assertEquals("AAAA", OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "C", 1));
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber_2() throws XPathExpressionException
        {
            assertEquals("AAAACBBBB", OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2));
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber_2a() throws XPathExpressionException
        {
            assertEquals("AAAA", OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 1));
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber_OKWDelimiterCountOutOfRangeException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 3);
                Assert.fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("The split-position(=3) is outside of valid range [1...2]!", e.getMessage());
                //Assert.Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                fail();
            }
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber_OKWDelimiterCountOutOfRangeException_0()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0);
                Assert.fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("The split-position(=0) is outside of valid range [1...2]!", e.getMessage());
                //Assert.pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                Assert.fail();
            }
        }

        @Test
        public void TC_GetLeftFromDelimiterNumber_OKWDelimiterIsEmptyException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "", 1);
                Assert.fail();
            }
            catch (IllegalArgumentException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("Delimiter is empty!", e.getMessage());
                ////Assert.Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                Assert.fail();
            }
        }

        @Test
        public void TC_GetRightFromDelimiterNumber_ExceptionEmptyDelemiter()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD", "", 1);
                Assert.fail();
            }
            catch (IllegalArgumentException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("Delimiter is empty!", e.getMessage());
                //Assert.Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                Assert.fail();
            }
        }

        @Test
        public void TC_GetRigthFromDelimiterNumber_OKWDelimiterCountOutOfRangeException()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 3);
                Assert.fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("The split-position(=3) is outside of valid range [1...2]!", e.getMessage());
                //Assert.Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                Assert.fail();
            }
        }

        @Test
        public void TC_GetRigthFromDelimiterNumber_OKWDelimiterCountOutOfRangeException_0()
        {
            try
            {
                OKWLanguage.getInstance().setLanguage("en");
                OKW_Helper.GetRigthFromDelimiterNumber( "AAAAGGBBBBGGDDDD", "GG", 0 );
                Assert.fail();
            }
            catch (IndexOutOfBoundsException e)
            {
                // Richtige Exception wurde ausgeloest daher Pass!
                Assert.assertEquals("The split-position(=0) is outside of valid range [1...2]!", e.getMessage());
                //Assert.Pass();
            }
            catch (Exception e)
            {
                // Alle anderen Exvceptions sind Fail!
                Assert.fail();
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
        public void TC_ListStringCompare_0_0_Wert()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
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
        public void TC_ListStringCompare_10_9Werte()
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

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
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
        public void TC_ListStringCompare_1_0_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert, die unterschiedlich.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void TC_ListStringCompare_1_1_DiffWert_1()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Diff");

            Boolean expected = false;
            Boolean actual;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void TC_ListStringCompare_1_1_Wert()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
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
        public void TC_ListStringCompare_1_2_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");

            List_2.add("Wert_1");
            List_2.add("Wert_2");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
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
        public void TC_ListStringCompare_2_1_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_1.add("Wert_2");

            List_2.add("Wert_2");

            Boolean expected = false;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert, die unterschiedlich.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void TC_ListStringCompare_2_2_DiffWert_2()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Diff");

            Boolean expected = false;
            Boolean actual;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
        }

        /// \~german
        /// \brief
        /// Test auf den Vergleich von zwei ListStings mit einem Wert.
        /// 
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.15.11
        @Test
        public void TC_ListStringCompare_2_2_Werte()
        {
        	ArrayList<String> List_1 = new ArrayList<String>();
        	ArrayList<String> List_2 = new ArrayList<String>();

            List_1.add("Wert_1");
            List_2.add("Wert_1");

            List_1.add("Wert_2");
            List_2.add("Wert_2");

            Boolean expected = true;
            Boolean actual = true;

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
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
        public void TC_ListStringCompare_3_3_DiffWert_2()
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

            actual = OKW_Helper.ListStringCompare(List_1, List_2);
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_ListStringConcat_With1CharacterSeparator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.ListStringConcat(Input, "/");

            Assert.assertEquals("", actual);

            // 1-Wert
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.ListStringConcat(Input, "/");

            Assert.assertEquals("Hase", actual);

            // 2-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.ListStringConcat(Input, "/");

            Assert.assertEquals("Hase/Fuchs", actual);

            // 3-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.ListStringConcat(Input, "/");

            Assert.assertEquals("Hase/Fuchs/Bär", actual);
        }

        @Test
        public void TC_ListStringConcat_WithMultipleCharacterSeparator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("", actual);

            // 1-Wert W
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("Hase", actual);

            // 2-Werte WW
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("Hase${SEP}Fuchs", actual);

            // 3-Werte WWW
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("Hase${SEP}Fuchs${SEP}Bär", actual);

            // 3-Werte WLW
            Input.clear();
            Input.add("Hase");
            Input.add("");
            Input.add("Bär");

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("Hase${SEP}${SEP}Bär", actual);

            // 3-Werte LWL
            Input.clear();
            Input.add("");
            Input.add("Fuchs");
            Input.add("");

            actual = OKW_Helper.ListStringConcat(Input, "${SEP}");

            Assert.assertEquals("${SEP}Fuchs${SEP}", actual);
        }

        @Test
        public void TC_ListStringConcat_WithOut_Separator()
        {
            String actual   = "";

            ArrayList<String> Input = new ArrayList<String>();

            // Keinwert
            Input.clear();

            actual = OKW_Helper.ListStringConcat(Input, "");

            Assert.assertEquals("", actual);

            // 1-Wert
            Input.clear();
            Input.add("Hase");

            actual = OKW_Helper.ListStringConcat(Input, "");

            Assert.assertEquals("Hase", actual);

            // 2-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");

            actual = OKW_Helper.ListStringConcat(Input, "");

            Assert.assertEquals("HaseFuchs", actual);

            // 3-Werte
            Input.clear();
            Input.add("Hase");
            Input.add("Fuchs");
            Input.add("Bär");

            actual = OKW_Helper.ListStringConcat(Input, "");

            assertEquals("HaseFuchsBär", actual);
        }



        @Test
        public void TC_MatchStr_SMS_CaseSensitve()
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.MatchStr("*Hase*", "Fux, hASE, bär");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_MatchStr_SM_CaseSensitve()
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.MatchStr("*Hase, bär", "Fux, Hase, Bär");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_RemoveBeginEndQuotations()
        {
            Assert.assertEquals("", OKW_Helper.RemoveBeginEndQuotations("\"\""));
            Assert.assertEquals("A", OKW_Helper.RemoveBeginEndQuotations("\"A\""));
            Assert.assertEquals("ABC", OKW_Helper.RemoveBeginEndQuotations("\"ABC\""));
        }

        @Test
        public void TC_RemoveBeginEndQuotations_TestMethod2()
        {
            Assert.assertEquals("\"", OKW_Helper.RemoveBeginEndQuotations("\"\"\""));
            Assert.assertEquals("A\"", OKW_Helper.RemoveBeginEndQuotations("\"A\"\""));
        }

        /// \brief
        /// Prüft ob innen liegende Anführungsstriche erhalten bleiben.
        /// TF 1: keine Anführungstriche am Anfang und Ende aber in der Mitte.
        /// TF 2: Mit Anführungstriche am Anfang und Ende und in der Mitte.
        /// 
        @Test
        public void TC_RemoveBeginEndQuotations_TestMethod3()
        {
            Assert.assertEquals("Fuchs \"liebt\" Hase", OKW_Helper.RemoveBeginEndQuotations("Fuchs \"liebt\" Hase"));
            Assert.assertEquals("Fuchs \"liebt\" Hase", OKW_Helper.RemoveBeginEndQuotations("\"Fuchs \"liebt\" Hase\""));
        }

        @Test
        public void TC_StrArray2ListStr_1Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            String[] Input = { "Wert1" };
            
            // Keinwert
            actual = OKW_Helper.StrArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_StrArray2ListStr_2Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
        	String[] Input = new String[] { "Wert1", "Wert2" };

            // Keinwert
            actual = OKW_Helper.StrArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");
            expected.add("Wert2");

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_StrArray2ListStr_3Value()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
        	String[] Input = new String[] { "Wert1", "Wert2", "Natloz" };

            // Keinwert
            actual = OKW_Helper.StrArray2ListStr(Input);

            expected.clear();
            expected.add("Wert1");
            expected.add("Wert2");
            expected.add("Natloz");

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_StrArray2ListStr_NoValue()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();
            String[] Input = { };

            // Keinwert
            actual = OKW_Helper.StrArray2ListStr(Input);

            expected.clear();

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_String2Boolean_false() throws XPathExpressionException
        {
            Boolean actual = true;
            Boolean expected = true;

            actual = OKW_Helper.String2Boolean("true");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_String2Boolean_true() throws XPathExpressionException
        {
            Boolean actual = false;
            Boolean expected = false;

            actual = OKW_Helper.String2Boolean("false");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_String2Boolean_false_lower() throws XPathExpressionException
        {
            Boolean actual = true;
            Boolean expected = false;

            actual = OKW_Helper.String2Boolean("False");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("FALSE");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("falsE");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("FaLsE");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_String2Boolean_true_lower() throws XPathExpressionException
        {
            Boolean actual = false;
            Boolean expected = true;

            actual = OKW_Helper.String2Boolean("True");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("TRUE");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("truE");
            Assert.assertEquals(expected, actual);

            actual = OKW_Helper.String2Boolean("TruE");
            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_String2Boolean_true_OKWNotAllowedValueException()
        {
            try
            {
                OKW_Helper.String2Boolean("Uschi");
                Assert.fail();
            }
            catch (OKWNotAllowedValueException e)
            {
                OKWLanguage.getInstance().setLanguage("en");
                // Richtige Exception wurde ausgeloest daher Pass!
                
                String Expected = "Value 'Uschi' is not allowd here! Valid values are: 'true' or 'false'";
                String Actual = e.getMessage();
                
                Assert.assertEquals(Expected, Actual);
            }
            catch (Exception e)
            {
            	Log.LogPrint("Exception nicht erwartet: '" + e.getMessage() + "'");
                Assert.fail();
            }
        }

        @Test
        public void TC_StrSplit()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            // Keinwert
            actual = OKW_Helper.StrSplit("", "/");
            expected.clear();
            expected.add("");

            Assert.assertEquals(expected, actual);

            // 1
            actual = OKW_Helper.StrSplit("Root", "/");

            expected.clear();
            expected.add("Root");

            Assert.assertEquals(expected, actual);

            // 1t
            actual = OKW_Helper.StrSplit("Root/", "/");

            expected.clear();
            expected.add("Root");
            expected.add("");
            Assert.assertEquals(expected, actual);

            // t1
            actual = OKW_Helper.StrSplit("/SubDir_1", "/");

            expected.clear();
            expected.add("");
            expected.add("SubDir_1");

            Assert.assertEquals(expected, actual);

            // 1t1
            actual = OKW_Helper.StrSplit("Root/SubDir_1", "/");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");

            Assert.assertEquals(expected, actual);

            // 1tt1
            actual = OKW_Helper.StrSplit("Root//Datei", "/");

            expected.clear();
            expected.add("Root");
            expected.add("");
            expected.add("Datei");

            Assert.assertEquals(expected, actual);

            // 1t1t1t1
            actual = OKW_Helper.StrSplit("Root/SubDir_1/SubDir_2/Datei", "/");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");
            expected.add("SubDir_2");
            expected.add("Datei");

            Assert.assertEquals(expected, actual);
        }

        @Test
        public void TC_StrSplit_Wert()
        {
        	ArrayList<String> actual = new ArrayList<String>();
        	ArrayList<String> expected = new ArrayList<String>();

            // Keinwert
            actual = OKW_Helper.StrSplit("", "${WERT}");
            expected.clear();
            expected.add("");

            Assert.assertEquals(expected, actual);

            // 1
            actual = OKW_Helper.StrSplit("Root", "{WERT}");

            expected.clear();
            expected.add("Root");

            Assert.assertEquals(expected, actual);

            // 1t
            actual = OKW_Helper.StrSplit("Root${WERT}", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("");
            Assert.assertEquals(expected, actual);

            // t1
            actual = OKW_Helper.StrSplit("${WERT}SubDir_1", "${WERT}");

            expected.clear();
            expected.add("");
            expected.add("SubDir_1");

            Assert.assertEquals(expected, actual);

            // 1t1
            actual = OKW_Helper.StrSplit("Root${WERT}SubDir_1", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");

            Assert.assertEquals(expected, actual);

            // 1tt1
            actual = OKW_Helper.StrSplit("Root${WERT}${WERT}Datei", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("");
            expected.add("Datei");

            Assert.assertEquals(expected, actual);

            // 1t1t1t1
            actual = OKW_Helper.StrSplit("Root${WERT}SubDir_1${WERT}SubDir_2${WERT}Datei", "${WERT}");

            expected.clear();
            expected.add("Root");
            expected.add("SubDir_1");
            expected.add("SubDir_2");
            expected.add("Datei");

            Assert.assertEquals(expected, actual);
        }

    }