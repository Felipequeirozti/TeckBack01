package br.com.fujideia.iesp.tecback.validation.impl;

import br.com.fujideia.iesp.tecback.validation.base.AtorBase;
import br.com.fujideia.iesp.tecback.validation.valid.ValidAtor;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AtorValidator implements ConstraintValidator<ValidAtor, String> {

    @Override
    public boolean isValid(String nomeAtor, ConstraintValidatorContext context) {
        if (nomeAtor == null || nomeAtor.isEmpty()) {
            return true;
        }
        boolean isValid = AtorBase.isAtorValido(nomeAtor);
        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    String.format("O nome do ator '%s' informado não é válido.", nomeAtor)
            ).addConstraintViolation();
        }
        return isValid;
    }
}
