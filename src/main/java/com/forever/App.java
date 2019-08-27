package com.forever;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Controller
public class App 
{
    @RequestMapping("/getIp")
    @ResponseBody
    String home(HttpServletRequest request) {
        String remoteAddr = request.getRemoteAddr();
        String  ip = request.getHeader("X-Real_IP");
        return remoteAddr+"->"+ip;
    }

    @RequestMapping("/person")
    @ResponseBody
    public Person person() {
       Person person = new Person();
       person.setId(1);
       person.setName("1");
       return person;
    }

    @PostMapping(value = "/jsonToProperties",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = "application/properties")
    @ResponseBody
    public Person jsonToProperties(@RequestBody Person person) {
        return person;
    }

    @PostMapping(value = "/propertiesToJson",
            consumes = "application/properties",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Person propertiesToJson(@RequestBody Person person) {
        return person;
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
