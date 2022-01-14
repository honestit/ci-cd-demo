package github.honestit.cicddemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SmallThingRepository extends JpaRepository<SmallThing, String> {
    
}
