package model;

public class Aluno {
	private String nome, senha, curso;
	private int id, serie;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public int getSerie() {
		return serie;
	}
	
	public void setSerie(int serie) {
		this.serie = serie;
	}
	
	public Aluno() {
	}
	
	public Aluno(int id, String nome, String senha, String curso, int serie) {
		super();
		this.id=id;
		this.nome = nome;
		this.senha = senha;
		this.curso = curso;
		this.serie = serie;
	}
	
	
}
