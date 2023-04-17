package com.jms.assignment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailBean implements Serializable {
    private String to;
    private String body;
    private String subject;
}
