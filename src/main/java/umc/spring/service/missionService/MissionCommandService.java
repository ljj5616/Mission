package umc.spring.service.missionService;

import umc.spring.web.dto.AddMissionDTO;

public interface MissionCommandService {

    Long createMission(Long storeId, AddMissionDTO request);
}
