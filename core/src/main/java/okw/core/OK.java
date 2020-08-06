/*
    ==============================================================================
    Copyright © 2012 - 2019 IT-Beratung Hrabovszki
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

import okw.log.*;
import okw.parser.Parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// \todo TODO: ANTLR einbauen import OKW.ANTLR4;
import okw.*;
import okw.exceptions.*;
import okw.gui.IGUIChildwindow;
import okw.gui.IGUIWindow;

/** \~german
 * Klasse OK representiert den Core Zustand "OK".
 * 
 * Testausführung mit GUI-Aktivität und es ist keine Exception ausgelöst worden.
 * 
 * 2019-12-27 - LogMessenger + LM_Ok.xml auf ok.properties umgestellt.
 * 
 * \~english
 * \~
 * @author Zoltán Hrabovszki
 * @date 2013.03.02
 */
public class OK implements IOKW_State
{
    // \copydoc OKWLanguage
    private static OKWLanguage              CL;

    // \copydoc Logger_Sngltn
    private static Logger_Sngltn            Log;

    private static OKW_Properties           PROP;

    // \copydoc OKW_CurrentObject_Sngltn
    private static OKW_CurrentObject_Sngltn CO;

    // \copydoc OKW_Memorize_Sngltn
    private static OKW_Memorize_Sngltn      MEM;

    private Core                           _Kernel;

    // 
    protected Boolean                      VerifyFail = false;
    
    /** \~german
     * Klasse representiert den Zustand "OK" des OKW-Kerns im Ausführungsmodus.
     *
     * \~english
     *
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014.01.09
     */
    public OK( Core fp_OKW )
    {
        try
        {
            CL = OKWLanguage.getInstance();
            Log = Logger_Sngltn.getInstance();
            
            PROP = OKW_Properties.getInstance();
            
            CO = OKW_CurrentObject_Sngltn.getInstance();
            MEM = OKW_Memorize_Sngltn.getInstance();
    
            this._Kernel = fp_OKW;
        }
        catch (Exception e)
        {
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            e.printStackTrace( new PrintStream( stream ) );
    
            System.out.println( "=================================================================================" );
            System.out.println( "= Exception during initialization of Class >>OK<<! Stop running!" );
            System.out.println( "=================================================================================" );
            System.out.println( stream );
    
            System.exit( 1 );
        }
    }

    /**
     *  \~german
     * In dieser Methode werden zentral die Exceptions ausgewertet.
     *
     * Methode führt folge Aktivitäten aus:
     * -# Exception wird als Log ausgegeben.
     * -# Daten des aktuellen Objektes werden für eine Fehler-Analyse ausgegeben (CO.LogObjectData()).
     * -# Wenn es sich um eine OKWVerifyingFailsException handelt, dann geht der Status von VerifyFail nach true
     * -# Wechselt den Zustand auf NOK.
     * dann wird an das Unittest-Framework die Exception weitergereicht.
     *
     * \param e Exception aus der OK-Schlüsselwort-Methode
     * \~english
     * In this method the exceptions are evaluated centrally.
     *
     * method executes the following activities:
     * -# Exception is displayed as a log.
     * -# Data of the current object is output for an error analysis (CO.LogObjectData()).
     * -# If it is an OKWVerifyingFailsException, the status is "VerifyFail=true".
     * -# Changes the state to NOK.
     * then the exception is passed on to the Unittest framework.
     *
     * \param e Exception from the OK keyword method

     * \~
     * \author Zoltán Hrabovszki
     * \date 2013-03-02
     * @throws Exception 
     */
    protected void handleException( Exception e ) throws Exception
    {
        Exception e_Wrapped = null;
    
        if ( e instanceof okw.exceptions.OKWVerifyingFailsException )
        {
            Boolean lvbAbort = PROP.getProperty2Boolean( "core.AbortOnVerifyFail", "false" );
            _Kernel.setNOK_Reason( e );
            
            if ( lvbAbort )
            {
                // Change State to NOK if Property core.AbortOnVerifyFail is true
                logException( e, e_Wrapped );
                this._Kernel.SetCoreStateNOK( );
            }
            else
            {   // If we don't want to abort, then we stay at State OK!
                // Loggen zur Abbweichung die Objektdaten.
                logException( e, e_Wrapped );
                // Und/Aber Merken uns dass wir einen VerifyFehler hatte mit this.VerifyFail = true
                this.VerifyFail = true;
            }
        }
        // if we have an InvocationTargetException...
        else if ( e instanceof InvocationTargetException )
        {
            // ... then get the origin exception.
            e = ( Exception ) e.getCause();
            logException( e, e_Wrapped );
            this._Kernel.SetCoreStateNOK( );
            _Kernel.setNOK_Reason( e );
        }
        else if ( e instanceof RuntimeException )
        {
            // ... then get the origin exception.
            e_Wrapped = ( Exception ) e.getCause();
            logException( e, e_Wrapped );
            this._Kernel.SetCoreStateNOK( );
            _Kernel.setNOK_Reason( e );
        }
    }

    protected void logException( Exception e, Exception e_Wrapped )
    {
        Log.LogPrint( "==========================================================================" );
        Log.LogException( e.getMessage() );
    
        if ( e_Wrapped != null )
        {
            Log.ResOpenList( "Trigger of the exception..." );
            Log.LogPrint( "--------------------------------------------------------------------------" );
            Log.LogPrint( "Exception: " + e_Wrapped.toString() );
            Log.LogPrint( "--------------------------------------------------------------------------" );
            Log.ResCloseList();
        }

        Log.LogPrint( "==========================================================================" );
        CO.LogObjectData();
        Log.LogPrint( "==========================================================================" );
    }
    

