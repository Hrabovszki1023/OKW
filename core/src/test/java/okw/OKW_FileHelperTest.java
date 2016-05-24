/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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


//import junit.framework.TestCase;
import org.junit.*;

/*	[TestFixture]
	[Category("BaseTest")]
	[Category("WIN")]
	[Category("OSX")]
	[Category("Helper")]
*/
@Ignore
public class OKW_FileHelperTest
	{
		@Test
		//@Category("BaseTest")
		public void TC_DosPath2UnixPath()
        {
            String lsDosPath = "\\abc\\abc\\file.ext";
            String lsUnixPath = "/abc/abc/file.ext";

            if (System.getProperty("file.separator") == "\\")  
            	Assert.assertEquals( lsDosPath, OKW_FileHelper.ConvertDirectorySeperator(lsUnixPath));
            else if  (System.getProperty("file.separator") == "/")
            	Assert.assertEquals( lsUnixPath, OKW_FileHelper.ConvertDirectorySeperator(lsDosPath));
            else
				Assert.fail("DirectorySeparatorChar ist weder UNIX noc DOS Typisch: " + System.getProperty("file.separator") );
        }

		@Test
		//@Category("BaseTest")
		public void TC_1()
        {

			String a = "abc";
			String b = "abc";
			
            Assert.assertEquals( a, b );
        }

		
		@BeforeClass
        public static void MyTestFixtureSetUp()
        {
            // TODO: Add Init code.
        }
        
		@AfterClass
        public static void MyTestFixtureTearDown()
        {
            // TODO: Add tear down code.
        }
    }
