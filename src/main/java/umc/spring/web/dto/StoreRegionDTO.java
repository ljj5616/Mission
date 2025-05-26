package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistRegion;

@Getter
@NoArgsConstructor
public class StoreRegionDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @ExistRegion
    private Long regionId;
}
