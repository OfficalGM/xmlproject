package com.xmlproject.xmlproject.Dao;

import java.util.ArrayList;

interface DBDao {
    ArrayList find();
    boolean store();
    ArrayList findAll();
    boolean update();
    boolean delete();
}
