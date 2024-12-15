package hr.stanblog.stanblog.service.impl;

import hr.stanblog.stanblog.dao.DiscussionRepository;
import hr.stanblog.stanblog.dao.UserVotingRepository;
import hr.stanblog.stanblog.dao.VotingRepository;
import hr.stanblog.stanblog.dto.UserVotingDto;
import hr.stanblog.stanblog.dto.VotingDto;
import hr.stanblog.stanblog.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VotingService {

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private DiscussionRepository discussionRepository;

    @Autowired
    private UserVotingRepository userVotingRepository;

    public Voting saveVoting(VotingDto votingDto) {
        Optional<Discussion> discussionOptional = discussionRepository.findById(votingDto.getDiscussionId());
        Discussion discussion = discussionOptional.orElse(null);

        if (discussion == null) {
            throw new IllegalArgumentException("Discussion not found.");
        }

        Voting voting = new Voting(
                votingDto.getTitle(),
                votingDto.getPozitiveAnswerLabel(),
                votingDto.getNegativeAnswerLabel(),
                discussion
        );
        return votingRepository.save(voting);
    }

    public void saveVote(Long votingId, UserVotingDto userVotingDto) {
        Optional<Voting> votingOptional = votingRepository.findById(votingId);
        Voting voting = votingOptional.orElse(null);

        if (voting == null) {
            throw new IllegalArgumentException("Voting with id " + votingId + " not found.");
        }

        UserVoting userVoting = new UserVoting(votingId, userVotingDto.isAnswerPozitive());

        userVotingRepository.save(userVoting);
    }
}
