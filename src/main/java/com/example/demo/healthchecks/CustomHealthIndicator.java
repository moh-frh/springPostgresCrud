package com.example.demo.healthchecks;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		Boolean isError = false;
		
		
		if(isError){
			return Health.down().withDetail("error key", 123).build();
		}
		
		
		return Health.up().build();
	}

}
