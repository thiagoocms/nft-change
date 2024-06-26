package com.nftchange.dto;

public class WebSocketMessageDTO {
    private String channel;
    private String message;
    private String action;

    public WebSocketMessageDTO() {
    }

    public WebSocketMessageDTO(String channel, String message, String action) {
        this.channel = channel;
        this.message = message;
        this.action = action;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
