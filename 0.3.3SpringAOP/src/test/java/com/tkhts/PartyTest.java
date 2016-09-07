package com.tkhts;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tkhts.aspect.BeforePartyAspect;
import com.tkhts.exception.NotOnListException;
import com.tkhts.service.IPartyService;
import com.tkhts.service.PartyPeople;

public class PartyTest {  

     public static void main(String[] args) {  
          ApplicationContext context1 = new ClassPathXmlApplicationContext(new String[] { "spring-config.xml" });  

          PartyPeople guest1 = new PartyPeople("jason statham", false);  
          PartyPeople guest2 = new PartyPeople("adam sandler", true);  

          IPartyService partyService = (IPartyService)context1.getBean("partyServiceImpl");  
          System.out.println(partyService);
          
          
         /* BeforePartyAspect beforePartyAspect = (BeforePartyAspect)context1.getBean("beforePartyAspect");  
          System.out.println(beforePartyAspect);
          */
          // in guest list  
          try {  
               partyService.letsParty(guest1);  
          } catch (NotOnListException e) {System.out.println(e.getMessage());}  
          catch (Exception e) {}  

          System.out.println("--------------------------------------");  

          // @before advice throws NotOnListException   
          try {  
               partyService.letsParty(guest2);  
          } catch (NotOnListException e) {System.out.println(e.getMessage());}  
          catch (Exception e) {}  

          System.out.println("--------------------------------------");  
     }  
}  
