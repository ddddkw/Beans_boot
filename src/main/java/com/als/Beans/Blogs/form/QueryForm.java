package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dkw
 * 查询表单
 */
@Data
@ApiModel
public class QueryForm implements Serializable {

    private static final long serialVersionUID = 3517865230444747626L;

    @ApiModelProperty("标题")
    private String title;

    @ApiModelProperty("摘要")
    private String summary;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("页码")
    private Integer pageIndex;

    @ApiModelProperty("每页大小")
    private Integer pageSize;

    @ApiModelProperty("总数")
    private Integer total;

    @ApiModelProperty("标签类型")
    private String tagType;

}
