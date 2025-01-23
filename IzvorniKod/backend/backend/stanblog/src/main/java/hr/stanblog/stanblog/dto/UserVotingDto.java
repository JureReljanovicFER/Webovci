package hr.stanblog.stanblog.dto;

public class UserVotingDto {

    private Long userId;
    private boolean answerPozitive;

    public UserVotingDto(boolean answerPozitive, Long userId) {
        this.answerPozitive = answerPozitive;
        this.userId = userId;
    }

    public boolean isAnswerPozitive() {
        return answerPozitive;
    }

    public void setAnswerPozitive(boolean answerPozitive) {
        this.answerPozitive = answerPozitive;
    }

    public Long getUserId() {
        return userId;
    }
}
