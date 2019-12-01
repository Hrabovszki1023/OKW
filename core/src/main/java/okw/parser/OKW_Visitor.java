
package okw.parser;

import org.antlr.v4.runtime.tree.*;
//import org.omg.CORBA.Environment;

import okw.*;
import okw.parser.antlr4.*;


    public class OKW_Visitor extends OKW_ParserBaseVisitor<String>
    {
        
    	@Override
        public String visitOkw_env_var( OKW_Parser.Okw_env_varContext context)
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
              else
              {
                lvsReturn = System.getenv( lvsReturn );
              }
            }
            return lvsReturn;
        }

    	@Override
        public String visitOkw_internal_var( OKW_Parser.Okw_internal_varContext context)
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

    	@Override
        public String visitText( OKW_Parser.TextContext context )
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
