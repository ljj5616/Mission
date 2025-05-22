package umc.spring.service.MissionService;

import umc.spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Long createMission(Long storeId, MissionRequestDTO request);
}
