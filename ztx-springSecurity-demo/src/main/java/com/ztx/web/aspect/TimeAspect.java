package com.ztx.web.aspect;

import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect//aop面向切片  注解（在哪些方法和实体类上使用）   方法增强（增强方法执行哪些操作  before after ）
@Component
public class TimeAspect {
	//表达式：* 所有返回值  指定controler .*该controller所有方法 （..）所有参数
	@Around("execution(* com.ztx.web.controller.UserController.*(..))")//包围方式执行
	public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("time around  start");
		Object [] args = pjp.getArgs();//通过此方法获取返回值
		for(Object arg : args ) {
			System.out.println("arg is :"+arg);
		}
		long start = new Date().getTime();
		
		Object obj = pjp.proceed();//此方法主要功能为获取在执行的方法信息
		
		System.out.println("time around end " +(new Date().getTime() - start));
		
		return obj;
	}
	
	
	
	
}
