package com.tkhts.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tkhts.exception.GotTooDrunkException;
import com.tkhts.service.PartyPeople;

/**  
 * @author http://java-sample-program.blogspot.in/  
 */  
@Component
@Aspect  
@Order(value=4) 
public class AfterThrowingPartyAspect {  

    /**  
      * Advice to send thank You Email to all guests, irrespective of whether they were   
      * too drunk or not.  
      * @param joinPoint  
      */  
     @AfterThrowing(value="(execution(* com.tkhts.service.*.*(..)))", throwing="exception")  
     public void callCabForDrunkGuests(JoinPoint joinPoint, Exception exception) {  

          if (exception instanceof GotTooDrunkException) {  
                    // get method arguments   
                    Object[] args = joinPoint.getArgs();  

                    // getting the method argument using Joinpoint API  
                    PartyPeople partyPeople = (PartyPeople)args[0];  
                    System.out.println(partyPeople.getName()+" got too drunk. Calling cab!!");  
          }   
          // No need to handle NotOnListException as exceptions thrown by @Before advice never come to @AfterThrowing  
     }  
}  