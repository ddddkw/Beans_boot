package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.form.TagForm;
import com.als.Beans.Blogs.service.TagService;
import com.als.Beans.Blogs.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dkw
 */
@RestController
@RequestMapping("/tags")
@Api(tags= "标签模块")
public class TagsController {

    @Resource
    private TagService tagService;

    @ApiOperation("查询标签接口")
    @GetMapping("/queryTags")
    public ResultUtil queryTags() {
        List list = tagService.QueryTags();
        return ResultUtil.success(list);
    }

    @ApiOperation("新增标签接口")
    @PostMapping("/addTags")
    public ResultUtil addTags(@RequestBody TagForm tagForm) {
        tagService.addTags(tagForm);
        return ResultUtil.success();
    }
}
