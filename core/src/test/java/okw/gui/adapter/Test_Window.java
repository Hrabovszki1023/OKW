package okw.gui.adapter;

import java.util.ArrayList;

import okw.OKW_TestClipboard;
import okw.gui.AnyWindow;
import okw.log.Logger_Sngltn;

    public class Test_Window extends AnyWindow
    {

        /// \brief
        /// Hier eventuell virtuelle Eigenschaft einfügen
        /// 
        public String Locator;

    	Logger_Sngltn            myLogger        = Logger_Sngltn.getInstance();
    	OKW_TestClipboard        myClipBoard     = OKW_TestClipboard.getInstance();

        public Test_Window()
        {
            this.Locator = "Locator Unset";
        }

        public Test_Window(String fps_Locator)
        {
            this.Locator = fps_Locator;
        }

        @Override
        public void SelectWindow()
        {
            this.myLogger.LogFunctionStartDebug("SelectWindow");
            
            String lvs_ObjectName = getFN();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("SelectWindow()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            
            myLogger.LogFunctionEndDebug();
        }

        public void StartApp()
        {
            this.myLogger.LogFunctionStartDebug("StartApp");
            String lvs_ObjectName = getFN();

            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("StartApp()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            this.myLogger.LogFunctionEndDebug();
        }

        public void StopApp()
        {
            this.myLogger.LogFunctionStartDebug("StopApp");
            String lvs_ObjectName = getFN();
            
            myClipBoard.setObjectName(lvs_ObjectName);
            myClipBoard.setMethod("StopApp()");
            myClipBoard.getValue().clear();;
            myClipBoard.getValue().add("NO VALUE");
            this.myLogger.LogFunctionEndDebug();
        }

        public void TypeKey(ArrayList<String> fpLs_Value)
        {
            this.myLogger.LogFunctionStartDebug("TypeKey");

            try
            {
                String lvs_ObjectName = getFN();

                myClipBoard.setObjectName(lvs_ObjectName);
                myClipBoard.setMethod("TypeKey(List<String> fpLs_Value)");

                // Eingabe werte auf den TestClipboard packen
                myClipBoard.getValue().clear();;
                
                for (String lsValue : fpLs_Value)
                {
                   myClipBoard.getValue().add(lsValue);
                }
            }
            finally
            {
                this.myLogger.LogFunctionEndDebug();
            }
        }

        /** \~german
         *  Parent-Objekt FN des aktuellen GUI-Objektes.
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */    
        private String myKN = "";

        
        /** \~german
         *  Setzten des Keyname FN.
         *  
         *  @fpsParentFN KN des Objektes
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */    
        public void setKN(String fpsKN)
        {
          this.myKN =  fpsKN;
        }

        
        /** \~german
         *  Setzten des Objekt KN.
         *  
         *  @return KN des Objektes.
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */ 
        public String getKN( )
        {
          return this.myKN;
        }
        
        /** \~german
         *  FN - Funktionaler Name des aktuellen GUI-Objektes.
         *  
         *  Wert wird 
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2014.04.27
         */    
        private String myFN = "";
        
        public void setFN(String fpsFN)
        {
          this.myFN =  fpsFN;
        }

        
        /** \~german
         *  Holt den funktionalen Name dws GUI-Objektes.
         * 
         *  Hinweis: Jeder GUI-Adapter kennt seinen eigenen funktionalen Namen.
         *  Dieser wird beim instanzieren der Frame-Objecte währen des Frame-Classen-Scans in der Methode FrameObjectDictionary_Sngltn.FrameScan()
         *  mitgeteilt.
         *  Wert wird 
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2014.04.27
         */  
        public String getFN( )
        {
          return this.myFN;
        }

        
        /** \~german
         *  Parent-Objekt FN des aktuellen GUI-Objektes.
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */    
        private String myParentFN = "";

        
        /** \~german
         *  Setzten des Parent-Objekt FN.
         *  
         *  @fpsParentFN FN des Parent-Objektes
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */    
        public void setParentFN(String fpsParentFN)
        {
          this.myParentFN =  fpsParentFN;
        }

        /** \~german
         *  Setzten des Parent-Objekt FN.
         *  
         *  @return FN des Parent-Objektes.
         *  
         *  \~english
         *  \brief
         *  @todo TODO:  Übersetzung ins Englische fehlt...
         *  
         *  \~
         *  @author Zoltán Hrabovszki
         *  @date 2016.11.20
         */ 
        public String getParentFN( )
        {
          return this.myParentFN;
        }
}