package okw.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.Misc;
//import Antlr4.Runtime.Tree;

import okw.parser.antlr4.*;
import okw.parser.antlr4.OKW_Parser.RootContext;



    public class Parser
    {
        /** \~german
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
         * 
         *  \~
         *  @author Zoltan Hrabovszki
         *  @date 2014-09-21
         */
        public static String ParseMe( String fpsString2Parse )
        
        {
            // StringReader inputStream = new StringReader(fpsString2Parse);
            ANTLRInputStream input = new ANTLRInputStream(fpsString2Parse);
            OKW_Lexer lexer = new OKW_Lexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            OKW_Parser parser = new OKW_Parser(tokens);
            RootContext tree = parser.root();

            //Console.WriteLine( tree.ToStringTree(parser));
            OKW_Visitor visitor = new OKW_Visitor();
            return visitor.visit(tree);
        }
    }