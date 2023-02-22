package tech.notgabs.contentcalendar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Component;
import tech.notgabs.contentcalendar.model.Content;
import tech.notgabs.contentcalendar.repository.ContentRepository;

import java.io.InputStream;
import java.util.List;

@Component
public class DatabaseLoader implements CommandLineRunner {
    private final ContentRepository repository;
    private final ObjectMapper objectMapper;

    public DatabaseLoader(ContentRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            try(InputStream inputStream = TypeReference.class.getResourceAsStream("/data/content.json")) {
                repository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Content>>(){}));
            }
        }
    }
}
