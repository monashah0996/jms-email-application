package com.jms.assignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MessageListener {

    private final EmailMessages emailMessages;

    @Autowired
    public MessageListener(EmailMessages emailMessages){
        this.emailMessages = emailMessages;
    }

    @JmsListener(destination = "jms.email.queue")
    public void receiveEmail(EmailBean email) {
        log.info("Email received={}", email);
        emailMessages.push(email);
    }
}
