/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
parser grammar OKWCoreParser;

@header { package okw.parser.antlr4.core; }

options { tokenVocab=OKWCoreLexer; }

/*
 * Parser Rules
 */
root : ( okw_internal_var
       | okw_env_var
//       | okw_typekey
       | text
       )+ ;

// OKW variablen
okw_internal_var   : KLAMMERAUF
                   ( FOLDER_LOGMESSAGES
                   | FOLDER_XML
                   | FILE_OKW_CONST_XML
                   | FILE_OKW_DOCU_XML
                   | FILE_OKW_IMPLEMENTATIONMATRIX_XML
                   | FILE_OKW_INI_XML
                   | FILE_OKW_KEYMAPS_XML
                   | FILE_OKW_MEMORIZE_XML ) KLAMMERZU
                   ;

//okw_typekey        : KLAMMERAUF keyvalue ( '+' keyvalue )* KLAMMERZU ;
//keyvalue           : KEYVALUE ;

okw_env_var        : KLAMMERAUF envvalue KLAMMERZU;

envvalue           : ENVVAL ;

text               : TEXT ;
