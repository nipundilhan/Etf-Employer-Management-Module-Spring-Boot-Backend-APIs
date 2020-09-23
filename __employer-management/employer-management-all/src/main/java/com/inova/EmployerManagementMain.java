package com.inova;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import com.inova.util.BootMain;

//@EnableFeignClients("com.inova.common.service")
@SpringBootApplication
@EnableAsync
public class EmployerManagementMain {
	public static void main(String[] args) {
		BootMain.main(args);
		SpringApplication.run(EmployerManagementMain.class, args);
	}
	
	  @Bean(name = "asyncExecutor")
	  public Executor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(3);
	    executor.setMaxPoolSize(3);
	    executor.setQueueCapacity(500);
	    executor.initialize();
	    return executor;
	  }
}
