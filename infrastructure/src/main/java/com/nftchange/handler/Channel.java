package com.nftchange.handler;

import java.util.HashSet;
import java.util.Set;

public class Channel {

    private String name;
    private Set<String> sessions;

    public Channel(String name) {
        this.name = name;
        this.sessions = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<String> getSessions() {
        return sessions;
    }

    public void addSession(String sessionId) {
        sessions.add(sessionId);
    }

    public void removeSession(String sessionId) {
        sessions.remove(sessionId);
    }

    public boolean isEmpty() {
        return sessions.isEmpty();
    }
}
