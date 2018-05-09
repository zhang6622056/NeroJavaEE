package com.boot.frame.application.rocketmq.consumer;

import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.secoo.rocketmq.PushRocketMQConsumer;

import java.util.List;

/**
 * Created by admin on 2018-04-26.
 */
public class MqConsumer extends PushRocketMQConsumer {


    @Override
    public ConsumeConcurrentlyStatus doService(List<MessageExt> msgs) {
        for(MessageExt messageExt : msgs){
            try {
//                CreateOrderRequest createOrderRequest = (CreateOrderRequest) IoUtil.byteToObject(messageExt.getBody());
            } catch (Exception e) {
                e.printStackTrace();
            }
            //do something

        }
        return null;
    }
}
