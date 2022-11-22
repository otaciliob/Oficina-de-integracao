package dao;

import model.dao.EmprestimoDao;
import model.dao.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;
import model.beans.Emprestimo;

/**
 *
 * @author D-JTP
 */
public class TelaEmprestimoTest {

    static Connection conexao;
    private static final String url = "jdbc:mysql://localhost:3306/teste";
    EmprestimoDao dao = new EmprestimoDao(url);

    @Before
    public void setup() throws SQLException {
        conexao = ConnectionFactory.getConnection(url);
        String sqllivroinsert = "INSERT INTO livro(livro_id, livro_nome, livro_autor, livro_ano, livro_unidades) VALUES(1, 'Java: Como Programar', 'Paul Deitel e Harvey Deitel', 2016, 36)";
        String sqllivroinsert02 = "INSERT INTO livro(livro_id, livro_nome, livro_autor, livro_ano, livro_unidades) VALUES(2, 'Código limpo: Habilidades práticas do Agile Software', 'Robert C. Martin', 2009, 21)";

        String sqlleitorinsert = "INSERT INTO leitor(leitor_rg, leitor_nome, leitor_email) VALUES(1, 'João', 'e-mail@e-mail.com')";
        String sqlleitorinsert02 = "INSERT INTO leitor(leitor_rg, leitor_nome, leitor_email) VALUES(2, 'José', 'e-mail02@e-mail02.com')";

        String sqlemprestimoinsert = "INSERT INTO emprestimo(livro_id, leitor_rg, data_devolucao) VALUES(1, 1, '2022-02-10')";
        String sqlemprestimoinsert02 = "INSERT INTO emprestimo(livro_id, leitor_rg, data_devolucao) VALUES(2, 2, '2022-06-10')";
        PreparedStatement ps = conexao.prepareStatement(sqllivroinsert);
        ps.executeUpdate(sqllivroinsert);
        ps.executeUpdate(sqllivroinsert02);
        ps.executeUpdate(sqlleitorinsert);
        ps.executeUpdate(sqlleitorinsert02);
        ps.executeUpdate(sqlemprestimoinsert);
        ps.executeUpdate(sqlemprestimoinsert02);
    }

    @Test
    public void testLivrosQuantidadeDeLivrosCadastradosCorreta() {
        List<Emprestimo> emp = dao.read();
        assertEquals(emp.size(), 2);
        assertEquals(emp.get(0).getLivro_id(), 1);
        assertEquals(emp.get(0).getLeitor_rg(), 1);
    }

    @Test
    public void testEmprestimoReadForCorreto() {
        List<Emprestimo> emp = dao.readFor(1);

        assertEquals(emp.get(0).getLivro_id(), 1);
        assertEquals(emp.get(0).getLeitor_rg(), 1);
        assertEquals(emp.get(0).getData_devolucao().toString(), "2022-02-10");
    }

    @Test
    public void testEmprestimoReadForIncorreto() {
        List<Emprestimo> emp = dao.readFor(2);

        assertNotEquals(emp.get(0).getLivro_id(), 1);
        assertNotEquals(emp.get(0).getLeitor_rg(), 1);
        assertNotEquals(emp.get(0).getData_devolucao().toString(), "2022-02-10");
    }

    @Test
    public void testEmprestimoDadosDoPrimeiroInsertCorretos() {
        List<Emprestimo> emp = dao.read();

        assertEquals(emp.get(0).getLivro_id(), 1);
        assertEquals(emp.get(0).getLeitor_rg(), 1);
        assertEquals(emp.get(0).getData_devolucao().toString(), "2022-02-10");
    }

    @Test
    public void testEmprestimoDadosDoPrimeiroInsertIncorretos() {
        List<Emprestimo> emp = dao.read();

        assertNotEquals(emp.get(0).getLivro_id(), 2);
        assertNotEquals(emp.get(0).getLeitor_rg(), 2);
        assertNotEquals(emp.get(0).getData_devolucao().toString(), "2022-06-10");
    }

    @Test
    public void testEmprestimoDadosDoSegundoInsertCorretos() {
        List<Emprestimo> emp = dao.read();

        assertEquals(emp.get(1).getLivro_id(), 2);
        assertEquals(emp.get(1).getLeitor_rg(), 2);
        assertEquals(emp.get(1).getData_devolucao().toString(), "2022-06-10");
    }

    @Test
    public void testEmprestimoDadosDoSegundoInsertIncorretos() {
        List<Emprestimo> emp = dao.read();

        assertNotEquals(emp.get(1).getLivro_id(), 1);
        assertNotEquals(emp.get(1).getLeitor_rg(), 1);
        assertNotEquals(emp.get(1).getData_devolucao().toString(), "2022-02-10");
    }

