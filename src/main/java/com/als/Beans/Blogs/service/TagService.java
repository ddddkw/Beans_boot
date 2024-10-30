package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.form.TagForm;

import java.util.List;

/**
 * @author dkw
 */
public interface TagService {

    List QueryTags();

    void addTags(TagForm tagForm);
}
