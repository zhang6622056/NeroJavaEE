package com.boot.frame.biz.controller;

import com.boot.frame.application.redis.RedisOperaTemplate;
import com.boot.frame.biz.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Mr Liu
 * @date: Created in 2018/4/25 14:55
 * @Description:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisOperaTemplate redisOperaTemplate;

    @RequestMapping("/setString")
    public String setString(String value){
        String key = "setString";
        redisOperaTemplate.set(key,value);
        return "success";
    }

    @RequestMapping("setBean")
    public String setBean(){
        String key = "setBean";
        User user = new User();
        user.setName("LeBron James");
        user.setAge(18);
        redisOperaTemplate.set(key,user);
        return "success";
    }

    @RequestMapping("/getString")
    public String get(){
        String key = "setString";
//        redisOperaTemplate.get(key);
        Object bean = redisOperaTemplate.getBean(key, String.class);
        return (String)bean;
    }

    @RequestMapping("/getBean")
    public User getBean(){
        String key = "setBean";
        Object bean = redisOperaTemplate.getBean(key, User.class);
        return (User)bean;
    }

    @RequestMapping("/multiSetString")
    public String multiSetString(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("mapStrKey1","mapStrValue1");
        map.put("mapStrKey2","mapStrValue2");
        map.put("mapStrKey3","mapStrValue3");
        redisOperaTemplate.multiSet(map);
        return "success";
    }

    @RequestMapping("/multiSetBean")
    public String multiSetBean(){

        Map<String,User> map = new HashMap<String, User>();

        User user1 = new User();
        user1.setName("tom");
        user1.setAge(18);
        User user2 = new User();
        user2.setName("jack");
        user2.setAge(19);
        User user3 = new User();
        user3.setName("lucy");
        user3.setAge(20);
        map.put("mapBeanKey1",user1);
        map.put("mapBeanKey2",user2);
        map.put("mapBeanKey3",user3);

        redisOperaTemplate.multiSet(map);
        return "success";
    }

    @RequestMapping("/multiGetString")
    public List<String> multiGetString(){
        List<String> list = new ArrayList<String>();
        list.add("mapStrKey1");
        list.add("mapStrKey2");
        list.add("mapStrKey3");
        List<String> bean = redisOperaTemplate.multiGet(list);
        return bean;
    }

    @RequestMapping("/multiGetBean")
    public List<User> multiGetBean(){
        List<String> list = new ArrayList<String>();
        list.add("mapBeanKey1");
        list.add("mapBeanKey2");
        list.add("mapBeanKey3");
        List<User> bean = redisOperaTemplate.multiGetBean(list,User.class);
        return bean;
    }


    @RequestMapping("/setWithExpired")
    public String setWithExpired(){
        String key = "setWithExpired";
        User user = new User();
        user.setName("wangjianfeng");
        user.setAge(18);
        redisOperaTemplate.setWithExpired(key,user,120L);
        return "success";
    }

    @RequestMapping("/getWithExpired")
    public User getWithExpired(){
        String key = "setWithExpired";
        Object bean = redisOperaTemplate.getBean(key, User.class);
        return (User) bean;
    }

    @RequestMapping("/getRange")
    public String getRange(){
        String key = "setString";
        String s = redisOperaTemplate.get(key, 1L, 5L);
        return s;
    }

    @RequestMapping("/getSize")
    public Long getSize(){
        String key = "setString";
        Long s = redisOperaTemplate.size(key);
        return s;
    }

    @RequestMapping("/setAppend")
    public Integer setAppend(String value){
        String key = "setString";
        Integer s = redisOperaTemplate.append(key,value);
        return s;
    }

    @RequestMapping("/getAppend")
    public String getAppend(String key){
        String keys = "setString";
        String s = redisOperaTemplate.get(keys+key);
        return s;
    }

    @RequestMapping("testIncrement")
    public String testIncrement(String key){
        Long step = 3L;
        Long increment = redisOperaTemplate.increment(key, step);
        return String.valueOf(increment);
    }
}
