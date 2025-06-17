package umc.spring.validation.annotation;

import jakarta.validation.Payload;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.annotation.*;

@Documented
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPage {

    String message() default "페이지 범위가 너무 작습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
