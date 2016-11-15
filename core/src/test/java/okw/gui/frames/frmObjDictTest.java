package okw.gui.frames;

import okw.*;
import okw.gui.adapter.*;
import okw.log.*;

    /** \~german
     *  Die Klasse frmObjDictTest ist eine Test-Frame-Klasse. Diese Klasse ist ein OKW-Unittest-Objekt.<br/>
     *  
     *  @author Zoltan Hrabovszki
     *  \date 2012.12.26
     *  @warning **Diese Frame-Klasse nicht ohne Grund verändern!**
     *  Sie ist basis für etliche OKW-Unittests. **ZH**
     *  @copyright
     */

@OKW(FN="frmObjDictTest")
public class frmObjDictTest extends Test_Window
  {
	Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();


        /** \~german
         * Test für einen GUI-Container.
         * 
         * Element zur Prüfung einer GUI-Container-Klasse mit dem Test Ziel:
         *  - wird das Feld instanziert und im ObjectDictionary abgelegt wird.
         * 
         * Keine Annotaion für die Container-Klasse selbst!
         * 
         * @author Zoltan Hrabovszki
         * @date 2016.11.13
         */
        public frmObjDictGuiContainer1 myGUIContainer = new frmObjDictGuiContainer1();

        
        /**
         * Test für eine Inline Klasse, die als GUI-Container dient.
         * 
         * Dient zur Prüfung, ob ein GUI-Container-Class instanziert und im ObjectDictionary abgelegt wird.
         * 
         * @author Zoltan Hrabovszki
         * @date 2016.11.13
         * No annotaion for the Container @OKW(FN="Anzeige")
         */
        @OKW(FN="Tastatur")
        public myTestbutton myInlineClassDef = this.new myTestbutton("locator");
        
        
        public class myTestbutton extends Test_PushButton
        {

          public myTestbutton( String fpsLocator )
          {
            super( fpsLocator );
            // TODO Auto-generated constructor stub
          }

          /// \brief
          /// Taste_1 ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_PushButton.
          /// D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
          /// 
          /// \author Zoltan Hrabovszki
          /// \date 2012.12.26
          @OKW(FN="Taste_1")
          public Test_PushButton Taste_1 = new Test_PushButton("1");

          /// \brief
          /// Taste_2 ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_PushButton.
          /// D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
          /// 
          /// \author Zoltan Hrabovszki
          /// \date 2012.12.26
          @OKW(FN="Taste_2")
          public Test_PushButton Taste_2 = new Test_PushButton("2");

        };
        
        
        /// \brief
        /// Konstruktor der Klasse Rechner: Hier wird angegeben, wie das Objekt "Rechner" erkannt wird.<br/>
        /// Da diese Klasse eine Testklasse ist ohne irgen dein ein GUI-Objekt,
        /// ist das setzten des Wertes "Neuer Locator Rechner" nur für den Unittest relevant.<br/>
        /// Also hier den Locator für das Fenster setzen...
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        public frmObjDictTest()
        {
        	super("Neuer Locator Rechner");
            myLogger.LogPrintDebug("Rechner.Constructor()");
        }

        @Override
        public  void SelectWindow()
        {
            myLogger.LogFunctionStartDebug(this.getClass().getName() + ".SelectWindow");
            myLogger.LogPrintDebug("Locator: " + this.Locator);

            myClipBoard.setObjectName("Rechner");
            myClipBoard.setMethod("SelectWindow()");
            myClipBoard.getValue().clear();
            myClipBoard.getValue().add("NO VALUE");

            myLogger.LogFunctionEndDebug();
            
            return;
        }
    }