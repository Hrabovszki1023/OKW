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

package okw.core;

import java.io.File;

import okw.OKWTestBase;
//import okw.OKW_FileHelper;
import okw.OKW_Memorize_Sngltn;
import okw.OKW_TestClipboard;
import okw.exceptions.OKWFileDoesNotExistsException;
import okw.exceptions.OKWNotAllowedValueException;
import okw.exceptions.OKWVerifyingFailsException;
import okw.log.Logger_Sngltn;

import org.junit.jupiter.api.*;

@Tag("AllCoreTests")
public class EN_FileKeywords_Test extends OKWTestBase
{
    static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @BeforeAll
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
    @AfterAll
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
     *  Prüft das Schlüsselwort EN.FileDelete(String).
     *  
     *  Prüft ob eine existierende Datei Gelöscht wird.
     *  
     *  Test Ablauf:
     *  -# Zuerst löschen, wenn die Datei existiert.
     *  -# Datei erstellen
     *  -# Datei muss vorhanden sein
     *  -# Datei löschen
     *  -# Datei darf nicht existieren
     *  
     *  \~english
     *  Checks the keyword EN.FileDelete(String).
     *  
     *  Checks if an existing file is deleted.
     *  
     *  Test procedure:
     *  -# Delete first, if the file exists
     *  -# Create file
     *  -# File must be present
     *  -# Delete File
     *  -# File must not exist
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void FileDelete() throws Exception
    {

    	EN.BeginTest( TestName );
        
        EN.SetVar( "TestBaseDir", "target/${TCN}" );
        EN.SetVar( "TargetFile", "${TestBaseDir}/myFileDelete.txt" );
        
        // Delete first if the file exists. (Precondition)
        EN.FileDelete( "${TargetFile}" );
        
        EN.DirectoryCreate( "${TestBaseDir}" );
        
        
        OKW_Memorize_Sngltn.getInstance().get( "TargetFile" );
        
        // Create file
        File f = new File( OKW_Memorize_Sngltn.getInstance().get( "TargetFile" ) );
        f.createNewFile();
        
        // File must be present...
        EN.VerifyFileExists( "${TargetFile}", "YES" );
        
        // Delete File
        EN.FileDelete( "${TargetFile}" );
        // File must not exist
        EN.VerifyFileExists( "${TargetFile}", "NO" );
        
        EN.EndTest();
    }
    
    //@Test FIXME: Testfall einschalten
    public void FileDelete_Wildcard() throws Exception
    {
        String myFile_1 = "myFile_1.txt";
        String myFile_2 = "myFile_2.txt";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.FileDelete( myFile_1 );
        EN.FileDelete( myFile_2 );
        
        // Create file
        File f = new File( myFile_1 );
        f.createNewFile();
        
        f = new File( myFile_2 );
        f.createNewFile();
        
        // File must be present...
        EN.VerifyFileExists( myFile_1, "YES" );
        EN.VerifyFileExists( myFile_2, "YES" );
        
        // Delete File
        EN.FileDelete( "myFile*.txt" );
        // File must not exist
        EN.VerifyFileExists( myFile_1, "NO" );
        EN.VerifyFileExists( myFile_2, "NO" );
        
        EN.EndTest();
    }
    
    
    //@Test FIXME: Testfall einschalten
//    public void FileDelete_WildCard() throws Exception
//    {
//        EN.DirectoryCreate( "target/FileDelete_WildCard/mydir" );
//
//        // Create file
//        File f = new File( "target/FileDelete_WildCard/sample_1.txt" );
//        f.createNewFile();
//
//        f = new File( "target/FileDelete_WildCard/sample_2.txt" );
//        f.createNewFile();
//
//        f = new File( "target/FileDelete_WildCard/mydir/sample_3.txt" );
//        f.createNewFile();
//        
//        File[] myFiles = ( File[] ) OKW_FileHelper.ListFiles( "target/FileDelete_WildCard").toArray();
//        
//        for (int i=0; i<myFiles.length; i++) {
//
//            File f = dirs[i];
//            if (dir.isDirectory()) {
//                File[] files = dir.listFiles(new WildcardFileFilter("sample*.java"));
//            }
//         }
//        
//    }
    
