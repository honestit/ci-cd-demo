package github.honestit.cicddemo;

import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CiCdDemoApplication {

	@Autowired
	SmallThingRepository smallThingRepository;

	public static void main(String[] args) {
		SpringApplication.run(CiCdDemoApplication.class, args);
	}

	@PostConstruct
	void setUpData() {
		smallThingRepository.save(SmallThing.builder().id(UUID.randomUUID().toString()).name("first").build());
		smallThingRepository.save(SmallThing.builder().id(UUID.randomUUID().toString()).name("second").build());
		smallThingRepository.save(SmallThing.builder().id(UUID.randomUUID().toString()).name("third").build());
	}

}
