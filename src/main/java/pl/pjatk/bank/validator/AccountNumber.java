package pl.pjatk.bank.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = AccountNumberValidator.class)
public @interface AccountNumber {

    public String someName() default "";

    String message() default "Invalid account number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

