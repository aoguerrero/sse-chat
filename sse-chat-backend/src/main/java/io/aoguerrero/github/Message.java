package io.aoguerrero.github;

import java.util.UUID;

public class Message implements Comparable<Message> {

    private final String id;
    private final DestinationType destinationType;
    private final String content;

    public Message(DestinationType destinationType, String content) {
        this.id = UUID.randomUUID().toString();
        this.destinationType = destinationType;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public DestinationType getDestinationType() {
        return this.destinationType;
    }

    public String getContent() {
        return this.content;
    }

    @Override
    public int compareTo(Message message) {
        return this.id.compareTo(message.getId());
    }
}