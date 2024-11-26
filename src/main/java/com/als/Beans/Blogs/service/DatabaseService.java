package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.utils.ResultUtil;

import java.util.List;
import java.util.Map;

/**
 * @author dkw
 */
public interface DatabaseService {

    void createTable(String tableName, String columnDefinitions);

    List getAllTables();

    List queryTableData(String tableName);

    List<Map<String, Object>> getColumns(String tableName);
}
