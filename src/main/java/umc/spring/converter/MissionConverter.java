package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.AddMissionDTO;

public class MissionConverter {

    public static Mission toEntity(AddMissionDTO dto, Store store) {
        return Mission.builder()
                .reward(dto.getReward())
                .deadline(dto.getDeadline())
                .missionSpec(dto.getMissionSpec())
                .store(store)
                .build();
    }
}
