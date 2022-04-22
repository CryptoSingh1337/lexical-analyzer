package com.saransh.lexicalanalyzer.utils;

import org.junit.jupiter.api.Test;

class LexerTest {

    private final String program = "#include<stdio.h>\n" +
            "//program\n" +
            "void factorial(int n) { //program to calculate factorial\n" +
            "    if (n == 1) return 1;\n" +
            "    return n * factorial(n - 1);\n" +
            "}\n" +
            "\n" +
            "/* Multi line comment */" +
            "int main() {\n" +
            "    printf(\"%d\", factorial(5.35));\n" +
            "    char a = 'A';\n" +
            "    for (int i = 0; i < n; i++) {}\n" +
            "    while (j < 10) {}\n" +
            "    do {} while (i < 10);\n" +
            "    a=a^b;\n" +
            "    a = a > b ? a : b;" +
            "    return 0;\n" +
            "}";

    @Test
    public void test() {
        Lexer lexer = new Lexer(program);
        System.out.println("Lexical Analysis");
        System.out.println("-----------------");
        while (!lexer.isExhausted()) {
            System.out.printf("%-18s :  %s \n",lexer.currentLexeme() , lexer.currentToken());
            lexer.moveAhead();
        }

        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            System.out.println(lexer.errorMessage());
        }
    }

    private void preprocess(String text) {
        String[] split = text.split("\n");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            System.out.println(s);
            s = s.contains("//") ? s.substring(0, s.indexOf("//")) : s;
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}