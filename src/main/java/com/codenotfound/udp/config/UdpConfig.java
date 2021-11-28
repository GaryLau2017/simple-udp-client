package com.codenotfound.udp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.ip.udp.UnicastReceivingChannelAdapter;
import org.springframework.integration.ip.udp.UnicastSendingMessageHandler;
import org.springframework.messaging.MessageChannel;

@Configuration
public class UdpConfig {

	@Value("${udp.channel}")
	private String channel;
	@Value("${udp.port}")
	private Integer port;

	@Value("${ip}")
	private String ip;
	
	@Bean
    public MessageChannel inboundChannel() {
        return new DirectChannel();
    }
	

	
	@Bean
	public UnicastSendingMessageHandler udpSendingAdapter() {
		return new UnicastSendingMessageHandler(ip, port);
	}

}
