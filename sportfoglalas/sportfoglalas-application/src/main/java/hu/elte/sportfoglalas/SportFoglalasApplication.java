package hu.elte.sportfoglalas;

import hu.elte.sportfoglalas.application.service.TestDataGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SportFoglalasApplication {


//	private final int currentUserId = 20;
//
//	public int getCurrentUserId() {
//		return currentUserId;
//	}



	@Autowired
	private TestDataGenerator testDataGenerator;

	@Autowired
	private SportFoglalasApplication sportFoglalasApplication;


	public static void main(String[] args) {
		SpringApplication.run(SportFoglalasApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			testDataGenerator.createTestData();

		};
	}


}
