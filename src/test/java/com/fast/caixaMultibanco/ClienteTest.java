package com.fast.caixaMultibanco;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fast.caixaMultibanco.entidades.Cliente;
import com.fast.caixaMultibanco.repositorios.ClienteRepositorio;

/**
 * @author allan
 *
 */
class ClienteTest { 
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private static final Logger log = LoggerFactory.getLogger(ClienteTest.class);
	
	private Cliente addClienteMock(Integer id, String text, Double numero) throws Exception {
		Cliente cliente = new Cliente(text, text, text, text, id, text, text, numero);
		return cliente;
	}
	
	private void loadClientes() throws Exception {
		clientes.add(addClienteMock(1, "texto1", 1.00 ));
		clientes.add(addClienteMock(2, "text2", 2.00));
	}
	
	@MockBean
	private ClienteRepositorio mockRepositorio;
	
	public void consultaTodosTest() throws Exception {
		loadClientes();
		
		ClienteRepositorio mockRepositorio = mock(ClienteRepositorio.class);
		
		when(mockRepositorio.findAll()).thenReturn(clientes);
		
		List<Cliente> listaRetornoGet = mockRepositorio.findAll();
		
		Assert.assertTrue(listaRetornoGet.size() > 0);
		
		log.info("Teste Consulta todos dos Funcionários - OK");
		
	}
	
	@Test
	public void main() throws Exception {
		log.info("------------------ClienteTest-----------------------");
		consultaTodosTest();
		log.info("----------------------------------------------------");
	}

}
