package com.als.Beans.Blogs.controller;

import com.als.Beans.Blogs.entity.Image;
import com.als.Beans.Blogs.form.ImageForm;
import com.als.Beans.Blogs.service.ImageService;
import com.als.Beans.Blogs.utils.ResultUtil;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

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
    @PostMapping("/upload")
    public ResultUtil addImage(@RequestParam("image") MultipartFile file){
        try {
            // 将 MultipartFile 转换为 byte[]
            byte[] imageBytes = file.getBytes();

            // 创建 ImageForm 对象并设置属性
            ImageForm imageForm = new ImageForm();
            imageForm.setName(file.getOriginalFilename());
            imageForm.setImage(imageBytes);

            // 调用服务层方法添加图片
            imageService.addImage(imageForm);

            return ResultUtil.success();
        }catch (IOException e){
            e.printStackTrace();
            return ResultUtil.fail();
        }
    }

    @ApiOperation("图片查询")
    @GetMapping("/queryImage")
    public ResultUtil queryImage(){
        List<Image> list = imageService.queryImage();
        return ResultUtil.success(list);
    }
}
