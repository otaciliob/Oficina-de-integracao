/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.beans.Leitor;
import model.dao.LeitorDao;

/**
 *
 * @author Computador
 */
public class test {

    public static void main(String[] args) {
        Leitor l = new Leitor(112223334, "leitor", "leitor@gmail.com");

        LeitorDao dao = new LeitorDao();
        dao.create(l);
    }
}
