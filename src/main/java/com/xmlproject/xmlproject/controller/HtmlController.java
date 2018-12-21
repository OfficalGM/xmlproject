package com.xmlproject.xmlproject.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public String insert() {
        return "insert";
    }
}
