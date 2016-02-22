package okw;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

import org.junit.Test;
import org.xml.sax.SAXException;

public class OKW_ConstTest {

	public class OKW_Const_Test_ {

		OKW_Const_Sngltn myOKW_Const;

		// / \copydoc CurrentObject::Log()
		private Logger_Sngltn Log = Logger_Sngltn.getInstance();

		// [TestFixtureSetUp]
		public void MySetUp() {

			try {
				myOKW_Const = OKW_Const_Sngltn.getInstance();
			} catch (XPathExpressionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JAXBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Reset des Loggers: Alle geladenen Instanzen löschen
			Log.Init();

			// Logger.Instance.AddLogger(new Log2Console());
			Log.setDebugMode(true);
		}

		@Test
		public void GetOKWConst_HSEP() {
			String actual = "";

			OKWLanguage.getInstance().setLanguage("en");

			try {
				actual = myOKW_Const.GetOKWConst4Internalname("HSEP");
			} catch (XPathExpressionException e) {
				fail(e.getMessage());
			}

			assertEquals("${HSEP}", actual);
		}

		@Test
		public void GetOKWConst_SEP() {
			String actual = "";

			OKWLanguage.getInstance().setLanguage("en");

			try {
				actual = myOKW_Const.GetOKWConst4Internalname("SEP");
			} catch (XPathExpressionException e) {
				fail(e.getMessage());
			}
			assertEquals("${SEP}", actual);
		}

		@Test
		public void GetOKWConst_VSEP() {
			String actual = "";

			try {
				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.GetOKWConst4Internalname("VSEP");
			} catch (XPathExpressionException e) {
				fail(e.getMessage());
			}

			assertEquals("${VSEP}", actual);
		}

		// / \brief
		// / Prüft ob die Exception "OKWConst4InternalnameNotFoundException"
		// ausgelöst wird,
		// / wenn ein nicht vorhandener Internalname verwendet wird.<br/>
		// / Sprache "EN"
		// /
		@Test
		public void TCE_GetConst4Internalname_OKWConst4InternalnameNotFoundException_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");

			try {
				actuel = myOKW_Const.GetConst4Internalname("NotExist");

				fail("Exception wurde nicht ausgelöst, daher ein Fehler!");
			} catch (OKWConst4InternalnameNotFoundException e) {
				Log.LogPrint("Erwarteter Exception wurde ausgelöst");
			} catch (Exception e) {
				fail("Fehler, weil nicht die erwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft, ob der sprachabhängige Hinweis zu der Exception
		// "OKWConst4InternalnameNotFoundException"
		// / ausgegeben wird<br/>
		// / Wenn ein nicht vorhadener Internalname verwendet wird.<br/>
		// / Sprache "de"
		// /
		@Test
		public void TCE_GetConst4Internalname_OKWConst4InternalnameNotFoundException_Msg_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");

			try {
				actuel = myOKW_Const.GetConst4Internalname("NotExist");
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWConst4InternalnameNotFoundException e) {
				String SollWertPath = Paths
						.get(OKW_Ini_Sngltn.getInstance().OKW_Enviroment
								.getFolder_LogMessages(),
								"LM_OKW_Const.xml").toString();
				assertEquals(
						"Konstante wurde nicht gefunden! Siehe internalname='NotExist' und die Sprache 'de' in der Datei '"
								+ SollWertPath + "'!", e.getMessage());
			} catch (Exception e) {
				Log.LogPrint(e.getMessage());
				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft ob der sprachabhängige Hinweis zu der Exception
		// "OKWConst4InternalnameNotFoundException"
		// / ausgegeben wird, wenn ein nicht vorhandener Internalname verwendet
		// wird.<br/>
		// / Sprache "EN"
		// /
		@Test
		public void TCE_GetConst4Internalname_OKWConst4InternalnameNotFoundException_Msg_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");

			try {
				actuel = myOKW_Const.GetConst4Internalname("NotExist");

				Log.LogError("Exception wurde nicht ausgelöst");
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWConst4InternalnameNotFoundException e) {
				String SollWertPath = Paths
						.get(OKW_Ini_Sngltn.getInstance().OKW_Enviroment
								.getFolder_LogMessages(),
								"LM_OKW_Const.xml").toString();
				assertEquals(
						"Const not Found! Check internalname='NotExist', language 'en' in file '"
								+ SollWertPath + "'!", e.getMessage());
			} catch (Exception e) {
				Log.LogPrint("Ausgelöste Ausnahme: " + e.getClass().getName());
				Log.LogPrint("          Nachricht: " + e.getMessage());
				Log.LogError("Fehler, weil nicht die erwartetet Exception(KernelException) kam.");
				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft ob eine die fehlende Sprache(hurtz) eine Exception auslöst.
		// / Es wird ein OKWConst4InternalnameNotFoundException-Exception
		// ausgelöst.<br/>
		// / ANmerkung die Sprache existiert nicht, d.h. es wird en als deafult
		// verwendet.
		// /
		@Test
		public void TCE_YesNoToBoolean_OKWConst4InternalnameNotFoundException() {
			Boolean actual;

			try {
				OKWLanguage.getInstance().setLanguage("hurtz");
				actual = myOKW_Const.YesNo2Boolean("YES");

				// Wenn folgende zeile Ausgeführt wird kam die exception nicht.
				Log.LogError("Exception wurde nicht ausgelöst");
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWLanguageNotImplemntedException e) {
				Log.LogPrint("Erwartete Exception wurde ausgelöst.");
			} catch (Exception e) {
				Log.LogPrint("Ausgelöste Ausnahme: " + e.getClass().getName());
				Log.LogPrint("          Nachricht: " + e.getMessage());
				Log.LogError("Fehler, weil nicht die erwartetet Exception(KernelException) kam.");
				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft ob ein Tippfehler eine Kernel-Exception auslöst.
		// /
		@Test
		public void TCE_YesNoToBoolean_OKWNotAllowedValueException() {
			Boolean actual;

			try {
				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.YesNo2Boolean("NON");

				// Wenn folgende zeile Ausgeführt wird kam die exception nicht.
				Log.LogError("Exception wurde nicht ausgelöst");
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWNotAllowedValueException e) {
				Log.LogPrint("Erwartete Exception wurde ausgelöst.");
			} catch (Exception e) {
				Log.LogPrint("Ausgelöste Ausnahme: " + e.getClass().getName());
				Log.LogPrint("          Nachricht: " + e.getMessage());
				Log.LogError("Fehler, weil nicht die arwartetet Exception kam.");

				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
		// auslöst.
		// /
		@Test
		public void TCE_YesNoToBoolean_OKWNotAllowedValueException_Msg_de() {
			Boolean actual;

			try {
				OKWLanguage.getInstance().setLanguage("de");
				actual = myOKW_Const.YesNo2Boolean("NON");

				// Wenn folgende zeile Ausgeführt wird kam die exception nicht.
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWNotAllowedValueException e) {
				Log.LogPrint("Erwartete Exception wurde ausgelöst.");
				assertEquals(
						"Dieser Wert ist hier nicht erlaubt: 'NON'! - Folgende Werte sind erlaubt: 'JA'/'NEIN'",
						e.getMessage());
			} catch (Exception e) {
				Log.LogPrint("Ausgelöste Ausnahme: " + e.getClass().getName());
				Log.LogPrint("          Nachricht: " + e.getMessage());
				Log.LogError("Fehler, weil nicht die erwartetet Exception(KernelException) kam.");
				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		// / \brief
		// / Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
		// auslöst.
		// /
		@Test
		public void TCE_YesNoToBoolean_OKWNotAllowedValueException_Msg_en() {
			Boolean actual;

			try {
				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.YesNo2Boolean("NON");

				// Wenn folgende zeile Ausgeführt wird kam die exception nicht.
				fail("Exception wurde nicht ausgelöst");
			} catch (OKWNotAllowedValueException e) {
				Log.LogPrint("Erwartete Exception wurde ausgelöst.");
				assertEquals(
						"This value is not allowed here: 'NON'! - Following values are possible: 'YES'/'NO'",
						e.getMessage());
			} catch (Exception e) {
				fail("Fehler, weil nicht die arwartetet Exception kam.");
			}
		}

		@Test
		public void TC_Boolean2YesNoTo() {
			String actual = "";
			try {

				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.Boolean2YesNo(true);

				assertEquals("YES", actual);

				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.Boolean2YesNo(false);

				assertEquals("NO", actual);

				OKWLanguage.getInstance().setLanguage("de");
				actual = myOKW_Const.Boolean2YesNo(true);

				assertEquals("JA", actual);

				OKWLanguage.getInstance().setLanguage("de");

				actual = myOKW_Const.Boolean2YesNo(false);

				assertEquals("NEIN", actual);
			} catch (XPathExpressionException e) {
				fail("Fehler, weil Exception erwartetet war.");
			}
		}

		@Test
		public void TC_ConcatHSEP() {
			String actual = "";

			ArrayList<String> Input = new ArrayList<String>();
			OKWLanguage.getInstance().setLanguage("en");
			try {

				// Keinwert
				Input.clear();

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("", actual);

				// 1-Wert W
				Input.clear();
				Input.add("Hase");

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("Hase", actual);

				// 2-Werte WW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("Hase${HSEP}Fuchs", actual);

				// 3-Werte WWW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");
				Input.add("Bär");

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("Hase${HSEP}Fuchs${HSEP}Bär", actual);

				// 3-Werte WLW
				Input.clear();
				Input.add("Hase");
				Input.add("");
				Input.add("Bär");

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("Hase${HSEP}${HSEP}Bär", actual);

				// 3-Werte LWL
				Input.clear();
				Input.add("");
				Input.add("Fuchs");
				Input.add("");

				actual = myOKW_Const.ConcatHSEP(Input);

				assertEquals("${HSEP}Fuchs${HSEP}", actual);
			} catch (XPathExpressionException e) {
				fail("Fehler, weil Exception erwartetet war.");
			}
		}

		@Test
		public void TC_ConcatSEP() {
			String actual = "";

			ArrayList<String> Input = new ArrayList<String>();
			OKWLanguage.getInstance().setLanguage("en");

			try {
				// Keinwert
				Input.clear();

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("", actual);

				// 1-Wert W
				Input.clear();
				Input.add("Hase");

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("Hase", actual);

				// 2-Werte WW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("Hase${SEP}Fuchs", actual);

				// 3-Werte WWW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");
				Input.add("Bär");

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("Hase${SEP}Fuchs${SEP}Bär", actual);

				// 3-Werte WLW
				Input.clear();
				Input.add("Hase");
				Input.add("");
				Input.add("Bär");

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("Hase${SEP}${SEP}Bär", actual);

				// 3-Werte LWL
				Input.clear();
				Input.add("");
				Input.add("Fuchs");
				Input.add("");

				actual = myOKW_Const.ConcatSEP(Input);

				assertEquals("${SEP}Fuchs${SEP}", actual);
			} catch (XPathExpressionException e) {
				fail("Fehler, weil Exception erwartetet war.");
			}
		}

		@Test
		public void TC_ConcatVSEP() {
			String actual = "";

			ArrayList<String> Input = new ArrayList<String>();
			OKWLanguage.getInstance().setLanguage("en");
			try {
				// Keinwert
				Input.clear();

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("", actual);

				// 1-Wert W
				Input.clear();
				Input.add("Hase");

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("Hase", actual);

				// 2-Werte WW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("Hase${VSEP}Fuchs", actual);

				// 3-Werte WWW
				Input.clear();
				Input.add("Hase");
				Input.add("Fuchs");
				Input.add("Bär");

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("Hase${VSEP}Fuchs${VSEP}Bär", actual);

				// 3-Werte WLW
				Input.clear();
				Input.add("Hase");
				Input.add("");
				Input.add("Bär");

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("Hase${VSEP}${VSEP}Bär", actual);

				// 3-Werte LWL
				Input.clear();
				Input.add("");
				Input.add("Fuchs");
				Input.add("");

				actual = myOKW_Const.ConcatVSEP(Input);

				assertEquals("${VSEP}Fuchs${VSEP}", actual);
			} catch (XPathExpressionException e) {
				fail("Fehler, weil Exception erwartetet war.");
			}
		}

		@Test
		public void TC_Const_Check_OKWDOKU_CHECK_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetConst4Internalname("CHECKED");
			assertEquals("ANGEWÄHLT", actuel);
		}

		@Test
		public void TC_Const_Check_OKWDOKU_CHECK_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetConst4Internalname("CHECKED");
			assertEquals(actuel, "CHECKED");
		}

		@Test
		public void TC_Const_GetOKWConst_HSEP_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetOKWConst4Internalname("HSEP");
			assertEquals("${HSEP}", actuel);
		}

		// / \brief
		// / Prüft ob eine die fehlende Sprache(hurtz) eine Exception auslöst.
		// /
		@Test
		public void TC_Const_GetOKWConst_HSEP_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetOKWConst4Internalname("HSEP");
			assertEquals("${HSEP}", actuel);
		}

		@Test
		public void TC_Const_Check_OKWDOKU_NO_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetConst4Internalname("NO");
			assertEquals(actuel, "NEIN");
		}

		@Test
		public void TC_Const_Check_OKWDOKU_NO_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetConst4Internalname("NO");
			assertEquals(actuel, "NO");
		}

		@Test
		public void TC_Const_GetOKWConst_SEP_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetOKWConst4Internalname("SEP");
			assertEquals("${SEP}", actuel);
		}

		@Test
		public void TC_Const_GetOKWConst_SEP_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetOKWConst4Internalname("SEP");
			assertEquals("${SEP}", actuel);
		}

		@Test
		public void TC_Const_Check_OKWDOKU_UNCHECK_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetConst4Internalname("UNCHECKED");
			assertEquals(actuel, "ABGEWÄHLT");
		}

		@Test
		public void TC_Const_Check_OKWDOKU_UNCHECK_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetConst4Internalname("UNCHECKED");
			assertEquals(actuel, "UNCHECKED");
		}

		@Test
		public void TC_Const_Check_OKWDOKU_YES_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetConst4Internalname("YES");
			assertEquals(actuel, "JA");
		}

