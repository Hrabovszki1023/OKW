package okw.seimage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import org.junit.FixMethodOrder;

import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.core.OKWTestBase;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;


/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Disabled
public class SeImage_EN_Test extends OKWTestBase
{
  String cvOKWObject = "Link" + "";

  protected OKW_Memorize_Sngltn myMM = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  
  @Test
  public void tc_ClickOn() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.SetValue( "Display", "${EMPTY}" );
      
      EN.ClickOn( "Image 1" );
      EN.VerifyValue( "Display", "Image 1" );

      EN.ClickOn( "Image 2" );
      EN.VerifyValue( "Display", "Image 2" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

    
  @Test
  public void tc_LogCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.LogCaption( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void tc_LogLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.LogCaption( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
 }

  
  @Test
  public void tc_LogValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );

      EN.LogValue( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   *  Prüft ob ein vorhandenes objekt existiert.
   *  Erwartet wird, dass das Objekt existiert.
   */
  @Test
  public void tc_LogExists_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );

      EN.LogExists( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   *  Focus eines Textfeldes loggen.
   */
  @Test
  public void tc_LogHasFocus_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );

      EN.LogHasFocus( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

/**
 * \~german
 *  Prüft LogIsActive.
 * \~english
 *
 * \~
 * @author Zoltán Hrabovszki
 * @date 2019-07-07
 */
  @Test
  public void tc_LogIsActive_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );

      EN.LogIsActive( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  /**
   *  Tooltip eines Textfeldes Prüfen.
   */
  @Test
  public void tc_LogToolTip_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );

      EN.LogTooltip( "Image 1" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
  * \~german
  *  Prüft ob die VerifyIsActive die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
  * \~english
  *
  * \~
  * @author Zoltán Hrabovszki
  * @date 2019-07-07
  */
  @Test
   public void tc_MemorizeIsActive() throws Exception
   {
       EN.BeginTest( TestName );

       EN.StartApp( ApplicationName );
       EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

       EN.SelectWindow( "Image" );

       EN.MemorizeIsActive( "Image 1", "Schlüssel" );
       assertEquals( "YES", myMM.get( "Schlüssel" ) );

       EN.StopApp( ApplicationName );
       EN.EndTest();
   }


  @Test
  public void tc_MemorizeCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeCaption( "Image 1", "SeImage_MemorizeCaption_1" );
      
      assertEquals( "OpenKeyWord Logo", myMM.get( "SeImage_MemorizeCaption_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

    
  @Test
  public void tc_MemorizeLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeLabel( "Image 1", "SeImage_MemorizeLabel_1" );
      assertEquals( "Label: Image 1", myMM.get( "SeImage_MemorizeLabel_1" ) );

      EN.MemorizeLabel( "Image 2", "SeImage_MemorizeLabel_2" );
      assertEquals( "Label: Image 2", myMM.get( "SeImage_MemorizeLabel_2" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void tc_MemorizeValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeValue( "Image 1", "SeImage" );

      // Gemerkten Href-Wert als URL eingeben...
      EN.SetValue( "Display", "A${SeImage}" );

      EN.VerifyValue( "Display", "Ahttps://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   *  Prüft die Methode MemorizeExists.
   */
  @Test
  public void tc_MemorizeExists_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeExists( "Image 1", "SeImage_MemorizeExists_1" );
      assertEquals( "YES", myMM.get( "SeImage_MemorizeExists_1" ) );

      EN.MemorizeExists( "Image 2", "SeImage_MemorizeExists_1" );
      assertEquals( "YES", myMM.get( "SeImage_MemorizeExists_1" ) );

      EN.MemorizeExists( "Does Not Exists", "SeImage_MemorizeExists_1" );
      assertEquals( "NO", myMM.get( "SeImage_MemorizeExists_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Prüft die Methode MemorizeHasFocus
   */
  @Test
  public void tc_MemorizeHasFocus_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeHasFocus( "Image 1", "SeImage" );
      
      assertEquals( "NO", myMM.get( "SeImage" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   *  Prüft die Methode MemorizeToolTip.
   */
  @Test
  public void tc_MemorizeToolTip_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.MemorizeTooltip( "Image 1", "SeImage_MemorizeTooltip_1" );
      assertEquals( "Title: Image 1", myMM.get( "SeImage_MemorizeTooltip_1" ) );

      EN.MemorizeTooltip( "Image 2", "SeImage_MemorizeTooltip_1" );
      assertEquals( "Title: Image 2", myMM.get( "SeImage_MemorizeTooltip_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
  public void tc_SetFocus() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.SetFocus( "Image 1" );

      Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
      {
          EN.EndTest();
      });
  }


  @Test
  public void tc_VerifyHasFocus() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyHasFocus( "Image 1", "NO" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }
  
  
  /**
   * \~german
   *  Prüft ob die VerifyIsActive die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
   * \~english
   *
   * \~
   * @author Zoltán Hrabovszki
   * @date 2019-07-07
   */
   @Test // (expected= UnsupportedOperationException.class)
    public void tc_VerifyIsActive_en() throws Exception
    {
        EN.BeginTest( TestName );

        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

        EN.SelectWindow( "Image" );

        EN.VerifyIsActive( "Image 1", "YES" );
        
        EN.StopApp( ApplicationName );
        EN.EndTest();
    }


   @Test
  public void tc_VerifyCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyCaption( "Image 1", "OpenKeyWord Logo" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
   @Test
  public void tc_VerifyCaptionWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyCaptionWCM( "Image 1", "OpenKeyWord Logo" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
   @Test
  public void tc_VerifyCaptionREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyCaptionREGX( "Image 1", "OpenKeyWord Logo" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void tc_VerifyLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyLabel( "Image 1", "Label: Image 1" );
      EN.VerifyLabel( "Image 2", "Label: Image 2" );
      
      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void tc_VerifyLabelWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyLabelWCM( "Image 1", "Label: Image #" );
      EN.VerifyLabelWCM( "Image 2", "Label: Image #" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void tc_VerifyLabelREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyLabelREGX( "Image 1", "Label: Image 1" );
      EN.VerifyLabelREGX( "Image 2", "Label: Image 2" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Prüft VerifyValue für SeImage
   * 
   * Value prüft gegen den aktuellen Wert des Attributes "src"
   */
  @Test
  public void tc_VerifyValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyValue( "Image 1", "https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Prüft VerifyValueWCM für SeImage
   * 
   * Value prüft gegen den aktuellen Wert des Attributes "src"
   */  
  @Test
  public void tc_VerifyValueWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyValueWCM( "Image 1", "https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /**
   * Prüft VerifyValueREGX für SeImage
   * 
   * Value prüft gegen den aktuellen Wert des Attributes "src"
   */  
  @Test
  public void tc_VerifyValueREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyValueREGX( "Image 1", "https://www.openkeyword.de/images/OKW_Logos/150x78/okw_color_msoffice_nobackground.png" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   *  Prüft die Methode VerifyExists.
   *
   *  Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _nicht_
   *  vorhanden ist.
   */
  @Test
  public void tc_VerifyExists_NO() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

      EN.SelectWindow( "Image" );
      EN.VerifyExists( "Image 1", "YES" );
      EN.VerifyExists( "Image 2", "YES" );
      EN.VerifyExists( "Does Not Exists", "NO" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /**
   *  Prüft die Methode VerifyExists.
   * 
   *  Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _nicht_ vorhanden
   *  ist.
   *  -> Exception muss ausgelöst werden.
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyExists_NO_YesObject() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyExists( "Image 1", "NO" );

    EN.StopApp( ApplicationName );
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  /**
   *  Prüft die Methode SeLink.VerifyExists.
   * 
   *  Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _vorhanden_ ist.
   */
  @Test
  public void tc_VerifyExists_YES() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyExists( "Image 1", "YES" );
    EN.VerifyExists( "Image 2", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /**
   *  Prüft die Methode SeLink.VerifyExists.
   * 
   *  Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _vorhanden_
   *  ist.
   */
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void tc_VerifyExists_YES_NoObject() throws Exception
  {

    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyExists( "Does Not Exists", "YES" );

    EN.StopApp( ApplicationName );
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
    {
        EN.EndTest();
    });
  }

  @Test
  public void tc_VerifyToolTip() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyTooltip( "Image 1", "Title: Image 1" );
    EN.VerifyTooltip( "Image 2", "Title: Image 2" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tc_VerifyToolTipWCM() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyTooltipWCM( "Image 1", "Title: Image #" );
    EN.VerifyTooltipWCM( "Image 2", "Title: Image #" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void tc_VerifyToolTipREGX() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

    EN.SelectWindow( "Image" );
    EN.VerifyTooltipREGX( "Image 1", "Title: Image 1" );
    EN.VerifyTooltipREGX( "Image 2", "Title: Image 2" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }
  
  /**
   * \~german
   *  Prüft ob die DoubleClickOn die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
   * \~english
   *
   * \~
   * @author Zoltán Hrabovszki
   * @date 2019-07-07
   */
   @Test //(expected= OKWFrameObjectMethodNotImplemented.class)
    public void tcDoubleClickOn_en() throws Exception
    {
        EN.BeginTest( TestName );

        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

        EN.SelectWindow( "Image" );
        EN.DoubleClickOn( "Image 1");
        
        Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
        {
            EN.EndTest();
        });
    }
   
    
    /**
     * \~german
     *  Prüft ob die SetValue die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2019-07-07
     */ 
   @Test // (expected= OKWFrameObjectMethodNotImplemented.class)
      public void tcSetValue_en() throws Exception
      {
          EN.BeginTest( TestName );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

          EN.SelectWindow( "Image" );

          EN.SetValue( "Image 1", "SetValue");
          Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
          {
              EN.EndTest();
          });
      }
     
     /**
      * \~german
      *  Prüft ob die Select die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
      * \~english
      *
      * \~
      * @author Zoltán Hrabovszki
      * @date 2019-07-07
      */  @Test // (expected= OKWFrameObjectMethodNotImplemented.class)
       public void tcSelect_en() throws Exception
       {
           EN.BeginTest( TestName );

           EN.StartApp( ApplicationName );
           EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

           EN.SelectWindow( "Image" );

           EN.Select( "Image 1", "Set a Value");
           Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
           {
               EN.EndTest();
           });
       }

      /**
       * \~german
       *  Prüft ob die SelectMenu( FN die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
       * \~english
       *
       * \~
       * @author Zoltán Hrabovszki
       * @date 2019-07-07
       */  @Test // (expected= OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu2_en() throws Exception
        {
            EN.BeginTest( TestName );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

            EN.SelectWindow( "Image" );

            EN.SelectMenu( "Image 1");
            Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
            {
                EN.EndTest();
            });
        }
      
      /**
       * \~german
       *  Prüft ob die SelectMenu( FN, Val ) die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
       * \~english
       *
       * \~
       * @author Zoltán Hrabovszki
       * @date 2019-07-07
       */  @Test // (expected= OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu_en() throws Exception
        {
            EN.BeginTest( TestName );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

            EN.SelectWindow( "Image" );

            EN.SelectMenu( "Image 1", "SetValue");
            Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
            {
                EN.EndTest();
            });
        }
       
       
       /**
        * \~german
        *  Prüft ob die TypeKey( FN, Val ) die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
        * \~english
        *
        * \~
        * @author Zoltán Hrabovszki
        * @date 2019-07-07
        */
       @Test // (expected=OKWFrameObjectMethodNotImplemented.class)
         public void tcTypeKey_en() throws Exception
         {
             EN.BeginTest( TestName );

             EN.StartApp( ApplicationName );
             EN.TypeKey( "URL", "http://test.openkeyword.de/Image/img.htm" );

             EN.SelectWindow( "Image" );

             EN.TypeKey( "Image 1", "SetValue");
             
             Assertions.assertThrows( OKWFrameObjectMethodNotImplemented.class, () ->
             {
                 EN.EndTest();
             });
         }

}
