package com.invillia.acme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class InvilliaApplication {

	public static void main(String[] args) {

		BCryptPasswordEncoder bp = new BCryptPasswordEncoder();
		SpringApplication.run(InvilliaApplication.class, args);
		//Customer customer = new Customer("Alexsander Wilen", "Avenida dos Excombatens", "69", "Laurindo de Castro", "Uba", "alexsander@sancode.com.br", bp.encode("123"));
		System.out.println(bp.encode("123"));

	}
}
