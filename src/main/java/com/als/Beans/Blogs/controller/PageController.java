package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.entity.Page;
import com.als.Beans.Blogs.form.PageForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.als.Beans.Blogs.service.PageService;
import com.als.Beans.Blogs.utils.ResultUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dkw
 */

@RestController
@RequestMapping("/Pages")
@Api(tags= "页面模块")
public class PageController {

    @Resource
    private PageService pageService;

    @ApiOperation("页面列表查询")
    @PostMapping("/queryList")
    public ResultUtil queryList(@RequestBody QueryForm form) {
        IPage<Page> pageList = pageService.queryPage(form);
        return ResultUtil.success(pageList);
    }

    @ApiOperation("新增页面接口")
    @PostMapping("/addPage")
    public ResultUtil addPage(@RequestBody PageForm form) {
        pageService.addPage(form);
        return ResultUtil.success();
    }

    @ApiOperation("更新页面接口")
    @PostMapping("/updatePage")
    public ResultUtil updatePage(@RequestBody PageForm form) {
        pageService.updatePage(form);
        return ResultUtil.success();
    }

    @ApiOperation("删除页面接口")
    @PostMapping("/deletePage")
    public ResultUtil deletePage(@RequestBody PageForm form) {
        pageService.deletePage(form);
        return ResultUtil.success();
    }

    @ApiOperation("查询页面详情")
    @PostMapping("/queryDetail")
    public ResultUtil queryDetail(@RequestBody PageForm form) {
        pageService.queryDetail(form);
        return ResultUtil.success();
    }
}