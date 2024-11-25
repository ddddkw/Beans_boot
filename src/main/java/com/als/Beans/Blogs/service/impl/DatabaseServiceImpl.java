package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author dkw
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void createTable(String tableName, String columnDefinitions) {
        String sql = String.format("CREATE TABLE %s (%s)", tableName, columnDefinitions);
        entityManager.createNativeQuery(sql).executeUpdate();
    }

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getAllTables() {
        String sql = "SHOW TABLES";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
