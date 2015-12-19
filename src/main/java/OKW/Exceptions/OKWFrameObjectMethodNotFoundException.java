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
package OKW.Exceptions;

/// \~german
/// \brief
/// Die Ausnahme <code>OKWFrameObjectMethodNotFoundException</code> wird ausgelöst, 
/// wenn im Frame Objekt eine gegebene Methode nicht implementiert ist.
/// \details
/// Eine OKW-Methode kann fehlen, wenn 
/// -# eine projektspezifisches Objekt definiert wird
/// -# eine Methode noch nicht in der OKW-GUI-Klasse implementiert worden ist.
/// \todo TODO: jnic Text war unlogisch, wurde verändert - bitte prüfen (auch in Übersetzung)
/// 
/// Die fehlende Methode muss dann ggf. implementiert werden. Die Ausnahmebehandlung gibt Hinweise darüber
/// _welche_ Methode fehlt und noch implementiert werden muss.
/// 
/// \~english
/// \brief
/// The exeption <code>OKWFrameObjectMethodNotFoundException</code> is triggered, 
/// if a given method is not implemented in the frame object.
/// \details 
/// An OKW-Methode can be missed, if 
/// -# a project specific object is to be defined...
/// -# a method is not implemented in the OKW-GUI-classes
/// \todo TODO: jnic text was not logical and was corrected - please proove it
/// 
/// The missing method must bei possibly implemented. The Exception gives hints about
/// _what_ method is missing and to be implemented.
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27
public class OKWFrameObjectMethodNotFoundException extends RuntimeException 
{

	private static final long serialVersionUID = -2374148675439496162L;

	public OKWFrameObjectMethodNotFoundException()
    {
    }

    public OKWFrameObjectMethodNotFoundException(String message)
    {
    	super(message);
    }
}