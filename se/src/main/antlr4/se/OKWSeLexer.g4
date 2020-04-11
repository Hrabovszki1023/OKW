/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
lexer grammar OKWSeLexer;

/*
 * Lexer Rules
 */

@header {
package okw.parser.antlr4.se;
}

// mode DEFAULT_MODE;
KLAMMERAUF : '${' -> mode(KLAMMER_MODE) ;

TEXT     :  ~'$'+ ;

WS	   : [\r]+ -> skip ;

mode KLAMMER_MODE;

KLAMMERZU        : '}'  -> mode(DEFAULT_MODE) ;

PLUS             : '+';

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
KEYVALUE     : 'ADD'
                   | 'ALT'
                   | 'ARROW_DOWN'
                   | 'ARROW_LEFT'
                   | 'ARROW_RIGHT'
                   | 'ARROW_UP'
                   | 'BACK_SPACE'
                   | 'CANCEL'
                   | 'CLEAR'
                   | 'COMMAND'
                   | 'CONTROL' | 'CTRL'
                   | 'DECIMAL'
                   | 'DEL'
                   | 'DIVIDE'
                   | 'DOWN'
                   | 'END'
                   | 'ENTER'
                   | 'EQUALS'
                   | 'ESCAPE'
                   | 'F1'
                   | 'F10'
                   | 'F11'
                   | 'F12'
                   | 'F2'
                   | 'F3'
                   | 'F4'
                   | 'F5'
                   | 'F6'
                   | 'F7'
                   | 'F8'
                   | 'F9'
                   | 'HELP'
                   | 'HOME'
                   | 'INSERT'
                   | 'LEFT'
                   | 'LEFT_ALT'
                   | 'LEFT_CONTROL'
                   | 'LEFT_SHIFT'
                   | 'META'
                   | 'MULTIPLY'
                   | 'NULL'
                   | 'NUMPAD0'
                   | 'NUMPAD1'
                   | 'NUMPAD2'
                   | 'NUMPAD3'
                   | 'NUMPAD4'
                   | 'NUMPAD5'
                   | 'NUMPAD6'
                   | 'NUMPAD7'
                   | 'NUMPAD8'
                   | 'NUMPAD9'
                   | 'PAGE_DOWN'
                   | 'PAGE_UP'
                   | 'PAUSE'
                   | 'RETURN'
                   | 'RIGHT'
                   | 'SEMICOLON'
                   | 'SEPARATOR'
                   | 'SHIFT'
                   | 'SPACE'
                   | 'SUBTRACT'
                   | 'TAB'
                   | 'UP' ;

ENVVAL       :  VALUE ;
VALUE        : [a-zA-Z0-9_.]+ ;
