package com.nftchange.handler;

import com.nftchange.dto.WebSocketMessageDTO;
import com.nftchange.util.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(WebSocketHandler.class);
    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
    private final Map<String, String> sessionChannels = new ConcurrentHashMap<>();
    private final Map<String, Channel> channels = new ConcurrentHashMap<>();
    private final static String NFT_RELOAD = "nft-reload";

    public WebSocketHandler() {
        channels.put(NFT_RELOAD,new Channel(NFT_RELOAD));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.info("Connected: {}", session.getId());
        sessions.put(session.getId(), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        WebSocketMessageDTO dto = JsonParser.fromJsonToEntity(message.getPayload(), WebSocketMessageDTO.class);

        switch (dto.getAction()) {
            case "subscribe":
                handleSubscribe(session, dto);
                break;
            case "create_channel":
                handleCreateChannel(dto);
                break;
            case "send_message":
                handleSendMessage(dto);
                break;
            default:
               log.error("Unknown action");
                break;
        }
    }

    private void handleSubscribe(WebSocketSession session, WebSocketMessageDTO dto) throws Exception {
        String channelName = dto.getChannel();
        if (channels.containsKey(channelName)) {
            Channel channel = channels.get(channelName);
            channel.addSession(session.getId());
            sessionChannels.put(session.getId(), channelName);
            log.info("Subscribed {} to channel {}", session.getId(), channelName);
        } else {
            log.error("Channel does not exist: {}", channelName);
        }
    }

    private void handleCreateChannel(WebSocketMessageDTO dto) throws Exception {
        String channelName = dto.getChannel();
        if (!channels.containsKey(channelName)) {
            channels.put(channelName, new Channel(channelName));
            log.info("Created channel: {}", channelName);
        } else {
            log.info("Channel already exists: {}", channelName);
        }
    }

    private void handleSendMessage(WebSocketMessageDTO dto) throws Exception {
        String channelName = dto.getChannel();
        String payload = dto.getMessage();

        if (channels.containsKey(channelName)) {
            Channel channel = channels.get(channelName);
            for (String sessionId : channel.getSessions()) {
                WebSocketSession targetSession = sessions.get(sessionId);
                if (targetSession != null && targetSession.isOpen()) {
                    log.info("Received: {} on channel: {}", payload, channel);;
                    targetSession.sendMessage(new TextMessage(payload));
                }
            }
        } else {
            log.info("Channel not found: {}", channelName);
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("Disconnected: " + session.getId());
        sessions.remove(session.getId());
        String channelName = sessionChannels.get(session.getId());
        if (channelName != null && channels.containsKey(channelName)) {
            Channel channel = channels.get(channelName);
            channel.removeSession(session.getId());
        }
        sessionChannels.remove(session.getId());
    }

    public void sendMessageToChannel(String channelName, String message) throws Exception {
        if (channels.containsKey(channelName)) {
            Channel channel = channels.get(channelName);
            TextMessage textMessage = new TextMessage(message);

            for (String sessionId : channel.getSessions()) {
                WebSocketSession targetSession = sessions.get(sessionId);
                if (targetSession != null && targetSession.isOpen()) {
                    targetSession.sendMessage(textMessage);
                }
            }
        } else {
            log.info("Channel not found: {}", channelName);
        }
    }
}
