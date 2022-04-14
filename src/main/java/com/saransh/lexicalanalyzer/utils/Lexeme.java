package com.saransh.lexicalanalyzer.utils;

import lombok.*;

/**
 * author: CryptoSingh1337
 */
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Lexeme {

    private String value;
    private String name;
}
