package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.authentication.HttpStatusEntryPoint;
// import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableWebSecurity
@RestController
public class DemoApplication{
    public static void main(String[] args) {
      SpringApplication.run(DemoApplication.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }

    
    // @Configuration
    // @EnableWebSecurity
    // public class WebSecurityConfig extends WebSecurityConfigurer<HttpSecurity> {
    //     @Override
    //     public void configure(HttpSecurity http) throws Exception {
    //         http
    //             .authorizeRequests()
    //                 .anyRequest().authenticated()
    //                 .and()
    //             .exceptionHandling()
    //                 .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    //     }
    // }
}
