package controllers;

import java.util.HashMap;
import java.util.Map;
import models.*;

/**
 * Classe de controlador do sistema. Armazena alunos e grupos em respectivos mapas.
 */
public class SistemaStudyMatch {
	private Map<String, Aluno> alunos;
	private Map<Integer, Grupo> grupos;
	private int proximoID;
	
	public SistemaStudyMatch() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
	}
	
	public void cadastrarAluno(String matricula, String nome, String contato, String[] disciplinas) throws IllegalArgumentException {
		if (alunos.containsKey(matricula)) {
			throw new IllegalArgumentException("A matrícula digitada pertence a um aluno já cadastrado.");
		}
		alunos.put(matricula, new Aluno(matricula, nome, contato, disciplinas));
	}
	
	public int cadastrarGrupo(String tema, int vagas, String[] foco) {
		proximoID++;
		grupos.put(proximoID, new Grupo(proximoID, tema, vagas, foco));
		return proximoID;
	}
	
	public int calcularAfinidade(String matricula, int codigoGrupo) {
		String[] disciplinasAluno = alunos.get(matricula).getDisciplinas();
		String[] disciplinasGrupo = grupos.get(codigoGrupo).getDisciplinas();
		int afinidade = 0;
		
		for (String disciplinaAluno : disciplinasAluno) {
			for (String disciplinaGrupo : disciplinasGrupo) {
				if (disciplinaAluno.equals(disciplinaGrupo)) {
					afinidade++;
				}
			}
		}
		
		return afinidade;
	}
	
	public boolean inscreverAluno(String matricula, int codigoGrupo) {
		Grupo grupo = grupos.get(codigoGrupo);
		Aluno aluno = alunos.get(matricula);
		
		return grupo.inscreverAluno(aluno);
	}
	
	public String[] listarAlunosDoGrupo(int codigoGrupo) {
		Grupo grupo = grupos.get(codigoGrupo);
		return grupo.listarInscritos();
	}

}
