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

package okw.exceptions;

/// \~german
/// \brief
/// <code>OKWDirectoryDoesNotExistsException</code>-Ausnahme wird ausgelöst, 
/// wenn ein Verzeichniss nicht gefunden worden ist.<br>
/// 
/// \~english
/// \brief
/// <code>OKWDirectoryDoesNotExistsException</code>-Exeption is triggered, 
/// if a data is not found.<br>
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27/ jnic_2014_11_26

public class OKWDirectoryDoesNotExistsException extends RuntimeException {

	private static final long serialVersionUID = -1734767833783821635L;

	public OKWDirectoryDoesNotExistsException() {
	}

	public OKWDirectoryDoesNotExistsException(String message) {
		super(message);
	}

}
