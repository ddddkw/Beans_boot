package com.als.Beans.Blogs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author dkw
 * 对应表中字段
 */
@Data
@TableName("pages")
public class Pages implements Serializable {

    private static final long serialVersionUID = -8397673869982311349L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField("pageName")
    private String pageName;

    @TableField("pageJson")
    private String pageJson;


}
