package okw.gui.frames;

import okw.*;
import okw.log.*;
import okw.gui.adapter.*;

@OKW(FN="CurrentObjectWindow")
public class frmCurrentObjectWindow extends Test_Window
{


	Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
	
	/// \brief
	/// Die Klasse frm_CurrentObjectWindow ist eine Test-Frame-Klasse. Diese Klasse dient als Unittest-Objekt.<br/>
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
	/// \copyright CC-OPENKEYWORD


	    /// \brief
	    /// Instanz der Klasse __CurrentObjectAllMethodCallTypes erstellen...
	    /// 
	    /// \author Zoltan Hrabovszki
	    /// \date 2014.01.14
	    @OKW(FN="CurrentObjectAllMethodCallTypes")
	    public CurrentChildObject_Allmethods CurrentObjectAllMethodCallTypes = new CurrentChildObject_Allmethods("Locator_CurrentObjectAllMethodCallTypes");
	    
	    @OKW(FN="AllMethod 2")
	    public AllMethods_SingleValue myAllMethods_SingleValue = new AllMethods_SingleValue("Locator_CurrentObjectAllMethodCallTypes");    	    
	        	    
		    /// \brief
		    /// Konstruktor der Klasse frm_CurrentObjectWindow
		    /// Diese Klasse ist eine Testklasse und in OKW Unitets verwendet.
		    /// Dies Klasse führt keine GUI-Aktivitäten durch,
		    /// Das setzten des Wertes "Neuer Locator CurrentObjectWindow" nur für den Unittest relevant.<br/>
		    /// 
		    /// \author Zoltan Hrabovszki
		    /// \date 2014.01.30
		    public frmCurrentObjectWindow()
		    {
		    	super("Neuer Locator CurrentObjectWindow");
		        myLogger.LogPrintDebug("frm_Rechner.Constructor()");
		    }


	}
