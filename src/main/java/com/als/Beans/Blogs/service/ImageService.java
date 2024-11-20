package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.form.ImageForm;

import java.util.List;

/**
 * @author dkw
 */
public interface ImageService {

    void addImage(ImageForm imageForm);

    List queryImage();
}
