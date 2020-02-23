package io.aoguerrero.github;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @PostConstruct
    public void init() {
        this.messages = new ArrayList<>();
    }

    public List<Message> messages;

    public void save(final Message message) {
        this.messages.add(message);
    }

    public Message pop() {
        if(this.messages.size() == 0)
            return new Message(DestinationType.END, "");
        Message message = this.messages.get(0);
        messages.remove(message);
        return message;
    }
}