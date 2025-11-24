package model;
public class inscricao {
	private int codProcesso;
	private int codDisciplina;
	private long cpf;
	
	public inscricao(int codProcesso, int codDisciplina, long cpf) {
		this.codProcesso = codProcesso;
		this.codDisciplina = codDisciplina;
		this.cpf = cpf;
	}
	
	public String toString(inscricao i) {
		String str = String.valueOf(i.codProcesso)+";"+String.valueOf(i.codDisciplina)+";"+String.valueOf(i.cpf);
		return str;
	}
	
	
	public long getCpf() {
		return cpf;
	}

	public void setCPF(long CPF) throws Exception {
		if(CPF < 0) {
			throw new Exception("CPF inválido.");
		}
		if(String.valueOf(CPF).length()!=11) {
			throw new Exception("CPF inválido.");
		}
		this.cpf = CPF;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) throws Exception {
		if(codDisciplina < 0) {
			throw new Exception("Valor negativo");
		}
		this.codDisciplina = codDisciplina;
	}

	public int getCodProcesso() {
		return codProcesso;
	}

	public void setCodProcesso(int codProcesso) throws Exception {
		if(codProcesso< 0) {
			throw new Exception("Valor negativo");
		}
		this.codProcesso = codProcesso;
	}
	
	
}
