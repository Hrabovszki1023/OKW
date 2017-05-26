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

package okw;

import java.util.*;

import javax.xml.xpath.XPathExpressionException;

import okw.exceptions.*;
import okw.log.Logger_Sngltn;

/// \~german
/// \brief
/// Klasse enthält OKW-Hilfsfunktionen.
/// 
/// Diese Klasse kann und soll auch in projektspezifischen Klassen verwendet werden.
/// 
///
/// \~english
/// \brief
/// Class contains OKW-Helpfunctions.
/// 
/// This class is and should to be used in project specific classes.
/// 
public class OKW_Helper
{

	/// \copydoc CurrentObject::Log()
	private static Logger_Sngltn		Log	= Logger_Sngltn.getInstance();

	/// \copydoc CurrentObject::LM()
	private static LogMessenger	LM	= new LogMessenger("OKW_Helper");

	/** \~german
	 *  Konvertiert Boolean <tt>true</tt>/<tt>false</tt> nach String
	 * "true"/"false"
	 *
	 *
	 *  @param fpbTrueOrFalse Zu konvertierender boolischer Wert.
	 *  @return
	 *  + <code>true</code> wird umgewandelt in "true" und
	 *  + <code>false</code>wird zu "false".
	 *
	 *   > _Method names should always begin with a lower case character, and should not contain underscores._ - das wird hier _bewust_ IGNORIERT
	 *  \~english
	 *  Converts Boolean <tt>true</tt>/<tt>false</tt> to String "true"/"false"
	 *
	 * 
	 *  @param fpbTrueOrFalse Boolean value to be converted.
	 *  @return
	 *  + <code>true</code> is to be changed in "true" and
	 *  + <code>false</code>becomes "false".
	 * 
	 *  \~
	 *  @author Zoltán Hrabovszki
	 *  @date 2013.05.03
	 */
	public static String Boolean2String( Boolean fpbTrueOrFalse )
	{
		String lvsReturn = "";
		
		Log.LogFunctionStartDebug("OKW_Helper.Boolean2String", "fpbTrueOrFalse", fpbTrueOrFalse.toString());

		try
		{
			if (fpbTrueOrFalse)
			{
				lvsReturn = "true";
			}
			else
			{
				lvsReturn = "false";
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Der String wird am fpiCount-ten Trennzeichen abgetrennt und die linke
	/// Hälfte des String wird zurückgegeben.
	///
	/// Es wird eine Ausnahme (exception) ausgelöst, wenn
	/// * das Trennzeichen leer ist: OKW.OKWDelimiterIsEmptyException
	/// * fpiCount ist nicht im gültigen Bereich(1 &gt;= fpiCount &gt; c= Anzahl
	/// Trennzeichen): OKW.OKWDelimiterCountOutOfRangeException
	///
	/// __Gültige Beispiele:__
	/// * <code>"AAAA" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "C",
	/// 1)</code>
	/// * <code>"AAAACBBBB" =
	/// OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2)</code>
	/// * <code>"AAAAGGBBBB"=
	/// OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG",
	/// 2)</code>
	///
	/// __Beispiele mit Auslösung der Ausnahmeprozedur__
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "", 1) :
	/// OKW.OKWDelimiterIsEmptyException</code>
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3)
	/// : OKW.OKWDelimiterCountOutOfRangeException</code>
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG",
	/// 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
	///
	/// \param fpsSource Zeichenkette, welche geschnitten wird.
	/// \param fpsDelimiter Trennzeichen an der geschnitten wird. Das
	/// Trennzeichen selbst gehört nicht zum Ergebnis. Trennzeichen kann aus
	/// mehr als einem Zeichen bestehen.
	/// \param fpiCount Nummer des Trennzeichen, an der geschnitten wird.
	/// fpiCount ist aus der Menge der natürlichen Zahlen, 1, 2, 3, ...
	/// \returnLinke Seiten des String, gesehen vom Trennzeichen fpsDelemeter.
	///
	/// \~english
	/// \brief
	/// The String will be cut at the fpiCount-ten delimiter and the left half
	/// of the String is returned.
	///
	/// An exception is triggered, if
	/// * the delimiter is empty: OKW.OKWDelimiterIsEmptyException
	/// * fpiCount is not in valid parameters(1 &gt;= fpiCount &gt;c= numerb of
	/// delimiters): OKW.OKWDelimiterCountOutOfRangeException
	///
	/// __Valid examples:__
	/// * <code>"AAAA" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "C",
	/// 1)</code>
	/// * <code>"AAAACBBBB" =
	/// OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2)</code>
	/// * <code>"AAAAGGBBBB"=
	/// OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG",
	/// 2)</code>
	///
	/// __Examples with triggering the exception procedure__
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "", 1) :
	/// OKW.OKWDelimiterIsEmptyException</code>
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3)
	/// : OKW.OKWDelimiterCountOutOfRangeException</code>
	/// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG",
	/// 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
	///
	/// \param fpsSource Signstring to be cut.
	/// \param fpsDelimiter Delimiter which is cut. Delimiter itself is no part
	/// of the return. Delimiter can exist out of more than 1 sign.
	/// \param fpiCount Number of delimiter to be cut. fpiCount is out of the
	/// multitude of natural numbers, 1, 2, 3, ...
	/// \returnLeft sides of the String, viewed from delimiter fpsDelemeter.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03
	public static String getLeftFromDelimiterNumber( String fpsSource, String fpsDelimiter, Integer fpiCount ) throws XPathExpressionException
	{
		String lvsReturn = "";
		ArrayList<String> lvLsSplitedSource = null;

		int RangeMin = 1;
		int RangeMax = 1;

		try
		{
			Log.LogFunctionStartDebug("OKW_Helper.GetLeftFromDelimiterNumber", "fpsSource", fpsSource, "fpsDelimiter",
					fpsDelimiter, "fpiCount", fpiCount.toString());

			if ( ! "".equals( fpsDelimiter ) )
			{
				lvLsSplitedSource = splitString(fpsSource, fpsDelimiter);

				// Gültigen Werte bereich berechnen:
				RangeMax = lvLsSplitedSource.size() - 1;
				RangeMin = 1;

				// 1. Prüfen ob Split Zahl <= Count, anderefalls Exception
				// auslösen...
				if ((RangeMin <= fpiCount) & (fpiCount <= RangeMax))
				{
					// 2. Dann bauen wir den String auf
					lvsReturn = lvLsSplitedSource.get(0);

					for (int i = 1; i < fpiCount; i++)
					{
						lvsReturn = lvsReturn + fpsDelimiter + lvLsSplitedSource.get(i);
					}
				}
				else
				{
					String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterCountOutOfRangeException",
							fpiCount, RangeMax);
					throw new IndexOutOfBoundsException(lvsLM);
				}
			}
			else
			{
				String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterIsEmptyException");
				throw new IllegalArgumentException(lvsLM);
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Schneidet fpsSource am fpiCount-ten fpsDelimiter ab und liefert den
	/// rechten Teil des String zurück.
	///
	/// __Gültige Beispiele:__
	/// * <code> "DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE",
	/// "/", 3)</code>
	/// * <code> "BBB/CCC/DDD/EEE" =
	/// GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 1)</code>
	/// * <code> "EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/",
	/// 4)</code>
	///
	/// __Beispiele mit Auslösung der Ausnahmeprozedur__
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBB", "", 1) :
	/// OKW.OKWDelimiterIsEmptyException</code>
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBBCDDDD", "C",
	/// 3) : OKW.OKWDelimiterCountOutOfRangeException</code>
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD",
	/// "GG", 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
	///
	/// \param fpsSource Quelle.
	/// \param fpsDelimiter Trennzeichen an dem geschnitten werden soll.
	/// \param fpiCount
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~english
	/// \brief
	/// Cuts fpsSource at fpiCount-ten fpsDelimiter and returns the right part
	/// of the String.
	///
	/// __Valid examples:__
	/// * <code> "DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE",
	/// "/", 3)</code>
	/// * <code> "BBB/CCC/DDD/EEE" =
	/// GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 1)</code>
	/// * <code> "EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/",
	/// 4)</code>
	///
	/// __Examples triggering the exception procedure__
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBB", "", 1) :
	/// System.IndexOutOfRangeException</code>
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBBCDDDD", "C",
	/// 3) : System.IndexOutOfRangeException</code>
	/// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD",
	/// "GG", 0) : System.IndexOutOfRangeException</code>
	///
	/// \param fpsSource Quelle
	/// \param fpsDelimiter Delimiter which is to be cut.
	/// \param fpiCount
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03
	public static String getRightFromDelimiterNumber( String fpsSource, String fpsDelimiter, Integer fpiCount ) throws XPathExpressionException
	{
		String lvsReturn = "";
		List<String> lvLsSplitedSource = null;
		int RangeMin = 1;
		int RangeMax = 1;
		try
		{
			Log.LogFunctionStartDebug("OKW_Helper.GetRigthFromDelimiterNumber", "fpsSource", fpsSource, "fpsDelimiter",
					fpsDelimiter, "fpiCount", fpiCount.toString());
			
			if (  ! "".equals( fpsDelimiter ))
			{
				lvLsSplitedSource = splitString(fpsSource, fpsDelimiter);

				// Gültigen Werte bereich berechnen:
				RangeMax = lvLsSplitedSource.size() - 1;
				RangeMin = 1;

				// 1. Prüfen ob Split Zahl <= Count, anderefalls Exception
				// auslösen...
				if ((RangeMin <= fpiCount) & (fpiCount <= RangeMax))
				{
					// 2. Dann bauen wir den String auf
					lvsReturn = lvLsSplitedSource.get(fpiCount);

					for (int i = fpiCount + 1; i < lvLsSplitedSource.size(); i++)
					{
						lvsReturn = lvsReturn + fpsDelimiter + lvLsSplitedSource.get(i);
					}
				}
				else
				{
					String lvsLM = LM.GetMessage("GetRightFromDelimiterNumber", "OKWDelimiterCountOutOfRangeException",
							fpiCount, RangeMax);
					throw new IndexOutOfBoundsException(lvsLM);
				}
			}
			else
			{
				String lvsLM = LM.GetMessage("GetRightFromDelimiterNumber", "OKWDelimiterIsEmptyException");
				throw new IllegalArgumentException(lvsLM);
			}
		}
		finally
		{
		    Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Vergleicht zwei ListStrings inhaltlich miteinander.
	///
	/// \param ListString1 String Nr. 1
	/// \param ListString2 String Nr. 2
	/// \returnTrue falls die Strings identischen Inhalt haben, sonst false.
	///
	/// \~english
	/// \brief
	/// Compares two ListStrings with view to their content.
	///
	/// \param ListString1 String Nr. 1
	/// \param ListString2 String Nr. 2
	/// \returnTrue if the String content is identical, else false.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.15.11
	public static Boolean compareListString( List<String> ListString1, List<String> ListString2 )
	{
		Boolean lvbReturn = true;

		Log.LogFunctionStartDebug("OKW_Helper.ListStringCompare", "ListString1", ListString1.toString(), "ListString2",
				ListString2.toString());

		try
		{
			// HAben beide Listen
			if (ListString1.size() == ListString2.size())
			{
				for (int i = 0; i < ListString1.size(); i++)
				{
					if (ListString1.get(i) != ListString2.get(i))
					{
						// ungleich daher abbrechen und false zurückliefern.
						Log.LogPrintDebug(ListString1.get(i) + "<>" + ListString2.get(i));
						lvbReturn = false;
						break;
					}
					else
					{
						lvbReturn = true;
					}
				}
			}
			else
			{
				lvbReturn = false;
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Wandelt List&lt;String&gt; in einen String um und trennt die Werte durch
	/// das vorgegebene Trennzeichen voneinander.
	///
	/// Fügt die Elemente des ListString aneinander. Die Werte sind ggf. mit
	/// Separator getrennt.
	/// Der Separator kann aus __""__, einem oder mehr als einem Zeichen
	/// bestehen.
	///
	/// __Siehe auch:__
	/// http://stackoverflow.com/questions/3575029/c-sharp-listString-to-String-with-delimiter
	/// \remark Für das sprachabhängige Zusammenfügen und Splitten von
	/// Strings und List&lt;String&gt; verwende:
	///
	/// * OKW.LogMessenger.Instance.SplitHSEP()
	/// * OKW.LogMessenger.Instance.SplitVSEP()
	///
	/// \param fps_ListString2Concat Liste der zu verbindenden Strings
	/// \param fps_Separator Trennzeichen (Separator) der verwendet werden soll.
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~german
	/// \brief
	/// Changes List&lt;String&gt; to a String and departs the values with the
	/// given delimiter.
	///
	/// Adds the elements of ListString together. The values are possibly
	/// devided with a separator.
	/// The delemiter can consist of __""__, one ore more signs.
	///
	/// __Have a view to:__
	/// http://stackoverflow.com/questions/3575029/c-sharp-listString-to-String-with-delimiter
	/// \remark For the language depending merging and splitting of
	/// Strings and List&lt;String&gt; use:
	///
	/// * OKW.LogMessenger.Instance.SplitHSEP()
	/// * OKW.LogMessenger.Instance.SplitVSEP()
	///
	/// \param fps_ListString2Concat List of Strings to be merged
	/// \param fps_Separator delimiter (Separator) which should be used.
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.01.03
	public static String concatListString( ArrayList<String> fps_ListString2Concat, String fps_Delimiter )
	{
		String lvsReturn = "";

		Log.LogFunctionStartDebug("OKW_Helper.ListStringConcat", "fps_ListString2Concat",
				fps_ListString2Concat.toString(), "fps_Separator", fps_Delimiter);

		try
		{
			StringBuilder sb = new StringBuilder();
			
			for (int i=0;  i<fps_ListString2Concat.size(); i++)
			{
				if (i > 0)
				{
					sb.append(fps_Delimiter);
				}

				sb.append(fps_ListString2Concat.get(i));
			}

			lvsReturn = sb.toString();
		}
		finally
		{
			Log.LogFunctionEndDebug(lvsReturn);
		}

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Quelle:
	/// http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
	///
	/// \param fpsPattern
	/// \param fpsStringToMatch
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~english
	/// \brief
	/// Source:
	/// http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
	///
	/// \param fpsPattern
	/// \param fpsStringToMatch
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	public static Boolean matchString( String fpsPattern, String fpsStringToMatch )
	{
		// Variables:
		Boolean lvbReturn = false;

		// Action:
		try
		{
			Log.LogFunctionStartDebug("OKW_Helper.MatchStr", "String fpsPattern", fpsPattern, "String fpsStringToMatch",
					fpsStringToMatch);

			// Replace the * with an .* and the ? with a dot. Put ^ at the
			// beginning and a $ at the end
			// c#:String pattern = "^" + Regex.Escape(fpsPattern).Replace("\\*",
			// ".*").Replace("\\?", ".") + "$";
			String pattern = "^" + fpsPattern.replace("*", ".*").replace("?", ".") + "$";

			// c#: Regex regex;
			// c#: regex = new Regex(pattern);

			// C#: lvb_Return = regex.IsMatch(fpsStringToMatch);
			lvbReturn = fpsStringToMatch.matches(pattern);
		}
		finally
		{
				Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Quelle:
	/// http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
	///
	/// \param fpsPattern
	/// \param fpsStringToMatch
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~english
	/// \brief
	/// Source:
	/// http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
	///
	/// \param fpsPattern
	/// \param fpsStringToMatch
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	public static Boolean matchStrIgnoreCase( String fpsPattern, String fpsStringToMatch )
	{
		// Variables:
		Boolean lvbReturn = false;

		// Action:
		try
		{
			Log.LogFunctionStartDebug("OKW_Helper.MatchStrIgnoreCase", "String fpsPattern", fpsPattern,
					"String fpsStringToMatch", fpsStringToMatch);

			//
			// Replace the * with an .* and the ? with a dot. Put ^ at the
			// beginning and a $ at the end
			// c#:String pattern = "^" + Regex.Escape(fpsPattern).Replace("\\*",
			// ".*").Replace("\\?", ".") + "$";
			String pattern = "^" + fpsPattern.replace("*", ".*").replace("?", ".") + "$";

			// Now, run the Regex as you already know
			// c#: Regex regex;
			// c#: regex = new Regex(pattern, RegexOptions.IgnoreCase);

			// C#: lvb_Return = regex.IsMatch(fpsStringToMatch);
			lvbReturn = fpsStringToMatch.matches("(?i:" + pattern + ")");
		}
		finally
		{
			Log.LogFunctionEndDebug(lvbReturn);
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Entfernt Anführungstriche " am Anfang und am Ende.
	/// Anführungstriche, die sich im String-Inneren befinden, werden nicht
	/// entfernt.
	/// Sind am Anfang und Ende keine Anführungstriche, dann ist der
	/// Rückgabewert gleich dem Eingabewert.
	///
	/// \param fps_StringinQuotations String, welcher von Anführungstrichen
	/// befreit werden soll.
	/// \returnString ohne Anführungstriche am Anfang und Ende.
	///
	/// \~english
	/// \brief
	/// Removes quotation marks " at the beginning and at the end.
	/// Quotation marks being internal of the String will not be removed.
	/// If there are no quotation marks at the beginning and at the end, then
	/// the return is identical to the input.
	///
	/// \param fps_StringinQuotations String, which should be removed from
	/// quotation marks.
	/// \returnString without quotation marks at the beginning an the end.
	///
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03
	public static String removeBeginEndQuotations( String fps_StringinQuotations )
	{

		String lvsReturn = fps_StringinQuotations.replaceAll("^\"|\"$", "");

		return lvsReturn;
	}

	/// \~german
	/// \brief
	/// Konvertiert einen String-Array nach List-String
	///
	/// \param fpsStringArray Zu konvertierender Array.
	/// \returnKonvertierung als List-String.
	///
	/// \~english
	/// \brief
	/// Converts a String-Array to a List-String
	///
	/// \param fpsStringArray Array to be converted.
	/// \returnConvertion as a List-String.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03
	public static ArrayList<String> StringArray2ListStr( String[] fpsStringArray )
	{
		Log.LogFunctionStartDebug("OKW_Helper.StrArray2ListStr", "fpsStringArray", fpsStringArray.toString());

		ArrayList<String> lvls_Splited = new ArrayList<String>();
		lvls_Splited.clear();

		try
		{
			for (String lvsElement : fpsStringArray)
			{
				lvls_Splited.add(lvsElement);
			}
		}
		finally
		{
			Log.LogFunctionEndDebug(lvls_Splited);
		}

		return lvls_Splited;
	}

	/// \~german
	/// \brief
	/// Konvertiert String "true"/"false" nach Boolean
	/// <code>true</code>/<code>false</code>.
	///
	/// \exception
	/// Die Ausnahme OKWNotAllowedValueException wird ausgelöst,
	/// wenn der Eingabwert nicht "true"/"false" ist .
	///
	/// \param fpsTrueOrFalse Zu konvertierender String Wert.
	/// \return
	/// * <code>true</code> wird umgewandelt in "true" und
	/// * <code>false</code>wird zu "false".
	///
	/// \~english
	/// \brief
	/// Converts String "true"/"false" to Boolean
	/// <code>true</code>/<code>false</code>.
	///
	/// \exception
	/// The exception OKWNotAllowedValueException is triggerd,
	/// if the input Parapere is not "true"/"false".
	///
	/// \param fpbTrueOrFalse Boolean value to be converted.
	/// \return
	/// * <code>true</code> is to be changed in "true" and
	/// * <code>false</code>becomes "false".
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03

	public static Boolean String2Boolean( String fpsTrueOrFalse ) throws XPathExpressionException
	{
		Boolean lvbReturn = false;
		Boolean bOK = false;

		String lvsTrueOrFalse = fpsTrueOrFalse.toLowerCase();

		Log.LogFunctionStartDebug("OKW_Helper.String2Boolean", "fpsTrueOrFalse", fpsTrueOrFalse);

		try
		{
			if ( "true".equals( lvsTrueOrFalse ) )
			{
				lvbReturn = true;
				bOK = true;
			}
			else if ( "false".equals( lvsTrueOrFalse ) )
			{
				lvbReturn = false;
				bOK = true;
			}
			else
			{
				// alles andere löst ein OKWNotAllowedValueException aus
				bOK = false;

				String lvsLM = LM.GetMessage("String2Boolean", "OKWNotAllowedValueException", fpsTrueOrFalse);
				throw new OKWNotAllowedValueException(lvsLM);
			}
		}
		finally
		{
			if (bOK)
			{
				Log.LogFunctionEndDebug(lvbReturn);
			}
			else
			{
				Log.LogFunctionEndDebug();
			}
		}

		return lvbReturn;
	}

	/// \~german
	/// \brief
	/// Splittet einen String am angegebenen Separator auf.
	/// Der Separator kann aus mehr als einem Zeichen bestehen.
	///
	/// \param fpsString2Split Zu splittender String.
	/// \param fpsSeparator
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~english
	/// \brief
	/// Splits a String at the given Separator.
	/// The separator can consist of more than one sign.
	///
	/// \param fpsString2Split String to be splitted.
	/// \param fpsSeparator
	/// \return \todo TODO ZH: Rückgabewert beschreiben.
	///
	/// \~
	/// \author Zoltán Hrabovszki
	/// \date 2013.05.03
	/**public static ArrayList<String> splitString_old( String fpsString2Split, String fpsSeparator )
	{
		String[] lvsA_Splited;
		ArrayList<String> lvls_Splited = new ArrayList<String>();

		Log.LogFunctionStartDebug("OKW_Helper.StrSplit", "fpsString2Split", fpsString2Split, "fpsSeparator", fpsSeparator);

		try
		{
			lvsA_Splited = fpsString2Split.split(fpsSeparator);
			lvls_Splited = StringArray2ListStr(lvsA_Splited);
		}
		finally
		{
			Log.LogFunctionEndDebug(lvls_Splited);
		}

		return lvls_Splited;
	}*/

	
	
	public static ArrayList<String> splitString(String fpsString2Split, String fpsSeparator)
	{
		ArrayList<String> SplitedList = new ArrayList<String>();
	    int offset = 0;
	    
		Log.LogFunctionStartDebug("OKW_Helper.StrSplit", "fpsString2Split", fpsString2Split, "fpsSeparator",
				fpsSeparator);

		try
		{	    
	    while (true)
	    {
	        int index = fpsString2Split.indexOf(fpsSeparator, offset);
	        if (index == -1)
	        {
	        	SplitedList.add(fpsString2Split.substring(offset));
	            break;
	        }
	        else
	        {
	        	SplitedList.add(fpsString2Split.substring(offset, index));
	            offset = (index + fpsSeparator.length());
	        }
	    }
	}
	finally
	{
		Log.LogFunctionEndDebug(SplitedList);
	}
	    
	    return SplitedList;
	}
	
	
	/// \todo TODO: Methode Documentieren!
	public static String repeatString( char c, Integer n )
	{
		StringBuilder lvsReturn = new StringBuilder();
		
		for (Integer x = 0; x < n; x++)
			lvsReturn.append(c);
		
		return lvsReturn.toString();
	}
	

	/// \todo TODO: Methode Documentieren!
	public static String repeatString( String c, Integer n )
	{
		StringBuilder lvsReturn = new StringBuilder();
		
		for (Integer x = 0; x < n; x++)
			lvsReturn.append(c);
		
		return lvsReturn.toString();
	}

/**
 * \~german
 * Prüft ob der gegeben String `fpsStrin` `null` oder leer ("") ist.
 *
 * @param fpsStrin Zu prüfender String
 * @return `true`, falls der String Leer oder `null` ist sondt `false`
 * \~english
 *
 *
 * @param ? 
 * @return returns `true`, if the given String is empty or `null`, else `false`
 * \~
 * @author Zoltán Hrabovszki
 * @date 2017-04-27
 */
	public static Boolean isStringNullOrEmpty( String fpsString)
	{
		// Variables
	    Boolean lvbReturn = true;
		
	    // Action
		if(fpsString != null && !fpsString.isEmpty())
		{
			lvbReturn = false;
		}
		
		// Return
		return lvbReturn;
	}
}
