package umc.spring.service.StoreService;

import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Long registerStore(StoreRequestDTO request);
}
