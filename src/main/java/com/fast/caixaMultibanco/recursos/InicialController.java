package com.fast.caixaMultibanco.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/")
public class InicialController {


	@GetMapping
	public ResponseEntity<Object> paginaInicial() {
		return ResponseEntity.ok().body("<h1>Seja bem vindo ao Caixa Multibanco Eletrônico\r\n"
				+ "</h1><p>Para começar faça login no seu banco</p><div>acesse: \r\n"
				+ "<a href=\"https://caixa-24-accenture.herokuapp.com/banco/loginBanco\">caixa-24-accenture.herokuapp.com/banco/loginBanco</a>\r\n"
				+ "    <p>Atraves do Postman ou qualquer outro  API Client </p>\r\n"
				+ "</div>\r\n"
				+ "<div>\r\n"
				+ "  <p>E faça um POST com o Body</p>\r\n"
				+ "    \r\n"
				+ "    <code>\r\n"
				+ "        \r\n"
				+ "    {\r\n"
				+ "         \"login\": \"exemplo_login\",\r\n"
				+ "         \"senha\": “S3nh@.d0-Cl13nt3”,\r\n"
				+ "         \"caixa\": 1,\r\n"
				+ "         \"conta\": “Conta do Cliente”\r\n"
				+ "    }\r\n"
				+ "    </code>        \r\n"
				+ "</div> ");		
	}
}
