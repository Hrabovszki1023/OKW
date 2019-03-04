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

/**\~german
 *  Diese Ausnahme wird ausgelöst, wenn mehr als ein GUI-Objekt zum gegeben Lokator gefunden wird.
 * 
 *  Folgende Gründe können Ursache sein, wenn der Lokator nicht (mehr) eindeutig ein Objekt identifiziert.
 *  <li>
 *   <item>Objekterkennungeigenschaft von Objekten hat sich geändert und muss angepasst werden.</item>
 *   <item>Es wurde eine Eigenschaft zur Objekterkennung herangezogen, die zur Laufzeit auch bei anderen GUI-Objekten passt.</item>
 *  </li>
 *  
 *  Um die Ausnahme OKWGUIObjectNotUniqueException zu verhindern muss der Locator eines Objketes nechgeschärft werden,
 *  dass dieser ausschliesslich das Gewünschte Objekt identifiziert.
 *  
 *  \~english
 *  This exception is triggered,
 *  if a GUI-object to the properties of the object identification given in the frame can not be found.
 *
 *  The reasons for triggering the exception can be as follows 
 *  -# Property of object identification in the <code>locator</code> has changed and must be customized.
 *  -# It was taken a property for object identification that is not constant to the operational time.
 *  -# The syncronisation lasts longer than the setted maximum time of delay of the object.
 * 
 *  \~
 *  @author Zoltán Hrabovszki
 *  @date 2019.04.24
 */
public class OKWGUIObjectNotUniqueException extends RuntimeException 
{

	private static final long serialVersionUID = 8115329818975080948L;

	public OKWGUIObjectNotUniqueException()
    {
    }

    public OKWGUIObjectNotUniqueException(String message)
    {
    	super(message);
    }
}