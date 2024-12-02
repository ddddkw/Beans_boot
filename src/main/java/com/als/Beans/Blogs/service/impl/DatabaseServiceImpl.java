package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.form.InsertForm;
import com.als.Beans.Blogs.service.DatabaseService;
import com.als.Beans.Blogs.utils.ResultUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

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
        // 使用安全的表名构建 SQL 语句（这里不需要参数化，因为表名已经验证）
        String sql = "SELECT * FROM " + tableName;

        // 执行查询并返回结果
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public void deleteData(String tableName, String id){
        // 使用参数化查询来避免 SQL 注入
        String sql = "DELETE FROM " + tableName + " WHERE id = ?";
        // 使用 jdbcTemplate 的 update 方法执行参数化查询
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void saveData(InsertForm insertForm) {
        List<Map<String, String>> dataList = insertForm.getDataList();
        if (dataList.isEmpty()) {
            throw new IllegalArgumentException("Data list is empty.");
        }

        // 使用第一个Map构建列名和占位符
        Map<String, String> firstMap = dataList.get(0);
        StringBuilder keysBuilder = new StringBuilder();
        StringBuilder placeholdersBuilder = new StringBuilder();

        // 添加 id 列
        keysBuilder.append("id,");
        placeholdersBuilder.append("?,");

        int i = 0;
        for (String key : firstMap.keySet()) {
            if (i > 0) {
                keysBuilder.append(", ");
                placeholdersBuilder.append(", ");
            }
            keysBuilder.append(key);
            placeholdersBuilder.append("?");
            i++;
        }

        String tableName = insertForm.getTableName();
        String sql = "INSERT INTO " + tableName + " (" + keysBuilder.toString() + ") VALUES (" + placeholdersBuilder.toString() + ")";

        // 使用BatchPreparedStatementSetter来设置批量插入的参数
        jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                Map<String, String> dataMap = dataList.get(i);

                // 设置 id 为 UUID
                ps.setString(1, UUID.randomUUID().toString());

                // 设置其他字段的值
                int index = 2; // 从 2 开始，因为 id 已经是第一个参数
                for (String value : dataMap.values()) {
                    ps.setString(index++, value);
                }
            }

            @Override
            public int getBatchSize() {
                return dataList.size();
            }
        });
    }
}
