package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionDTO.ChallengingMissionDTO toChallengingMissionDTO(MemberMission memberMission) {
        Mission mission = memberMission.getMission();
        return MemberMissionDTO.ChallengingMissionDTO.builder()
                .missionId(mission.getId())
                .missionSpec(mission.getMissionSpec())
                .reward(mission.getReward())
                .deadline(mission.getDeadline())
                .storeName(mission.getStore().getName())
                .build();
    }

    public static MemberMissionDTO.ChallengingMissionListDTO toChallengingMissionListDTO(Page<MemberMission> missions) {
        List<MemberMissionDTO.ChallengingMissionDTO> dtoList = missions.stream()
                .map(MemberMissionConverter::toChallengingMissionDTO)
                .collect(Collectors.toList());

        return MemberMissionDTO.ChallengingMissionListDTO.builder()
                .missionList(dtoList)
                .listSize(dtoList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
