//  OKW__Test__AllMethodCalls.cs
//
//  Author:
//       zoltan <${AuthorEmail}>
//
//  Copyright(c) 2012 zoltan
//
//  This program is free software: you can redistribute it and/or modify
//  it under the terms of the GNU General Public License as published by
//  the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful,
//  but WITHOUT ANY WARRANTY; without even the implied warranty of
//  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//  GNU General Public License for more details.
//
//  You should have received a copy of the GNU General Public License
//  along with this program.  If not, see <http://www.gnu.org/licenses/>.


package okw.core;

import static org.junit.Assert.*;
import okw.OKW_TestClipboard;
import okw.exceptions.OKWNotAllowedValueException;
import okw.log.Logger_Sngltn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.omg.CORBA.SystemException;

public class EN_OKWNotAllowedValueException_Keywords_IGNORE
{

	static Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
	static OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

   @Rule
   public TestName name = new TestName();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
        // Reset des Loggers: Alle Geladenen Instanzen löschen
        Logger_Sngltn.Init();
        //myLogger.AddLogger(new Log2Console());

        myLogger.setDebugMode(false);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

    /// \~german
    /// \brief
    /// Diese Methode wird immer vor jedem Test(fall) ausgeführt.
    /// 
	@Before
	public void setUp() throws Exception
	{

	}

    /// \~german
    /// \brief
    /// Diese Methode wird immer nach jedem Test(fall) ausgeführt.
    /// 
	@After
	public void tearDown() throws Exception
	{
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
	@Test(expected=OKWNotAllowedValueException.class)
    public void TC_MemorizeCaption_IGNORE_1() throws Exception
    {

		EN.BeginTest( name.getMethodName() );
		EN.SelectWindow("Rechner");
        EN.MemorizeCaption( "All_MethodsObj", "${IGNORE} ");
    }

    /** \~german
     * Prüft ob ""${IGNORE}${TCN}" die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test(expected=OKWNotAllowedValueException.class)
    public void TC_MemorizeCaption_IGNORE_2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow("Rechner");
        EN.MemorizeCaption( "All_MethodsObj", "${IGNORE}${TCN}");
    }


    /** \~german
     * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
     * 
     *  \~english
     *  \~
     *  \author Zoltan Hrabovszki
     *  \date 2017-05-12
     */
    @Test(expected=OKWNotAllowedValueException.class)
    public void TC_MemorizeExists_IGNORE_1() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow("Rechner");
        EN.MemorizeExists( "All_MethodsObj", "${IGNORE} ");
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
    @Test(expected=OKWNotAllowedValueException.class)
    public void TC_MemorizeExists_IGNORE_2() throws Exception
    {

        EN.BeginTest( name.getMethodName() );
        EN.SelectWindow("Rechner");
        EN.MemorizeExists( "All_MethodsObj", "${IGNORE}${TCN}");
    }


       /** \~german
        * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
        * 
        *  \~english
        *  \~
        *  \author Zoltan Hrabovszki
        *  \date 2017-05-12
        */
       @Test(expected=OKWNotAllowedValueException.class)
       public void TC_MemorizeHasFocus_IGNORE_1() throws Exception
       {

           EN.BeginTest( name.getMethodName() );
           EN.SelectWindow("Rechner");
           EN.MemorizeHasFocus( "All_MethodsObj", "${IGNORE} ");
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
       @Test(expected=OKWNotAllowedValueException.class)
       public void TC_MemorizeHasFocus_IGNORE_2() throws Exception
       {

           EN.BeginTest( name.getMethodName() );
           EN.SelectWindow("Rechner");
           EN.MemorizeHasFocus( "All_MethodsObj", "${IGNORE}${TCN}");
       }


       /** \~german
        * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
        * 
        *  \~english
        *  \~
        *  \author Zoltan Hrabovszki
        *  \date 2017-05-12
        */
       @Test(expected=OKWNotAllowedValueException.class)
       public void TC_MemorizeIsActive_IGNORE_1() throws Exception
       {

           EN.BeginTest( name.getMethodName() );
           EN.SelectWindow("Rechner");
           EN.MemorizeIsActive( "All_MethodsObj", "${IGNORE} ");
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
       @Test(expected=OKWNotAllowedValueException.class)
       public void TC_MemorizeIsActive_IGNORE_2() throws Exception
       {

           EN.BeginTest( name.getMethodName() );
           EN.SelectWindow("Rechner");
           EN.MemorizeIsActive( "All_MethodsObj", "${IGNORE}${TCN}");
       }

                 /** \~german
                  * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                  * 
                  *  \~english
                  *  \~
                  *  \author Zoltan Hrabovszki
                  *  \date 2017-05-12
                  */
                 @Test(expected=OKWNotAllowedValueException.class)
                 public void TC_MemorizeLabel_IGNORE_1() throws Exception
                 {

                     EN.BeginTest( name.getMethodName() );
                     EN.SelectWindow("Rechner");
                     EN.MemorizeLabel( "All_MethodsObj", "${IGNORE} ");
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
                 @Test(expected=OKWNotAllowedValueException.class)
                 public void TC_MemorizeLabel_IGNORE_2() throws Exception
                 {

                     EN.BeginTest( name.getMethodName() );
                     EN.SelectWindow("Rechner");
                     EN.MemorizeLabel( "All_MethodsObj", "${IGNORE}${TCN}");
                 }

                /** \~german
                 * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                 * 
                 *  \~english
                 *  \~
                 *  \author Zoltan Hrabovszki
                 *  \date 2017-05-12
                 */
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeSelectedValue_IGNORE_1() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE} ");
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
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeSelectedValue_IGNORE_2() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeSelectedValue( "All_MethodsObj", "${IGNORE}${TCN}");
                }


                /** \~german
                 * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                 * 
                 *  \~english
                 *  \~
                 *  \author Zoltan Hrabovszki
                 *  \date 2017-05-12
                 */
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeTablecellValue_IGNORE_1() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeTablecellValue( "All_MethodsObj", "", "", "${IGNORE} ");
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
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeTablecellValue_IGNORE_2() throws Exception
                {
                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeTablecellValue( "All_MethodsObj", "", "", "${IGNORE}${TCN}");
                }

                /** \~german
                 * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                 * 
                 *  \~english
                 *  \~
                 *  \author Zoltan Hrabovszki
                 *  \date 2017-05-12
                 */
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeTooltip_IGNORE_1() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeTooltip( "All_MethodsObj", "${IGNORE} ");
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
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeTooltip_IGNORE_2() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeTooltip( "All_MethodsObj", "${IGNORE}${TCN}");
                }

                
                /** \~german
                 * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                 * 
                 *  \~english
                 *  \~
                 *  \author Zoltan Hrabovszki
                 *  \date 2017-05-12
                 */
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeValue_IGNORE_1() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeValue( "All_MethodsObj", "${IGNORE} ");
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
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_MemorizeValue_IGNORE_2() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.MemorizeValue( "All_MethodsObj", "${IGNORE}${TCN}");
                }
        

