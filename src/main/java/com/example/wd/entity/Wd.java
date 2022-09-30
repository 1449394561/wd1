package com.example.wd.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("wd")
public class Wd {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String password;
    private Integer code;

    @TableField(exist = false)
    private String name1;

    @Override
    public String toString() {
        return "Wd [sid=" + id + ", name=" + name + ", password=" + password + "]";
    }
}
