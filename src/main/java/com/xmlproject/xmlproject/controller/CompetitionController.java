package com.xmlproject.xmlproject.controller;

import com.xmlproject.xmlproject.Service.WebParserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CompetitionController {
    @Autowired
    WebParserService webParserService;
    @GetMapping("/")
    public ArrayList index() {

        return  webParserService.getParser();
    }


}
