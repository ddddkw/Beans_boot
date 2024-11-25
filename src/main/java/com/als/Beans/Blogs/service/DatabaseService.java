package com.als.Beans.Blogs.service;

import java.util.List;

/**
 * @author dkw
 */
public interface DatabaseService {
    void createTable(String tableName, String columnDefinitions);
    List getAllTables();
}
