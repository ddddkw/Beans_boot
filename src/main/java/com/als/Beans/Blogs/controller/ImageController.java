package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.form.ImageForm;
import com.als.Beans.Blogs.service.ImageService;
import com.als.Beans.Blogs.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dkw
 */
@RestController
@RequestMapping("/image")
@Api(tags="图片模块")
public class ImageController {
    @Resource
    private ImageService imageService;

    @ApiOperation("图片上传")
    @PostMapping("/addImage")
    public ResultUtil addImage(ImageForm imageForm){
        imageService.addImage(imageForm);
        return ResultUtil.success();
    }

    @ApiOperation("图片查询")
    @PostMapping("/queryImage")
    public ResultUtil queryImage(){
        return ResultUtil.success();
    }
}
