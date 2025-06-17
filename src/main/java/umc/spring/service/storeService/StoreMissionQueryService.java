package umc.spring.service.storeService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;

public interface StoreMissionQueryService {
    Page<Mission> getMissionsByStore(Long storeId, Integer page);
}
