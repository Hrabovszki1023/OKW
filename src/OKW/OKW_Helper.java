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

package OKW;


    import java.util.*;;

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
        
        /// \~german
        /// \copydoc CurrentObject::Log()
        /// \~english
        /// \copydoc CurrentObject::Log()
        /// 
        private static Logger Log = Logger.Instance;

        /// \~german
        /// \copydoc CurrentObject::LM()
        /// \~english
        /// \copydoc CurrentObject::LM()
        /// 
        private static LogMessenger LM = new LogMessenger("OKWHelper");


        /// \~german
        /// \brief
        /// Konvertiert Boolean <tt>true</tt>/<tt>false</tt> nach String "true"/"false"
        /// 
        /// 
        /// \param fpbTrueOrFalse  Zu konvertierender boolischer Wert.
        /// \return
        /// * <code>true</code> wird umgewandelt in "true" und
        /// * <code>false</code>wird zu "false".
        ///
        /// \~english
        /// \brief
        /// Converts Boolean <tt>true</tt>/<tt>false</tt> to String "true"/"false"
        /// 
        /// 
        /// \param fpbTrueOrFalse  Boolean value to be converted.
        /// \return
        /// * <code>true</code> is to be changed in "true" and
        /// * <code>false</code>becomes "false".
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.05.03
        public static String Boolean2String(Boolean fpbTrueOrFalse)
        {
            String lvsReturn = "";

            Logger.Instance.LogFunctionStartDebug("OKW_Helper.Boolean2String", "fpbTrueOrFalse", fpbTrueOrFalse.ToString());

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
                Logger.Instance.LogFunctionEndDebug(lvsReturn);
            }

            return lvsReturn;
        }

        /// \~german
        /// \brief
        /// Der String wird am fpiCount-ten Trennzeichen abgetrennt und die linke Hälfte des String wird zurückgegeben.
        /// 
        /// Es wird eine Ausnahme (exception) ausgelöst, wenn
        /// * das Trennzeichen leer ist: OKW.OKWDelimiterIsEmptyException
        /// * fpiCount ist nicht im gültigen Bereich(1 &gt;= fpiCount &gt; c= Anzahl Trennzeichen): OKW.OKWDelimiterCountOutOfRangeException
        /// 
        /// __Gültige Beispiele:__
        /// * <code>"AAAA" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "C", 1)</code>
        /// * <code>"AAAACBBBB" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2)</code>
        /// * <code>"AAAAGGBBBB"= OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 2)</code>
        /// 
        /// __Beispiele mit Auslösung der Ausnahmeprozedur__
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "", 1) : OKW.OKWDelimiterIsEmptyException</code>
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// 
        /// \param fpsSource Zeichenkette, welche geschnitten wird.
        /// \param fpsDelimiter Trennzeichen an der geschnitten wird. Das Trennzeichen selbst gehört nicht zum Ergebnis. Trennzeichen kann aus mehr als einem Zeichen bestehen.
        /// \param fpiCount Nummer des Trennzeichen, an der geschnitten wird. fpiCount ist aus der Menge der natürlichen Zahlen, 1, 2, 3, ...
        /// \returnLinke Seiten des String, gesehen vom Trennzeichen fpsDelemeter.
        ///
        /// \~english
        /// \brief
        /// The String will be cut at the fpiCount-ten delimiter and the left half of the String is returned.
        /// 
        /// An exception is triggered, if
        /// * the delimiter is empty: OKW.OKWDelimiterIsEmptyException
        /// * fpiCount is not in valid parameters(1 &gt;= fpiCount &gt;c= numerb of delimiters): OKW.OKWDelimiterCountOutOfRangeException
        /// 
        /// __Valid examples:__
        /// * <code>"AAAA" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "C", 1)</code>
        /// * <code>"AAAACBBBB" = OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 2)</code>
        /// * <code>"AAAAGGBBBB"= OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 2)</code>
        /// 
        /// __Examples with triggering the exception procedure__
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBB", "", 1) : OKW.OKWDelimiterIsEmptyException</code>
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// * <code> OKW_Helper.GetLeftFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// 
        /// \param fpsSource Signstring to be cut.
        /// \param fpsDelimiter Delimiter which is cut. Delimiter itself is no part of the return. Delimiter can exist out of more than 1 sign.
        /// \param fpiCount Number of delimiter to be cut. fpiCount is out of the multitude of natural numbers, 1, 2, 3, ...
        /// \returnLeft sides of the String, viewed from delimiter fpsDelemeter.
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.05.03
        public static String GetLeftFromDelimiterNumber(String fpsSource, String fpsDelimiter, int fpiCount)
        {
            String lvsReturn = "";
            List<String> lvLsSplitedSource = null;

            Boolean bOK = false;

            int RangeMin = 1;
            int RangeMax = 1;

            try
            {
                Log.LogFunctionStartDebug("OKW_Helper.GetLeftFromDelimiterNumber", "fpsSource", fpsSource, "fpsDelimiter", fpsDelimiter, "fpiCount", fpiCount.ToString());

                if (fpsDelimiter != "")
                {
                    lvLsSplitedSource = StrSplit(fpsSource, fpsDelimiter);

                    // Gültigen Werte bereich berechnen:
                    RangeMax = lvLsSplitedSource.size() - 1;
                    RangeMin = 1;

                    // 1. Prüfen ob Split Zahl <= Count, anderefalls Exception auslösen...
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
                        String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterCountOutOfRangeException", fpiCount.ToString(), RangeMax.ToString());
                        throw new System.IndexOutOfRangeException(lvsLM);
                    }
                }
                else
                {
                    String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterIsEmptyException");
                    throw new System.ArgumentException(lvsLM);
                }

                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Log.LogFunctionEndDebug(lvsReturn);
                }
                else
                {
                    Log.LogFunctionEndDebug();
                }
            }

            return lvsReturn;
        }

        /// \~german
        /// \brief
        /// Schneidet fpsSource am fpiCount-ten fpsDelimiter ab und liefert den rechten Teil des String zurück.
        /// 
        /// __Gültige Beispiele:__
        /// * <code> "DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 3)</code>
        /// * <code> "BBB/CCC/DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 1)</code>
        /// * <code> "EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 4)</code>
        /// 
        /// __Beispiele mit Auslösung der Ausnahmeprozedur__
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBB", "", 1) : OKW.OKWDelimiterIsEmptyException</code>
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0) : OKW.OKWDelimiterCountOutOfRangeException</code>
        /// 
        /// \param fpsSource Quelle.
        /// \param fpsDelimiter Trennzeichen an dem geschnitten werden soll.
        /// \param fpiCount
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        ///
        /// \~english
        /// \brief
        /// Cuts fpsSource at fpiCount-ten fpsDelimiter and returns the right part of the String.
        /// 
        /// __Valid examples:__
        /// * <code> "DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 3)</code>
        /// * <code> "BBB/CCC/DDD/EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 1)</code>
        /// * <code> "EEE" = GetRigthFromDelimiterNumber("AAA/BBB/CCC/DDD/EEE", "/", 4)</code>
        /// 
        /// __Examples triggering the exception procedure__
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBB", "", 1) : System.IndexOutOfRangeException</code>
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAACBBBBCDDDD", "C", 3) : System.IndexOutOfRangeException</code>
        /// * <code> OKW_Helper.GetRigthFromDelimiterNumber("AAAAGGBBBBGGDDDD", "GG", 0) : System.IndexOutOfRangeException</code>
        /// 
        /// \param fpsSource Quelle
        /// \param fpsDelimiter Delimiter which is to be cut.
        /// \param fpiCount
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.05.03
        public static String GetRigthFromDelimiterNumber(String fpsSource, String fpsDelimiter, int fpiCount)
        {
            String lvsReturn = "";
            List<String> lvLsSplitedSource = null;
            Boolean bOK = false;
            int RangeMin = 1;
            int RangeMax = 1;
            try
            {
                Log.LogFunctionStartDebug("OKW_Helper.GetLeftFromDelimiterNumber", "fpsSource", fpsSource, "fpsDelimiter", fpsDelimiter, "fpiCount", fpiCount.ToString());
                if (fpsDelimiter != "")
                {
                    lvLsSplitedSource = StrSplit(fpsSource, fpsDelimiter);

                    // Gültigen Werte bereich berechnen:
                    RangeMax = lvLsSplitedSource.Count - 1;
                    RangeMin = 1;

                    // 1. Prüfen ob Split Zahl <= Count, anderefalls Exception auslösen...
                    if ((RangeMin <= fpiCount) & (fpiCount <= RangeMax))
                    {
                        // 2. Dann bauen wir den String auf
                        lvsReturn = lvLsSplitedSource[fpiCount];

                        for (int i = fpiCount + 1; i < lvLsSplitedSource.Count; i++)
                        {
                            lvsReturn = lvsReturn + fpsDelimiter + lvLsSplitedSource[i];
                        }
                    }
                    else
                    {
                        String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterCountOutOfRangeException", fpiCount.ToString(), RangeMax.ToString());
                        throw new System.IndexOutOfRangeException(lvsLM);
                    }
                }
                else
                {
                    String lvsLM = LM.GetMessage("GetLeftFromDelimiterNumber", "OKWDelimiterIsEmptyException");
                    throw new System.ArgumentException(lvsLM);
                }

                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Log.LogFunctionEndDebug(lvsReturn);
                }
                else
                {
                    Log.LogFunctionEndDebug();
                }
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
        public static Boolean ListStringCompare(List<String> ListString1, List<String> ListString2)
        {
            Boolean lvbReturn = true;
            Boolean bOK = false;

            Logger.Instance.LogFunctionStartDebug("OKW_Helper.ListStringCompare", "ListString1", ListString1.ToString(), "ListString2", ListString2.ToString());

            try
            {
                // HAben beide Listen
                if (ListString1.Count == ListString2.Count)
                {
                    for (int i = 0; i < ListString1.Count; i++)
                    {
                        if (ListString1[i] != ListString2[i])
                        {
                            // ungleich daher abbrechen und false zurückliefern.
                            Logger.Instance.LogPrintDebug(ListString1[i] + "<>" + ListString2[i]);
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
                
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Logger.Instance.LogFunctionEndDebug(lvbReturn);
                }
                else
                {
                    Logger.Instance.LogFunctionEndDebug();
                }
            }
            
            return lvbReturn;
        }

        /// \~german
        /// \brief
        /// Wandelt List&lt;String&gt; in einen String um und trennt die Werte durch das vorgegebene Trennzeichen voneinander.
        /// 
        /// Fügt die Elemente des ListString aneinander. Die Werte sind ggf. mit Separator getrennt.
        /// Der Separator kann aus __""__, einem oder mehr als einem Zeichen bestehen.
        /// 
        /// __Siehe auch:__ http://stackoverflow.com/questions/3575029/c-sharp-listString-to-String-with-delimiter
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
        /// Changes List&lt;String&gt; to a String and departs the values with the given delimiter.
        /// 
        /// Adds the elements of ListString together. The values are possibly devided with a separator.
        /// The separator can consist oder __""__, one ore more signs.
        /// 
        /// __Have a view to:__ http://stackoverflow.com/questions/3575029/c-sharp-listString-to-String-with-delimiter
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
        public static String ListStringConcat(List<String> fps_ListString2Concat, String fps_Separator)
        {
            String lvsReturn = "";
            Boolean bOK = false;

            Log.LogFunctionStartDebug("OKW_Helper.ListStringConcat", "fps_ListString2Concat", fps_ListString2Concat.ToString(), "fps_Separator", fps_Separator);

            try
            {
                lvsReturn = String.Join(fps_Separator, fps_ListString2Concat.ToArray());
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Log.LogFunctionEndDebug(lvsReturn);
                }
                else
                {
                    Log.LogFunctionEndDebug();
                }
            }

            return lvsReturn;
        }

        /// \~german
        /// \brief
        /// Quelle: http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
        /// 
        /// \param fpsPattern
        /// \param fpsStringToMatch
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        ///
        /// \~english
        /// \brief
        /// Source: http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
        /// 
        /// \param fpsPattern
        /// \param fpsStringToMatch
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        public static Boolean MatchStr(String fpsPattern, String fpsStringToMatch)
        {
            // Variables:
            Boolean lvbReturn = false;
            Boolean bOK = false;

            // Action:
            try
            {
                Logger.Instance.LogFunctionStartDebug("OKW_Helper.MatchStr", "String fpsPattern", fpsPattern, "String fpsStringToMatch", fpsStringToMatch);

                // Replace the * with an .* and the ? with a dot. Put ^ at the
                // beginning and a $ at the end
                String pattern = "^" + Regex.Escape(fpsPattern).Replace(@"\*", ".*").Replace(@"\?", ".") + "$";

                // Now, run the Regex as you already know
                Regex regex;
                regex = new Regex(pattern);

                lvbReturn = regex.IsMatch(fpsStringToMatch);
                bOK = true;
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
        /// Quelle: http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
        /// 
        /// \param fpsPattern
        /// \param fpsStringToMatch
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        ///
        /// \~english
        /// \brief
        /// Source: http://stackoverflow.com/questions/6907720/need-to-perform-wildcard-etc-search-on-a-String-using-regex
        /// 
        /// \param fpsPattern
        /// \param fpsStringToMatch
        /// \return \todo TODO ZH: Rückgabewert beschreiben.
        public static Boolean MatchStrIgnoreCase(String fpsPattern, String fpsStringToMatch)
        {
            // Variables:
            Boolean lvb_Return = false;
            Boolean bOK = true;

            // Action:
            try
            {
                Logger.Instance.LogFunctionStartDebug("OKW_Helper.MatchStrIgnoreCase", "String fpsPattern", fpsPattern, "String fpsStringToMatch", fpsStringToMatch);

                // Replace the * with an .* and the ? with a dot. Put ^ at the
                // beginning and a $ at the end
                String pattern = "^" + Regex.Escape(fpsPattern).Replace(@"\*", ".*").Replace(@"\?", ".") + "$";

                // Now, run the Regex as you already know
                Regex regex;
                regex = new Regex(pattern, RegexOptions.IgnoreCase);

                lvb_Return = regex.IsMatch(fpsStringToMatch);
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Logger.Instance.LogFunctionEndDebug(lvb_Return);
                }
                else
                {
                    Logger.Instance.LogFunctionEndDebug();
                }
            }
            
            return lvb_Return;
        }

        /// \~german
        /// \brief
        /// Entfernt Anführungstriche " am Anfang und am Ende.
        /// Anführungstriche, die sich im String-Inneren befinden, werden nicht entfernt.
        /// Sind am Anfang und Ende keine Anführungstriche, dann ist der Rückgabewert gleich dem Eingabewert.
        /// 
        /// \param fps_StringinQuotations String, welcher von Anführungstrichen befreit werden soll.
        /// \returnString ohne Anführungstriche am Anfang und Ende.
        ///
        /// \~english
        /// \brief
        /// Removes quotation marks " at the beginning and at the end.
        /// Quotation marks being internal of the String will not be removed.
        /// If there are no quotation marks at the beginning and at the end, then the return is identical to the input.
        /// 
        /// \param fps_StringinQuotations String, which should be removed from quotation marks.
        /// \returnString without quotation marks at the beginning an the end.
        ///
        /// \author Zoltán Hrabovszki
        /// \date 2013.05.03
        public static String RemoveBeginEndQuotations(String fps_StringinQuotations)
        {
            String lvs_Return = Regex.Replace(fps_StringinQuotations, "^\"|\"$", "");
            return lvs_Return;
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
        public static List<String> StrArray2ListStr(String[] fpsStringArray)
        {
            Logger.Instance.LogFunctionStartDebug("OKW_Helper.StrArray2ListStr", "fpsStringArray", fpsStringArray.ToString());

            List<String> lvls_Splited = new List<String>();
            lvls_Splited.Clear();

            try
            {
                lvls_Splited = new List<String>(fpsStringArray);
            }
            finally
            {
                Logger.Instance.LogFunctionEndDebug(lvls_Splited);
            }
            
            return lvls_Splited;
        }

        /// \~german
        /// \brief
        /// Konvertiert String "true"/"false" nach Boolean <code>true</code>/<code>false</code>.
        /// 
        /// \exception
        /// Die Ausnahme OKWNotAllowedValueException wird ausgelöst,
        /// wenn der Eingabwert nicht "true"/"false" ist .
        /// 
        /// \param fpsTrueOrFalse  Zu konvertierender String Wert.
        /// \return
        /// * <code>true</code> wird umgewandelt in "true" und
        /// * <code>false</code>wird zu "false".
        ///
        /// \~english
        /// \brief
        /// Converts String "true"/"false" to Boolean <code>true</code>/<code>false</code>.
        /// 
        /// \exception
        /// The exception OKWNotAllowedValueException is triggerd,
        /// if the input Parapere is not "true"/"false".
        /// 
        /// \param fpbTrueOrFalse  Boolean value to be converted.
        /// \return
        /// * <code>true</code> is to be changed in "true" and
        /// * <code>false</code>becomes "false".
        ///
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.05.03

        public static Boolean String2Boolean(String fpsTrueOrFalse)
        {
            Boolean lvbReturn = false;
            Boolean bOK = false;

            String lvsTrueOrFalse = fpsTrueOrFalse.ToLower();

            Logger.Instance.LogFunctionStartDebug("OKW_Helper.String2Boolean", "fpsTrueOrFalse", fpsTrueOrFalse);

            try
            {
                if ( lvsTrueOrFalse == "true")
                {
                    lvbReturn = true;
                    bOK = true;
                }
                else if ( lvsTrueOrFalse == "false" )
                {
                    lvbReturn = false;
                    bOK = true;
                }
                else{
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
        public static List<String> StrSplit(String fpsString2Split, String fpsSeparator)
        {
            Boolean bOK = false;

            String[] lvsA_Splited;
            List<String> lvls_Splited = new List<String>();

            String[] lvsSeparators = new String[] { fpsSeparator };

            Log.LogFunctionStartDebug("OKW_Helper.StrSplit", "fpsString2Split", fpsString2Split, "fpsSeparator", fpsSeparator);

            try
            {
                lvsA_Splited = fpsString2Split.Split(lvsSeparators, StringSplitOptions.None);
                lvls_Splited = StrArray2ListStr(lvsA_Splited);
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    Log.LogFunctionEndDebug(lvls_Splited);
                }
                else
                {
                    Log.LogFunctionEndDebug();
                }
            }
            
            return lvls_Splited;
        }

    }
}