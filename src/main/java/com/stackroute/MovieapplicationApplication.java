package com.stackroute;

//import com.stackroute.seeder.DataSeeder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieapplicationApplication.class, args);
	}


}
