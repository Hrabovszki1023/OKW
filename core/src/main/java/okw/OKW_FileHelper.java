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
package okw;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import okw.exceptions.OKWDirectoryDoesNotExistsException;
import okw.exceptions.OKWDirectorySeperatorNotImplementedException;
import okw.exceptions.OKWFileDoesNotExistsException;
import okw.log.Logger_Sngltn;

/** \~german
 *  OKW_FileHelper enthält FilfsMethoden für die Handhabung von Dateien und Verzechnissen..
 *  
 *  \~english
 *  \~
 *  @author Zoltan Hrabovszki
 *  \date 2013-12-30
 */
public class OKW_FileHelper
{
    /**
     * \~german
     *  Instanz der Zentralen Loggerklasse.
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2017-07-06
     */
    private static Logger_Sngltn Log = Logger_Sngltn.getInstance();

    /**
     *   \copydoc OKW_CurrentObject_Sngltn::LM()
     */
    // private static LogMessenger LM = new LogMessenger("OKW_FileHelper");

    /**
     * \~german
     *  Erzeugt ein leeres Verzechniss mit dem angegebenen Pfad.
     * 
     *  Endbedingung: Nachdem Aufruf existiert ein leeres Verzeichniss mit dem gegebenen Pfad.
     *  
     *  -# Existiert das Verzeichniss nicht, dann wird ein (leeres) Verzeichniss angelegt.
     *  -# Existiert das Verzeichniss, dann wird dieser rekursiv gelöscht und neu angelegt.
     *  
     *  @param fpsPath Pfad des Verzeichnisses, welches Angelegt werden soll.
     *  
     *  @return true wenn ein leeres Verzeichniss erfolgreich angelegt worden ist, sonst false.
     *  
     *  \~english
     *  Creates an empty directory with the specified path.
     * 
     *  End condition: After call an empty directory exists with the given path.
     *  
     *  -# If the directory does not exist, an (empty) directory is created.
     *  -# If the directory exists, it is deleted recursively and recreated.
     *  
     *  @param fpsPath Path of the directory which is to be created.
     *  
     *  @return true if an empty directory has been successfully created, otherwise false.
    
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013-12-30
     */
    public static Boolean createEmptyDirectory( String fpsPath )
    {

        String lvsPath = "";
        Boolean lvbReturn = false;

        try
        {
            // lvsPath = MyParser.ParseMe(fpsPath);
            Log.LogFunctionStart( "DirectoryCreateEmpty", "String", fpsPath );

            File myDirectory = new File( fpsPath );

            // Determine whether the directory exists.
            if ( myDirectory.exists() & myDirectory.isDirectory() )
            {
                deleteDirectory( lvsPath );
            }
            else if ( myDirectory.exists() & myDirectory.isFile() )
            {
                deleteFile( lvsPath );
            }

            // Try to create the directory.
            myDirectory.mkdirs();

            lvbReturn = true;

        }
        catch (Exception e)
        {
            Log.LogPrint( "The process failed:" );
        }
        finally
        {
            Log.LogFunctionEnd( lvbReturn );
        }
        return lvbReturn;
    }

