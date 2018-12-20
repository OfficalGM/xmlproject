package com.xmlproject.xmlproject.Dao;

import com.xmlproject.xmlproject.Model.Contest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class CompetitionDao implements Dao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void add(Contest contest){
        System.out.println("A");
//        String sql;
//        jdbcTemplate.update()
    }
}
