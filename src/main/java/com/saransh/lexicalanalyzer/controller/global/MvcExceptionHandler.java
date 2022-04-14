package com.saransh.lexicalanalyzer.controller.global;

import com.saransh.lexicalanalyzer.exception.TokenizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: CryptoSingh1337
 */
@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(TokenizationException.class)
    public ModelAndView errorPage(TokenizationException e) {
        ModelAndView modelAndView = new ModelAndView("tokens");
        modelAndView.addObject("error", e.getMessage());
        return modelAndView;
    }
}