    /** \~german
     *  Löschent rekursiv alle Dateien und Unterverzeichnisse und das gegebenen
     *  Verzeichniss selbst.
     * 
     *  Endbedingung: Verzeichniss exsitiert einschliesslich aller Dateien und
     *  Unterverueichnisse nachdem Aufruf nicht mehr.
     *  
     *  -# Existiert das Verzeichniss nicht, dann ist die Endbedingung bereits erfüllt. 
     *     Es wird keine weitere Aktion durchgeführt. Methode wird ohne Fehler beenden.
     *  -# Existiert das Verzeichniss, dann wird dieser rekursiv mit dem gesamten Inhalt gelöscht.
     *  
     *  \param fpsPath
     *  
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013-12-30
     */
    public static void deleteDirectory( String Path )
    {
        String lvsPath = Path;
        Boolean lvbReturn = false;

        Log.LogFunctionStartDebug( "OKW_Helper.DirectoryDelete", "Path", Path );

        try
        {

            // \todo TODO: ANTLR-Paser einschalten
            // lvsPaFiNa = MyParser.ParseMe(lvsPaFiNa);

            File myPath = new File( lvsPath );

            if ( myPath.exists() )
            {
                for ( File f : myPath.listFiles() )
                {
                    if ( f.isDirectory() )
                    {
                        deleteDirectory( f.getPath() );
                        f.delete();
                    }
                    else
                    {
                        f.delete();
                    }
                }
                myPath.delete();
            }
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn );
        }
    }

    /** \~german
     *  Prüft, ob die gegebene _fpsPaFiNa_ Datei existiert.
     * 
     *  \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der zulöschenden Datei.
     *  \return true, falls die Datei existiert, sonst false.
     *  
     *  \~english
     *  Checks if the given _fpsPaFiNa_ file exists.
     * 
     *  \param fpsPaFiNa PathAndFileName: Specifies the complete path of the file to be deleted.
     *  \return true, if the file exists, otherwise false.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.30
     */
    public static Boolean directoryExists( String fpsPaFiNa )
    {
        Boolean lvbReturn = false;

        Log.LogFunctionStartDebug( "OKW_FileHelper.DirectoryExists", "fpsPaFiNa", fpsPaFiNa );

        try
        {
            // \todo TODO: ANTLR-Paser einschalten
            // lvsPaFiNa = MyParser.ParseMe(lvsPaFiNa);

            File myFile = new File( fpsPaFiNa );

            // Existiert "fpsPaFiNa"?
            if ( myFile.exists() )
            {
                // Ist ein Verzeichniss?
                if ( myFile.isDirectory() )
                {
                    lvbReturn = true;
                }
                // Ist es eine Datei?
                else if ( myFile.isFile() )
                {
                    throw ( new OKWFileDoesNotExistsException( "This is not a directory! Given path is a directory!" ) );
                }
                // Dann Existiert "fpsPaFiNa" nicht!
                else
                {
                    lvbReturn = false;
                }
            }
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    public static void copyDirectory( String fpsSourceFolder, String fpsDestinationFolder )
    {
        // Source directory which you want to copy to new location
        File sourceFolder = new File( fpsSourceFolder );

        // Target directory where files should be copied
        File destinationFolder = new File( fpsDestinationFolder );

        copyDirectory( sourceFolder, destinationFolder );

    }

    private static boolean copyDirectory( File fpSourceFolder, File fpDestinationFolder )
    {

        Boolean lvbReturn = false;

        try
        {
            // \todo TODO: ANTLR-Paser einschalten
            // lvsPaNaSource = MyParser.ParseMe(fpsPaNaSource);
            // lvsPaNaDestination = MyParser.ParseMe(fpsPaNaDestination);

            Log.LogFunctionStartDebug( "OKW_FileHelper.DirectoryMove", "fpSourceFolder", fpSourceFolder.getPath(), "fpDestinationFolder",
                            fpDestinationFolder.getPath() );

            // Check if sourceFolder is a directory or file
            // If sourceFolder is file; then copy the file directly to new
            // location
            if ( fpSourceFolder.isDirectory() )
            {
                // Verify if destinationFolder is already present; If not then
                // create it
                if ( !fpDestinationFolder.exists() )
                {
                    fpDestinationFolder.mkdir();
                    System.out.println( "Directory created :: " + fpDestinationFolder );
                }

                // Get all files from source directory
                String files[] = fpSourceFolder.list();

                // Iterate over all files and copy them to destinationFolder one
                // by one
                for ( String file : files )
                {
                    File srcFile = new File( fpSourceFolder, file );
                    File destFile = new File( fpDestinationFolder, file );

                    // Recursive function call
                    copyDirectory( srcFile, destFile );
                }
            }
            else
            {
                // Copy the file content from one place to another
                Files.copy( fpSourceFolder.toPath(), fpDestinationFolder.toPath(), StandardCopyOption.REPLACE_EXISTING );
                System.out.println( "File copied :: " + fpDestinationFolder );
            }
        }
        catch (IOException e)
        {
            Log.LogPrintDebug( e.getMessage() );
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    /**  \~german
     *  \brief
     *  Verzeichniss verschieben löschen des gegebenen Verzeichnisses..
     * 
     *  \param fpsPaNaSource Pfad des Quell-Verzeichnisses.
     *  \param fpsPaNaDestination Pfad des Ziel-Verzeichnisses.
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.30
     */
    public static boolean moveDirectory( String fpsPaNaSource, String fpsPaNaDestination ) throws IOException, FileNotFoundException
    {
        Boolean lvbReturn = false;

        String lvsPaNaSource = fpsPaNaSource;
        String lvsPaNaDestination = fpsPaNaDestination;

        try
        {
            // \todo TODO: ANTLR-Paser einschalten
            // lvsPaNaSource = MyParser.ParseMe(fpsPaNaSource);
            // lvsPaNaDestination = MyParser.ParseMe(fpsPaNaDestination);

            Log.LogFunctionStartDebug( "OKW_FileHelper.DirectoryMove", "fpsPaNaSource", fpsPaNaSource, "fpsPaNaDestination", fpsPaNaDestination );

            if ( directoryExists( lvsPaNaSource ) )
            {
                // Löschen des ZIEL-verzeichnissen wenn vorhanden
                deleteDirectory( lvsPaNaDestination );

                // Copy with subfolders
                copy( lvsPaNaSource, lvsPaNaDestination, true );

                // Delete Source
                deleteDirectory( lvsPaNaSource );

                lvbReturn = true;
            }
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn );
        }

        return lvbReturn;
    }

    public static void copy( String fpsSource, String fpsDestination, Boolean copySubDirs ) throws IOException, FileNotFoundException
    {
        Path lvSourcePath = Paths.get( fpsSource );
        Path lvDestinationPath = Paths.get( fpsDestination );

        if ( Files.notExists( lvSourcePath ) )
        {
            throw new FileNotFoundException( "Source directory does not exist or could not be found: " + fpsSource );
        }

        else
        {

            Files.copy( lvSourcePath, lvDestinationPath );
        }
    }


    /**
     * @param fpsPath
     * @return
     */
    public static ArrayList<File> ListFiles( String fpsPath )
    {
        ArrayList<File> lvReturn = new ArrayList<File>();

        File root = new File( fpsPath );
        File[] list = root.listFiles();

        if ( list != null )
        {
            ;

            for ( File f : list )
            {
                if ( f.isDirectory() )
                {
                    System.out.println( " Dir:" + f.getAbsolutePath() );
                    ListFiles( f.getAbsolutePath() );
                }
                else
                {
                    String myPathy = f.getAbsolutePath();
                    Log.LogPrint( "File:" + myPathy );
                    lvReturn.add( f );
                }
            }
        }

        return lvReturn;
    }
    
    
    /**
    *  \~german
    *  Löscht alle Dateien des gegebenen Musters im gegebenen Verzeichniss Rekursive. Die
    *  Verzeichnisstruktur bleibt erhalten.
    * 
    *  https://stackoverflow.com/a/794883
    *  https://www.rgagnon.com/javadetails/java-0072.html
    * 
    *  \param fpsPaFiNa Pfad und Name der Datei. Wildcards * und ? sind
    *  erlaubt.
    *  \return
    * 
    *  \~english
    *  \brief \todo TODO: Brief Description.
    * 
    *  \todo TODO: Detailed Description
    * 
    *  \param
    *  \return
    * 
    *  \~
    *  \author Zoltán Hrabovszki
    *  \date 2015.08.22
    */
    public static void deleteFiles( String fpsPaFiNa )
    {

        if ( directoryExists( fpsPaFiNa ) )
        {
            File myDir = new File( fpsPaFiNa );
            File[] listOfFiles = myDir.listFiles();

            for ( File myFileToDelete : listOfFiles )
            {
                if ( !myFileToDelete.isDirectory() )
                {
                    myFileToDelete.delete();
                }
            }
        }
    }

    /**
    *  \~german
    *  Löscht die gegebene Datei _fpsPaFiNa_. Verzeichnisse werden nicht gelöscht.
    * 
    *  __Anmerkung:__ Existiert die Datei, dann wird diese gelöscht, falls die Datei nicht existiert, dann passiert schlicht nichts weiter.
    *  D.h. es wird auch kein Fehler oder eine Exception ausgelöst.
    * 
    *  Ist die vermeintliche Datei in Wahrheit ein Verzeichniss, dann wird eine
    *  OKWFileDoesNotExistsException ausgelöst.
    * 
    *  \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der
    *  zulöschenden Datei.
    *  \~english
    *  \~
    *  \author Zoltan Hrabovszki
    *  \date 2013.12.30
    *  */
    public static Boolean deleteFile( String fpsPaFiNa )
    {
        Boolean lvbReturn = false;

        Log.LogFunctionStartDebug( "OKW_FileHelper.FileDelete", "fpsPaFiNa", fpsPaFiNa );

        if ( fileExists( fpsPaFiNa ) )
        {
            try
            {
                File myFile = new File( fpsPaFiNa );

                lvbReturn = myFile.delete();
            }
            finally
            {
                Log.LogFunctionEndDebug();
            }
        }

        return lvbReturn;
    }

    /**
    * \~german
    *  \brief Prüft, ob die gegebene _fpsPaFiNa_ Datei existiert.
    * 
    * 
    *  \param fpsPaFiNa PathAndFileName: Vollständiger Pfad der Datein, die auf
    *  Existenz Geprüft werden soll.
    *  \return true, falls die Datei _fpsPaFiNa_ existiert, sonst false.
    *  \~english
    *  \~
    *  \author Zoltan Hrabovszki
    *  \date 2013.12.30
    */
    public static Boolean fileExists( String fpsPaFiNa )
    {

        Boolean lvbReturn = false;

        Log.LogFunctionStartDebug( "OKW_FileHelper.FileExist", "fpsPaFiNa", fpsPaFiNa );

        try
        {
            File myFile = new File( fpsPaFiNa );

            // Existiert "fpsPaFiNa"?
            if ( myFile.exists() )
            {
                // Ist es eine Datei?
                if ( myFile.isFile() )
                {
                    lvbReturn = true;
                }
                // Ist ein Verzeichniss?
                else if ( myFile.isDirectory() )
                {
                    throw ( new OKWFileDoesNotExistsException( "This is not a file! Given path is a directory!" ) );
                }
                // Dann Existiert "fpsPaFiNa" nicht!
                else
                {
                    lvbReturn = false;
                }
            }
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn.toString() );
        }

        return lvbReturn;
    }

    /** \~german
     *  Prüft, ob der gegebene PATH eine Datei ist.
     *  
     *  @info Die Datei muss existieren, sonst wird hier
     * 
     *  \param PATH Pfad der geprüft werden soll, ob dieser eine Datei ist.
     *  \return true, falls der Pfad eine Datei ist, sonst false.
     *  
     *  \~english
     *  Verifies that the given PATH is a file.
     * 
     *  \param PATH Path to check if it is a file.
     *  \return true, if the path is a file, otherwise false.
     *  
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2019-12-01
     */
    public static Boolean isFile( String PATH )
    {

        Boolean lvbReturn = false;

        Log.LogFunctionStartDebug( "OKW_FileHelper.isFile", "PATH", PATH );

        try
        {
            File myFile = new File( PATH );

            // Existiert "fpsPaFiNa"?
            if ( myFile.exists() )
            {
                // Ist es eine Datei?
                if ( myFile.isFile() )
                {
                    lvbReturn = true;
                }
                else
                {
                    lvbReturn = false;
                }
            }
            else
                throw ( new OKWFileDoesNotExistsException( "This is not a file! Given path is a directory!" ) );
        }
        finally
        {
            Log.LogFunctionEndDebug( lvbReturn.toString() );
        }

        return lvbReturn;
    }

    /** \~german
     *  Verschiebt die gegeben Quell-Datei zu einer neuen Ziel-Datei.
     * 
     *  \param fpsPaFiNaSource PathAndFileName: Angabe des vollständigen Pfades
     *  der zulöschenden Datei.
     *  \param fpsPaFiNaDestination Angabe des vollständigen Pfades der
     *  zulöschenden Datei.
     *  \~english
     * 
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.30
     */
    public static void move( String fpsPaFiNaSource, String fpsPaFiNaDestination ) throws IOException, FileNotFoundException
    {

        Log.LogFunctionStartDebug( "OKW_FileHelper.Move", "fpsPaFiNaSource", fpsPaFiNaSource, "fpsPaFiNaDestination", fpsPaFiNaDestination );
        try
        {
            if ( fileExists( fpsPaFiNaSource ) )
            {

                deleteFile( fpsPaFiNaDestination );
                copy( fpsPaFiNaSource, fpsPaFiNaDestination, true );
                deleteFile( fpsPaFiNaSource );

            }
            else
            {
                // \todo TODO: Log in xml-datei auslagern
                Log.LogFunctionEnd();
                throw new OKWFileDoesNotExistsException( "file doesnot exists..." );
            }
        }
        finally
        {
            Log.LogFunctionEnd();
        }
    }

    /** \~german
     *  \brief
     *  Legt eine Leere Datei an.
     * 
     *  \param fpsPaFiNa PathAndFileName: Angabe des vollständigen Pfades der an
     *  zu legenden Datei.
     *  \~english
     * 
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2013.12.30
     */
    public static boolean createFile( String fpsPaFiNa ) throws IOException
    {

        Boolean lvbReturn = false;

        Path newFilePath = Paths.get( fpsPaFiNa );
        
        try
        {

            if ( !Files.exists( newFilePath ) )
            {
                Files.createFile( newFilePath );
            }
        }
        finally
        {
            Log.LogFunctionEnd( lvbReturn );
        }

        return lvbReturn;

    }

    /** \~german
     *  Diese Methode prüft, ob das gegebene Verzeichniss existiert und leer ist.
     *  D.h. das Verzeichniss enthält:
     *  
     *  -# keine Dateien und
     *  -# keine Unterverzeichnisse
     *  
     *  @param PATH Das zu prüfende Verzeichniss.
     *  @return true wenn das Verzeichniss leer ist, sonst false
     *  
     *  @exception OKW.Exceptions.OKWDirectoryDoesNotExistsException wird ausgelöst, wenn de gegeben Pfad nicht auf ein existierendesVerzeichiss zeigt.
     *  
     *  \~english
     *  This method checks whether the given directory exists and is empty.
     *  This means that the directory contains:
     *  
     *  -# no files and
     *  -# no subdirectories
     *  
     *  @param PATH The directory to be checked.
     *  @return true, if the directory is empty, otherwise false
     *  
     *  @exception OKW.Exceptions.OKWDirectoryDoesNotExistsException is raised if the given path does not point to an existing directory.
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013-12-30
     */
    public static Boolean isDirectoryEmpty( String PATH )
    {

        Boolean lvbReturn = false;
        Log.LogFunctionStart( "OKW_FileHelper.IsDirectoryEmpty", "PATH", PATH );
        try
        {
            if ( directoryExists( PATH ) )
            {
                lvbReturn = Paths.get( PATH ).toFile().listFiles().length == 0;
            }
            else
            {
                // \todo TODO: Meldung in LM_OKW_FileHelper.xml auslagern...
                throw new OKWDirectoryDoesNotExistsException( "Directory Does not Exists..." );
            }
        }
        finally
        {
            Log.LogFunctionEnd( lvbReturn );
        }

        return false;
    }

    /** \~german
     *  Konvertiert für das Host-Betriebsystem den Path Separator.
     * 
     *  Je nach Betriebssystem wird wie folgt konvertiert:
     * 
     *  -# Auf einem Windows/DOS System werden Unix-Pfad-Trenner "/" nach "\" konvertiert.
     *  -# Auf einem OSX, Linux (Unix-Artige) Systemen wir der DOS-Pfad Trenner "\" nach "/" konvertiert.
     * 
     *  @param fpsPath Pfad, der zu konvertieren ist.
     *  @return Könvertierter Pfad
     *  
     *  \~english
     *  Converts the Path Separator for the host operating system.
     * 
     *  Depending on the operating system, the conversion is as follows:
     * 
     *  -# On a Windows/DOS system, Unix path separators "/" are converted to "\".
     *  -# On an OSX, Linux (Unix-like) system, the DOS path separator "\" is converted to "/".
     * 
     *  @param fpsPath Path to convert.
     *  @return Converted path.
     *  
     *  \~
     *  @author Zoltan Hrabovszki
     *  \date 2013.12.30
     */
    public static String convertDirectorySeperator( String fpsPath )
    {
        String lvsReturn = fpsPath;

        Log.LogFunctionStartDebug( "OKW_FileHelper.ConvertDirectorySeperator", "fpsPath", fpsPath );

        try
        {
            String myFileSeparator = System.getProperty( "file.separator" );

            if ( "/".equals( myFileSeparator ) )
            {
                lvsReturn = fpsPath.replace( "\\", "/" );
            }
            else if ( "\\".equals( myFileSeparator ) )
            {
                lvsReturn = fpsPath.replace( "/", "\\" );
            }
            else
                throw ( new OKWDirectorySeperatorNotImplementedException( "Error: Unknown file.separator: -" + myFileSeparator + "-" ) );

            lvsReturn = lvsReturn.replace( "\\C:", "C:" );
        }
        finally
        {
            Log.LogFunctionEndDebug( lvsReturn );
        }

        return lvsReturn;
    }

    /**
     * \~german
     *  Erstellt ein Verzeichnis, einschließlich aller notwendigen, aber nicht vorhandenen übergeordneten Verzeichnisse.
     *  
     *  Wenn eine Datei bereits mit dem angegebenen Namen existiert, aber kein Verzeichnis ist, dann wird eine IOException ausgelöst.
     *  Wenn das Verzeichnis nicht erstellt werden kann (oder nicht bereits existiert), wird eine IOException ausgelöst.
     *
     * @param PATH - Verzeichnis, das erstellt werden soll, darf nicht Null sein.
     * \~english
     *  Creates a directory, including any necessary but nonexistent parent directories.
     *  
     *  If a file already exists with specified name but it is not a directory then an IOException is thrown.
     *  If the directory cannot be created (or does not already exist) then an IOException is thrown.
     *
     * @param PATH - directory to create, must not be null
     * \~
     * @author Zoltán Hrabovszki
     * @throws IOException 
     * \date 2019-12-01
     */
    public static void DirectoryCreate( String PATH ) throws IOException
    {
        File myFile = new File( PATH );

        Log.LogFunctionStartDebug( "OKW_FileHelper.CreateDirectory", "PATH", PATH );

        try
        {
            org.apache.commons.io.FileUtils.forceMkdir( myFile );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }
}
