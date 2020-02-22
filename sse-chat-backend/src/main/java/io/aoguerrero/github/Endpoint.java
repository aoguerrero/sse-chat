package io.aoguerrero.github;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/sse")
public class Endpoint {

    @Autowired
    private MessageService messageService;

    @GetMapping(path = "/receive")
    public Flux<List<Message>> receive() {
        Flux<List<Message>> intervalFlux = Flux.interval(Duration.ofMillis(1000)).map(tick -> {
            return messageService.flush();
        });
        return intervalFlux;
    }

    @PostMapping(path = "/send")
    public void send(@RequestBody Message message) {
        messageService.save(message);
    }

}