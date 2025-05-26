package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRegionDTO;

public interface StoreCommandService {
    Long registerStore(StoreRegionDTO request);
}
