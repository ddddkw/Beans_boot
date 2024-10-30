package com.als.Beans.Blogs.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dkw
 */
@Data
public class TagForm implements Serializable {

    private static final long serialVersionUID = -4662566401428610844L;

    @ApiModelProperty("标签")
    private String tag;
}
