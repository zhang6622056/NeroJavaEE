package com.boot.frame.biz.entity;

import java.util.HashMap;

/**
 * @author: Mr Liu
 * @date: Created in 2018/4/25 14:53
 * @Description:
 */
public class User {
    private String name;

    private int age;

    private int sex;

    private String hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();
        int[] numbers = {3,5,7,9,11,13,17,19,2,3,5,33,12,5};
        for(int i:numbers){
            Integer count = hashMap.get(i);
            if(count == null) hashMap.put(i,1);
            else hashMap.put(i,++count);
        }
    }
}