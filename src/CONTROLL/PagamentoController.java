/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.ClienteDAO;
import MODEL.Cliente;
import VIEW.FramePagamento;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jailton
 */
public class PagamentoController {

    private final FramePagamento view;
    ArrayList<Cliente> ListaClientes;
    private final ClienteDAO clienteDAO;

    public PagamentoController(FramePagamento view) {
        this.view = view;
        this.clienteDAO = new ClienteDAO();
    }

    //CARREGANDO A TABELA DE CLIENTE(INICIALMENTE COM TODOS DO CLIENTES CADASTRADOS, 
    //MAS SOFRE ALTERAÇÃO QUANDO USUARIO BUSCA UM GRUPO OU CLINTE ESPECIFICO)//
    public void CarregarTBLClientes() {

        String pesquisa = "";
        pesquisa = this.view.getTextPesquisar().getText();
        this.ListaClientes = clienteDAO.ListarClientes(pesquisa);

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Nome", "CPF", "Telefone", "Logradouro"}, 0);

        for (Cliente cliente : this.ListaClientes) {
            Object Linha[] = new Object[]{
                cliente.getNome(),
                cliente.getCPF(),
                cliente.getTelefone(),
                cliente.getLogradouro()
            };
            modelo.addRow(Linha);
        }

        this.view.getTable_Clientes().setModel(modelo);
    }

    //METODO QUE PEGA O CLIENTE SELECIONADO NA TBL E PASSA O CLIENTE SELECIONADO PARA O METODO QUE IRÁ SETAR AS INFORMAÇÕES NOS CAMPOS//
    public void SelecionarCliente() {
        int index = this.view.getTable_Clientes().getSelectedRow();
        this.SetarTotal(this.ListaClientes.get(index));
    }

    //METODO QUE IRÁ SETAR O DEBITO DO CLIENTE SELECIONADO NO RESPECTIVO CAMPO//
    public void SetarTotal(Cliente cliente) {
        this.view.getTextTotal().setText(String.valueOf(cliente.getDebito()));
    }

    //MWTODO QUE CHAMA O METODO ALTERARDEBITO DA CAMADA DAO E PASSA O DEBITO ATUAL COM O VALOR JA ABATIDO//
    public void AbaterDebito() {
        try {
            float ValorAbater = 0;
            float ValorAbatido = 0;
            ValorAbater = Float.parseFloat(this.view.getTextValorAbater().getText());

            Cliente cliente = new Cliente();
            int index = this.view.getTable_Clientes().getSelectedRow();

            cliente = this.ListaClientes.get(index);
            ValorAbatido = cliente.getDebito() - ValorAbater;
            int opc = JOptionPane.showConfirmDialog(null, "VALOR A SER ABATIDO: R$" + ValorAbater + "\nDEBITO ATUAL: R$" + cliente.getDebito() + "\n"
                    + "CLIENTE: " + cliente.getNome() + "", "ATENCÃO, CONFIRME A OPERAÇÃO!", JOptionPane.YES_NO_OPTION);
            if (opc == 0) {
                this.clienteDAO.AlterarDebito(ValorAbatido, cliente.getID());
                this.CarregarTBLClientes();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "INFORME UM VALOR VALIDO PARA SER DEBITADO!");
        }

    }

    public void SetarIcone() {
        this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
