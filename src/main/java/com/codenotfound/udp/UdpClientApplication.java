package com.codenotfound.udp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;

import com.codenotfound.udp.client.UdpClient;
import com.codenotfound.udp.client.UdpSimpleClient;
import com.codenotfound.udp.metrics.GenericMetrics;

import io.prometheus.client.spring.boot.EnablePrometheusEndpoint;


@SpringBootApplication
@EnableIntegration
@EnablePrometheusEndpoint
public class UdpClientApplication {
	private final static Logger LOGGER = LoggerFactory.getLogger(UdpClientApplication.class);
	private static UdpClient udpClient;
	
	@Autowired
	public UdpClientApplication(UdpSimpleClient udpClient) {
		this.udpClient = udpClient;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(UdpClientApplication.class, args);
		String status = "0";
		while(true) {
		
		try {
			GenericMetrics genericMetrics = new GenericMetrics(GenericMetrics.UDP_TRANSACTION_TYPE, GenericMetrics.TRANSACTION_TYPE, 
		            GenericMetrics.OUTGOING_TRANSACTION_DIRECTION, GenericMetrics.TRANSACTION_COMMAND); 
			udpClient.sendMessage("Hello");
			genericMetrics.close(status.toString());
			Thread.sleep(5);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
