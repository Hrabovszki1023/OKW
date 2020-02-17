package okw.gui.frames.material8;

import okw.OKW;
import okw.gui.adapter.selenium.*;
import okw.gui.adapter.selenium.material8.*;

@OKW( FN = "REACTIVE FORM USING A FORM BUILDER" )
public class ReactiveFormUsingAFormBuilder extends SeBrowserChild
{
	
	  @OKW( FN = "Request a gift",
      VerifyLabel_PT=500, VerifyLabel_TO=1,
      VerifyIsActive_PT=500, VerifyIsActive_TO=1,
      VerifyValue_PT=500, VerifyValue_TO=4,
      VerifyTooltip_PT=500, VerifyTooltip_TO=1,
      VerifyCaption_PT=500, VerifyCaption_TO=1,
      VerifyExists_PT=500, VerifyExists_TO=1,
      VerifyHasFocus_PT=500, VerifyHasFocus_TO=1
       )
      public mat_checkbox Request_A_Gift = new mat_checkbox( "//*[@formcontrolname='requestGift']" );

      @OKW( FN = "Auto Save")
      public mat_slide_toggle Auto_Save = new mat_slide_toggle( "//*[@formcontrolname='autosave']" );
			  
	  @OKW( FN = "Username" )
	  public SeInputText Username = new SeInputText( "//*[@formcontrolname='username']" );

	  @OKW( FN = "Password" )
	  public SeInputText Password = new SeInputText( "//*[@formcontrolname='password']" );

	  @OKW( FN = "Email" )
	  public SeInputText Email = new SeInputText( "//*[@formcontrolname='email']" );

	  @OKW( FN = "Birthday" )
	  public SeInputText Birthday = new SeInputText( "//*[@formcontrolname='birthday']" );

	  @OKW( FN = "Description" )
	  public SeTextarea Description = new SeTextarea( "//*[@formcontrolname='description']" );

	  public ReactiveFormUsingAFormBuilder()
	  {
	    this.setLocator( "//*[contains(text(),'Reactive form using a form builder')]/ancestor::body" );
	  }
}
