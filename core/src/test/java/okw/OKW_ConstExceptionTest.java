package okw;

import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreHelperTests")
public class OKW_ConstExceptionTest
{

        public static OKW_Const_Sngltn myOKW_Const;

        // / \copydoc CurrentObject::Log()
        private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

        @BeforeAll
        public static void mySetUp()
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
        @Test
        public void tcGetConst4InternalnameOKWConst4InternalnameNotFoundException()
        {
            OKWLanguage.getInstance().setLanguage( "en" );
            
            Assertions.assertThrows( OKWConst4InternalnameNotFoundException.class, () ->
            {
                myOKW_Const.GetConst4Internalname( "NotExist" );
            });
        }

        /**
         *  Prüft, ob der sprachabhängige Hinweis zu der Exception
         *  "OKWConst4InternalnameNotFoundException"
         *  ausgegeben wird<br/>
         *  Wenn ein nicht vorhadener Internalname verwendet wird.<br/>
         *  Sprache "de"
         */
        @Test
        public void tcGetConst4InternalnameOKWConst4InternalnameNotFoundException_Msg()
        {

            OKWLanguage.getInstance().setLanguage( "de" );

            Assertions.assertThrows( OKWConst4InternalnameNotFoundException.class, () ->
            {
                myOKW_Const.GetConst4Internalname( "NotExist" );
            });
        }

        /**
         *  Prüft ob eine die fehlende Sprache(hurtz) eine Exception auslöst.
         *  Es wird ein OKWConst4InternalnameNotFoundException-Exception
         *  ausgelöst.<br/>
         *  ANmerkung die Sprache existiert nicht, d.h. es wird en als deafult
         *  verwendet.
         */
        @Test
        public void tcYesNoToBoolean_OKWConst4InternalnameNotFoundException() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "hurtz" );

            Assertions.assertThrows( OKWLanguageNotImplemntedException.class, () ->
            {
                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "YES" );
            });
        }

        /**
         * Prüft ob ein Tippfehler eine Kernel-Exception auslöst.
         */
        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "en" );

            Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
            {
                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "NON" );
            });
        }

        /**
         *  Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
         *  auslöst.
         */
        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_Msg_de() throws XPathExpressionException
        {
                OKWLanguage.getInstance().setLanguage( "de" );

                Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
                {
                    // Call with expected Exception...
                    myOKW_Const.YesNo2Boolean( "NON" );
                });
        }

        /**
         *  Prüft ob ein Tippfehler eine OKWNotAllowedValueException-Exception
         *  auslöst.
         */
        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_Msg()
        {
                OKWLanguage.getInstance().setLanguage( "en" );

                Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
                {
                    // Call with expected Exception...
                    myOKW_Const.YesNo2Boolean( "NON" );
                });
        }

        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_en() throws XPathExpressionException
        {
            OKWLanguage.getInstance().setLanguage( "en" );

            Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
            {
                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "NotAllowedValue" );
            });
        }

        @Test
        public void tcYesNoToBoolean_OKWNotAllowedValueException_de() throws XPathExpressionException
        {

            OKWLanguage.getInstance().setLanguage( "de" );

            Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
            {
                // Call with expected Exception...
                myOKW_Const.YesNo2Boolean( "NotAllowedValue" );
            });
        }
}
