
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
/// <code>OKWNotAllowedValueException</code>-Ausnahme wird ausgelöst, wenn ein gegebener Wert im 
/// Schlüsselwort nicht erlaubt ist.<br>
/// Beispiel:<br>
/// 
/// <code>EN.Select( "MyCheckbox", "Haus" )</code> - bei einer CheckBox sind nur die Werte CHECKED/UNCHECKED erlaubt.
/// Bei allen anderen Werten wird <code>OKWNotAllowedValueException</code> ausgelöst.
/// 
/// \~english
/// \brief
/// <code>OKWNotAllowedValueException</code>-exception is triggered, if a given value in the keyword is
/// not allowed.<br>
/// Example:<br>
/// 
/// <code>EN.Select( "MyCheckbox", "House" )</code> - at a checkbox only the values CHECKED/UNCHECKED are permitted.
/// With all other values <code>OKWNotAllowedValueException</code> is triggered.
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2014.04.27/ jnic_2014_11_27
public class OKWNotAllowedValueException extends RuntimeException {

	private static final long serialVersionUID = -8984438888513262427L;

	public OKWNotAllowedValueException() {
		super();
	}

	public OKWNotAllowedValueException(String message) {
		super(message);
	}

    public OKWNotAllowedValueException(String message, Throwable e) {
        super(message, e);
    }

}
