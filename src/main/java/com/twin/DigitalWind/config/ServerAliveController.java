package com.twin.DigitalWind.config;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class ServerAliveController {

    private final SimpMessagingTemplate messagingTemplate;

    public ServerAliveController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendServerAliveMessage() {
//        System.out.println("server-alive");
        messagingTemplate.convertAndSend("/topic/server-alive", "ServerAlive");
    }

    @Scheduled(fixedRate = 150)
    public void sendPeriodicServerAliveMessage() {
        sendServerAliveMessage();
    }
}