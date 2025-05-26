package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.validation.annotation.NotDuplicateChallenge;
import umc.spring.web.dto.MissionChallengeRequestDTO;

@Component
@RequiredArgsConstructor
public class NotDuplicateChallengeValidator implements ConstraintValidator<NotDuplicateChallenge, MissionChallengeRequestDTO> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(MissionChallengeRequestDTO dto, ConstraintValidatorContext context) {
        if (dto.getMemberId() == null || dto.getMissionId() == null) return false;
        return !memberMissionRepository.existsByMemberIdAndMissionId(dto.getMemberId(), dto.getMissionId());
    }
}
