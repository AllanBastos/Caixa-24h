package com.fast.caixaMultibanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe Principaldo programa
 * @author allan
 * @version 0.0.1
 */

@SpringBootApplication
public class CaixaMultibancoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CaixaMultibancoApplication.class, args);
		System.out.println("Aplicação iniciada com sucesso!");
	}

}