    /** \~german
     *  Prüft das Schlüsselwort EN.FileDelete(String).
     *  
     *  Prüft ob eine _nicht_ existierende Datei, die zum löschen
     *  frei gegeben wird keine ausnahme auslöst.
     *  
     *  Test Ablauf:
     *  -# Erstmal löschen, falls die Datei vorhanden sein sollte.
     *  -# Datei darf jetzt nicht mehr existieren.
     *  -# Erneutes löschen darf keine Ausnahme auslösen
     *  
     *  \~english
     *  Checks the keyword EN.FileDelete(String).
     *  
     *  Checks if a _not_ existing file released for deletion does not raise an exception.
     *  
     *  Test procedure:
     *  -# Delete first if the file exists.
     *  -# file must no longer exist.
     *  -# Delete again must not raise an exception
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void FileDelete_Not_Exists() throws Exception
    {
        String myFile = "myFileDeleteDoesNotExist.txt";
        
        EN.BeginTest( TestName );
     
        EN.SetVar( "TestBaseDir", "Val" );
        // Delete first if the file exists. (Precondition)
        EN.FileDelete( myFile );
        
        // File must no longer exist...
        EN.VerifyFileExists( myFile, "NO" );

        // Delete again must not raise an exception.
        EN.FileDelete( myFile );
        
        EN.EndTest();
    }

    
    /** \~german
     *  Prüft das Schlüsselwort EN.FileDelete(String), ob bei "${IGNORE}" _nichts_ passiert.
     *
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void FileDelete_IGNORE() throws Exception
    {
        String myFile = "myFileDelete.txt";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.FileDelete( myFile );
        
        // Create file
        File f = new File( myFile );
        f.createNewFile();
        
        // File must be exists
        EN.VerifyFileExists( myFile, "YES" );
        
        // Start AC
        // Execute with ${IGNORE}
        EN.FileDelete( "${IGNORE}" );
        EN.VerifyFileExists( myFile, "YES" );

        // Execute with "", this corresponds to ${IGNORE} or is an alternative to it
        EN.FileDelete( "" );
        EN.VerifyFileExists( myFile, "YES" );
        
        //End AC

        // Clean up now (Postcondition)
        EN.FileDelete( myFile );
        EN.VerifyFileExists( myFile, "NO" );

        EN.EndTest();
    }
    
    
    /** \~german
     *  Prüft das Schlüsselwort EN.VerifyFileExists(String), ob bei "${IGNORE}" _nichts_ passiert.
     *
     *  Testablauf:
     *  
     *  -# Es wird ein Sollwert eineggeben , welches _nicht_ "YES/NO" entspricht
     *  
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  
     *  Test procedure:
     *  
     *  -# An expected value is entered, which _not_ corresponds to "YES/NO
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void VerifyFileExists_OKWNotAllowedValueException() throws Exception
    {
        String myFile = "myFileDelete.txt";
        
        EN.BeginTest( TestName );
        
        // This expected value is not allowed...
        EN.VerifyFileExists( myFile, "abc" );
        
        Assertions.assertThrows( OKWNotAllowedValueException.class, () ->
        {
            EN.EndTest();
        });
    }
    
    
    /** \~german
     *  Prüft das Schlüsselwort EN.VerifyIsFile(String,String)
     *  
     *  
     *  Testablauf:
     *  
     *  -# Es wird ein Sollwert eineggeben , welches _nicht_ "YES/NO" entspricht
     *  
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  
     *  Test procedure:
     *  
     *  -# Delete first if the file exists. (Precondition)
     *  -# Create file
     *  -# File must be present...
     *  -# Expected: Pfad ist eine Datei...
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void VerifyIsFile() throws Exception
    {
        String myFile = "myFileDelete.txt";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.FileDelete( myFile );
        
        // Create file
        File f = new File( myFile );
        f.createNewFile();
        
        // File must be present...
        EN.VerifyFileExists( myFile, "YES" );
        
        // 
        EN.VerifyIsFile( myFile, "YES" );
        
        EN.EndTest();
    }
    
    
    /** \~german
     *  Prüft das Schlüsselwort EN.VerifyIsFile(String,String)
     *  
     *  
     *  Testablauf:
     *  
     *  -# Es wird ein Sollwert eineggeben , welches _nicht_ "YES/NO" entspricht
     *  
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  
     *  Test procedure:
     *  
     *  -# Delete first if the file exists. (Precondition)
     *  -# Create file
     *  -# File must be present...
     *  -# Expected: Pfad ist keine Datei...
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-05-17
     */
    @Test
    public void VerifyIsFile_No() throws Exception
    {
        String myFile = "myDir";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.DirectoryDelete( myFile );
        
        // Create file
        File f = new File( myFile );
        f.mkdir();
        
        // File must be present...
        EN.VerifyDirectoryExists( myFile, "YES" );
        
        // Pfad ist keine Datei...
        EN.VerifyIsFile( myFile, "NO" );
        
        EN.EndTest();
    }
    
    
    /** \~german
     *  Prüft das Schlüsselwort EN.VerifyIsFile(String,String)
     *  
     *  Pfad Existiert ist aber keine Datei.
     *  
     *  Testablauf:
     *  
     *  -# Es wird ein Sollwert eineggeben , welches _nicht_ "YES/NO" entspricht
     *  
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  
     *  Test procedure:
     *  
     *  -# Delete first if the file exists. (Precondition)
     *  -# Create file
     *  -# File must be present...
     *  -# Expected: Pfad ist keine Datei...
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-12-01
     */
    @Test
    public void VerifyIsFile_OKWVerifyingFailsException() throws Exception
    {
        String myFile = "myDir";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.DirectoryDelete( myFile );
        
        // Create file
        File f = new File( myFile );
        f.mkdir();
        
        // File must be present...
        EN.VerifyDirectoryExists( myFile, "YES" );
        
        // Pfad ist keine Datei...
        EN.VerifyIsFile( myFile, "YES" );
        
        Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });
    }
   
    
    /** \~german
     *  Prüft das Schlüsselwort EN.VerifyIsFile(String,String)
     *  
     *  Pfad existiert _nicht_,  Es wird Geprüft ob es eine Datei ist.
     *  
     *  Testablauf:
     *  
     *  -# Es wird ein Sollwert eineggeben , welches _nicht_ "YES/NO" entspricht
     *  
     *  \~english
     *  Checks the FileDelete keyword to see if "${IGNORE}" does _nothing_ happen.
     *  
     *  Test procedure:
     *  
     *  -# Delete first if the file exists. (Precondition)
     *  -# Create file
     *  -# File must be present...
     *  -# Expected: Pfad ist keine Datei...
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-12-01
     */
    @Test
    public void VerifyIsFile_OKWFileDoesNotExistsException() throws Exception
    {
        String myFile = "myDir";
        
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.DirectoryDelete( myFile );

        // File must be present...
        EN.VerifyDirectoryExists( myFile, "NO" );
        
        // Pfad ist keine Datei...
        EN.VerifyIsFile( myFile, "YES" );
        
        Assertions.assertThrows( OKWFileDoesNotExistsException.class, () ->
        {
            EN.EndTest();
        });
    }
    
   
    
    /** \~german
     *  Prüft das Schlüsselwort EN.DirectoryCreate(String)
     *  
     *  Legt zwei Verzeichnisse an und es wird Geprüft ob diese anschkiessend Vorhanden sind.
     *  
     *  Testablauf:
     *  
     *  -# Löschen des Zielpfades mit EN.DirectoryDelete(String)
     *  -# Anlegen des 1. Zielpfades "path1/path11"
     *  -# Prüfen ob die Verzeichnisse vorhanden sidn
     *  -# Anlegen des 2. Zielpfades "path1/path11"
     *  -# Prüfen ob das 1. und das 2. Verzeichniss vorhanden sind.
     *
     *  \~english
     *  Checks the keyword EN.DirectoryCreate(String)
     *  
     *  Creates two directories and checks if they are available afterwards.
     *  
     *  Test procedure:
     *  
     *  -# Delete target path with EN.DirectoryDelete(String)
     *  -# Creation of the 1st target path "path1/path11"
     *  -# Check whether the directories exist
     *  -# Creation of the 2nd target path "path1/path11"
     *  -# Check whether the 1st and 2nd directories exist.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-12-01
     */
    
    @Test
    public void DirectoryCreate() throws Exception
    {
        EN.BeginTest( TestName );
        
        // Delete first if the file exists. (Precondition)
        EN.DirectoryDelete( "path1" );
        EN.VerifyDirectoryExists( "path1", "NO" );
        
        EN.DirectoryCreate( "path1/path11" );
                
        // Directory must be present...
        EN.VerifyDirectoryExists( "path1", "YES" );
        EN.VerifyDirectoryExists( "path1/path11", "YES" );
        
        EN.DirectoryCreate( "path1/path12/path121" );

        EN.VerifyDirectoryExists( "path1", "YES" );

        EN.VerifyDirectoryExists( "path1/path11", "YES" );
        EN.VerifyDirectoryExists( "path1/path12", "YES" );

        EN.VerifyDirectoryExists( "path1/path12/path121", "YES" );
        
        EN.EndTest();
    }

}
