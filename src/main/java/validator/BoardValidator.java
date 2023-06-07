package validator;

import domain.Board;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class BoardValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors,"boardTitle","required");
        ValidationUtils.rejectIfEmpty(errors,"boardContent","required");
    }
}
