/**
 * 
 */
package com.fast.caixaMultibanco;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.Assert;

import com.fast.caixaMultibanco.entidades.Banco;
import com.fast.caixaMultibanco.repositorios.BancoRepositorio;


/**
 * @author Maurilio
 *
 */
class BancoTest {

	private static final Logger log = org.slf4j.LoggerFactory.getLogger(BancoTest.class);

	private List<Banco> bancos = new ArrayList<Banco>();

	private Banco addBancoMock(Integer id) {
		Banco banc = new Banco(id, "BCO DO BRASIL S.A." + id, 001+id, "Sim"+id, "RSFN"+id, "Banco do Brasil S.A."+id);
		return banc;
	}

	/*
	 * Carregando Funcionários
	 */
	private void loadBancos() {
		bancos.add(addBancoMock(1));
		bancos.add(addBancoMock(2));
	}

	@MockBean
	private BancoRepositorio mockBancoRepository;

	@Test
	public void main() {
		log.info("---------------------------BancoTest---------------------");
		consultaTodosTest();
		log.info("---------------------------------------------------------------");
	}

	public void consultaTodosTest() {

		loadBancos();

		/*
		 * Mockando da classe Repositório Funcionário
		 */
		BancoRepositorio mockBancoRepository = mock(BancoRepositorio.class);

		/*
		 * Mockando retorno do Repositório
		 */
		when(mockBancoRepository.findAll()).thenReturn(bancos);

		/*
		 * Chamando o serviço mockado
		 */

		List<Banco> listaRetornoGet = mockBancoRepository.findAll();

		/*
		 * Verificando o resultado.
		 */
		Assert.assertTrue(listaRetornoGet.size() > 0);

		/*
		 * Gerando Log do método
		 */
		log.info("Teste Consulta todos dos Funcionários - Ok");

	}

}
