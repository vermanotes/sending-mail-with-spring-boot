/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eatcodesleep.mail;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author shiraaz
 */
public class TextEmail {
    private String fromAddress;
    private List<String> toAddresses;
    private String message;

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public List<String> getToAddresses() {
        return toAddresses;
    }

    public void setToAddresses(List<String> toAddresses) {
        this.toAddresses = toAddresses;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public String getToAddressesAsCommaSeparatedString() {
        return toAddresses.stream().collect(Collectors.joining(","));
    }
}
