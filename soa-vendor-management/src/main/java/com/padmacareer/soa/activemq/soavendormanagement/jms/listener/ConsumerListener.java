package com.padmacareer.soa.activemq.soavendormanagement.jms.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.padmacareer.soa.activemq.soavendormanagement.jms.adapter.ConsumerAdapter;

//@Component
public class ConsumerListener implements MessageListener {
	private static Logger logger = LogManager.getLogger(ConsumerListener.class);
	@Autowired
	JmsTemplate jmsTemplate;
	@Autowired
	ConsumerAdapter consumerAdapter;

	@Override
	public void onMessage(Message message) {
		String json = null;
		logger.info("In onMessage()");
		if (message instanceof TextMessage) {
			try {
				json = ((TextMessage) message).getText();
				logger.info("Sending Json to DB : " + json);
				consumerAdapter.sendToMongo(json);
			} catch (JMSException e) {
				logger.error("Message: " + json);
				jmsTemplate.convertAndSend(json);
			} catch (Exception e) {
				logger.error("Message: " + json);
				jmsTemplate.convertAndSend(json);
			}
		}

	}

}
