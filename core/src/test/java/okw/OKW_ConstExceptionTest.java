package okw;

import static org.junit.Assert.*;

import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;
import org.junit.Test;

public class OKW_ConstExceptionTest
{

    public class OKW_Const_Test_
    {

        private OKW_Const_Sngltn myOKW_Const;

        // / \copydoc CurrentObject::Log()
        private Logger_Sngltn    Log = Logger_Sngltn.getInstance();

        // [TestFixtureSetUp]
        public void mySetUp()
        {

            myOKW_Const = OKW_Const_Sngltn.getInstance();

            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.init();

            // Log.AddLogger(new Log2Console());
            Log.setDebugMode( true );
        }

        /**
         *  Prüft ob die Exception "OKWConst4InternalnameNotFoundException" ausgelöst wird,
         *  wenn ein nicht vorhandener Internalname verwendet wird.<br/>
         */
        @Test( expected = OKWConst4InternalnameNotFoundException.class )
        public void tcGetConst4InternalnameOKWConst4InternalnameNotFoundException()
        {
            OKWLanguage.getInstance().setLanguage( "en" );
            myOKW_Const.GetConst4Internalname( "NotExist" );
        }

        /**
         *  Prüft, ob der sprachabhängige Hinweis zu der Exception
         *  "OKWConst4InternalnameNotFoundException"
         *  ausgegeben wird<br/>
         *  Wenn ein nicht vorhadener Internalname verwendet wird.<br/>
         *  Sprache "de"
         */
        @Test( expected = OKWConst4InternalnameNotFoundException.class )
        public void tcGetConst4InternalnameOKWConst4InternalnameNotFoundException_Msg()
        {

            OKWLanguage.getInstance().setLanguage( "de" );
            myOKW_Const.GetConst4Internalname( "NotExist" );
        }

        
        /**
         *  Prüft ob der sprachabhängige Hinweis zu der Exception
         *  "OKWConst4InternalnameNotFoundException"
         *  ausgegeben wird, wenn ein nicht vorhandener Internalname verwendet
         *  wird.<br/>
         *  Sprache "EN"
         */
        @Test( expected = OKWConst4InternalnameNotFoundException.class )
        public void tcGetConst4Internalname_OKWConst4InternalnameNotFoundException_Msg_en()
        {
            OKWLanguage.getInstance().setLanguage( "en" );
            myOKW_Const.GetConst4Internalname( "NotExist" );
        }

        /**
         *  Prüft ob eine die fehlende Sprache(hurtz) eine Exception auslöst.
         *  Es wird ein OKWConst4InternalnameNotFoundException-Exception
         *  ausgelöst.<br/>
         *  ANmerkung die Sprache existiert nicht, d.h. es wird en als deafult
         *  verwendet.
         */
        @Test( expected = OKWLanguageNotImplemntedException.class )
        public void tcYesNoToBoolean_OKWConst4InternalnameNotFoundException() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "hurtz" );

            // Call with expected Exception...
            myOKW_Const.YesNo2Boolean( "YES" );
        }

        /**
         * Prüft ob ein Tippfehler eine Kernel-Exception auslöst.
         */
        @Test( expected = OKWNotAllowedValueException.class )
        public void tcYesNoToBoolean_OKWNotAllowedValueException() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "en" );

            // Call with expected Exception...
            myOKW_Const.YesNo2Boolean( "NON" );
        }

        /**
         *  Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
         *  auslöst.
         */
        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_Msg_de()
        {

            try
            {
                OKWLanguage.getInstance().setLanguage( "de" );

                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "NON" );

                // Wenn folgende zeile Ausgeführt wird kam die exception nicht.
                fail( "Exception wurde nicht ausgelöst" );
            }
            catch (OKWNotAllowedValueException e)
            {
                Log.LogPrint( "Erwartete Exception wurde ausgelöst." );
                assertEquals( "Dieser Wert ist hier nicht erlaubt: 'NON'! - Folgende Werte sind erlaubt: 'JA'/'NEIN'", e.getMessage() );
            }
            catch (Exception e)
            {
                Log.LogPrint( "Ausgelöste Ausnahme: " + e.getClass().getName() );
                Log.LogPrint( "          Nachricht: " + e.getMessage() );
                Log.LogError( "Fehler, weil nicht die erwartetet Exception(KernelException) kam." );
                fail( "Fehler, weil nicht die arwartetet Exception kam." );
            }
        }

        /**
         *  Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
         *  auslöst.
         */
        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_Msg()
        {

            try
            {
                OKWLanguage.getInstance().setLanguage( "en" );

                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "NON" );

                // Wenn folgende zeile Ausgeführt wird kam die exception nicht.
                fail( "Exception wurde nicht ausgelöst" );
            }
            catch (OKWNotAllowedValueException e)
            {
                Log.LogPrint( "Erwartete Exception wurde ausgelöst." );
                assertEquals( "This value is not allowed here: 'NON'! - Following values are possible: 'YES'/'NO'", e.getMessage() );
            }
            catch (Exception e)
            {
                fail( "Fehler, weil nicht die arwartetet Exception kam." );
            }
        }

        @Test( expected = OKWNotAllowedValueException.class )
        public void tcYesNoToBoolean_OKWNotAllowedValueException_en() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "en" );

            // Call with expected Exception...
            myOKW_Const.YesNo2Boolean( "NotAllowedValue" );
        }

        @Test( expected = OKWNotAllowedValueException.class )
        public void tcYesNoToBoolean_OKWNotAllowedValueException_de() throws XPathExpressionException
        {

            OKWLanguage.getInstance().setLanguage( "de" );

            // Call with expected Exception...
            myOKW_Const.YesNo2Boolean( "NotAllowedValue" );
        }
    }
}
