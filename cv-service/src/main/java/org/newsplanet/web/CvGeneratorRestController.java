package org.newsplanet.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/cv")
public class CvGeneratorRestController {

    @GetMapping("/")
    public String hello(){
        return "Hello";
    }
}
