package com.tkhts.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tkhts.service.PartyPeople;

/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  
@Order(5) 
public class AfterReturningPartyAspect {  
     /**  
      * Advice to give party gift to guests who came out without getting too drunk.  
      * @param joinPoint  
      */  
     @AfterReturning(value="(execution(* com.tkhts.service.*.*(..)))")  
     public void givePartyGift(JoinPoint joinPoint) {  
          // get method arguments   
          Object[] args = joinPoint.getArgs();  
         
          // getting the method argument using Joinpoint API  
          PartyPeople partyPeople = (PartyPeople)args[0];  
         
          System.out.println(partyPeople.getName()+" got party gift.");  
     }  
}  