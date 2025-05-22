package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import umc.spring.validation.annotation.ExistRegion;

@Getter
@NoArgsConstructor
public class StoreRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String address;

    @ExistRegion
    private Long regionId;
}
