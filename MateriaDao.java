package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materia;

public class MateriaDao extends GenericDao {

    public void salvar(Materia materia) throws SQLException {
        String insert = "INSERT INTO MATERIAS(nome, u_nome) VALUES?,?)";
        save(insert, materia.getNome(), materia.getU_nome());
    }

    public void alterarNota(Materia materia, int bim) throws SQLException {
    	String update = "UPDATE MATERIAS " +
                "SET n"+bim+" = ? " +
                "WHERE nome = ?";
        update(update, materia.getNome(), 
               materia.getMediaBimestral(bim));
    }

    public void excluir(String nome) throws SQLException {
        String delete = "DELETE FROM MATERIAS WHERE nome = ?";
        delete(delete, nome);
    }

    public List findMaterias() throws SQLException {
        List materias = new ArrayList();

        String select = "SELECT * FROM MATERIAS";

        PreparedStatement stmt = 
	    getConnection().prepareStatement(select);
			
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Materia materia = new Materia();
            materia.setNome(rs.getString("nome"));
            materia.alterarNota(0, 0);
            materia.setU_nome(rs.getString("nome do usuario"));
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
            materia.alterarNota(0, 0);
            materia.setU_nome(rs.getString("nome do usuario"));
        }

        rs.close();
        stmt.close();
        getConnection().close();

        return materia;
    }
}