    /**
     *  \copydoc IOKW_State::BeginTest()
     */
    public void BeginTest( String fpsTestname ) throws Exception
    {

        Log.LogFunctionStartDebug( "BeginTest", "fpsTestname", fpsTestname );
        try
        {
            OKW_Memorize_Sngltn.getInstance().set( "TCN", fpsTestname );
            
            this._Kernel.SetCoreStateOK();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::EndTest()
     * @throws Exception 
     */
    public void EndTest() throws Exception
    {
        Log.LogFunctionStartDebug( "EndTest" );
        
        String msg = "";
        
        try {
	        if ( this.VerifyFail )
	        { 
	            msg = PROP.getProperty( "ok.endtest.verifyfail.msg.${LANGUAGE}" );
	            Log.LogPrint( msg );

	        	throw _Kernel.getNOK_Reason();
	        }
	        else
	        {
	            msg = PROP.getProperty( "ok.endtest.verifypass.msg.${LANGUAGE}" );
	            Log.LogPrint( msg );
	        }
        }
        finally
        {           
            Log.LogFunctionEndDebug();
        }
        
    }

    /**
     * \copydoc IOKW_State::ClickOn(String)
     */
    public void ClickOn( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "ClickOn", "FN", FN );

        try
        {
            ( ( IGUIChildwindow ) CO.setChildName( FN ) ).ClickOn();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     * \copydoc IOKW_State::DoubleClickOn(String)
     */
    public void DoubleClickOn( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "DoubleClickOn", "FN", FN );

        try
        {
            ( ( IGUIChildwindow ) CO.setChildName( FN ) ).DoubleClickOn();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogCaption(String)
     */
    public void LogCaption( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogCaption", "FN", FN );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogCaption();

            Log.ResOpenListDebug( "Log... " );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseListDebug();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogExists(String)
     */
    public void LogExists( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogExists", "FN", FN );

        try
        {
            Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogExists();
            String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

            // String lvsLM = LM.GetMessage( "LogExists", "LogValue", lvsActual );
            // Print: "Value found: '%P1%'"
            String lvsLM = PROP.getProperty( "ok.Log.ValueFound.${LANGUAGE}", lvsActual );
            Log.LogPrint( lvsLM );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogHasFocus(String)
     */
    public void LogHasFocus( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogHasFocus", "FN", FN );

        try
        {
            Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogHasFocus();
            String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

            // String lvsLM = LM.GetMessage( "LogHasFocus", "LogValue", lvsActual );
            // Print: "Value found: '%P1%'"
            String lvsLM = PROP.getProperty( "ok.Log.ValueFound.${LANGUAGE}", lvsActual );
            Log.LogPrint( lvsLM );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogIsActive(String)
     */
    public void LogIsActive( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogIsActive", "FN", FN );

        try
        {
            Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogIsActive();
            String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

            //String lvsLM = LM.GetMessage( "LogIsActive", "LogValue", lvsActual );
            // Print: "Value found: '%P1%'"
            String lvsLM = PROP.getProperty( "ok.Log.ValueFound.${LANGUAGE}", lvsActual );
            Log.LogPrint( lvsLM );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogLabel(String)
     */
    public void LogLabel( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogLabel", "FN", FN );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogLabel();

            Log.ResOpenList( "Log... " );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }
    
    /**
     *  \copydoc IOKW_State::LogPlaceholder(String)
     */
    public void LogPlaceholder( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogPlaceholder", "FN", FN );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogPlaceholder();

            Log.ResOpenList( "Log... " );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::LogSelected(String)
     */
    public void LogSelected( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogSelected", "FN", FN );

        try
        {
            ArrayList<String> actualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogSelected();

            // String lvsLM = LM.GetMessage( "LogSelected", "LogValue" );

            // String lvsLM = LM.GetMessage( "LogSelected", "LogValue" );
            String lvsLM = PROP.getProperty( "ok.Log.ListValuesFound.${LANGUAGE}" );
            Log.ResOpenList( lvsLM );

            for ( String Value : actualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogTablecellValue(String,String,String)
     */
    public void LogTablecellValue( String FN, String COL, String ROW ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogTablecellValue", "String FN", FN, "COL", COL, "ROW", ROW );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogTablecellValue( COL, ROW );

            String lvsLM = PROP.getProperty( "ok.Log.ListValuesFound.${LANGUAGE}" );
            Log.ResOpenList( lvsLM );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( ">>" + Value + "<<" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogTooltip(String)
     */
    public void LogTooltip( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogTooltip", "FN", FN );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogTooltip();

            String lvsLM = PROP.getProperty( "ok.Log.ListValuesFound.${LANGUAGE}" );
            Log.ResOpenList( lvsLM );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::LogValue(String)
     */
    public void LogValue( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "LogValue", "FN", FN );

        try
        {
            ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).LogValue();

            String lvsLM = PROP.getProperty( "ok.Log.ListValuesFound.${LANGUAGE}" );
            Log.ResOpenList( lvsLM );

            for ( String Value : ActualValues )
            {
                Log.LogPrint( "'" + Value + "'" );
            }

            Log.ResCloseList();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeCaption(String,String)
     */
    public void MemorizeCaption( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeCaption", "FN", FN, "fpsMemKeyName", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( MemKey ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeCaption();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeExists(String,String)
     */
    public void MemorizeExists( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeExists", "FN", FN, "MemKey", MemKey );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeExists();

                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                MEM.set( MemKey, lvsActual );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeHasFocus(String,String)
     */
    public void MemorizeHasFocus( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeHasFocus", "FN", FN, "MemKey", MemKey );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fps_MemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
                }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeHasFocus();

                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                MEM.set( MemKey, lvsActual );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeIsActive(String,String)
     */
    public void MemorizeIsActive( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeIsActive", "FN", FN, "MemKey", MemKey );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                Boolean lvbActual = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeIsActive();

                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                MEM.set( MemKey, lvsActual );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeLabel(String,String)
     */
    public void MemorizeLabel( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeLabel", "FN", FN, "MemKey", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fps_MemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeLabel();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizePlaceholder(String,String)
     */
    public void MemorizePlaceholder( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizePlaceholder", "FN", FN, "MemKey", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fps_MemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizePlaceholder();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeSelectedValue(String,String)
     */
    public void MemorizeSelectedValue( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeSelectedValue", "FN", FN, "MemKey", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fps_MemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeSelectedValue();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeTablecellValue(String,String,String,String) throws Exception
     */
    public void MemorizeTablecellValue( String FN, String COL, String ROW, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeTablecellValue", "FN", FN, "COL", COL, "ROW", ROW, "MemKey", MemKey );

        try
        {

            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeTablecellValue( COL, ROW );

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::MemorizeTooltip(String,String)
     */
    public void MemorizeTooltip( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeTooltip", "FN", FN, "fps_MemKeyName", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );

            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeTooltip();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     * \copydoc IOKW_State::MemorizeValue(String,String)
     */
    public void MemorizeValue( String FN, String MemKey ) throws Exception
    {
        Log.LogFunctionStartDebug( "MemorizeValue", "FN", FN, "MemKey", MemKey );

        try
        {
            if ( MemKey.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || MemKey.equals( "" ) )
            {
                // Wenn fpsMemKeyName = IGNORE oder "" ist ->
                // OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", MemKey );
                throw new OKWNotAllowedValueException( lvsLM );

            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in MemVal ->  trigger OKWNotAllowedValueException
                this.newMethod( MemKey, "IGNORE", "DELETE" );                

                ArrayList<String> ActualValues = ( ( IGUIChildwindow ) CO.setChildName( FN ) ).MemorizeValue();

                String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP( ActualValues );

                MEM.set( MemKey, lvsToMemorize );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::Select(String,String)
     */
    public void Select( String FN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "Select", "FN", FN, "Val", Val );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( Val ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> Abbrechen...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                

                // Sonst Methode des Objektes aufrufen....
                ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );

                lvlsValue = Parser.ParseMe( lvlsValue );

                ( ( IGUIChildwindow ) CO.setChildName( FN ) ).Select( lvlsValue );

            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectMenu(String)
     */
    public void SelectMenu( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "SelectMenu", "FN", FN );

        try
        {
            ( ( IGUIChildwindow ) CO.setChildName( FN ) ).SelectMenu();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     * \copydoc IOKW_State::SelectMenu(String,String)
     */
    public void SelectMenu( String FN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "SelectMenu", "FN", FN, "Val", Val );

        try
        {
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || Val.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> Abbrechen...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                

                ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );

                ( ( IGUIChildwindow ) CO.setChildName( FN ) ).SelectMenu( lvlsValue );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectTablecell(String,String,String)
     */
    public void SelectTablecell( String FN, String COL, String ROW ) throws Exception
    {
        Log.LogFunctionStartDebug( "SelectTablecell", "FN", FN, "COL", COL, "ROW", ROW );

        try
        {
            ( ( IGUIChildwindow ) CO.setChildName( FN ) ).SelectTablecell( COL, ROW );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectWindow(String)
     */
    public void SelectWindow( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "OK.SelectWindow", "FN", FN );

        try
        {
            ( ( IGUIWindow ) CO.setWindowName( FN ) ).SelectWindow();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug(  );
        }
    }

    
    /**
     *  \copydoc IOKW_State::SelectChild(String)
     */
    public void SelectChild( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "SelectChild", "FN", FN );

        try
        {
            CO.setChildName( FN );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::SelectContext(String)
     */
    public void SelectContext( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "OK.SelectContext", "FN", FN );

        try
        {
            CO.setWindowName( FN );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug(  );
        }
    }
    
    /**
     *  \copydoc IOKW_State::Sequence(String,String,String)
     */
    public void Sequence( String FN, String SEQ_Name, String SEQ_ID ) throws Exception
    {
        Log.LogFunctionStartDebug( "Sequence", "FN", FN, "SEQ_Name", SEQ_Name, "SEQ_ID", SEQ_ID );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( SEQ_ID.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( SEQ_ID ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> Abbrechen...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in SEQ_ID ->  trigger OKWNotAllowedValueException
                this.newMethod( SEQ_ID, "IGNORE", "DELETE" );                

                CO.Sequence( FN, SEQ_Name, SEQ_ID );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::SetFocus(String)
     */
    public void SetFocus( String FN ) throws Exception
    {
        Log.LogFunctionStartDebug( "SetFocus", "FN", FN );

        try
        {
            ( ( IGUIChildwindow ) CO.setChildName( FN ) ).SetFocus();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /** \~german
     * \~english
     * \~
     * @author Zoltán Hrabovszki
     * @date 02.03.2013
     */
    public void setLanguage( String Language )
    {
        CL.setLanguage( Language );
    }

    /**
    *   \copydoc IOKW_State::SetValue(String,String)
    */
    public void SetValue( String FN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "SetValue", "FN", FN );

        ArrayList<String> lvlsValue;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || Val.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );

            }
            else
            {   
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                

                lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );

                lvlsValue = Parser.ParseMe( lvlsValue );

                ( ( IGUIChildwindow ) CO.setChildName( FN ) ).SetValue( lvlsValue );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }


    /**
     *   \copydoc IOKW_State::SetVar(String,String)
     */
    public void SetVar( String VN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "SetVar", "VN", VN );
        
        String lvsValue = "";

        try
        {
            lvsValue = Parser.ParseMe( Val );
            Log.LogPrint( VN + "= \"" + lvsValue + "\"" );
            OKW_Memorize_Sngltn.getInstance().set( VN, lvsValue );
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::StartApp(String)
     */
    public void StartApp( String AppName ) throws Exception
    {
        Log.LogFunctionStartDebug( "StartApp", "AppName", AppName );

        try
        {
            ( ( IGUIWindow ) CO.setWindowName( AppName ) ).StartApp();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::StopApp(String)
     */
    public void StopApp( String AppName ) throws Exception
    {
        Log.LogFunctionStartDebug( "StopApp", "AppName", AppName );

        try
        {
            ( ( IGUIWindow ) CO.setWindowName( AppName ) ).StopApp();
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKey(String,String)
     */
    public void TypeKey( String FN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "TypeKey", "FN", FN, "Val", Val );

        ArrayList<String> lvlsValue;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || Val.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                
                
                lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );

                lvlsValue = Parser.ParseMe( lvlsValue );

                ( ( IGUIChildwindow ) CO.setChildName( FN ) ).TypeKey( lvlsValue );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKeyTablecell(String,String,String,String)
     */
    public void TypeKeyTablecell( String FN, String COL, String ROW, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "TypeKeyTablecell", "FN", FN, "COL", COL, "ROW", ROW, "Val", Val );

        ArrayList<String> lvlsValue;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || Val.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                

                // Werte in Val separieren
                lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );

                lvlsValue = Parser.ParseMe( lvlsValue );

                ( ( IGUIChildwindow ) CO.setChildName( FN ) ).TypeKeyTablecell( COL, ROW, lvlsValue );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::TypeKeyWindow(String,String)
     */
    public void TypeKeyWindow( String FN, String Val ) throws Exception
    {
        Log.LogFunctionStartDebug( "TypeKeyWindow", "FN", FN, "Val", Val );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( Val.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || Val.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in Val ->  trigger OKWNotAllowedValueException
                this.newMethod( Val, "IGNORE" );                

                ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP( Val );
                lvlsValue = Parser.ParseMe( lvlsValue );

                ( ( IGUIWindow ) CO.setWindowName( FN ) ).TypeKeyWindow( lvlsValue );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
	 *  \copydoc IOKW_State::VerifyBadge(String,String)
	 */
	public void VerifyBadge( String FN, String ExpVal ) throws Exception
	{
	
	    ArrayList<String> lvlsExpected = null;
	    ArrayList<String> Actual = null;
	    Log.LogFunctionStartDebug( "VerifyBadge", "FN", FN, "ExpVal", ExpVal );
	
	    try
	    {
	        // Prüfen ob ignoriert werden muss...
	        if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
	        {
	            // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
	        }
	        else
	        {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

	            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
	            {
	                lvlsExpected = new ArrayList<String>();
	                lvlsExpected.add( "" );
	            }
	            else
	            {
	                // Split giveneExpected Value
	                lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
	                lvlsExpected = Parser.ParseMe( lvlsExpected );
	            }
	
	            IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );
	
	            OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
	            OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyBadge_TO(), myOKW.VerifyBadge_PT() );
	
	            Actual = verify( TimeOut, lvlsExpected, () ->
	            {
	                return MyObject.VerifyBadge();
	            } );
	            verification( Actual, lvlsExpected );
	        }
	    }
	    catch (Exception e)
	    {
	        this.handleException( e );
	    }
	    finally
	    {
	        Log.LogFunctionEndDebug();
	    }
	}

	/**
	 *   \copydoc IOKW_State::VerifyBadgeWCM(String,String)
	 */
	public void VerifyBadgeWCM( String FN, String ExpVal ) throws Exception
	{
	
	    ArrayList<String> lvlsExpected = null;
	    ArrayList<String> Actual = null;
	
	    Log.LogFunctionStartDebug( "VerifyBadgeWCM", "FN", FN, "fpsExpected", ExpVal );
	
	    try
	    {
	        // Prüfen ob ignoriert werden muss...
	        if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
	        {
	            // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );

	        }
	        else
	        {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

	            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
	            {
	                lvlsExpected = new ArrayList<String>();
	                lvlsExpected.add( "" );
	            }
	            else
	            {
	                // Split giveneExpected Value
	                lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
	                lvlsExpected = Parser.ParseMe( lvlsExpected );
	            }
	
	            IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );
	
	            OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
	            OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyBadge_TO(), myOKW.VerifyBadge_PT() );
	
	            Actual = verifyWCM( TimeOut, lvlsExpected, () ->
	            {
	                return MyObject.VerifyBadge();
	            } );
	
	            verificationWCM( Actual, lvlsExpected );
	        }
	    }
	    catch (Exception e)
	    {
	        this.handleException( e );
	    }
	    finally
	    {
	        Log.LogFunctionEndDebug();
	    }
	}

	/**
	 *   \copydoc IOKW_State::VerifyBadgeREGX(String,String)
	 */
	public void VerifyBadgeREGX( String FN, String ExpVal ) throws Exception
	{
	
	    ArrayList<String> lvlsExpected = null;
	    ArrayList<String> Actual = null;
	
	    Log.LogFunctionStartDebug( "VerifyBadgeREGX", "FN", FN, "fpsExpected", ExpVal );
	
	    try
	    {
	        // Prüfen ob ignoriert werden muss...
	        if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
	        {
	            // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
	        }
	        else
	        {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

	            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
	            {
	                lvlsExpected = new ArrayList<String>();
	                lvlsExpected.add( "" );
	            }
	            else
	            {
	                // Split giveneExpected Value
	                lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
	                lvlsExpected = Parser.ParseMe( lvlsExpected );
	            }
	
	            IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );
	
	            OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
	            OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyBadge_TO(), myOKW.VerifyBadge_PT() );
	
	            Actual = verifyREGX( TimeOut, lvlsExpected, () ->
	            {
	                return MyObject.VerifyBadge(); 
	            } );
	
	            verificationREGX( Actual, lvlsExpected );
	        }
	    }
	    catch (Exception e)
	    {
	        this.handleException( e );
	    }
	    finally
	    {
	        Log.LogFunctionEndDebug();
	    }
	}

	/**
     *  \copydoc IOKW_State::VerifyValue(String,String)
     */
    public void VerifyCaption( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyCaption", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( ExpVal ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                // Print: "KeyWord was ignored!'"
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }
                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyCaption_TO(), myOKW.VerifyCaption_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyCaption();
                } );
                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyValueWCM(String,String)
     */
    public void VerifyCaptionWCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyCaptionWCM", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {

                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyCaption_TO(), myOKW.VerifyCaption_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyCaption();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyCaptionREGX(String,String)
     */
    public void VerifyCaptionREGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyCaptionREGX", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {

                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyCaption_TO(), myOKW.VerifyCaption_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyCaption();
                } );
                verificationREGX( Actual, lvlsExpected );

            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
    *   \copydoc IOKW_State::VerifyExists(String,String)
    */
    public void VerifyExists( String FN, String ExpVal ) throws Exception
    {

        Log.LogFunctionStartDebug( "VerifyExists", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Only three values are possible here: YES/NO/IGNORE
            // 1. check if you need to ignore...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {   // 2. Dann den wert durch den Parser laufenlassen, danach darf nur Nun darf nur ...
                String lvsExpected = Parser.ParseMe( ExpVal );

                if ( lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                                || lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
                {
                    Boolean lvbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean( lvsExpected );

                    IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                    OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                    OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyExists_TO(), myOKW.VerifyExists_PT() );

                    Boolean lvbActual = verify( TimeOut, lvbExpectedValue, () ->
                    {
                        return MyObject.VerifyExists();
                    } );

                    String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                    verification( lvsActual, lvsExpected );
                }
                else
                {
                    // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                    String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                    throw new OKWNotAllowedValueException( lvsLM );
                }
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyHasFocus(String,String)
     */
    public void VerifyHasFocus( String FN, String ExpVal ) throws Exception
    {

        Log.LogFunctionStartDebug( "VerifyHasFocus", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Hier sind nur drei Werte erlaubt: YES/NO/IGNORE
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                String lvsExpected = Parser.ParseMe( ExpVal );

                // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
                if ( lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                                || lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
                {

                    // Sprachabhängiges YES/NO nach Boolean transformieren
                    Boolean lvbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean( lvsExpected );

                    IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                    OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                    OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyHasFocus_TO(), myOKW.VerifyHasFocus_PT() );

                    Boolean lvbActual = verify( TimeOut, lvbExpectedValue, () ->
                    {
                        return MyObject.VerifyHasFocus();
                    } );

                    String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                    verification( lvsActual, lvsExpected );
                }
                else
                {
                    // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                    String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                    throw new OKWNotAllowedValueException( lvsLM );
                }
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  copydoc IOKW_State::VerifyHasFocus(String,String)
     */
    public void VerifyIsActive( String FN, String ExpVal ) throws Exception
    {
        Log.LogFunctionStartDebug( "VerifyIsActive", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Hier sind nur drei werte erlaubt: YES/NO/IGNORE

            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {

                String lvsExpected = Parser.ParseMe( ExpVal );

                // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
                if ( lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                                || lvsExpected.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
                {

                    // Sprachabhängiges YES/NO nach Boolean transformieren
                    Boolean lvbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean( lvsExpected );

                    IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                    OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                    OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyIsActive_TO(), myOKW.VerifyIsActive_PT() );

                    Boolean lvbActual = verify( TimeOut, lvbExpectedValue, () ->
                    {
                        return MyObject.VerifyIsActive();
                    } );

                    String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                    verification( lvsActual, lvsExpected );
                }
                else
                {
                    // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                    String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                    throw new OKWNotAllowedValueException( lvsLM );
                }
            }
        }
        catch (Exception e)
        {
            Log.LogPrint( e.getMessage() );
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    private void verification( String fpsActual, String fpsExpected )
    {
        if ( fpsActual.equals( fpsExpected ) )
        {
            Log.LogPass( fpsActual + " = " + fpsExpected );
        }
        else
        {
            LogVerifyError( fpsExpected, fpsActual );;
            
            // Trigger OKWVerifyingFailsException!
            String lvsLM = PROP.getProperty( "OKWVerifyingFailsException.${LANGUAGE}", fpsExpected, fpsActual );
            throw new OKWVerifyingFailsException( lvsLM );
        }
    }

    private void verification( Integer fpiActual, Integer fpiExpected )
    {
        String fpsActual   = fpiActual.toString();
        String fpsExpected = fpiExpected.toString();
        
        if ( fpsActual.equals( fpsExpected ) )
        {
            Log.LogPass( fpsActual + " = " + fpsExpected );
        }
        else
        {   
            LogVerifyError( fpsExpected, fpsActual );

            // Trigger OKWVerifyingFailsException!
            String lvsLM = PROP.getProperty( "OKWVerifyingFailsException.${LANGUAGE}", fpsExpected, fpsActual );
            throw new OKWVerifyingFailsException( lvsLM );
        }
    }

    private void verification( ArrayList<String> Actual, ArrayList<String> Expected )
    {
        String msg = "";
        
        Boolean bFail = false;

        Integer ActualSize = new Integer( Actual.size() );
        Integer ExpectedSize = new Integer( Expected.size() );

        if ( ActualSize.equals( ExpectedSize ) )
        {
            Log.LogPass( PROP.getProperty( "ok.SizeIsOK.${LANGUAGE}" ) );

            for ( int i = 0; i < Actual.size(); i++ )
            {

                if ( Actual.get( i ).equals( Expected.get( i ) ) )
                {
                    Log.LogPass( Actual.get( i ) + " = " + Expected.get( i ) );
                }
                else
                {   
                    LogVerifyError( Expected.get( i ), Actual.get( i ) );

                    msg = PROP.getProperty( "ok.verification.exception.unexpectedvalue.${LANGUAGE}" );
                    bFail = true;
                    
                }
            }
        }
        else
        {               
            LogVerifyError( ((Integer)Expected.size()).toString(), ((Integer)Actual.size()).toString() );
            
            msg = PROP.getProperty( "ok.verification.exception.unexpectedsize.${LANGUAGE}" );
            bFail = true;
        }

        if ( bFail )
        {
            // Fehler Ausnahme auslösen
            throw new OKWVerifyingFailsException( msg );
        }
        return;
    }

    private void verificationWCM( ArrayList<String> Actual, ArrayList<String> Expected )
    {
        Boolean bFail = false;
        String msg = "";

        Integer ActualSize = new Integer( Actual.size() );
        Integer ExpectedSize = new Integer( Expected.size() );

        if ( ActualSize.equals( ExpectedSize ) )
        {
            Log.LogPass( PROP.getProperty( "ok.SizeIsOK.${LANGUAGE}" ) );

            for ( int i = 0; i < Actual.size(); i++ )
            {

                if ( Matcher.WildcardMatch( Actual.get( i ), Expected.get( i ) ) )
                {
                    Log.LogPass( Actual.get( i ) + " = " + Expected.get( i ) );
                }
                else
                {   
                    LogVerifyError( Expected.get( i ), Actual.get( i ) );
                    
                    msg = PROP.getProperty( "ok.verification.exception.unexpectedvalue.${LANGUAGE}" );
                    bFail = true;
                }
            }
        }
        else
        {   
            LogVerifyError( ((Integer)Expected.size()).toString(), ((Integer)Actual.size()).toString() );
            msg = PROP.getProperty( "ok.verification.exception.unexpectedsize.${LANGUAGE}" );
            bFail = true;
        }

        if ( bFail )
        {
            // Fehler Ausnahme auslösen
            throw new OKWVerifyingFailsException(msg);
        }
    }

    private void verificationREGX( ArrayList<String> Actual, ArrayList<String> Expected )
    {
        Boolean bFail = false;
        String msg = "";

        Integer ActualSize = new Integer( Actual.size() );
        Integer ExpectedSize = new Integer( Expected.size() );

        if ( ActualSize.equals( ExpectedSize ) )
        { 
            Log.LogPass( PROP.getProperty( "ok.SizeIsOK.${LANGUAGE}" ) );

            for ( int i = 0; i < Actual.size(); i++ )
            {

                if ( Matcher.RegexMatch( Actual.get( i ), Expected.get( i ) ) )
                {
                    Log.LogPass( Actual.get( i ) + " = " + Expected.get( i ) );
                }
                else
                {   
                    LogVerifyError( Expected.get( i ), Actual.get( i ) );

                    msg = PROP.getProperty( "ok.verification.exception.unexpectedvalue.${LANGUAGE}" );
                    bFail = true;
                }
            }
        }
        else
        {   
            LogVerifyError( ((Integer)Expected.size()).toString(), ((Integer)Actual.size()).toString() );
            msg = PROP.getProperty( "ok.verification.exception.unexpectedsize.${LANGUAGE}" );
            
            bFail = true;
        }

        if ( bFail )
        {
            // Fehler: Ausnahme auslösen...
            throw new OKWVerifyingFailsException(msg);
        }
    }

    
    /**
     * \~german
     *  Prüft ob der gegebene boolische Wert "fpbExpected" innerhalb des Time Out "timeout" durch
     *  die gegebene Methode Method2Call gefunden wird.
     *  
     *  Die Absicht dieser Methode ist _nicht_ ein Soll/Ist vergleich, sondern das warten auf einen Werten,
     *  der sich einstellen sollte, wenn ein Testfall wie geplant abläuft. Der Soll-/Istvergleich wird in der jeweiligen
     *  okw.core.IOKW_State methode, die diese Methode ruft, durchgeführt.
     *  
     *  Die Methode wird aus folgenden zwei Gründen beendet:
     *  -# der erwartet Wert fpbExpected wurde gefunden
     *  -# der Time Out timeout ist erreicht
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * @param timeout Enthält die Timeout Daten.
     * @param fpbExpected Erwarteter Wert, der sich einstellen sollte.
     * @param Method2Call Functions Referenz auf die aufzurufende Methode
     * @return Liefert den gefundenen aktuellen Wert zurück.
     * 
     * \~english
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014-01-09
     */
    private Boolean verify( OKW_TimeOut timeout, Boolean fpbExpected, Supplier<Boolean> Method2Call )
    {
        Integer Count = 0;

        Boolean lvbReturn = false;
        Boolean bOK = false;

        Log.LogFunctionStartDebug( "verify", "timeout", timeout.toString(), "fpbExpected", fpbExpected.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvbReturn = Method2Call.get();

                if ( fpbExpected.equals( lvbReturn ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }
                Count++;
            }
            bOK = true;
        }
        catch (IllegalArgumentException | InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( lvbReturn );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return lvbReturn;
    }

    
    /**
     * \~german
     *  Prüft ob der gegebene integer Wert "fpiExpected" innerhalb des Time Out "timeout" durch
     *  die gegebene Methode Method2Call gefunden wird.
     *  
     *  Die Absicht dieser Methode ist _nicht_ ein Soll/Ist vergleich, sondern das warten auf einen Werten,
     *  der sich einstellen sollte, wenn ein Testfall wie geplant abläuft. Der Soll-/Istvergleich wird in der jeweiligen
     *  okw.core.IOKW_State methode, die diese Methode ruft, durchgeführt.
     *  
     *  Die Methode wird aus folgenden zwei Gründen beendet:
     *  -# der erwartet Wert fpiExpected wurde gefunden
     *  -# der Time Out timeout ist erreicht
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * @param timeout Enthält die Timeout Daten.
     * @param fpiExpected Erwarteter Wert, der sich einstellen sollte.
     * @param Method2Call Functions Referenz auf die aufzurufende Methode
     * @return Liefert den gefundenen aktuellen Wert zurück.
     * 
     * \~english
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014-01-09
     */
    private Integer verify( OKW_TimeOut timeout, Integer fpiExpected, Supplier<Integer> Method2Call )
    {
        Integer Count = 0;

        Integer lviReturn = 0;
        Boolean bOK = false;

        //Log.LogFunctionStartDebug( "Verify", "String", "OKW_TimeOut", timeout.toString(), "fpbExpected", fpbExpected.toString() );
        
        Log.LogFunctionStartDebug( "verify", "timeout", timeout.toString(), "fpbExpected", fpiExpected.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lviReturn = Method2Call.get();

                if ( fpiExpected == lviReturn )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }
                Count++;
            }

            bOK = true;
        }
        catch (IllegalArgumentException | InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( lviReturn.toString() );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return lviReturn;
    }

    /**
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * 
     * @param timeout Entält Timeout Daten.
     * @param fpALExpected Erwaretetr Wert
     * @param Method2Call Functions eferenz auf die aufzurufende Methode
     * @return
     */
    // TODO: DocyGen-Doku schreiben
    private ArrayList<String> verify( OKW_TimeOut timeout, String COL, String ROW, ArrayList<String> fpALExpected, BiFunction<String, String, ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;

        Log.LogFunctionStartDebug( "Verify", "timeout", timeout.toString(), "COL", COL, "ROW", ROW, "ArrayList<String> fpALExpected", fpALExpected.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.apply( COL, ROW );

                if ( fpALExpected.equals( lvLsReturn ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
                Log.LogFunctionEndDebug( lvLsReturn );
        }
        return lvLsReturn;
    }


    /**
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * 
     * @param timeout Entält Timeout Daten.
     * @param fpALExpectedWCM Erwaretetr Wert
     * @param Method2Call Functions eferenz auf die aufzurufende Methode
     * @return
     */
    // TODO: DocyGen-Doku schreiben
    private ArrayList<String> verifyWCM( OKW_TimeOut timeout, String COL, String ROW, ArrayList<String> fpALExpectedWCM, BiFunction<String, String, ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;

        Log.LogFunctionStartDebug( "verifyWCM", "timeout", timeout.toString(), "COL", COL, "ROW", ROW, "ArrayList<String> fpALExpectedWCM", fpALExpectedWCM.toString() );
        
        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.apply( COL, ROW );

                if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCM ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug( lvLsReturn );
        }
        return lvLsReturn;
    }

    /**
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * 
     * @param timeout Entält Timeout Daten.
     * @param COL Spalten auswahl.
     * @param ROW Spalten auswahl.
     * @param fpALExpectedREGXs Erwaretetr Wert
     * @param Method2Call Functions eferenz auf die aufzurufende Methode
     * @return
     */
    private ArrayList<String> verifyREGX( OKW_TimeOut timeout, String COL, String ROW, ArrayList<String> fpALExpectedREGXs, BiFunction<String, String, ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;

        Log.LogFunctionStartDebug( "verifyREGX", "timeout", timeout.toString(), "COL", COL, "ROW", ROW, "ArrayList<String> fpALExpected", fpALExpectedREGXs.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.apply( COL, ROW );

                if ( Matcher.RegexMatch(  lvLsReturn, fpALExpectedREGXs ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug( lvLsReturn );
        }
        return lvLsReturn;
    }


    /**
     * \~german
     *  Prüft ob der gegebene ArrayList<String> Wert "fpALExpected" innerhalb des Time Out "timeout" durch
     *  die gegebene Methode Method2Call gefunden wird.
     *  
     *  Die Absicht dieser Methode ist _nicht_ ein Soll/Ist vergleich, sondern das warten auf einen Werten,
     *  der sich einstellen sollte, wenn ein Testfall wie geplant abläuft. Der Soll-/Istvergleich wird in der jeweiligen
     *  okw.core.IOKW_State methode, die diese Methode ruft, durchgeführt.
     *  
     *  Die Methode wird aus folgenden zwei Gründen beendet:
     *  -# der erwartet Wert fpALExpected wurde gefunden
     *  -# der Time Out timeout ist erreicht
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * @param timeout Enthält die Timeout Daten.
     * @param fpALExpected Erwarteter Wert, der sich einstellen sollte.
     * @param Method2Call Functions Referenz auf die aufzurufende Methode
     * @return Liefert den gefundenen aktuellen Wert zurück.
     * 
     * \~english
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014-01-09
     */
    private ArrayList<String> verify( OKW_TimeOut timeout, ArrayList<String> fpALExpected, Supplier<ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;
        Boolean bOK = false;

        Log.LogFunctionStartDebug( "verify", "timeout", timeout.toString(), "ArrayList<String> fpALExpected", fpALExpected.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.get();

                if ( fpALExpected.equals( lvLsReturn ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }

            bOK = true;
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( lvLsReturn );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return lvLsReturn;
    }

    /**
     * \~german
     *  Prüft ob der gegebene ArrayList<String> Wert "fpALExpected" als WCM innerhalb des Time Out "timeout" durch
     *  die gegebene Methode Method2Call gefunden wird.
     *  
     *  Die Absicht dieser Methode ist _nicht_ ein Soll/Ist vergleich, sondern das warten auf einen Werten,
     *  der sich einstellen sollte, wenn ein Testfall wie geplant abläuft. Der Soll-/Istvergleich wird in der jeweiligen
     *  okw.core.IOKW_State methode, die diese Methode ruft, durchgeführt.
     *  
     *  Die Methode wird aus folgenden zwei Gründen beendet:
     *  -# der erwartet Wert fpALExpected wurde gefunden
     *  -# der Time Out timeout ist erreicht
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * @param timeout Enthält die Timeout Daten.
     * @param fpALExpected Erwarteter Wert, der sich einstellen sollte.
     * @param Method2Call Functions Referenz auf die aufzurufende Methode
     * @return Liefert den gefundenen aktuellen Wert zurück.
     * 
     * \~english
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014-01-09
     */
    private ArrayList<String> verifyWCM( OKW_TimeOut timeout, ArrayList<String> fpALExpectedWCMs, Supplier<ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;
        Boolean bOK = false;

        Log.LogFunctionStartDebug( "verifyWCN", "timeout", timeout.toString(), "ArrayList<String> fpALExpectedWCMs", fpALExpectedWCMs.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.get();

                if ( Matcher.WildcardMatch( lvLsReturn, fpALExpectedWCMs ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }

            bOK = true;
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( lvLsReturn );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return lvLsReturn;
    }

    /**
     * \~german
     *  Prüft ob der gegebene ArrayList<String> Wert "fpALExpected" als REGX innerhalb des Time Out "timeout" durch
     *  die gegebene Methode Method2Call gefunden wird.
     *  
     *  Die Absicht dieser Methode ist _nicht_ ein Soll/Ist vergleich, sondern das warten auf einen Werten,
     *  der sich einstellen sollte, wenn ein Testfall wie geplant abläuft. Der Soll-/Istvergleich wird in der jeweiligen
     *  okw.core.IOKW_State methode, die diese Methode ruft, durchgeführt.
     *  
     *  Die Methode wird aus folgenden zwei Gründen beendet:
     *  -# der erwartet Wert fpALExpected wurde gefunden
     *  -# der Time Out timeout ist erreicht
     * 
     * \see https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * @param timeout Enthält die Timeout Daten.
     * @param fpALExpected Erwarteter Wert, der sich einstellen sollte.
     * @param Method2Call Functions Referenz auf die aufzurufende Methode
     * @return Liefert den gefundenen aktuellen Wert zurück.
     * 
     * \~english
     * 
     * \~
     * @author Zoltán Hrabovszki
     * @date 2014-01-09
     */
    private ArrayList<String> verifyREGX( OKW_TimeOut timeout, ArrayList<String> fpALExpectedREGXs, Supplier<ArrayList<String>> Method2Call )
    {
        Integer Count = 0;

        ArrayList<String> lvLsReturn = null;
        Boolean bOK = false;

        Log.LogFunctionStartDebug( "verifyWCN", "timeout", timeout.toString(), "ArrayList<String> fpALExpectedREGXs", fpALExpectedREGXs.toString() );

        try
        {
            Count = 0;

            while ( Count < timeout.getMaxCount() )
            {
                lvLsReturn = Method2Call.get();

                if ( Matcher.RegexMatch( lvLsReturn, fpALExpectedREGXs ) )
                {
                    break;
                }
                else
                {
                    Thread.sleep( timeout.getPT() );
                }

                Count++;
            }

            bOK = true;
        }
        catch (IllegalArgumentException e)
        {
            throw new RuntimeException( e );
        }
        catch (InterruptedException e)
        {
            throw new RuntimeException( e );
        }
        finally
        {
            if ( bOK )
            {
                Log.LogFunctionEndDebug( lvLsReturn );
            }
            else
            {
                Log.LogFunctionEndDebug();
            }
        }
        return lvLsReturn;
    }

    /**
     *  \copydoc IOKW_State::VerifyLabel(String,String)
     */
    public void VerifyLabel( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;
        Log.LogFunctionStartDebug( "VerifyLabel", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyLabel_TO(), myOKW.VerifyLabel_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyLabel();
                } );
                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyLabelWCM(String,String)
     */
    public void VerifyLabelWCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyLabelWCM", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyLabel_TO(), myOKW.VerifyLabel_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyLabel();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyLabelREGX(String,String)
     */
    public void VerifyLabelREGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyLabelREGX", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyLabel_TO(), myOKW.VerifyLabel_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyLabel();
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }


    /**
     *  \copydoc IOKW_State::VerifyLabel(String,String)
     */
    public void VerifyPlaceholder( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;
        Log.LogFunctionStartDebug( "VerifyPlaceholder", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyPlaceholder_TO(), myOKW.VerifyPlaceholder_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyPlaceholder();
                } );
                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *   \copydoc IOKW_State::VerifyPlaceholderWCM(String,String)
     */
    public void VerifyPlaceholderWCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyLabelWCM", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyPlaceholder_TO(), myOKW.VerifyPlaceholder_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyPlaceholder();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *   \copydoc IOKW_State::VerifyMaxLength(String,String)
     */
    public void VerifyMaxLength( String FN, String ExpVal ) throws Exception
    {

        Integer lviExpected = null;
        Integer Actual = null;

        Log.LogFunctionStartDebug( "VerifyMaxLength", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE",  "SEP", "VSEP", "HSEP", "EMPTY" );                

                try {
                    String myExpVal = Parser.ParseMe( ExpVal );

                    lviExpected = Integer.parseInt( myExpVal );
                }
                catch (NumberFormatException e)
                {
                    // Wenn ExpVal = keine Zahl enthält -> OKWNotAllowedValueException auslösen...
                    // OKWNotAllowedValueException.IntegerOnly
                    String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.IntegerOnly.${LANGUAGE}", ExpVal );
                    throw new OKWNotAllowedValueException( lvsLM );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyMaxLength_TO(), myOKW.VerifyMaxLength_PT() );

                Actual = verify( TimeOut, lviExpected, () ->
                {
                    return MyObject.VerifyMaxLength();
                } );

                verification( Actual, lviExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *   \copydoc IOKW_State::VerifyPlaceholderREGX(String,String)
     */
    public void VerifyPlaceholderREGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyPlaceholderREGX", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyPlaceholder_TO(), myOKW.VerifyPlaceholder_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyPlaceholder();
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValue(String,String)
     */
    public void VerifySelectedValue( String FN, String ExpVal ) throws Exception
    {
        Log.LogFunctionStartDebug( "VerifySelectedValue", "FN", FN, "fpsExpected", ExpVal );

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                // Get the actuel value from object
                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifySelectedValue_TO(), myOKW.VerifySelectedValue_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifySelectedValue();
                } );

                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValueWCM(String,String)
     */
    public void VerifySelectedValueWCM( String FN, String ExpVal ) throws Exception
    {
        Log.LogFunctionStartDebug( "VerifySelectedValueWCM", "FN", FN, "fpsExpected", ExpVal );

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                // Get the actuel value from object
                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifySelectedValue_TO(), myOKW.VerifySelectedValue_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifySelectedValue();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifySelectedValueWCM(String,String)
     */
    public void VerifySelectedValueREGX( String FN, String ExpVal ) throws Exception
    {
        Log.LogFunctionStartDebug( "VerifySelectedValueREGX", "FN", FN, "fpsExpected", ExpVal );

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifySelectedValue_TO(), myOKW.VerifySelectedValue_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifySelectedValue();
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
     */
    public void VerifyTablecellValue( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyTablecellValue", "FN", FN, "COL", COL, "ROW", ROW, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTablecellValue_TO(), myOKW.VerifyTablecellValue_PT() );

                Actual = verify( TimeOut, COL, ROW, lvlsExpected, (String col, String row) ->
                {
                    return MyObject.VerifyTablecellValue(col, row);
                } );

                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValueWCM(String,String,String,String)
     */
    public void VerifyTablecellValueWCM( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyTablecellValue", "FN", FN, "COL", COL, "ROW", ROW, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTablecellValue_TO(), myOKW.VerifyTablecellValue_PT() );

                Actual = verifyWCM( TimeOut, COL, ROW, lvlsExpected, (String col, String row) ->
                {
                    return MyObject.VerifyTablecellValue(col, row);
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTablecellValue(String,String,String,String)
     */
    public void VerifyTablecellValueREGX( String FN, String COL, String ROW, String ExpVal ) throws Exception
    {
        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyTablecellValue", "FN", FN, "COL", COL, "ROW", ROW, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTablecellValue_TO(), myOKW.VerifyTablecellValue_PT() );

                Actual = verifyREGX( TimeOut, COL, ROW, lvlsExpected, (String col, String row) ->
                {
                    return MyObject.VerifyTablecellValue(col, row);
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     * \copydoc IOKW_State::VerifyTooltip(String,String)
     */
    public void VerifyTooltip( String FN, String ExpVal ) throws Exception
    {
        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyTooltip", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTooltip_TO(), myOKW.VerifyTooltip_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyTooltip();
                } );
                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyTooltipWCM(String,String)
     */
    public void VerifyTooltipWCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> Actual = null;
        ArrayList<String> lvlsExpected = null;

        Log.LogFunctionStartDebug( "VerifyTooltipWCM", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {

                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTooltip_TO(), myOKW.VerifyTooltip_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyTooltip();
                } );
                verificationWCM( Actual, lvlsExpected );

            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyTooltipREGX(String,String)
     */
    public void VerifyTooltipREGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> Actual = null;
        ArrayList<String> lvlsExpected = null;

        Log.LogFunctionStartDebug( "VerifyTooltipREGX", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyTooltip_TO(), myOKW.VerifyTooltip_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyTooltip();
                } );
                verificationREGX( Actual, lvlsExpected );

            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyValue(String,String)
     */
    public void VerifyValue( String FN, String ExpVal ) throws Exception
    {
        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyValue", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyValue_TO(), myOKW.VerifyValue_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyValue();
                } );

                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyValueWCM(String,String)
     */
    public void VerifyValueWCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> Actual = null;
        ArrayList<String> lvlsExpected = null;

        Log.LogFunctionStartDebug( "VerifyValueWCM", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyValue_TO(), myOKW.VerifyValue_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyValue();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     * _Wichtig:_ Ein "EMPTY"-Wert ist ein ArrayList String welche keine Array-Elemte enthält, also ArrayList.Size() = 0!
     * \~
     * \copydoc IOKW_State::VerifyValueREGX(String,String)
     */
    public void VerifyValueREGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> Actual = null;
        ArrayList<String> lvlsExpected = null;

        Log.LogFunctionStartDebug( "VerifyValueREGX", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {

                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyValue_TO(), myOKW.VerifyValue_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyValue();
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }


    /**
     *  \copydoc IOKW_State::FileCreate(String)
     */
    public void FileCreate( String PATH ) throws Exception
    {
        String lvsPATH = "";

        Log.LogFunctionStartDebug( "FileCreate", "PATH", PATH );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( PATH.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( PATH ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // 1. Parsen der Pfad-Eingabe
                lvsPATH = Parser.ParseMe( PATH );
                // 2. Konvertieren des Pfad separators.
                lvsPATH = OKW_FileHelper.convertDirectorySeperator( lvsPATH );

                String lsvLog = PROP.getProperty( "ok.FileCreate.ResolvedPath.${LANGUAGE}", lvsPATH );
                Log.LogPrint( lsvLog );

                OKW_FileHelper.createFile( lvsPATH );
            }
        }
        catch (Exception e)
        {
            handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::FileDelete(String)
     */
    public void FileDelete( String fpsPathAndFileName ) throws Exception
    {
        String lvsPathAndFileName = "";

        Log.LogFunctionStartDebug( "FileDelete", "fpsPathAndFileName", fpsPathAndFileName );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( fpsPathAndFileName.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( fpsPathAndFileName ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else
            {
                // 1. Parsen der Pfad-Eingabe
                lvsPathAndFileName = Parser.ParseMe( fpsPathAndFileName );
                // 2. Konvertieren des Pfad separators.
                lvsPathAndFileName = OKW_FileHelper.convertDirectorySeperator( lvsPathAndFileName );

                String lsvLog = PROP.getProperty( "ok.FileDelete.ResolvedPath.${LANGUAGE}", lvsPathAndFileName );
                Log.LogPrint( lsvLog );

                // Basis-Funktion aufrufen...
                OKW_FileHelper.deleteFile( lvsPathAndFileName );
            }
        }
        catch (Exception e)
        {
            handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::FilesDelete(String,String)
     */
    public void FilesDelete( String fpsDirPath, String fpsFileMatch ) throws Exception
    {
        String lvsDirPath = "";
        String lvsFileMatch = "";

        Log.LogFunctionStartDebug( "FilesDelete", "fpsDirPath", fpsDirPath, "fpsFileMatch", fpsFileMatch );
        try
        {
            // Check if you need to ignore...
            // FIXME: Testfall für fpsFileMatch schreiben
            if ( fpsDirPath.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) )
                 || "".equals( fpsDirPath )
                 || fpsFileMatch.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) )
                 || "".equals( fpsFileMatch ))
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // 1. Parsen der Pfad-Eingabe
                lvsDirPath = Parser.ParseMe( fpsDirPath );
                lvsFileMatch = Parser.ParseMe( fpsDirPath );
                
                // 2. Konvertieren des Pfad separators.
                lvsDirPath = OKW_FileHelper.convertDirectorySeperator( lvsDirPath );
                lvsFileMatch = OKW_FileHelper.convertDirectorySeperator( lvsFileMatch );

                String lsvLog = PROP.getProperty( "ok.FileDelete.ResolvedPath.${LANGUAGE}", lvsFileMatch );
                Log.LogPrint( lsvLog );

                // Basis-Funktion aufrufen...
                OKW_FileHelper.deleteFiles( lvsDirPath );
            }
        }
        catch (Exception e)
        {
            handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }
    
    /**
     *  \copydoc IOKW_State::DirectoryDelete(String)
     */
    public void DirectoryDelete( String PATH ) throws Exception
    {
        String lvsPATH = "";

        Log.LogFunctionStartDebug( "FileDelete", "PATH", PATH );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( PATH.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( PATH ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else
            {
                // 1. Parsen der Pfad-Eingabe
                lvsPATH = Parser.ParseMe( PATH );
                // 2. Konvertieren des Pfad separators.
                lvsPATH = OKW_FileHelper.convertDirectorySeperator( lvsPATH );

                String lsvLog = PROP.getProperty( "ok.DirectoryDelete.ResolvedPath.${LANGUAGE}", lvsPATH );
                Log.LogPrint( lsvLog );

                // Basis-Funktion aufrufen...
                OKW_FileHelper.deleteDirectory( lvsPATH );
            }
        }
        catch (Exception e)
        {
            handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }


    /**
     *  \copydoc IOKW_State::DirectoryCreate(String)
     */
    public void DirectoryCreate( String PATH ) throws Exception
    {
        String lvsPATH = "";

        Log.LogFunctionStartDebug( "DirectoryCreate", "PATH", PATH );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( PATH.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || "".equals( PATH ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else
            {
                // 1. Parsen der Pfad-Eingabe
                lvsPATH = Parser.ParseMe( PATH );
                // 2. Konvertieren des Pfad separators.
                lvsPATH = OKW_FileHelper.convertDirectorySeperator( lvsPATH );

                String lsvLog = PROP.getProperty( "ok.DirectoryCreate.ResolvedPath.${LANGUAGE}", lvsPATH );
                Log.LogPrint( lsvLog );
                
                // Basis-Funktion aufrufen...
                OKW_FileHelper.DirectoryCreate( lvsPATH );
            }
        }
        catch (Exception e)
        {
            handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *  \copydoc IOKW_State::VerifyFileExists(String,String)
     */
    public void VerifyFileExists( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        String lvsPathAndFileName = "";

        Log.LogFunctionStartDebug( "VerifyFileExist", "fpsPathAndFileName", fpsPathAndFileName, "ExpVal", ExpVal );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else if ( ExpVal.equals(OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                            || ExpVal.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
            {
                // Aktuellen Wert holen...

                // 1. Parsen der Pfad-Eingabe
                lvsPathAndFileName = Parser.ParseMe( fpsPathAndFileName );
                // 2. Konvertieren des Pfad separators.
                lvsPathAndFileName = OKW_FileHelper.convertDirectorySeperator( lvsPathAndFileName );

                String lsvLog = PROP.getProperty( "ok.VerifyFileExists.ResolvedPath.${LANGUAGE}", lvsPathAndFileName );
                Log.LogPrint( lsvLog );

                // Basis-Funkton aufrufen...
                Boolean lvbActual = OKW_FileHelper.fileExists( lvsPathAndFileName );

                // Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                verification( lvsActual, ExpVal );
            }
            else
            {
                // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                throw new OKWNotAllowedValueException( lvsLM );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::VerifyIsFile(String,String)
     */
    public void VerifyIsFile( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        String lvsPathAndFileName = "";

        Log.LogFunctionStartDebug( "VerifyIsFile", "fpsPathAndFileName", fpsPathAndFileName, "ExpVal", ExpVal );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else if ( ExpVal.equals(OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                            || ExpVal.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
            {
                // Aktuellen Wert holen...

                // 1. Parsen der Pfad-Eingabe
                lvsPathAndFileName = Parser.ParseMe( fpsPathAndFileName );
                // 2. Konvertieren des Pfad separators.
                lvsPathAndFileName = OKW_FileHelper.convertDirectorySeperator( lvsPathAndFileName );

                String lsvLog = PROP.getProperty( "ok.VerifyIsFile.ResolvedPath.${LANGUAGE}", lvsPathAndFileName );
                Log.LogPrint( lsvLog );

                // Basis-Funkton aufrufen...
                Boolean lvbActual = OKW_FileHelper.isFile( lvsPathAndFileName );

                // Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                verification( lvsActual, ExpVal );
            }
            else
            {
                // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                throw new OKWNotAllowedValueException( lvsLM );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    
    /**
     *  \copydoc IOKW_State::VerifyIsDirectory(String,String)
     */
    public void VerifyIsDirectory( String fpsPathAndFileName, String ExpVal ) throws Exception
    {
        String lvsPathAndFileName = "";

        Log.LogFunctionStartDebug( "VerifyIsDirectory", "fpsPathAndFileName", fpsPathAndFileName, "ExpVal", ExpVal );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else if ( ExpVal.equals(OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                            || ExpVal.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" ) ) )
            {
                // Aktuellen Wert holen...

                // 1. Parsen der Pfad-Eingabe
                lvsPathAndFileName = Parser.ParseMe( fpsPathAndFileName );
                // 2. Konvertieren des Pfad separators.
                lvsPathAndFileName = OKW_FileHelper.convertDirectorySeperator( lvsPathAndFileName );

                String lsvLog = PROP.getProperty( "ok.VerifyIsDirectory.ResolvedPath.${LANGUAGE}", lvsPathAndFileName );
                Log.LogPrint( lsvLog );

                // Basis-Funkton aufrufen...
                Boolean lvbActual = OKW_FileHelper.isFile( lvsPathAndFileName );

                // Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                verification( lvsActual, ExpVal );
            }
            else
            {
                // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                throw new OKWNotAllowedValueException( lvsLM );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }    
    
    /**
     *  \copydoc IOKW_State::VerifyDirectoryExists(String,String)
     */
    public void VerifyDirectoryExists( String fpsPath, String ExpVal ) throws Exception
    {
        String lvsPath = "";

        Log.LogFunctionStartDebug( "VerifyDirectoryExists", "fpsPath", fpsPath, "ExpVal", ExpVal );
        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            // Püfen ob YES/NO als Sollwert vorgegeben worden ist.
            else if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "YES" ) )
                            || ExpVal.equals( OKW_Const_Sngltn.getInstance().GetConst4Internalname( "NO" )) )
            {
                // Aktuellen Wert holen...

                // 1. Parsen der Pfad-Eingabe
                lvsPath = Parser.ParseMe( fpsPath );
                // 2. Konvertieren des Pfad separators.
                lvsPath = OKW_FileHelper.convertDirectorySeperator( lvsPath );

                String lsvLog = PROP.getProperty( "ok.VerifyDirectoryExists.ResolvedPath.${LANGUAGE}", lvsPath );
                Log.LogPrint( lsvLog );
                
                // Basis-Funkton aufrufen...
                Boolean lvbActual = OKW_FileHelper.directoryExists( lvsPath );

                // Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
                String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo( lvbActual );

                verification( lvsActual, ExpVal );
            }
            else
            {
                // Both conditions are not fulfilled: An exception must be thrown since no other value is allowed here.
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.YesNoIgnore.${LANGUAGE}", ExpVal );
                throw new OKWNotAllowedValueException( lvsLM );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    @Override
    public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName ) throws Exception
    {
        // TODO Auto-generated method stub
    }
    
    
    /**
     *   \copydoc IOKW_State::VerifyMinLength(String,String)
     */
    public void VerifyMinLength( String FN, String ExpVal ) throws Exception
    {

        Integer lviExpected = null;
        Integer Actual = null;

        Log.LogFunctionStartDebug( "VerifyMinLength", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE",  "SEP", "VSEP", "HSEP", "EMPTY" );                

                try
                {
                    String myExpVal = Parser.ParseMe( ExpVal );
                    lviExpected = Integer.parseInt( myExpVal );
                }
                catch (NumberFormatException e)
                {
                    // Wenn ExpVal = keine Zahl enthält -> OKWNotAllowedValueException auslösen...
                    // OKWNotAllowedValueException.IntegerOnly
                    String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.IntegerOnly.${LANGUAGE}", ExpVal );
                    throw new OKWNotAllowedValueException( lvsLM );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyMinLength_TO(), myOKW.VerifyMinLength_PT() );

                Actual = verify( TimeOut, lviExpected, () ->
                {
                    return MyObject.VerifyMinLength();
                } );

                verification( Actual, lviExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }
    
    
    /**
     *  \copydoc IOKW_State::VerifyErrorMSG(String,String)
     */
    public void VerifyErrorMSG( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;
        Log.LogFunctionStartDebug( "VerifyErrorMSG", "FN", FN, "ExpVal", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the given OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyErrorMSG_TO(), myOKW.VerifyErrorMSG_PT() );

                Actual = verify( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyErrorMSG();
                } );
                verification( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyErrorMSG_WCM(String,String)
     */
    public void VerifyErrorMSG_WCM( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyErrorMSG_WCM", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the given OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                

                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyErrorMSG_TO(), myOKW.VerifyErrorMSG_PT() );

                Actual = verifyWCM( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyErrorMSG();
                } );

                verificationWCM( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }

    /**
     *   \copydoc IOKW_State::VerifyErrorMSG_REGX(String,String)
     */
    public void VerifyErrorMSG_REGX( String FN, String ExpVal ) throws Exception
    {

        ArrayList<String> lvlsExpected = null;
        ArrayList<String> Actual = null;

        Log.LogFunctionStartDebug( "VerifyErrorMSG_REGX", "FN", FN, "fpsExpected", ExpVal );

        try
        {
            // Prüfen ob ignoriert werden muss...
            if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "IGNORE" ) ) || ExpVal.equals( "" ) )
            {
                // Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
                String lvsLM = PROP.getProperty( "ok.Ignore.${LANGUAGE}" );
                Log.LogPrint( lvsLM );
            }
            else
            {
                // If One of the Give OKW-Const-Values is contained in ExpVal ->  trigger OKWNotAllowedValueException
                this.newMethod( ExpVal, "IGNORE", "DELETE" );                
                
                if ( ExpVal.equals( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( "EMPTY" ) ) )
                {
                    lvlsExpected = new ArrayList<String>();
                    lvlsExpected.add( "" );
                }
                else
                {
                    // Split giveneExpected Value
                    lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP( ExpVal );
                    lvlsExpected = Parser.ParseMe( lvlsExpected );
                }

                IGUIChildwindow MyObject = ( ( IGUIChildwindow ) CO.setChildName( FN ) );

                OKW myOKW = okw.FrameObjectDictionary_Sngltn.myAnnotationDictionary.get( CO.getObjectFN() );
                OKW_TimeOut TimeOut = new OKW_TimeOut( myOKW.VerifyErrorMSG_TO(), myOKW.VerifyErrorMSG_PT() );

                Actual = verifyREGX( TimeOut, lvlsExpected, () ->
                {
                    return MyObject.VerifyErrorMSG();
                } );

                verificationREGX( Actual, lvlsExpected );
            }
        }
        catch (Exception e)
        {
            this.handleException( e );
        }
        finally
        {
            Log.LogFunctionEndDebug();
        }
    }
    
    protected void newMethod( String ValueToAnalyse, String... NotAllowedValues )
    {
        
        String NotAllowedValue = "";
        
        for(int i=0; i< NotAllowedValues.length; i++)
        {
            NotAllowedValue = NotAllowedValues[i];
            
            if ( ValueToAnalyse.contains( OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname( NotAllowedValue ) ) )
            {
                // Wenn ValueToAnalyse einen wert aus NotAllowedValue enthält -> OKWNotAllowedValueException auslösen...
                String lvsLM = PROP.getProperty( "OKWNotAllowedValueException.${LANGUAGE}", null, ValueToAnalyse );
                throw new OKWNotAllowedValueException( lvsLM );
            }
            else continue;
        }
    }
    protected void LogVerifyError( String fpsExpected,  String fpsActual )
    {
        Log.LogError( PROP.getProperty( "ok.LogVerifyError.ExpectedActuel.${LANGUAGE}", fpsExpected,  fpsActual ) );
        Log.ResOpenList( PROP.getProperty( "ok.LogVerifyError.Details.${LANGUAGE}" ) );
           Log.LogPrint( PROP.getProperty( "ok.LogVerifyError.Expected.${LANGUAGE}", null, fpsExpected ) );
           Log.LogPrint( PROP.getProperty( "ok.LogVerifyError.Actuel.${LANGUAGE}", null, fpsActual ) );
        Log.ResCloseList();
    }
}
