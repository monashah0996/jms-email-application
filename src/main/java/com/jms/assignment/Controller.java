package com.jms.assignment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    private final MessagePublisher emailMessagePublisher;
    private final EmailMessages emailMessages;

    @Autowired
    public Controller(MessagePublisher emailMessagePublisher, EmailMessages emailMessages) {
        this.emailMessagePublisher = emailMessagePublisher;
        this.emailMessages = emailMessages;
    }

    @PostMapping("/")
    public String sendEmail(@RequestBody EmailBean email) {
        log.info("Email request received {}", email);
        boolean isEmailSent = emailMessagePublisher.sendEmailToQueue(email);
        if(isEmailSent){
            return "Email has been sent successfully";
        }else{
            return "Error occurred while sending an email, Please contact administrator";
        }
    }

    @GetMapping("/")
    @ResponseBody
    public List<EmailBean> getAllEmails() {
        return emailMessages.getAllEmails();
    }
}
