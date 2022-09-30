package App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
Spring Boot is NOT the same as Spring
We could use Spring without Boot if we set up a bean factory or applicationcontext ourselves, we can take beans
from the context and run them manually
SpringBootApplication introduces auto configuration: it scans the package it belongs to for components, sets up
the IOC container, and runs Controllers automatically
*/
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

}
