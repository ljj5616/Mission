package umc.spring.service.storeService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.StoreHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.MissionRepository;
import umc.spring.repository.storeRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreMissionQueryServiceImpl implements StoreMissionQueryService {

    private final StoreRepository storeRepository;
    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMissionsByStore(Long storeId, Integer page) {
            Store store = storeRepository.findById(storeId)
                    .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

            return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }
}