    @Test
    public void testEmprestimoDeleteCorreto() throws SQLException {
        String sqlinsertliv = "INSERT INTO livro(livro_id, livro_nome, livro_autor, livro_ano, livro_unidades) VALUES(3, 'Nome', 'Autor', 0, 0)";
        String sqlinsertlei = "INSERT INTO leitor(leitor_rg, leitor_nome, leitor_email) VALUES(3, 'Júnior', 'e-mail03@e-mail03.com')";
        String sqlinsertemp = "INSERT INTO emprestimo(livro_id, leitor_rg, data_devolucao) VALUES(3, 3, '2022-08-10')";
        PreparedStatement ps = conexao.prepareStatement(sqlinsertliv);
        ps.executeUpdate(sqlinsertliv);
        ps.executeUpdate(sqlinsertlei);
        ps.executeUpdate(sqlinsertemp);
        List<Emprestimo> emp = dao.read();

        assertEquals(emp.get(2).getLivro_id(), 3);
        assertEquals(emp.get(2).getLeitor_rg(), 3);

        String sqldeleteemp = "DELETE FROM emprestimo WHERE livro_id = 3 AND leitor_rg = 3";
        String sqldeleteliv = "DELETE FROM livro WHERE livro_id = 3";
        String sqldeletelei = "DELETE FROM leitor WHERE leitor_rg = 3";
        ps.executeUpdate(sqldeleteemp);
        ps.executeUpdate(sqldeleteliv);
        ps.executeUpdate(sqldeletelei);
        emp = dao.readFor(3);
        assertEquals(emp.size(), 0);
    }

    
    @Test
    public void testEmprestimoDeleteIncorreto() throws SQLException {
        String sqlinsertliv = "INSERT INTO livro(livro_id, livro_nome, livro_autor, livro_ano, livro_unidades) VALUES(3, 'Nome', 'Autor', 0, 0)";
        String sqlinsertlei = "INSERT INTO leitor(leitor_rg, leitor_nome, leitor_email) VALUES(3, 'Júnior', 'e-mail03@e-mail03.com')";
        String sqlinsertemp = "INSERT INTO emprestimo(livro_id, leitor_rg, data_devolucao) VALUES(3, 3, '2022-08-10')";
        PreparedStatement ps = conexao.prepareStatement(sqlinsertliv);
        ps.executeUpdate(sqlinsertliv);
        ps.executeUpdate(sqlinsertlei);
        ps.executeUpdate(sqlinsertemp);
        List<Emprestimo> emp = dao.read();

        assertEquals(emp.get(2).getLivro_id(), 3);
        assertEquals(emp.get(2).getLeitor_rg(), 3);

        String sqldeleteemp = "DELETE FROM emprestimo WHERE livro_id = 3 AND leitor_rg = 3";
        String sqldeleteliv = "DELETE FROM livro WHERE livro_id = 3";
        String sqldeletelei = "DELETE FROM leitor WHERE leitor_rg = 3";
        ps.executeUpdate(sqldeleteemp);
        ps.executeUpdate(sqldeleteliv);
        ps.executeUpdate(sqldeletelei);
        emp = dao.readFor(3);
        assertNotEquals(emp.size(), 1);
    }

    @Test
    public void testEmprestimoDataInvalida() throws SQLException {
        try {
            String sqlinsertliv = "INSERT INTO livro(livro_id, livro_nome, livro_autor, livro_ano, livro_unidades) VALUES(3, 'Nome', 'Autor', 0, 0)";
        String sqlinsertlei = "INSERT INTO leitor(leitor_rg, leitor_nome, leitor_email) VALUES(3, 'Júnior', 'e-mail03@e-mail03.com')";
        String sqlinsertemp = "INSERT INTO emprestimo(livro_id, leitor_rg, data_devolucao) VALUES(3, 3, '10/04/2022')";
        PreparedStatement ps = conexao.prepareStatement(sqlinsertliv);
        ps.executeUpdate(sqlinsertliv);
        ps.executeUpdate(sqlinsertlei);
        ps.executeUpdate(sqlinsertemp);
        } catch (java.sql.DataTruncation e) {
            System.out.println(e);
        }
        List<Emprestimo> emp = dao.read();
        assertEquals(emp.size(), 2);
        String sqldeleteliv = "DELETE FROM livro WHERE livro_id = 3";
        String sqldeletelei = "DELETE FROM leitor WHERE leitor_rg = 3";
        PreparedStatement ps = conexao.prepareStatement(sqldeleteliv);
        ps.executeUpdate(sqldeleteliv);
        ps.executeUpdate(sqldeletelei);
    }

    @After
    public void after() throws SQLException {
        String sqlemprestimodelete = "DELETE FROM emprestimo WHERE livro_id = 1 AND leitor_rg = 1";
        String sqlemprestimodelete02 = "DELETE FROM emprestimo WHERE livro_id = 2 AND leitor_rg = 2";
        String sqllivrodelete = "DELETE FROM livro WHERE livro_id = 1";
        String sqllivrodelete02 = "DELETE FROM livro WHERE livro_id = 2";
        String sqlleitordelete = "DELETE FROM leitor WHERE leitor_rg = 1";
        String sqlleitordelete02 = "DELETE FROM leitor WHERE leitor_rg = 2";
        PreparedStatement ps = conexao.prepareStatement(sqllivrodelete);
        ps.executeUpdate(sqlemprestimodelete);
        ps.executeUpdate(sqlemprestimodelete02);
        ps.executeUpdate(sqllivrodelete);
        ps.executeUpdate(sqllivrodelete02);
        ps.executeUpdate(sqlleitordelete);
        ps.executeUpdate(sqlleitordelete02);
    }
}
