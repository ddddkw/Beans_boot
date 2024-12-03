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
public class QueryForm implements Serializable {

    private static final long serialVersionUID = 7228507237597179449L;

    @ApiModelProperty("当前页")
    private int pageIndex;

    @ApiModelProperty("每页大小")
    private int pageSize;
}
