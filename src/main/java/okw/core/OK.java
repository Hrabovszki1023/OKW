/*
    ==============================================================================
      Author: Zoltan Hrabovszki <zh@openkeyword.de>

      Copyright © 2012, 2013, 2014, 2015 IT-Beratung Hrabovszki
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

import okw.log.*;
import okw.parser.Parser;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

// \todo TODO: ANTLR einbauen import OKW.ANTLR4;
import okw.*;
import okw.exceptions.*;

/// \~german
/// \brief
/// Klasse OK representiert den Core Zustand OK.
/// 
/// Testausführung mit GUI-Aktivität und es ist keine Exception ausgelöst worden.
/// 
/// \~english
/// \~
/// \author Zoltán Hrabovszki
/// \date 2013.03.02
public class OK implements IOKW_State
{

	/// \copydoc OKWLanguage
	private static OKWLanguage		CL;

	/// \copydoc Logger
	private static Logger_Sngltn			Log;

	/// \copydoc LogMessenger
	private static LogMessenger		LM;

	/// \copydoc CurrentObject
	private static OKW_CurrentObject_Sngltn	CO;

	Boolean							UNITTEST	= true;

	Core							_Kernel;

	/// \~german
	/// \brief
	/// Klasse representiert den Zustand "OK" des OKW-Kerns im Ausführungsmodus.
	///
	/// \~english
	/// \brief
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 09.01.2014
	public OK(Core fp_OKW)
	{
		try
		{
			CL  = OKWLanguage.getInstance();
			Log	= Logger_Sngltn.getInstance();
			LM  = new LogMessenger("OK");
			CO  = OKW_CurrentObject_Sngltn.getInstance();
			
			this._Kernel = fp_OKW;
		}
		catch (Exception e)
		{
			final ByteArrayOutputStream stream = new ByteArrayOutputStream();
			e.printStackTrace(new PrintStream(stream));

			System.out.println("=================================================================================");
			System.out.println("= Exception during initialization of Class >>OK<<! Stop running!");
			System.out.println("=================================================================================");
			System.out.println(stream);

			System.exit(1);
		}
	}

	/// \~german
	/// \copydoc IOKW_State::BeginTest()
	/// \~english
	/// \copydoc IOKW_State::BeginTest()
	///
	public void BeginTest( String fpsTestname )
	{
		Log.LogFunctionStart("BeginTest", "fpsTestname", fpsTestname);

		Log.LogFunctionEnd();
	}

	/// \~german
	/// \copydoc IOKW_State::ClickOn(string)
	/// \~english
	/// \copydoc IOKW_State::ClickOn(string)
	///
	public void ClickOn( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("ClickOn", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("ClickOn");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::ClickOn(string,string)
	/// \~english
	/// \copydoc IOKW_State::ClickOn(string,string)
	///
	public void ClickOn( String fpsFunctionalname, String fpsClickType ) throws Exception
	{
		Log.LogFunctionStart("ClickOn", "fpsFunctionalname", fpsFunctionalname, "fpsClickType", fpsClickType);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("ClickOn_Clicktype", fpsClickType);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::EndTest()
	/// \~english
	/// \copydoc IOKW_State::EndTest()
	///
	public void EndTest()
	{
		Log.LogFunctionStart("EndTest");

		Log.LogFunctionEnd();
	}

	/// \~german
	/// \copydoc IOKW_State::LogCaption(string)
	/// \~english
	/// \copydoc IOKW_State::LogCaption(string)
	///
	public void LogCaption( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogCaption", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("LogCaption");

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogExists(string)
	/// \~english
	/// \copydoc IOKW_State::LogExists(string)
	///
	public void LogExists( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogExists", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			Boolean lvbActual = CO.CallMethodReturn_Boolean("LogExists");
			String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

			String lvsLM = LM.GetMessage("LogExists", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogHasFocus(string)
	/// \~english
	/// \copydoc IOKW_State::LogHasFocus(string)
	///
	public void LogHasFocus( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogHasFocus", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			Boolean lvbActual = CO.CallMethodReturn_Boolean("LogHasFocus");
			String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

			String lvsLM = LM.GetMessage("LogIsActive", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogIsActive(string)
	/// \~english
	/// \copydoc IOKW_State::LogIsActive(string)
	///
	public void LogIsActive( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogIsActive", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			Boolean lvbActual = CO.CallMethodReturn_Boolean("LogIsActive");

			String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

			String lvsLM = LM.GetMessage("LogIsActive", "LogValue", lvsActual);

			Log.LogPrint(lvsLM);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogLabel(string)
	/// \~english
	/// \copydoc IOKW_State::LogLabel(string)
	///
	public void LogLabel( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogLabel", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("LogLabel");

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogSelected(string)
	/// \~english
	/// \copydoc IOKW_State::LogSelected(string)
	///
	public void LogSelected( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogSelected", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> actualValues = CO.CallMethodReturn_ListString("LogSelected");

			String lvsLM = LM.GetMessage("LogSelected", "LogValue");

			Log.LogPrint(lvsLM);

			Log.ResOpenList(lvsLM);

			for (String Value : actualValues)
			{
				Log.LogPrint("'" + Value + "'");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::LogTablecellValue(string,string,string)
	///
	public void LogTablecellValue( String fpsFunctionalname, String fpsCol, String fpsRow ) throws Exception
	{
		Log.LogFunctionStart("LogTablecellValue", "fpsCol", fpsCol, "fpsRow", fpsRow, "fpsFunctionalname",
				fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("LogTablecellValue", fpsCol, fpsRow);

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogTooltip(string)
	/// \~english
	/// \copydoc IOKW_State::LogTooltip(string)
	///
	public void LogTooltip( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogTooltip", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("LogTooltip");

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::LogValue(string)
	/// \~english
	/// \copydoc IOKW_State::LogValue(string)
	///
	public void LogValue( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("LogValue", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("LogValue");

			Log.ResOpenList("Log... ");

			for (String Value : ActualValues)
			{
				Log.LogPrint(">>" + Value + "<<");
			}

			Log.ResCloseList();
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeCaption(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeCaption(string,string)
	///
	public void MemorizeCaption( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeCaption", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeCaption");

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeExists(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeExists(string,string)
	///
	public void MemorizeExists( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeExists", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fps_MemKeyName == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fps_MemKeyName == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(LM.GetMessage("MemorizeExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				CO.SetChildName(fpsFunctionalname);
				Boolean lvbActual = CO.CallMethodReturn_Boolean("MemorizeExists");

				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsActual);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeHasFocus(string,string)
	///
	public void MemorizeHasFocus( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeHasFocus", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fps_MemKeyName == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fps_MemKeyName == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(LM.GetMessage("MemorizeHasFocus", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				CO.SetChildName(fpsFunctionalname);
				Boolean lvbActual = CO.CallMethodReturn_Boolean("MemorizeHasFocus");

				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsActual);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeIsActive(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeIsActive(string,string)
	///
	public void MemorizeIsActive( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeIsActive", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			Boolean lvbActual = CO.CallMethodReturn_Boolean("MemorizeIsActive");

			String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsActual);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	///
	public void MemorizeLabel( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeLabel", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeLabel");

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeSelectedValue(string,string)
	///
	public void MemorizeSelectedValue( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeSelectedValue", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeSelectedValue");

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeTablecellValue(string,string,string,string)
	///
	public void MemorizeTablecellValue( String fpsFunctionalname, String fpsCol, String fpsRow, String fps_MemKeyName )
			throws Exception
	{
		Log.LogFunctionStart("MemorizeTablecellValue", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol,
				"fpsRow", fpsRow, "fps_MemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeTablecellValue", fpsCol, fpsRow);

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeTooltip(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeTooltip(string,string)
	///
	public void MemorizeTooltip( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeTooltip", "fpsFunctionalname", fpsFunctionalname, "fps_MemKeyName",
				fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeTooltip");

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::MemorizeLabel(string,string)
	///
	public void MemorizeValue( String fpsFunctionalname, String fps_MemKeyName ) throws Exception
	{
		Log.LogFunctionStart("MemorizeValue", "fpsFunctionalname", fpsFunctionalname, "fpsMemKeyName", fps_MemKeyName);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			ArrayList<String> ActualValues = CO.CallMethodReturn_ListString("MemorizeValue");

			String lvsToMemorize = OKW_Const_Sngltn.getInstance().ConcatSEP(ActualValues);

			OKW_Memorize_Sngltn.getInstance().Set(fps_MemKeyName, lvsToMemorize);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::Select(string,string)
	/// \~english
	/// \copydoc IOKW_State::Select(string,string)
	///
	public void Select( String fpsFunctionalname, String fpsValue ) throws Exception
	{
		Log.LogFunctionStart("Select", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				// Sonst Methode des Objektes aufrufen....
				ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("Select", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}

		return;
	}

	/// \~german
	/// \copydoc IOKW_State::Select(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::Select(string,string,string)
	///
	public void Select( String fpsFunctionalname, String fpsValue, String fpsClickType ) throws Exception
	{
		Log.LogFunctionStart("Select", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue, "fpsClickType",
				fpsClickType);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);

				// TODO: Select - Sprachabhängigkeit von KlickType einbauen...
				CO.CallMethod("Select_Clicktype", lvlsValue, fpsClickType);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectMenu(string)
	/// \~english
	/// \copydoc IOKW_State::SelectMenu(string)
	///
	public void SelectMenu( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("SelectMenu", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectMenu");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectMenu(string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectMenu(string,string)
	///
	public void SelectMenu( String fpsFunctionalname, String fpsValue ) throws Exception
	{
		Log.LogFunctionStart("SelectMenu", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		try
		{
			ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectMenu_Value", lvlsValue);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectTablecell(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectTablecell(string,string,string)
	///
	public void SelectTablecell( String fpsFunctionalname, String fpsCol, String fpsRow ) throws Exception
	{
		Log.LogFunctionStart("SelectTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow);

		//// ArrayList<String> lvls_Cell =
		//// LogMessenger.Instance.SplitSEP(fpsCell);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectTablecell", fpsCol, fpsRow);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::SelectTablecell(string,string,string,string)
	///
	public void SelectTablecell( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsClickType )
			throws Exception
	{
		Log.LogFunctionStart("SelectTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow, "fpsClickType", fpsClickType);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SelectTablecell_Clicktype", fpsCol, fpsRow, fpsClickType);
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SelectWindow(string)
	/// \~english
	/// \copydoc IOKW_State::SelectWindow(string)
	///
	public void SelectWindow( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("SelectWindow", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetWindowName(fpsFunctionalname);
			CO.CallMethod("SelectWindow");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}

		return;
	}

	/// \~german
	/// \copydoc IOKW_State::Sequence(string,string,string)
	/// \~english
	/// \copydoc IOKW_State::Sequence(string,string,string)
	///
	public void Sequence( String fpsObjectName, String fpsSequenceName, String SEQ_ID ) throws Exception
	{
		Log.LogFunctionStart("Sequence", "fpsObjectName", fpsObjectName, "fpsSequenceName", fpsSequenceName, "SEQ_ID",
				SEQ_ID);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (SEQ_ID == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || SEQ_ID == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> Abbrechen...
				// \todo TODO: Meldung sprachabhägig auslagern!
				Log.LogPrintDebug("Ignore...");
			}
			else
			{
				CO.SetWindowName(fpsObjectName);
				CO.CallMethod(fpsSequenceName, SEQ_ID);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::SetFocus(string)
	/// \~english
	/// \copydoc IOKW_State::SetFocus(string)
	///
	public void SetFocus( String fpsFunctionalname ) throws Exception
	{
		Log.LogFunctionStart("SetFocus", "fpsFunctionalname", fpsFunctionalname);

		try
		{
			CO.SetChildName(fpsFunctionalname);
			CO.CallMethod("SetFocus");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 02.03.2013
	public void SetLanguage( String Language )
	{
		CL.setLanguage(Language);
	}

	/// \~german
	/// \copydoc IOKW_State::SetValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::SetValue(string,string)
	///
	public void SetValue( String fpsFunctionalname, String fpsValue ) throws Exception
	{
		Log.LogFunctionStart("SetValue", "fpsFunctionalname", fpsFunctionalname);

		ArrayList<String> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("SetValue", "Ignore"));
			}
			else
			{
				lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("SetValue", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::StartApp(string)
	/// \~english
	/// \copydoc IOKW_State::StartApp(string)
	///
	public void StartApp( String fps_ApplikationName ) throws Exception
	{
		Log.LogFunctionStart("StartApp", "fps_ApplikationName", fps_ApplikationName);

		try
		{
			CO.SetWindowName(fps_ApplikationName);
			CO.CallMethod("StartApp");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::StopApp(string)
	/// \~english
	/// \copydoc IOKW_State::StopApp(string)
	///
	public void StopApp( String fps_ApplikationName ) throws Exception
	{
		Log.LogFunctionStart("StopApp", "fps_ApplikationName", fps_ApplikationName);

		try
		{
			CO.SetWindowName(fps_ApplikationName);
			CO.CallMethod("StopApp");
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKey(string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKey(string,string)
	///
	public void TypeKey( String fpsFunctionalname, String fpsValue ) throws Exception
	{
		Log.LogFunctionStart("TypeKey", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		ArrayList<String> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("TypeKey", "Ignore"));
			}
			else
			{
				lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("TypeKey", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKeyTablecell(string,string,string,string)
	///
	public void TypeKeyTablecell( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsValue )
			throws Exception
	{
		Log.LogFunctionStart("TypeKeyTablecell", "fpsFunctionalname", fpsFunctionalname, "fpsColl", fpsCol, "fpsRow",
				fpsRow, "fpsValue", fpsValue);

		ArrayList<String> lvlsValue;

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("TypeKeyTablecell", "Ignore"));
			}
			else
			{
				// Werte in fpsValue separieren
				lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);

				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetChildName(fpsFunctionalname);
				CO.CallMethod("TypeKeyTablecell", fpsCol, fpsRow, lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::TypeKeyWindow(string,string)
	/// \~english
	/// \copydoc IOKW_State::TypeKeyWindow(string,string)
	///
	public void TypeKeyWindow( String fpsFunctionalname, String fpsValue ) throws Exception
	{
		Log.LogFunctionStart("TypeKeyWindow", "fpsFunctionalname", fpsFunctionalname, "fpsValue", fpsValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE") || fpsValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("TypeKeyWindow", "Ignore"));
			}
			else
			{
				ArrayList<String> lvlsValue = OKW_Const_Sngltn.getInstance().SplitSEP(fpsValue);
				lvlsValue = Parser.ParseMe(lvlsValue);

				CO.SetWindowName(fpsFunctionalname);
				CO.CallMethod("TypeKey", lvlsValue);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyCaption(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyCaption(string,string)
	///
	public void VerifyCaption( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyCaption", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyCaption", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifyCaption", lvlsExpected);

				// Verify:
				// 1. are the length of the lists equal?
				Log.LogPrint(LM.GetMessage("VerifyCaption", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifyCaption", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyExists(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyExists(string,string)
	///
	public void VerifyExists( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyExists", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Hier sind nur drei werte erlaubt: YES/NO/IGNORE

			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("NO"))
			{
				// Sprachabhängiges YES/NO nach Boolean transformieren
				Boolean lvsbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				Boolean lvbActual = CO.CallMethodReturn_BooleanPb("VerifyExists", lvsbExpectedValue);

				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(LM.GetMessage("VerifyExists", "VerifyValue"));

				// LANGUAGE: Prüfen: Sprachabhängigen string-vergleich
				// durchführen...
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da keinanderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyExists", "OKWNotAllowedValueException", fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyHasFocus(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyHasFocus(string,string)
	///
	public void VerifyHasFocus( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyHasFocus", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyHasFocus", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("NO"))
			{
				// Sprachabhängiges YES/NO nach Boolean transformieren
				Boolean lvsbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				Boolean lvbActual = CO.CallMethodReturn_BooleanPb("VerifyHasFocus", lvsbExpectedValue);

				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(LM.GetMessage("VerifyHasFocus", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);

				// \todo LANGUAGE: Püfen aws dieser eintrag soll:
				// Sprachabhängigen string-vergleich durchführen...
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da keinanderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyExists", "OKWNotAllowedValueException", fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyIsActive(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyIsActive(string,string)
	///
	public void VerifyIsActive( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyIsActive", "fpsFunctionalname", fpsFunctionalname, "fpsExpectedValue",
				fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyIsActive", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("NO"))
			{
				CO.SetChildName(fpsFunctionalname);

				// Erwarteten Wert(YES/NO, Sprachabhänging) nach Boolean
				// wandelen
				Boolean lvbExpectedValue = OKW_Const_Sngltn.getInstance().YesNo2Boolean(fpsExpectedValue);

				// Aktuellen Wert holen...
				Boolean lvbActual = CO.CallMethodReturn_BooleanPb("VerifyIsActive", lvbExpectedValue);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(LM.GetMessage("VerifyIsActive", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyExists", "OKWNotAllowedValueException", fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyLabel(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyLabel(string,string)
	///
	public void VerifyLabel( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyLabel", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyLabel", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifyLabel", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(LM.GetMessage("VerifyLabel", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifyLabel", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifySelectedValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifySelectedValue(string,string)
	///
	public void VerifySelectedValue( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifySelectedValue", "fpsFunctionalname", fpsFunctionalname, "fpsExpected",
				fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifySelectedValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifySelectedValue", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(LM.GetMessage("VerifySelectedValue", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifySelectedValue", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyTablecellValue(string,string,string,string)
	///
	public void VerifyTablecellValue( String fpsFunctionalname, String fpsCol, String fpsRow, String fpsExpectedValue )
			throws Exception
	{
		Log.LogFunctionStart("VerifyTablecellValue", "fpsFunctionalname", fpsFunctionalname, "fpsCol", fpsCol, "fpsRow",
				fpsRow, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyTablecellValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifyTablecellValue", fpsCol, fpsRow,
						lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(LM.GetMessage("VerifyTablecellValue", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifyTablecellValue", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyTooltip(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyTooltip(string,string)
	///
	public void VerifyTooltip( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyTooltip", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyTooltip", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				// Get the actuel value from object
				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifyTooltip", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(LM.GetMessage("VerifyTooltip", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifyTooltip", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \copydoc IOKW_State::VerifyValue(string,string)
	/// \~english
	/// \copydoc IOKW_State::VerifyValue(string,string)
	///
	public void VerifyValue( String fpsFunctionalname, String fpsExpectedValue ) throws Exception
	{
		Log.LogFunctionStart("VerifyValue", "fpsFunctionalname", fpsFunctionalname, "fpsExpected", fpsExpectedValue);

		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine weitere Aktion...
				Log.LogPrint(LM.GetMessage("VerifyValue", "Ignore"));
			}
			else
			{
				// Split giveneExpected Value
				ArrayList<String> lvlsExpected = OKW_Const_Sngltn.getInstance().SplitSEP(fpsExpectedValue);

				CO.SetChildName(fpsFunctionalname);
				ArrayList<String> Actual = CO.CallMethodReturn_ListString("VerifyValue", lvlsExpected);

				// Verify:
				// 1. are the List length equal?
				Log.LogPrint(LM.GetMessage("VerifyValue", "VerifyListCount"));

				Integer ActualSize = new Integer(Actual.size());
				Integer ExpectedSize = new Integer(lvlsExpected.size());
				Log.LogVerify(ActualSize.toString(), ExpectedSize.toString());

				Log.LogPrint(LM.GetMessage("VerifyValue", "VerifyValues"));

				for (int i = 0; i < Actual.size(); i++)
				{
					Log.LogVerify(Actual.get(i), lvlsExpected.get(i));
				}
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \~german
	/// \brief
	/// Zentrale Exception-Behandlung.
	///
	/// Methode führt folge Aktivitäten aus:
	/// -# Exception wird als Log ausgegeben.
	/// -# Daten des aktuellen Objektes werden für eine Fehler-Analyse
	/// ausgegeben (CO.LogObjectData()).
	/// -# Wechselt den Zustand auf NOK.
	/// -# Wenn OKW in NUNIT/UNIT aufgerufen wird (this.UNITTEST = true sein)
	/// dann wird an das Unittest-Framework die Exception weitergereicht.
	///
	/// \param e Exception aus der OK-Schlüsselwort-Methode
	/// \~english
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 02.03.2013
	private void HandleException( Exception e ) throws Exception
	{
		Log.LogPrint("==========================================================================");
		Log.LogException(e.getMessage());
		Log.LogPrint("--------");

		CO.LogObjectData();
		/*
		 * Log.LogPrint("--------"); Log.LogPrint(" Message:");
		 * Log.LogException(e.getMessage());
		 * 
		 * Log.LogPrint("-------"); Log.LogPrint(" Source:");
		 * Log.LogException(String.Format("{0}", e. Source));
		 * 
		 * Log.LogPrint("-------"); Log.LogPrint(" TargetSite:");
		 * Log.LogException(String.Format("{0}", e.TargetSite));
		 */
		Log.LogPrint("==========================================================================");

		// Change State to NOK
		this._Kernel.SetCurrentState(new NOK(this._Kernel));

		if (this.UNITTEST)
		{
			throw e;
		}
	}

	/// \copydoc IOKW_State::FileDelete(string)
	public void FileDelete( String fpsPathAndFileName ) throws Exception
	{
		String lvsPathAndFileName = "";

		Log.LogFunctionStart("FileDelete", "fpsPathAndFileName", fpsPathAndFileName);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsPathAndFileName == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsPathAndFileName == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(LM.GetMessage("FileDelete", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else
			{
				// 1. Parsen der Pfad-Eingabe
				lvsPathAndFileName = Parser.ParseMe(fpsPathAndFileName);
				// 2. Konvertieren des Pfad separators.
				lvsPathAndFileName = OKW_FileHelper.ConvertDirectorySeperator(lvsPathAndFileName);

				String lsvLog = LM.GetMessage("FileDelete", "ResolvedPath", lvsPathAndFileName);
				Log.LogPrint(lsvLog);

				// Basis-Funktion aufrufen...
				OKW_FileHelper.FilesDelete(lvsPathAndFileName);
			}
		}
		catch (Exception e)
		{
			HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \copydoc IOKW_State::VerifyFileExists(string,string)
	public void VerifyFileExists( String fpsPathAndFileName, String fpsExpectedValue ) throws Exception
	{
		String lvsPathAndFileName = "";

		Log.LogFunctionStart("VerifyFileExist", "fpsPathAndFileName", fpsPathAndFileName, "fpsExpectedValue",
				fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(LM.GetMessage("VerifyFileExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("NO"))
			{
				// Aktuellen Wert holen...

				// 1. Parsen der Pfad-Eingabe
				lvsPathAndFileName = Parser.ParseMe(fpsPathAndFileName);
				// 2. Konvertieren des Pfad separators.
				lvsPathAndFileName = OKW_FileHelper.ConvertDirectorySeperator(lvsPathAndFileName);

				String lsvLog = LM.GetMessage("VerifyFileExists", "ResolvedPath", lvsPathAndFileName);
				Log.LogPrint(lsvLog);

				// Basis-Funkton aufrufen...
				Boolean lvbActual = OKW_FileHelper.FileExists(lvsPathAndFileName);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(LM.GetMessage("VerifyIsActive", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyFileExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	/// \copydoc IOKW_State::VerifyDirectoryExists(string,string)
	public void VerifyDirectoryExists( String fpsPath, String fpsExpectedValue ) throws Exception
	{
		String lvsPath = "";

		Log.LogFunctionStart("VerifyDirectoryExists", "fpsPath", fpsPath, "fpsExpectedValue", fpsExpectedValue);
		try
		{
			// Prüfen ob ignoriert werden muss...
			if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetOKWConst4Internalname("IGNORE")
					|| fpsExpectedValue == "")
			{
				// Wenn der 1. Wert = IGNORE ist -> keine Weitere Aktion...
				Log.LogPrintDebug(LM.GetMessage("VerifyDirectoryExists", "Ignore"));
			}
			// Püfen ob YES/NO als Sollwert vorgegeben worden ist.
			else if (fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("YES")
					|| fpsExpectedValue == OKW_Const_Sngltn.getInstance().GetConst4Internalname("NO"))
			{
				// Aktuellen Wert holen...

				// 1. Parsen der Pfad-Eingabe
				lvsPath = Parser.ParseMe(fpsPath);
				// 2. Konvertieren des Pfad separators.
				lvsPath = OKW_FileHelper.ConvertDirectorySeperator(lvsPath);

				String lsvLog = LM.GetMessage("VerifyDirectoryExists", "ResolvedPath", lvsPath);
				Log.LogPrint(lsvLog);

				// Basis-Funkton aufrufen...
				Boolean lvbActual = OKW_FileHelper.DirectoryExists(lvsPath);

				// Aktuellen Wert nach YES/NO, Sprachabhänging, wandel...
				String lvsActual = OKW_Const_Sngltn.getInstance().Boolean2YesNo(lvbActual);

				// Soll/Ist Vergleich...
				Log.LogPrint(LM.GetMessage("VerifyDirectoryExists", "VerifyValue"));
				Log.LogVerify(lvsActual, fpsExpectedValue);
			}
			// Beide Bedingungen sind nicht erfüllt -> Exception da kein anderer
			// Wert hier erlaubt ist.
			else
			{
				String ExceptionLog = LM.GetMessage("VerifyDirectoryExists", "OKWNotAllowedValueException",
						fpsExpectedValue);
				throw new OKWNotAllowedValueException(ExceptionLog);
			}
		}
		catch (Exception e)
		{
			this.HandleException(e);
		}
		finally
		{
			Log.LogFunctionEnd();
		}
	}

	@Override
	public void CopyFile( String fpsSourcePathAndFileName, String fpsDestinationPathAndFileName )
	{
		// TODO Auto-generated method stub

	}

}