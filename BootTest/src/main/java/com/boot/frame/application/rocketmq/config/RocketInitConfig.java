package com.boot.frame.application.rocketmq.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018-04-25.
 */
@ConfigurationProperties("mq")
public class RocketInitConfig {

    private final List<Producer> producers = new ArrayList<>();
    private final List<Consumer> consumers = new ArrayList<>();


    public List<Producer> getProducers() {
        return producers;
    }

    public List<Consumer> getConsumers() {
        return consumers;
    }
}
