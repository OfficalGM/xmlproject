package com.xmlproject.xmlproject.Service;


import com.xmlproject.xmlproject.webCrawler.WebParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class WebParserService {

    public ArrayList getParser() {
        WebParser webParser = new WebParser();
        String json = webParser.Connection();
        return webParser.parser(json);
    }
}
