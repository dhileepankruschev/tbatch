package com.tkhts.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.tkhts.exception.NotOnListException;
import com.tkhts.service.PartyPeople;


@Component
@Aspect
@Order(value=1) 
public class BeforePartyAspect {  
    /**  
     * Advice to log entering and exit of guests.  
     * @param proceedingJoinPoint  
     */  
	
	public BeforePartyAspect(){
		
	}
	
	@Before("execution(* com.tkhts.service.PartyServiceImpl.*(..))")  
	 public void checkGuestList(JoinPoint joinPoint) throws NotOnListException {  
	 	
//	 	System.out.println("Should be called");
	 	
	      // get method arguments   
	      Object[] args = joinPoint.getArgs();  
	      
	      // getting the method argument using Joinpoint API  
	      PartyPeople partyPeople = (PartyPeople)args[0];  
	      
	      boolean onGuestList = false;  
	      // checking guest list  
	      for (int i = 0; i < partyPeoples.length; i++) {  
	           if (partyPeople.getName().equals(partyPeoples[i].getName())) {  
	                onGuestList = true;  
	                break;  
	           }  
	      }  
	      
	      if (!onGuestList) {  
	           throw new NotOnListException(partyPeople.getName()+" trying to gatecrash.");  
	      }  
	 }  

	 // guest list
	 PartyPeople[] partyPeoples = {new PartyPeople("jason statham"),  
	                                     new PartyPeople("john travolta"),            
	                                     new PartyPeople("arnold"),            
	                                     new PartyPeople("christian bale"),            
	                                     new PartyPeople("Vin Diesel")  
	 };  

	
}