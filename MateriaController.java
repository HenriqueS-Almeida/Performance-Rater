package controller;

import javax.swing.*;

import dao.MateriaDao;
import model.Materia;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class MateriaController {

    public void salvar(String nome, String u_nome) 
		throws SQLException
	{
        Materia materia = new Materia();
        materia.setNome(nome);
        materia.setU_nome(u_nome);
        
        new MateriaDao().salvar(materia);
    }

    public void alterarNota(String nome, Double nota, int bim) 
		throws SQLException 
	{
        
		Materia materia = new Materia();
        materia.setNome(nome);
        materia.alterarNota(bim, nota);

        new MateriaDao().alterarNota(materia, bim);
    }

    public List listaMaterias() {
        MateriaDao dao = new MateriaDao();
        try {
            return dao.findMaterias();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, 
				"Problemas ao localizar materian" + 
				e.getLocalizedMessage()
			);
        }
        return null;
    }

    public void excluir(String nome) throws SQLException {
        new MateriaDao().excluir(nome);
    }

    public Materia buscaMateriaPorNome(String nome) throws SQLException {
        MateriaDao dao = new MateriaDao();
        return dao.findByName(nome);
    }
}