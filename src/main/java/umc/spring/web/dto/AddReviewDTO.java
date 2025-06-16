package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistStore;

@Getter
@NoArgsConstructor
public class AddReviewDTO {

    @NotBlank
    private String content;

    @NotNull
    @Min(0)
    @Max(5)
    private Float score;

    @NotNull
    @ExistMember
    private Long memberId;

    @NotNull
    @ExistStore
    private Long storeId;
}
