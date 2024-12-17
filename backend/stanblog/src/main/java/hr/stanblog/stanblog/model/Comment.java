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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
