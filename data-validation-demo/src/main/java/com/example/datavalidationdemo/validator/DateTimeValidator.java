package com.example.datavalidationdemo.validator;

import com.example.datavalidationdemo.annotation.Datetime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.SimpleTimeZone;

public class DateTimeValidator implements ConstraintValidator<Datetime,String> {
    private Datetime datetime;

    @Override
    public void initialize(Datetime datetime){
        this.datetime = datetime;
    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //如果value为空则不进行格式验证，为空验证可以使用@NotBlank @Not null @Not Empty等注解来进行控制，职责分离
        if(value == null){
            return true;
        }
        String format = datetime.format();
        if(value.length() != format.length()){
            return false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        try{
            simpleDateFormat.parse(value);
        }catch (ParseException e){
            return false;
        }
        return true;
    }
}
