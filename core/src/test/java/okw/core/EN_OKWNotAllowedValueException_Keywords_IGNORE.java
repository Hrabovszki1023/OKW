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
import okw.exceptions.OKWNotAllowedValueException;
import okw.log.Logger_Sngltn;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EN_OKWNotAllowedValueException_Keywords_IGNORE
{

    static Logger_Sngltn     myLogger    = Logger_Sngltn.getInstance();
    static OKW_TestClipboard myClipBoard = OKW_TestClipboard.getInstance();

    @Rule
    public TestName          name        = new TestName();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception
    {
        // Reset des Loggers: Alle Geladenen Instanzen löschen
        Logger_Sngltn.init();
        //myLogger.AddLogger(new Log2Console());

        myLogger.setDebugMode( false );
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeCaptionIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeCaption( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeCaptionIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeCaption( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeExistsIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeExists( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeExistsIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeExists( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeHasFocusIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeHasFocus( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeHasFocusIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeHasFocus( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeIsActiveIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeIsActive( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeIsActiveIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeIsActive( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeLabelIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeLabel( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeLabelIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeLabel( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizePlaceholderIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizePlaceholder( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizePlaceholderIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizePlaceholder( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeSelectedValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeSelectedValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeTablecellValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeTablecellValue( "All_MethodsObj", "", "", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeTablecellValueIGNORE2() throws Exception
    {
        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeTablecellValue( "All_MethodsObj", "", "", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeTooltipIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeTooltip( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeTooltipIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeTooltip( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeValue( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcMemorizeValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeValue( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSelectMenuIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.SelectMenu( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSelectMenuIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.SelectMenu( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSelectIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.Select( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSelectIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.Select( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSequenceIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.Sequence( "All_MethodsObj", "Method", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSequenceIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.Sequence( "All_MethodsObj", "Method", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSetValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.SetValue( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcSetValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.SetValue( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcTypeKeyTablecellIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.TypeKeyTablecell( "All_MethodsObj", "", "", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcTypeKeyTablecellIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.TypeKeyTablecell( "All_MethodsObj", "", "", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcTypeKeyIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.TypeKey( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcTypeKeyIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.TypeKey( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaption( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaption( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyCaptionWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyCaptionWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabel( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabel( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyLabelWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyLabelWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholder( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholder( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholderREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyPlaceholderWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyPlaceholderWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyExistsIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyExists( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyExistsIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyExists( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyHasFocusIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyHasFocusIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyIsActiveIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyIsActive( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyIsActiveIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyIsActive( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValueREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValueREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValueWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifySelectedValueWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifySelectedValueWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValue( "All_MethodsObj", "", "", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValue( "All_MethodsObj", "", "", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueREGX( "All_MethodsObj", "", "", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueREGX( "All_MethodsObj", "", "", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "", "", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTablecellValueWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTablecellValueWCM( "All_MethodsObj", "", "", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltip( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltip( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltipREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.MemorizeExists( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltipWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyTooltipWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyTooltipWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValue( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValue( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueREGXIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValueREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueREGXIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValueREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueWCMIGNORE1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValueWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyValueWCMIGNORE2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyValueWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadge1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadge( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadge2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadge( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadgeWCM1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadgeWCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadgeWCM2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadgeWCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadgeREGX1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadgeREGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyBadgeREGX2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyBadgeREGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyMaxLength1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyMaxLength( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyMaxLength2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyMaxLength( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyMinLength1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyMinLength( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyMinLength2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyMinLength( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyErrorMSG1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVVerifyErrorMSG2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyErrorMSG_WCM1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG_WCM( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyErrorMSG_WCM2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG_WCM( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }

    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyErrorMSG_REGX1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG_REGX( "All_MethodsObj", "${IGNORE} " );

        EN.EndTest();
    }

    /**
     * \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test( expected = OKWNotAllowedValueException.class )
    public void tcVerifyErrorMSG_REGX2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow( "Rechner" );
        EN.VerifyErrorMSG_REGX( "All_MethodsObj", "${IGNORE}${TCN}" );

        EN.EndTest();
    }
}
