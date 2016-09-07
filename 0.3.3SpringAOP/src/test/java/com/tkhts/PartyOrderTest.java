package com.tkhts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tkhts.exception.NotOnListException;
import com.tkhts.service.IPartyService;
import com.tkhts.service.PartyPeople;

public class PartyOrderTest {
	public static void main(String[] args) {  

        ApplicationContext context1 = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });  

        PartyPeople guest1 = new PartyPeople("jason statham", false);  
        PartyPeople guest2 = new PartyPeople("john travolta", true);  
        PartyPeople guest3 = new PartyPeople("adam sandler", true);  

        System.out.println("--------------------------------------");  

        IPartyService partyService = (IPartyService)context1.getBean("partyService");  

        // in guest list and not drunk  
        try {  
             partyService.letsParty(guest1);  
        } catch (NotOnListException e) {System.out.println(e.getMessage());}  
        catch (Exception e) {}  
        System.out.println("--------------------------------------");  

        // in guest list and drunk. Even if exception is thrown still the exit time is audited  
        try {  
             partyService.letsParty(guest2);  
        } catch (NotOnListException e) {System.out.println(e.getMessage());}  
        catch (Exception e) {}  
        System.out.println("--------------------------------------");  

        // not in guest list and drunk.   
        try {  
             partyService.letsParty(guest3);  
        } catch (NotOnListException e) {System.out.println(e.getMessage());}  
        catch (Exception e) {}  
        System.out.println("--------------------------------------");  
   }  
}
