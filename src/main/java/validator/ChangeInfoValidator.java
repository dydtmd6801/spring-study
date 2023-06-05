package validator;

import domain.ChangeInfo;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ChangeInfoValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return ChangeInfo.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "required");
    }
}
