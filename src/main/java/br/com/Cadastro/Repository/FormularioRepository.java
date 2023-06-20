package br.com.Cadastro.Repository;
import br.com.Cadastro.Entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
