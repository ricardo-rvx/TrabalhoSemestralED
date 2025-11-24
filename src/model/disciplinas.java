package model;

public class disciplinas {
	private int codDisciplina; 
	private String nomeDisciplina; 
	private String diaSemana; 
	private int horaIni; 
	private int qtdHoraDiaria;
	private int codCurso;
	
	
	public disciplinas(int codDisciplina, String nomeDisciplina, String diaSemana, 
			int horaIni, int qtdHoraDiaria, int codCurso){
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.diaSemana = diaSemana;
		this.horaIni = horaIni;
		this.qtdHoraDiaria = qtdHoraDiaria;
		this.codCurso = codCurso;
	}
	
	public String toString(disciplinas d) {
		String str = String.valueOf(d.codDisciplina)+";"+d.nomeDisciplina+";"+d.diaSemana
				+";"+String.valueOf(d.horaIni)+";"+String.valueOf(d.qtdHoraDiaria)+";"
				+String.valueOf(d.codCurso);
		return str;
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


	public String getNomeDisciplina() {
		return nomeDisciplina;
	}


	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}


	public String getDiaSemana() {
		return diaSemana;
	}


	public void setDiaSemana(String diaSemana) throws Exception {
		this.diaSemana = diaSemana;
	}


	public int getHoraIni(){
		return horaIni;
	}


	public void setHoraIni(int horaIni) throws Exception {
		if(horaIni < 0 || horaIni > 24) {
			throw new Exception("Valor negativo");
		}
		this.horaIni = horaIni;
	}


	public int getQtdHoraDiaria() {
		return qtdHoraDiaria;
	}


	public void setQtdHoraDiaria(int qtdHoraDiaria) throws Exception {
		if(qtdHoraDiaria < 0) {
			throw new Exception("Valor negativo");
		}
		this.qtdHoraDiaria = qtdHoraDiaria;
	}


	public int getCodCurso() {
		return codCurso;
	}


	public void setCodCurso(int codCurso) throws Exception {
		if(codCurso < 0) {
			throw new Exception("Valor negativo");
		}
		this.codCurso = codCurso;
	}
}


