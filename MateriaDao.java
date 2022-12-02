package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materia;

public class MateriaDao extends GenericDao {

    public void salvar(Materia materia) throws SQLException {
        String insert = "INSERT INTO MATERIA(nome) VALUES(?);"+
        				"INSERT INTO ALUNO_MATERIA(nome_materia) VALUES(?)";
        save(insert, materia.getNome(), materia.getNome());
    }

    public void alterarNota(Materia materia, int bim) throws SQLException {
    	String update = "UPDATE ALUNO_MATERIA " +
                "SET n_"+bim+" = ? " +
                "WHERE materia_nome = ?";
        update(update, materia.getNome(), 
               materia.getMediaBimestral(bim));
    }

    public void excluir(String nome) throws SQLException {
        String delete = "DELETE FROM MATERIA WHERE nome = ?; " +
        				"DELETE FROM ALUNO_MATERIA WHERE nome_materia = ?";
        delete(delete, nome, nome);
    }

    public List findMaterias() throws SQLException {
        List materias = new ArrayList();

        String select = "SELECT * FROM MATERIA LEFT JOIN ALUNO_MATERIA";

        PreparedStatement stmt = 
	    getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Materia materia = new Materia();
            materia.setNome(rs.getString("nome"));
            materia.alterarNota(1, rs.getDouble("n_1"));
            materia.alterarNota(2, rs.getDouble("n_2"));
            materia.alterarNota(3, rs.getDouble("n_3"));
            materia.alterarNota(4, rs.getDouble("n_4"));
            materia.setU_id(rs.getInt("aluno_id"));
            materias.add(materia);
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return materias;
    }

    public Materia findByName(String nome) throws SQLException {
        String select = "SELECT * FROM MATERIAS WHERE nome = ?";
        Materia materia = null;
        PreparedStatement stmt = 
			getConnection().prepareStatement(select);
			
        stmt.setString(1, nome);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            materia = new Materia();
            materia.setNome(rs.getString("nome"));
            materia.alterarNota(1, rs.getDouble("n_1"));
            materia.alterarNota(2, rs.getDouble("n_2"));
            materia.alterarNota(3, rs.getDouble("n_3"));
            materia.alterarNota(4, rs.getDouble("n_4"));
            materia.setU_id(rs.getInt("aluno_id"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return materia;
    }
}
