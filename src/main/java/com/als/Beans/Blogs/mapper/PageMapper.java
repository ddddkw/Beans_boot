package com.als.Beans.Blogs.mapper;

import com.als.Beans.Blogs.entity.Blog;
import com.als.Beans.Blogs.form.QueryForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface PageMapper extends BaseMapper<Blog> {
    IPage<Blog> selectByType(Page<Blog> page, @Param("form") QueryForm form);
}
