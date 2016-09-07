package com.tkhts.aspect;

import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tkhts.service.PartyPeople;

/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  
@Order(value=2) 
public class AroundPartyAspect {  
     /**  
      * Advice to log entering and exit of guests.  
      * @param proceedingJoinPoint  
      * @throws Throwable   
      */  
     @Around(value="(execution(* com.tkhts.service.*.*(..)))")  
     public void audit(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {  

          // get method arguments   
          Object[] args = proceedingJoinPoint.getArgs();  

          // getting the method argument using Joinpoint API  
          PartyPeople partyPeople = (PartyPeople)args[0];  
          
          //auditing entry and exit  
          System.out.println(partyPeople.getName()+" came in at "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE));  
          
          try {  
               proceedingJoinPoint.proceed();  
          } finally {  
               // exit time kept in finally block so that even if there is any exception from method  
               // the exit time still gets audited  
               System.out.println(partyPeople.getName()+" left at "+Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE));  
          }  
     }  
}  