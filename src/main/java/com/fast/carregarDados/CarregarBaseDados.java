/**
 * 
 */
package com.fast.carregarDados;

import java.sql.Date;

import org.aspectj.weaver.patterns.ArgsAnnotationPointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import com.fast.caixaMultibanco.Entities.Banco;
import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.repositories.BancoRepository;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;


/**
 * @author Notebook
 *
 */
public class CarregarBaseDados {

	
	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);
	
	@Bean
	CommandLineRunner initDatabase (ClienteRepository cliente, BancoRepository banco, CaixaRepository caixa) {
		
		
		return args -> {
			
			Banco banco1 = new Banco(00000000, "BCO DO BRASIL S.A.", 001, "Sim", "RSFN", "Banco do Brasil S.A.", new Date(2002, 4, 22));
			log.info("Carregando " + banco.save(banco1));
			
			log.info("Carregando " + cliente.save(new Cliente("Francisco TESTE", "(74)99971-8965", "allan.teste", "1052", 
					banco1.getCodigo(), banco1.getNome_extenso(), "2021001",(double) 1000)));
			
			log.info("Carregando " + caixa.save(new Caixa(200, 200, 150, 200)));
			
			};
		
		
	
		
		
	
		
		
		
		
		
		
		
		
		
		
	}
	
	

}
