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
package okw.selink;

import okw.OKWTestBase;
import okw.OKW_Memorize_Sngltn;
import okw.core.EN;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.exceptions.OKWVerifyingFailsException;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
* \~
* @ingroup groupSeleniumChildGUIAdapterTests
* 
* @author zoltan
*/
@Disabled
public class SeLink_EN_Test extends OKWTestBase
{
  String                  cvOKWObject = "Link" + "";

  protected OKW_Memorize_Sngltn     myMM        = OKW_Memorize_Sngltn.getInstance();

  protected static String ApplicationName;

  @Test
  public void TC_ClickOn() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.ClickOn( "Google" );
      EN.VerifyValue( "URL", "https://www.google.de/?gws_rd=ssl" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

    
  @Test
  public void TC_LogCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.LogCaption( "Google" );
      EN.LogCaption( "Yahoo" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_LogLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.LogLabel( "Google" );
      EN.LogLabel( "Yahoo" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
 }

  
  @Test
  public void TC_LogValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );

      EN.LogValue( "Google" );
      EN.LogValue( "Yahoo" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /// \brief
  /// Prüft ob ein vorhandenes objekt existiert.
  /// Erwartet wird, dass das Objekt existiert.
  ///
  @Test
  public void TC_LogExists_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );

      EN.LogExists( "Google" );
      EN.LogExists( "Yahoo" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /// \brief
  /// Focus eines Textfeldes loggen.
  ///
  @Test
  public void TC_LogHasFocus_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );

      EN.LogHasFocus( "Google" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

/**
 * \~german
 *  Prüft ob die LogIsActive die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
 * \~english
 *
 * \~
 * @author Zoltán Hrabovszki
 * \date 2017-04-30
 */  @Test // ( expected= UnsupportedOperationException.class)
  public void tcLogIsActive_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );

      EN.LogIsActive( "Google" );

      EN.StopApp( ApplicationName );
      Assertions.assertThrows( UnsupportedOperationException.class, () ->
    {
        EN.EndTest();
    });
  }
  
 /**
  * \~german
  *  Prüft ob die VerifyIsActive die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
  * \~english
  *
  * \~
  * @author Zoltán Hrabovszki
  * \date 2017-04-30
  */  @Test // ( expected= UnsupportedOperationException.class)
   public void tcMemorizeIsActive_en() throws Exception
   {
       EN.BeginTest( TestName );

       EN.StartApp( ApplicationName );
       EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

       EN.SelectWindow( "Link" );

       EN.MemorizeIsActive( "Google", "Schlüssel" );

       EN.StopApp( ApplicationName );
       Assertions.assertThrows( UnsupportedOperationException.class, () ->
        {
            EN.EndTest();
        });
  }
  
