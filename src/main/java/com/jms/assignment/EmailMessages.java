package com.jms.assignment;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmailMessages {

    private final List<EmailBean> receicedEmailList;

    public EmailMessages() {
        this.receicedEmailList = new ArrayList<>();
    }

    public void push(EmailBean email) {
        receicedEmailList.add(email);
    }

    public List<EmailBean> getAllEmails() {
        return receicedEmailList;
    }
}
