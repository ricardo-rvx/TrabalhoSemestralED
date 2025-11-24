package model;

public class professor {
	
	private long CPF;
	private int qtdPontos;
	private String nomeProfessor;
	private String areaConhecimento;
	
	public professor(long CPF, int qtdPontos, String nomeProfessor,
			String areaConhecimento) {
		this.CPF = CPF;
		this.qtdPontos = qtdPontos;
		this.nomeProfessor = nomeProfessor;
		this.areaConhecimento = areaConhecimento;
	}
	
	public String toString(professor p) {
		String str = String.valueOf(p.CPF)+";"+String.valueOf(p.qtdPontos)+";"+p.nomeProfessor
				+";"+p.areaConhecimento;
		return str;
	}
	
	public long getCPF() {
		return CPF;
	}

	public void setCPF(long CPF) throws Exception {
		if(CPF < 0) {
			throw new Exception("CPF inválido.");
		}
		if(String.valueOf(CPF).length()!=11) {
			throw new Exception("CPF inválido.");
		}
		this.CPF = CPF;
	}

	public int getQtdPontos() {
		return qtdPontos;
	}

	public void setQtdPontos(int qtdPontos) throws Exception {
		if(qtdPontos < 0) {
			throw new Exception("Valor negativo");
		}
		this.qtdPontos = qtdPontos;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}
	

}
