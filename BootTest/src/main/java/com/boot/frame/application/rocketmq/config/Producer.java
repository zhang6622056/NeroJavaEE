package com.boot.frame.application.rocketmq.config;


/**
 * Created by admin on 2018-04-26.
 */
public class Producer {

    private String nameAddr;
    private String producerGroup;

    public String getNameAddr() {
        return nameAddr;
    }

    public void setNameAddr(String nameAddr) {
        this.nameAddr = nameAddr;
    }

    public String getProducerGroup() {
        return producerGroup;
    }

    public void setProducerGroup(String producerGroup) {
        this.producerGroup = producerGroup;
    }
}
