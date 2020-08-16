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

// import org.antlr.v4.runtime.tree.*;

import okw.*;
import okw.parser.antlr4.core.*;
//import okw.parser.antlr4.core.OKWCoreParser.KeyvalueContext;


    public class OKW_Visitor extends OKWCoreParserBaseVisitor<String>
    {
        
    	@Override
        public String visitOkw_env_var( OKWCoreParser.Okw_env_varContext context)
        {
            String lvsReturn = context.getChild(1).getText();
            
            if (OKW_Memorize_Sngltn.getInstance().exists( lvsReturn ))
                lvsReturn = OKW_Memorize_Sngltn.getInstance().get( lvsReturn);
            else
            {
              if( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "DELETE" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "DELETE" );
              }
              else if ( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "EMPTY" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" );
              }
              else if ( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "IGNORE" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" );
              }
              else if ( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "SEP" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "SEP" );
              }
              else if ( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "VSEP" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "VSEP" );
              }
              else if ( lvsReturn.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "HSEP" )) )
              {
                lvsReturn = OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "HSEP" );
              }
              else if ( okw.OKW_Properties.getInstance().containsKey( lvsReturn ))
                  lvsReturn = okw.OKW_Properties.getInstance().getProperty( lvsReturn );
              else
              {
                lvsReturn = System.getenv( lvsReturn );
              }
            }
            return lvsReturn;
        }

    	@Override
        public String visitOkw_internal_var( OKWCoreParser.Okw_internal_varContext context)
        {
            String lvsReturn = context.getChild(1).getText();
            
            switch (lvsReturn)
            {
                case "Folder_LogMessages":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFolder_LogMessages();
                    break;

                case "Folder_XML":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFolder_XML();
                    break;

                case "File_OKW_Const_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Const_xml();
                    break;

                case "File_OKW_Docu_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Docu_xml();
                    break;

                case "File_OKW_ImplementationMatrix_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_ImplementationMatrix_xml();
                    break;

                case "File_OKW_Ini_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Ini_xml();
                    break;

                case "File_OKW_Keymaps_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Keymaps_xml();
                    break;

                case "File_OKW_Memorize_xml":
                    lvsReturn = OKW_Ini_Sngltn.getInstance().OKW_Enviroment.getFile_OKW_Memorize_xml();
                    break;
            }
            
            return lvsReturn;
            
        }

//    	@Override
//    	public String visitKeyvalue( OKWCoreParser.KeyvalueContext context )
//    	{
//           String lvsReturn = context.getChild(0).getText();
//            
//            switch (lvsReturn)
//            {       
//                case "ALT":
//                    lvsReturn = "!!DEL";
//                    break;
//                case "SHIFT":
//                    lvsReturn = "!!CONTROL";
//                    break;
//                case "CTRL":
//                    lvsReturn = "!!CONTROL";
//                    break;
//                default :
//                    lvsReturn = Keys.valueOf( lvsReturn ).toString();
//                    break;
//            }
//            
//            return lvsReturn;
//    	}
    	
    	@Override
        public String visitText( OKWCoreParser.TextContext context )
        {
            String lvsReturn = context.getText();

            return lvsReturn;
        }
        
    	@Override
        protected String aggregateResult( String aggregate, String fpsNextResult )
        {
            String lvsReturn = "";

            if ( aggregate != null )
                lvsReturn = aggregate;
            
            if (fpsNextResult != null)
                lvsReturn = lvsReturn + fpsNextResult;
            
            return lvsReturn;
        }
    }
