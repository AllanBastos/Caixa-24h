/**
 * 
 */
package com.fast.caixaMultibanco;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fast.caixaMultibanco.Entities.Acesso;
import com.fast.caixaMultibanco.Entities.Cliente;
import com.fast.caixaMultibanco.repositories.AcessoRepository;



/**
 * @author NOTE-CASA
 *
 */
class AcessoTest {

	private static final Logger log = LoggerFactory.getLogger(Acesso.class);

	private List<Acesso> Acessos = new ArrayList<Acesso>();
	
	
	private Cliente cliente = null;
	
	
	
	private Acesso addAcessoMock(Cliente cliente, String token, Integer caixa, Long tempoInicial, Long tempoFinal) {
		Acesso func = new Acesso(cliente, token, caixa, tempoInicial, tempoFinal);
		
		return func;
	}

	private void loadAcessos() {
		/* Carregando objeto Acessos */
		Acessos.add(new Acesso(cliente, null, null, null, null));
		Acessos.add(new Acesso(cliente, null, null, null, null));
	}

	@MockBean
	private AcessoRepository mockRepositorio;

	@Test
	public void main() {

		log.info("--------------------AcessoTest------------------");
		consultaTodosTest();
		log.info("-----------------------------------------------------");
	}

	public void consultaTodosTest() {
		loadAcessos();
		/* Mockado da classe RepositorioAcesso */
		AcessoRepository mockRepositorio = mock(AcessoRepository.class);

		when(mockRepositorio.findAll()).thenReturn(Acessos);

		List<Acesso> listaRetornoGet = mockRepositorio.findAll();

		Assert.assertTrue(listaRetornoGet.size() > 0);

		log.info("Teste Consulta todos dos Funcionários - Ok");

	}

}
