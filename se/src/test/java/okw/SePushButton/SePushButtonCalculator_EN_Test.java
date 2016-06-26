/*
==============================================================================
Copyright © 2012, 2013, 2014, 2015, 2016 IT-Beratung Hrabovszki
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

package okw.SePushButton;

import okw.core.EN;

import org.junit.Ignore;
import org.junit.Test;

    /// \~german
    /// \brief
    /// Basisklasse für Test des GUI-Adapters SePushButton.
    /// 
    /// SePushButton_Chrome_Test, SePushButton_FireFox_Test usw. werden von diese Klasse abgeleitet.
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2015.02.28
    @Ignore("Ignoring the whole fixture")
    public class SePushButtonCalculator_EN_Test
    {

        @Test
        public void AA_Taschenrechner_DE() throws Exception
        {
            EN.TypeKey( "URL", "http://de.selfhtml.org/javascript/beispiele/anzeige/taschenrechner.htm");
            EN.SelectWindow("Taschenrechner");
            EN.ClickOn("1");
            EN.ClickOn("+");
            EN.ClickOn("1");
            EN.ClickOn("=");

            EN.VerifyValue("Anzeige", "2");
        }
    }

