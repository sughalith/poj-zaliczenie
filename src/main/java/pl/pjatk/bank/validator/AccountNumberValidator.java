package pl.pjatk.bank.validator;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class AccountNumberValidator implements ConstraintValidator<AccountNumber, String> {

    private static final String NUMBERS_REGEX = "[0-9]+";

    @Override
    public void initialize(AccountNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() == 26 && Pattern.matches(NUMBERS_REGEX, s);
    }
}
