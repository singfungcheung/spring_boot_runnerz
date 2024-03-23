package dev.singfung.runnerz;

import dev.singfung.runnerz.run.Location;
import dev.singfung.runnerz.run.Run;
import dev.singfung.runnerz.run.RunRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(ApplicationContext.class);
	public static void main(String[] args) {

		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Testing!");
	}

//	@Bean
//	CommandLineRunner runner(RunRepository runRepository) {
//		return args -> {
//			Run run = new Run(1, "First Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5, Location.OUTDOOR);
//			runRepository.create(run);
//			log.info("Run: " + run);
//		};
//	}

}
