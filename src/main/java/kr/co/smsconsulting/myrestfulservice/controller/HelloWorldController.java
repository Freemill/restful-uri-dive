package kr.co.smsconsulting.myrestfulservice.controller;

import kr.co.smsconsulting.myrestfulservice.bean.HelloWorldBean;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {
    private final MessageSource messageSource;

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping("/hello-wordld-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("HelloWorld, %s", name));
    }

    @GetMapping("/hello-world-internationalized")
    public String helloWorldInternationalized(
            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
        return messageSource.getMessage("greeting.message", null, locale);
    }

}
