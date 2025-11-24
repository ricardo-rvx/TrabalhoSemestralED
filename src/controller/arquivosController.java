package controller;
import model.*;
import br.edu.fateczl.Lista;
public class arquivosController {
	static int ultimaLinha;
	private Lista<inscricao> listaI = new Lista<inscricao>();
	private Lista<professor> listaP = new Lista<professor>();
	private Lista<cursos> listaC = new Lista<cursos>();
	private Lista<disciplinas> listaD = new Lista<disciplinas>();

	
	public String buscarInscritos(String chave) throws Exception{
		Lista<Long> listaCPFs = new Lista<Long>();
		Lista<professor> listaFinal = new Lista<professor>();
		String resultado = "";
		iIOarquivos io = new IOarquivos();
		listaI = io.chamarInscricoes();
		listaP = io.chamarProfessores();
		for (int i = 0; i < listaI.size(); i++) {
			if(listaI.get(i).getCodDisciplina() == Integer.parseInt(chave)) {
				listaCPFs.addFirst(listaI.get(i).getCpf());
			}
		}
		for (int i = 0; i < listaP.size(); i++) {
			long cpf = listaP.get(i).getCPF();
			if(contains(cpf, listaCPFs)) {
				listaFinal.addFirst(listaP.get(i));
			}
		}
		listaFinal = organizaLista(listaFinal);
		for (int i = 0; i < listaFinal.size(); i++) {
			resultado = resultado + "CPF: \t"+listaFinal.get(i).getCPF()+"\tNome: \t"+listaFinal.get(i).getNomeProfessor()
					+"\tQtd. Pontos: \t"+listaFinal.get(i).getQtdPontos()+"\tÁrea conhecimento: \t"
					+listaFinal.get(i).getAreaConhecimento()+"\n";
		}
		return resultado;
	}
	
	private Lista<professor> organizaLista(Lista<professor> listaFinal) throws Exception {
		Lista<professor> listaNova = new Lista<professor>();
		professor[] vetProfessores = new professor[listaFinal.size()];
		for (int i = 0; i < vetProfessores.length; i++) {
			vetProfessores[i] = listaFinal.get(i);
		}
		vetProfessores = ordenaVetor(vetProfessores);
		for (int i = 0; i < vetProfessores.length; i++) {
			listaNova.add(vetProfessores[i], i);
		}
		return listaNova;
	}

	private professor[] ordenaVetor(professor[] vetProfessores) { //bubble sort
		int tamanho = vetProfessores.length;
		for (int i = 0; i < tamanho-1; i++) {
			for (int j = 1; j < tamanho; j++) {
				if(vetProfessores[i].getQtdPontos()<vetProfessores[j].getQtdPontos()) {
					professor aux = vetProfessores[i];
					vetProfessores[i] = vetProfessores[j];
					vetProfessores[j] = aux;
				}
			}
		}
		return vetProfessores;
	}

	private boolean contains(long chave, Lista<Long> lista) throws Exception {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i) == chave) {return true;}
		}
		return false;
	}
	
	public String listarTodasDisciplinas() throws Exception {
		disciplinas d = new disciplinas(0, null, null, 0, 0, 0);
		iIOarquivos io = new IOarquivos();
		listaC = io.chamarCursos();
		listaI = io.chamarInscricoes();
		int tamanho = listaC.size();
		tabelaEspalhamento tabela = new tabelaEspalhamento(tamanho);
		tabela = preencherTabela(tabela, listaI);
        String todas = "";
        for (int i = 0; i < tamanho; i++) {
        	int tam = tabela.getLista(i).size();
			for (int j = 0; j < tam ; j++) {
				d = tabela.getLista(i).get(j);
				todas = todas + "Cód. Disciplina: "+d.getCodDisciplina()+" \tDisciplina: "+d.getNomeDisciplina()+"\tDia Semana: "
				+d.getDiaSemana()+"\t Hora inicial: "+d.getHoraIni()+"\tQtd. Horas diaria: "+d.getQtdHoraDiaria()
				+"\tCód. curso: "+d.getCodCurso()+"\r\n";
			}
        }
        return todas;
    }

	private tabelaEspalhamento preencherTabela(tabelaEspalhamento tabela, Lista<inscricao> lista) throws Exception {
		iIOarquivos io = new IOarquivos();
		listaD = io.chamarDisciplinas();
		for (int i = 0; i < listaD.size(); i++) {
			if(containsCodDisciplina(listaD.get(i).getCodDisciplina(), lista)) {
				tabela.inserir(listaD.get(i));
			}
		}
		return tabela;
	}

	private boolean containsCodDisciplina(int codDisciplina, Lista<inscricao> lista) throws Exception {
		for (int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodDisciplina() == codDisciplina){
				return true;
			}
		}
		return false;
	}
}
