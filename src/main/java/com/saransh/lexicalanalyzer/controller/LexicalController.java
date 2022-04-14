package com.saransh.lexicalanalyzer.controller;

import com.saransh.lexicalanalyzer.model.Program;
import com.saransh.lexicalanalyzer.service.LexicalAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * author: CryptoSingh1337
 */
@RequiredArgsConstructor
@Controller
@RequestMapping("/")
public class LexicalController {

    private final LexicalAnalyzerService service;

    @GetMapping({"", "/", "/index.html"})
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView("lexical-analyzer");
        modelAndView.addObject("program", Program.builder()
                .build());
        return modelAndView;
    }

    @PostMapping
    public ModelAndView tokensPage(@Validated @ModelAttribute("program") Program program,
                             BindingResult bindingResult) {
        ModelAndView modelAndView;
        if (bindingResult.hasErrors()) {
            modelAndView = new ModelAndView("lexical-analyzer");
            return modelAndView;
        }
        modelAndView = new ModelAndView("tokens");
        modelAndView.addObject("tokens", service.tokenize(program.getText()));
        return modelAndView;
    }
}
