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

package okw.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.*;

import okw.parser.antlr4.core.*;
import okw.parser.antlr4.core.OKWCoreParser.RootContext;



    public class Parser
    {
        /** \~german
<<<<<<< HEAD
         *  Parst einen List&lt string&gt und ersetzt die Parser-Schlüsselewörter durch Werte.
         *  
         *  @param fpLsString2Parse Liste, die geparst werden soll.
         *  @return Parser Schlüssel sind durch Werte ersetzt.
         *  
         *  \~english
         *  Parses a List&lt string&gt and replaces the parser keywords with values.
         *  
         *  \param fpLsString2Parse List to be parsed.
         * @return Parser keys are replaced by values.
=======
         *  Parst einen ArayList&lt string&gt, ersetzt die Parser-Schlüsslewörter durch Werte.
         *  
         *  \param fpLsString2Parse ArayList&lt string&gt, die geparst werden soll.
         *  \return Parser Schlüssel sind durch Werte ersetzt.
         *  
         *  \~english
         *  Parses an ArayList&lt string&gt, replaces the parser keywords with values.
         *  
         *  \param fpLsString2Parse ArayList&lt string&gt that should be parsed.
         *  \return Parser Keys are replaced by values.
>>>>>>> refs/heads/FileKeyWords
         * 
         *  \~
         *  \author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        public static ArrayList<String> ParseMe( ArrayList<String> fpLsString2Parse )
        {
            ArrayList<String> lvLsReturn =  new ArrayList<String>();
            
            for (String Value : fpLsString2Parse )
            {
                if ("".equals( Value ))
                {
                  lvLsReturn.add("");
                }
                else
                {
                  lvLsReturn.add(ParseMe(Value));
                }
            }
            
            return lvLsReturn;
        }
        
        /** \~german
<<<<<<< HEAD
         *  Parst einen _string und ersetzt die Parser-Schlüsslewörter durch Werte.
         *  
         *  @param fpsString2Parse String, der geparst werden muss.
         *  @return Parser Schlüssel sind durch Werte ersetzt.
         *  
         *  \~english
         *  
         *  @param fpsString2Parse Functional name of the object.
=======
         *  Das ist die Parser-methode um einen string zu parsen und die Parser-Schlüsselwörter durch Werte zu ersetzten .
         *  
         *  @param fpsString2Parse String, der geparst werden soll.
         *  @return Rückgabe des geparsten Strings: Parser Schlüssel sind durch Werte ersetzt.
         *  
         *  \~english
         *  Das ist die Parser-methode um einen string zu parsen und die Parser-Schlüsselwörter durch Werte zu ersetzten .
         *  
         *  @param fpsString2Parse String to be parsed. 
         *  @return Return of the parsed string: Parser keys are replaced by values.
>>>>>>> refs/heads/FileKeyWords
         * 
         *  \~
         *  @author Zoltan Hrabovszki
         *  \date 2014-09-21
         */
        public static String ParseMe( String fpsString2Parse )
        
        {
            // StringReader inputStream = new StringReader(fpsString2Parse);
            // ANTLRInputStream input = new ANTLRInputStream(fpsString2Parse);
            CharStream input = CharStreams.fromString(fpsString2Parse);
            
            OKWCoreLexer lexer = new OKWCoreLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            OKWCoreParser parser = new OKWCoreParser(tokens);
            RootContext tree = parser.root();

            //Console.WriteLine( tree.ToStringTree(parser));
            OKW_Visitor visitor = new OKW_Visitor();
            return visitor.visit(tree);
        }
    }