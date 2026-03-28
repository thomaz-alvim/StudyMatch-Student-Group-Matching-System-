package models;

import java.util.Arrays;
import java.util.Objects;

/**
 * Classe para Alunos
 */
public class Aluno {
	private String matricula;
	private String nome;
	private String contato;
	private String[] disciplinas;
	
	public Aluno(String matricula, String nome, String contato, String[] disciplinas) {
		this.matricula = matricula;
		this.nome = nome;
		this.contato = contato;
		this.disciplinas = disciplinas;
	}
	
	// Getters
	
	public String[] getDisciplinas() {
		return disciplinas;
	}
	
	// Overrides

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + contato + " - " + Arrays.toString(disciplinas);
	}

}
