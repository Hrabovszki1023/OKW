/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2020, IT-Beratung Hrabovszki
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
