package com.als.Beans.Blogs.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.sql.Blob;

/**
 * @author dkw
 */
@Data
@TableName("images")
public class Image implements Serializable {

    private static final long serialVersionUID = -333323961730706490L;

    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private String id;

    @TableField("name")
    private String name;

    @TableField("image")
    private byte[] image;
}
