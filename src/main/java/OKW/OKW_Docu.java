#region Header
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
#endregion Header

namespace OKW
{
    using System;
    using System.Collections.Generic;
    using System.IO;
    using System.Text;
    using System.Text.RegularExpressions;
    using System.Xml.XPath;

    using OKW.Log;

    /// \~german
    /// \brief
    /// Designpattern: Singelton
    /// Hier gilt das Highlander Prinzip: "Es kann nur einen geben".
    /// D.h. nur eine Instanz dieser Klasse, die für das Lesen der Nachrichten
    /// Zuständig ist.
    /// Diese Klasse selbst ist eine OKW-Fundametalklasse und gibt keine Nachrichten aus.
    /// TODO: Nachricht weiter-Linken auf einen Andren Tag. Ziel: Wiederkehrende Nachrichten werden nur einmal gepflegt.
    /// 
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2014.05.28
    public class OKW_Docu
    {
        #region Fields

        /// \brief
        /// Instance des Singelton
        /// 
        private static readonly OKW_Docu instance = new OKW_Docu();

        private OKWLanguage AL = OKWLanguage.Instance;
        private string File_okwdocu_xml = System.IO.Path.Combine(OKW.OKW_Ini.Instance.OKW_Enviroment.Folder_XML, "OKW_Docu.xml");
        

        /// \~german
        /// \brief
        /// Feld enthält den Pfad und den Dateinamen der XML-Datei, die als Datenquelle Dient.
        /// 
        /// \~english
        /// \brief
        /// \todo TODO: JN: Rranslation
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013_12_09 <br/>
        private XPathDocument MyXPathDocument;

        /// \~german
        /// \brief
        /// Stellt ein Cursormodell für die Navigation und Bearbeitung von XML-Daten bereit.
        /// 
        /// Siehe: http://msdn.microsoft.com/de-de/library/system.xml.xpath.xpathnavigator%28v=vs.110%29.aspx
        /// 
        /// \~english
        /// \brief
        /// Provides a cursor model for navigating and editing XML data.
        /// 
        /// See: http://msdn.microsoft.com/de-de/library/system.xml.xpath.xpathnavigator%28v=vs.110%29.aspx
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013_12_09 <br/>
        private XPathNavigator MyXPathNavigator;

        #endregion Fields

        #region Constructors

        /// \brief
        /// This constructor has no Parameter and uses the default values for the config-file and Actual/default language(=EN)
        /// 
        /// <remarks>This klass is a Singelton. -> Konstuctor is Private! Use Instance to get the Instanc of this Class.</remarks>
        private OKW_Docu()
        {
            if (!System.IO.File.Exists(this.File_okwdocu_xml))
            {
                System.Console.WriteLine("=  End Logmessenger.Logmessenger() with exception!");
                throw new FileNotFoundException("File not found! '" + this.File_okwdocu_xml + "'");
            }
            else
            {
                this.MyXPathDocument = new XPathDocument(this.File_okwdocu_xml);
                this.MyXPathNavigator = this.MyXPathDocument.CreateNavigator();
            }
        }

        #endregion Constructors

        #region Properties

        /// \brief
        /// Holt die einzige Instanz dieser Klasse.
        /// 
        /// <value>
        /// The instance.
        /// </value>
        public static OKW_Docu Instance
        {
            get
            {
                return instance;
            }
        }

        #endregion Properties

        #region Methods

        /// \brief
        /// Gets the KeyWordName for Language.
        /// 
        /// \param KeyWord Name of 
        /// \return\return
        public string GetKWForCurrentLanguage(string KeyWord)
        {
            string lvs_Return = string.Empty;

            lvs_Return = this.ReadKeyWordName(KeyWord);

            return lvs_Return;
        }

        /// \brief
        /// This method gets the Keywordname depending an the Language.
        /// 
        /// If the given KeyWordSybol isn´t definden in
        /// 
        /// \param KeyWordSymbol SymbolName of Keyword
        /// \returnreturns the Message for the given language or default language if given languae does not exist\return
        private string ReadKeyWordName(string KeyWordSymbol)
        {
            Log.Logger.Instance.LogFunctionStartDebug(this.GetType().FullName + ".ReadKeyWordName", "KeyWordSymbol", KeyWordSymbol);

            string lvs_temp = "!!" + KeyWordSymbol;

            string lvsXPath = "//okwentry[@keyword='" + KeyWordSymbol + "']//keyword/" + this.AL.Language;

            Log.Logger.Instance.LogPrintDebug(lvsXPath);

            XPathNodeIterator iter = this.MyXPathNavigator.Select(lvsXPath);

            while (iter.MoveNext())
            {
                lvs_temp = iter.Current.Value;
            }

            Log.Logger.Instance.LogFunctionEndDebug(lvs_temp);

            return lvs_temp;
        }

        #endregion Methods
    }
}
