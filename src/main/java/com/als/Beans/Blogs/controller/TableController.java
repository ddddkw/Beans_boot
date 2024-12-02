package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.form.CreateTableForm;
import com.als.Beans.Blogs.form.DeleteForm;
import com.als.Beans.Blogs.form.InsertForm;
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
    public ResultUtil createTable(@RequestBody CreateTableForm createTableForm) {
        try {
            databaseService.createTable(createTableForm.getTableName(), createTableForm.getColumnDefinitions());
            return ResultUtil.success();
        } catch (Exception e) {
            return ResultUtil.fail();
        }
    }

    @GetMapping("/getTables")
    public ResultUtil getTables(){
        return ResultUtil.success(databaseService.getAllTables());
    }

    @GetMapping("/getColumns")
    public ResultUtil getColumns(@RequestParam("tableName") String tableName){
        return ResultUtil.success(databaseService.getColumns(tableName));
    }

    @GetMapping("/queryTableData")
    public ResultUtil queryTableData(@RequestParam("tableName") String tableName){
        return ResultUtil.success(databaseService.queryTableData(tableName));
    }

    @PostMapping("/deleteData")
    public ResultUtil deleteData(@RequestBody DeleteForm deleteForm){
        databaseService.deleteData(deleteForm.getTableName(),deleteForm.getId());
        return ResultUtil.success();
    }


    @PostMapping("/insertData")
    public ResultUtil insertData(@RequestBody InsertForm insertForm){
        databaseService.saveData(insertForm);
        return ResultUtil.success();
    }
}
