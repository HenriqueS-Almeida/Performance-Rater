package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

public class AlunoDao extends GenericDao {

    public void salvar(Aluno aluno) throws SQLException {
        String insert = "INSERT INTO ALUNOS(nome, senha, curso, serie) VALUES(?,?,?,?)";
        save(insert, aluno.getNome(), aluno.getSenha(), aluno.getCurso(), aluno.getSerie());
    }

    public void alterar(Aluno aluno) throws SQLException {
        String update = "UPDATE ALUNOS " +
                "SET nome = ?, senha = ?, curso = ? , serie = ?" +
                "WHERE id = ?";
        update(update, aluno.getId(), aluno.getNome(), aluno.getSenha(), aluno.getCurso(), aluno.getSerie());
    }

    public void excluir(int id) throws SQLException {
        String delete = "DELETE FROM ALUNOS WHERE id = ?";
        delete(delete, id);
    }

    public List findAlunos() throws SQLException {
        List alunos = new ArrayList();

        String select = "SELECT * FROM ALUNOS";

        PreparedStatement stmt = 
	    getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setSenha(rs.getString("senha"));
            aluno.setCurso(rs.getString("curso"));
            aluno.setSerie(rs.getInt("serie"));
            alunos.add(aluno);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return alunos;
    }

    public Aluno findByName(String nome) throws SQLException {
        String select = "SELECT * FROM ALUNOS WHERE nome = ?";
        Aluno aluno = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
        	aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setSenha(rs.getString("senha"));
            aluno.setCurso(rs.getString("curso"));
            aluno.setSerie(rs.getInt("serie"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return aluno;
    }
}
