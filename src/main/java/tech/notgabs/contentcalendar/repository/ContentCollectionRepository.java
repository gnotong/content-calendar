package tech.notgabs.contentcalendar.repository;

import org.springframework.stereotype.Repository;
import tech.notgabs.contentcalendar.model.Content;

import java.util.*;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contents = new ArrayList<>();

    public List<Content> findAll() {
        return contents;
    }

    public void save(Content content) {
        contents.add(content);
    }

    public Content findById(Integer id) {
        return contents.stream().filter(c -> c.getId().equals(id)).findFirst().orElseThrow(() -> new NoSuchElementException("Content " + id + " not found"));
    }
}
