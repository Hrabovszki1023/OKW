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

package okw.exceptions;

/// \~german
/// \brief
/// OKW.OKWFrameObjectChildNotFoundException wird ausgelöst, 
/// wenn die Frame-Definition eines Kind-Objektes nicht gefunden wird.
/// 
/// \details
/// __Anmerkung:__ Diese Exception wird sehr wahrscheinlich ausgelöst, weil...
/// -# der fachliche Bezeichner des Kind-Objektes im Schlüsselwort einen Tipp-Fehler enthält.
/// -# das Kind-Objekt im Frame nicht definiert ist.
///
/// \~english
/// \brief
/// OKW.OKWFrameObjectChildNotFoundException is triggered, 
/// if the Frame-Definition of a child object is not found.
/// 
/// \details
/// __Annotation:__ This exception is likely triggered, because...
/// -# the professional identifierof the child object in the key word contains a typing error.
/// -# the child object is not defined in in the frame.
///
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27
public class OKWFrameObjectChildNotFoundException extends RuntimeException
{

	private static final long serialVersionUID = 4248080362146234825L;

	public OKWFrameObjectChildNotFoundException()
    {
    }

    public OKWFrameObjectChildNotFoundException(String message)
    {
    	super(message);
    }
}