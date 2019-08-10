package com.smallren.listener;

import com.smallren.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PostPersist;
import java.util.UUID;

import static com.smallren.config.RabbitMqConfig.ROUTING;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/10 14:38
 * @UpdateUser:
 * @UpdateDate: 2019/8/10 14:38
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
public class EntityListener {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 完成save之后的操作。
     *
     * @param obj obj
     */
    @PostPersist
    public void postPersist(Object obj) {
        logger.debug("insert----{}", obj.getClass());
        String className = obj.getClass().getSimpleName();
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, ROUTING + className,
                obj, correlationId);
    }
}
