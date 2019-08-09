package com.smallren.config;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @Description: 消息消费成功回调接口
 * @Author: renbaojia
 * @CreateDate: 2019/8/9 10:26
 * @UpdateUser:
 * @UpdateDate: 2019/8/9 10:26
 * @UpdateRemark:
 */
public class RabbitConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("MsgSendConfirmCallBack  , 回调id:" + correlationData);
        if (b) {
            System.out.println("消息消费成功");
        } else {
            System.out.println("消息消费失败:" + s + "\n重新发送");
        }
    }
}
