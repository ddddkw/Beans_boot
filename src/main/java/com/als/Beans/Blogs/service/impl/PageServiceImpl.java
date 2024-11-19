package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.entity.Page;
import com.als.Beans.Blogs.form.PageForm;
import com.als.Beans.Blogs.form.QueryForm;
import com.als.Beans.Blogs.mapper.PageMapper;
import com.als.Beans.Blogs.service.PageService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
public class PageServiceImpl extends ServiceImpl<PageMapper, Page> implements PageService {

    @Resource
    private PageMapper pageMapper;

    @Override
    public void addPage(PageForm form){
        Page page = new Page();
        saveOrUpdate(page);
    }

    @Override
    public void updatePage(PageForm form){
        Page page = new Page();
        saveOrUpdate(page);
    }

    @Override
    public IPage<Page>  queryPage(QueryForm form) {
        try {
            LambdaQueryWrapper<Page> wrapper = new LambdaQueryWrapper();
            IPage<Page> page=new com.baomidou.mybatisplus.extension.plugins.pagination.Page(form.getPageIndex(), form.getPageSize());
            IPage<Page> iPage = pageMapper.selectPage(page, wrapper);
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
        Page page = new Page();
        saveOrUpdate(page);
    }
    @Override
    public void queryDetail(PageForm form){
        Page page = new Page();
        LocalDateTime now = LocalDateTime.now();
        saveOrUpdate(page);
    }

}
