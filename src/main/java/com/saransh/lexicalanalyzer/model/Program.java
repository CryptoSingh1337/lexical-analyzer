package com.saransh.lexicalanalyzer.model;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * author: CryptoSingh1337
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Program {

    @NotNull(message = "Please enter a valid program")
    @NotBlank(message = "Please enter a valid program")
    private String text;
}
