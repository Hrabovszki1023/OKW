/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
parser grammar OKWSeParser;

@header {
package okw.parser.antlr4.se;
}

options { tokenVocab=OKWSeLexer; }

/*
 * Parser Rules
 */
root : ( typekey | keyvalue | modifierkey | text )+;
//root : ( typekey | text )+;

//typekey		: KLAMMERAUF (modifierkey)? ( PLUS modifierkey )* ( PLUS keyvalue )* KLAMMERZU ;
typekey		: KLAMMERAUF (modifierkey)? ( PLUS modifierkey )* ( PLUS keyvalue )* ( PLUS value )*  KLAMMERZU;

keyvalue    : KEYVALUE        ;

modifierkey : ALT       #Alt
			| CTRL      #Ctrl
			| SHIFT     #Shift
			| COMMAND   #Command
			;
value       : VALUE;
			
text        : TEXT;
