package com.smallren.publisher;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @Description: 消息消费者1
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 18:51
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 18:51
 * @UpdateRemark:
 */

@Component
@ConditionalOnProperty(prefix = "application", name = "type", havingValue = "subscriber")
public class FirstConsumer {

    @RabbitListener(queues = {"first-queue", "second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :" + message);
    }
}