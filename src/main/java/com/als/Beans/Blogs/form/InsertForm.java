package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dkw
 */
@Data
public class InsertForm implements Serializable {

    private static final long serialVersionUID = 6198363565073578680L;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "数据列表")
    private List dataList;
}
