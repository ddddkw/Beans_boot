package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

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

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("内容")
    private String content;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("标签类型")
    private String tagTypes;

    @ApiModelProperty("用户姓名")
    private String author;

}
