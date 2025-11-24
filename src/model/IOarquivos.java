package model;
import java.io.*; 
import ed.lib.Filas.controllerFilas;
import br.edu.fateczl.Lista;
public class IOarquivos implements iIOarquivos{
	private String path = "";
	private File arqD; 
	private File arqC;
	private File arqP; 
	private File arqI;
	public IOarquivos() throws IOException {
		this.path = System.getProperty("user.home") + File.separator + "SistemaConcurso";
		File dir = new File(path);
		if(!dir.exists()) {
			dir.mkdir();
		}
		this.arqD = new File(path, "disciplinas.csv");
		this.arqC = new File(path, "cursos.csv");     
		this.arqP = new File(path, "professores.csv");
		this.arqI = new File(path, "inscricoes.csv"); 
	}
	
	@Override
	public void reescreveDisciplina(String d) throws IOException {
		if(d == null) {
			FileWriter fw = new FileWriter(arqD);
		}else {
			FileWriter fw = new FileWriter(arqD);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(d + "\r\n");
			pw.flush();
			pw.close();
			fw.close();
		}
	}
	
	@Override
	public void reescreveCurso(String c) throws IOException {
		if(c == null) {
			FileWriter fw = new FileWriter(arqC);
		}else {
			FileWriter fw = new FileWriter(arqC);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(c + "\r\n");
			pw.flush();
			pw.close();
			fw.close();
		}
	}
	
	@Override
	public void reescreveProfessor(String p) throws IOException {
		if(p == null) {
			FileWriter fw = new FileWriter(arqP);
		}else {
			FileWriter fw = new FileWriter(arqP);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(p + "\r\n");
			pw.flush();
			pw.close();
			fw.close();
		}
	}
	
	@Override
	public void reescreveInscricao(String i) throws IOException {
		if(i == null) {
			FileWriter fw = new FileWriter(arqI);
		}else {
			FileWriter fw = new FileWriter(arqI);
			PrintWriter pw = new PrintWriter(fw);
			pw.write(i + "\r\n");
			pw.flush();
			pw.close();
			fw.close();
		}
	}

