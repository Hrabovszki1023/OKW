package okw;


import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

@Tag("AllCoreHelperTests")
public class OKW_Memorize_Sngltn_Test
{

        public static OKW_Memorize_Sngltn myOKW_Memorize;

        // / \copydoc CurrentObject::Log()
        private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

        @BeforeAll
        public static void mySetUp()
        {
            myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();

            // Reset des Loggers: Alle geladenen Instanzen löschen
            Logger_Sngltn.init();

            // Log.AddLogger(new Log2Console());
            Log.setDebugMode( false );
        }

        
        /**
         *  Prüft die Methoden get und set, ohne
         *  wenn ein nicht vorhandener Internalname verwendet wird.<br/>
         * @throws XPathExpressionException 
         */
        @Test
        public void tc_get_set() throws XPathExpressionException
        {
            myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();
            myOKW_Memorize.reset();
            
            myOKW_Memorize.set( "Key 1", "Value 1" );
            String myValue = myOKW_Memorize.get( "Key 1" );
            assertEquals( "Value 1", myValue );
        }

        
        /**
         *  Prüft die Methoden get und set, ohne
         *  wenn ein nicht vorhandener Internalname verwendet wird.<br/>
         * @throws XPathExpressionException 
         */
        @Test
        public void tc_get_OKWMemorizeKeyNotExistsException() throws XPathExpressionException
        {
            myOKW_Memorize.reset();
            myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();
            
            myOKW_Memorize.set( "Key 1", "Value 1" );
            String myValue = myOKW_Memorize.get( "Key 1" );
            assertEquals( "Value 1", myValue );
            
            Assertions.assertThrows( OKWMemorizeKeyNotExistsException.class, () ->
            {
                myOKW_Memorize.get( "Key 2" );
            });
        }
        
        /**
         *  Prüft die Methoden OKW_Memorize_Sngltn.exist(String)
         */
        @Test
        public void tc_exists() throws XPathExpressionException
        {
            myOKW_Memorize.reset();
            myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();
            
            myOKW_Memorize.set( "Key 1", "Value 1" );

            assertEquals( true, myOKW_Memorize.exists( "Key 1" ) );
            
            assertEquals( false, myOKW_Memorize.exists( "Key DoesnotExists" ) );
            
            
        }
        
        /**
         *  Prüft die OKW_Memorize_Sngltn.Set(String,String),
         *  wenn ein Schlüssel bereit existiert und mit einem
         *  neuen Wert belegt wird
         */
        @Test
        public void tc_set_aKey_twice() throws XPathExpressionException
        {
            myOKW_Memorize.reset();
            myOKW_Memorize = OKW_Memorize_Sngltn.getInstance();
            
            myOKW_Memorize.set( "Key 1", "Value 1" );
            assertEquals( "Value 1", myOKW_Memorize.get( "Key 1" ) );
            
            myOKW_Memorize.set( "Key 1", "Value 2" );
            assertEquals( "Value 2", myOKW_Memorize.get( "Key 1" ) );
            
            
        }
}
