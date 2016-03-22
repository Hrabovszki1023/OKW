package okw.gui.frames;

import okw.*;
import okw.core.EN;
import okw.gui.adapter.*;
import okw.log.*;

    /* \brief
    /// Die Klasse Rechner ist eine Test-Frame-Klasse. Diese Klasse dient als Unittest-Objekt.<br/>
    /// Dieser Klasse dient(e) als als Prototyp um zu zeigen/testen<br/>
    /// * wie Basis Klassen als GUI-Frame-Objekte verwendet werden
    /// * wie virtuelle Methoden der Basisklassen angepasst, sprich überschrieben, werden können.
    ///
    /// Diese Klasse
    /// * wird für die Prüfung der GUI-Mthoden-Aufrufe verwendet.
    /// * ist virtuell und hat keine aktivität auf der Oberfläche.
    /// 
    /// 1. DE.WähleFenster("Rechner")
    /// 2. DE.GibEin("Taste_3")
    /// 3. DE.PrüfeWert("Anzeige", "3")
    /// 
    /// \author Zoltan Hrabovszki
    /// \date 2012.12.26
    /// \warning **Diese Frame-Klasse nicht ohne Grund verändern!**
    /// Sie ist basis für etliche OKW-Unittests. **ZH**
    /// \copyright */

@OKW_FN(FN="Rechner")
public class frmTestRechner extends Test_Window
    {
	Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

        /// \brief
        /// Test Objekt mit allen OKW-Methoden,
        @OKW_FN(FN="All_MethodsObj")
        public AllMethods All_MethodsObj = new AllMethods("Locator_All_MethodsObj");

        /// \brief
        /// Anzeige ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_TextField.
        /// D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        @OKW_FN(FN="Anzeige")
        public Test_TextField Anzeige = new Test_TextField("Neuer Locator Anzeige");

        /// \brief
        /// Test Objekt ohne einer einzigen OKW-Methoden. -> Unittest für Exceptionauslösung OKWFrameObjectMethodNotFoundException
        @OKW_FN(FN="NoMethodObj")
        public Test_NoMethod_Object NoMethodObj = new Test_NoMethod_Object("Locator_NoMethodObj");

        /// \brief
        /// Taste_1 ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_PushButton.
        /// D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        @OKW_FN(FN="Taste_1")
        public Test_PushButton Taste_1 = new Test_PushButton("1");

        /// \brief
        /// Taste_2 ist ein GUI-Objekt ohne weitere Veränderung der Basisklasse Test_PushButton.
        /// D.h. das Objekt verhält sich *normal*, also wie in der Basisklasse angenommen.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        @OKW_FN(FN="Taste_2")
        public Test_PushButton Taste_2 = new Test_PushButton("2");

        /// \brief
        /// Taste_3 ist ein GUI-Objekt, welches Veränderung der Basisklasse Test_PushButton.
        /// benötigt. Dieses wurde in der Klasse __Taste_3 vorgenmmen.
        /// Nun wird hier eine Instanz der Klasse __Taste_3 erzeugt.
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        @OKW_FN(FN="Taste_3")
        public __Taste_3 Taste_3 = new __Taste_3("3");

        /// \brief
        /// Konstruktor der Klasse Rechner: Hier wird angegeben, wie das Objekt "Rechner" erkannt wird.<br/>
        /// Da diese Klasse eine Testklasse ist ohne irgen dein ein GUI-Objekt,
        /// ist das setzten des Wertes "Neuer Locator Rechner" nur für den Unittest relevant.<br/>
        /// Also hier den Locator für das Fenster setzen...
        /// 
        /// \author Zoltan Hrabovszki
        /// \date 2012.12.26
        public frmTestRechner()
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

        public void TestSequence(String SEQID) throws Exception
        {
            EN.SelectWindow("Rechner");
            EN.ClickOn("Taste_3");
            EN.ClickOn("Taste_2");
        }

        
        // Kindobjekt >>mit<< Anpassung
        public class __Taste_3 extends Test_PushButton
        {

            public __Taste_3(String fps_Locator)
            {
            	super(fps_Locator);
            	myLogger.LogFunctionStartDebug(this.getClass().getName() + ".__Taste_3()", "fps_Locator", fps_Locator);
                myLogger.LogPrintDebug(Locator);
                myLogger.LogFunctionEndDebug();
            }

            @Override
            public void ClickOn()
            {
                myLogger.LogFunctionStartDebug("Überschriebenes ClickOn... ABER JETZT");
                myLogger.LogPrintDebug("Locator: " + Locator);

                myClipBoard.setObjectName("Rechner.Taste_3");
                myClipBoard.setMethod("ClickOn()");
                myClipBoard.getValue().clear();
                myClipBoard.getValue().add("NO VALUE");

                myLogger.LogFunctionEndDebug();
                return;
            }
            
            @Override
            public String getFN()
            {
                return "Rechner";
            }

        }
    }