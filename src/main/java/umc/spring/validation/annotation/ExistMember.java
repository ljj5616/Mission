package umc.spring.validation.annotation;

import jakarta.validation.Constraint;
import umc.spring.validation.validator.MemberExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MemberExistValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMember {
}
