package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

/**
 * @author dkw
 */
@Data
@ApiModel
public class ImageForm implements Serializable {

    private static final long serialVersionUID = -6434967152333868971L;

    @ApiModelProperty(value = "文件名称", example = "example.jpg")
    private String name;

    @ApiModelProperty(value = "文件内容", notes = "Base64 编码的图片内容")
    private byte[] image;

}
