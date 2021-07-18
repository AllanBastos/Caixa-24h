package com.fast.caixaMultibanco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fast.caixaMultibanco.Entities.Banco;
import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.repositories.BancoRepository;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;

/**
 * @author Maurilio versão 0.0.2
 */
@Configuration
public class CarregarBaseDados {

	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);

	@Bean
	CommandLineRunner initDatabase(BancoRepository banco, CaixaRepository caixa, ClienteRepository cliente) {
		return args -> {
			/*
			 * Inserindo Bancos
			 */
			String path =  ".\\src\\main\\resources\\Bancos.csv";
			try (BufferedReader br = new BufferedReader(new FileReader(path))){
				
				String line = br.readLine();
				Integer ispb = 0;
				while(line != null) {
					String[] fields = line.split(",");
					ispb = Integer.parseInt((fields[1].toString().trim()));
					int codigo = Integer.parseInt(fields[3]);
					log.info("Carregando " + banco.save(new Banco(ispb, fields[2], codigo, fields[4], fields[5], fields[6])));
					line = br.readLine();
				}
	
			}catch(IOException e) {
				System.out.println("Error: " + e.getMessage());
			}catch(NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			
			/*
			 * Inserindo Clientes
			 */
			log.info("Carregando " + cliente.save(new Cliente("Allan Time 3", "(74)99999-9999", "allan.teste", "senha1",
					1, "Banco do Brasil S.A.", "2021001", (double) 116)));
			log.info("Carregando " + cliente.save(new Cliente("Francisco Time 3", "(81)99999-8888", "francisco.teste",
					"senha2", 104, "CAIXA ECONOMICA FEDERAL", "2021001", (double) 118)));
			log.info("Carregando " + cliente.save(new Cliente("Gabriel Time 3", "(84)99999-7777", "gabriel.teste",
					"senha3", 341, "ITAÚ UNIBANCO S.A.", "2021001", (double) 119)));
			log.info("Carregando " + cliente.save(new Cliente("Matheus Time 3", "(74)99999-6666", "matheus.teste",
					"senha4", 237, "Banco Bradesco S.A.", "2021001", (double) 13000)));
			log.info("Carregando " + cliente.save(new Cliente("Maurilio Time 3", "(74)99999-5555", "maurilio.teste",
					"senha5", 27, "RSFN, BANCO SANTANDER (BRASIL) S.A.", "2021001", (double) 121)));

			/*
			 * Inserindo Caixas
			 */
			log.info("Carregando " + caixa.save(new Caixa()));
			log.info("Carregando " + caixa.save(new Caixa(0, 100, 10, 10)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 200, 0)));

		};
	}
}
