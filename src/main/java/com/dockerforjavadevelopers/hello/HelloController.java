package com.dockerforjavadevelopers.hello;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class HelloController {
    
    @GetMapping("/greet/{name}")
    public String index(@PathVariable String name) {
        return "Hi!!  " + name;;
    }
    
}
