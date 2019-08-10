package com.smallren.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.smallren.config.RabbitMqConfig.ROUTING;

/**
 * @Description: java类作用描述
 * @Author: renbaojia
 * @CreateDate: 2019/8/10 11:23
 * @UpdateUser:
 * @UpdateDate: 2019/8/10 11:23
 * @UpdateRemark:
 * @Version: 3.5.xxx
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "application", name = "type", havingValue = "publisher")
public class MyAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @AfterReturning(returning = "rvt", pointcut = "execution(* com.smallren.service..*.save*(..))")
    public void AfterReturning(JoinPoint joinPoint, Object rvt) {
        Object[] args = joinPoint.getArgs();
        logger.debug("OPERATION", joinPoint.getArgs());
        String className = args[0].getClass().getSimpleName();
        String uuid = UUID.randomUUID().toString();
        CorrelationData correlationId = new CorrelationData(uuid);
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGE, ROUTING + className,
                args[0], correlationId);
    }


}
