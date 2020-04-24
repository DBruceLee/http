package com.dbstar.http;

import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class HttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpApplication.class, args);
    }

    @RequestMapping("/hello")
    public String test(HttpServletResponse response) {
        System.out.println("hello");
        response.addHeader("Last-Modified", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        return "hello world";
    }

}
