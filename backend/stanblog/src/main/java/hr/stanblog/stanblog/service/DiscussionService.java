package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.DiscussionRepository;
import hr.stanblog.stanblog.dao.UserApartmentBuildingRepository;
import hr.stanblog.stanblog.dao.UserDiscussionRepository;
import hr.stanblog.stanblog.dto.DiscussionDto;
import hr.stanblog.stanblog.model.Discussion;
import hr.stanblog.stanblog.model.UserApartmentBuilding;
import hr.stanblog.stanblog.model.UserDiscussion;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final UserDiscussionRepository userDiscussionRepository;
    private final UserApartmentBuildingRepository userApartmentBuildingRepository;


    public DiscussionService(DiscussionRepository discussionRepository, UserDiscussionRepository userDiscussionRepository, UserApartmentBuildingRepository userApartmentBuildingRepository) {
        this.discussionRepository = discussionRepository;
        this.userDiscussionRepository = userDiscussionRepository;
        this.userApartmentBuildingRepository = userApartmentBuildingRepository;
    }

    public List<Discussion> getAllDiscussions() {
        return discussionRepository.findAll();
    }

    public boolean addNewDiscussion(DiscussionDto DTO) {
        Discussion pom = discussionRepository.save(new Discussion(DTO.getCreatorUserId(), DTO.getTitle(), DTO.getDescription(), DTO.getApartmentBuildingId()));
        for (DiscussionDto.Visibility elem : DTO.getVisibilities()) {
            Optional<UserApartmentBuilding> pom2 = userApartmentBuildingRepository.findById(elem.getUserId());

            if (pom2.isPresent()) {
                userDiscussionRepository.save(new UserDiscussion(pom2.get(), pom, elem.isCanUserSee(), elem.isCanUserParticipate()));
            }
        }


        return true;

    }


}
