package com.ztx.voladitor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
//实现接口，自动注入为bean
public class MyConstraintValidation implements ConstraintValidator<MyConstraint, Object> {//绑定注解，指定类型

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		//指定的逻辑
		System.out.println("执行指定的逻辑，false校验不过，true校验通过");
		System.out.println("value"+value);
		System.out.println("context"+context);
		return false;
	}


}
