package com.als.Beans.Blogs.mapper;

import com.als.Beans.Blogs.entity.Page;
import com.als.Beans.Blogs.form.QueryForm;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface PageMapper extends BaseMapper<Page> {
    IPage<Page> selectByType(com.baomidou.mybatisplus.extension.plugins.pagination.Page page, @Param("form") QueryForm form);
}
