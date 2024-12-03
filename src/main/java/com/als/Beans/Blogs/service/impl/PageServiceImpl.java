package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.entity.Pages;
import com.als.Beans.Blogs.form.PageForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.als.Beans.Blogs.mapper.PageMapper;
import com.als.Beans.Blogs.service.PageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;

/**
 * @author dkw
 */
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, Pages> implements PageService {

    @Resource
    private PageMapper pageMapper;

    @Override
    public void addPage(PageForm form){
        Pages pages = new Pages();
        pages.setPageJson(form.getPageJson());
        pages.setPageName(form.getPageName());
        saveOrUpdate(pages);
    }

    @Override
    public void updatePage(PageForm form){
        Pages pages = new Pages();
        pages.setId(form.getId());
        pages.setPageName(form.getPageName());
        pages.setPageJson(form.getPageJson());
        saveOrUpdate(pages);
    }

    @Override
    public IPage<Pages> queryPage(QueryForm queryForm) {
        try {
            Page<Pages> page = new Page<>(queryForm.getPageIndex(), queryForm.getPageSize());
            // 构建查询条件（如果有的话）
            QueryWrapper<Pages> queryWrapper = new QueryWrapper<>();
            // 执行分页查询
            return pageMapper.selectPage(page, queryWrapper);
        } catch (DataAccessException ex) {
            // 记录异常并回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new RuntimeException("Data access error", ex);
        } catch (Exception ex) {
            // 记录其他异常
            throw new RuntimeException("Unexpected error", ex);
        }
    }
    @Override
    public void deletePage(String id){
        pageMapper.deleteById(id);
    }
    @Override
    public Pages queryDetail(String id){
        return pageMapper.selectById(id);
    }

}
