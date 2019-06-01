/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.exceptions;

/// \~german
/// \brief
/// Die Ausnahme <code>OKWMessageNotFoundException</code> wird ausgelöst, 
/// wenn ein Nachrichten-Eintrag in einer XML/Log/*.xml-Datei nicht gefunden worden ist. 
/// "Exception" (Ausnahmebehandlung) wird von der Klasse OKW.LogMessenger ausgelöst.
/// 
/// \~english
/// \brief
/// The Exception <code>OKWMessageNotFoundException</code> is triggered, if a news-listing in an
/// XML/Log/*.xml-File is not found. Exception is triggered from the class OKW.LogMessenger.
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27/ jnic_2014_11_26
public class OKWMessageNotFoundException extends RuntimeException 
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 4016537071569707340L;

	public OKWMessageNotFoundException()
    {
    }

    public OKWMessageNotFoundException(String message)
    {
    	super(message);
    }

}