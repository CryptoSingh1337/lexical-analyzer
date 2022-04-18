package com.saransh.lexicalanalyzer.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author: CryptoSingh1337
 */
public enum Token {
    TK_SINGLE_LINE_COMMENT("\\/\\/.*"),
    TK_UNARY_INCREMENT("\\+\\+"),
    TK_UNARY_DECREMENT("\\-\\-"),
    TK_MOD("%"),
    TK_MUL("\\*"),
    TK_DIV("\\/"),
    TK_ADD("\\+"),
    TK_MINUS("\\-"),
    TK_NOT("~"),
    TK_OR("\\|"),
    TK_AND("&"),
    TK_XOR("\\^"),
    TK_LOGICAL_NE("\\!="),
    TK_LOGICAL_OR("\\|\\|"),
    TK_LOGICAL_AND("\\&&"),
    TK_LESS("<"),
    TK_GT(">"),
    TK_GTE(">="),
    TK_EQ("=="),
    TK_LTE("<="),
    TK_ASSIGN("="),
    TK_OPEN("\\("),
    TK_CLOSE("\\)"),
    TK_OPEN_BRACKET("\\{"),
    TK_CLOSE_BRACKET("\\}"),
    TK_SEMI(";"),
    TK_COMMA(","),
    TK_KEY_RETURN("return"),
    TK_KEY_STRUCT("struct"),
    TK_KEY_IF("if"),
    TK_KEY_ELSE("else"),
    TK_KEY_ELSE_IF("else if"),
    TK_KEY_FOR("for"),
    TK_KEY_WHILE("while"),
    TK_KEY_DO("do"),
    TK_KEY_VOID("void"),
    TK_KEY_INT("int"),
    TK_KEY_FLOAT("float"),
    TK_KEY_DOUBLE("double"),
    TK_KEY_CHAR("char"),
    SPECIAL_SYMBOL("#"),
    EXTENSION("\\.h"),
    STRING("\"(.)*\""),
    CHAR("\\'(.){1}\\'"),
    REAL("[-]?\\d+\\.\\d+"),
    INTEGER("[-]?\\d+"),
    IDENTIFIER("\\w+");

    Token(String regex) {
        pattern = Pattern.compile("^" + regex);
    }

    private final Pattern pattern;

    public int endOfMatch(String s) {
        Matcher matcher = pattern.matcher(s);
        if (matcher.find())
            return matcher.end();
        return -1;
    }
}
