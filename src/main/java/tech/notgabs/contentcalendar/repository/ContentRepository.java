package tech.notgabs.contentcalendar.repository;

import org.springframework.data.repository.ListCrudRepository;
import tech.notgabs.contentcalendar.model.Content;

import java.util.List;

public interface ContentRepository extends ListCrudRepository<Content, Integer> {
    List<Content> findAllByTitleContainsIgnoreCase(String keyword);
}
