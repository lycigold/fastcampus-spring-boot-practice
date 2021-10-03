package com.fastcampus.springbootpractice;

import com.fastcampus.springbootpractice.controller.MainController;
import com.fastcampus.springbootpractice.properties.MyProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication(
//        exclude = WebMvcAutoConfiguration.class
//        excludeName = "org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration"
//        scanBasePackages = {"com.fastcampus.springbootpractice"},
//        scanBasePackageClasses = {MainController.class},
//        nameGenerator = BeanNameGenerator.class,
//        proxyBeanMethods = true
)
public class SpringbootPracticeApplication {



    private final Integer height;
    private final Environment environment;
    private final ApplicationContext applicationContext;
    //Java Configuration
    private final MyProperties myProperties;

    public SpringbootPracticeApplication(
            @Value("${my.height}") Integer height,
            Environment environment,
            ApplicationContext applicationContext,
            MyProperties myProperties
            ) {
        this.height = height;
        this.environment = environment;
        this.applicationContext = applicationContext;
        this.myProperties = myProperties;
    }


    public static void main(String[] args) {
        SpringApplication.run(SpringbootPracticeApplication.class, args);
    }

    @PostConstruct
    public void init() {
        System.out.println("[@Value] " + height);
        System.out.println("[Environment] " + environment.getProperty("my.height"));
        System.out.println("[ApplicationContext] " + applicationContext.getEnvironment().getProperty("my.height"));
        System.out.println("[configurationProps] " + myProperties.getHeight());
    }



}
