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

package okw.log;

import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import okw.OKW_Helper;

/// \~german
/// \brief Klasse zur Ausgabe in die System.out.
/// 
/// Ausgaben werden auf der Konsele farbig ausgegeben: Implementiert das Interface ILogger für eine Konsolen-Ausgabe:
/// - Normaler Log ist weiß/schwarz.
/// - Warning wird gelb,
/// - Error wird rot
/// - Passed wird grün und 
/// - Exception in pink
/// ausgegeben.
/// Quelle: https://stackoverflow.com/questions/1448858/how-to-color-system-out-println-output
/// \~english
/// \brief \todo TODO: Brief Description.
/// 
/// \todo TODO: Detailed Description
/// 
/// \~
/// \author Zoltán Hrabovszki
/// \date 2015.05.02
public class Log2Console implements ILogger
{

	        String BlanksBefore = "";
	        int LevelCounter = 0;
	        
	        private Boolean cvbDebugMode = false;

	        
			/**
	         * \copydoc ILogger::LogError(String)
			 */
			@Override
	        public void LogError(String fps_Message)
	        {
				System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
				System.out.println(this.BlanksBefore + " ERROR:");
				System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));      
				System.out.println(this.BlanksBefore + fps_Message);
				System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
	        }


			/**
	         * \copydoc ILogger::LogException(String)
			 */			@Override
			public void LogException(String fps_Message)
	        {
	            System.out.print(this.BlanksBefore + "Exception: ");
	            System.out.println(fps_Message);
	        }

	
	        /// \~german
	        /// \copydoc ILogger::LogFunctionEnd()
	        /// \~english
	        /// \copydoc ILogger::LogFunctionEnd()
	        ///
			@Override
			public void LogFunctionEnd()
	        {
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /// \~german
	        /// \copydoc ILogger::LogFunctionEnd(String)
	        /// \~english
	        /// \copydoc ILogger::LogFunctionEnd(String)
	        ///
			@Override
			public void LogFunctionEnd(String fps_Return)
	        {
	            this.ResOpenList("Return...");
	            this.LogPrint(fps_Return);
	            this.ResCloseList();
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /// \~german
	        /// \copydoc ILogger::LogFunctionEnd(Boolean)
	        /// \~english
	        /// \copydoc ILogger::LogFunctionEnd(Boolean)
	        ///
			@Override
	        public void LogFunctionEnd(Boolean fpb_Return)
	        {
	            this.ResOpenList("Return...");
	            this.LogPrint(fpb_Return.toString());
	            this.ResCloseList();
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /// \~german
	        /// \copydoc ILogger::LogFunctionEnd(List)
	        /// \~english
	        /// \copydoc ILogger::LogFunctionEnd(List)
	        ///
			@Override
	        public void LogFunctionEnd(List<String> fpls_Return)
	        {
	            this.ResOpenList("Return...");

	            for (String Value : fpls_Return)
	            {
	                this.LogPrint(Value);
	            }

	            this.ResCloseList();
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /// \~german
	        /// \copydoc ILogger::LogFunctionStart(String,params)
	        /// \~english
	        /// \copydoc ILogger::LogFunctionStart(String,params)
	        ///
			@Override
			public void LogFunctionStart(String fps_FunctionName, String... fpsParameter)
	        {
	            this.ResOpenList(fps_FunctionName);
	            this.ResOpenList("Parameter...");

	            for (int i = 0; i < fpsParameter.length; i += 2)
	            {
	                this.LogPrint(fpsParameter[i] + ": >>" + fpsParameter[i + 1] + "<<");
	            }

	            this.ResCloseList(); // Close Parameter List...
	            this.LogPrint("-------");

	            return;
	        }

	        /// \~german
	        /// \copydoc ILogger::LogKeyWordEnd()
	        /// \~english
	        /// \copydoc ILogger::LogKeyWordEnd()
	        ///
			@Override
	        public void LogKeyWordEnd()
	        {
	            this.ResCloseList();
	        }

	        /// \~german
	        /// \copydoc ILogger::LogKeyWordStart(String,params)
	        /// \~english
	        /// \copydoc ILogger::LogKeyWordStart(String,params)
	        /// 
			@Override
	        public void LogKeyWordStart(String fps_KeyWordName, String... fpsParameter)
	        {
	            String String2Print = fps_KeyWordName;

	            // Keyword without parameter
	            if (fpsParameter.length == 0)
	            {
	            // Keyword with one Parameter
	                String2Print = String2Print + "()";
	            }
	            // Keyword with one Parameter
	            else if (fpsParameter.length == 1)
	            {
	                String2Print = String2Print + ": \"" + fpsParameter[0] + "\"";
	            }
	            // Keyword with two Parameters
	            else if (fpsParameter.length == 2)
	            {
	                String2Print = String2Print + ": \"" + fpsParameter[0] + "\" = \"" + fpsParameter[1] + "\"";
	            }
	            // Keyword with more then two Parameters
	            else
	            {
	                String2Print = String2Print + "(\"" + fpsParameter[0] + "\"";

	                for (int i = 1; i < fpsParameter.length; i++)
	                {
	                    String2Print = String2Print + ", \"" + fpsParameter[i] + "\"";
	                }

	                String2Print = String2Print + ")";
	            }

	            this.ResOpenList(String2Print);

	            return;
	        }

			
			/**
	         * \copydoc ILogger::LogPass(String)
			 */
			@Override
	        public void LogPass( String fps_Message )
	        {
					System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
					System.out.println(this.BlanksBefore + " ERROR:");
					System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));      
					System.out.println(this.BlanksBefore + fps_Message);
					System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
		    }

			
			/**
	         *  \copydoc ILogger::LogPrint(String)
			 */
			@Override
	        public void LogPrint(String fps_Message)
	        {
	            System.out.println(this.BlanksBefore + fps_Message);
	        }

			
            /**
	         *  \copydoc ILogger::LogVerify(String,String)
	        */
			@Deprecated
			@Override
	        public void LogVerify(String fps_Actual, String fps_Expected)
	        {
	            System.out.println( this.BlanksBefore + "-------------------------------------------------------");
	            if (fps_Actual.equals( fps_Expected ))
	            {
		            System.out.println( this.BlanksBefore + "  Pass:");
	            }
	            else
	            {
		            System.out.println( this.BlanksBefore + "  Fail:");
	            }
	            // System.out.println(this.BlanksBefore + "-------------------------------------------------------");
	            System.out.println(this.BlanksBefore + "  Expected = >>" + fps_Expected + "<<");
	            System.out.println(this.BlanksBefore + "    Actual = >>" + fps_Actual + "<<");
	            System.out.println(this.BlanksBefore + "-------------------------------------------------------");
	        }


			
			/**
	         *  \copydoc ILogger::LogWarning(String)
			 */
			@Override
	        public void LogWarning(String fps_Message)
	        {	            
						System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
						System.out.println(this.BlanksBefore + " WARNING:");
						System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));      
						System.out.println(this.BlanksBefore + fps_Message);
						System.out.println(this.BlanksBefore + okw.OKW_Helper.StringRepeat("-", 80));
	        }

			
			/**
	         *  \copydoc ILogger::ResCloseList()
			 */
			@Override
	        public void ResCloseList()
	        {
	            if (this.LevelCounter > 0) 
	            {
	                this.LevelCounter--;
	            }
	            else
	            {
	                this.LevelCounter = 0;
	            }
	            
	            this.BlankBefore();
	        }

			
	        /// \~german
	        /// \copydoc ILogger::ResOpenList(String)
	        /// \~english
	        /// \copydoc ILogger::ResOpenList(String)
	        ///
			@Override
	        public void ResOpenList(String fps_Name)
	        {
	            this.LogPrint(fps_Name);
	            this.LevelCounter++;
	            this.BlankBefore();
	        }

	        /// \~german
	        /// \copydoc ILogger::BlankBefore()
	        /// \~english
	        /// \copydoc ILogger::BlankBefore()
	        ///
	        private void BlankBefore()
	        {
	            this.BlanksBefore = OKW_Helper.StringRepeat( "  ", this.LevelCounter);
	        }

			@Override
			public void LogTestcaseStart( String fps_TestcaseName )
			{
				LogPrint("");
				LogPrint("-------------------------------------------------------------------------");
				LogKeyWordStart( "Testcase", fps_TestcaseName );
			}

			@Override
			public void LogTestcaseEnd()
			{
				this.ResCloseList();
				LogPrint("-------------------------------------------------------------------------");
			}


			@Override
			public void LogSequenceStart( String fps_KeyWordName, String fpsWindowFN,
					String fps_SequenceName, String... fpsParameter )
			{
				String[] myParameter = {fpsWindowFN, fps_SequenceName};
				
				myParameter = (String[])ArrayUtils.addAll(myParameter, fpsParameter);
				
				LogKeyWordStart( fps_KeyWordName, myParameter );
			}

			@Override
			public void LogSequenceEnd()
			{
	            this.ResCloseList();
			}

			@Override
			public void LogFunctionStartDebug( String fps_FunctionName, String... fpsParameter )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionStart(fps_FunctionName, fpsParameter);
				}
			}

			@Override
			public void LogFunctionEndDebug()
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd();
				}
			}


			@Override
			public void LogFunctionEndDebug( Boolean fpb_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd();
				}
			}

			@Override
			public void LogFunctionEndDebug( String fps_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd( fps_Return );
				}
			}

			@Override
			public void LogFunctionEndDebug( List<String> fpLs_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd( fpLs_Return );
				}
			}

			@Override
			public void LogPrintDebug( String fps_Message )
			{
				if (this.cvbDebugMode)
				{
					LogPrint( fps_Message );
				}
			}

			@Override
			public void ResOpenListDebug( String fps_Name )
			{
				if (this.cvbDebugMode)
				{
					ResOpenList( fps_Name );
				}
			}

			@Override
			public void ResCloseListDebug()
			{
				if (this.cvbDebugMode)
				{
					ResCloseList( );
				}
			}
			
			public void setDebugMode( Boolean cvbDebugMode )
			{
				this.cvbDebugMode = cvbDebugMode;
				
			}


}
