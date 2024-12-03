package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dkw
 * 博客的具体内容
 */
@Data
@ApiModel
public class PageForm implements Serializable {

    private static final long serialVersionUID = 3733751670823487574L;

    @ApiModelProperty("ID")
    private String id;

    @ApiModelProperty("页面名称")
    private String pageName;

    @ApiModelProperty("页面内容")
    private String pageJson;

}
