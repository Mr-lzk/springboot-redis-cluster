package com.gzly.query.redis.queryredis.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author lzk
 * @date 2018/6/12
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 4604372926305272713L;

    @NotNull(message = "书籍名称必填！")
    private String name;

    private String year;

    public Book() {
    }

    public Book(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
