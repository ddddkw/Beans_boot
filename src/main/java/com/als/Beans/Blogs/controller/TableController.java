package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.form.CreateTableForm;
import com.als.Beans.Blogs.service.DatabaseService;
import com.als.Beans.Blogs.utils.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author dkw
 */
@RestController
@RequestMapping("/tables")
@Api(tags="数据库表创建")
public class TableController {

    @Autowired
    private DatabaseService databaseService;

    @PostMapping("/createTable")
    public String createTable(@RequestBody CreateTableForm createTableForm) {
        try {
            databaseService.createTable(createTableForm.getTableName(), createTableForm.getColumnDefinitions());
            return String.format("Table %s created successfully!", createTableForm.getTableName());
        } catch (Exception e) {
            return String.format("Error creating table %s: %s", createTableForm.getTableName(), e.getMessage());
        }
    }

    @GetMapping("/getTables")
    public ResultUtil getTables(){
        return ResultUtil.success(databaseService.getAllTables());
    }
}
