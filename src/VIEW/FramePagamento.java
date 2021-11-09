/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLL.PagamentoController;
import java.beans.PropertyVetoException;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Jailton
 */
public class FramePagamento extends javax.swing.JInternalFrame {

    /**
     * Creates new form Pagamento
     */
    private final PagamentoController controle;

    public FramePagamento() throws PropertyVetoException {
        initComponents();
        this.setMaximum(true);
        this.controle = new PagamentoController(this);
        this.controle.CarregarTBLClientes();
        this.controle.SetarIcone();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TextTotal = new javax.swing.JTextField();
        TextValorAbater = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnAbater = new javax.swing.JButton();
        TextPesquisar = new javax.swing.JTextField();
        BtnPesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Clientes = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TablePagamentos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TextTotal.setEditable(false);
        TextTotal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(TextTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 16, 143, -1));

        TextValorAbater.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(TextValorAbater, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 80, 143, -1));

        jLabel2.setText("TOTAL:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 22, 56, -1));

        jLabel3.setText("VALOR A SER ABATIDO:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 86, -1, -1));

        BtnAbater.setText("ABATER");
        BtnAbater.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAbaterActionPerformed(evt);
            }
        });
        jPanel1.add(BtnAbater, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 257, -1));

        TextPesquisar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel1.add(TextPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 259, 24));

        BtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/search.png"))); // NOI18N
        BtnPesquisar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPesquisarActionPerformed(evt);
            }
        });
        jPanel1.add(BtnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 45, 24));

        jLabel4.setText("PESQUISAR CLIENTE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 26, 750, 200));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "CLIENTES"));

        Table_Clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Table_Clientes.setForeground(new java.awt.Color(0, 0, 0));
        Table_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "CPF", "Telefone", "Logradouro"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Table_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Clientes);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 292, 750, -1));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PAGAMENTOS"));

        TablePagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TablePagamentos);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 26, 724, 707));

        setBounds(0, 0, 1571, 761);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPesquisarActionPerformed
        this.controle.CarregarTBLClientes();
    }//GEN-LAST:event_BtnPesquisarActionPerformed

    private void Table_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_ClientesMouseClicked
        this.controle.SelecionarCliente();

    }//GEN-LAST:event_Table_ClientesMouseClicked

    private void BtnAbaterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAbaterActionPerformed
        this.controle.EfetuarPagamento();
    }//GEN-LAST:event_BtnAbaterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAbater;
    private javax.swing.JButton BtnPesquisar;
    private javax.swing.JTable TablePagamentos;
    private javax.swing.JTable Table_Clientes;
    private javax.swing.JTextField TextPesquisar;
    private javax.swing.JTextField TextTotal;
    private javax.swing.JTextField TextValorAbater;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public JButton getBtnAbater() {
        return BtnAbater;
    }

    public void setBtnAbater(JButton BtnAbater) {
        this.BtnAbater = BtnAbater;
    }

    public JButton getBtnPesquisar() {
        return BtnPesquisar;
    }

    public void setBtnPesquisar(JButton BtnPesquisar) {
        this.BtnPesquisar = BtnPesquisar;
    }

    public JTable getTable_Clientes() {
        return Table_Clientes;
    }

    public void setTable_Clientes(JTable Table_Clientes) {
        this.Table_Clientes = Table_Clientes;
    }

    public JTextField getTextPesquisar() {
        return TextPesquisar;
    }

    public void setTextPesquisar(JTextField TextPesquisar) {
        this.TextPesquisar = TextPesquisar;
    }

    public JTextField getTextTotal() {
        return TextTotal;
    }

    public void setTextTotal(JTextField TextTotal) {
        this.TextTotal = TextTotal;
    }

    public JTextField getTextValorAbater() {
        return TextValorAbater;
    }

    public void setTextValorAbater(JTextField TextValorAbater) {
        this.TextValorAbater = TextValorAbater;
    }

    public JTable getTablePagamentos() {
        return TablePagamentos;
    }

    public void setTablePagamentos(JTable TablePagamentos) {
        this.TablePagamentos = TablePagamentos;
    }

}
