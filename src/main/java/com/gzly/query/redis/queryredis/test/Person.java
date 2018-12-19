package com.gzly.query.redis.queryredis.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lzk
 * @date 2018/12/11
 */
public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("tom1", "add1"));
        list.add(new Person("tom2", "add2"));
        list.add(new Person("tom3", "add3"));

        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getAddress, Person::getName));
        System.out.println(map);
    }
}
