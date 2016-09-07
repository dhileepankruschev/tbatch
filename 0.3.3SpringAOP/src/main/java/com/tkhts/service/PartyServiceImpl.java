package com.tkhts.service;

import org.springframework.stereotype.Component;

import com.tkhts.exception.GotTooDrunkException;

 
@Component
public class PartyServiceImpl implements IPartyService {  
     /**  
      * guests wait for some time in party then leave.  
      * If a guest gets too drunk then they are taken out.  
      */  
	
	public PartyServiceImpl(){
		
	}
	
     public void letsParty(PartyPeople people) throws Exception {  
               Thread.sleep(200);  
               // if people get drunk then get them out
               System.out.println("Partying.....");
               if (people.isDrunk()) {  
                    throw new GotTooDrunkException();  
               }  
     }  
}  
