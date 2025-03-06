package com.kdr.CrediGo;

import com.kdr.CrediGo.config.DotenvConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrediGoApplication {

	public static void main(String[] args) {
		DotenvConfig.loadEnv();
		SpringApplication.run(CrediGoApplication.class, args);
	}

}
