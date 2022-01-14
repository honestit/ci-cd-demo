package github.honestit.cicddemo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data 
public class SmallThing {

    @Id
    String id;
    String name;
}