	@Override
	public void createDisciplinas(String d) throws Exception {
		boolean existe = false;
		if(arqD.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arqD, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(d + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	@Override
	public void createCursos(String c) throws Exception {
		boolean existe = false;
		if(arqC.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arqC, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(c + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}

	@Override
	public void createProfessores(String p) throws Exception {
		boolean existe = false;
		if(arqP.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arqP, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(p + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
		
	}

	@Override
	public void createInscricoes(String i) throws Exception {
		boolean existe = false;
		if(arqI.exists()) {
			existe = true;
		}
		FileWriter fw = new FileWriter(arqI, existe);
		PrintWriter pw = new PrintWriter(fw);
		pw.write(i + "\r\n");
		pw.flush();
		pw.close();
		fw.close();
	}

	@Override
	public controllerFilas<disciplinas> readDisciplinas(String busca) throws Exception {
		controllerFilas<disciplinas> fila = new controllerFilas<disciplinas>();
		if(arqD.exists()) {
			FileInputStream fis = new FileInputStream(arqD);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				throw new Exception("Arquivo vazio.");
			}
			while (linha != null) {
				String[] linhas = linha.split(";");
				disciplinas d = new disciplinas(Integer.parseInt(linhas[0]),linhas[1],linhas[2],
						Integer.parseInt(linhas[3]), Integer.parseInt(linhas[4]),Integer.parseInt(linhas[5]));
				fila.enfileirar(d);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return fila;
		
	}
	@Override
	public controllerFilas<cursos> readCursos(String busca) throws Exception {
		controllerFilas<cursos> fila = new controllerFilas<cursos>();
		if(arqC.exists()) {
			FileInputStream fis = new FileInputStream(arqC);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				throw new Exception("Arquivo vazio.");
			}
			while (linha != null) {
				String[] linhas = linha.split(";");
				cursos d = new cursos(Integer.parseInt(linhas[0]),linhas[1],linhas[2]);
				fila.enfileirar(d);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return fila;
		
	}

	@Override
	public controllerFilas<professor> readProfessores(String busca) throws Exception {
		controllerFilas<professor> fila = new controllerFilas<professor>();
		if(arqP.exists()) {
			FileInputStream fis = new FileInputStream(arqP);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				throw new Exception("Arquivo vazio.");
			}
			while (linha != null) {
				String[] linhas = linha.split(";");
				professor p = new professor(Long.parseLong(linhas[0]),Integer.parseInt(linhas[1]),linhas[2],
						linhas[3]);
				fila.enfileirar(p);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return fila;
		
	}

	@Override
	public controllerFilas<inscricao> readInscricoes(String busca) throws Exception {
		controllerFilas<inscricao> fila = new controllerFilas<inscricao>();
		if(arqI.exists()) {
			FileInputStream fis = new FileInputStream(arqI);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				throw new Exception("Arquivo vazio.");
			}
			while (linha != null) {
				String[] linhas = linha.split(";");
				inscricao i = new inscricao(Integer.parseInt(linhas[0]),Integer.parseInt(linhas[1]),
						Long.parseLong(linhas[2]));
				fila.enfileirar(i);
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		return fila;
		
	}

	@Override
	public Lista<disciplinas> chamarDisciplinas() throws Exception {
		Lista<disciplinas> lista = new Lista<disciplinas>();
		if(!arqD.exists()) {
			FileWriter fw = new FileWriter(arqD);
			fw.close();
		}else if(arqD.exists()){
			FileInputStream fis = new FileInputStream(arqD);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				return lista;
			}
			
			while (linha != null) {
				String[] linhas = linha.split(";");
				disciplinas d = new disciplinas(Integer.parseInt(linhas[0]),linhas[1],linhas[2],
						Integer.parseInt(linhas[3]), Integer.parseInt(linhas[4]),Integer.parseInt(linhas[5]));
				if(lista.isEmpty()) {
					lista.addFirst(d);
				}else {
					lista.addLast(d);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		else {
			throw new Exception("Arquivo não encontrado.");
		}
		return lista;
	}

	@Override
	public Lista<cursos> chamarCursos() throws Exception {
		Lista<cursos> lista = new Lista<cursos>();
		if(!arqC.exists()) {
			FileWriter fw = new FileWriter(arqC);
			fw.close();
		}else if(arqC.exists()){
			FileInputStream fis = new FileInputStream(arqC);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				return lista;
			}
			
			while (linha != null) {
				String[] linhas = linha.split(";");
				cursos c = new cursos(Integer.parseInt(linhas[0]),linhas[1],linhas[2]);
				if(lista.isEmpty()) {
					lista.addFirst(c);
				}else {
					lista.addLast(c);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}else {
			throw new Exception("Arquivo não encontrado.");
		}
		return lista;
	}

	@Override
	public Lista<professor> chamarProfessores() throws Exception {
		Lista<professor> lista = new Lista<professor>();
		if(!arqP.exists()) {
			FileWriter fw = new FileWriter(arqP);
			fw.close();
		}else if(arqP.exists()){
			FileInputStream fis = new FileInputStream(arqP);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				return lista;
			}
			
			while (linha != null) {
				String[] linhas = linha.split(";");
				professor p = new professor(Long.parseLong(linhas[0]),Integer.parseInt(linhas[1]),linhas[2],
						linhas[3]);
				if(lista.isEmpty()) {
					lista.addFirst(p);
				}else {
					lista.addLast(p);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}else {
			throw new Exception("Arquivo não encontrado.");
		}
		return lista;
	}

	@Override
	public Lista<inscricao> chamarInscricoes() throws Exception {
		Lista<inscricao> lista = new Lista<inscricao>();
		if(!arqI.exists()) {
			FileWriter fw = new FileWriter(arqI);
			fw.close();
		}else if(arqI.exists()){
			FileInputStream fis = new FileInputStream(arqI);
			InputStreamReader isr = new InputStreamReader(fis);
			BufferedReader buffer = new BufferedReader(isr);
			String linha = buffer.readLine();
			if(linha == null) {
				return lista;
			}
			
			while (linha != null) {
				String[] linhas = linha.split(";");
				inscricao i = new inscricao(Integer.parseInt(linhas[0]), Integer.parseInt(linhas[1]), 
						Long.parseLong(linhas[2]));
				if(lista.isEmpty()) {
					lista.addFirst(i);
				}else {
					lista.addLast(i);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			isr.close();
			fis.close();
		}
		else {
			throw new Exception("Arquivo não encontrado.");
		}
		return lista;
	}

}
