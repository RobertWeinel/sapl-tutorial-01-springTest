package io.sapl.tutorial.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoService {
    public String hello(){
        log.info("Service called!");
        return "Hello World";
    }
}
