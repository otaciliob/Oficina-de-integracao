/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
 * @author Aluno
 */
public class TelaEmprestimo extends javax.swing.JFrame {

    LeitorDao dao = new LeitorDao();
    LivrosDao dao2 = new LivrosDao();
    EmprestimoDao dao3 = new EmprestimoDao();

    /**
     * Creates new form TelaEmprestimo
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        txtEmpData = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtEmpPesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmbLivro = new javax.swing.JComboBox();
        btnRemover = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmprestimos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbLeitor = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAdicionar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Empréstimo");

        txtEmpData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel11.setText("Pesquisar por RG:");

        jLabel7.setForeground(new java.awt.Color(250, 250, 40));
        jLabel7.setToolTipText("");
        jLabel7.setMaximumSize(new java.awt.Dimension(10, 10));
        jLabel7.setMinimumSize(new java.awt.Dimension(10, 10));

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("*");

        jLabel10.setForeground(new java.awt.Color(255, 0, 51));
        jLabel10.setText("Campos obrigatórios possuem um (*)");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Leitor:");

        txtEmpPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEmpPesquisarKeyReleased(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("*");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Empréstimos de Livros");

        cmbLivro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbLivro.setMaximumRowCount(900000000);
        cmbLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {null}));
        cmbLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLivroActionPerformed(evt);
            }
        });

        btnRemover.setText("Excluir");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        tblEmprestimos = new javax.swing.JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tblEmprestimos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id do Livro", "RG do Leitor", "Data de Devolução", "Nome do Livro", "Nome do Leitor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data de Devolução:");

        cmbLeitor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbLeitor.setMaximumRowCount(900000000);
        cmbLeitor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {null}));
        cmbLeitor.setToolTipText("");
        cmbLeitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLeitorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Livro:");

        jLabel6.setForeground(new java.awt.Color(255, 0, 51));
        jLabel6.setText("*");

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

        jDateChooser2.setDateFormatString("dd/MM/yyyy");
        jDateChooser2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser2PropertyChange(evt);
            }
        });

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
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLivro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbLeitor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmpData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtEmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(234, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(123, 123, 123))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbLivro, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbLeitor, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3))
                    .addComponent(txtEmpData)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(btnAdicionar)
                    .addComponent(btnAlterar)
                    .addComponent(btnRemover))
                .addGap(13, 13, 13))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmpPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmpPesquisarKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtEmpPesquisarKeyReleased

    private void cmbLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLivroActionPerformed
        comboLivro();
    }//GEN-LAST:event_cmbLivroActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Quer mesmo excluir  o livro?", "Aviso", JOptionPane.YES_NO_OPTION);
        Emprestimo emp = carregaEmprestimo();
        if (confirma == JOptionPane.YES_OPTION) {
            if (dao3.delete(emp)) {
                JOptionPane.showMessageDialog(null, "Livro excluído com sucesso");
                dao2.emprestimo(Integer.valueOf(comboLivro()), 0);
                zerar();
            } else {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void tblEmprestimosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmprestimosMouseClicked
        setar_campos();
    }//GEN-LAST:event_tblEmprestimosMouseClicked

    private void cmbLeitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLeitorActionPerformed
        comboLeitor();
    }//GEN-LAST:event_cmbLeitorActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
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
                        dao2.emprestimo(Integer.valueOf(comboLivro()), 1);
                        zerar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro");
                    }
                } catch (NullPointerException erro) {
                    System.out.println(erro);
                }
            }
        }
    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
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
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void jDateChooser2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser2PropertyChange
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        if (!(jDateChooser2.getDate() == null)) {
            txtEmpData.setText(df.format(jDateChooser2.getDate()));
        }

    }//GEN-LAST:event_jDateChooser2PropertyChange

    public void zerar() {
        DefaultTableModel modelo = (DefaultTableModel) tblEmprestimos.getModel();
        modelo.setNumRows(0);
        cmbLeitor.setSelectedIndex(0);
        cmbLivro.setSelectedIndex(0);
        txtEmpData.setText(null);
        for (Emprestimo emp : dao3.read()) {
            List<Leitor> lei = dao.readFor(emp.getLeitor_rg());
            List<Livros> liv = dao2.selectFrom(emp.getLivro_id());

            modelo.addRow(new Object[]{
                emp.getLivro_id(),
                emp.getLeitor_rg(),
                emp.getData_devolucao(),
                lei.get(0).getNome(),
                liv.get(0).getNome(),});
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
        // TO-DO Fazer o setar funcionar nos combobox
        String leitor = tblEmprestimos.getModel().getValueAt(setar, 1).toString();
        String livro = "ID: " + tblEmprestimos.getModel().getValueAt(setar, 0).toString();
        for (int i = 1; i < cmbLeitor.getItemCount(); i++) {
            if (cmbLeitor.getItemAt(i).toString().contains(leitor)) {
                cmbLeitor.setSelectedIndex(i);
                break;
            }
        }
        for (int i = 1; i < cmbLivro.getItemCount(); i++) {
            if (cmbLivro.getItemAt(i).toString().contains(livro)) {
                cmbLivro.setSelectedIndex(i);
                break;
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
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaEmprestimo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JComboBox cmbLeitor;
    private javax.swing.JComboBox cmbLivro;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    // End of variables declaration//GEN-END:variables
}
