package com.cor.demo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main demo class. You need to have the ActiveMQ broker up and running before running this demo
 * (use 'mvn camel:run' on the command line to run up Camel - see README for more details).
 */
public class StartDemo {

    /** Logger. */
    private static Logger LOG = LoggerFactory.getLogger(StartDemo.class);

    /**
     * Main class - this will fire automatically generated String messages to the
     * "corsoft.BroadcastMessageQueue" running on the local ActiveMQ broker (as defined in
     * application.properties).
     */
    public static void main(String[] args) throws Exception {

        // Load spring config
        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "application-client-context.xml" });
        BeanFactory factory = (BeanFactory) appContext;

        MessageDispatcher dispatcher = (MessageDispatcher) factory.getBean("messageDispatcher");

        for (int x = 0; x < 100; x++) {
            dispatcher.sendMessageObject(createRandomMessage(x));
            Thread.sleep(1000);
        }

        LOG.info("Fin.");

    }
    
    private static String createRandomMessage(int index){
        
        StringBuilder sb = new StringBuilder();
        sb.append("<h2>Broadcast Message ");
        sb.append(index);
        sb.append("</h2>");
        sb.append("<p>Received on : ");
        sb.append(new Date());
        sb.append("<br/>Hey, hey - isn't this great!</p>");
        
        return sb.toString();
        
    }

}