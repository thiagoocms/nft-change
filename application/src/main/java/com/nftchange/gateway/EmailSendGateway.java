package com.nftchange.gateway;

public interface EmailSendGateway {
    void sendEmailText(String to, String subject, String message);
}
