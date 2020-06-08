package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;

@Component
//by default scope is singleton
//we can use prototype also
//@Scope("prototype")
public class TennisCoach implements Coach {
   
	//FIELD INJECTION
	@Autowired
	@Qualifier("randomFortuneService") 
	private FortuneService fortuneService; 
	
	
	
     // define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	
	// define my init method
		@PostConstruct
		public void doMyStartupStuff() {
			System.out.println(">> TennisCoach: inside of doMyStartupStuff()");
		}
		
		// define my destroy method
		@PreDestroy
		public void doMyCleanupStuff() {
			System.out.println(">> TennisCoach: inside of doMyCleanupStuff()");		
		}
	
	
	
	
	/*
	//CUSTOM METHOD INJECTION
	@Autowired
	public void doSomeCrazyStuff(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside doSomeCrazyStuff method");
		this.fortuneService = theFortuneService;
	}
	
	*/
	
	
    /*
	// SETTOR INJECTION
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {
		System.out.println(">> TennisCoach: inside setFortuneService() method");
		this.fortuneService = theFortuneService;
	}
	
	*/
	
	/*
	 //CONSTRUCTOR INJECTION
	@Autowired
	public TennisCoach(FortuneService theFortuneService) {
		fortuneService = theFortuneService;
	}
	
	*/

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
