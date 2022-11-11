/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.dao.EmprestimoDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Computador
 */
public class EmprestimoTest {
    
    private final static String user = "root";
    private final static String pass = "barbieri07";
    private static final String url ="jdbc:mysql://localhost:3306/teste";
    EmprestimoDao dao = new EmprestimoDao(url);
    
    public EmprestimoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void teste1(){
        assertNotNull(dao.read());
    }
    
}
