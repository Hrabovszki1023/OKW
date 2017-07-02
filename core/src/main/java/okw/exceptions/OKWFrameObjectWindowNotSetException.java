/*
==============================================================================
  Author: Zoltán Hrabovszki <zh@openkeyword.de>

  Copyright © 2012 - 2017 IT-Beratung Hrabovszki
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
/// Diese Ausnahme wird ausgelöst, wenn kein Fenster
/// Objekt ausgewählt/gesetzt worden ist bevor ein Kindobjekt ausgeführt 
/// werden kann.
/// 
/// \details
/// Um mit dem Kindobjekt eines Fenster zu interagieren, _muss_ zunächst das 
/// Fenster-Objekt ausgewählt werden. Wurde das Fenster Objekt noch nicht gesetzt,
/// dann wird diese Ausnahmebehandlung ausgelöst.
/// 
/// \remark
/// Wurde ein Festerobjekt bereits einmal ausgewählt und danach wurde vergessen, 
/// dass der Kontext auf ein neues Fenster gesetzt wurde, dann wird die 
/// Ausnahmebehandlung <code>OKW.OKWFrameObjectChildNotFoundException</code> ausgelöst.
///
/// \~english
/// \brief
/// This exception is triggered, if no window object is selected or set before a child
/// object is to be processed.
/// 
/// \details
/// To interact with the child object of a window there _must_ be selected first of all the window object.
/// If the window object has not been set, then the exception is to be triggered.
/// 
/// \remark
/// If the window object was selected once and after that it was forgotten, that the context
/// was set on a new window, the Exception <code>OKW.OKWFrameObjectChildNotFoundException</code> is triggered.
///
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04./ jnic_2014_11_27
public class OKWFrameObjectWindowNotSetException extends RuntimeException
{
	private static final long serialVersionUID = -1364288228996230519L;

	public OKWFrameObjectWindowNotSetException()
    {
    }

    public OKWFrameObjectWindowNotSetException(String message)
    {
    	super(message);
    }
}