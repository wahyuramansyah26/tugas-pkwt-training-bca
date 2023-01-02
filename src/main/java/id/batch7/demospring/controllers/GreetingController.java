package id.batch7.demospring.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/hello")
    public String hello(@RequestParam(value ="name", defaultValue = "world") String name) {
        return String.format("Hello, %s!", name);
    }

    @GetMapping("/hello2/{name}")
    public String hello2(@PathVariable String name) {
        return String.format("Hello, %s!", name);
    }
}
