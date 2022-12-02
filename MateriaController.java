package controller;

import javax.swing.*;

import dao.AlunoDao;
import model.Aluno;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class AlunoController {

    public void salvar(String nome, String senha, String curso, int serie) 
		throws SQLException
	{
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setSenha(senha);
        aluno.setCurso(curso);
        aluno.setSerie(serie);
        
        new AlunoDao().salvar(aluno);
    }

    public void alterar(int id, String nome, String senha, String curso, int serie) 
		throws SQLException 
	{
        
		Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(nome);
        aluno.setSenha(senha);
        aluno.setCurso(curso);
        aluno.setSerie(serie);

        new AlunoDao().alterar(aluno);
    }

    public List listaAlunos() {
        AlunoDao dao = new AlunoDao();
        try {
            return dao.findAlunos();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar alunon" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(int id) throws SQLException {
        new AlunoDao().excluir(id);
    }

    public Aluno buscaAlunoPorNome(String nome) throws SQLException {
        AlunoDao dao = new AlunoDao();
        return dao.findByName(nome);
    }
}
