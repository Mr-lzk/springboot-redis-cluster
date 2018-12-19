package com.gzly.query.redis.queryredis.test;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * @author lzk
 * @date 2018/9/18
 */
public class Book {
    private String myList;
    private String name;
    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMyList() {
        return myList;
    }

    public void setMyList(String myList) {
        this.myList = myList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book{" +
                "myList='" + myList + '\'' +
                ", name='" + name + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    public static void main(String[] args) {
        //{myList:[1,2], name:xx}
        String s = "{\n" +
                "\t\"myList\": [],\n" +
                "\t\"name\": \"xx\"\n" +
                "}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        Book b = jsonObject.toJavaObject(Book.class);
        System.out.println(b.getYear());
    }


}
