package hr.stanblog.stanblog.service.impl;

import hr.stanblog.stanblog.dao.VotingRepository;
import hr.stanblog.stanblog.dto.ApartmentBuildingDto;
import hr.stanblog.stanblog.dto.VotingDto;
import hr.stanblog.stanblog.model.ApartmentBuilding;
import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.model.Voting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotingService {

    @Autowired
    private VotingRepository votingRepository;

    @Autowired
    private DIscussionRepository discussionRepository;

    public Voting saveVoting(VotingDto votingDto) {
        Discussion discussion = discussionRepository.getById(votingDto.getDiscussionDto().getId());

        Voting voting = new Voting(
                votingDto.getTitle(),
                votingDto.getPozitiveAnswerLabel(),
                votingDto.getNegativeAnswerLabel(),
                discussion
        );
        return votingRepository.save(voting);
    }
}
