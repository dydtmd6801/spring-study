package validator;

import domain.Register;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistValidator implements Validator {

    private static final String idRegExp = "/[ㄱ-힣]/";
    private Pattern pattern;

    public RegistValidator() {
        this.pattern = Pattern.compile(idRegExp);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Register.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Register register = (Register) target;
        if(register.getUserId() == null || register.getUserId().trim().isEmpty()) {
            errors.rejectValue("id", "required");
        } else {
            Matcher matcher = pattern.matcher(register.getUserId());
            if(!matcher.matches()) {
                errors.rejectValue("id","bad");
            }
        }
        ValidationUtils.rejectIfEmpty(errors, "password","required");
        ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
        ValidationUtils.rejectIfEmpty(errors, "nickName", "required");
        ValidationUtils.rejectIfEmpty(errors, "email", "required");
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "required");
    }
}
