package hr.stanblog.stanblog.dto;

import hr.stanblog.stanblog.model.Discussion;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class VotingDto {

    private String title;

    private String pozitiveAnswerLabel;

    private String negativeAnswerLabel;

    private Long discussionId;

    public VotingDto(String title, String pozitiveAnswerLabel, String negativeAnswerLabel, Long discussionId) {
        this.title = title;
        this.pozitiveAnswerLabel = pozitiveAnswerLabel;
        this.negativeAnswerLabel = negativeAnswerLabel;
        this.discussionId = discussionId;
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
