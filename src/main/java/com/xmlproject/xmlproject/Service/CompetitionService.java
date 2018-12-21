package com.xmlproject.xmlproject.Service;


import com.xmlproject.xmlproject.Dao.CompetitionDao;
import com.xmlproject.xmlproject.Model.Contest;
import com.xmlproject.xmlproject.pojo.Info;
import com.xmlproject.xmlproject.pojo.ShowInfo;
import com.xmlproject.xmlproject.vo.Competition;
import com.xmlproject.xmlproject.webCrawler.WebParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CompetitionService {
    @Autowired
    private CompetitionDao competitionDao;

    public ArrayList findAll() {
        storeAll();
        return competitionDao.findAll();
    }

    public ArrayList findByTitle(String title) {
        return competitionDao.findByTitle(title);
    }

    public boolean delete(String title) {
        int update = competitionDao.delete(title);
        if (update == 1)
            return true;
        else
            return false;
    }

    public boolean store(Competition competition) {
        int update = competitionDao.store(competition);
        if (update == 1)
            return true;
        else
            return false;
    }

    private void storeAll() {
        WebParser webParser = new WebParser();
        String json = webParser.Connection();
        ArrayList<Info> list = webParser.parser(json);
        for (int i = 0; i < list.size(); i++) {
            Contest contest = new Contest();
            ArrayList<ShowInfo> showInfos = list.get(i).getShowInfo();
            contest.setTitle(list.get(i).getTitle());
            contest.setEndDate(list.get(i).getEndDate());
            contest.setShowUnit(list.get(i).getShowUnit());
            contest.setSourceWebName(list.get(i).getSourceWebName());
            contest.setStartDate(list.get(i).getStartDate());
            contest.setLocation(showInfos.get(0).getLocation());
            contest.setOnSales(showInfos.get(0).getOnSales());
            contest.setLocationName(showInfos.get(0).getLocationName());
            competitionDao.storeAll(contest);
        }


    }


}
