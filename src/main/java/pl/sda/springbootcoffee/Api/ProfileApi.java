package pl.sda.springbootcoffee.Api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileApi {

    @Value("${server.port}")
    private int port;

    @Value("${profile.type}")
    private String profile;

    @GetMapping("/profile")
    public String get() {
        return ("Active profile is: "+profile+", on port: "+port);
    }
}
