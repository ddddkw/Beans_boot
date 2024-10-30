package com.als.Beans.Blogs.service.impl;

import com.als.Beans.Blogs.entity.Tag;
import com.als.Beans.Blogs.form.TagForm;
import com.als.Beans.Blogs.mapper.TagMapper;
import com.als.Beans.Blogs.service.TagService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dkw
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements TagService {
    @Override
    public List QueryTags(){
        List list = this.list();
        return list;
    }

    @Override
    public void addTags(TagForm tagForm){
        Tag tagsInfo = new Tag();
        tagsInfo.setTag(tagForm.getTag());
        saveOrUpdate(tagsInfo);
    }
}
