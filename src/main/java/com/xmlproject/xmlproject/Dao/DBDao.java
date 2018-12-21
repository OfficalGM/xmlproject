package com.xmlproject.xmlproject.Dao;

import com.xmlproject.xmlproject.vo.Competition;

import java.util.ArrayList;

interface DBDao {
    ArrayList findByTitle(String title);
    int store();
    ArrayList findAll();
    int update(Competition competition);
    int delete(String title);
}
