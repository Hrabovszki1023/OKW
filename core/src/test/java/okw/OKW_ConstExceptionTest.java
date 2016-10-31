package okw;

import static org.junit.Assert.*;

import java.nio.file.Paths;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;
import org.junit.Test;

public class OKW_ConstExceptionTest {

	public class OKW_Const_Test_ {

		OKW_Const_Sngltn myOKW_Const;

		// / \copydoc CurrentObject::Log()
		private Logger_Sngltn Log = Logger_Sngltn.getInstance();

		// [TestFixtureSetUp]
		public void MySetUp() {

			myOKW_Const = OKW_Const_Sngltn.getInstance();

			// Reset des Loggers: Alle geladenen Instanzen löschen
			Logger_Sngltn.Init();

			// Log.AddLogger(new Log2Console());
			Log.setDebugMode(true);
		}


		// / \brief
		// / Prüft ob die Exception "OKWConst4InternalnameNotFoundException"
		// ausgelöst wird,
		// / wenn ein nicht vorhandener Internalname verwendet wird.<br/>
		// / Sprache "EN"
		// /
		@Test
		public void TCE_GetConst4Internalname_OKWConst4InternalnameNotFoundException_de() {
	
			OKWLanguage.getInstance().setLanguage("en");

			try
			{
				
				// Call with expected Exception...
				myOKW_Const.GetConst4Internalname("NotExist");

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

			OKWLanguage.getInstance().setLanguage("de");

			try {
				// Call with expected Exception...
				myOKW_Const.GetConst4Internalname("NotExist");
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

			OKWLanguage.getInstance().setLanguage("en");

			try {
				// Call with expected Exception...
				myOKW_Const.GetConst4Internalname("NotExist");

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


			try {
				OKWLanguage.getInstance().setLanguage("hurtz");
				
				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("YES");

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

			try {
				OKWLanguage.getInstance().setLanguage("en");

				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("NON");

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

			try {
				OKWLanguage.getInstance().setLanguage("de");

				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("NON");

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

			try {
				OKWLanguage.getInstance().setLanguage("en");
				
				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("NON");

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



		public void TC_YesNoToBoolean_OKWNotAllowedValueException_en() {

			try {
				OKWLanguage.getInstance().setLanguage("en");
				
				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("NotAllowedValue");
				fail("OKWNotAllowedValueException was NOT ´triggerd");
			}
			catch (OKWNotAllowedValueException e)
			{
				//Assert.Pass("OKWNotAllowedValueException was ´triggerd -> OK!");
			}
			catch (Exception ex)
			{
				fail("Not expected Exception was ´triggerd");
			}
		}

		public void TC_YesNoToBoolean_OKWNotAllowedValueException_de() {
			
			
			try
			{
				OKWLanguage.getInstance().setLanguage("de");
				
				// Call with expected Exception...
				myOKW_Const.YesNo2Boolean("NotAllowedValue");
				fail("OKWNotAllowedValueException was NOT ´triggerd");
			} 
			catch (OKWNotAllowedValueException e)
			{
				//Assert.Pass("OKWNotAllowedValueException was ´triggerd -> OK!");
			}
			catch (Exception ex)
			{
				fail("Not expected Exception was ´triggerd");
			}
		}

	}

}
