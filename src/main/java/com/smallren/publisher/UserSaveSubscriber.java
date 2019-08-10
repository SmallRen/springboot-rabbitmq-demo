package com.smallren.publisher;


import com.smallren.config.RabbitMqConfig;
import com.smallren.entity.User;
import com.smallren.service.IUserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import static com.smallren.config.RabbitMqConfig.ROUTING_USER;
import static com.smallren.config.RabbitMqConfig.SAVE;

/**
 * @Description: 消息消费者1
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 18:51
 * @UpdateUser:ani
 * @UpdateDate: 2019/8/8 18:51
 * @UpdateRemark:
 */

@Component
@ConditionalOnProperty(prefix = "application", name = "type", havingValue = "subscriber")
public class UserSaveSubscriber {
    @Autowired
    IUserService iUserService;

    @RabbitListener(queues = {ROUTING_USER}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(User message) throws Exception {
        iUserService.save(message);
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage :" + message);
    }
}