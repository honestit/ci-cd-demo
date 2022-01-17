package github.honestit.cicddemo;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@RestController
@RequestMapping("/api/smallthings")
public class SmallThingRestController {

    @Autowired
    SmallThingRepository smallThingRepository;

    @GetMapping
    public List<SmallThing> get() {
        return smallThingRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        return smallThingRepository.findById(id)
                .map(smallThing -> ResponseEntity.ok(smallThing))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> post(@RequestBody SmallThing smallThing) {
        smallThing.setId(UUID.randomUUID().toString());
        smallThingRepository.save(smallThing);
        return ResponseEntity.created(MvcUriComponentsBuilder.fromController(SmallThingRestController.class)
                .path("/{id}").buildAndExpand(smallThing.getId()).toUri()).build();

    }
}
