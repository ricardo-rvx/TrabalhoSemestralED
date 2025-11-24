package model;
import br.edu.fateczl.Lista;

public class tabelaEspalhamento {
    private Lista<disciplinas>[] tabela;
    private int tamanho;

    public tabelaEspalhamento(int tamanho) {
        this.tamanho = tamanho;
        this.tabela = (Lista<disciplinas>[]) new Lista[tamanho];
        for (int i = 0; i < tamanho; i++) {
            this.tabela[i] = new Lista<>();
        }
    }
    private int funcaoHash(int codigoDisciplina) {
    	int tam = this.tamanho;
    	if(tam>0) {
    		return Math.abs(codigoDisciplina % tam);
    	}
    	else return 0;
    }
    public void inserir(disciplinas d) {
        int codigo = d.getCodDisciplina(); 
        int posicao = funcaoHash(codigo);
        tabela[posicao].addFirst(d);
    }

    public Lista<disciplinas> getLista(int posicao) {
        return this.tabela[posicao];
    }
}
