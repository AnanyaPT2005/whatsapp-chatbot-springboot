

package com.example.WhatsAppBot;

import org.springframework.web.bind.annotation.*;
import java.util.Map;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebhookController {

   
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping("/webhook")
    public String receiveMessage(@RequestBody Map<String, String> payload) {

        String message = payload.get("message");

       
        logger.info("Incoming message: {}", message);

        if (message == null) {
            logger.warn("Received null message");
            return "Invalid message";
        }

        message = message.trim();

        String response;

        if (message.equalsIgnoreCase("Hi")) {
            response = "Hello";
        } else if (message.equalsIgnoreCase("Bye")) {
            response = "Goodbye";
        } else if (message.equalsIgnoreCase("How are you")) {
            response = "I'm just a bot, but I'm doing great!";
        } else if (message.equalsIgnoreCase("Help")) {
            response = "You can say Hi or Bye!";
        } else {
            response = "I don't understand";
        }

     
        logger.info("Bot response: {}", response);

        return response;
    }
}