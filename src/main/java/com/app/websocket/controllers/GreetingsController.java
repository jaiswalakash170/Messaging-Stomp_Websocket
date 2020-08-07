package com.app.websocket.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.app.websocket.model.Greeting;
import com.app.websocket.model.HelloMessage;

@RestController
public class GreetingsController {

	@Autowired
	SimpMessagingTemplate messaging_template;
	
	@MessageMapping("/hello")
	@SendTo("/topic/greetings")
	public String greeting(String message) throws Exception
	{
		//Thread.sleep(1000);
		System.out.println("Serving greeting method Name : " + message);
		Greeting g = new Greeting("Hello " + message + "!");
		return g.toString();
	}
}