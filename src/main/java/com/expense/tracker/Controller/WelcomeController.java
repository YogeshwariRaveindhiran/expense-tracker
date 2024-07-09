package com.expense.tracker.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {
    public String welcome()
    {
        return "<h1> Congratulations. You have successfully deployed the sample Spring Boot Application. </h1>";
    }
}
