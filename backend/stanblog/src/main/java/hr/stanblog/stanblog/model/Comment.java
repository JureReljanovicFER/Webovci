package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Comment {
    @Id
     Long id;

    @ManyToOne
    private Discussion discussion;

    @ManyToOne
    private AppUser author;

    @ManyToOne
    private Comment parentComment;

    private String content;

    private final LocalDateTime createdAt = LocalDateTime.now();
}
