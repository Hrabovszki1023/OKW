/** 
 *  OKW__Test__AllMethodCalls.cs
 *
 *  Author:
 *       zoltan <${AuthorEmail}>
 *
 *  Copyright(c) 2012, 2013, 2014, 2015, 2016 zoltan
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package okw.core;

import okw.OKW_TestClipboard;
import okw.exceptions.OKWFrameObjectMethodNotFoundException;
import okw.exceptions.OKWFrameObjectMethodNotImplemented;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

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
     * \brief
     * Diese Methode wird immer vor jedem Test(fall) ausgeführt.
     */
    @Before
    public void setUp() throws Exception
    {
        // EN.BeginTest( "TestContext.CurrentContext.Test.Name" );
    }

    // / \~german
    // / \brief
    // / Diese Methode wird immer nach jedem Test(fall) ausgeführt.
    // /
    @After
    public void tearDown() throws Exception
    {
        EN.EndTest();
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
    }

    /**
     * \~german \brief Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented
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
    }

    // / \~german
    // / \brief
    // / Prüft ob die Ausnahme OKWFrameObjectMethodNotImplemented von
    // SelectWindow ausgelöst wird.
    // /
    // / \~english
    // / \~
    // / @author Zoltan Hrabovszki
    // / @date 2016.05.07
    @Test( expected = OKWFrameObjectMethodNotImplemented.class )
    public void TC_Select_Window_OKWFrameObjectMethodNotImplemented_Test() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
    
        EN.SelectWindow( "WindowWithoutMethods" );
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
    public void TC_VerifyLabel_OKWFrameObjectMethodNotImplemented() throws Exception
    {
        EN.BeginTest( name.getMethodName() );

        EN.SelectWindow( "Rechner" );
        EN.VerifyLabel( "NoMethodObj", "NoValue" );
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
    }

}
