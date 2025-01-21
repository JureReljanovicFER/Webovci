package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.Discussion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class VotingDto {

    private Long id;

    private String title;

    private String pozitiveAnswerLabel;

    private String negativeAnswerLabel;

    private Long discussionId;

    public VotingDto(Long id, String title, String pozitiveAnswerLabel, String negativeAnswerLabel, Long discussionId) {
        this.id = id;
        this.title = title;
        this.pozitiveAnswerLabel = pozitiveAnswerLabel;
        this.negativeAnswerLabel = negativeAnswerLabel;
        this.discussionId = discussionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPozitiveAnswerLabel() {
        return pozitiveAnswerLabel;
    }

    public void setPozitiveAnswerLabel(String pozitiveAnswerLabel) {
        this.pozitiveAnswerLabel = pozitiveAnswerLabel;
    }

    public String getNegativeAnswerLabel() {
        return negativeAnswerLabel;
    }

    public void setNegativeAnswerLabel(String negativeAnswerLabel) {
        this.negativeAnswerLabel = negativeAnswerLabel;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }
}
