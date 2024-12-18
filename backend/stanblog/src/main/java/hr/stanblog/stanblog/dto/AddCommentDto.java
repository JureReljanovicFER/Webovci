package hr.stanblog.stanblog.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class AddCommentDto {


    private Long discussionId;

    private String content;

    private Long userId;

    public AddCommentDto(Long userId, String content, Long discussionId) {
        this.userId = userId;
        this.content = content;
        this.discussionId = discussionId;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
