package com.boot.frame.application.rocketmq;


import com.boot.frame.application.rocketmq.config.Consumer;
import com.boot.frame.application.rocketmq.config.Producer;
import com.boot.frame.application.rocketmq.config.RocketInitConfig;
import com.boot.frame.application.rocketmq.consumer.MqConsumer;
import com.boot.frame.application.rocketmq.producer.MqMsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by admin on 2018-04-26.
 */
@Configuration
@EnableConfigurationProperties(RocketInitConfig.class)
public class MqBeanConfig{

    @Autowired
    RocketInitConfig rocketInitConfig;

    @Bean
    public MqMsgProducer mqMsgProducer() throws Exception {
        MqMsgProducer mqMsgProducer = new MqMsgProducer();
        List<Producer> list = rocketInitConfig.getProducers();

        if(null == list || list.size() == 0){
            throw new Exception("can not find mq config...");
        }
        Producer producer = list.get(0);
        mqMsgProducer.setNamesrvAddr(producer.getNameAddr());
        mqMsgProducer.setProducerGroup(producer.getProducerGroup());
        return mqMsgProducer;
    }

    @Bean
    public MqConsumer mqMsgConsumer() throws Exception {
        MqConsumer mqConsumer = new MqConsumer();
        List<Consumer> list = rocketInitConfig.getConsumers();
        if(null == list || list.size() == 0){
            throw new Exception("can not find mq config...");
        }
        Consumer consumerConfig = list.get(0);
        mqConsumer.setTopic(consumerConfig.getTopic());
        mqConsumer.setNamesrvAddr(consumerConfig.getNameAddr());
        mqConsumer.setMessageModel(consumerConfig.getMessageModel());
        mqConsumer.setConsumerGroup(consumerConfig.getConsumerGroup());
        return mqConsumer;
    }

}
