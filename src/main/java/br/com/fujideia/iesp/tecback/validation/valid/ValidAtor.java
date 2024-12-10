package br.com.fujideia.iesp.tecback.validation.valid;

import br.com.fujideia.iesp.tecback.validation.impl.AtorValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = AtorValidator.class)
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAtor {
    String message() default "O nome do ator informado não é válido.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
