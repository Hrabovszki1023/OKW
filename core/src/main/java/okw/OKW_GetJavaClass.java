package okw;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.xml.xpath.XPathExpressionException;


public class OKW_GetJavaClass
{

	public static ArrayList<String> getClasses( String fpsPackage ) throws IOException, XPathExpressionException
	{
		ArrayList<String> lvAsReturn = new ArrayList<String>();

		// 1. Hole alle Klassen die das Packet fpsPackeg enthalten...
		ArrayList<String> lvClassPathes = getClassPaths( fpsPackage );

		// Durchsuchen wir alle Pfade...
		for ( String lvClassPath : lvClassPathes )
		{
				
			if ( lvClassPath.startsWith("file:") )
			{
				// Hier handelt es sch um eine *.jar Datei
				// "file:/some/path/myfile.jar!/okw/gui/frames"

				lvClassPath = okw.OKW_Helper.GetRightFromDelimiterNumber(lvClassPath, "file:", 1);
				
				// nun rechts von "!" abschneiden incl. "!" weg!
				// Ergebniss: "/some/path/myfile.jar"
				lvClassPath = okw.OKW_Helper.GetLeftFromDelimiterNumber( lvClassPath, "!", 1);
			}
					
			File file = new File(lvClassPath);

			if ( file.exists() )
			{
				
				// 2. Ist ein die URL eine *.jar Datei?
				if ( lvClassPath.endsWith( "jar" ) )
				{
					// Dann "okw.gui.frames.*" Klassen des Paketes ermitteln...
					lvAsReturn.addAll( getClassesFromJar( lvClassPath, fpsPackage ) );
				}
				else if ( Files.isDirectory( Paths.get( lvClassPath ), LinkOption.NOFOLLOW_LINKS ) )
				{
					// Dann "okw.gui.frames.*" Klassen des gegebenen Pfades ermitteln...
					lvAsReturn.addAll( getClassesFromDirectory( lvClassPath, fpsPackage ) );
				}
			}
		}
			
		return lvAsReturn;
	}


	static public ArrayList<String> getClassPaths( String packageName )
			throws IOException
	{
		ArrayList<String> ReturnList = new ArrayList<String>();

		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();

		String path = packageName.replace( '.', '/' );

		Enumeration<URL> resources = classLoader.getResources( path );

		while ( resources.hasMoreElements() )
		{
			URL resource = resources.nextElement();

			String replacedURL = resource.getPath();
			
			/* replacedURL = replacedURL.replaceFirst( "/", "" ); */

			System.out.println( ">>" + replacedURL + "<<" );
			ReturnList.add( replacedURL );
		}

		return ReturnList;
	}
	
	
	/**
	 * Recursive method used to find all classes in a given directory and
	 * subdirs.
	 *
	 * @param directory
	 *            The base directory
	 * @param packageName
	 *            The package name for classes found inside the base directory
	 * @return The classes
	 * @throws ClassNotFoundException
	 */
	private static ArrayList<String> getClassesFromDirectory( String fpsdirectory, String packageName )
	{
		ArrayList<String> classes = new ArrayList<String>();

		File directory = new File( fpsdirectory );

		if ( directory.exists() )
		{

			File[] files = directory.listFiles();

			for ( File file : files )
			{
				if ( file.isDirectory() )
				{
					// assert !file.getName().contains( "." );
					classes.addAll( getClassesFromDirectory( file.getPath(),
						packageName + "." + file.getName() ) );
				}
				else if ( file.getName().endsWith( ".class" ) )
				{
					// System.out.println( ">>Class: " + file.getName() );
					classes.add( packageName
						+ '.'
						+ file.getName().substring( 0,
								file.getName().length() - 6 ) );
				}
		 	}
		}
		return classes;
	}



	/**
	 *
	 * Returns the list of classes in the same directories as Classes in
	 * classes.
	 *
	 * @param result
	 * @param classes
	 * @param jarPath
	 * @throws IOException 
	 *
	 */
	private static ArrayList<String> getClassesFromJar( String jarPath, String packageName ) throws IOException
	{
		JarFile jarFile = null;
		ArrayList<String> lvAL_Return = new ArrayList<String>();
		
		try
		{
			jarFile = new JarFile( jarPath );
			Enumeration<JarEntry> en = jarFile.entries();
			while ( en.hasMoreElements() )
			{
				JarEntry entry = en.nextElement();
				String entryName = entry.getName();
				packageName = packageName.replace( ".", "/" );

				if ( entryName != null && entryName.endsWith( ".class" )
						&& entryName.startsWith( packageName ) )
				{
					try
					{
						Class<?> entryClass = Class.forName( entryName
								.substring( 0, entryName.length() - 6 )
								.replace( "/", "." ) );

						if ( entryClass != null )
						{
							lvAL_Return.add( entryClass.getName() );
						}
					}
					catch (Throwable e)
					{
						// do nothing, just continue processing classes
					}
				}
			}
		}
		finally
		{
			if ( jarFile != null )
			{
				jarFile.close();
			}
		}
		
		return lvAL_Return;
	}
}