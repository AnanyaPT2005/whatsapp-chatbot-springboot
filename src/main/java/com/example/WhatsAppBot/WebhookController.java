// package com.example.WhatsAppBot;

// import org.springframework.web.bind.annotation.*;

// import java.util.Map;

// @RestController  // tells Spring this class handles API requests
// public class WebhookController {

//     @PostMapping("/webhook")  // this is your endpoint
//     public String receiveMessage(@RequestBody Map<String, String> payload) {

//         String message = payload.get("message");  // read JSON

//         return "Message received: " + message;  // simple response
//     }
// }

// package com.example.WhatsAppBot;

// import org.springframework.web.bind.annotation.*;
// import java.util.Map;

// @RestController
// public class WebhookController {

//     @PostMapping("/webhook")
//     public String receiveMessage(@RequestBody Map<String, String> payload) {

//         String message = payload.get("message"); // get input
//         message = message.trim();

//         if (message == null) {
//             return "Invalid message";
//         }

//         // chatbot logic
//         if (message.equalsIgnoreCase("Hi")) {
//             return "Hello";
//         } else if (message.equalsIgnoreCase("Bye")) {
//             return "Goodbye";
//         } else {
//             return "I don't understand";
//         }
//     }
// }

package com.example.WhatsAppBot;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

// ✅ Logger imports
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WebhookController {

    // ✅ Create logger instance (best practice)
    private static final Logger logger = LoggerFactory.getLogger(WebhookController.class);

    @PostMapping("/webhook")
    public String receiveMessage(@RequestBody Map<String, String> payload) {

        String message = payload.get("message");

        // ✅ Log incoming message
        logger.info("Incoming message: {}", message);

        if (message == null) {
            logger.warn("Received null message");
            return "Invalid message";
        }

        message = message.trim();

        String response;

        // if (message.equalsIgnoreCase("Hi")) {
        // response = "Hello";
        // } else if (message.equalsIgnoreCase("Bye")) {
        // response = "Goodbye";
        // } else {
        // response = "I don't understand";
        // }

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

        // ✅ Log response
        logger.info("Bot response: {}", response);

        return response;
    }
}