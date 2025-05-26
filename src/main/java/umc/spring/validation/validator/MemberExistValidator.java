package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MemberRepository;
import umc.spring.validation.annotation.ExistMember;

@Component
@RequiredArgsConstructor
public class MemberExistValidator implements ConstraintValidator<ExistMember, Long> {

    private final MemberRepository memberRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) return false;
        return memberRepository.existsById(value);
    }
}
