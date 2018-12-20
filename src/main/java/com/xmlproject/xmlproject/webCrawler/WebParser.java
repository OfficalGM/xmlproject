package com.xmlproject.xmlproject.webCrawler;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.xmlproject.xmlproject.pojo.Info;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;


public class WebParser {

    private final String url = "https://cloud.culture.tw/frontsite/trans/SearchShowAction.do?method=doFindTypeJ&category=13";

    public String Connection() {
        Connection con = null;
        try {
            con = Jsoup.connect(url).ignoreContentType(true).validateTLSCertificates(false);
            Document document = con.get();
            String json = document.body().text();
            return json;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList parser(String json) {
        if (json.equalsIgnoreCase(null)) {
            throw new NullPointerException("value is null");
        }
        Gson gson = new Gson();
        ArrayList<Info> Info = gson.fromJson(json, new TypeToken<ArrayList<Info>>() {
        }.getType());

        return Info;
    }


}
