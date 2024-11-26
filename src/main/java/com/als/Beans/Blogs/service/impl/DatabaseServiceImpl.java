package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.service.DatabaseService;
import com.als.Beans.Blogs.utils.ResultUtil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

/**
 * @author dkw
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {
    @PersistenceContext
    private EntityManager entityManager;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public void createTable(String tableName, String columnDefinitions) {
        String sql = String.format("CREATE TABLE %s (%s)", tableName, columnDefinitions);
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Override
    public List<String> getAllTables() {
        String sql = "SHOW TABLES";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<Map<String, Object>> getColumns(String tableName){
        String sql = "SELECT COLUMN_NAME as fieldName, DATA_TYPE as fieldType FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
        List<Map<String, Object>> columns = jdbcTemplate.queryForList(sql, new Object[]{tableName});
        return columns;
    }

    @Override
    public List queryTableData(String tableName){
        String sql = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = ?";
        List columns = jdbcTemplate.queryForList(sql, new Object[]{tableName});
        return columns;
    }
}
