package com.codenotfound.udp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codenotfound.udp.client.UdpClient;
import com.codenotfound.udp.client.UdpIntegrationClient;


public class MessageController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(MessageController.class);
	
	private final UdpClient udpClient;
	
	@Autowired
	public MessageController(UdpIntegrationClient udpClient) {
		this.udpClient = udpClient;
	}
	
}
