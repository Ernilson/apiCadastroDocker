package br.com.Cadastro.Entity;

import java.util.Objects;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Formulario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nome;
    @Column
    private String ender;
    @Column
    private int fone;
    @Column
    private String email;
    
    public Formulario() {
		// TODO Auto-generated constructor stub
	}

	public Formulario(Long id, String nome, String ender, int fone, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.ender = ender;
		this.fone = fone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEnder() {
		return ender;
	}

	public void setEnder(String ender) {
		this.ender = ender;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, ender, fone, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formulario other = (Formulario) obj;
		return Objects.equals(email, other.email) && Objects.equals(ender, other.ender) && fone == other.fone
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Formulario [id=" + id + ", nome=" + nome + ", ender=" + ender + ", fone=" + fone + ", email=" + email
				+ "]";
	}
    
    

}
