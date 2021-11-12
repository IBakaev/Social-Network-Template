package com.example.in100gramm.Annotations;

import com.example.in100gramm.payload.Request.SignUpRequest;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatches.PasswordMatchesValidator.class)
@Documented
public @interface PasswordMatches {
    String message() default "Password don't match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


    public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object>
    {
        @Override
        public void initialize(PasswordMatches constraintAnnotation) {}

        @Override
        public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
        {
            SignUpRequest signUpRequest = (SignUpRequest) o;
            return signUpRequest.getPassword().equals(signUpRequest.getConfirmPassword());
        }
    }

}