                /** \~german
                 * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
                 * 
                 *  \~english
                 *  \~
                 *  \author Zoltan Hrabovszki
                 *  \date 2017-05-12
                 */
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_SelectMenu_IGNORE_1() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.SelectMenu( "All_MethodsObj", "${IGNORE} ");
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
                @Test(expected=OKWNotAllowedValueException.class)
                public void TC_SelectMenu_IGNORE_2() throws Exception
                {

                    EN.BeginTest( name.getMethodName() );
                    EN.SelectWindow("Rechner");
                    EN.SelectMenu( "All_MethodsObj", "${IGNORE}${TCN}");
                }
            

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_Select_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.Select( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_Select_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.Select( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_Sequence_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.Sequence( "All_MethodsObj", "Method", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_Sequence_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.Sequence( "All_MethodsObj", "Method", "${IGNORE}${TCN}");
            }
        

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_SetValue_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.SetValue( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_SetValue_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.SetValue( "All_MethodsObj", "${IGNORE}${TCN}");
            }


            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_TypeKeyTablecell_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.TypeKeyTablecell( "All_MethodsObj", "", "", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_TypeKeyTablecell_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.TypeKeyTablecell( "All_MethodsObj", "", "", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_TypeKey_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.TypeKey( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_TypeKey_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.TypeKey( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaption_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaption( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaption_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaption( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaptionREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaptionREGX( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaptionREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaptionREGX( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaptionWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaptionWCM( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyCaptionWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyCaptionWCM( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabel_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabel( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabel_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabel( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabelREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabelREGX( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabelREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabelREGX( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabelWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabelWCM( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyLabelWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyLabelWCM( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyExists_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyExists( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyExists_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyExists( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyHasFocus_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyHasFocus_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyHasFocus( "All_MethodsObj", "${IGNORE}${TCN}");
            }
        
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyIsActive_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyIsActive( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyIsActive_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyIsActive( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValue_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValue_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValue( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValueREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValueREGX( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValueREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValueREGX( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValueWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValueWCM( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifySelectedValueWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifySelectedValueWCM( "All_MethodsObj", "${IGNORE}${TCN}");
            }

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValue_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValue( "All_MethodsObj", "", "", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValue_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValue( "All_MethodsObj", "", "", "${IGNORE}${TCN}");
            }

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValueREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValueREGX( "All_MethodsObj", "", "", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValueREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValueREGX( "All_MethodsObj", "", "", "${IGNORE}${TCN}");
            }
            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValueWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValueWCM( "All_MethodsObj", "", "", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTablecellValueWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTablecellValueWCM( "All_MethodsObj", "", "", "${IGNORE}${TCN}");
            }

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltip_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTooltip( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltip_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTooltip( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            
            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltipREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTooltipREGX( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltipREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.MemorizeExists( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltipWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTooltipWCM( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyTooltipWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyTooltipWCM( "All_MethodsObj", "${IGNORE}${TCN}");
            }

                

            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValue_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValue( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValue_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValue( "All_MethodsObj", "${IGNORE}${TCN}");
            }
            
            
            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValueREGX_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValueREGX( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValueREGX_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValueREGX( "All_MethodsObj", "${IGNORE}${TCN}");
            }


            /** \~german
             * Prüft ob "${IGNORE} " die Ausnahme okw.exceptions.OKWNotAllowedValueException auslöst
             * 
             *  \~english
             *  \~
             *  \author Zoltan Hrabovszki
             *  \date 2017-05-12
             */
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValueWCM_IGNORE_1() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValueWCM( "All_MethodsObj", "${IGNORE} ");
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
            @Test(expected=OKWNotAllowedValueException.class)
            public void TC_VerifyValueWCM_IGNORE_2() throws Exception
            {

                EN.BeginTest( name.getMethodName() );
                EN.SelectWindow("Rechner");
                EN.VerifyValueWCM( "All_MethodsObj", "${IGNORE}${TCN}");
            }
}
	