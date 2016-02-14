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
/// Diese Ausnahme <code>OKWFrameObjectIllegalNameCharacterException</code> wird ausgelöst,
/// wenn nicht erlaubte Zeichen im gegeben Frameobjektnamen enthalten ist.
/// 
/// \details 
/// __Beispiel: __<code>EN.SelectWindow("%&Login")</code> Die Zeichen "%&" sind
/// im fachlichen Bezeichner nicht erlaubt und es wird eine
/// <code>OKWFrameObjectIllegalNameCharacterException</code> ausgelöst.
/// 
/// \~english
/// \brief
/// This exeption <code>OKWFrameObjectIllegalNameCharacterException</code> is triggered,
/// if not allowed signs are conatined in the given frameobjectname.
/// \details
/// __Example: __<code>EN.SelectWindow("%&Login")</code> The signs "%&" are
/// not allowed in the professional identifier and a 
/// <code>OKWFrameObjectIllegalNameCharacterException</code> is triggered.
///
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27/ jnic_2014_11_27

public class OKWFrameObjectIllegalNameCharacterException extends RuntimeException 
{

	private static final long serialVersionUID = -7100296892695679790L;

	public OKWFrameObjectIllegalNameCharacterException()
    {
    }

    public OKWFrameObjectIllegalNameCharacterException(String message)
    {
    	super(message);
    }

}