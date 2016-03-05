/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
lexer grammar OKW_Lexer;
/*
 * Lexer Rules
 */
@header {
package okw.parser.antlr4;
}
// mode DEFAULT_MODE;
KLAMMERAUF : '${' -> mode(KLAMMER_MODE) ;

TEXT     :  ~'$'+ ;

WS	   : [\r]+ -> skip ;


mode KLAMMER_MODE;

KLAMMERZU        : '}'  -> mode(DEFAULT_MODE) ;

// OKW Interne variablen

FOLDER_LOGMESSAGES    : 'Folder_LogMessages' ;
FOLDER_XML            : 'Folder_XML' ;
FILE_OKW_CONST_XML    : 'File_OKW_Const_xml' ;
FILE_OKW_DOCU_XML     : 'File_OKW_Docu_xml' ;
FILE_OKW_IMPLEMENTATIONMATRIX_XML    : 'File_OKW_ImplementationMatrix_xml' ;
FILE_OKW_INI_XML      : 'File_OKW_Ini_xml' ;
FILE_OKW_KEYMAPS_XML  : 'File_OKW_Keymaps_xml' ;
FILE_OKW_MEMORIZE_XML : 'File_OKW_Memorize_xml' ;

// Tastatureingabe kürzel
KEYPREFIX    : 'Taste.' ;
KEYVALUE     : 'Abbruch'
             | 'Return' ;

ENVVAL       :  VALUE ;
VALUE        : [a-zA-Z0-9] [a-zA-Z0-9]* ;

