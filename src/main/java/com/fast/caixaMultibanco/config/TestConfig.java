package com.fast.caixaMultibanco.config;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fast.caixaMultibanco.Entities.Banco;
import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.repositories.BancoRepository;
import com.fast.caixaMultibanco.repositories.CaixaRepository;
import com.fast.caixaMultibanco.repositories.ClienteRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private BancoRepository bancoRepository;
	@Autowired
	private CaixaRepository caixaRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Banco banco = new Banco(00000000, "BCO DO BRASIL S.A.", 001, "Sim", "RSFN", "Banco do Brasil S.A.", Date.valueOf("2002-04-22"));
		Caixa caixa = new Caixa(200, 200, 150, 200);
		Cliente cliente = new Cliente("Allan", "(74)99971-8965", "allan.teste", "1052", banco.getCodigo(), banco.getNome_extenso(), "2021001",(double) 1000);
//		
		bancoRepository.save(banco);
		caixaRepository.save(caixa);
		clienteRepository.save(cliente);
		
		
		
	}

	

}
