package br.com.Cadastro.Controller;

import br.com.Cadastro.Entity.Formulario;
import br.com.Cadastro.Services.FormularioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/formulario")
public class FormularioController {

    private final FormularioService service;

    public FormularioController(FormularioService service) {
       this.service = service;
    }
    
    @GetMapping
    public ResponseEntity<List<Formulario>> buscaTodos(){
        return ResponseEntity.ok(service.buscaTodos());
    }
    
    @PostMapping("/cadastro")
    public ResponseEntity<Formulario> salvar(@RequestBody Formulario formulario){
        var novoFormulario = service.salvar(formulario);
        return new ResponseEntity<>(novoFormulario, null, HttpStatus.CREATED);
    }

    @DeleteMapping()
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
