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
    using System.IO;
    using System.Xml.Serialization;

    using OKW.Log;

    /// \~german
    /// \brief
    /// OKW_Memorize ist die Speicher-Klasse hinter den Merke*-Schlüsselwörter.
    /// 
    /// Die Daten werden vie Serialisierung in eine XML Datei geschrieben.
    /// Zur Serialisierung wird die Klasse System.Xml.XmlSerializer verwendet.
    /// 
    /// Pfad und Name der XML-Datei. Dies wird in der XML/OKW_Ini.xml vorgegeben:
    /// <code>XPATH: OKW_Ini/OKW_Enviroment/OKW_Memorize_xml</code>
    /// 
    /// Diese Klasse ist nach denm Singelton-Muster aufgebaut.
    /// 
    /// Die Instanz der Klasse wird wie folgt abgerufen:
    /// 
    /// ~~~~~~~~~~~~~{.py}
    /// OKW.OKW_Memorrize.Instanz
    /// ~~~~~~~~~~~~~
    /// 
    /// \~english
    /// \~
    /// \author Zoltán Hrabovszki
    /// \date 2013.12.06
    public class OKW_Memorize
    {
        #region Fields

        /// \~german
        /// \brief
        /// Variable hält Pfad und Dateinamen der OKW_Memorize.xml.
        /// 
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        public string OKW_Memorize_xml = string.Empty;

        /// \~german
        /// \brief
        /// Dictionary speichert die Schlüssel-Wert Paare.
        /// 
        /// \note Dieses Feld _muss_ wegen der Serialisierung _public_ sein.
        ///
        /// \~english
        /// \brief
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        public SerializableDictionary<string, string> _Value = new SerializableDictionary<string, string>();

        /// \~german
        /// \brief
        /// Singelton spezifisch: Dieses Feld speichert die einzige Instanz dieser Klasse.
        /// 
        /// \~english
        /// \brief
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        private static OKW_Memorize _Instance;

        /// \~german
        /// \brief
        /// Eine lokale Instanz des OKW.Log.LogMssenger.
        /// 
        /// \~english
        /// \brief
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2014.12.28

        private LogMessenger LM = null;
        
        /// \~german
        /// \brief
        /// Referenz auf die einzige Instanz des Klasse OKW.Logger.
        /// 
        /// \~english
        /// \brief
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28

        private Logger Log = Logger.Instance;

        #endregion Fields

        #region Constructors

        /// \~german
        /// \brief
        /// Privater Konstruktor dieser Klasse.
        /// 
        /// \note Der Konstruktor _muss private_ sein, weil die Klasse ein Singelton ist.
        /// Verwende die Methode OKW_Memorize.Instace() um eine Instanz dieser Klasse zu erhalten.
        ///
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2014.14.27
        private OKW_Memorize()
        {
            this.LM = new LogMessenger(this.GetType().Name);
        }

        #endregion Constructors

        #region Properties

        /// \~german
        /// \brief
        /// Diese Methode gibt die einzige Instanz dieser Klasse zurück.
        /// 
        /// Nachdem Singelton-Muster wird die einzige Instanz der Klasse mit einer Methode abgerufen.
        /// 
        /// Diese Methode erzeug eine Instanz dieser Klasse und initialisiert diesen, sofern nicht bereits eine Instanz 
        /// der Klasse exsistiert.
        /// Wenn eine Instenz bereits vorhanden ist, dann wird nur die Referenz auf die Instanz zurückgeliefert
        /// 
        /// Beipsile für die Verwendung sind unter der Beschreibung dieser Klasse, OKW.OKW_Memorize, zu finden.
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2014.14.27
        public static OKW_Memorize Instance
        {
            get
            {
                if (_Instance == null)
                {
                    _Instance = new OKW_Memorize();
                    _Instance.Init();
                }

                return _Instance;
            }
        }

        #endregion Properties

        #region Methods

        /// \~german
        /// \brief
        /// Methode setzt diese Klasse zurück.
        /// 
        /// Nach Aufruf dieser Methode befinden sich die Klasse im Initialzustand.
        /// Dazu wird die Instance-Variable auf__null__ gesetzt.
        /// Wird in erster Linie für die Unittest benötigt.
        /// 
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.11.25
        public static void Reset()
        {
            _Instance = null;
        }
        
        /// \~german
        /// \brief
        /// Prüft ob es eine Eintragzum Schlüssel _fpsKey_ vorhanden ist.
        /// 
        /// Nach Aufruf dieser Methode befinden sich die Klasse im Initialzustand.
        /// Dazu wird die Instance-Variable auf__null__ gesetzt.
        /// Wird in erster Linie für die Unittest benötigt.
        /// 
        /// \param fpsKey Schlüssel, der geprüft werden soll.
        /// \returntrue, falls der gegeben schlüssel existiert, sonst false\return
        /// \~
        /// \author Zoltan Hrabovszki
        /// \date 2013.11.25
        public bool Exists(string fpsKey)
        {
            bool lvbReturn = false;

            this.Log.LogFunctionStartDebug(_Instance.GetType().FullName + "Exists", "string fpsKey", fpsKey);

            if (this._Value.ContainsKey(fpsKey))
            {
                lvbReturn = true;
            }
            
            this.Log.LogFunctionEndDebug(lvbReturn);
            
            return lvbReturn;
        }

        /// \~german
        /// \brief
        /// Holt den Aktuellen Wert eines Schlüssels.
        /// 
        /// Kernfunktion dieser Klasse. Holt zum gegeben Schlüssel _fpsKey_ den aktuellwert aus OKW_Memmorize._Value.
        /// 
        /// \exception Es wird die Ausnahme OKWMemorizeKeyNotExistsException ausgelöst, wenn ein Schlüssel abgefragt wird,
        /// der vorher nicht eigespeichert wurde.
        /// 
        /// \param fpsKey
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2014.14.27
        public string Get(string fpsKey)
        {
            string lvsReturn = string.Empty;
            bool bOK = false;

            this.Log.LogFunctionStartDebug(_Instance.GetType().FullName + "Get", "String fpsKey", fpsKey);

            try
            {
                if (this._Value.ContainsKey(fpsKey))
                {
                    lvsReturn = this._Value[fpsKey];
                }
                else
                {
                    string ErrorText = this.LM.GetMessage("Get", "OKWMemorizeKeyNotExistsException", fpsKey);
                    throw new OKWMemorizeKeyNotExistsException(ErrorText);
                }
                
                bOK = true;
            }
            finally
            {
                if (bOK)
                {
                    this.Log.LogFunctionEndDebug();
                }
                else
                {
                    this.Log.LogFunctionEndDebug(lvsReturn);
                }
            }
            
            return lvsReturn;
        }

        /// \~german
        /// \brief
        /// Initialsiert die Klasse OKW.OKW_Memorize
        /// 
        /// Die Initialisierung der Klasse OKW.OKW_Ini läuft wie folgt ab:
        /// 
        /// @startuml{OKW_Memorize_de.png}
        /// start
        /// 
        /// :Lösche alle Werte im Speicher (**_Value**);
        /// :Hole Pfad und Dateiname\naus der **OKW_Ini.xml**;
        /// 
        /// if (Ist Pfad und Dateiname\n              für\n **OWK_Memorize.xml**\n          gegeben?) then (ja)
        /// 
        ///   if (Ist die gegebene Datei\n        vorhanden?) then (ja)
        ///     :this.Read()>
        ///   else (nein)
        ///     :Gebe eine Warnung aus ;
        ///   endif
        /// 
        /// else(nein)
        ///  :Gebe eine Warnung: **'OKW_Memorize'** ist nicht gesetzt!;
        /// endif
        /// 
        /// stop
        /// @enduml
        /// 
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        public void Init()
        {
            this.Log.LogFunctionStartDebug(this.GetType().FullName + ".Init");

            // Klassen Variablen erst löschen...
            _Instance.OKW_Memorize_xml = string.Empty;
            _Instance._Value.Clear();

            // ... und dann alles Initialisieren!
            // 1. Setze Pfad und
            this.OKW_Memorize_xml = OKW_Ini.Instance.OKW_Enviroment.File_OKW_Memorize_xml;

            if (!string.IsNullOrEmpty(this.OKW_Memorize_xml))
            {
                this.Log.LogPrintDebug("OKW Memorize Datei = >>" + this.OKW_Memorize_xml + "<<");
                if (System.IO.File.Exists(this.OKW_Memorize_xml))
                {
                    // Lesen der Daten...
                    this.Read();
                }
                else
                {
                    // Deafault Werte Lesen.
                    this.Log.LogWarning("Datei: >>" + this.OKW_Memorize_xml + "<< nicht gefunden.");
                }
            }
            else
            {
                this.Log.LogWarning("Enviroment variable 'OKWIni' not set!");
            }

            this.Log.LogFunctionEndDebug();
            return;
        }

        /// \~german
        /// \brief
        /// Liest die Werte der Klasse OKW_Memorize aus einer Datei,
        /// gegeben in OKW.OKW_Ini.Xml_Ini_xml, ein.
        /// Es wird eine XML Datei gelesen. Hierzu wird die Klasse OKW_Memorize mit System.Xml.XmlSerializer deserialisiert.
        /// 
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        public void Read()
        {
            this.Log.LogFunctionStartDebug(_Instance.GetType().FullName + "Read()");

            try
            {
                XmlSerializer serializer = new XmlSerializer(typeof(OKW_Memorize));
                StreamReader fs = new StreamReader(this.OKW_Memorize_xml);
                _Instance = (OKW_Memorize)serializer.Deserialize(fs);
                fs.Close();
            }
            finally
            {
                this.Log.LogFunctionEndDebug();
            }

            return;
        }

        /// \~german
        /// \brief
        /// Schreibt die Felder (fields) der Klasse OKW_Memorize in eine Datei.
        /// 
        /// Es wird eine XML Datei geschrieben. Hierzu wird die Klasse OKW_Ini mit der
        /// Klasse System.Xml.XmlSerializer serialisiert.
        /// 
        /// Pfad und Name der XML-Datei. Dies wird in der XML/OKW_Ini.xml vorgegeben:
        /// XPATH: OKW_Ini/OKW_Enviroment/OKW_Memorize_xml
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2013.11.28
        public void Save()
        {
            this.Log.LogFunctionStartDebug(_Instance.GetType().FullName + "Save()");

            try
            {
                XmlSerializer serializer = new XmlSerializer(typeof(OKW_Memorize));
                StreamWriter fs = new StreamWriter(this.OKW_Memorize_xml, false);
                serializer.Serialize(fs, _Instance);
                fs.Close();
            }
            finally
            {
                this.Log.LogFunctionEndDebug();
            }
            
            return;
        }

        /// \~german
        /// \brief
        ///
        /// \~english
        /// \~
        /// \author Zoltán Hrabovszki
        /// \date 2014.12.27
        public void Set(string fpsKey, string fpsValue)
        {
            this.Log.LogFunctionStartDebug(_Instance.GetType().FullName + "Set", "String fpsKey", fpsKey, "String fpsValue", fpsValue);
            
            try
            {
                if (this._Value.ContainsKey(fpsKey))
                {
                    string lvsOverwriteKey = this.LM.GetMessage("Set", "OverwriteKeyWarning", fpsKey);
                    string lvsOldValue = this.LM.GetMessage("Set", "OldValue", this._Value[fpsKey]);
                    string lvsNewValue = this.LM.GetMessage("Set", "NewValue", fpsValue);

                    this.Log.LogWarning(lvsOverwriteKey);
                    this.Log.LogPrint(lvsOldValue);
                    this.Log.LogPrint(lvsNewValue);
                    _Instance._Value[fpsKey] = fpsValue;
                }
                else
                {
                    _Instance._Value.Add(fpsKey, fpsValue);
                    this.Log.LogPrint("Wert: " + fpsValue  + " wird gespeichert");
                }
                
                // persistentes Speichern aller Daten...
                _Instance.Save();
            }
            finally
            {
                this.Log.LogFunctionEndDebug();
            }

            return;
        }

        #endregion Methods
    }
}