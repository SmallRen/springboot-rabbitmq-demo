package com.smallren.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Description: 消息丢失回调接口
 * @Author: renbaojia
 * @CreateDate: 2019/8/9 10:34
 * @UpdateUser:
 * @UpdateDate: 2019/8/9 10:34
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
public class RabbitReturnCallback implements RabbitTemplate.ReturnCallback {
    private static final Logger log = LoggerFactory.getLogger(RabbitReturnCallback.class);

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("消息丢失:exchange({}),route({}),replyCode({}),replyText({}),message:{}", exchange,
                routingKey, replyCode, replyText, message);
    }
}
