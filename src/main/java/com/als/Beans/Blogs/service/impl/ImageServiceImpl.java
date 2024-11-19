package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.entity.Image;
import com.als.Beans.Blogs.form.ImageForm;
import com.als.Beans.Blogs.mapper.ImageMapper;
import com.als.Beans.Blogs.service.ImageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author dkw
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements ImageService {

    @Override
    public void addImage(ImageForm imageForm){
        Image image = new Image();
        image.setName(imageForm.getName());
        image.setImage(imageForm.getImage());
        baseMapper.insert(image);
    }

    @Override
    public void queryImage(ImageForm imageForm) {
        LambdaQueryWrapper<Image> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.eq(Image::getName,imageForm.getName());
    }
}
