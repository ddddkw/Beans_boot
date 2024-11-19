package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dkw
 */
@Data
@ApiModel
public class ImageForm implements Serializable {

    private static final long serialVersionUID = -6434967152333868971L;

    @ApiModelProperty("文件名称")
    private String name;

    @ApiModelProperty("文件内容")
    private String image;

}
