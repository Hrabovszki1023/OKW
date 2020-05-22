
package okw.parser;


import okw.gui.adapter.selenium.SeTypeKeysCharSequence;
import okw.parser.antlr4.se.*;
import okw.parser.antlr4.se.OKWSeParser;
import okw.parser.antlr4.se.OKWSeParser.RootContext;
import okw.parser.antlr4.se.OKWSeParser.ValueContext;

    public class OKWSeVisitor extends OKWSeParserBaseVisitor<String>
    {
        SeTypeKeysCharSequence myCharSequence = new SeTypeKeysCharSequence();
        
        @Override
        public String visitAlt(OKWSeParser.AltContext ctx) { 
            
            String lvsReturn = visitChildren(ctx);
            
            System.out.println( "Modifier: ALT: \"" + lvsReturn + "\"" );
            
            myCharSequence.setALT();
            
            return lvsReturn;
        }

        @Override
        public String visitCommand(OKWSeParser.CommandContext ctx) { 
            
            String lvsReturn = visitChildren(ctx);
            
            System.out.println( "Modifier: COMMAND" );
            
            myCharSequence.setCOMMAND();
            
            return lvsReturn;
        }

        @Override
        public String visitShift(OKWSeParser.ShiftContext ctx) { 
            
            String lvsReturn = visitChildren(ctx);
            
            System.out.println( "Modifier: SHIFT" );

            myCharSequence.setSHIFT();
            
            return lvsReturn;
        }

        @Override
        public String visitCtrl(OKWSeParser.CtrlContext ctx) { 
            
            String lvsReturn = visitChildren(ctx);
            
            System.out.println( "Modifier: CTRL" );

            myCharSequence.setCTRL();
            
            return lvsReturn;
        }
        
        
        @Override
        public String visitKeyvalue( OKWSeParser.KeyvalueContext ctx )
        {
            String lvsReturn = visitChildren(ctx);
            
            System.out.println( "Keyvalue: " + ctx.getText() );
            
            myCharSequence.setKeyvalue( ctx.getText() );

            return lvsReturn;
        }
        
        @Override
        public String visitValue( ValueContext ctx )
        {
            String lvsReturn = visitChildren(ctx);
            
            lvsReturn = lvsReturn + ctx.getText();
            System.out.println( "Value: " + lvsReturn );
            
            myCharSequence.setText( lvsReturn );

            return lvsReturn;
        }
        
    	@Override
        public String visitText( OKWSeParser.TextContext ctx )
        {
            String lvsReturn = visitChildren(ctx);
            
            lvsReturn = lvsReturn + ctx.getText();
            System.out.println( "Text: " + lvsReturn );
            
            myCharSequence.setText( lvsReturn );

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
    	

        @Override
        public String visitRoot( RootContext ctx )
        {
            String lvsReturn = "";
                            
            super.visitChildren(ctx);
            
            System.out.println( "Root: " + ctx.getText() );
            
            lvsReturn = myCharSequence.getCharSequenze();
            
            return lvsReturn;
        }
    	
    }
