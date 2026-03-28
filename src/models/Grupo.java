package models;

import java.util.Arrays;
import java.util.Objects;

/**
 * Classe para grupos de estudo. Armazena objetos do tipo Aluno em um array.
 */
public class Grupo {
	private int id;
	private String tema;
	private int vagas;
	private String[] foco;
	private Aluno[] inscritos;
	private int proximoInscrito;
	
	public Grupo(int id, String tema, int vagas, String[] foco) {
		this.id = id;
		this.tema = tema;
		this.vagas = vagas;
		this.foco = foco;
		this.inscritos = new Aluno[vagas];
	}
	
	// Getters
	
	public String[] getDisciplinas() {
		return foco;
	}
	
	public Aluno[] getInscritos() {
		return inscritos;
	}
	
	public int getVagas() {
		return vagas;
	}
	
	// Lógica
	
	public boolean inscreverAluno(Aluno aluno) {
		if (proximoInscrito == vagas) {
			return false;
		}
		
		for (int i = 0 ; i < proximoInscrito ; i++) {
			if (inscritos[i].equals(aluno)) {
				return false;
			}
		}
		
		inscritos[proximoInscrito] = aluno;
		proximoInscrito++;
		return true;
	}
	
	public String[] listarInscritos() {
		String[] informacoesInscritos = new String[proximoInscrito];
		
		for (int i = 0 ; i < proximoInscrito ; i++) {
			informacoesInscritos[i] = inscritos[i].toString();
		}
		
		return informacoesInscritos;
	}
	
	// Overrides

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		int vagasLivres = vagas - proximoInscrito;
		return "Grupo " + id + ": " + tema + " (" + vagasLivres + "/" + vagas + ") - Foco: " + Arrays.toString(foco);
	}
	
}
