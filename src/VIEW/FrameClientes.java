/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import CONTROLL.ClienteControle;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.beans.PropertyVetoException;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Pichau
 */
public class FrameClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form Frame_Clientes
     */
    private final ClienteControle controle;

    public FrameClientes() throws PropertyVetoException {
        initComponents();
        this.controle = new ClienteControle(this);
        this.controle.CarregarTabelaClientes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Tex_CliCodigo = new javax.swing.JTextField();
        Tex_CliNome = new javax.swing.JTextField();
        Tex_CliCpf = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Tex_CliTelefone = new javax.swing.JFormattedTextField();
        Tex_CliEmail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Tex_CliEstado = new javax.swing.JTextField();
        Tex_CliLogradouro = new javax.swing.JTextField();
        Tex_CliCidade = new javax.swing.JTextField();
        Tex_CliBairro = new javax.swing.JTextField();
        Tex_CliNumero = new javax.swing.JTextField();
        Tex_CliComplemento = new javax.swing.JTextField();
        Tex_CliCep = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Clientes = new javax.swing.JTable();
        Bnt_CliEditar = new javax.swing.JButton();
        Bnt_CliExcluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        Bnt_CliCadastro = new javax.swing.JButton();
        Bnt_CliAtualizar = new javax.swing.JButton();
        Bnt_CliLimpar = new javax.swing.JButton();
        Bnt_CliCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("CLIENTES");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("CONTROLE DE CLIENTES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Dados Cadastrais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CODIGO:");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOME:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("CPF:");

        Tex_CliCodigo.setEditable(false);
        Tex_CliCodigo.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliCodigoActionPerformed(evt);
            }
        });

        Tex_CliNome.setForeground(new java.awt.Color(0, 0, 0));

        Tex_CliCpf.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Tex_CliCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###.-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Tex_CliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tex_CliNome, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tex_CliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(165, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Tex_CliCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Tex_CliNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(Tex_CliCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Contato", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TELEFONE:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("E-MAIL:");

        Tex_CliTelefone.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Tex_CliTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) # ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        Tex_CliTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliTelefoneActionPerformed(evt);
            }
        });

        Tex_CliEmail.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tex_CliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tex_CliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(153, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Tex_CliTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Tex_CliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("CEP:");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("LOGRADOURO:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("NUMERO:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("COMPLEMENTO:");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("BAIRRO:");

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("CIDADE:");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("ESTADO:");

        Tex_CliEstado.setForeground(new java.awt.Color(0, 0, 0));

        Tex_CliLogradouro.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliLogradouroActionPerformed(evt);
            }
        });

        Tex_CliCidade.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliCidadeActionPerformed(evt);
            }
        });

        Tex_CliBairro.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliBairroActionPerformed(evt);
            }
        });

        Tex_CliNumero.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliNumeroActionPerformed(evt);
            }
        });

        Tex_CliComplemento.setForeground(new java.awt.Color(0, 0, 0));
        Tex_CliComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Tex_CliComplementoActionPerformed(evt);
            }
        });

        Tex_CliCep.setForeground(new java.awt.Color(0, 0, 0));
        try {
            Tex_CliCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tex_CliLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tex_CliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tex_CliCep, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tex_CliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tex_CliComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tex_CliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Tex_CliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel12))
                        .addGap(0, 123, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel7))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Tex_CliCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Tex_CliLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(Tex_CliNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(Tex_CliComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(Tex_CliBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(Tex_CliCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(Tex_CliEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)), "Relação de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 0, 14), new java.awt.Color(0, 0, 0))); // NOI18N
        jScrollPane1.setForeground(new java.awt.Color(0, 0, 0));

        Table_Clientes.setForeground(new java.awt.Color(0, 0, 0));
        Table_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        jScrollPane1.setViewportView(Table_Clientes);

        Bnt_CliEditar.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliEditar.setText("EDITAR");
        Bnt_CliEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliEditarActionPerformed(evt);
            }
        });

        Bnt_CliExcluir.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliExcluir.setText("EXCLUIR");
        Bnt_CliExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliExcluirActionPerformed(evt);
            }
        });

        Bnt_CliCadastro.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliCadastro.setText("CADASTRAR");
        Bnt_CliCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliCadastroActionPerformed(evt);
            }
        });

        Bnt_CliAtualizar.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliAtualizar.setText("ATUALIZAR");
        Bnt_CliAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliAtualizarActionPerformed(evt);
            }
        });

        Bnt_CliLimpar.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliLimpar.setText("LIMPAR");
        Bnt_CliLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliLimparActionPerformed(evt);
            }
        });

        Bnt_CliCancelar.setForeground(new java.awt.Color(0, 0, 0));
        Bnt_CliCancelar.setText("CANCELAR");
        Bnt_CliCancelar.setPreferredSize(new java.awt.Dimension(74, 32));
        Bnt_CliCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bnt_CliCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bnt_CliCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(Bnt_CliAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(Bnt_CliLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(Bnt_CliCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(Bnt_CliCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnt_CliAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnt_CliLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bnt_CliCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(59, 59, 59)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1408, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Bnt_CliEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Bnt_CliExcluir, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
                                .addGap(32, 32, 32))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Bnt_CliEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(Bnt_CliExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166))))
        );

        setBounds(0, 0, 1575, 741);
    }// </editor-fold>//GEN-END:initComponents

    private void Tex_CliTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliTelefoneActionPerformed

    private void Tex_CliLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliLogradouroActionPerformed

    private void Tex_CliCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliCidadeActionPerformed

    private void Tex_CliBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliBairroActionPerformed

    private void Tex_CliNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliNumeroActionPerformed

    private void Tex_CliComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliComplementoActionPerformed

    private void Bnt_CliExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliExcluirActionPerformed
        this.controle.ExcluirCliente();
    }//GEN-LAST:event_Bnt_CliExcluirActionPerformed

    private void Bnt_CliEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliEditarActionPerformed
        this.controle.Editar();
    }//GEN-LAST:event_Bnt_CliEditarActionPerformed

    private void Bnt_CliCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliCancelarActionPerformed
        this.controle.Cancelar();
    }//GEN-LAST:event_Bnt_CliCancelarActionPerformed

    private void Bnt_CliCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliCadastroActionPerformed
        this.controle.CadastrarCliente();

    }//GEN-LAST:event_Bnt_CliCadastroActionPerformed

    private void Bnt_CliLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliLimparActionPerformed
        this.controle.Limpar();
    }//GEN-LAST:event_Bnt_CliLimparActionPerformed

    private void Tex_CliCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Tex_CliCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Tex_CliCodigoActionPerformed

    private void Bnt_CliAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bnt_CliAtualizarActionPerformed
        this.controle.AtualizarCliente();
    }//GEN-LAST:event_Bnt_CliAtualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bnt_CliAtualizar;
    private javax.swing.JButton Bnt_CliCadastro;
    private javax.swing.JButton Bnt_CliCancelar;
    private javax.swing.JButton Bnt_CliEditar;
    private javax.swing.JButton Bnt_CliExcluir;
    private javax.swing.JButton Bnt_CliLimpar;
    private javax.swing.JTable Table_Clientes;
    private javax.swing.JTextField Tex_CliBairro;
    private javax.swing.JFormattedTextField Tex_CliCep;
    private javax.swing.JTextField Tex_CliCidade;
    private javax.swing.JTextField Tex_CliCodigo;
    private javax.swing.JTextField Tex_CliComplemento;
    private javax.swing.JFormattedTextField Tex_CliCpf;
    private javax.swing.JTextField Tex_CliEmail;
    private javax.swing.JTextField Tex_CliEstado;
    private javax.swing.JTextField Tex_CliLogradouro;
    private javax.swing.JTextField Tex_CliNome;
    private javax.swing.JTextField Tex_CliNumero;
    private javax.swing.JFormattedTextField Tex_CliTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JButton getBnt_CliAtualizar() {
        return Bnt_CliAtualizar;
    }

    public void setBnt_CliAtualizar(JButton Bnt_CliAtualizar) {
        this.Bnt_CliAtualizar = Bnt_CliAtualizar;
    }

    public JButton getBnt_CliCadastro() {
        return Bnt_CliCadastro;
    }

    public void setBnt_CliCadastro(JButton Bnt_CliCadastro) {
        this.Bnt_CliCadastro = Bnt_CliCadastro;
    }

    public JButton getBnt_CliCancelar() {
        return Bnt_CliCancelar;
    }

    public void setBnt_CliCancelar(JButton Bnt_CliCancelar) {
        this.Bnt_CliCancelar = Bnt_CliCancelar;
    }

    public JButton getBnt_CliEditar() {
        return Bnt_CliEditar;
    }

    public void setBnt_CliEditar(JButton Bnt_CliEditar) {
        this.Bnt_CliEditar = Bnt_CliEditar;
    }

    public JButton getBnt_CliExcluir() {
        return Bnt_CliExcluir;
    }

    public void setBnt_CliExcluir(JButton Bnt_CliExcluir) {
        this.Bnt_CliExcluir = Bnt_CliExcluir;
    }

    public JButton getBnt_CliLimpar() {
        return Bnt_CliLimpar;
    }

    public void setBnt_CliLimpar(JButton Bnt_CliLimpar) {
        this.Bnt_CliLimpar = Bnt_CliLimpar;
    }

    public JTable getTable_Clientes() {
        return Table_Clientes;
    }

    public void setTable_Clientes(JTable Table_Clientes) {
        this.Table_Clientes = Table_Clientes;
    }

    public JTextField getTex_CliBairro() {
        return Tex_CliBairro;
    }

    public void setTex_CliBairro(JTextField Tex_CliBairro) {
        this.Tex_CliBairro = Tex_CliBairro;
    }

    public JFormattedTextField getTex_CliCep() {
        return Tex_CliCep;
    }

    public void setTex_CliCep(JFormattedTextField Tex_CliCep) {
        this.Tex_CliCep = Tex_CliCep;
    }

    public JTextField getTex_CliCidade() {
        return Tex_CliCidade;
    }

    public void setTex_CliCidade(JTextField Tex_CliCidade) {
        this.Tex_CliCidade = Tex_CliCidade;
    }

    public JTextField getTex_CliCodigo() {
        return Tex_CliCodigo;
    }

    public void setTex_CliCodigo(JTextField Tex_CliCodigo) {
        this.Tex_CliCodigo = Tex_CliCodigo;
    }

    public JTextField getTex_CliComplemento() {
        return Tex_CliComplemento;
    }

    public void setTex_CliComplemento(JTextField Tex_CliComplemento) {
        this.Tex_CliComplemento = Tex_CliComplemento;
    }

    public JFormattedTextField getTex_CliCpf() {
        return Tex_CliCpf;
    }

    public void setTex_CliCpf(JFormattedTextField Tex_CliCpf) {
        this.Tex_CliCpf = Tex_CliCpf;
    }

    public JTextField getTex_CliEmail() {
        return Tex_CliEmail;
    }

    public void setTex_CliEmail(JTextField Tex_CliEmail) {
        this.Tex_CliEmail = Tex_CliEmail;
    }

    public JTextField getTex_CliEstado() {
        return Tex_CliEstado;
    }

    public void setTex_CliEstado(JTextField Tex_CliEstado) {
        this.Tex_CliEstado = Tex_CliEstado;
    }

    public JTextField getTex_CliLogradouro() {
        return Tex_CliLogradouro;
    }

    public void setTex_CliLogradouro(JTextField Tex_CliLogradouro) {
        this.Tex_CliLogradouro = Tex_CliLogradouro;
    }

    public JTextField getTex_CliNome() {
        return Tex_CliNome;
    }

    public void setTex_CliNome(JTextField Tex_CliNome) {
        this.Tex_CliNome = Tex_CliNome;
    }

    public JTextField getTex_CliNumero() {
        return Tex_CliNumero;
    }

    public void setTex_CliNumero(JTextField Tex_CliNumero) {
        this.Tex_CliNumero = Tex_CliNumero;
    }

    public JFormattedTextField getTex_CliTelefone() {
        return Tex_CliTelefone;
    }

    public void setTex_CliTelefone(JFormattedTextField Tex_CliTelefone) {
        this.Tex_CliTelefone = Tex_CliTelefone;
    }

}
