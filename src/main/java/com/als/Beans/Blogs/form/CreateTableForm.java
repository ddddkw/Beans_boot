package com.als.Beans.Blogs.form;

import lombok.Data;

/**
 * @author dkw
 */
@Data
public class CreateTableForm {
    private long uuid;
    private String tableName;
    private String columnDefinitions;
}
