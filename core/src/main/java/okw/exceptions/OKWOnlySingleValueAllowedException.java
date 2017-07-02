
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

/**
 *  \~german
 *  <code>OKWOnlySingleValueAllowedException</code>-Ausnahme wird ausgelöst, wenn nur Wert erlaubt ist.<br/>
 *
 *  Beispiel:<br/>
 *  
 *  <code>EN.Select( "Geschlecht", "weiblich${SEP}männlich" )</code> - Ein Radiolist erlaubt naturgemäß nur die Auswahl eines
 *  einzigen Wertes.
 *  Wird, wie im Beispiel, mehr als ein Wert ausgewählt, dann wird <code>OKWOnlySingleValueAllowedException</code> ausgelöst. 
 *  Diese Ausnahme wird typischerweise vom GUI-Adapter (Beispiel: SeRadioList) und nicht von den Core-Klassen ausgelöst.
 *  - In der Aufrufhierarchie wird erst im GUI-Adapter deutlich, wieviele Werte in einem GUI-Object ausgewählt werden können.
 *  
 *  \~english
 *  <code>OKWOnlySingleValueAllowedException</code> - exception is triggered, if a given value in the keyword is
 *  not allowed.<br/>
 *  Example:<br/>
 *  
 *  <code>EN.Select( "MyCheckbox", "House" )</code> - A radiolist, of course, allows only the selection of a single value.
 *  If, as in the example, more than one value is selected, the exception <code>OKWOnlySingleValueAllowedException</code> is thrown.</br>
 *  This exception is typically triggered by a GUI adapter (example: SeRadioList) and not by the core classes.
 *  - In the call hierarchy, the GUI adapter shows how many values can be selected in a GUI object.
 *  \~
 *  @author Zoltán Hrabovszki
 *  @date 2016.11.11
 */
public class OKWOnlySingleValueAllowedException extends RuntimeException {

	private static final long serialVersionUID = -8984438888513262427L;

	public OKWOnlySingleValueAllowedException() {
		super();
	}

	public OKWOnlySingleValueAllowedException(String message) {
		super(message);
	}

}
