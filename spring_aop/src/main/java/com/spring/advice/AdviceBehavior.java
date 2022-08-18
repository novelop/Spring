package com.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

public class AdviceBehavior {
	public void chikachika() {
	      System.out.println("치카포카");
	   }
	   
	   
	   // joinpoint : around 
	   public void chikachikaAround(ProceedingJoinPoint joinPoint)throws Throwable{
	      
	      System.out.println("한번 닦았다.");
	      
	      joinPoint.proceed();
	      
	      System.out.println("그만 닦아!!");
	      
	   }
}
