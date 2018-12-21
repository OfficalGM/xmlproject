package com.xmlproject.xmlproject.Dao;

import com.xmlproject.xmlproject.Model.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;

@Repository
public class CompetitionDao implements DBDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public ArrayList find() {
        return null;
    }

    @Override
    public boolean store() {
        return false;
    }

    @Override
    public ArrayList findAll() {
        return null;
    }

    @Override
    public boolean update() {
        return false;
    }

    @Override
    public boolean delete() {
        return false;
    }

    public void storeAll(Contest contest) {
        String sql = "INSERT INTO `contest`(`title`, `showUnit`, `descriptionFilterHtml`, `sourceWebName`, `startDate`, `endDate`, `location`, `locationName`, `onSales`)" +
                " VALUES(?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,contest.getTitle(),contest.getShowUnit(),contest.getDescriptionFilterHtml(),contest.getSourceWebName(),contest.getStartDate(),contest.getEndDate(),contest.getLocation(),contest.getLocationName(),contest.getOnSales());
    }
}
