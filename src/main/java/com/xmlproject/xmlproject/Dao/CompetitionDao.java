package com.xmlproject.xmlproject.Dao;

import com.xmlproject.xmlproject.Model.Contest;
import com.xmlproject.xmlproject.vo.Competition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;

@Repository
public class CompetitionDao implements DBDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public ArrayList findByTitle(String title) {
        String sql = "SELECT * FROM `contest` WHERE `title` LIKE ?";
        return (ArrayList) jdbcTemplate.queryForList(sql, new String[]{title});
    }

    @Override
    public int store() {
        return 0;
    }

    public int store(Competition competition) {
        try {
            String sql = "INSERT INTO `contest`(`title`, `showUnit`,`sourceWebName` , `startDate`, `endDate`, `location`, `locationName`, `onSales`)" +
                    " VALUES(?,?,?,?,?,?,?,?)";
            int update = jdbcTemplate.update(sql, competition.getTitle(), competition.getShowUnit(),competition.getShowUnit(), competition.getStartDate(), competition.getEndDate(), competition.getLocation(), competition.getLocationName(), competition.getOnSales());
            return update;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public ArrayList findAll() {
        String sql = "SELECT * FROM `contest` where display=1";
        return (ArrayList) jdbcTemplate.queryForList(sql);
    }

    @Override
    public int update(Competition competition) {
        String sql = "UPDATE `contest` SET title =?,showUnit =?,sourceWebName =?,startDate =?,endDate =?,location =?,locationName =?,onSales =? ";
//        int update = jdbcTemplate.update(sql, new String[]{competition.getTitle(), competition.getShowUnit(), competition.getSourceWebName(), competition.getStartDate(), competition.getStartDate()
//                , competition.getEndDate(), competition.getLocation(), competition.getLocationName(), competition.getLocation()});
//        return update;
        return 0;
    }

    @Override
    public int delete(String title) {
        String sql = "UPDATE `contest` SET `display`=0 where title=?";
        int update = jdbcTemplate.update(sql, new String[]{title});
        return update;
    }

    public boolean storeAll(Contest contest) {
        try {
            String sql2 = "SELECT count(title) from `contest` where `title` =?";
            int count = jdbcTemplate.queryForObject(sql2, new String[]{contest.getTitle()}, Integer.class);
            if (count == 0) {
                String sql = "INSERT INTO `contest`(`title`, `showUnit`, `sourceWebName`, `startDate`, `endDate`, `location`, `locationName`, `onSales`)" +
                        " VALUES(?,?,?,?,?,?,?,?)";
                jdbcTemplate.update(sql, contest.getTitle(), contest.getShowUnit(), contest.getSourceWebName(), contest.getStartDate(), contest.getEndDate(), contest.getLocation(), contest.getLocationName(), contest.getOnSales());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

}
