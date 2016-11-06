/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eatcodesleep.web;

import com.eatcodesleep.mail.TextEmail;
import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
@RequestMapping("/mail")
public class MailRestController {

    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_VALUE)
    public String sendMail(@RequestBody final TextEmail textEmail) {
        javaMailSender.send((MimeMessage mimeMessage) -> {
            mimeMessage.setFrom(textEmail.getFromAddress());
            mimeMessage.setRecipients(Message.RecipientType.TO,
              textEmail.getToAddressesAsCommaSeparatedString());
            mimeMessage.setText(textEmail.getMessage());
        });
        return "Success!!!";
    }
}
