package br.com.Cadastro;

import br.com.Cadastro.Entity.Formulario;
import br.com.Cadastro.Services.FormularioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CadastroApplicationTests {

	@Autowired
	private FormularioService service;
	@Test
	void contextLoads() {
		Formulario f = new Formulario();		
		f.setNome("Ernilson Daniel Lima de Souza");
		f.setEnder("quandra 105 conj");
		f.setFone(999999);
		f.setEmail("ernilson25@test.com");

		service.salvar(f);
	}

}
