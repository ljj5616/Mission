package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;

@Getter
@NoArgsConstructor
public class MissionChallengeRequestDTO {
    @NotNull
    @ExistMember
    private Long memberId;

    @NotNull
    @ExistMission
    private Long missionId;
}
