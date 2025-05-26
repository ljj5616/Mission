package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MissionChallengeRequestDTO {

    @NotNull
    private Long memberId;

    @NotNull
    private Long missionId;
}
