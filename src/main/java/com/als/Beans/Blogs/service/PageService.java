package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.form.PageForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * @author dkw
 */
public interface PageService {

    void addPage(PageForm pageForm);

    IPage queryPage(QueryForm queryForm);

    void updatePage(PageForm pageForm);

    void deletePage(PageForm pageForm);

    void queryDetail(PageForm pageForm);
}