/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLL.LoginControle;
import CONTROLL.PrincipalControle;
import java.beans.PropertyVetoException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextField;
import Servicos.GerarRelatorios;

/**
 *
 * @author Pichau
 */
public class FramePrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FramePrincipal
     */
    
    private final PrincipalControle controle;

    public FramePrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.controle = new PrincipalControle(this);
        this.controle.SetarIcone();
        this.controle.CarregarData();

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
        Btn_vender = new javax.swing.JButton();
        Bnt_Clientes = new javax.swing.JButton();
        Btn_produtos = new javax.swing.JButton();
        Bnt_Fornecedor = new javax.swing.JButton();
        Btn_mov = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Lbl_Usuario = new javax.swing.JLabel();
        Lbl_data = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Lbl_divisao = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Btn_sair = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        Deskpane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Usuarios = new javax.swing.JMenu();
        GerenciarUsuarios = new javax.swing.JMenuItem();
        GerenciarClientes = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        MenuPagar = new javax.swing.JMenuItem();
        Menu_Fornecedores = new javax.swing.JMenu();
        GerenciarForncedores = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        Menu_Vendas = new javax.swing.JMenu();
        LancamentoVendas = new javax.swing.JMenuItem();
        Menu_Produtos = new javax.swing.JMenu();
        GerenciarProdutos = new javax.swing.JMenuItem();
        Menu_Financas = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        Relatorio = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        Menu_Ajuda = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TELA PRINCIPAL");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        Btn_vender.setBackground(new java.awt.Color(0, 102, 255));
        Btn_vender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconVenda.png"))); // NOI18N
        Btn_vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_venderActionPerformed(evt);
            }
        });

        Bnt_Clientes.setBackground(new java.awt.Color(255, 255, 0));
        Bnt_Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconCliente.png"))); // NOI18N
        Bnt_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_ClientesActionPerformed(evt);
            }
        });

        Btn_produtos.setBackground(new java.awt.Color(255, 102, 0));
        Btn_produtos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon_produto.png"))); // NOI18N
        Btn_produtos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Btn_produtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_produtosActionPerformed(evt);
            }
        });

        Bnt_Fornecedor.setBackground(new java.awt.Color(0, 0, 102));
        Bnt_Fornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconFornecedor.png"))); // NOI18N
        Bnt_Fornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_FornecedorActionPerformed(evt);
            }
        });

        Btn_mov.setBackground(new java.awt.Color(102, 255, 102));
        Btn_mov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icon_movimen.png"))); // NOI18N
        Btn_mov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_movActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 255, 255));
        jPanel2.setForeground(new java.awt.Color(51, 255, 255));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("USUARIO:");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("DATA:");

        Lbl_Usuario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Lbl_Usuario.setForeground(new java.awt.Color(0, 0, 0));
        Lbl_Usuario.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Lbl_UsuarioAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        Lbl_data.setBackground(new java.awt.Color(102, 255, 255));
        Lbl_data.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Lbl_data.setForeground(new java.awt.Color(0, 0, 0));
        Lbl_data.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                Lbl_dataAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("SETOR:");

        Lbl_divisao.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Lbl_divisao.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(4, 4, 4)
                        .addComponent(Lbl_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Lbl_divisao, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(Lbl_data, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Lbl_Usuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(Lbl_divisao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_data, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("VENDER");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText(" CLIENTES");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("  PRODUTOS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("  FORNECEDORES");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("MOVIMENTAÇÃO");

        Btn_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconSair.png"))); // NOI18N
        Btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_sairActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("SAIR");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(Btn_vender, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel3)))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bnt_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(Btn_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(Bnt_Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(67, 67, 67)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(Btn_mov, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(Btn_sair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel5))
                    .addComponent(Btn_produtos, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Btn_vender, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Bnt_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Bnt_Fornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_mov, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Btn_sair, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)))))
        );

        Deskpane.setBackground(new java.awt.Color(0, 153, 153));
        Deskpane.setMinimumSize(new java.awt.Dimension(1575, 741));

        javax.swing.GroupLayout DeskpaneLayout = new javax.swing.GroupLayout(Deskpane);
        Deskpane.setLayout(DeskpaneLayout);
        DeskpaneLayout.setHorizontalGroup(
            DeskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1575, Short.MAX_VALUE)
        );
        DeskpaneLayout.setVerticalGroup(
            DeskpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
        );

        Menu_Usuarios.setText("USUARIOS");

        GerenciarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_User_Menu.png"))); // NOI18N
        GerenciarUsuarios.setText("GERENCIAR USUARIOS");
        GerenciarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerenciarUsuariosActionPerformed(evt);
            }
        });
        Menu_Usuarios.add(GerenciarUsuarios);

        jMenuBar1.add(Menu_Usuarios);

        GerenciarClientes.setText("CLIENTES");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_Person.png"))); // NOI18N
        jMenuItem3.setText("GERENCIAR CLIENTES");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        GerenciarClientes.add(jMenuItem3);

        MenuPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_pay.png"))); // NOI18N
        MenuPagar.setText("PAGAR");
        MenuPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuPagarActionPerformed(evt);
            }
        });
        GerenciarClientes.add(MenuPagar);

        jMenuBar1.add(GerenciarClientes);

        Menu_Fornecedores.setText("FORNECEDORES");

        GerenciarForncedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_Fornecedor.png"))); // NOI18N
        GerenciarForncedores.setText("GERENCIAR FORNECEDORES");
        GerenciarForncedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerenciarForncedoresActionPerformed(evt);
            }
        });
        Menu_Fornecedores.add(GerenciarForncedores);

        jMenuItem4.setText("RECEBER MERCADORIA");
        Menu_Fornecedores.add(jMenuItem4);

        jMenuBar1.add(Menu_Fornecedores);

        Menu_Vendas.setText("VENDAS");

        LancamentoVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_Vendas.png"))); // NOI18N
        LancamentoVendas.setText("LANÇAMENTOS DE VENDAS");
        LancamentoVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LancamentoVendasActionPerformed(evt);
            }
        });
        Menu_Vendas.add(LancamentoVendas);

        jMenuBar1.add(Menu_Vendas);

        Menu_Produtos.setText("PRODUTOS");

        GerenciarProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_product.png"))); // NOI18N
        GerenciarProdutos.setText("GERENCIAR PRODUTOS");
        GerenciarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GerenciarProdutosActionPerformed(evt);
            }
        });
        Menu_Produtos.add(GerenciarProdutos);

        jMenuBar1.add(Menu_Produtos);

        Menu_Financas.setText("FINANÇAS");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_Moviemntação_FInanceira.png"))); // NOI18N
        jMenuItem1.setText("MOVIMENTAÇÃO FINANCEIRA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Menu_Financas.add(jMenuItem1);

        Relatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_fechar_Caixa.png"))); // NOI18N
        Relatorio.setText("FECHAR CAIXA");
        Relatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelatorioActionPerformed(evt);
            }
        });
        Menu_Financas.add(Relatorio);

        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_Relatorio.png"))); // NOI18N
        jMenuItem5.setText("GERAR RELATORIO MENSAL");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        Menu_Financas.add(jMenuItem5);

        jMenuBar1.add(Menu_Financas);

        Menu_Ajuda.setText("AJUDA");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Icon_information.png"))); // NOI18N
        jMenuItem2.setText("SOBRE");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        Menu_Ajuda.add(jMenuItem2);

        jMenuBar1.add(Menu_Ajuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Deskpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskpane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 1603, 937);
    }// </editor-fold>//GEN-END:initComponents

    private void Bnt_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_ClientesActionPerformed
        FrameClientes tela;
        try {
            tela = new FrameClientes();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_Bnt_ClientesActionPerformed

    private void Lbl_UsuarioAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Lbl_UsuarioAncestorAdded

    }//GEN-LAST:event_Lbl_UsuarioAncestorAdded

    private void Lbl_dataAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_Lbl_dataAncestorAdded

    }//GEN-LAST:event_Lbl_dataAncestorAdded

    private void Btn_venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_venderActionPerformed
        FrameVendas tela;
        try {
            tela = new FrameVendas();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_Btn_venderActionPerformed

    private void Btn_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_sairActionPerformed
        dispose();
        
        FrameLogin loginView = new FrameLogin();
        loginView.setVisible(true);
    }//GEN-LAST:event_Btn_sairActionPerformed

    private void Bnt_FornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_FornecedorActionPerformed
        FrameFornecedores tela;
        try {
            tela = new FrameFornecedores();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }//GEN-LAST:event_Bnt_FornecedorActionPerformed

    private void Btn_produtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_produtosActionPerformed
        Frame_Produtos tela;
        try{
            tela = new Frame_Produtos();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch( Exception ex){
            System.out.println(ex);
        }

    }//GEN-LAST:event_Btn_produtosActionPerformed

    private void Btn_movActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_movActionPerformed
        Frame_movimentacao tela;
        try{
            tela = new Frame_movimentacao();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_Btn_movActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new FrameSobre().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void GerenciarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerenciarUsuariosActionPerformed
       FrameCadastroUsuario tela;
        try{
            tela = new FrameCadastroUsuario();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch(Exception ex){
            System.out.println(ex);
        } 
    }//GEN-LAST:event_GerenciarUsuariosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FrameClientes tela;
        try {
            tela = new FrameClientes();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void GerenciarForncedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerenciarForncedoresActionPerformed
        FrameFornecedores tela;
        try {
            tela = new FrameFornecedores();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_GerenciarForncedoresActionPerformed

    private void LancamentoVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LancamentoVendasActionPerformed
        FrameVendas tela;
        try {
            tela = new FrameVendas();
            tela.setVisible(true);

            Deskpane.add(tela);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_LancamentoVendasActionPerformed

    private void GerenciarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GerenciarProdutosActionPerformed
        Frame_Produtos tela;
        try{
            tela = new Frame_Produtos();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch( Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_GerenciarProdutosActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Frame_movimentacao tela;
        try{
            tela = new Frame_movimentacao();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void RelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelatorioActionPerformed
        new GerarRelatorios().GerarRelatorioDiario();
    }//GEN-LAST:event_RelatorioActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        FrameRalatorios tela;
        try{
            tela = new FrameRalatorios();
            tela.setVisible(true);
            Deskpane.add(tela);
        
        }catch(Exception ex){
            System.out.println(ex);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void MenuPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuPagarActionPerformed
        FramePagamento tela;
        try{
            tela = new FramePagamento();
            tela.setVisible(true);
            Deskpane.add(tela);
        }catch(Exception ex){
        
        ex.printStackTrace();}
    }//GEN-LAST:event_MenuPagarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FramePrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bnt_Clientes;
    private javax.swing.JButton Bnt_Fornecedor;
    private javax.swing.JButton Btn_mov;
    private javax.swing.JButton Btn_produtos;
    private javax.swing.JButton Btn_sair;
    private javax.swing.JButton Btn_vender;
    private javax.swing.JDesktopPane Deskpane;
    private javax.swing.JMenu GerenciarClientes;
    private javax.swing.JMenuItem GerenciarForncedores;
    private javax.swing.JMenuItem GerenciarProdutos;
    private javax.swing.JMenuItem GerenciarUsuarios;
    private javax.swing.JMenuItem LancamentoVendas;
    private javax.swing.JLabel Lbl_Usuario;
    private javax.swing.JLabel Lbl_data;
    private javax.swing.JLabel Lbl_divisao;
    private javax.swing.JMenuItem MenuPagar;
    private javax.swing.JMenu Menu_Ajuda;
    private javax.swing.JMenu Menu_Financas;
    private javax.swing.JMenu Menu_Fornecedores;
    private javax.swing.JMenu Menu_Produtos;
    private javax.swing.JMenu Menu_Usuarios;
    private javax.swing.JMenu Menu_Vendas;
    private javax.swing.JMenuItem Relatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    public JLabel getLbl_Usuario() {
        return Lbl_Usuario;
    }

    public void setLbl_Usuario(JLabel Lbl_Usuario) {
        this.Lbl_Usuario = Lbl_Usuario;
    }

    public JLabel getLbl_data() {
        return Lbl_data;
    }

    public void setLbl_data(JLabel Lbl_data) {
        this.Lbl_data = Lbl_data;
    }

    public JLabel getLbl_divisao() {
        return Lbl_divisao;
    }

    public void setLbl_divisao(JLabel Lbl_divisao) {
        this.Lbl_divisao = Lbl_divisao;
    }

    public JButton getBnt_Clientes() {
        return Bnt_Clientes;
    }

    public void setBnt_Clientes(JButton Bnt_Clientes) {
        this.Bnt_Clientes = Bnt_Clientes;
    }

    public JButton getBnt_Fornecedor() {
        return Bnt_Fornecedor;
    }

    public void setBnt_Fornecedor(JButton Bnt_Fornecedor) {
        this.Bnt_Fornecedor = Bnt_Fornecedor;
    }

    public JButton getBtn_mov() {
        return Btn_mov;
    }

    public void setBtn_mov(JButton Btn_mov) {
        this.Btn_mov = Btn_mov;
    }

    public JButton getBtn_produtos() {
        return Btn_produtos;
    }

    public void setBtn_produtos(JButton Btn_produtos) {
        this.Btn_produtos = Btn_produtos;
    }

    public JButton getBtn_sair() {
        return Btn_sair;
    }

    public void setBtn_sair(JButton Btn_sair) {
        this.Btn_sair = Btn_sair;
    }

    public JButton getBtn_vender() {
        return Btn_vender;
    }

    public void setBtn_vender(JButton Btn_vender) {
        this.Btn_vender = Btn_vender;
    }

    public JMenu getMenu_Clientes() {
        return GerenciarClientes;
    }

    public void setMenu_Clientes(JMenu Menu_Clientes) {
        this.GerenciarClientes = Menu_Clientes;
    }

    public JMenu getMenu_Financas() {
        return Menu_Financas;
    }

    public void setMenu_Financas(JMenu Menu_Financas) {
        this.Menu_Financas = Menu_Financas;
    }

    public JMenu getMenu_Fornecedores() {
        return Menu_Fornecedores;
    }

    public void setMenu_Fornecedores(JMenu Menu_Fornecedores) {
        this.Menu_Fornecedores = Menu_Fornecedores;
    }

    public JMenu getMenu_Produtos() {
        return Menu_Produtos;
    }

    public void setMenu_Produtos(JMenu Menu_Produtos) {
        this.Menu_Produtos = Menu_Produtos;
    }

    public JMenu getMenu_Usuarios() {
        return Menu_Usuarios;
    }

    public void setMenu_Usuarios(JMenu Menu_Usuarios) {
        this.Menu_Usuarios = Menu_Usuarios;
    }

    public JMenu getMenu_Vendas() {
        return Menu_Vendas;
    }

    public void setMenu_Vendas(JMenu Menu_Vendas) {
        this.Menu_Vendas = Menu_Vendas;
    }
    
    

}
