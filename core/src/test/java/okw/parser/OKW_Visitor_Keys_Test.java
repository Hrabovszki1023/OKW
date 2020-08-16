package okw.parser;


import okw.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


	public class OKW_Visitor_Keys_Test
    {
        String myOKW_Xml = "";
        
        OKW_Ini_Sngltn myOKW_Ini = OKW_Ini_Sngltn.getInstance();
                
        /**
         *  Prüft die Tastatureingabe "DEL" als einzelner Wert
         *  @author Zoltan Hrabovszki
         *  \date 2014.01.14
         */
        @Test
        public void TC_DEL()
        {
            String sActual = Parser.ParseMe("#{DEL}");            
            String sExpected = "#{DEL}";

            assertEquals(sExpected, sActual);
        }

        /**
         *  Prüft die Tastatureingabe "DEL" in einem Text eingebbetet.
         *  @author Zoltan Hrabovszki
         *  \date 2014.01.14
         */
        @Test
        public void TC_DEL_2()
        {
            String sActual = Parser.ParseMe("Brunsbüttel#{DEL}Hamburg");            
            String sExpected = "Brunsbüttel#{DEL}Hamburg";

            assertEquals(sExpected, sActual);
        }
        
        /**
         *  Prüft die Tastatureingabe "SHFT" / Shift
         *  @author Zoltan Hrabovszki
         *  \date 2014.01.14
         */
        @Test
        public void TC_SHFT()
        {
            String sActual = Parser.ParseMe("#{SHIFT}");            
            String sExpected = "#{SHIFT}";

            assertEquals(sExpected, sActual);
        }

        /**
         *  Prüft die Tastatureingabe "CONTROL" / CTRL
         *  @author Zoltan Hrabovszki
         *  \date 2014.01.14
         */
        @Test
        public void TC_CONTROL()
        {
            String sExpected = "#{CONTROL}";

            String sActual = Parser.ParseMe("#{CONTROL}");            
            assertEquals(sExpected, sActual);

        }
        
/*        'ADD';
        | 'ALT' 
        | 'ARROW_DOWN' 
        | 'ARROW_LEFT' 
        | 'ARROW_RIGHT' 
        | 'ARROW_UP' 
        | 'BACK_SPACE' 
        | 'CANCEL' 
        | 'CLEAR' 
        | 'COMMAND' 
        | 'CONTROL' | 'CTRL'
        | 'DECIMAL' 
        | 'DEL' 
        | 'DIVIDE' 
        | 'DOWN' 
        | 'END' 
        | 'ENTER' 
        | 'EQUALS' 
        | 'ESCAPE' 
        | 'F1' 
        | 'F10' 
        | 'F11' 
        | 'F12' 
        | 'F2' 
        | 'F3' 
        | 'F4' 
        | 'F5' 
        | 'F6' 
        | 'F7' 
        | 'F8' 
        | 'F9' 
        | 'HELP' 
        | 'HOME' 
        | 'INSERT' 
        | 'LEFT' 
        | 'LEFT_ALT' 
        | 'LEFT_CONTROL' 
        | 'LEFT_SHIFT' 
        | 'META' 
        | 'MULTIPLY' 
        | 'NULL' 
        | 'NUMPAD0' 
        | 'NUMPAD1' 
        | 'NUMPAD2' 
        | 'NUMPAD3' 
        | 'NUMPAD4' 
        | 'NUMPAD5' 
        | 'NUMPAD6' 
        | 'NUMPAD7' 
        | 'NUMPAD8' 
        | 'NUMPAD9' 
        | 'PAGE_DOWN' 
        | 'PAGE_UP' 
        | 'PAUSE' 
        | 'RETURN' 
        | 'RIGHT' 
        | 'SEMICOLON' 
        | 'SEPARATOR' 
        | 'SHIFT' 
        | 'SPACE' 
        | 'SUBTRACT' 
        | 'TAB' 
        | 'UP' ;
        */
}
	