package com.cor.demo;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * Delegate for sending messages to ActiveMQ Broker via the Spring JMSTemplate.
 */
@Component
public class MessageDispatcher {

    /** Logger. */
    private static Logger LOG = LoggerFactory.getLogger(MessageDispatcher.class);

    /** JMS Template. */
    @Autowired
    protected JmsTemplate jmsTemplate;

    /**
     * Send the objectMessage to the Broker and Queue defined in application.properties.
     * @param objectMessage Object Message
     */
    public void sendMessageObject(final Serializable objectMessage) {

        LOG.info("Sending message " + objectMessage);

        jmsTemplate.send(new MessageCreator() {

            public Message createMessage(Session session) throws JMSException {
                ObjectMessage message = session.createObjectMessage(objectMessage);
                return message;
            }
        });

        LOG.info("Message Sent!");

    }

}
