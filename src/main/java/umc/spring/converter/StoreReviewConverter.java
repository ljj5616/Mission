package umc.spring.converter;

import org.springframework.data.domain.Page;
<<<<<<< HEAD
import umc.spring.domain.Review;
import umc.spring.web.dto.StoreResponseDTO;
=======
import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreMissionDTO;
>>>>>>> feature/#7-get-store-mission

import java.util.List;
import java.util.stream.Collectors;

public class StoreConverter {

<<<<<<< HEAD
    public static StoreResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review) {
        return StoreResponseDTO.ReviewPreViewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static StoreResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList) {
        List<StoreResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(StoreConverter::reviewPreViewDTO).collect(Collectors.toList());

        return StoreResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
=======
    public static StoreMissionDTO.MissionDTO toMissionDTO(Mission mission) {
        return StoreMissionDTO.MissionDTO.builder()
                .missionId(mission.getId())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .missionSpec(mission.getMissionSpec())
                .build();
    }

    public static StoreMissionDTO.MissionListDTO toMissionListDTO(Page<Mission> missions) {
        List<StoreMissionDTO.MissionDTO> missionDTOList = missions.stream()
                .map(StoreConverter::toMissionDTO)
                .collect(Collectors.toList());

        return StoreMissionDTO.MissionListDTO.builder()
                .missionList(missionDTOList)
                .listSize(missionDTOList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
>>>>>>> feature/#7-get-store-mission
                .build();
    }
}
