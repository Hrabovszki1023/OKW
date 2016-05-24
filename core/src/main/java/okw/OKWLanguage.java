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
package okw;

import java.util.ArrayList;

import okw.exceptions.OKWLanguageNotImplemntedException;

/// \brief
/// http://de.wikipedia.org/wiki/ISO-3166-1-Kodierliste
/// 
public class OKWLanguage {

	private static OKWLanguage		Instance;

	public static OKWLanguage getInstance()
	{
		// Lazy Initialization (If required then only)
		if (Instance == null)
		{
			// Thread Safe. Might be costly operation in some case
			synchronized (OKW_Ini_Sngltn.class)
			{
				if (Instance == null)
				{
					Instance = new OKWLanguage();
				}
			}
		}
		return Instance;
	}

	/// \brief
	/// Enthält die Liste der implemntierten Sprachen
	private static ArrayList<String> cvLsLanguagesImplemented = new ArrayList<String>();

	private OKWLanguage() {

		cvLsLanguagesImplemented.add("en");
		cvLsLanguagesImplemented.add("de");
	}

	/// \brief
	/// Gets or sets a string property.
	///
	private String Language = "en";

	public String getLanguage() {
		return this.Language.toLowerCase();
	}

	public void setLanguage(String value) {
		if (-1 < cvLsLanguagesImplemented.indexOf(value.toLowerCase())) {
			this.Language = value.toLowerCase();
		} else {
			throw new OKWLanguageNotImplemntedException();
		}
	}
}