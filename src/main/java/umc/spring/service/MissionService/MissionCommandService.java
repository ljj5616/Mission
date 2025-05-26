package umc.spring.service.MissionService;

import umc.spring.web.dto.AddMissionDTO;

public interface MissionCommandService {

    Long createMission(Long storeId, AddMissionDTO request);
}
