package controller;

import javax.swing.JOptionPane;

import br.edu.fateczl.Lista;
import ed.lib.Filas.controllerFilas;
import model.*;
public class validacaoController {
	private disciplinas d = new disciplinas(0, null, null, 0, 0, 0);
	private cursos c = new cursos(0, null, null);
	private professor p = new professor(0, 0, null, null);
	private inscricao i = new inscricao(0, 0, 0);
	private Lista<disciplinas> listaD = new Lista<disciplinas>();
	private controllerFilas<disciplinas> filaD = new controllerFilas<disciplinas>();
	private Lista<cursos> listaC = new Lista<cursos>();
	private controllerFilas<cursos> filaC = new controllerFilas<cursos>();
	private Lista<professor> listaP = new Lista<professor>();
	private controllerFilas<professor> filaP = new controllerFilas<professor>();
	private Lista<inscricao> listaI = new Lista<inscricao>();
	private controllerFilas<inscricao> filaI = new controllerFilas<inscricao>();
	
	public boolean isNotNumeric(String str) throws Exception {
	    if (str == null) {return false;}
	    try {
	        Integer.parseInt(str);
	        throw new Exception("Valor '"+str+"' não aceito.");
	    } catch (NumberFormatException e) {
	    	return true;
	    }
	}
	
