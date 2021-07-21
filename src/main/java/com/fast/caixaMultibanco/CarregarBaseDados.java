package com.fast.caixaMultibanco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fast.caixaMultibanco.entidades.Banco;
import com.fast.caixaMultibanco.entidades.Caixa;
import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.repositorios.BancoRepositorio;
import com.fast.caixaMultibanco.repositorios.CaixaRepositorio;
import com.fast.caixaMultibanco.repositorios.ClienteRepositorio;

/**
 * @author Maurilio versão 0.0.2
 */
@Configuration
public class CarregarBaseDados {

	private static final Logger log = LoggerFactory.getLogger(CarregarBaseDados.class);

	@Bean
	CommandLineRunner initDatabase(BancoRepositorio banco, CaixaRepositorio caixa, ClienteRepositorio cliente) {
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
			 * Inserindo Caixas
			 */
			log.info("Carregando " + caixa.save(new Caixa()));
			log.info("Carregando " + caixa.save(new Caixa(0, 100, 10, 10)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 200, 0)));
			log.info("Carregando " + caixa.save(new Caixa(200, 0, 0, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 200, 0, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 200, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 0, 200)));
			log.info("Carregando " + caixa.save(new Caixa(100, 0, 0, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 100, 0, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 100, 0)));
			log.info("Carregando " + caixa.save(new Caixa(0, 0, 0, 100)));
			
			/*
			 * Inserindo Clientes
			 */
			
			String[] lista = ("Allan Time 3, Francisco Time 3, Gabriel  Time 3, Marilio Time 3, "
					+ "Thiago Time 2, Raphael Time 2, Eustakio Time 2, Alfredo Time 2, Jeronimo Time 2, "
					+ "Heitor Time 1, Daniel Time 1, Jonathan Time 1, Neemias Time 1, "
					+ "Gusta Instrutor, Samuca Instrutor").split(",");
			List<Banco> lBancos = banco.findAll();
			
			int cont = 1;
			int bancos = 0;
			for (String nome : lista) {
				nome = nome.trim();
				String[] nomes = nome.split(" ");
				String primeiroNome = nomes[0];
				log.info("Carregando " + cliente.save(new Cliente(nome, "(99)99999-9999", primeiroNome + ".test", primeiroNome ,
					lBancos.get(bancos).getCodigo() , lBancos.get(bancos).getNome_reduzido() ,"BCTT-00001-2021" + (10000 + cont++), (double) 1000)));
				if (bancos < lBancos.size() - 1) {
					bancos++;
				}else {
					bancos = 0;
				}
			}

		};
	}
}
