package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.spring.validation.validator.NotDuplicateChallengeValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NotDuplicateChallengeValidator.class)
@Target(ElementType.TYPE) // 전체 DTO 클래스에 붙임
@Retention(RetentionPolicy.RUNTIME)
public @interface NotDuplicateChallenge {

    String message() default "이미 도전 중인 미션입니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
