package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.entity.Blog;
import com.als.Beans.Blogs.form.BlogForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.als.Beans.Blogs.service.BlogService;
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
@RequestMapping("/Blogs")
@Api(tags= "博客模块")
public class BlogController {

    @Resource
    private BlogService blogService;

    @ApiOperation("博客列表查询")
    @PostMapping("/QueryList")
    public ResultUtil QueryList(@RequestBody QueryForm form) {
        IPage<Blog> pageList = blogService.QueryBlog(form);
        return ResultUtil.success(pageList);
    }

    @ApiOperation("新增接口")
    @PostMapping("/addBlog")
    public ResultUtil addVlogs(@RequestBody BlogForm form) {
        blogService.AddBlog(form);
        return ResultUtil.success();
    }

    @ApiOperation("更新接口")
    @PostMapping("/updateBlog")
    public ResultUtil UpdateVlog(@RequestBody BlogForm form) {
        blogService.UpdateBlog(form);
        return ResultUtil.success();
    }
}
