package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.DiscussionRepository;
import hr.stanblog.stanblog.model.Discussion;

import java.util.List;

public class DiscussionService {

    private final DiscussionRepository discussionRepository;

    public DiscussionService(DiscussionRepository discussionRepository){
        this.discussionRepository = discussionRepository;
    }

    public List<Discussion> getAllDiscussions(){
        return discussionRepository.findAll();
    }
}
