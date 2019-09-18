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

import java.io.File;

import okw.OKW_TestClipboard;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class EN_FileKeywords_Test
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

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
        EN.EndTest();
    }

    
    /** \~german
     *  Prüft das Schlüsselwort File.
     *
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void FileDelete() throws Exception
    {
        String myFile = "myFileDelete.txt";
        
        EN.BeginTest( name.getMethodName() );
        // Testscript in Schlüsselwort-Notation
        //
        
        EN.FileDelete( myFile ); // Erstmal löschen... Falls vorhanden
        
        // Datei anlegen
        File f = new File( myFile );
        f.createNewFile();
        
        // Datei muss Vorhanden sein...
        EN.VerifyFileExists( myFile, "YES" );
        
        // Test State 
        EN.FileDelete( myFile );
        EN.VerifyFileExists( myFile, "NO" );
        
        EN.EndTest();
    }
    
    /** \~german
     *  Prüft das Schlüsselwort File.
     *
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void FileDelete_EMPTY() throws Exception
    {
        String myFile = "myFileDelete.txt";
        
        EN.BeginTest( name.getMethodName() );
        // Testscript in Schlüsselwort-Notation
        //
        
        EN.FileDelete( myFile ); // Erstmal löschen... Falls vorhanden
        
        // Datei anlegen
        File f = new File( myFile );
        f.createNewFile();
        
        // Datei muss Vorhanden sein...
        EN.VerifyFileExists( myFile, "YES" );
        
        // Test State 
        EN.FileDelete( "IGNOR" );
        EN.VerifyFileExists( myFile, "YES" );

        // Test State 
        EN.FileDelete( "" );
        EN.VerifyFileExists( myFile, "YES" );

        EN.EndTest();

    }

}
