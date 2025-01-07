package hr.stanblog.stanblog.service;

import hr.stanblog.stanblog.dao.*;
import hr.stanblog.stanblog.dto.*;
import hr.stanblog.stanblog.model.*;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final DiscussionVisibilityRepository discussionVisibilityRepository;
    private final UserApartmentBuildingRepository userApartmentBuildingRepository;
    private final UserRepository userRepository;
    private final ApartmentBuildingRepository apartmentBuildingRepository;
    private final  CommentRepository commentRepository;
    private final VotingRepository votingRepository;
    private final UserVotingRepository userVotingRepository;

    public DiscussionService(DiscussionRepository discussionRepository, DiscussionVisibilityRepository discussionVisibilityRepository, UserApartmentBuildingRepository userApartmentBuildingRepository, UserRepository userRepository, ApartmentBuildingRepository apartmentBuildingRepository, CommentRepository commentRepository, VotingRepository votingRepository, UserVotingRepository userVotingRepository) {
        this.discussionRepository = discussionRepository;
        this.discussionVisibilityRepository = discussionVisibilityRepository;
        this.userApartmentBuildingRepository = userApartmentBuildingRepository;
        this.userRepository = userRepository;
        this.apartmentBuildingRepository = apartmentBuildingRepository;
        this.commentRepository = commentRepository;
        this.votingRepository = votingRepository;
        this.userVotingRepository = userVotingRepository;
    }

    public List<DiscussionBasicDto> getAllDiscussionsBasic() {
        List<DiscussionBasicDto> discussions = new ArrayList<>();
        discussionRepository.findAll().forEach(discussion -> {
            List<DiscussionVisibility> discussionVisibilities = discussionVisibilityRepository.findAllByDiscussion(discussion);

            List<DiscussionVisibilityDto> discussionVisibilityDtos = new ArrayList<>();
            discussionVisibilities.forEach(discussionVisibility -> {
                discussionVisibilityDtos.add(new DiscussionVisibilityDto(discussionVisibility.getId(), discussionVisibility.isCanUserSeeDiscussion(), discussionVisibility.isCanUserParticipateInDiscussion()));
            });

            discussions.add(new DiscussionBasicDto(discussion.getId(), discussion.getCreatorUser().getId(), discussion.getTitle(), discussion.getDescription(), discussion.getApartmentBuilding().getId(), discussionVisibilityDtos));
        });
        return discussions;
    }

    public DiscussionDto getDiscussionsById(Long id) {
        Discussion discussion = discussionRepository.findById(id).orElse(null);

        if (discussion == null) {
            throw new EntityNotFoundException("Discussion with id " + id + " not found.");
        }

        List<Comment> comments = commentRepository.findAll();
        List<DiscussionVisibility> discussionVisibilities = discussionVisibilityRepository.findAllByDiscussion(discussion);
        Voting voting = votingRepository.findByDiscussionId(discussion.getId());
        AppUser user = discussion.getCreatorUser();
        ApartmentBuilding apartmentBuilding = discussion.getApartmentBuilding();

        UserDto userDto = new UserDto(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUserRole());

        ApartmentBuildingDto apartmentBuildingDto = new ApartmentBuildingDto(apartmentBuilding.getId(), apartmentBuilding.getAddress(), apartmentBuilding.getZipCode(), apartmentBuilding.getCity(), apartmentBuilding.getNumberOfIndividualApartments());

        VotingDto votingDto = new VotingDto(voting.getTitle(), voting.getPozitiveAnswerLabel(), voting.getNegativeAnswerLabel(), voting.getDiscussion().getId());

        List<DiscussionVisibilityDto> discussionVisibilityDtos = new ArrayList<>();
        discussionVisibilities.forEach(discussionVisibility -> {
            discussionVisibilityDtos.add(new DiscussionVisibilityDto(discussionVisibility.getId(), discussionVisibility.isCanUserSeeDiscussion(), discussionVisibility.isCanUserParticipateInDiscussion()));
        });

        List<CommentDto> commentDtos = new ArrayList<>();
        comments.forEach(comment -> {
            AppUser commentAuthor = comment.getAuthor();
            UserDto commentAutherDto = new UserDto(commentAuthor.getFirstName(), commentAuthor.getLastName(), commentAuthor.getEmail(), commentAuthor.getUserRole());
            commentDtos.add(new CommentDto(comment.getId(), commentAutherDto, comment.getContent(), comment.getCreatedAt()));
        });

        List<UserVotingDto> userVotingDtos = new ArrayList<>();

        List<UserVoting> userVotings = userVotingRepository.findUserVotingByVoting(voting);

        userVotings.forEach(userVoting -> {
            userVotingDtos.add(new UserVotingDto( userVoting.isAnswerPozitive(), userVoting.getId()));
        });

        DiscussionDto discussionDto = new DiscussionDto(discussion.getId(), userDto, discussion.getTitle(), discussion.getDescription(), apartmentBuildingDto, discussionVisibilityDtos, votingDto, userVotingDtos, commentDtos);

        return discussionDto;
    }

    public Discussion addNewDiscussion(DiscussionBasicDto newDiscussion) {
        Optional<AppUser> appUserOptional = userRepository.findById(newDiscussion.getCreatorUserId());
        AppUser appUser = appUserOptional.orElse(null);

        Optional<ApartmentBuilding> apartmentBuildingOptional = apartmentBuildingRepository.findById(newDiscussion.getApartmentBuildingId());
        ApartmentBuilding apartmentBuilding = apartmentBuildingOptional.orElse(null);

        if (appUser != null && apartmentBuilding != null) {
            Discussion discussion = new Discussion(appUser, newDiscussion.getTitle(), newDiscussion.getDescription(), apartmentBuilding);
            discussionRepository.save(discussion);

            for (DiscussionVisibilityDto elem : newDiscussion.getVisibilities()) {
                Optional<UserApartmentBuilding> pom2 = userApartmentBuildingRepository.findById(elem.getAppUser());

                if (pom2.isPresent()) {
                    discussionVisibilityRepository.save(new DiscussionVisibility(discussion, appUser, elem.getCanUserSeeDiscussion(), elem.getCanUserParticipateInDiscussion()));
                }
            }
            return discussion;

        } else {
            throw new IllegalArgumentException("Can't add new discussion to a non-existent user.");
        }

    }


}
