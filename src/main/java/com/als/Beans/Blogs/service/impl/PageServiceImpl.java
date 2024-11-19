package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.entity.Blog;
import com.als.Beans.Blogs.form.PageForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.als.Beans.Blogs.mapper.PageMapper;
import com.als.Beans.Blogs.service.PageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.xiaoymin.knife4j.core.util.StrUtil;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author dkw
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper,Blog> implements PageService {

    @Resource
    private PageMapper pageMapper;

    @Override
    public void addPage(PageForm form){
        Blog blog = new Blog();
        LocalDateTime now = LocalDateTime.now();
        if (StrUtil.isNotBlank(form.getId())){
            blog.setId(form.getId());
        }
        blog.setTitle(form.getTitle());
        blog.setSummary(form.getSummary());
        blog.setContent(form.getContent());
        blog.setCreateTime(now);
        blog.setAuthor(form.getAuthor());
        blog.setTagTypes(form.getTagTypes());
        saveOrUpdate(blog);
    }

    @Override
    public void updatePage(PageForm form){
        Blog blog = new Blog();
        blog.setId(form.getId());
        blog.setTitle(form.getTitle());
        blog.setSummary(form.getSummary());
        blog.setContent(form.getContent());
        saveOrUpdate(blog);
    }

    @Override
    public IPage<Blog>  queryPage(QueryForm form) {
        try {
            LambdaQueryWrapper<Blog> wrapper = new LambdaQueryWrapper();
            IPage<Blog> page=new Page<>(form.getPageIndex(), form.getPageSize());
            if(!form.getTitle().isEmpty()){
                wrapper.like(Blog::getTitle, form.getTitle());
            }
            IPage<Blog> iPage = pageMapper.selectPage(page, wrapper);
            return iPage;
        } catch (DataAccessException ex) {
            // 处理数据访问异常，如果需要回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw ex;
        } catch (Exception ex) {
            // 处理其他异常
            throw ex;
        }
    }
    @Override
    public void deletePage(PageForm form){
        Blog blog = new Blog();
        LocalDateTime now = LocalDateTime.now();
        if (StrUtil.isNotBlank(form.getId())){
            blog.setId(form.getId());
        }
        blog.setTitle(form.getTitle());
        blog.setSummary(form.getSummary());
        blog.setContent(form.getContent());
        blog.setCreateTime(now);
        blog.setAuthor(form.getAuthor());
        blog.setTagTypes(form.getTagTypes());
        saveOrUpdate(blog);
    }
    @Override
    public void queryDetail(PageForm form){
        Blog blog = new Blog();
        LocalDateTime now = LocalDateTime.now();
        if (StrUtil.isNotBlank(form.getId())){
            blog.setId(form.getId());
        }
        blog.setTitle(form.getTitle());
        blog.setSummary(form.getSummary());
        blog.setContent(form.getContent());
        blog.setCreateTime(now);
        blog.setAuthor(form.getAuthor());
        blog.setTagTypes(form.getTagTypes());
        saveOrUpdate(blog);
    }

}
