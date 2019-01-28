package com.bear.blogvillage.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyContraint implements ConstraintValidator<MyAnno,Object> {
    @Override
    public void initialize(MyAnno constraintAnnotation) {
        System.out.println("initizlize===============");
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if(String.valueOf(object).length()<5){
            return false;
        }
        return true;
    }
}
