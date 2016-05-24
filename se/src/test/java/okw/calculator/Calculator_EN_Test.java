/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 Zoltán Hrabovszki, IT-Beratung Hrabovszki
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
package okw.calculator;

import org.junit.After;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;


    @Ignore("Ignore the whole testfixture")
    public class Calculator_EN_Test
    {
    	OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();
    	
    	protected static String ApplicationName;
    	
        @Rule
        public TestName name = new TestName();
    	
        @After
        public void myAfter() throws Exception
        {
            EN.StopApp( ApplicationName );
            EN.EndTest();
        }

    	
        @Test
        public void TC_Calculator_Addition_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.SetValue("URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm");

            EN.SelectWindow("Calculator");
            EN.ClickOn("1");
            EN.ClickOn("+");
            EN.ClickOn("1");
            EN.ClickOn("=");

            EN.VerifyValue("Display", "2");
        }

        @Test
        public void AA_Calculator_Subtraktion_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm");

            EN.SelectWindow("Calculator");
            EN.ClickOn("1");
            EN.ClickOn("0");
            EN.ClickOn("0");
            EN.ClickOn("-");
            EN.ClickOn("1");
            EN.ClickOn("=");

            EN.VerifyValue("Display", "99");
        }

        @Test
        public void TC_Calculator_Multiplikation_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm");

            EN.SelectWindow("Calculator");
            EN.ClickOn("1");
            EN.ClickOn("2");
            EN.ClickOn("3");
            EN.ClickOn("*");
            EN.ClickOn("1");
            EN.ClickOn("2");
            EN.ClickOn("3");
            EN.ClickOn("=");

            EN.VerifyValue("Display", "15129");
        }

        
        @Test
        public void TC_Calculator_AllKeys_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm");

            EN.SelectWindow("Calculator");
            EN.ClickOn("1");
            EN.ClickOn("2");
            EN.ClickOn("3");
            EN.ClickOn("4");
            EN.ClickOn("5");
            EN.ClickOn("6");
            EN.ClickOn("7");
            EN.ClickOn("8");
            EN.ClickOn("9");
            EN.ClickOn("0");

            EN.VerifyValue("Display", "1234567890");
        }
        
        // 
        @Test
        public void Taschenrechner_AllKeyExists_EN() throws Exception
        {
            EN.BeginTest( name.getMethodName() );
            EN.StartApp( ApplicationName );
            EN.TypeKey("URL", "https://www2.informatik.hu-berlin.de/Themen/www/selfhtml/javascript/beispiele/anzeige/taschenrechner.htm");

            EN.SelectWindow("Calculator");
            EN.VerifyExists("1", "YES");
            EN.VerifyExists("2", "YES");
            EN.VerifyExists("3", "YES");
            EN.VerifyExists("4", "YES");
            EN.VerifyExists("5", "YES");
            EN.VerifyExists("6", "YES");
            EN.VerifyExists("7", "YES");
            EN.VerifyExists("8", "YES");
            EN.VerifyExists("9", "YES");
            EN.VerifyExists("0", "YES");

            EN.VerifyExists("Display", "YES");
        }
}