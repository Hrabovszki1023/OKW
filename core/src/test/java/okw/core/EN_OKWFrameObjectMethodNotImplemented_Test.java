/*
    ==============================================================================
      Author: Zoltán Hrabovszki <zh@openkeyword.de>

      Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

package okw.core;

import okw.OKW_TestClipboard;
import okw.exceptions.OKWFrameObjectMethodNotFoundException;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.Logger_Sngltn;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EN_OKWFrameObjectMethodNotImplemented_Test
{

    static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName          name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        Logger_Sngltn myLogger = Logger_Sngltn.getInstance();

        // Reset des Loggers: Alle Geladenen Instanzen löschen
        Logger_Sngltn.init();
        // myLogger.AddLogger(new Log2Console());

        myLogger.setDebugMode( false );
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception
    {
    }

    /**
     *  \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von ClickOn() ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_ClickOn_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "Rechner" );
        EN.ClickOn( "NoMethodObj" );
        
        EN.EndTest();
    }

    /**
     *  \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  DoubleClickOn() ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_DoubleClickOn_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "Rechner" );
        EN.DoubleClickOn( "NoMethodObj" );
        
        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von Select() ausgelöst wird.
     * 
     * \~english
     * \~
     * @author Zoltan Hrabovszki
     * @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_Select_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "Rechner" );
        EN.Select( "NoMethodObj", "NoValue" );
        
        EN.EndTest();
    }

    /**
     *  \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  SelectMenu() ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_SelectMenu_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "Rechner" );
        EN.SelectMenu( "NoMethodObj" );
        
        EN.EndTest();
    }

    /**
     *  \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  SetFocus( FN ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_SetFocus_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.SetFocus( "NoMethodObj" );
        
        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented
     * von SetValue( FN, Val ) ausgelöst wird.
     * 
     * \~english \~ @author Zoltan Hrabovszki @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_SetValue_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.SetValue( "NoMethodObj", "NoValue" );
        
        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented
     * von LogPlaceholder( FN ) ausgelöst wird.
     * 
     * \~english \~ @author Zoltan Hrabovszki @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_LogPlaceholder_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.LogPlaceholder( "NoMethodObj" );
        
        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented
     * von MemorizePlaceholder( FN, MemKey ) ausgelöst wird.
     * 
     * \~english \~ @author Zoltan Hrabovszki @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_MemorizePlaceholder_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.MemorizePlaceholder( "NoMethodObj", "myKey" );
        
        EN.EndTest();
    }

    /**
     * \~german \brief Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented
     * von TypeKey( FN, Val ) ausgelöst wird.
     * 
     * \~english \~ @author Zoltan Hrabovszki @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_TypeKey_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "Rechner" );
        EN.TypeKey( "NoMethodObj", "NoValue" );
        
        EN.EndTest();
    }

    /** \~german
     *   Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *   SelectWindow ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_Select_Window_OKWFrameObjectMethodNotImplemented_Test() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "WindowWithoutMethods" );
        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  StartApp( AppName ) ausgelöst wird, wenn die Methode StartApp im 
     *  Window-GUI-Adapter nicht definiert ist.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.06.18
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_StartApp_OKWFrameObjectMethodNotImplemented_Test() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.StartApp( "WindowWithoutMethods" );
        
        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  StopApp( AppName ) ausgelöst wird, wenn die Methode StopApp im 
     *  Window-GUI-Adapter nicht definiert ist.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.06.18
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void tc_StopApp_OKWFrameObjectMethodNotImplemented_Test() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.StopApp( "WindowWithoutMethods" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyHasFocus( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyHasFocus_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyHasFocus( "NoMethodObj", "YES" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyIsActive( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyIsActive_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyIsActive( "NoMethodObj", "YES" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaption( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyCaption_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyCaption( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaptionREGX( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyCaptionREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaptionWCM( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyCaptionWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaption( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    **/
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyLabel_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyLabel( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaptionREGX( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyLabelREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaptionWCM( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2016.05.07
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyLabelWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyMaxLength( FN, ExpVal ) ausgelöst wird,
    *  wenn die Methode im GUI-Adapter nicht implementiert ist.
    * 
    *  \~english
    *  Checks whether the OKWFrameObjectMethodNotImplemented exception is raised 
    *  by VerifyMaxLength( FN, ExpVal ),
    *  if the method is not implemented in the GUI adapter.
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2018-12-26
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyMaxLength_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyMaxLength( "NoMethodObj", "2" );

        EN.EndTest();
    }

    /**
    * \~german
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyCaption( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2018-10-04
    **/
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyPlaceholder_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholder( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  \brief
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyPlaceholderREGX( FN, ExpVal ) ausgelöst wird.
    * 
    *  \~english
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2018-10-04
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyPlaceholderREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholderREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
    * \~german
    *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    *  VerifyPlaceholderWCM( FN, ExpVal ) ausgelöst wird,
    *  wenn die Methode im GUI-Adapter nicht implementiert ist.
    * 
    *  \~english
    *  Checks whether the OKWFrameObjectMethodNotImplemented exception is raised 
    *  by VerifyPlaceholderWCM( FN, ExpVal ),
    *  if the method is not implemented in the GUI adapter.
    *  \~
    *  @author Zoltan Hrabovszki
    *  @date 2018-10-04
    */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyPlaceholderWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTooltip( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTooltip_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltip( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTooltipREGX( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTooltipREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltipREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTooltipWCM( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTooltipWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltipWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyValue( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyValue_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyValue( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyValueREGX( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyValueREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyValueWCM( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016.05.07
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyValueWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTablecellValue( FN, X, Y, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTablecellValue_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValue( "NoMethodObj", "X", "Y", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTablecellValueREGX( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTablecellValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueREGX( "NoMethodObj", "X", "Y", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyTablecellValueWCM( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifyTablecellValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueWCM( "NoMethodObj", "X", "Y", "NoValue" );

        EN.EndTest();
    }

    
    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifySelectedValue( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifySelectedValue_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValue( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  \brief
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifySelectedValueREGX( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifySelectedValueREGX_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyValueREGX( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    /**
     * \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyValueWCM( FN, ExpVal ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2016-05-21
     */
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_VerifySelectedValueWCM_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValueWCM( "NoMethodObj", "NoValue" );

        EN.EndTest();
    }

    
    /**
     *  \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  Sequence( FN, SEQ_NAME, SEQ_ID ) ausgelöst wird.
     * 
     *  \~english
     *  \~
     *  @author Zoltan Hrabovszki
     *  @date 2013.12.26
     */
    @Test( expected = OKWFrameObjectMethodNotFoundException.class )
    public void TC_Sequence_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.Sequence( "Rechner", "NoMethodObj", "SEQ_ID" );

        EN.EndTest();
    }
    
    /**
     * \~german
     *  Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
     *  VerifyMinLength( FN, ExpVal ) ausgelöst wird,
     *  wenn die Methode im GUI-Adapter nicht implementiert ist.
     * 
     *  \~english
     *  Checks whether the OKWFrameObjectMethodNotImplemented exception is raised 
     *  by VerifyMinLength( FN, ExpVal ),
     *  if the method is not implemented in the GUI adapter.
     *  \~
     *  @author Daniel Krüger
     *  @date 2019-06-18
     */
     @Test( expected = OKWFrameObjectMethodNotImplemented.class )
     public void TC_VerifyMinLength_OKWFrameObjectMethodNotImplemented() throws Exception
     {
         EN.BeginTest( name.getMethodName() );

         EN.SelectWindow( "Rechner" );
         EN.VerifyMinLength( "NoMethodObj", "2" );

         EN.EndTest();
     }
}
