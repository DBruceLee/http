package com.dbstar.http;

import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
@RestController
public class HttpApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttpApplication.class, args);
    }

    @RequestMapping("/")
    public String root(HttpServletResponse response) {
        return "hello world";
    }
    @RequestMapping("/hello")
    public String test(HttpServletResponse response) {
        System.out.println("hello");
        response.setStatus(HttpStatus.FOUND.value());
        response.addHeader("Location", "http://localhost:8888/hello/redirect1");
        return "hello world";
    }
    @RequestMapping("/hello/redirect1")
    public String location1(HttpServletRequest request, HttpServletResponse response) {

        response.setStatus(HttpStatus.FOUND.value());
        response.addHeader("Location", "http://localhost:8888/hello/redirect2");
        return "hello world, redirect1 ";
    }
    @RequestMapping("/hello/redirect2")
    public String location2(HttpServletResponse response) {
        response.setStatus(HttpStatus.FOUND.value());
        response.addHeader("Location", "http://localhost:8888/hello/redirect3");
        return "hello world, redirect2 ";
    }
    @RequestMapping("/hello/redirect3")
    public String location3(HttpServletResponse response) {
        return "hello world, redirect3 ";
    }
}
