package com.xmlproject.xmlproject.controller;


import com.xmlproject.xmlproject.Service.CompetitionService;
import com.xmlproject.xmlproject.webCrawler.WebParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;
    @GetMapping("/index")
    public String index() {

        competitionService.storeAll();
        return "A";

    }


}
