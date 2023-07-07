package apiCadastroDocker.FormularioControllerTestes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.Cadastro.Controller.FormularioController;
import br.com.Cadastro.Entity.Formulario;
import br.com.Cadastro.Services.FormularioService;

class FormularioControllerTest {

    private FormularioController formularioController;

    @Mock
    private FormularioService formularioService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        formularioController = new FormularioController(formularioService);
    }

    @Test
    void buscaTodos_DeveRetornarListaDeFormularios() {
        // Arrange
        List<Formulario> formularios = new ArrayList<>();
        formularios.add(new Formulario());
        formularios.add(new Formulario());

        when(formularioService.buscaTodos()).thenReturn(formularios);

        // Act
        ResponseEntity<List<Formulario>> response = formularioController.buscaTodos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(formularios, response.getBody());
    }

    @Test
    void salvar_DeveRetornarFormularioCriado() {
        // Arrange
        Formulario formulario = new Formulario();
        Formulario novoFormulario = new Formulario();

        when(formularioService.salvar(formulario)).thenReturn(novoFormulario);

        // Act
        ResponseEntity<Formulario> response = formularioController.salvar(formulario);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(novoFormulario, response.getBody());
    }

    @Test
    void remover_DeveRetornarHttpStatusOk() {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<Void> response = formularioController.remover(id);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(formularioService, times(1)).delete(id);
    }
}
