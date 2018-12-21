package com.xmlproject.xmlproject.controller;


import com.google.gson.Gson;
import com.xmlproject.xmlproject.Model.Contest;
import com.xmlproject.xmlproject.Service.CompetitionService;
import com.xmlproject.xmlproject.vo.Competition;
import com.xmlproject.xmlproject.vo.Status;
import com.xmlproject.xmlproject.webCrawler.WebParser;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;


@RestController
public class CompetitionController {
    @Autowired
    private CompetitionService competitionService;

    @GetMapping("/index")
    public ArrayList index() {
        return competitionService.findAll();
    }

    @GetMapping("/index/{title}")
    public ArrayList findByTitle(@PathVariable String title) {
        return competitionService.findByTitle(title);
    }

    @PostMapping(value = "/delete/{title}")
    public String delete(@PathVariable String title) {
        String gson = new Gson().toJson(Status.builder().success(competitionService.delete(title)).build());
        return gson;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String insert(@RequestParam(value = "title") String title,
        @RequestParam(value = "showUnit") String showUnit,
        @RequestParam(value = "startDate") String startDate,
        @RequestParam(value = "endDate") String endDate,
        @RequestParam(value = "location") String location,
        @RequestParam(value = "locationName") String locationName,
        @RequestParam(value = "onSales") String onSales) {

//
        boolean b = competitionService.store(Competition.builder().title(title).showUnit(showUnit).startDate(startDate).startDate(startDate).endDate(endDate).location(location).locationName(locationName).onSales(onSales).build());
        String gson = new Gson().toJson(Status.builder().success(b).build());
        return gson;

    }


}
