package com.boot.frame.application.rocketmq.producer;

import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.boot.frame.application.rocketmq.config.IoUtil;
import com.secoo.rocketmq.PushRocketMQProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2018-04-25.
 */
public class MqMsgProducer extends PushRocketMQProducer {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private static ExecutorService executorService = Executors.newFixedThreadPool(32);

    public void sendMqMsg(final String topic, final String tags, final String keys, final Object messageBody) {
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    SendResult sendResult = sendMsg(topic, tags, keys, messageBody);
                    System.out.println(sendResult.toString());
                } catch (Exception e) {
                    log.error("发送MQ消息异常", e);
                }
            }
        });
    }

    private SendResult sendMsg(String topic, String tags, String keys, Object messageBody) {
        SendResult sendResult = null;
        try {
            byte[] bytes = null;
            if (messageBody instanceof String) {
                bytes = ((String) messageBody).getBytes("utf-8");
            } else {
                bytes = IoUtil.objectToBytes(messageBody);
            }

            Message message = new Message(topic, tags, keys, bytes);
            sendResult = send(message);
            log.info("mq消息:" + message + ", 发送结果:" + sendResult);
        } catch (Exception e) {
            log.error("发送MQ消息异常,topic:" + topic + ",keys:" + keys + ",data:" + messageBody + ",SendResult:" + sendResult, e);
        }
        return sendResult;
    }
}
