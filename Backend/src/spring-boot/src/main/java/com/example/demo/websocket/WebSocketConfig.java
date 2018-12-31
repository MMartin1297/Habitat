package com.example.demo.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Configuration class for web sockets
 * @author Max Minard, Matthew Martin
 *
 */
@Configuration
public class WebSocketConfig {
	
	/**
	 * Method to establish new server endpoint exporter
	 * @return ServerEndpointExporter
	 * 		Server Endpoint Exporter
	 */
	@Bean
	public ServerEndpointExporter serverEndpointExporter(){
		return new ServerEndpointExporter();
	} 
}