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

import model.beans.Livros;

public class LivrosDao {
    
    private Connection con = null;

    public LivrosDao(String teste) {
        con = ConnectionFactory.getConnection(teste);
    }

    public LivrosDao() {
        con = ConnectionFactory.getConnection();
    }        
    
	public void create(Livros l) {
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Livro(livro_id,livro_titulo,Livros_autor,livro_unidade,livro_datapublicacao) VALUES(?,?,?) ");
            stmt.setString(1, l.getTitulo());
            stmt.setString(2, l.getAutor());
            stmt.setInt(3, l.getUnidades());
            stmt.setDate(4, l.getData_publicacao());
            
            GenericDao.create(stmt, con);

        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public List<Livros> read() {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livros> book = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Livros");
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
                Livros l = new Livros(
                	rs.getInt("Livro_id"),
                	rs.getString("Livro_titulo"),
                	rs.getString("Livro_autor"),
                	rs.getInt("Livro_unidade"),
                	rs.getDate("Livro_dataPublicacao")
                );
                book.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return book;
    }
    
    public List<Livros> readFor(String titulo) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livros> book = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Livros WHERE Livros_titulo LIKE '%?%'");
            stmt.setString(1, titulo);
            
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
            	Livros l = new Livros(
                    	rs.getInt("Livro_id"),
                    	rs.getString("Livro_titulo"),
                    	rs.getString("Livro_autor"),
                    	rs.getInt("Livro_unidade"),
                    	("Livro_dataPublicacao")
                    );
            	book.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return book;
    }
    
    public List<Livros> readFor(int rg) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Livros> book = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Livros WHERE Livros_rg = ?");
            stmt.setInt(1, rg);
            
            rs = GenericDao.read(stmt, con);
            while (rs.next()) {
                Livros l = new Livros(
                	rs.getInt("Livro_id"),
                	rs.getString("Livro_titulo"),
                	rs.getString("Livro_autor"),
                	rs.getInt("Livro_unidade"),
                	rs.getDate("Livro_dataPublicacao")
                );
                book.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return book;
    }
    /*
    public void update(Livros l,int rg) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "UPDATE Livros SET Livros_rg = ?,Livros_ = ?,Livros_email = ? WHERE Livros_rg = ?"
            );
            stmt.setInt(1, l.getRg());
            stmt.setString(2, l.get());
            stmt.setString(3, l.getEmail());
            stmt.setInt(4, rg);
            
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    public void delete(Livros l) {
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement(
                "DELETE FROM Livros WHERE Livros_id = ?"
            );
            stmt.setInt(1, l.getRg());
            GenericDao.update(stmt, con);
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(LivrosDao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }*/
}
