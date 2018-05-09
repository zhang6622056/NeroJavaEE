package com.boot.frame.application.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr Liu
 * @date: Created in 2018/4/25 14:51
 * @Description:
 */
@Component
public class RedisOperaTemplate<T> {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private ValueOperations<String, String> opsForValue;

    @PostConstruct
    private void init(){
        opsForValue = stringRedisTemplate.opsForValue();
    }

    /**
     * bean(include string) to jsonString
     *
     * @param t
     * @return
     */
    private String toJsonStr(T t){
        if(t instanceof String){
            return (String) t;
        }else{
            return JSON.toJSONString(t);
        }
    }

    /**
     * jsonString to bean without string
     *
     * @param value
     * @param clazz
     * @return
     */
    private T toBean(String value,Class<T> clazz){
        if(String.class.isAssignableFrom(clazz)){
            return (T)value;
        }else{
            return JSON.parseObject(value, clazz);
        }
    }

    /**
     * 添加缓存
     *
     * @param key
     * @param value
     */
    public void set(String key,T value){
        opsForValue.set(key, toJsonStr(value));
    }


    /**
     * 批量添加缓存
     *
     * @param map
     */
    public void multiSet(Map<String,T> map){
        Map<String,String> changeMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, T>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, T> entry = it.next();
            changeMap.put(entry.getKey(),toJsonStr(entry.getValue()));
        }
        opsForValue.multiSet(changeMap);
    }

    /**
     * 添加缓存
     *      --设置失效时间,单位秒
     *
     * @param key
     * @param value
     */
    public  void setWithExpired(String key,T value,Long time){
        opsForValue.set(key, toJsonStr(value), time, TimeUnit.SECONDS);
    }

    /**
     * 若key不存在，设置key的值为value；若key存在，不进行设置
     *
     * @param key
     * @param value
     * @return
     */
    public Boolean setIfAbsent(String key, T value){
        return opsForValue.setIfAbsent(key,toJsonStr(value));
    }

    /**
     * 批量设置
     *      --若key不存在，设置key的值为value；若key存在，不进行设置
     *
     * @param map
     * @return
     */
    public Boolean multiSetIfAbsent(Map<String,T> map){
        Map<String,String> changeMap = new HashMap<String, String>();
        Iterator<Map.Entry<String, T>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, T> entry = it.next();
            changeMap.put(entry.getKey(),toJsonStr(entry.getValue()));
        }
        return opsForValue.multiSetIfAbsent(changeMap);
    }
    /**
     * 获取缓存
     *      --返回字符串
     * @param key
     * @return
     */
    public String get(String key){
        return opsForValue.get(key);
    }

    /**
     * 获取缓存
     *      --返回对象
     *
     * @param key
     * @param clazz
     * @return
     */
    public T getBean(String key,Class<T> clazz){
        return toBean(opsForValue.get(key),clazz);
    }

    /**
     *设置value为新值，返回被替换的值
     *      --notice:此方法仅适用于value为字符串类型
     *
     * @param key
     * @return
     */
    public String getAndSetString(String key, String value){
        return opsForValue.getAndSet(key, value);
    }

    /**
     * 批量获取缓存
     *      --to string
     *
     * @param collection
     * @return
     */
    public  List<String> multiGet(Collection<String> collection){
        return opsForValue.multiGet(collection);
    }

    /**
     * 批量获取缓存
     *      --to bean
     *
     * @param collection
     * @return
     */
    public  List<T> multiGetBean(Collection<String> collection,Class<T> clazz){
        List<String> list = opsForValue.multiGet(collection);
        List<T> retList = new ArrayList<T>();
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            retList.add(toBean(iterator.next(),clazz));
        }
        return retList;
    }

    /**
     * 删除缓存
     *
     * @param key
     */
    public  void del(String key){
        opsForValue.getOperations().delete(key);
    }

    /**
     * 批量删除缓存
     *
     * @param collection
     * @return
     */
    public  Long multiDel(Collection<String> collection){
        return opsForValue.getOperations().delete(collection);
    }

    /**
     * Increment an integer value stored as string value under {@code key} by {@code delta}.
     *      --需要确定value为integer类型，且没有超出范围，否则抛出类型不满足异常
     *
     * @param key
     * @param delta
     * @return
     */
    public Long increment(String key, long delta){
        return opsForValue.increment(key,delta);
    }

    /**
     * Increment a floating point number value stored as string value under {@code key} by {@code delta}.
     *
     * @param key
     * @param delta
     * @return
     */
    public Double increment(String key, double delta){
        return opsForValue.increment(key,delta);
    }

    /**
     * Append a {@code value} to {@code key}.
     *      --原value后面拼接参数value
     *      --返回拼接后的字符串长度
     *      --慎用此方法，以防缓存数据的错误更改
     *
     * @param key
     * @param value
     * @return
     */
    public Integer append(String key, String value){
        return opsForValue.append(key,value);
    }

    /**
     * Get a substring of value of {@code key} between {@code begin} and {@code end}.
     *   --notice:
     *      --1:此方法仅适用于value为字符串类型的缓存才有实际意义
     *      --2:此方法仅支持英文字符的截取，中文截取有BUG
     *
     *
     * @param key
     * @param start
     * @param end
     * @return
     */
    public String get(String key, long start, long end){
        return opsForValue.get(key,start,end);
    }


    /**
     * Get the length of the value stored at {@code key}.
     *      --获取字符串的长度
     *
     * @param key
     * @return
     */
    public Long size(String key){
        return opsForValue.size(key);
    }

}
