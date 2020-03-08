package org.apache.rocketmq.samples.springboot;

import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class MyProducer implements CommandLineRunner {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Value("${demo.rocketmq.topic}")
    private String Topic;

    public static void main(String[] args) {
        SpringApplication.run(MyProducer.class, args);
    }

    @Override
    public void run(String... args) {
        // Send string
        SendResult sendResult = rocketMQTemplate.syncSend(Topic, "Hello, RocketMQ 1!");
        System.out.printf("syncSend1 to topic %s sendResult=%s %n", Topic, sendResult);

        rocketMQTemplate.convertAndSend(Topic + ":tag-spring", "I'm from spring boot 1");
        System.out.printf("syncSend topic: %s tag: %s %n", Topic, "tag-spring");
    }
}
