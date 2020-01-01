package com.ztx.voladitor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

//自定义注解类
@Target({ElementType.METHOD,ElementType.FIELD})//标识注释到哪里，方法和字段
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Constraint(validatedBy=MyConstraintValidation.class)//注解执行的校验类
public @interface MyConstraint {
	//这三个方法必须要有
	String message();//提示信息

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
