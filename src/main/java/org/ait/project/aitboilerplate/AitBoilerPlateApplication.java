package org.ait.project.aitboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AitBoilerPlateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AitBoilerPlateApplication.class, args);
	}

}
