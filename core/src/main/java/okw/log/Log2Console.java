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

package okw.log;

import java.util.List;
import okw.OKW_Helper;

/** \~german
 *  Klasse zur Ausgabe in die System.out.
 *  
 *  \~english
 *  \brief \todo TODO: Brief Description.
 *  
 *  \todo TODO: Detailed Description
 *  
 *  \~
 *  \author Zoltán Hrabovszki
 *  \date 2015.05.02
 */
public class Log2Console implements ILogger
{

	        private String BlanksBefore = "";
	        private int LevelCounter = 0;
	        
	        private Boolean cvbDebugMode = false;

	        
	        public void reset()
	        {
		        LevelCounter = 0;
		        BlanksBefore = "";
		        
		        this.BlanksBefore();
	        }
	        
	        
			/**
	         * \copydoc ILogger::LogError(String)
			 */
			@Override
	        public void LogError(String fps_Message)
	        {
				System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));
				System.out.println(this.BlanksBefore + "ERROR: " + fps_Message);
				System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));      
	        }


			/**
	         * \copydoc ILogger::LogException(String)
			 */			@Override
			public void LogException(String fps_Message)
	        {
	            System.out.print(this.BlanksBefore + "Exception: ");
	            System.out.println(fps_Message);
	        }

	
	        /**
	         *  \copydoc ILogger::LogFunctionEnd()
	         */
			public void LogFunctionEnd()
	        {
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /**
	         *  \copydoc ILogger::LogFunctionEnd(String)
	         */
			public void LogFunctionEnd(String fps_Return)
	        {
	            this.ResOpenList("Return...");
	            this.LogPrint(fps_Return);
	            this.ResCloseList();
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }

	        /**
	         *  \copydoc ILogger::LogFunctionEnd(Boolean)
	         */
	        public void LogFunctionEnd(Boolean fpb_Return)
	        {
	            this.ResOpenList("Return...");
	            this.LogPrint(fpb_Return.toString());
	            this.ResCloseList();
	            this.LogPrint("-------");
	            this.ResCloseList();
	        }


	        /**
	         *  \copydoc ILogger::LogFunctionEnd(List<String>)
	         */
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


	        /**
	         *  \copydoc ILogger::LogFunctionStart(String,String...)
	         */
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
	        }

			
	        /**
	         *  \copydoc ILogger::LogKeyWordEnd()
	         */
	        public void LogKeyWordEnd()
	        {
	            this.ResCloseList();
	        }

	        
	        /**
	         *  \copydoc ILogger::LogKeyWordStart(String,String...)
	         */
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
	        }

	        
            /**
             *  \copydoc ILogger::LogAcceptanceCriteriaStart(String,String)
             */
            public void LogLocalACCallStart( String sourceExcerpt, String Type )
            {
                this.ResOpenList( sourceExcerpt );
                this.LogPrint( "Type: " + Type );
            }
			
            
            /**
             *  \copydoc ILogger::LogAcceptanceCriteriaEnd()
             */
            public void LogLocalACCallEnd()
            {
                this.ResCloseList();
            }

            
            /**
             *  \copydoc ILogger::LogRemoteACCallStart(String, String)
             */
            public void LogRemoteACCallStart( String sourceExcerpt, String Type )
            {
                this.ResOpenList( sourceExcerpt );
                this.LogPrint( "Type: " + Type );
            }
            
            
            /**
             *  \copydoc ILogger::LogRemoteACCallEnd()
             */
            public void LogRemoteACCallEnd()
            {
                this.ResCloseList();
            }

            /**
             *  \copydoc ILogger::LogStepStart(String,String,String,String,String,String,String)
             */
            public void LogStepStart( String categoryName, String categoryType, 
                            String choiceValue, String featureName,
                            String localCategoryName, String sourceExcerpt,
                            String type )
            {
                this.LogPrint( "Step: " + sourceExcerpt);
                this.LevelCounter++;
                this.LogPrint( "       Feature Name:" + featureName);
                this.LogPrint( "      Category Name:" + categoryName );
                this.LogPrint( "      Category Type:" + categoryType );
                this.LogPrint( "       Choice Value:" + choiceValue);  
                this.LogPrint( "Local Category Name:" + localCategoryName);
                this.LogPrint( "               Type:" + type);
                this.BlanksBefore();
            }
            
            /**
             *  \copydoc ILogger::LogAcceptanceCriteriaEnd()
             */
            public void LogStepEnd()
            {
                this.ResCloseList();
            }
 

            /**
             *  \copydoc ILogger::LogPreconditionStart(String)
             */
            public void LogPreconditionStart( String Gherkin )
            {
                this.ResOpenList( Gherkin );
            }
            
            
            /**
             *  \copydoc ILogger::LogPreconditionEnd()
             */
            public void LogPreconditionEnd()
            {
                this.ResCloseList();
            }

            

            /**
             *  \copydoc ILogger::LogPostconditionStart(String)
             */
            public void LogPostconditionStart( String Gherkin )
            {
                this.ResOpenList( Gherkin );
            }
            
            
            /**
             *  \copydoc ILogger::LogPostconditionCriteriaEnd()
             */
            public void LogPostconditionEnd()
            {
                this.ResCloseList();
            }
            
			/**
	         * \copydoc ILogger::LogPass(String)
			 */
	        public void LogPass( String fps_Message )
	        {
					System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));
					System.out.println(this.BlanksBefore + "Pass: " + fps_Message);
					System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));      
		    }

			
			/**
	         *  \copydoc ILogger::LogPrint(String)
			 */
	        public void LogPrint(String fps_Message)
	        {
	            System.out.println(this.BlanksBefore + fps_Message);
	        }


            
            /**
             *  \copydoc ILogger::LogSourceLocation(String,String,String,String)
             */
            public void LogSourceLocation( String Start, String End, String featureName, String sourceType )
            {
                System.out.println(this.BlanksBefore + featureName);
                System.out.println(this.BlanksBefore + Start);
                System.out.println(this.BlanksBefore + End);
                System.out.println(this.BlanksBefore + sourceType);
            }
			
            
			/**
	         *  \copydoc ILogger::LogWarning(String)
			 */
	        public void LogWarning(String fps_Message)
	        {	            
						System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));
						System.out.println(this.BlanksBefore + "WARNING: " + fps_Message);
						System.out.println(this.BlanksBefore + OKW_Helper.repeatString("-", 80));      
	        }

			
			/**
	         *  \copydoc ILogger::ResCloseList()
			 */
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
	            
	            this.BlanksBefore();
	        }

			
	        /**
	         *  \copydoc ILogger::ResOpenList(String)
	         */
	        public void ResOpenList(String fps_Name)
	        {
	            this.LogPrint(fps_Name);
	            this.LevelCounter++;
	            this.BlanksBefore();
	        }
	        
	        
	        /**
	         *  Erzeugt die Einrücktiefe für die Console-Ausgabe.
	         *  
	         *  Ergebniss befindet sich im Feld BlanksBefore.
	         */
	        private void BlanksBefore()
	        {
	            this.BlanksBefore = OKW_Helper.repeatString( "  ", this.LevelCounter);
	        }

	        /**
	         *  \copydoc ILogger::LogTestcaseStart(String)
	         */
			public void LogTestcaseStart( String fps_TestcaseName )
			{
				// Reset Log2Console
				reset(); // Reset LevelCounter, BlanksBefor
				
				LogPrint("");
				LogPrint("-------------------------------------------------------------------------");
				LogKeyWordStart( "Testcase", fps_TestcaseName );
			}

			
	        /**
	         *  \copydoc ILogger::LogTestcaseEnd()
	         */
			public void LogTestcaseEnd()
			{
				this.ResCloseList();
				LogPrint("-------------------------------------------------------------------------");
			}

	        /**
	         *  \copydoc ILogger::LogSequenceStart(String,String,String,String...)
	         */
			public void LogSequenceStart( String fps_KeyWordName, String fpsWindowFN,
					String fps_SequenceName, String... fpsParameter )
			{
			    int i = fpsParameter.length;  
			    int n = i + 3;
			    
			    String[] newArray = new String[n];
			    
			    newArray[0] =  fpsWindowFN;
			    newArray[1] =  fps_SequenceName;
			    
			    for(int cnt=2; cnt<i; cnt++)
			    {  
			        newArray[cnt] = fpsParameter[cnt-2];
			    }
				
				LogKeyWordStart( fps_KeyWordName, newArray );
			}

	        /**
	         *  \copydoc ILogger::LogSequenceEnd()
	         */
			public void LogSequenceEnd()
			{
	            this.ResCloseList();
			}

			
	        /**
	         *  \copydoc ILogger::LogFunctionStartDebug(String,String...)
	         */
			public void LogFunctionStartDebug( String fps_FunctionName, String... fpsParameter )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionStart(fps_FunctionName, fpsParameter);
				}
			}

			
	        /**
	         *  \copydoc ILogger::LogFunctionEndDebug()
	         */
			public void LogFunctionEndDebug()
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd();
				}
			}


	        /**
	         *  \copydoc ILogger::LogFunctionEndDebug(Boolean)
	         */
			public void LogFunctionEndDebug( Boolean fpb_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd();
				}
			}

	        /**
	         *  \copydoc ILogger::LogFunctionEndDebug(String)
	         */
			public void LogFunctionEndDebug( String fps_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd( fps_Return );
				}
			}

	        /**
	         *  \copydoc ILogger::LogFunctionEndDebug(List<String>)
	         */
			public void LogFunctionEndDebug( List<String> fpLs_Return )
			{
				if (this.cvbDebugMode)
				{
					LogFunctionEnd( fpLs_Return );
				}
			}


			/**
	         *  \copydoc ILogger::LogPrintDebug(String)
	         */
			public void LogPrintDebug( String fps_Message )
			{
				if (this.cvbDebugMode)
				{
					LogPrint( fps_Message );
				}
			}


			/**
	         *  \copydoc ILogger::ResOpenListDebug(String)
	         */
			public void ResOpenListDebug( String fps_Name )
			{
				if (this.cvbDebugMode)
				{
					ResOpenList( fps_Name );
				}
			}

			

	        /**
	         *  \copydoc ILogger::ResCloseListDebug()
	         */
			public void ResCloseListDebug()
			{
				if (this.cvbDebugMode)
				{
					ResCloseList( );
				}
			}
			
	        /**
	         *  \copydoc ILogger::setDebugMode(Boolean)
	         */
			public void setDebugMode( Boolean cvbDebugMode )
			{
				this.cvbDebugMode = cvbDebugMode;
				
			}


}
