package tech.notgabs.contentcalendar.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.notgabs.contentcalendar.model.Content;
import tech.notgabs.contentcalendar.repository.ContentCollectionRepository;
import tech.notgabs.contentcalendar.repository.ContentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contents")
public class ContentController {
    private final ContentRepository repository;
    public ContentController(ContentRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Content>> getAll() {
        List<Content> contents = repository.findAll();

        return new ResponseEntity<>(contents, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Content> getOne(@PathVariable Integer id) {
        Optional<Content> content = repository.findById(id);

        return new ResponseEntity<>(content.orElseGet(() -> null), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody Content content) {
        repository.save(content);
    }

    @GetMapping("/search/{filter}")
    public ResponseEntity<List<Content>> search(@PathVariable("filter") String keyword) {
        List<Content> contents = repository.findAllByTitleContainsIgnoreCase(keyword);
        return new ResponseEntity<>(contents, HttpStatus.OK);
    }
}
