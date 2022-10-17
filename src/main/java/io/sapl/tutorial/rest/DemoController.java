package io.sapl.tutorial.rest;

import io.sapl.tutorial.data.DemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class DemoController {
private final DemoService demoservice;
@GetMapping("/api/hello")
    public Mono<String> hello(){
    return Mono.just(demoservice.hello());
}
}
