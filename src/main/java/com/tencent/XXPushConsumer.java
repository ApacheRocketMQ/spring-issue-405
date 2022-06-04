package com.tencent;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RocketMQMessageListener(
        consumerGroup = "${rocketmq.consumer.group}",
        topic = "${rocketmq.consumer.topic}"
)
public class XXPushConsumer implements RocketMQListener<MessageExt> {

    @Override
    public void onMessage(MessageExt message) {
        System.out.println(LocalDateTime.now() + "\t" + message.toString());
    }
}