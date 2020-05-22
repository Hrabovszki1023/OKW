package okw.gui.frames.keyboardtester;

import java.util.ArrayList;

import javax.xml.xpath.XPathExpressionException;

import okw.OKW;
import okw.gui.adapter.selenium.*;

@OKW (FN="Keyboard Tester",
      WaitForMe_PT=500,
      WaitForMe_TO=5
     )
public class frmKeyboardTester extends SeBrowserChild
{
  
	  @OKW (FN="Testarea",
	          VerifyLabel_PT=500, VerifyLabel_TO=1,
	          VerifyIsActive_PT=500, VerifyIsActive_TO=1,
	          VerifyValue_PT=500, VerifyValue_TO=1,
	          VerifyTooltip_PT=500, VerifyTooltip_TO=1,
	          VerifyCaption_PT=500, VerifyCaption_TO=1,
	          VerifyExists_PT=500, VerifyExists_TO=1,
	          VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
              VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
              VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
              VerifyMinLength_PT=500, VerifyMinLength_TO=1,
	          WaitForMe_PT=500, WaitForMe_TO=1
	          )
    public SeTextarea Testarea = new SeTextarea("//textarea[@id='testarea']" );

	  
    @OKW (FN="Reset",
                    VerifyLabel_PT=500, VerifyLabel_TO=1,
                    VerifyIsActive_PT=500, VerifyIsActive_TO=1,
                    VerifyValue_PT=500, VerifyValue_TO=1,
                    VerifyTooltip_PT=500, VerifyTooltip_TO=1,
                    VerifyCaption_PT=500, VerifyCaption_TO=1,
                    VerifyExists_PT=500, VerifyExists_TO=1,
                    VerifyHasFocus_PT=500, VerifyHasFocus_TO=1,
                    VerifyPlaceholder_PT=500, VerifyPlaceholder_TO=1,
                    VerifyMaxLength_PT=500, VerifyMaxLength_TO=1,
                    VerifyMinLength_PT=500, VerifyMinLength_TO=1,
                    WaitForMe_PT=500, WaitForMe_TO=1
            )
    public SeInputButton Reset = new SeInputButton("//input[@name='reset']" );
    
    
    /** <div id="key76" class="key_pressed" bis_skin_checked="1">L</div>
     *  <div id="key75" class="key_un" bis_skin_checked="1">K</div>
     */
    @OKW (FN="Button", VerifyValue_PT=500, VerifyValue_TO=5, WaitForMe_PT=500, WaitForMe_TO=1
            )
    public SeButton SelectButton = new SeButton("")
    { 
       @Override
       public void SetValue( ArrayList<String> Values )
       {
           this.setLocator( "//div[text()='" + Values.get( 0 ) + "'][1]" );
       }
       
       @Override
       public ArrayList<String> VerifyValue()
       {
           ArrayList<String> lvLsReturn = null;

           try
           {
               this.LogFunctionStartDebug( "VerifyValue" );

               // get the Actual Value.
               lvLsReturn = this.getValue();
           }
           finally
           {
               this.LogFunctionEndDebug( lvLsReturn );
           }

           return lvLsReturn;
       }
       
       @Override
       public ArrayList<String> getValue()
       {
           ArrayList<String> lvLsReturn = new ArrayList<String>();

           try
           {
               this.LogFunctionStartDebug( "getValue" );

               // Warten auf das Objekt. Wenn es nicht existiert wird mit OKWGUIObjectNotFoundException beendet...
               this.WaitForMe();

               // Get Value from TextField and put this into the return ArrayList<String>
               String ValueRaw = this.Me().getAttribute( "class" );
               
               System.out.println( "---------------------------------------------" );
               System.out.println( "class=" + ValueRaw );
               System.out.println( "---------------------------------------------" );
               
               switch (ValueRaw)
               {
                   case "key_pressed" :
                   case "key_pressed_m" :
                       lvLsReturn.add( "PRESSED" );
                       break;
                   case "key_un":
                       lvLsReturn.add( "UNPRESSED" );
                       break;
                   default:
                       lvLsReturn.add( "UNKNOWN" );
                       break;
               }
           }
           finally
           {
               this.LogFunctionEndDebug( lvLsReturn );
           }

           return lvLsReturn;       }
       
    };
    

    public frmKeyboardTester( )
    {
        setLocator("//head/title[text()='Keyboard Tester']/../..");
    }

}