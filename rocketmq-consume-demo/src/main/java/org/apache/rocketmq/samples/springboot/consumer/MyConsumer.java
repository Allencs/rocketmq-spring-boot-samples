package org.apache.rocketmq.samples.springboot.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RocketMQMessageListener(nameServer = "${rocketmq.name-server}",
        topic = "${demo.rocketmq.topic}", consumerGroup = "MyConsumerGroup")
public class MyConsumer implements RocketMQListener<String> {

    private static Logger logger = LoggerFactory
            .getLogger(MyConsumer.class);

    public MyConsumer() {
        logger.info("start listening");
    }

    @Override
    public void onMessage(String message) {

        System.out.printf("------- MyConsumer received: %s \n", message);
    }
}
