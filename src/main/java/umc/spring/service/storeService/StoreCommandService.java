package umc.spring.service.storeService;

import umc.spring.web.dto.StoreRegionDTO;

public interface StoreCommandService {
    Long registerStore(StoreRegionDTO request);
}
