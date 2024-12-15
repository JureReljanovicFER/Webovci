package hr.stanblog.stanblog.dto;

public class UserVotingDto {

    private boolean answerPozitive;

    public UserVotingDto(boolean answerPozitive) {
        this.answerPozitive = answerPozitive;
    }

    public boolean isAnswerPozitive() {
        return answerPozitive;
    }

    public void setAnswerPozitive(boolean answerPozitive) {
        this.answerPozitive = answerPozitive;
    }
}
