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
		smallThingRepository.save(new SmallThing(UUID.randomUUID().toString(), "first"));
		smallThingRepository.save(new SmallThing(UUID.randomUUID().toString(), "second"));
		smallThingRepository.save(new SmallThing(UUID.randomUUID().toString(), "third"));
	}

}
