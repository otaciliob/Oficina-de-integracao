/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.beans.ComboItem;
import model.beans.Emprestimo;
import model.beans.Leitor;
import model.beans.Livros;
import model.dao.EmprestimoDao;
import model.dao.LeitorDao;
import model.dao.LivrosDao;

/**
 *
 * @author Computador
 */
public class TelaEmprestimo extends javax.swing.JFrame {

    LeitorDao dao = new LeitorDao();
    LivrosDao dao2 = new LivrosDao();
    EmprestimoDao dao3 = new EmprestimoDao();

    /**
     * Creates new form EmprestimoView
     */
    public TelaEmprestimo() {
        initComponents();

        DefaultTableModel modelo = (DefaultTableModel) tblEmprestimos.getModel();
        tblEmprestimos.setRowSorter(new TableRowSorter(modelo));
        zerar();
        comboBoxPopulate();
    }

    public String formatSqlDate(java.sql.Date data) throws Exception {
        if (data == null) {
            return null;
        }
        return new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(data.getTime()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbLeitor = new javax.swing.JComboBox();
        cmbLivro = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmpData = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmprestimos = new javax.swing.JTable();
        txtEmpPesquisar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empréstimo");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Leitor:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Livro:");

        cmbLeitor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbLeitor.setMaximumRowCount(900000000);
        cmbLeitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {null}));
        cmbLeitor.setToolTipText("");
        cmbLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLeitorActionPerformed(evt);
            }
        });

        cmbLivro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbLivro.setMaximumRowCount(900000000);
        cmbLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {null}));
        cmbLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLivroActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Empréstimos de Livros");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Campos obrigatórios possuem um (*)");

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("*");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data de Devolução:");

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("*");

        txtEmpData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnAdicionar.setText("Cadastrar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnRemover.setText("Excluir");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setText("formato: dd/MM/yyyy");

        tblEmprestimos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id do Livro", "RG do Leitor", "Data de Devolução"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmprestimos.setFocusable(false);
        tblEmprestimos.getTableHeader().setReorderingAllowed(false);
        tblEmprestimos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmprestimosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmprestimos);

        txtEmpPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpPesquisarKeyReleased(evt);
            }
        });

        jLabel11.setText("Pesquisar por RG:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdicionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlterar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRemover)
                .addGap(45, 45, 45))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtEmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmpData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLivro, 0, 465, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLeitor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(123, 123, 123))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbLeitor, cmbLivro});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addComponent(txtEmpData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnRemover))
                .addGap(13, 13, 13))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbLeitor, cmbLivro, txtEmpData});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void cmbLeitorActionPerformed(java.awt.event.ActionEvent evt) {                                          
        comboLeitor();
    }                                         

    private void cmbLivroActionPerformed(java.awt.event.ActionEvent evt) {                                         
        comboLivro();
    }                                        

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Emprestimo emp = carregaEmprestimo();

        if (dao2.consultaUnidades(Integer.valueOf(comboLivro())) <= 0 || !(dao3.restricao2(Integer.parseInt(comboLeitor()))) || !(dao3.validarData(txtEmpData.getText()))) {
            JOptionPane.showMessageDialog(null, "Erro");
        } else {
            if (comboLivro() == null || comboLeitor() == null) {
                JOptionPane.showMessageDialog(null, "Preencha o campo obrigatório");
            } else {
                try {
                    if (dao3.create(emp)) {
                        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                        dao2.emprestimo(Integer.valueOf(comboLivro()),1);
                        zerar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro");
                    }
                } catch (NullPointerException erro) {
                    System.out.println(erro);
                }
            }
        }
    }                                            

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {                                           
        Emprestimo emp = carregaEmprestimo();
        if ((comboLivro() == null || comboLeitor() == null)) {
            JOptionPane.showMessageDialog(null, "Preencha o campo obrigatório");
        } else {
            if (dao3.update(emp, Integer.valueOf(comboLeitor()), Integer.valueOf(comboLivro()))) {
                JOptionPane.showMessageDialog(null, "Dados alterados com sucesso");
                zerar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
    }                                          

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {                                           
        int confirma = JOptionPane.showConfirmDialog(null, "Quer mesmo excluir  o livro?", "Aviso", JOptionPane.YES_NO_OPTION);
        Emprestimo emp = carregaEmprestimo();
        if (confirma == JOptionPane.YES_OPTION) {
            if (dao3.delete(emp)) {
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso");
                dao2.emprestimo(Integer.valueOf(comboLivro()),0);
                zerar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
    }                                          

    private void tblEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {                                            
        // Evento para setar os campos da tabela no formulário
        setar_campos();
    }                                           

    private void txtEmpPesquisarKeyReleased(java.awt.event.KeyEvent evt) {                                            
        // Evento enquanto está digitando
        pesquisar();
    }                                           

    public void zerar() {
        DefaultTableModel modelo = (DefaultTableModel) tblEmprestimos.getModel();
        modelo.setNumRows(0);
        cmbLeitor.setSelectedIndex(0);
        cmbLivro.setSelectedIndex(0);
        txtEmpData.setText(null);
        for (Emprestimo emp : dao3.read()) {
            modelo.addRow(new Object[]{
                emp.getLivro_id(),
                emp.getLeitor_rg(),
                emp.getData_devolucao()
            });
        }
    }

    private void pesquisar() {
        DefaultTableModel modelo = (DefaultTableModel) tblEmprestimos.getModel();
        modelo.setNumRows(0);
        int rg = 0;
        try {
            if (txtEmpPesquisar.getText().length() > 0) {
                rg = Integer.valueOf(txtEmpPesquisar.getText());
                if (rg < 0) {
                    rg = 0;
                }
            } else {
                zerar();
            }
            for (Emprestimo emp : dao3.readFor(rg)) {
                modelo.addRow(new Object[]{
                    emp.getLivro_id(),
                    emp.getLeitor_rg(),
                    emp.getData_devolucao()
                });
            }
        } catch (NumberFormatException erro) {
            System.out.println(erro);
        }
    }

    private void setar_campos() {
        int setar = tblEmprestimos.getSelectedRow();
        // TODO Fazer o setar funcionar nos combobox
        String leitor = tblEmprestimos.getModel().getValueAt(setar, 1).toString();
        String livro = "ID: " + tblEmprestimos.getModel().getValueAt(setar, 0).toString();
        for(int i = 1; i < cmbLeitor.getItemCount();i++){
            if( cmbLeitor.getItemAt(i).toString().contains(leitor) ){
                cmbLeitor.setSelectedIndex(i);break;
            }
        }
        for(int i = 1; i < cmbLivro.getItemCount();i++){
            if( cmbLivro.getItemAt(i).toString().contains(livro) ){
                cmbLivro.setSelectedIndex(i);break;
            }
        }
        try {
            String ds1 = tblEmprestimos.getModel().getValueAt(setar, 2).toString();
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
            String ds2 = sdf2.format(sdf1.parse(ds1));
            txtEmpData.setText(ds2);
        } catch (ParseException erro) {
            System.out.println(erro);
        }
    }

    public void comboBoxPopulate() {
        for (Leitor lei : dao.read()) {
            cmbLeitor.addItem(new ComboItem("Nome: " + lei.getNome() + " || RG: " + Integer.toString(lei.getRg()) + " || E-mail: " + lei.getEmail(), Integer.toString(lei.getRg())));
        }
        for (Livros liv : dao2.select()) {
            cmbLivro.addItem(new ComboItem("Título: " + liv.getNome() + " || Autor: " + liv.getAutor() + " || Ano: " + liv.getAno() + " || ID: " + Integer.toString(liv.getId()), Integer.toString(liv.getId())));
        }
    }

    public Emprestimo carregaEmprestimo() {
        Emprestimo emp = null;
        SimpleDateFormat dateFor = new SimpleDateFormat("dd/MM/yyyy");

        try {
            int id = Integer.valueOf(comboLivro());
            int rg = Integer.valueOf(comboLeitor());
            Date date = dateFor.parse(txtEmpData.getText());
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            emp = new Emprestimo(id, rg, sqlDate);
        } catch (ParseException | NumberFormatException erro) {
            System.out.println(erro);
            JOptionPane.showMessageDialog(null, "Erro");
        }

        return emp;
    }

    public String comboLivro() {
        // TODO: Previnir NullPointerException
        try {
            Object item = cmbLivro.getSelectedItem();
            String value = ((ComboItem) item).getValue();
            return value;
        } catch (NullPointerException erro) {
            System.out.println(erro);
        }
        return null;
    }

    public String comboLeitor() {
        // TODO: Previnir NullPointerException
        try {
            Object item = cmbLeitor.getSelectedItem();
            String value = ((ComboItem) item).getValue();
            return value;
        } catch (NullPointerException erro) {
            System.out.println(erro);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaEmprestimo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cmbLeitor;
    private javax.swing.JComboBox cmbLivro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblEmprestimos;
    private javax.swing.JTextField txtEmpData;
    private javax.swing.JTextField txtEmpPesquisar;
    // End of variables declaration                   
}
