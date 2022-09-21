package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.beans.Leitor;


public class LeitorDao extends GenericDao{
    public void create(Leitor l) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Leitor(leitor_rg,leitor_nome,leitor_email) VALUES(?,?,?) ");
            stmt.setInt(1,l.getRg());
            stmt.setString(2,l.getNome());
            stmt.setString(3,l.getEmail());
            GenericDao.create(stmt, con);
            
        } catch (SQLException ex) {
            Logger.getLogger(LeitorDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