  /**
   * \~german
   *  Prüft ob die VerifyIsActive die Ausnahme OKWFrameObjectMethodNotImplemented auslöst.
   * \~english
   *
   * \~
   * @author Zoltán Hrabovszki
   * \date 2017-04-30
   */  @Test // ( expected= UnsupportedOperationException.class)
    public void tcVerifyIsActive_UnsupportedOperationException() throws Exception
    {
        EN.BeginTest( TestName );

        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

        EN.SelectWindow( "Link" );

        EN.VerifyIsActive( "Google", "YES" );

        EN.StopApp( ApplicationName );
        Assertions.assertThrows( UnsupportedOperationException.class, () ->
        {
            EN.EndTest();
        });
    }

 
  /// \brief
  /// Tooltip eines Textfeldes Prüfen.
  ///
  @Test
  public void TC_LogToolTip_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );

      EN.LogTooltip( "Google" );
      EN.LogTooltip( "Yahoo" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_MemorizeCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeCaption( "Google", "SeLink_MemorizeCaption_1" );
      assertEquals( "Google...", myMM.get( "SeLink_MemorizeCaption_1" ) );

      EN.MemorizeCaption( "Yahoo", "SeLink_MemorizeCaption_1" );
      assertEquals( "Yahoo...", myMM.get( "SeLink_MemorizeCaption_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

    
  @Test
  public void TC_MemorizeLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeLabel( "Google", "SeLink_MemorizeLabel_1" );
      assertEquals( "Label Google:", myMM.get( "SeLink_MemorizeLabel_1" ) );

      EN.MemorizeLabel( "Yahoo", "SeLink_MemorizeLabel_1" );
      assertEquals( "Label Yahoo:", myMM.get( "SeLink_MemorizeLabel_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_MemorizeValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeValue( "Google", "SeLinkMemorizeValue1" );

      // Gemerkten Href-Wert als URL eingeben...
      EN.TypeKey( "URL", "${SeLinkMemorizeValue1}" );

      EN.VerifyValueWCM( "URL", "https://www.google.de*" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /// \brief
  /// Prüft die Methode SeLink.MemorizeToolTip.
  ///
  @Test
  public void TC_MemorizeExists_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeExists( "Google", "SeLink_MemorizeExists_1" );
      assertEquals( "YES", myMM.get( "SeLink_MemorizeExists_1" ) );

      EN.MemorizeExists( "Yahoo", "SeLink_MemorizeExists_1" );
      assertEquals( "YES", myMM.get( "SeLink_MemorizeExists_1" ) );

      EN.MemorizeExists( "LinkNotExists", "SeLink_MemorizeExists_1" );
      assertEquals( "NO", myMM.get( "SeLink_MemorizeExists_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /// \brief
  /// Prüft die Methode SeLink.MemorizeFocus.
  ///
  @Test
  public void TC_MemorizeHasFocus_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeHasFocus( "Yahoo", "SeLink_MemorizeHasFocus" );
      assertEquals( "NO", myMM.get( "SeLink_MemorizeHasFocus" ) );

      EN.SetFocus( "Yahoo" );
      EN.MemorizeHasFocus( "Yahoo", "SeLink_MemorizeHasFocus" );
      assertEquals( "YES", myMM.get( "SeLink_MemorizeHasFocus" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  /// \brief
  /// Prüft die Methode SeLink.MemorizeToolTip.
  ///
  @Test
  public void TC_MemorizeToolTip_en() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.MemorizeTooltip( "Google", "SeLink_MemorizeTooltip_1" );
      assertEquals( "Title: Google", myMM.get( "SeLink_MemorizeTooltip_1" ) );

      EN.MemorizeTooltip( "Yahoo", "SeLink_MemorizeTooltip_1" );
      assertEquals( "Title: Yahoo", myMM.get( "SeLink_MemorizeTooltip_1" ) );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_SetFocus_VerifyHasFocus() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.SetFocus( "Google" );

      EN.VerifyHasFocus( "Google", "YES" );
      EN.VerifyHasFocus( "Yahoo", "NO" );

      EN.SetFocus( "Yahoo" );

      EN.VerifyHasFocus( "Yahoo", "YES" );
      EN.VerifyHasFocus( "Google", "NO" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_VerifyCaption() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyCaption( "Google", "Google..." );
      EN.VerifyCaption( "Yahoo", "Yahoo..." );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_VerifyCaptionWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyCaptionWCM( "Google", "Google???" );
      EN.VerifyCaptionWCM( "Yahoo", "Yahoo???" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_VerifyCaptionREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyCaptionREGX( "Google", "Google\\W{3}" );
      EN.VerifyCaptionREGX( "Yahoo", "Yahoo\\W{3}" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void TC_VerifyLabel() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyLabel( "Google", "Label Google:" );
      EN.VerifyLabel( "Yahoo", "Label Yahoo:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_VerifyLabelWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyLabelWCM( "Google", "Label Google?" );
      EN.VerifyLabelWCM( "Yahoo", "Label Yahoo?" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void TC_VerifyLabelREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyLabelREGX( "Google", "Label Google:" );
      EN.VerifyLabelREGX( "Yahoo", "Label Yahoo:" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void TC_VerifyValue() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyValue( "Google", "http://www.google.de/" );
      EN.VerifyValue( "Yahoo", "http://www.yahoo.de/" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  @Test
  public void TC_VerifyValueWCM() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyValueWCM( "Google", "http?//www.google.de*" );
      EN.VerifyValueWCM( "Yahoo", "http?//www.yahoo.de*" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }


  @Test
  public void TC_VerifyValueREGX() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyValueREGX( "Google", "http\\W//www.google.de.*" );
      EN.VerifyValueREGX( "Yahoo", "http\\W//www.yahoo.de.*" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /// \brief
  /// Prüft die Methode SeLink.MemorizeToolTip.
  ///
  /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _nicht_
  /// vorhanden ist.
  ///
  @Test
  public void TC_VerifyExists_NO() throws Exception
  {
      EN.BeginTest( TestName );

      EN.StartApp( ApplicationName );
      EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

      EN.SelectWindow( "Link" );
      EN.VerifyExists( "LinkNotExists", "NO" );

      EN.StopApp( ApplicationName );
      EN.EndTest();
  }

  
  /// \brief
  /// Prüft die Methode SeLink.VerifyExists.
  ///
  /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _nicht_ vorhanden
  /// ist.
  /// -> Exception muss ausgelöst werden.
  ///
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyExists_NO_YesObject() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyExists( "Google", "NO" );

    EN.StopApp( ApplicationName );
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });
  }

  /// \brief
  /// Prüft die Methode SeLink.VerifyExists.
  ///
  /// Objekt _ist vorhanden_. Erwartet wird, dass das Objekt _vorhanden_ ist.
  ///
  @Test
  public void TC_VerifyExists_YES() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyExists( "Google", "YES" );
    EN.VerifyExists( "Yahoo", "YES" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  /// \brief
  /// Prüft die Methode SeLink.VerifyExists.
  ///
  /// Objekt ist _nicht_ vorhanden. Erwartet wird, dass das Objekt _vorhanden_
  /// ist.
  ///
  @Test // ( expected = OKWVerifyingFailsException.class )
  public void TC_VerifyExists_YES_NoObject() throws Exception
  {

    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyExists( "LinkNotExists", "YES" );

    EN.StopApp( ApplicationName );
    Assertions.assertThrows( OKWVerifyingFailsException.class, () ->
        {
            EN.EndTest();
        });
  }

  @Test
  public void TC_VerifyToolTip() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyTooltip( "Google", "Title: Google" );
    EN.VerifyTooltip( "Yahoo", "Title: Yahoo" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void TC_VerifyToolTipWCM() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyTooltipWCM( "Google", "Title? Google" );
    EN.VerifyTooltipWCM( "Yahoo", "Title? Yahoo" );

    EN.StopApp( ApplicationName );
    EN.EndTest();
  }

  @Test
  public void TC_VerifyToolTipREGX() throws Exception
  {
    EN.BeginTest( TestName );

    EN.StartApp( ApplicationName );
    EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

    EN.SelectWindow( "Link" );
    EN.VerifyTooltipREGX( "Google", "Title\\W Google" );
    EN.VerifyTooltipREGX( "Yahoo", "Title\\W Yahoo" );

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
   * \date 2017-04-30
   */  @Test // ( expected= OKWFrameObjectMethodNotImplemented.class)
    public void tcDoubleClickOn_en() throws Exception
    {
        EN.BeginTest( TestName );

        EN.StartApp( ApplicationName );
        EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

        EN.SelectWindow( "Link" );

        EN.DoubleClickOn( "Google");

        EN.StopApp( ApplicationName );
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
     * \date 2017-04-30
     */  @Test // ( expected= OKWFrameObjectMethodNotImplemented.class)
      public void tcSetValue_OKWFrameObjectMethodNotImplemented() throws Exception
      {
          EN.BeginTest( TestName );

          EN.StartApp( ApplicationName );
          EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

          EN.SelectWindow( "Link" );

          EN.SetValue( "Google", "SetValue");
          
          EN.StopApp( ApplicationName );
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
      * \date 2017-04-30
      */  @Test // ( expected= OKWFrameObjectMethodNotImplemented.class)
       public void tcSelect_OKWFrameObjectMethodNotImplemented() throws Exception
       {
           EN.BeginTest( TestName );

           EN.StartApp( ApplicationName );
           EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

           EN.SelectWindow( "Link" );

           EN.Select( "Google", "SetValue");

           EN.StopApp( ApplicationName );
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
       * \date 2017-04-30
       */  
        @Test // ( expected= OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu2_OKWFrameObjectMethodNotImplemented() throws Exception
        {
            EN.BeginTest( TestName );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

            EN.SelectWindow( "Link" );

            EN.SelectMenu( "Google");
            
            EN.StopApp( ApplicationName );
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
       * \date 2017-04-30
       */  @Test // ( expected= OKWFrameObjectMethodNotImplemented.class)
        public void tcSelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
        {
            EN.BeginTest( TestName );

            EN.StartApp( ApplicationName );
            EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

            EN.SelectWindow( "Link" );

            EN.SelectMenu( "Google", "SetValue");

            EN.StopApp( ApplicationName );
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
        * \date 2017-04-30
        */  @Test // ( expected= UnsupportedOperationException.class)
         public void tcTypeKey_UnsupportedOperationException() throws Exception
         {
             EN.BeginTest( TestName );

             EN.StartApp( ApplicationName );
             EN.TypeKey( "URL", "http://test.openkeyword.de/Link/Link.htm" );

             EN.SelectWindow( "Link" );

             EN.TypeKey( "Google", "SetValue");

             EN.StopApp( ApplicationName );
             Assertions.assertThrows( UnsupportedOperationException.class, () ->
        {
            EN.EndTest();
        });
         }

}
