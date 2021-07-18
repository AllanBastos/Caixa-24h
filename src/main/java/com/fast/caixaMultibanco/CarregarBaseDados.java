package com.fast.caixaMultibanco;

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
			Banco banco1 = new Banco(00000000, "BCO DO BRASIL S.A.", 001, "Sim", "RSFN", "Banco do Brasil S.A.");
			Banco banco2 = new Banco(00360305, "CAIXA ECONOMICA FEDERAL", 104, "Sim", "RSFN",
					"CAIXA ECONOMICA FEDERAL");
			Banco banco3 = new Banco(60701190, "ITAÚ UNIBANCO S.A.", 341, "Sim", "RSFN", "ITAÚ UNIBANCO S.A.");
			Banco banco4 = new Banco(60746948, "BCO BRADESCO S.A.", 237, "Sim", "RSFN", "Banco Bradesco S.A.");
			Banco banco5 = new Banco(90400888, "BCO SANTANDER (BRASIL) S.A.", 033, "Sim", "RSFN",
					"RSFN, BANCO SANTANDER (BRASIL) S.A.");
			log.info("Carregando " + banco.save(banco1));
			log.info("Carregando " + banco.save(banco2));
			log.info("Carregando " + banco.save(banco3));
			log.info("Carregando " + banco.save(banco4));
			log.info("Carregando " + banco.save(banco5));

			/*
			 * Inserindo Clientes
			 */
			log.info("Carregando " + cliente.save(new Cliente("Allan Time 3", "(74)99999-9999", "allan.teste", "senha1",
					banco1.getCodigo(), banco1.getNome_extenso(), "2021001", (double) 116)));
			log.info("Carregando " + cliente.save(new Cliente("Francisco Time 3", "(81)99999-8888", "francisco.teste",
					"senha2", banco2.getCodigo(), banco2.getNome_extenso(), "2021001", (double) 118)));
			log.info("Carregando " + cliente.save(new Cliente("Gabriel Time 3", "(84)99999-7777", "gabriel.teste",
					"senha3", banco3.getCodigo(), banco3.getNome_extenso(), "2021001", (double) 119)));
			log.info("Carregando " + cliente.save(new Cliente("Matheus Time 3", "(74)99999-6666", "matheus.teste",
					"senha4", banco4.getCodigo(), banco4.getNome_extenso(), "2021001", (double) 13000)));
			log.info("Carregando " + cliente.save(new Cliente("Maurilio Time 3", "(74)99999-5555", "maurilio.teste",
					"senha5", banco5.getCodigo(), banco5.getNome_extenso(), "2021001", (double) 121)));

			/*
			 * Inserindo Caixas
			 */
			log.info("Carregando " + caixa.save(new Caixa()));
			log.info("Carregando " + caixa.save(new Caixa(0, 100, 10, 10)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 200, 0)));

		};
	}
}
