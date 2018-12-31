package com.example.demo.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.RequestRepository;
import com.example.demo.websocket.WebSocketConfig;
import com.example.demo.Request;

/**
 * Web socket server class
 * @author Max Minard, Matthew Martin
 *
 */
@ServerEndpoint("/websocket/{id_users}")
@Component
public class WebSocketServer {
	
	/**
	 * Variable to represent session and user id map
	 */
	private static Map<Session, Integer> sessionUserIDMap = new HashMap<>(); //Session is Key, UserID is value
	
	/**
	 * Variable to represent user id and session map
	 */
    private static Map<Integer, Session> userIDSessionMap = new HashMap<>(); //UserID is Key, Session is value
    
    /**
     * Variable to represent Logger
     */
    private final Logger logger = LoggerFactory.getLogger(WebSocketServer.class);
    
    /**
     * Variable to represent request repository
     */
    @Autowired
    private static RequestRepository requests;
    
    /**
     * Method that is called when web socket is opened. Creates a session with user id
     * @param session
     * 		Current session
     * @param id_users
     * 		User ID of open session
     * @throws IOException
     * 		Exception
     */
	@OnOpen
	public void onOpen(Session session, @PathParam("id_users") Integer id_users) throws IOException{
		sessionUserIDMap.put(session, id_users);
        userIDSessionMap.put(id_users, session);
        logger.info("Session open: "+ id_users);
	}
	
	/**
	 * Method that is called when web socket is closed. 
	 * @param session
	 * 		Current session
	 * @throws IOException
	 * 		Exception
	 */
	@OnClose
	public void onClose(Session session) throws IOException{
		Integer id_users = sessionUserIDMap.get(session);
    	sessionUserIDMap.remove(session);
    	userIDSessionMap.remove(id_users);
    	logger.info("Session closed: "+ id_users);
	}
	
	/**
	 * Method that is called when web socket has error. 
	 * @param session
	 * 		Current session
	 * @param throwable
	 * 		Throwable
	 */
	@OnError
    public void onError(Session session, Throwable throwable) 
    {
    	logger.info("Error occured");
    }

	
	/**
	 * Method that is called when a message is sent over web sockets.
	 * Uses the session and message to determined the notification sent to specific user.
	 * @param session
	 * 		Current session
	 * @param request
	 * 		Request that activated notification
	 */
	@OnMessage
	public void OnMessage(Session session, String request){
		
		/*
		 *   The 2 different users to notify on an update to a request
		 */
		Integer notify1 = null;
		Integer notify2 = null;
		
		String[] information = request.split(",");
		
		notify1 = Integer.parseInt(information[0]);
		notify2 = Integer.parseInt(information[1]);
		String title = information[2];
		
		/*
		 *   Send notification to needed users with an open session
		 */
		if(notify1 != -1 && userIDSessionMap.get(notify1).isOpen()){//Send notification to 1st person
			sendMessageToPArticularUser(notify1, title);
		}
		
		if(notify2 != -1 && userIDSessionMap.get(notify2).isOpen()){//Send notification to 2nd person
			sendMessageToPArticularUser(notify2, title);
		}
	}
	
	/**
	 * Helper class to send the notification to a given user.
	 * @param username
	 * 		User name to send notification to.
	 * @param message
	 * 		Message to send in notification.
	 */
	private void sendMessageToPArticularUser(Integer username, String message) 
    {	
    	try {
    		userIDSessionMap.get(username).getBasicRemote().sendText(message + " has been updated");
    		System.out.println("Sent to " + username);
        } catch (IOException e) {
        	logger.info("Exception: " + e.getMessage().toString());
            e.printStackTrace();
        }
    }

	
	
}
