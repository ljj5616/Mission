package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.web.dto.StoreMissionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class StoreMissionConverter {

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
                .map(StoreMissionConverter::toMissionDTO)
                .collect(Collectors.toList());

        return StoreMissionDTO.MissionListDTO.builder()
                .missionList(missionDTOList)
                .listSize(missionDTOList.size())
                .totalPage(missions.getTotalPages())
                .totalElements(missions.getTotalElements())
                .isFirst(missions.isFirst())
                .isLast(missions.isLast())
                .build();
    }
}
