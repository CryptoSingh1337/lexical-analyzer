package com.saransh.lexicalanalyzer.service;

import com.saransh.lexicalanalyzer.utils.Lexeme;
import com.saransh.lexicalanalyzer.utils.LexicalAnalyzer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: CryptoSingh1337
 */
@RequiredArgsConstructor
@Service
public class LexicalAnalyzerService {

    private final LexicalAnalyzer lexicalAnalyzer;

    public List<Lexeme> tokenize(String program) {
        return lexicalAnalyzer.tokenize(program);
    }
}
