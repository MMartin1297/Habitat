package com.example.demo.websocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Class to run web socket server application.
 * @author Max Minard, Matthew Martin
 *
 */
@SpringBootApplication
public class WebSocketServerApplication {

	/**
	 * Main method to run web socket server application.
	 * @param args
	 * 		Arguments needed
	 */
	public static void main(String[] args) {
		SpringApplication.run(WebSocketServerApplication.class, args);
	}
}