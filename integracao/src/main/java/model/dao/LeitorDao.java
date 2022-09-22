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
import model.beans.Leitor;

public class LeitorDao extends GenericDao {

    public void create(Leitor l) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Leitor(leitor_rg,leitor_nome,leitor_email) VALUES(?,?,?) ");
            stmt.setInt(1, l.getRg());
            stmt.setString(2, l.getNome());
            stmt.setString(3, l.getEmail());
            GenericDao.create(stmt, con);

        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Leitor> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor");
            GenericDao.read(stmt, con);
            while (rs.next()) {
                Leitor l = new Leitor();
                l.setRg(rs.getInt("leitor_rg"));
                l.setNome(rs.getString("leitor_nome"));
                l.setEmail(rs.getString("leitor_email"));
                leitores.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return leitores;
    }
    
    public List<Leitor> readFor(String nome) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor WHERE leitor_nome LIKE '%?%'");
            stmt.setString(1, nome);
            
            GenericDao.read(stmt, con);
            while (rs.next()) {
                Leitor l = new Leitor();
                l.setRg(rs.getInt("leitor_rg"));
                l.setNome(rs.getString("leitor_nome"));
                l.setEmail(rs.getString("leitor_email"));
                leitores.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return leitores;
    }
    
    public List<Leitor> readFor(int rg) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Leitor> leitores = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM leitor WHERE leitor_rg = ?");
            stmt.setInt(1, rg);
            
            GenericDao.read(stmt, con);
            while (rs.next()) {
                Leitor l = new Leitor();
                l.setRg(rs.getInt("leitor_rg"));
                l.setNome(rs.getString("leitor_nome"));
                l.setEmail(rs.getString("leitor_email"));
                leitores.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return leitores;
    }
    
    public void update(Leitor l) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "UPDATE leitor SET leitor_rg = ?,leitor_nome = ?,leitor_email = ?, WHERE leitor_rg = ?"
            );
            stmt.setInt(1, l.getRg());
            stmt.setString(2, l.getNome());
            stmt.setString(3, l.getEmail());
            stmt.setInt(4, l.getRg());
            
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete(Leitor l) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "DELETE FROM leitor WHERE leitor_rg = ?"
            );
            stmt.setInt(1, l.getRg());
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
}
