package br.com.meetup.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@ComponentScan("br.com.meetup")
@EntityScan("br.com.meetup")
@EnableJpaRepositories
@SpringBootApplication
public class SampleMeetup13Application {

	public static void main(String[] args) {
		SpringApplication.run(SampleMeetup13Application.class, args);
	}
}
