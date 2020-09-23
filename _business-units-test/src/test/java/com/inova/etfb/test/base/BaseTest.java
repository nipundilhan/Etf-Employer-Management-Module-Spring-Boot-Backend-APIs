package com.inova.etfb.test.base;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.inova.ETFBMain;
import com.inova.config.EmployerRelationServiceConfig;
import com.inova.util.BootMain;

@SpringBootTest(classes = { ETFBMain.class, EmployerRelationServiceConfig.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations="classpath:application-test.properties")
@RunWith(SpringRunner.class)
public abstract class BaseTest {
	@BeforeClass
	public static void setUp() {
		BootMain.main(null);
//		System.setProperty("spring.profiles.active", "dev");
//		System.setProperty("spring.config.name", ApplicationConfig.APP_CONFING_NAME);
	}
}
