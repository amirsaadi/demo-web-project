package com.amir.validator;

import com.amir.entities.BlogUser;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


/**
 * Created by Amir on 2016-11-29.
 * spring-weblog
 */
@Component
public class BloggerValidator implements Validator{
    @Override
    public boolean supports(Class<?> clazz) {
        return BlogUser.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
           BlogUser user =(BlogUser) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "blogger.password","short");
        }
    }

}
