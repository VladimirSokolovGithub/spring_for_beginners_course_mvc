package spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckEmailValidator implements ConstraintValidator<CheckEmail, String> {

    private String endOfEmail; //эта переменная будет содержать хвост нашего email после собачки.

    //параметр метода initialize это наша аннотация
    @Override
    public void initialize(CheckEmail checkEmail) {
        endOfEmail = checkEmail.value(); //получили конец нашего email из аннотации.
    }

    //В этом методе будет происходить проверка нашего бизнес правила.
    //enteredValue - это то значение, которое будет вводиться в нашу форму email.
    //Вторым параметром constraintValidatorContext мы пользоваться не будем.
    @Override
    public boolean isValid(String enteredValue, ConstraintValidatorContext constraintValidatorContext) {
        return enteredValue.endsWith(endOfEmail);
    }
}

//00-11-50
