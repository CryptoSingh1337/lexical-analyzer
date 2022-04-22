package com.saransh.lexicalanalyzer.utils;

import com.saransh.lexicalanalyzer.exception.TokenizationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * author: CryptoSingh1337
 */
@Component
public class LexicalAnalyzer {

    public List<Lexeme> tokenize(String program) {
        List<Lexeme> lexemes = new ArrayList<>();
        Lexer lexer = new Lexer(program);
        while (!lexer.isExhausted()) {
            if (lexer.currentToken() == Token.TK_SINGLE_LINE_COMMENT ||
                    lexer.currentToken() == Token.TK_MULTI_LINE_COMMENT) {
                lexer.moveAhead();
                continue;
            }
            lexemes.add(Lexeme.builder()
                    .value(lexer.currentLexeme())
                    .name(lexer.currentToken().name())
                    .build());
            lexer.moveAhead();
        }
        if (lexer.isSuccessful()) {
            System.out.println("Ok! :D");
        } else {
            throw new TokenizationException(lexer.errorMessage());
        }
        return lexemes;
    }
}
