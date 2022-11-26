package dao;

import model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import model.beans.Usuario;
import model.dao.UsuarioDao;

/**
 *
 * @author D-JTP
 */
public class TelaUsuarioTest {

    static Connection conexao;
    private static final String url = "jdbc:mysql://localhost:3306/teste";
    UsuarioDao dao = new UsuarioDao(url);

    @Before
    public void setup() throws SQLException {
        conexao = ConnectionFactory.getConnection(url);
        String sqlusuarioinsert = "INSERT INTO login(user, password) VALUES('A', '456')";
        String sqlusuarioinsert02 = "INSERT INTO login(user, password) VALUES('B', '123')";
        PreparedStatement ps = conexao.prepareStatement(sqlusuarioinsert);
        ps.executeUpdate(sqlusuarioinsert);
        ps.executeUpdate(sqlusuarioinsert02);
    }

    @Test
    public void testUsuarioQuantidadeDeUsuariosCadastradosCorreta() {
        List<Usuario> user = dao.select();
        assertEquals(user.size(), 2);
        assertEquals(user.get(0).getUser(), "A");
    }

    @Test
    public void testUsuarioSelectFromCorreto() {
        List<Usuario> user = dao.selectFrom("A");

        assertEquals(user.get(0).getUser(), "A");
        assertEquals(user.get(0).getPassword(), "456");
    }

    @Test
    public void testUsuarioSelectFromIncorreto() {
        List<Usuario> user = dao.selectFrom("B");

        assertNotEquals(user.get(0).getUser(), "A");
        assertNotEquals(user.get(0).getPassword(), "456");
    }

    @Test
    public void testUsuarioDadosDoPrimeiroInsertCorretos() {
        List<Usuario> user = dao.select();
        System.out.println(user.get(0).getUser());
        assertEquals(user.get(0).getUser(), "A");
        assertEquals(user.get(0).getPassword(), "456");
    }

    @Test
    public void testUsuarioDadosDoPrimeiroInsertIncorretos() {
        List<Usuario> user = dao.select();

        assertNotEquals(user.get(0).getUser(), "B");
        assertNotEquals(user.get(0).getPassword(), "123");
    }

    @Test
    public void testUsuarioDadosDoSegundoInsertCorretos() {
        List<Usuario> user = dao.select();

        assertEquals(user.get(1).getUser(), "B");
        assertEquals(user.get(1).getPassword(), "123");
    }

    @Test
    public void testLivrosDadosDoSegundoInsertIncorretos() {
        List<Usuario> user = dao.select();

        assertNotEquals(user.get(1).getUser(), "A");
        assertNotEquals(user.get(1).getPassword(), "456");
    }

    @Test
    public void testUsuarioDeleteCorreto() throws SQLException {
        String sqlinsert = "INSERT INTO login(user, password) VALUES('C', '789')";
        PreparedStatement ps = conexao.prepareStatement(sqlinsert);
        ps.executeUpdate(sqlinsert);
        List<Usuario> user = dao.select();

        assertEquals(user.get(2).getUser(), "C");

        String sqldelete = "DELETE FROM login WHERE user = 'C'";
        ps.executeUpdate(sqldelete);
        user = dao.selectFrom("C");
        assertEquals(user.size(), 0);
    }

    @Test
    public void testUsuarioDeleteIncorreto() throws SQLException {
        String sqlinsert = "INSERT INTO login(user, password) VALUES('C', '789')";
        PreparedStatement ps = conexao.prepareStatement(sqlinsert);
        ps.executeUpdate(sqlinsert);
        List<Usuario> user = dao.select();

        assertEquals(user.get(2).getUser(), "C");

        String sqldelete = "DELETE FROM login WHERE user = 'C'";
        ps.executeUpdate(sqldelete);
        user = dao.selectFrom("C");
        assertNotEquals(user.size(), 1);
    }

    @After
    public void after() throws SQLException {
        String sqllivrodelete = "DELETE FROM login WHERE user = 'A'";
        String sqllivrodelete02 = "DELETE FROM login WHERE user = 'B'";
        PreparedStatement ps = conexao.prepareStatement(sqllivrodelete);
        ps.executeUpdate(sqllivrodelete);
        ps.executeUpdate(sqllivrodelete02);
    }
}