		@Test
		public void TC_Const_Check_OKWDOKU_YES_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetConst4Internalname("YES");
			assertEquals(actuel, "YES");
		}

		@Test
		public void TC_Const_GetOKWConst_DELETE_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetOKWConst4Internalname("DELETE");
			assertEquals(actuel, "${LÖSCHEN}");
		}

		@Test
		public void TC_Const_GetOKWConst_DELETE_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetOKWConst4Internalname("DELETE");
			assertEquals(actuel, "${DELETE}");
		}

		@Test
		public void TC_Const_GetOKWConst_IGNORE_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetOKWConst4Internalname("IGNORE");
			assertEquals(actuel, "${IGNORIEREN}");
		}

		@Test
		public void TC_Const_GetOKWConst_IGNORE_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetOKWConst4Internalname("IGNORE");
			assertEquals(actuel, "${IGNORE}");
		}

		@Test
		public void TC_Const_GetOKWConst_EMPTY_de() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("de");
			actuel = myOKW_Const.GetOKWConst4Internalname("EMPTY");
			assertEquals(actuel, "${LEER}");
		}

		@Test
		public void TC_Const_GetOKWConst_EMPTY_en() {
			String actuel = "";

			OKWLanguage.getInstance().setLanguage("en");
			actuel = myOKW_Const.GetOKWConst4Internalname("EMPTY");
			assertEquals(actuel, "${EMPTY}");
		}

		@Test
		public void TC_SplitHSEP_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC1: 0-Value and 0-Separator
			actual = myOKW_Const.SplitHSEP("");
			expected.add("");

			assertEquals(expected, actual);

			// TC2: 1-Value and 0-Separator
			actual = myOKW_Const.SplitHSEP("WERT");

			expected.clear();
			expected.add("WERT");

			assertEquals(expected, actual);

			// TC2: 2-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");

			assertEquals(expected, actual);

			// TC2a: 1-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("");

			assertEquals(expected, actual);

			// TC2b: 1-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("${HSEP}Wert2");

			expected.clear();
			expected.add("");
			expected.add("Wert2");

			assertEquals(expected, actual);

			// TC3: 3-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2${HSEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2${HSEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("");

			assertEquals(expected, actual);

			// TC3b: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}${HSEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("");
			expected.add("Wert3");

			assertEquals(expected, actual);

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("${HSEP}Wert2${HSEP}Wert3");

			expected.clear();
			expected.add("");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitHSEP_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC1: 0-Value and 0-Separator
			actual = myOKW_Const.SplitHSEP("");
			expected.add("");

			assertEquals(expected, actual);

			// TC2: 1-Value and 0-Separator
			actual = myOKW_Const.SplitHSEP("WERT");

			expected.clear();
			expected.add("WERT");

			assertEquals(expected, actual);

			// TC2: 2-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");

			assertEquals(expected, actual);

			// TC2a: 1-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("");

			assertEquals(expected, actual);

			// TC2b: 1-Value and 1-Separator
			actual = myOKW_Const.SplitHSEP("${HSEP}Wert2");

			expected.clear();
			expected.add("");
			expected.add("Wert2");

			assertEquals(expected, actual);

			// TC3: 3-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2${HSEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}Wert2${HSEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("");

			assertEquals(expected, actual);

			// TC3b: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("Wert1${HSEP}${HSEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("");
			expected.add("Wert3");

			assertEquals(expected, actual);

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitHSEP("${HSEP}Wert2${HSEP}Wert3");

			expected.clear();
			expected.add("");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_SVSV_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("${SEP}Wert2${SEP}Wert3");

			expected.clear();
			expected.add("");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_SVSV_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("${SEP}Wert2${SEP}Wert3");

			expected.clear();
			expected.add("");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_SV_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC2b: 1-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("${SEP}Wert2");

			expected.clear();
			expected.add("");
			expected.add("Wert2");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_SV_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC2b: 1-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("${SEP}Wert2");

			expected.clear();
			expected.add("");
			expected.add("Wert2");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSSV_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC3b: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}${SEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSSV_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC3b: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}${SEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSVSV_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC3: 3-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2${SEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSVSV_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC3: 3-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2${SEP}Wert3");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("Wert3");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSVS_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2${SEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSVS_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC3a: 2-Value and 2-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2${SEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSV_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC2: 2-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VSV_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC2: 2-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}Wert2");

			expected.clear();
			expected.add("Wert1");
			expected.add("Wert2");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VS_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC2a: 1-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_VS_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC2a: 1-Value and 1-Separator
			actual = myOKW_Const.SplitSEP("Wert1${SEP}");

			expected.clear();
			expected.add("Wert1");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_V_de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC2: 1-Value and 0-Separator
			actual = myOKW_Const.SplitSEP("WERT");

			expected.clear();
			expected.add("WERT");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP_V_en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC2: 1-Value and 0-Separator
			actual = myOKW_Const.SplitSEP("WERT");

			expected.clear();
			expected.add("WERT");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP__de() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("de");

			// TC1: 0-Value and 0-Separator
			actual = myOKW_Const.SplitSEP("");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_SplitSEP__en() {
			ArrayList<String> actual;
			ArrayList<String> expected = new ArrayList<String>();

			OKWLanguage.getInstance().setLanguage("en");

			// TC1: 0-Value and 0-Separator
			actual = myOKW_Const.SplitSEP("");
			expected.add("");

			assertEquals(expected, actual);
		}

		@Test
		public void TC_YesNoToBoolean() {
			Boolean actual;

			OKWLanguage.getInstance().setLanguage("en");
			actual = myOKW_Const.YesNo2Boolean("YES");

			assertEquals(true, actual);

			OKWLanguage.getInstance().setLanguage("en");
			actual = myOKW_Const.YesNo2Boolean("NO");

			assertEquals(false, actual);

			OKWLanguage.getInstance().setLanguage("de");
			actual = myOKW_Const.YesNo2Boolean("JA");

			assertEquals(true, actual);

			OKWLanguage.getInstance().setLanguage("de");
			actual = myOKW_Const.YesNo2Boolean("NEIN");

			assertEquals(false, actual);
		}

		public void TC_YesNoToBoolean_OKWNotAllowedValueException_en() {
			Boolean actual;
			try {
				OKWLanguage.getInstance().setLanguage("en");
				actual = myOKW_Const.YesNo2Boolean("NotAllowedValue");
				fail("OKWNotAllowedValueException was NOT ´triggerd");
			} catch (OKWNotAllowedValueException e) {
				Assert.Pass("OKWNotAllowedValueException was ´triggerd -> OK!");
			} catch (SystemException ex) {
				fail("Not expected Exception was ´triggerd");
			}
		}

		public void TC_YesNoToBoolean_OKWNotAllowedValueException_de() {
			Boolean actual;
			try {
				OKWLanguage.getInstance().setLanguage("de");
				actual = myOKW_Const.YesNo2Boolean("NotAllowedValue");
				fail("OKWNotAllowedValueException was NOT ´triggerd");
			} catch (OKWNotAllowedValueException e) {
				Assert.Pass("OKWNotAllowedValueException was ´triggerd -> OK!");
			} catch (SystemException ex) {
				fail("Not expected Exception was ´triggerd");
			}
		}

	}

}
