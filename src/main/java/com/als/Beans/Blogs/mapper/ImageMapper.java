package com.als.Beans.Blogs.mapper;

import com.als.Beans.Blogs.entity.Image;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dkw
 */
@Mapper
public interface ImageMapper extends BaseMapper<Image> {
    List<Image> selectImages();
}
