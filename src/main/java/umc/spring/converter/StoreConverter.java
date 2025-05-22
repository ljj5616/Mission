package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;

public class StoreConverter {

    public static Store toEntity(StoreRequestDTO dto, Region region) {
        return Store.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .region(region)
                .build();
    }
}
