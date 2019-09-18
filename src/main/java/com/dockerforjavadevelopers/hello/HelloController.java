package com.dockerforjavadevelopers.hello;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @GetMapping("/greet/{name}")
    public String index(@PathVariable String name) {
        return "Hi!!  " + name;;
    }
    
}
