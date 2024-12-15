package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.DiscussionRepository;
import hr.stanblog.stanblog.dto.DiscussionDto;
import hr.stanblog.stanblog.model.Discussion;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository discussionRepository){
        this.discussionRepository = discussionRepository;
    }

    public List<Discussion> getAllDiscussions(){
        return discussionRepository.findAll();
    }

    public boolean addNewDiscussion(DiscussionDto DTO) {
        discussionRepository.save(new Discussion(DTO.getCreatorUserId(), DTO.getTitle(), DTO.getDescription(), DTO.getApartmentBuildingId()));


        return false;

    }


}
