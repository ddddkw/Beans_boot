package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dkw
 */
@Data
public class DeleteForm implements Serializable {

    private static final long serialVersionUID = 6683857328334421091L;

    @ApiModelProperty(value = "表名")
    private String tableName;

    @ApiModelProperty(value = "id", notes = "唯一标识")
    private String id;
}