	public String validarDisciplina(String codD, String nome, String diaSemana,
			String horaIni, String qtdHoras, String codCurso, boolean verificar) throws Exception{
		try {	
			if(codDisciplinaNOTExists(codD) || verificar) {
				d.setCodDisciplina(Integer.parseInt(codD));
			}else {
				throw new Exception("Este código já está cadastrado.");
			}
			if(isNotNumeric(nome) && isNotNumeric(diaSemana)) {
				d.setNomeDisciplina(nome);
				d.setDiaSemana(diaSemana);
			}
			d.setQtdHoraDiaria(Integer.parseInt(qtdHoras));
			if(Integer.parseInt(horaIni) > 0 || Integer.parseInt(horaIni) < 24) {
				d.setHoraIni(Integer.parseInt(horaIni));
			}else {
				throw new Exception("Hora inicial inválida");
			}
			if(codCursoExists(codCurso)) {
				d.setCodCurso(Integer.parseInt(codCurso));			
			}else {
				throw new Exception("Curso não existe/cadastrado.");
			}
			String csvDisciplina = d.toString(d);
			return csvDisciplina;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	private boolean codDisciplinaNOTExists(String codDisciplina) throws Exception {
		iIOarquivos io = new IOarquivos();
		listaD = io.chamarDisciplinas();
		if(!listaD.isEmpty()) {
			for (int i = 0; i < listaD.size(); i++) {
				if(listaD.get(i).getCodDisciplina() == Integer.parseInt(codDisciplina)) {
					return false;
				}
			}
		}
		return true;
	}
	
	private boolean codCursoExists(String codCurso) throws Exception {
		iIOarquivos io = new IOarquivos();
		listaC = io.chamarCursos();
		if(!listaC.isEmpty()) {
			for (int i = 0; i < listaC.size(); i++) {
				if(listaC.get(i).getCodCursos() == Integer.parseInt(codCurso)) {
					return true;
				}
			}
		}
		return false;
	}

	public void enviarDisciplina(String valor) throws Exception{
		iIOarquivos io = new IOarquivos();
		io.createDisciplinas(valor);
	}
	
	public String[] buscarDisciplina(String chave) throws Exception{
		iIOarquivos io = new IOarquivos();
		filaD = io.readDisciplinas(chave);
		while(!filaD.estaVazia()) {
			d = filaD.desenfileirar();
			if(String.valueOf(d.getCodDisciplina()).equalsIgnoreCase(chave)  || 
					d.getNomeDisciplina().equalsIgnoreCase(chave)) {
				return d.toString(d).split(";");
			}
		}
		throw new Exception("Valor não encontrado.");
		
		
	}

	public void atualizarDisciplina(String valor) throws Exception {
		String[] valores = valor.split(";");
		iIOarquivos io = new IOarquivos();
		listaD = io.chamarDisciplinas();	
		if(listaD.isEmpty()) throw new Exception("Lista vazia.");
		for(int i = 0; i < listaD.size(); i++) {
			int codLista = listaD.get(i).getCodDisciplina();
			if(codLista == Integer.parseInt(valores[0])) {
				listaD.get(i).setCodDisciplina(Integer.parseInt(valores[0]));
				listaD.get(i).setNomeDisciplina(valores[1]);
				listaD.get(i).setDiaSemana(valores[2]);
				listaD.get(i).setQtdHoraDiaria(Integer.parseInt(valores[3]));
				listaD.get(i).setHoraIni(Integer.parseInt(valores[4]));
				listaD.get(i).setCodCurso(Integer.parseInt(valores[5]));
			}
			if(i==0) {
				io.reescreveDisciplina(listaD.get(i).toString(listaD.get(i)));
			}else {
				io.createDisciplinas(listaD.get(i).toString(listaD.get(i)));
			}
		}
	}
	
	public String validarCurso(String codD, String nome, String areaConhec, boolean verificar) throws Exception{
		try {	
			if(!codCursoExists(codD) || verificar) {
				c.setCodCursos(Integer.parseInt(codD));
			}else {
				throw new Exception("Curso já cadastrado.");
			}
			if(isNotNumeric(areaConhec) && isNotNumeric(nome)) {
				c.setNomeCurso(nome); //coloca os dados no Objeto disciplinas
				c.setAreaConhecimento(areaConhec);
			}
			String csvCurso = c.toString(c);
			
			return csvCurso;//adiciona no arquivo .csv
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void enviarCurso(String valor) throws Exception{
		iIOarquivos io = new IOarquivos();
		io.createCursos(valor);
	}
	
	public String[] buscarCurso(String chave) throws Exception{
		iIOarquivos io = new IOarquivos();
		filaC = io.readCursos(chave);
		while(!filaC.estaVazia()) {
			c = filaC.desenfileirar();
			if(String.valueOf(c.getCodCursos()).equalsIgnoreCase(chave)  || 
					c.getNomeCurso().equalsIgnoreCase(chave)) {
				return c.toString(c).split(";");
			}
		}
		throw new Exception("Valor não encontrado.");
		
		
	}

	public void atualizarCurso(String valor) throws Exception {
		String[] valores = valor.split(";");
		iIOarquivos io = new IOarquivos();
		listaC = io.chamarCursos();	
		if(listaC.isEmpty()) throw new Exception("Lista vazia.");
		for(int i = 0; i < listaC.size(); i++) {
			int codLista = listaC.get(i).getCodCursos();
			if(codLista == Integer.parseInt(valores[0])) {
				listaC.get(i).setCodCursos(Integer.parseInt(valores[0]));
				listaC.get(i).setNomeCurso(valores[1]);
				listaC.get(i).setAreaConhecimento(valores[2]);
			}
			if(i==0) {
				io.reescreveCurso(listaC.get(i).toString(listaC.get(i)));
			}else {
				io.createCursos(listaC.get(i).toString(listaC.get(i)));
			}
		}
	}
	
	public String validarProfessor(String cpf, String nomeProfessor, String areaConhec, 
			String qtdPontos, boolean verificar) throws Exception{
		try {	
			if(!cpfExists(cpf) || verificar) {
				p.setCPF(Long.parseLong(cpf));
			}else {
				throw new Exception("CPF já cadastrado");
			}
			if(Integer.parseInt(qtdPontos) > 0 && Integer.parseInt(qtdPontos) <=100) {
				p.setQtdPontos(Integer.parseInt(qtdPontos));
			}else {
				throw new Exception("Pontos inválidos.");
			}
			if(isNotNumeric(nomeProfessor) && isNotNumeric(areaConhec)) {
				p.setNomeProfessor(nomeProfessor);
				p.setAreaConhecimento(areaConhec); //coloca os dados no Objeto disciplinas
			}
			String csvProfessor = p.toString(p);
			
			return csvProfessor;//adiciona no arquivo .csv
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void enviarProfessor(String valor) throws Exception{
		iIOarquivos io = new IOarquivos();
		io.createProfessores(valor);
	}
	
	public String[] buscarProfessor(String chave) throws Exception{
		iIOarquivos io = new IOarquivos();
		filaP = io.readProfessores(chave);
		while(!filaP.estaVazia()) {
			p = filaP.desenfileirar();
			if(String.valueOf(p.getCPF()).equalsIgnoreCase(chave)) {
				return p.toString(p).split(";");
			}
		}
		throw new Exception("Professor não encontrado.");
		
		
	}

	public void atualizarProfessor(String valor) throws Exception {
		String[] valores = valor.split(";");
		iIOarquivos io = new IOarquivos();
		listaP = io.chamarProfessores();	
		if(listaP.isEmpty()) throw new Exception("Lista vazia.");
		for(int i = 0; i < listaP.size(); i++) {
			long codLista = listaP.get(i).getCPF();
			if(codLista == Long.parseLong(valores[0])) {
				listaP.get(i).setCPF(Long.parseLong(valores[0]));
				listaP.get(i).setQtdPontos(Integer.parseInt(valores[1]));
				listaP.get(i).setNomeProfessor(valores[2]);
				listaP.get(i).setAreaConhecimento(valores[3]);
			}
			if(i==0) {
				io.reescreveProfessor(listaP.get(i).toString(listaP.get(i)));
			}else {
				io.createProfessores(listaP.get(i).toString(listaP.get(i)));
			}
		}
	}
    	
	public String validarInscricao(String codProcesso, String codDisciplina, String cpf, boolean verificar) throws Exception{
		try {	
			if(codProcessoNotExists(codProcesso) || verificar) {
				i.setCodProcesso(Integer.parseInt(codProcesso));
			}else {
				throw new Exception("Este código já está cadastrado.");
			}
			if(!codDisciplinaNOTExists(codDisciplina)) {
				i.setCodDisciplina(Integer.parseInt(codDisciplina));
			}else {
				throw new Exception("Código de disciplina não cadastrado.");
			}
			if(cpfExists(cpf)) {
				i.setCPF(Long.parseLong(cpf));//coloca os dados no Objeto disciplinas
			}else {
				throw new Exception("CPF não encontrado.");
			}
			String csvInscricao = i.toString(i);
			return csvInscricao;//adiciona no arquivo .csv	
		} catch (Exception e) {
			throw e;
		}
	}
	
	private boolean cpfExists(String cpf) throws Exception {
		iIOarquivos io = new IOarquivos();
		listaP = io.chamarProfessores();
		long cpfN;
		try {
			cpfN = Long.parseLong(cpf);
		} catch (Exception e) {
			throw new Exception("CPF inválido.");
		}
		for (int i = 0; i < listaD.size(); i++) {
			if(listaP.get(i).getCPF() == cpfN) {
				return true;
			}
		}
		return false;
	}

	private boolean codProcessoNotExists(String codProcesso) throws Exception {
		iIOarquivos io = new IOarquivos();
		listaI = io.chamarInscricoes();
		if(!listaI.isEmpty()) {
			for (int i = 0; i < listaI.size(); i++) {
				if(listaI.get(i).getCodProcesso() == Integer.parseInt(codProcesso)) {
					return false;
				}
			}
		}
		return true;
	}

	public void enviarInscricao(String valor) throws Exception{
		iIOarquivos io = new IOarquivos();
		io.createInscricoes(valor);
	}
	
	public String[] buscarInscricao(String chave) throws Exception{
		iIOarquivos io = new IOarquivos();
		filaI = io.readInscricoes(chave);
		while(!filaI.estaVazia()) {
			i = filaI.desenfileirar();
			if(String.valueOf(i.getCodProcesso()).equalsIgnoreCase(chave)) {
				return i.toString(i).split(";");
			}
		}
		throw new Exception("Processo não encontrado.");
		
		
	}

	public void atualizarInscricao(String valor) throws Exception {
		String[] valores = valor.split(";");
		iIOarquivos io = new IOarquivos();
		listaI = io.chamarInscricoes();	
		if(listaI.isEmpty()) throw new Exception("Lista vazia.");
		for(int i = 0; i < listaI.size(); i++) {
			int codLista = listaI.get(i).getCodProcesso();
			if(codLista == Integer.parseInt(valores[0])) {
				listaI.get(i).setCodProcesso(Integer.parseInt(valores[0]));
				listaI.get(i).setCodDisciplina(Integer.parseInt(valores[1]));
				listaI.get(i).setCPF(Long.parseLong(valores[2]));
			}
			if(i==0) {
				io.reescreveInscricao(listaI.get(i).toString(listaI.get(i)));
			}else {
				io.createInscricoes(listaI.get(i).toString(listaI.get(i)));
			}
		}
	}

	public void deleteDisciplina(String texts) throws Exception {
		String[] valoresDis = texts.split(";");
		iIOarquivos io = new IOarquivos();
		listaD = io.chamarDisciplinas();
		listaI = io.chamarInscricoes();
		String posInscricao = encontrarPosInscricao(listaI, valoresDis[0]);
		for (int i = 0; i < listaD.size(); i++) {
			int cod = listaD.get(i).getCodDisciplina();
			if(cod == Integer.parseInt(valoresDis[0])){
				listaD.remove(i);
				if(posInscricao != null) {
					listaI.remove(Integer.parseInt(posInscricao));
					if(!listaI.isEmpty()) {
						for (int ix = 0; ix < listaI.size(); ix++) {
							if(ix==0) {
								io.reescreveInscricao(listaI.get(ix).toString(listaI.get(ix)));
							}else {
								io.createInscricoes(listaI.get(ix).toString(listaI.get(ix)));
							}
						}
					}else {
						io.reescreveInscricao(null);
						JOptionPane.showMessageDialog(null, "Não há mais inscricões registradas.");
					}
				}
			}else{
				if(!listaD.isEmpty()) {
					if(i==0) {
						io.reescreveDisciplina(listaD.get(i).toString(listaD.get(i)));
					}else {
						io.createDisciplinas(listaD.get(i).toString(listaD.get(i)));
					}
				}else {
					io.reescreveDisciplina(null);
					JOptionPane.showMessageDialog(null, "Não há mais disciplinas registradas.");
				}
			}
		}
	}

	private String encontrarPosInscricao(Lista<inscricao> lista, String chave) throws Exception {
		for (int i = 0; i < lista.size(); i++) {
			if(chave.equalsIgnoreCase(String.valueOf(lista.get(i).getCodDisciplina()))) {
				return String.valueOf(i);
			}
		}
		return null;
	}
	
	public void deleteCursos(String texts) throws Exception {
		String[] valoresCur = texts.split(";");
		iIOarquivos io = new IOarquivos();
		listaC = io.chamarCursos();
		for (int i = 0; i < listaC.size(); i++) {
			int cod = listaC.get(i).getCodCursos();
			if(cod == Integer.parseInt(valoresCur[0])){
				listaC.remove(i);
				continue;
			}
			if(!listaC.isEmpty()) {
				if(i==0) {
					io.reescreveCurso(listaC.get(i).toString(listaC.get(i)));
				}else {
					io.createCursos(listaC.get(i).toString(listaC.get(i)));
				}
			}else{
				io.reescreveCurso(null);
				JOptionPane.showMessageDialog(null, "Não há mais cursos registrados.");
			}
		}
	}
	
	public void deleteProfessores(String texts) throws Exception {
		String[] valoresPro = texts.split(";");
		iIOarquivos io = new IOarquivos();
		listaP = io.chamarProfessores();
		for (int i = 0; i < listaP.size(); i++) {
			long cod = listaP.get(i).getCPF();
			if(cod == Long.parseLong(valoresPro[0])){
				listaP.remove(i);
				continue;
			}
			if(!listaP.isEmpty()) {
				if(i==0) {
					io.reescreveProfessor(listaP.get(i).toString(listaP.get(i)));
				}else {
					io.createProfessores(listaP.get(i).toString(listaP.get(i)));
				}
			}else{
				io.reescreveProfessor(null);
				JOptionPane.showMessageDialog(null, "Não há mais professores registrados.");
			}
		}
	}
	
	public void deleteInscricao(String texts) throws Exception {
		String[] valoresIns = texts.split(";");
		iIOarquivos io = new IOarquivos();
		listaI = io.chamarInscricoes();
		for (int i = 0; i < listaI.size(); i++) {
			int cod = listaI.get(i).getCodProcesso();
			if(cod == Integer.parseInt(valoresIns[0])){
				listaI.remove(i);
				continue;
			}
			if(!listaI.isEmpty()) {
				if(i==0) {
					io.reescreveInscricao(listaI.get(i).toString(listaI.get(i)));
				}else {
					io.createInscricoes(listaI.get(i).toString(listaI.get(i)));
				}
			}else{
				io.reescreveInscricao(null);
				JOptionPane.showMessageDialog(null, "Não há mais incrições registradas.");
			}
		}
	}
}
