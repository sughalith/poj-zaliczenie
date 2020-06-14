package pl.pjatk.shop.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class ShopNameValidator implements ConstraintValidator<ShopName, String> {

    private static final String LETTERS_REGEX = "[a-zA-Z]+";


    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() >= 6 && Pattern.matches(LETTERS_REGEX, s);
    }
}
