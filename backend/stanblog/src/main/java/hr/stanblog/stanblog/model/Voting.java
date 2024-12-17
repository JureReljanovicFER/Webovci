package hr.stanblog.stanblog.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Voting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String pozitiveAnswerLabel;

    private String negativeAnswerLabel;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<UserVoting> userVotings;

    @OneToOne
    private Discussion discussion;

    public Voting(String title, String pozitiveAnswerLabel, String negativeAnswerLabel, Discussion discussion) {
        this.title = title;
        this.pozitiveAnswerLabel = pozitiveAnswerLabel;
        this.negativeAnswerLabel = negativeAnswerLabel;
        this.discussion = discussion;
    }

    public Voting() {

    }

    public Discussion getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Discussion discussion) {
        this.discussion = discussion;
    }

    public String getNegativeAnswerLabel() {
        return negativeAnswerLabel;
    }

    public void setNegativeAnswerLabel(String negativeAnswerLabel) {
        this.negativeAnswerLabel = negativeAnswerLabel;
    }

    public String getPozitiveAnswerLabel() {
        return pozitiveAnswerLabel;
    }

    public void setPozitiveAnswerLabel(String pozitiveAnswerLabel) {
        this.pozitiveAnswerLabel = pozitiveAnswerLabel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
