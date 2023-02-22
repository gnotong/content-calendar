package tech.notgabs.contentcalendar.model;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;

public record Content(
        @Id
        Integer id,
        @NotEmpty
        String title,
        LocalDateTime createdAt
) {
}
