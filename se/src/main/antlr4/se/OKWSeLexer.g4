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
KLAMMERAUF : '#{' -> mode(KLAMMER_MODE) ;

TEXT     :  ~'#'+ ;

WS	   : [\r]+ -> skip ;

mode KLAMMER_MODE;

KLAMMERZU        : '}'  -> mode(DEFAULT_MODE) ;

PLUS             : '+';


// Tastatureingabe kürzel
ALT          : 'ALT' | 'LEFT_ALT';
CTRL         : 'CONTROL' | 'CTRL' | 'LEFT_CONTROL';
SHIFT        : 'SHIFT' | 'LEFT_SHIFT';
COMMAND      : 'COMMAND';
             
KEYVALUE     : 'ADD'
             | 'ARROW_DOWN'
             | 'ARROW_LEFT'
             | 'ARROW_RIGHT'
             | 'ARROW_UP'
             | 'BACK_SPACE'
             | 'CANCEL'
             | 'CLEAR'
             | 'DECIMAL'
             | 'DELETE'
             | 'DIVIDE'
             | 'LEFT' | 'RIGHT' | 'UP' | 'DOWN'
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
             | 'SEMICOLON'
             | 'SEPARATOR'
             | 'SPACE'
             | 'SUBTRACT'
             | 'TAB';

VALUE        : [a-zA-Z0-9_.]+ ;
