package model;
import ed.lib.Filas.controllerFilas;

import java.io.IOException;

import br.edu.fateczl.Lista;
public interface iIOarquivos {
	public void createDisciplinas(String d) throws Exception;
	public void createCursos(String c) throws Exception;
	public void createProfessores(String p) throws Exception;
	public void createInscricoes(String i) throws Exception;
	public controllerFilas<disciplinas> readDisciplinas(String busca) throws Exception;
	public controllerFilas<cursos> readCursos(String busca) throws Exception;
	public controllerFilas<professor> readProfessores(String busca) throws Exception;
	public controllerFilas<inscricao> readInscricoes(String busca) throws Exception;
	public Lista<disciplinas> chamarDisciplinas() throws Exception;
	public Lista<cursos> chamarCursos() throws Exception;
	public Lista<professor> chamarProfessores() throws Exception;
	public Lista<inscricao> chamarInscricoes() throws Exception;
	public void reescreveDisciplina(String d) throws IOException;
	public void reescreveCurso(String c) throws IOException;
	public void reescreveProfessor(String p) throws IOException;
	public void reescreveInscricao(String i) throws IOException;
}
