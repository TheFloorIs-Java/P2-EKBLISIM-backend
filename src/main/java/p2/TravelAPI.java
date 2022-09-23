package p2;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TravelAPI {
    public static void main(String[] args) {
        SpringApplication.run(TravelAPI.class);
    }

//    @Bean
//    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//        return args -> {
//            System.out.println("Let's inspect the beans")
//        }
//    }
}
