/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.core;

import okw.OKW_TestClipboard;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.Logger_Sngltn;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EN_Keywords_NOK_Test
{
    static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName          name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {

        Logger_Sngltn.getInstance();
        // Reset des Loggers: Alle geladenen Instanzen löschen
        Logger_Sngltn.init();

        // Log2Console myLog2Console = null;
        // myLog2Console = new Log2Console();
        // myLogger.AddLogger(myLog2Console);

        myLogger.setDebugMode( false );
    }

    /*
    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
        System.out.println( "===========================================================================" );
        System.out.println( "= Ausgabe in die Datei: 'EN_Keywords_Test.html'" );
        System.out.println( "===========================================================================" );
        //myLog2HTML.Result2HTML( "EN_Keywords_Test.html" );
        System.out.println( "===========================================================================" );
    }
    */

    /** \~german
     * Prüft methoden aufruf für einen einfachen Click.
     *
     * \~english
     * \~
     * @author Zoltan Hrabovszki
     * @date 2013.12.26
     * 
     * @throws Exception
     */
    @Test (expected= OKWFrameObjectMethodNotImplemented.class)
    public void tc_A_NOK_AllKeyWords() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );
        EN.ClickOn( "NoMethodObj" );
        //
        EN.ClickOn( "All_MethodsObj" );
        EN.DoubleClickOn( "All_MethodsObj" );
        
        EN.LogExists( "All_MethodsObj" );
        EN.LogHasFocus( "All_MethodsObj" );
        EN.LogIsActive( "All_MethodsObj" );
        EN.LogSelected( "All_MethodsObj" );
        EN.LogTablecellValue( "All_MethodsObj", "Col", "Row" );
        EN.LogTooltip( "All_MethodsObj" );
        EN.LogPlaceholder( "All_MethodsObj" );
        EN.LogLabel( "All_MethodsObj" );
        EN.LogCaption( "All_MethodsObj" );
        EN.LogValue( "All_MethodsObj" );

        EN.MemorizeExists( "All_MethodsObj", "Key_TC_MemorizeExists" );
        EN.MemorizeHasFocus( "All_MethodsObj", "Key_TC_Memorize_Focus" );
        EN.MemorizeIsActive( "All_MethodsObj", "TC_MemorizeIsActive" );
        EN.MemorizeSelectedValue( "All_MethodsObj", "TC_MemorizeSelectedValue_Key_1" );
        EN.MemorizeTablecellValue( "All_MethodsObj", "Col", "Row", "TC_MemorizeTablecellVelue_Key_1" );
        EN.MemorizeTooltip( "All_MethodsObj", "TC_MemorizeTooltip_Key_1" );
        EN.MemorizeCaption( "All_MethodsObj", "TC_MemorizeCaption_Key_1" );
        EN.MemorizePlaceholder( "All_MethodsObj", "TC_MemorizePlaceholder_Key_1" );
        EN.MemorizeLabel( "All_MethodsObj", "TC_MemorizeLabel_Key_1" );
        EN.MemorizeValue( "All_MethodsObj", "TC_Memorize_Key_1" );

        EN.SelectMenu( "All_MethodsObj" );
        EN.SelectMenu( "All_MethodsObj", "Wert 1${SEP}Wert 2${SEP}Wert 3" );
        EN.SelectMenu( "All_MethodsObj", "Hanna" );

        EN.SelectTablecell( "All_MethodsObj", "COL", "ROW" );


        EN.SelectChild( "All_MethodsObj" );
        EN.SetValue( "SELECTEDCHILD", "YES" );
        EN.SetFocus( "SELECTEDCHILD" );
        EN.Select( "All_MethodsObj", "Hanna${SEP}Zoltan" );
        EN.Sequence( "Rechner", "TestSequence_1", "SEQID_Test" );

        EN.SetFocus( "All_MethodsObj" );

        EN.TypeKey( "All_MethodsObj", "CTRL-C${SEP}CTRL-V" );
        EN.TypeKeyTablecell( "All_MethodsObj", "1", "2", "CTRL A" );

        // Window-Keywords
        EN.StartApp( "Rechner" );
        EN.SelectWindow( "Rechner" );
        EN.TypeKeyWindow( "Rechner", "Wert 1${SEP}Wert 2${SEP}Wert 3" );
        EN.StopApp( "Rechner" );

        EN.VerifyCaption( "All_MethodsObj", "The one and only Value" );
        EN.VerifyCaptionREGX( "All_MethodsObj", "\\w{3} one and only Value" );
        EN.VerifyCaptionWCM( "All_MethodsObj", "??? one and only Value" );

        EN.VerifyLabel( "All_MethodsObj", "The one and only VerifyLabel" );
        EN.VerifyLabelREGX( "All_MethodsObj", "\\w{3} one and only VerifyLabel" );
        EN.VerifyLabelWCM( "All_MethodsObj", "??? one and only VerifyLabel" );

        EN.VerifyMaxLength( "All_MethodsObj", "2" );
        EN.VerifyMinLength( "All_MethodsObj", "2" );

        EN.VerifyPlaceholder( "All_MethodsObj", "The one and only VerifyPlaceholder" );
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "\\w{3} one and only VerifyPlaceholder" );
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "??? one and only VerifyPlaceholder" );

        EN.VerifyExists( "All_MethodsObj", "YES" );
        EN.VerifyHasFocus( "All_MethodsObj", "YES" );
        EN.VerifyIsActive( "All_MethodsObj", "YES" );

        EN.VerifySelectedValue( "All_MethodsObj", "Sollwert_Einstellen" );
        EN.VerifySelectedValueWCM( "All_MethodsObj", "?ollwert_Einstellen" );
        EN.VerifySelectedValueREGX( "All_MethodsObj", "Sollwert_Einstellen" );

        EN.VerifyTablecellValue( "All_MethodsObj", "Col", "Row", "Sollwert_1" );
        EN.VerifyTablecellValueREGX( "All_MethodsObj", "Col", "Row", "Sollwert_1" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "Col", "Row", "Sollwert_1" );

        EN.VerifyTooltip( "All_MethodsObj", "The one and only Value" );
        EN.VerifyTooltipREGX( "All_MethodsObj", "\\w{3} one and only Value" );
        EN.VerifyTooltipWCM( "All_MethodsObj", "??? one and only Value" );

        EN.VerifyValue( "All_MethodsObj", "The one and only Value" );
        EN.VerifyValueWCM( "All_MethodsObj", "??? one and only Value" );
        EN.VerifyValueREGX( "All_MethodsObj", "\\w{3} one and only Value" );
        
        EN.VerifyBadge( "All_MethodsObj", "The one and only Value" );
        EN.VerifyBadgeWCM( "All_MethodsObj", "??? one and only Value" );
        EN.VerifyBadgeREGX( "All_MethodsObj", "\\w{3} one and only Value" );
        
        EN.VerifyErrorMSG( "All_MethodsObj", "The one and only Value" );
        EN.VerifyErrorMSG_WCM( "All_MethodsObj", "??? one and only Value" );
        EN.VerifyErrorMSG_REGX( "All_MethodsObj", "\\w{3} one and only Value" );
        
        // Datei Schlüsselwörter
        
        EN.EndTest();
    }
    
    @Test 
    public void tc_B_OK_AllKeyWords() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        // Testscript in Schlüsselwort-Notation
        EN.SelectWindow( "Rechner" );

        //
        EN.ClickOn( "All_MethodsObj" );
        EN.EndTest();
}

}
