package io.aoguerrero.github;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MessageService {

    public List<Message> messages;

    public void save(Message message) {
        this.messages.add(message);
    }

    public List<Message> flush() {
        List<Message> currentMessages = new ArrayList<>();
        for(int i = 0; i< messages.size(); i++) {
            Message message = messages.get(i);
            currentMessages.add(message);
            messages.remove(message);
        }
        return currentMessages;
    }
}