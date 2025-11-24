package model;

public class cursos {
	
	private int codCursos;
	private String nomeCurso;
	private String areaConhecimento;
	
	public cursos(int cod, String nome, String area) {
		codCursos = cod;
		nomeCurso = nome;
		areaConhecimento = area;
	}
	
	public String toString(cursos c) {
		String str = String.valueOf(c.codCursos)+";"+c.nomeCurso+";"+c.areaConhecimento;
		return str;
	}
	
	
	public int getCodCursos() {
		return codCursos;
	}

	public void setCodCursos(int codCursos) throws Exception {
		if(codCursos < 0) {
			throw new Exception("Valor negativo");
		}
		this.codCursos = codCursos;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getAreaConhecimento() {
		return areaConhecimento;
	}

	public void setAreaConhecimento(String areaConhecimento) {
		this.areaConhecimento = areaConhecimento;
	}

	
	
}
