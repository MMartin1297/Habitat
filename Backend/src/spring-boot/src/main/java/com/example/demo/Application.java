package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.websocket.WebSocketServerApplication;

/**
 * Class to run application
 * @author Max Minard, Matthew Martin
 *
 */
@SpringBootApplication
public class Application {

	/**
	 * Main method to run application
	 * @param args
	 * 		Any needed arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
