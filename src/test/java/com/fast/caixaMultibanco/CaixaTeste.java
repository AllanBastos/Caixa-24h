package com.fast.caixaMultibanco;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fast.caixaMultibanco.Entities.Caixa;
import com.fast.caixaMultibanco.repositories.CaixaRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CaixaTeste {
	
private List<Caixa> Caixas = new ArrayList<Caixa>();
	
	private Caixa addCaixaMock(int id) {
		Caixa caixa = new Caixa(id, id, id, id);
		return caixa;
	}
	
	private void loadCaixas() {
		Caixas.add(addCaixaMock(1));
		Caixas.add(addCaixaMock(2));
	}
	
	
	@MockBean
	private CaixaRepository mockCaixaRepository;
	
	private static final Logger log = LoggerFactory.getLogger(CaixaTeste.class);
	@Test
	public void main() {
		log.info("------------ CaixaTest ------------");
		consultaTodosTest();
		log.info("-----------------------------------------------");
		}
	
	public void consultaTodosTest() {
		loadCaixas();
	
	
	CaixaRepository mockCaixaRepository = mock(CaixaRepository.class);
	
	/* mockando o retorno do Repositório */
	when(mockCaixaRepository.findAll())
	.thenReturn(Caixas);
	/* chamando o serviço mockado */
	List<Caixa> listaRetornoGET = mockCaixaRepository.findAll();
	/* verificando o resultado */
	Assert.assertTrue(listaRetornoGET.size()>0);
	/* gerando log do método */
	log.info("Teste Consulta todos dos Funcionários - OK");	
	
	}
	
}
	
	

