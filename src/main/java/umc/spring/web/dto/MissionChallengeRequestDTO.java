package umc.spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.validation.annotation.ExistMember;
import umc.spring.validation.annotation.ExistMission;
import umc.spring.validation.annotation.NotDuplicateChallenge;

@Getter
@NoArgsConstructor
@NotDuplicateChallenge
public class MissionChallengeRequestDTO {

    @NotNull
    @ExistMember
    private Long memberId;

    @NotNull
    @ExistMission
    private Long missionId;
}
