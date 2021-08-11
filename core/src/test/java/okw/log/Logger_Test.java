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

import org.junit.jupiter.api.*;

public class Logger_Test
{

	Logger_Sngltn Log = Logger_Sngltn.getInstance();

	@BeforeAll
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception
	{
	}

	/**
	 * 
	 */
	@Test
	public void tcGet2ndInstance()
	{
		Log.setDebugMode( false );

		Logger_Sngltn my2nLog = Logger_Sngltn.getInstance();

		Log.LogTestcaseStart( "tcBeginTest_EndTest" );

		my2nLog.LogKeyWordStart( "LogKeyWordStart" );
		my2nLog.LogKeyWordEnd();

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogTestcaseStart_LogTestcaseEnd()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcBeginTest_EndTest" );
		Log.LogTestcaseEnd();

		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcBeginTest_EndTest" );
		Log.LogTestcaseEnd();

	}

	@Test
	public void tcLogKeyWordStart_LogKeyWordEnd_NoParam()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );

		Log.LogKeyWordStart( "LogKeyWordStart" );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();



		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );

		Log.LogKeyWordStart( "LogKeyWordStart" );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogKeyWordStart_LogKeyWordEnd_OneParam()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();



		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_OneParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "MEM_Key" );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();

	}

	@Test
	public void tcLogKeyWordStart_LogKeyWordEnd_TwoParam()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();



		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_TwoParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "Name", "Wert"  );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();

	}


	@Test
	public void tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();



		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd_gt_TwoParam" );

		Log.LogKeyWordStart( "LogKeyWordStart", "Param 1", "Param 2" , "Param 3"  );
		Log.LogKeyWordEnd();

		Log.LogTestcaseEnd();

	}

	@Test
	public void tcLogSequenceStart_LogSequenceEnd_OhneParamater()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );

		Log.LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
		Log.LogSequenceEnd();

		Log.LogTestcaseEnd();


		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcLogKeyWordStart_LogKeyWordEnd" );

		Log.LogSequenceStart( "LogSequenceStart", "Window BN", "SEQ-Name", "SEQID" );
		Log.LogSequenceEnd();

		Log.LogTestcaseEnd(); 
	}

	@Test
	public void tcResultOpenList_ResultCloseList()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenList( "ResOpenList L1" );
		Log.ResOpenList( "ResOpenList L2" );
		Log.LogPrint( "Eintrag 1" );
		Log.LogPrint( "Eintrag 2" );
		Log.LogPrint( "Eintrag 3" );
		Log.ResCloseList();
		Log.ResCloseList();

		Log.LogTestcaseEnd();


		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenList( "ResOpenList L1" );
		Log.ResOpenList( "ResOpenList L2" );
		Log.LogPrint( "Eintrag 1" );
		Log.LogPrint( "Eintrag 2" );
		Log.LogPrint( "Eintrag 3" );
		Log.ResCloseList();
		Log.ResCloseList();

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcResultOpenList_ResultCloseList_LevelTest()
	{
		Log.setDebugMode( false );

		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenList( "ResOpenList L1" );
		Log.ResOpenList( "ResOpenList L2" );
		Log.LogPrint( "Eintrag" );
		Log.ResCloseList();
		Log.ResCloseList();
		Log.ResCloseList(); // one close more than open

		Log.LogTestcaseEnd();


		Log.setDebugMode( true );

		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenList( "ResOpenList L1" );
		Log.ResOpenList( "ResOpenList L2" );
		Log.LogPrint( "Eintrag" );
		Log.ResCloseList();
		Log.ResCloseList();
		Log.ResCloseList(); // one close more than open

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcResultOpenListDebug_ResultCloseListDebug()
	{
		Log.setDebugMode( false );
		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenListDebug( "ResOpenList" );
		Log.LogPrintDebug( "Eintrag 1" );
		Log.LogPrintDebug( "Eintrag 2" );
		Log.LogPrintDebug( "Eintrag 3" );
		Log.ResCloseListDebug();

		Log.LogTestcaseEnd();


		Log.setDebugMode( true );
		Log.LogTestcaseStart( "tcResultOpenList_ResultCloseList" );

		Log.ResOpenListDebug( "ResOpenList" );
		Log.LogPrintDebug( "Eintrag 1" );
		Log.LogPrintDebug( "Eintrag 2" );
		Log.LogPrintDebug( "Eintrag 3" );
		Log.ResCloseListDebug();

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogError()
	{
		Log.setDebugMode( false );
		Log.LogTestcaseStart( "tcLogError" );

		Log.LogVerifyError( "1", "2" );

		Log.LogTestcaseEnd();


		Log.setDebugMode( true );
		Log.LogTestcaseStart( "tcLogError" );

		Log.LogVerifyError( "1", "2" );

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogPass()
	{
		Log.LogTestcaseStart( "tcLogPass" );

		Log.LogPass( "Pass..." );

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogWarning()
	{
		Log.LogTestcaseStart( "tcLogWarning" );

		Log.LogWarning( "Warning..." );

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogException()
	{
		Log.LogTestcaseStart( "tcLogException" );

		Log.LogException( "Exception 1" );

		Log.LogTestcaseEnd();
	}


	@Test
	public void tcLogPrint()
	{
		Log.LogTestcaseStart( "tcLogPrint" );

		Log.LogPrint( "Print hore something..." );

		Log.LogTestcaseEnd();
	}

	@Test
	public void tcLogPrintDebug()
	{
		Log.LogTestcaseStart( "tcLogPrintDebug" );

		Log.LogPrintDebug( "Print hore something..." );

		Log.LogTestcaseEnd();
	}
}
