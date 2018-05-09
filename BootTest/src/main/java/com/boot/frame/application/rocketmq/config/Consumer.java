package com.boot.frame.application.rocketmq.config;

/**
 * Created by admin on 2018-04-26.
 */
public class Consumer {


    private String id;
    private String clazz;
    private String nameAddr;
    private String topic;
    private String messageModel;
    private String consumerGroup;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getNameAddr() {
        return nameAddr;
    }

    public void setNameAddr(String nameAddr) {
        this.nameAddr = nameAddr;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessageModel() {
        return messageModel;
    }

    public void setMessageModel(String messageModel) {
        this.messageModel = messageModel;
    }

    public String getConsumerGroup() {
        return consumerGroup;
    }

    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }
}
