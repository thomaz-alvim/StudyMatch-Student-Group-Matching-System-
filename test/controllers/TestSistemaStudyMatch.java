package controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Classe de testes
 */
class TestSistemaStudyMatch {
	private SistemaStudyMatch sistema;

	@BeforeEach
	void setUp() {
		this.sistema = new SistemaStudyMatch();
		sistema.cadastrarAluno("1", "Tomen", "500 000 000 001", new String[] {"Computer Science", "Electrical Engineering", "Chemical Engineering"});
	}

	@Test
	void testCriarAlunoCpfCadastrado() {
		assertThrows(IllegalArgumentException.class, () -> {
			sistema.cadastrarAluno("1", "Tomen", "500 000 000 001", new String[] {"Computer Science", "Electrical Engineering", "Chemical Engineering"});
		});
	}

}
