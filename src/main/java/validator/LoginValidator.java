package validator;

import domain.Login;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Login.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Login login = (Login) target;
        ValidationUtils.rejectIfEmpty(errors, "id", "required");
        ValidationUtils.rejectIfEmpty(errors, "password", "required");
    }
}
