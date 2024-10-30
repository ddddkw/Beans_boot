package com.als.Beans.Blogs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author dkw
 */
@Data
@TableName("tagsInfo")
public class Tag {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;


    @TableField("tag")
    private String tag;
}
