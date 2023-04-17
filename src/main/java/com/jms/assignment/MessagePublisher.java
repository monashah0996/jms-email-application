package com.jms.assignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class MessagePublisher {
    private final JmsTemplate template;

    @Autowired
    public MessagePublisher(JmsTemplate template) {
        this.template = template;
    }

    public boolean sendEmailToQueue(EmailBean emailBean) {
        try{
            template.convertAndSend("jms.email.queue", emailBean);
            log.info("Email sent to queue");
            return true;
        } catch (Exception ex) {
            log.error("Error occurred while sending an email to queue", ex);
        }
        return false;
    }
}
