package hr.stanblog.stanblog.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class CommentDto {

    private Long id;

    private UserDto author;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    public CommentDto(Long id, UserDto author, String content, LocalDateTime createdAt) {
        this.id = id;
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public CommentDto( UserDto author, String content, LocalDateTime createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
