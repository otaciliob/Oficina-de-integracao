/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Emprestimo;

/**
 *
 * @author Computador
 */
public class EmprestimoDao {
    public void create(Emprestimo l) {
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO emprestimo(leitor_rg,livro_id,data_devolucao) VALUES(?,?,?) ");
            stmt.setInt(1, l.getLeitor_rg());
            stmt.setInt(2, l.getLivro_id());
            stmt.setDate(3, l.getData_devolucao());
            GenericDao.create(stmt, con);

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    private Connection con = null;

    public EmprestimoDao(String teste) {
        con = ConnectionFactory.getConnection(teste);
    }

    public EmprestimoDao() {
        con = ConnectionFactory.getConnection();
    }
      
    public List<Emprestimo> read() {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestado = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo");
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
                Emprestimo l = new Emprestimo();
                l.setLeitor_rg(rs.getInt("leitor_rg"));
                l.setLivro_id(rs.getInt("livro_id"));
                l.setData_devolucao(rs.getDate("data_devolucao"));
                emprestado.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return emprestado;
    }
    
    public List<Emprestimo> readFor(int rg) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestado = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE leitor_rg LIKE '%?%'");
            stmt.setInt(1, rg);
            
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
                Emprestimo l = new Emprestimo();
                l.setLeitor_rg(rs.getInt("leitor_rg"));
                l.setLivro_id(rs.getInt("livro_id"));
                l.setData_devolucao(rs.getDate("data_devolucao"));
                emprestado.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return emprestado;
    }
    //<editor-fold>
    /*
    public List<Emprestimo> readFor(int id) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Emprestimo> emprestado = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM emprestimo WHERE emprestimo_rg = ?");
            stmt.setInt(1, rg);
            
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
                Emprestimo l = new Emprestimo();
                l.setRg(rs.getInt("emprestimo_rg"));
                l.setNome(rs.getString("emprestimo_nome"));
                l.setEmail(rs.getString("emprestimo_email"));
                emprestado.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return emprestado;
    }*/
    //</editor-fold>
    public void update(Emprestimo l,int rg,int id) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "UPDATE emprestimo SET emprestimo_rg = ?,emprestimo_nome = ?,emprestimo_email = ? WHERE leitor_rg = ? and livro_id = ?"
            );
            stmt.setInt(1, l.getLeitor_rg());
            stmt.setInt(2, l.getLivro_id());
            stmt.setDate(3, l.getData_devolucao());
            stmt.setInt(4, rg);
            stmt.setInt(5, id);
            
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete(Emprestimo l) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "DELETE FROM emprestimo WHERE leitor_rg = ? and livro_id ?"
            );
            stmt.setInt(1, l.getLeitor_rg());
            stmt.setInt(2, l.getLivro_id());
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(EmprestimoDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
