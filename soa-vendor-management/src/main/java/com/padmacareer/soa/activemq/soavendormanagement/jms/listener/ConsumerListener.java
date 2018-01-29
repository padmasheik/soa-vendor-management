package com.padmacareer.soa.activemq.soavendormanagement.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class ConsumerListener implements MessageListener {

	@Override
	public void onMessage(Message arg0) {
		System.out.println("In onMessage()");

	}

}
