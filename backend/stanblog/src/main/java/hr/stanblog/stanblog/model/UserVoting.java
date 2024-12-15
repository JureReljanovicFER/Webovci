package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

@Entity
@Table
public class UserVoting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean answerPozitive;

    public UserVoting(Long id, boolean answerPozitive) {
        this.id = id;
        this.answerPozitive = answerPozitive;
    }

    public UserVoting() {

    }

    public boolean isAnswerPozitive() {
        return answerPozitive;
    }

    public void setAnswerPozitive(boolean answerPozitive) {
        this.answerPozitive = answerPozitive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
