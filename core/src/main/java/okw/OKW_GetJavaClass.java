package okw;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * @author Philippe Schweitzer dbi services Switzerland
 *         http://blog.dbi-services.
 *         com/java-get-class-names-from-package-string-in-classpath/
 * 
 */
public class OKW_GetJavaClass
{
	static ArrayList<String> getClasses( String fpsPackage )
	{
		ArrayList<String> lvAsReturn = new ArrayList<String>();

		// 1. Hole alle Classpathes...
		try
		{
			ArrayList<String> lvClassPathes;

			lvClassPathes = getClassPaths( fpsPackage );

			// Klappern wir dann mal alle Pfade ab...

			for ( String lvClassPath : lvClassPathes )
			{
				
				File file = new File(lvClassPath);
				
				if ( file.exists() )
				{
				
				// 2. Ist ein die URL eine jar Datei? -> muss dann mit "jar"
				// enden...
				if ( lvClassPath.endsWith( "jar" ) )
				{
					// Alle Klassen der JAR-Datei für das gegebene Paket
					// ermitteln
					// Alle *.class Dateien für das Paket ermitteln...
					lvAsReturn.addAll( getClassesFromDirectory( lvClassPath, fpsPackage ) );
				}
				else if ( Files.isDirectory( Paths.get( lvClassPath ), LinkOption.NOFOLLOW_LINKS ) )
				{
					// Alle *.class Dateien für das Paket ermitteln...
					lvAsReturn.addAll( getClassesFromDirectory( lvClassPath, fpsPackage ) );
				}
				}

			}
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		if ( !directory.exists() )
		{
			return classes;
		}

		File[] files = directory.listFiles();

		for ( File file : files )
		{
			if ( file.isDirectory() )
			{
				assert !file.getName().contains( "." );
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
		return classes;
	}

	/**
	 *
	 * Attempts to list all the classes in the specified package as determined *
	 * by the context class loader…
	 * 
	 * https://dzone.com/articles/get-all-classes-within-package
	 * http://mike.shannonandmike
	 * .net/2009/09/02/java-reflecting-to-get-all-classes-in-a-package/
	 * 
	 * https://blog.denevell.org/java-reflection-get-classes.html !!!
	 * 
	 * @param pckgname
	 *            the package name to search
	 * @return a list of classes that exist within that package
	 * @throws ClassNotFoundException
	 *             if something went wrong
	 * 
	 */
	/*
	public static ArrayList<Class<?>> getClassesFromPackage( String fps_pckgname )
			throws ClassNotFoundException
	{
		ArrayList<Class<?>> lvAL_result = new ArrayList<Class<?>>();
		ArrayList<File> directories = new ArrayList<File>();
		HashMap<File, String> packageNames = null;

		try
		{
			ClassLoader cld = Thread.currentThread().getContextClassLoader();

			if ( cld == null )
			{
				throw new ClassNotFoundException( "Can’t get class loader." );
			}

			for ( URL jarURL : ( ( URLClassLoader ) Thread.currentThread()
					.getContextClassLoader() ).getURLs() )
			{
				System.out.println( "JAR: " + jarURL.getPath() );
				getClassesInSamePackageFromJar( lvAL_result, fps_pckgname, jarURL.getPath() );
				String path = fps_pckgname;
				Enumeration<URL> resources = cld.getResources( path );
				File directory = null;

				while ( resources.hasMoreElements() )
				{
					String path2 = resources.nextElement().getPath();
					directory = new File( URLDecoder.decode( path2, "UTF-8" ) );
					directories.add( directory );
				}
				
				if ( packageNames == null )
				{
					packageNames = new HashMap<File, String>();
				}
				packageNames.put( directory, fps_pckgname );
			}
		}
		catch (NullPointerException x)
		{
			throw new ClassNotFoundException(
					fps_pckgname
							+ " does not appear to be a valid package (Null pointer exception)" );
		}
		catch (UnsupportedEncodingException encex)
		{
			throw new ClassNotFoundException(
					fps_pckgname
							+ " does not appear to be a valid package (Unsupported encoding)" );
		}
		catch (IOException ioex)
		{
			throw new ClassNotFoundException(
					"IOException was thrown when trying to get all resources for "
							+ fps_pckgname );
		}

		for ( File directory : directories )
		{
			if ( directory.exists() )
			{
				String[] files = directory.list();

				for ( String file : files )
				{
					if ( file.endsWith( ".class" ) )
					{
						try
						{
							// System.out.println(packageNames.get(directory).toString()
							// + ‘.’ + file.substring(0, file.length() – 6));
							Class<?> lvcReult = Class.forName( packageNames
									.get( directory ).toString()
									+ "."
									+ file.substring( 0, file.length() - 6 ) );
							lvAL_result.add( lvcReult );
						}
						catch (Throwable e)
						{
						}
					}
				}
			}
			else
			{
				throw new ClassNotFoundException( fps_pckgname + " ("
						+ directory.getPath()
						+ ") does not appear to be a valid package" );
			}
		}
		return lvAL_result;
	}
	*/

	/**
	 *
	 * Returns the list of classes in the same directories as Classes in
	 * classes.
	 *
	 * @param result
	 * @param classes
	 * @param jarPath
	 *
	 */
	@SuppressWarnings("unused")
	private static ArrayList<String> getClassesFromJar( String jarPath, String packageName )
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
		catch (Exception e)
		{
		}
		finally
		{
			try
			{
				if ( jarFile != null )
				{
					jarFile.close();
				}
			}
			catch (Exception e)
			{
			}
		}
		
		return lvAL_Return;
	}
	
	
	/**
	 *
	 * Returns the list of classes in the same directories as Classes in
	 * classes.
	 *
	 * @param result
	 * @param classes
	 * @param jarPath
	 *
	 */
	/*
	private static void getClassesInSamePackageFromJar(
			ArrayList<Class<?>> result, String packageName, String jarPath )
	{
		JarFile jarFile = null;

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
							result.add( entryClass );
						}
					}
					catch (Throwable e)
					{
						// do nothing, just continue processing classes
					}
				}
			}
		}
		catch (Exception e)
		{
		}
		finally
		{
			try
			{
				if ( jarFile != null )
				{
					jarFile.close();
				}
			}
			catch (Exception e)
			{
			}
		}
	}
	*/
}
