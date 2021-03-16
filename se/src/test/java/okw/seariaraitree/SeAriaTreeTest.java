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
package okw.seariaraitree;

import org.junit.jupiter.api.Test;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;


/**
 * \~
 * @ingroup groupSeleniumChildGUIAdapterTests
 * 
 * @author zoltan
 */
public class SeAriaTreeTest extends OKWTestBase
{
	protected static String ApplicationName;

	protected String __cvsObjektName = "SeAriaRadio";

	protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();

	String myURL = "https://www.w3.org/TR/wai-aria-practices-1.1/examples/treeview/treeview-1/treeview-1b.html";

	@Test
	public void tcClickOn() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.ClickOn("MAXIMIZE");
		EN.TypeKey( "URL", myURL);

		//  
		EN.SelectWindow("SeAriaTree");

		EN.SetValue( "Tree", "Projects/project-3/project-3B.docx");
		EN.VerifyValue( "last_action", "project-3B.docx");
		
		EN.SetValue( "Tree", "Projects/project-3/project-3A.docx");
		EN.VerifyValue( "last_action", "project-3A.docx");
		
		EN.SetValue( "Tree", "Projects/project-3/project-3C.docx");
		EN.VerifyValue( "last_action", "project-3C.docx");
		

		EN.SetValue( "Tree", "Letters/letter-3/letter-3B.docx");
		EN.VerifyValue( "last_action", "letter-3B.docx");
		
		EN.SetValue( "Tree", "Letters/letter-1/letter-1B.docx");
		EN.VerifyValue( "last_action", "letter-1B.docx");
		
		EN.SetValue( "Tree", "Letters/letter-2/letter-2C.docx");
		EN.VerifyValue( "last_action", "letter-2C.docx");

		EN.SetValue( "Tree", "Projects/project-3/project-3B.docx");
		EN.VerifyValue( "last_action", "project-3B.docx");
		
		EN.SetValue( "Tree", "Projects/project-3/project-3A.docx");
		EN.VerifyValue( "last_action", "project-3A.docx");
		
		EN.SetValue( "Tree", "Projects/project-3/project-3C.docx");
		EN.VerifyValue( "last_action", "project-3C.docx");
		

		EN.SetValue( "Tree", "Letters/letter-3/letter-3B.docx");
		EN.VerifyValue( "last_action", "letter-3B.docx");
		
		EN.SetValue( "Tree", "Letters/letter-1/letter-1B.docx");
		EN.VerifyValue( "last_action", "letter-1B.docx");
		
		EN.SetValue( "Tree", "Letters/letter-2/letter-2C.docx");
		EN.VerifyValue( "last_action", "letter-2C.docx");
		
		EN.StopApp( ApplicationName );
		EN.EndTest();
	}

	// https://etics1.4dsoft.hu/test-elmu/misz3t/
	
	
	@Test
	public void tcElmueMenu() throws Exception
	{
		EN.BeginTest( TestName );
		EN.StartApp( ApplicationName );
		EN.ClickOn("MAXIMIZE");
		EN.TypeKey( "URL", "https://etics1.4dsoft.hu/test-elmu/misz3t/" );

		// Set start condition: Set All Checkboxes to "CHECKED" 
		EN.SelectWindow("Elmue Login");
		EN.SetValue( "User", "bernat");
		EN.SetValue( "Password", "bernat");
		EN.ClickOn("Belépés");

		EN.SelectWindow("ELMŰ");
		EN.ClickOn("KIMÈR");
		EN.ClickOn("Törzsadatok");


		// EN.SetValue( "Menue", "Felhasználó/Felhasználó karbantartása");
		EN.SetValue( "Menue", "Mérő/Mérő gyártó");
		// EN.SetValue( "Menue", "Felhasználó/Felhasználó karbantartása");
		EN.SetValue( "Menue", "Mérő/Mérő létrehozása");
		EN.SetValue( "Menue", "Plomba/Plombatiltás okok");
		
		
		EN.StopApp( ApplicationName );
		EN.EndTest();
	}
}