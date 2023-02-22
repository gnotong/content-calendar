package tech.notgabs.contentcalendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.notgabs.contentcalendar.model.Content;

import java.util.List;

public interface ContentRepository extends JpaRepository<Content, Integer> {
    List<Content> findAllByTitleContainsIgnoreCase(String keyword);
}
