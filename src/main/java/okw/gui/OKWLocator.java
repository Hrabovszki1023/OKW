package okw.gui;

/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

import java.util.ArrayList;

import okw.log.*;
	
	/// <summary>
	/// Description of OKWLocator.
	/// </summary>
	public class OKWLocator //: IOKWLocator
	{
		String _locator = "";
		OKWLocator[] _Locatoren;
        
		Logger_Sngltn myLogger = Logger_Sngltn.getInstance();
        
		
		public OKWLocator(String fpsLocatorRAW, OKWLocator... fpLocators)
		{
			if (fpLocators != null) {
				_locator = fpsLocatorRAW;
				_Locatoren = fpLocators;
			}
			else
			{
				_locator = fpsLocatorRAW;
			}
		}
        
		public String getLocator()
		{
			myLogger.LogFunctionStartDebug("getLocator()");
				String lvsReturn = "";
                
				ArrayList<String> myLocatoren = new ArrayList<String>();
                
				if (_Locatoren != null) {
					for (OKWLocator Locator : _Locatoren) {
						myLocatoren.add(Locator.getLocator());
					}
                    
					lvsReturn = String.format(_locator, myLocatoren.toArray());
				} else {
					lvsReturn = _locator;
				}
                
				myLogger.LogFunctionEndDebug(lvsReturn);
				return lvsReturn;
		}
		
		public void setLocator(String value)
		{
				myLogger.LogFunctionStartDebug("Get locator");
				_locator = value;
				myLogger.LogFunctionEndDebug();
		}
	}

