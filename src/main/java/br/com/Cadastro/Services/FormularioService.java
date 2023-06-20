package br.com.Cadastro.Services;

import br.com.Cadastro.Entity.Formulario;
import br.com.Cadastro.Repository.FormularioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@Slf4j
public class FormularioService {
	
   private final FormularioRepository repository;
   
    public FormularioService(FormularioRepository repsitory){
        this.repository = repsitory;
    }
    
    public List<Formulario> buscaTodos(){
        return repository.findAll();
    }
    
    public Formulario salvar(Formulario formulario){
        return repository.save(formulario);
    }
    
    public void delete (Long id){
        try {
            repository.deleteById(id);
        } catch (Exception e) {
           // log.info(e.getMessage());
            throw new RuntimeException("Erro ao remover formulario");
        }
    }
}
