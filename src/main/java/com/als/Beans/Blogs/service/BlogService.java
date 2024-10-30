package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.form.BlogForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author dkw
 */
public interface BlogService {

    void AddBlog(BlogForm blogForm);

    IPage QueryBlog(QueryForm queryForm);

    void UpdateBlog(BlogForm blogForm);
}
