package okw.parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.*;
//import org.antlr.v4.runtime.Misc;
//import Antlr4.Runtime.Tree;

import okw.parser.antlr4.se.*;
import okw.parser.antlr4.se.OKWSeParser.RootContext;



    public class Parser
    {
        /// \~german
        /// \brief
        /// Parst einen _List&lt string&gt, ersetzt die Parser-Schlüsslewörter durch Werte.
        /// 
        /// \param fpLsString2Parse Liste, die geparst werden muss.
        /// \return Parser Schlüssel sind durch Werte ersetzt.\return
        /// \~english
        /// \brief
        /// 
        /// 
        /// \param fpLsString2Parse Functional name of the object
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21
        public static ArrayList<String> ParseMe( ArrayList<String> fpLsString2Parse )
        {
            ArrayList<String> lvLsReturn =  new ArrayList<String>();
            
            for (String Value : fpLsString2Parse )
            {
                if (Value.equals( "" ))
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
        
        /// \~german
        /// \brief
        /// Parst einen _string und ersetzt die Parser-Schlüsslewörter durch Werte.
        /// 
        /// \param fpsString2Parse String, der geparst werden muss.
        /// \return Parser Schlüssel sind durch Werte ersetzt.\return
        /// \~english
        /// \brief
        /// 
        /// 
        /// \param fpsString2Parse Functional name of the object.
        ///
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2014-09-21
        public static String ParseMe( String fpsString2Parse )
        
        {
            // StringReader inputStream = new StringReader(fpsString2Parse);
            ANTLRInputStream input = new ANTLRInputStream(fpsString2Parse);
            OKWSeLexer lexer = new OKWSeLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            OKWSeParser parser = new OKWSeParser(tokens);
            RootContext tree = parser.root();

            //Console.WriteLine( tree.ToStringTree(parser));
            OKWSeVisitor visitor = new OKWSeVisitor();
            return visitor.visit(tree);
        }
    }