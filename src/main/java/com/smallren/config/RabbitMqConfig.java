package com.smallren.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/8 17:35
 * @UpdateUser:
 * @UpdateDate: 2019/8/8 17:35
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
@Configuration
public class RabbitMqConfig {
    @Value("${application.type}")
    public String types;

    public static String type;

    private static final Logger log = LoggerFactory.getLogger(RabbitMqConfig.class);
    public static final String SAVE = "save-";
    public static final String UPDATE = "update-";
    /**
     * 消息交换机的名字
     */
    public static final String EXCHANGE = "exchangeTest";
    /**
     * ROUTING
     */
    public static final String ROUTING = "routing_";
    public static final String ROUTING_USER = "routing_User";
    public static final String QUEUE_USER = "queue_User";

    @Autowired
    private QueueConfig queueConfig;
    @Autowired
    private ExchangeConfig exchangeConfig;

    /**
     * 连接工厂
     */
    @Autowired
    private CachingConnectionFactory connectionFactory;

    /**
     * 将消息队列1和交换机进行绑定
     */
    @Bean
    public Binding bindingSave() {
        return BindingBuilder.bind(queueConfig.UserQueue()).to(exchangeConfig.directExchange()).with(ROUTING_USER);
    }


    /**
     * 定义rabbit template用于数据的接收和发送
     *
     * @return
     */
    @Bean
    public RabbitTemplate rabbitTemplate() {
        //RabbitTemplate template = new RabbitTemplate(connectionFactory);
        /**若使用confirm-callback或return-callback，
         * 必须要配置publisherConfirms或publisherReturns为true
         * 每个rabbitTemplate只能有一个confirm-callback和return-callback
         */
        /*消息确认机制
         * Confirms给客户端一种轻量级的方式，能够跟踪哪些消息被broker处理，
         * 哪些可能因为broker宕掉或者网络失败的情况而重新发布。
         * 确认并且保证消息被送达，提供了两种方式：发布确认和事务。(两者不可同时使用)
         * 在channel为事务时，不可引入确认模式；同样channel为确认模式下，不可使用事务。*/
        //template.setConfirmCallback(new RabbitConfirmCallback());
        //template.setReturnCallback(msgSendReturnCallback());
        /**
         * 使用return-callback时必须设置mandatory为true，或者在配置中设置mandatory-expression的值为true，
         * 可针对每次请求的消息去确定’mandatory’的boolean值，
         * 只能在提供’return -callback’时使用，与mandatory互斥
         */
        //  template.setMandatory(true);
        connectionFactory.setPublisherConfirms(true);
        connectionFactory.setPublisherReturns(true);
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new RabbitConfirmCallback());
        rabbitTemplate.setReturnCallback(new RabbitReturnCallback());

        return rabbitTemplate;
    }


}