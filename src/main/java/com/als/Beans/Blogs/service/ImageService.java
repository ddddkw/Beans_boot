package com.als.Beans.Blogs.service;

import com.als.Beans.Blogs.form.ImageForm;

/**
 * @author dkw
 */
public interface ImageService {

    void addImage(ImageForm imageForm);

    void queryImage(ImageForm imageForm);
}
