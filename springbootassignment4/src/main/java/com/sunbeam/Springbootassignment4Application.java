package com.sunbeam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

import com.bank.Account;
import com.bank.AppConfig;
import com.bank.ConsoleLoggerImpl;
import com.bank.FileLoggerImpl;
import com.bank.Logger;
import com.bank.SpELTest;

@Import(AppConfig.class)
@SpringBootApplication
public class Springbootassignment4Application implements CommandLineRunner {
	
	private final SpELTest spELTest;
	private final ConsoleLoggerImpl consoleLoggerImpl;
	
	   Springbootassignment4Application(@Qualifier("consoleLoggerImpl") ConsoleLoggerImpl consoleLoggerImpl, SpELTest spELTest) {
	        this.consoleLoggerImpl = consoleLoggerImpl;
	        this.spELTest = spELTest;
	    }

	public static void main(String[] args) {
		SpringApplication.run(Springbootassignment4Application.class, args);
	}
	
	@Autowired
	private ApplicationContext ctx;
	
	@Override
	public void run(String... args) throws Exception {
		Logger consoleLogger = ctx.getBean(ConsoleLoggerImpl.class);
		consoleLogger.log("Log message");
		
		Logger fileLogger = ctx.getBean(FileLoggerImpl.class);
		fileLogger.log("file log message");
		
		Logger logger = ctx.getBean(Logger.class);
		logger.log("Console Log Message with primary");
		
		Account acc = ctx.getBean(Account.class);
		
		System.out.println("acc -- " + acc); // 40000
		acc.deposit(4000);
		System.out.println("acc -- " + acc); // 44000
		acc.withdraw(3000);
		System.out.println("acc -- " + acc); // 41000
		
 		SpELTest test = ctx.getBean(SpELTest.class);
 		test.displayInfo();
		
		
	}

}
