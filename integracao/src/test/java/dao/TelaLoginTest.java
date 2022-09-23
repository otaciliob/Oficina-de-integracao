/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dao;

import model.dao.LoginDao;
import model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TelaLoginTest {

    static Connection conexao;
    LoginDao dao = new LoginDao();
    private final static String user = "login";
    private final static String pass = "senha";

    @Before
    public void setup() throws SQLException {
        conexao = ConnectionFactory.getConnection();
        String sqllogininsert = "INSERT INTO login VALUES ('login','senha')";
        PreparedStatement ps = conexao.prepareStatement(sqllogininsert);
        ps.executeUpdate(sqllogininsert);
    }

    @Test
    public void testLogin() {
        assertEquals(true, dao.login(user, pass));
    }

    @Test
    public void testLogin02() {
        assertEquals(false, dao.login("no", "no"));
    }

    @Test
    public void testLogin03() {
        assertEquals(false, dao.login("", pass));
    }

    @Test
    public void testLogin04() {
        assertEquals(false, dao.login(user, ""));
    }

    @Test
    public void testLogin05() {
        assertEquals(true, dao.login("login", "senha"));
    }

    @Test
    public void testLogin06() {
        assertEquals(false, dao.login("user", "senha"));
    }

    @Test
    public void testLogin07() {
        assertEquals(false, dao.login("login", "123456"));
    }

    @Test
    public void testLogin08() throws SQLException {
        String sqllogininsert = "INSERT INTO login VALUES ('teste','123')";
        PreparedStatement ps = conexao.prepareStatement(sqllogininsert);
        ps.executeUpdate(sqllogininsert);

        assertEquals(true, dao.login("teste", "123"));

        String sqllogindelete = "DELETE FROM login WHERE user = 'teste'";
        ps = conexao.prepareStatement(sqllogindelete);
        ps.executeUpdate(sqllogindelete);
    }

    @Test
    public void testLogin09() {
        assertEquals(false, dao.login("login", ""));
    }

    @Test
    public void testLogin10() throws SQLException {
        String sqllogininsert = "INSERT INTO login VALUES ('teste','123')";
        PreparedStatement ps = conexao.prepareStatement(sqllogininsert);
        ps.executeUpdate(sqllogininsert);

        assertEquals(false, dao.login("false", "123"));

        String sqllogindelete = "DELETE FROM login WHERE user = 'teste'";
        ps = conexao.prepareStatement(sqllogindelete);
        ps.executeUpdate(sqllogindelete);
    }

    @After
    public void after() throws SQLException {
        String sqllogindelete = "DELETE FROM login WHERE user = 'login'";
        PreparedStatement ps = conexao.prepareStatement(sqllogindelete);
        ps.executeUpdate(sqllogindelete);
    }
}
