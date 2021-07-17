/**
 * 
 */
package com.fast.caixaMultibanco.config;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fast.caixaMultibanco.Entities.Banco;
import com.fast.caixaMultibanco.repositories.BancoRepository;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;

/**
 * @author Maurilio
 * 	versão 0.0.1
 */
@Configuration
public class CarregarBaseDados {
	
	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);

	@Bean
	CommandLineRunner initDatabase(BancoRepository banco, CaixaRepository caixa, ClienteRepository cliente ) {
		return args -> {
			log.info("Carregando " + banco.save(new Banco(00000000, "BCO DO BRASIL S.A.", 001, "Sim", "RSFN", "Banco do Brasil S.A.", Date.valueOf("2002-04-22"))));
			
		};
	}
}
