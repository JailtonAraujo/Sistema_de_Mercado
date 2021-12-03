/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.ClienteDAO;
import DAO.LoginDAO;
import MODEL.Cliente;
import VIEW.FramePagamento;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.PagamentoDAO;
import MODEL.Pagamento;
import MODEL.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author Jailton
 */
public class PagamentoController {

    private final FramePagamento view;
    ArrayList<Cliente> ListaClientes;
    ArrayList<Pagamento> ListaDePagamentos;
    private final ClienteDAO clienteDAO;
    private final PagamentoDAO pagamentoDAO;
    private final LoginDAO login;
    

    public PagamentoController(FramePagamento view) {
        this.view = view;
        this.clienteDAO = new ClienteDAO();
        this.pagamentoDAO = new PagamentoDAO();
        this.login = new LoginDAO();
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
    public void SelecionarCliente() throws ParseException {
        int index = this.view.getTable_Clientes().getSelectedRow();
        this.SetarTotal(this.ListaClientes.get(index));
        this.CarregarTBLPagamentos();
        
    }

    //METODO QUE IRÁ SETAR O DEBITO DO CLIENTE SELECIONADO NO RESPECTIVO CAMPO//
    public void SetarTotal(Cliente cliente) {
        this.view.getTextTotal().setText(String.valueOf(cliente.getDebito()));
    }

    //MWTODO QUE CHAMA O METODO ALTERARDEBITO DA CAMADA DAO E PASSA O DEBITO ATUAL COM O VALOR JA ABATIDO//
    public void EfetuarPagamento() {
        try {
            float ValorAbater = 0;
            float ValorAbatido = 0;
            ValorAbater = Float.parseFloat(this.view.getTextValorAbater().getText());

            Usuario usuario = new Usuario(this.login.ReturnUsu());
            Cliente cliente = new Cliente();
            int index = this.view.getTable_Clientes().getSelectedRow();
            cliente = this.ListaClientes.get(index);

            ValorAbatido = cliente.getDebito() - ValorAbater;

            //MONTANDO O OBJETO PAGAMENTO COM AS DEVIDAS INFORMAÇÕES CARREGADAS NO SISTEMA//
            Pagamento pagamento = new Pagamento(ValorAbater, cliente, usuario, this.ObterData());
            int opc = JOptionPane.showConfirmDialog(null, "VALOR A SER ABATIDO: R$" + ValorAbater + "\nDEBITO ATUAL: R$" + cliente.getDebito() + "\n"
                    + "CLIENTE: " + cliente.getNome() + "", "ATENCÃO, CONFIRME A OPERAÇÃO!", JOptionPane.YES_NO_OPTION);
            if (opc == 0) {
                this.clienteDAO.AlterarDebito(ValorAbatido, cliente.getID());
                this.pagamentoDAO.SalvarPagamento(pagamento);
                JOptionPane.showMessageDialog(null, "PAGAMENTO RECEBIDO COM SUCESSO!");
                this.CarregarTBLClientes();
                

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "INFORME UM VALOR VALIDO PARA SER DEBITADO!");
        }

    }
    
    //CARREGANDO TABELA COM OS PAGAMENTOS DOS CLIENTES//
    public void CarregarTBLPagamentos() throws ParseException{
        int index = this.view.getTable_Clientes().getSelectedRow();
        this.ListaDePagamentos = new ArrayList<Pagamento>();
        this.ListaDePagamentos = this.pagamentoDAO.ListarPagamentos(this.ListaClientes.get(index).getID());
        
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Cliente", "Usuario", "Data Do Pagamento", "Valor Pago"},0 );
        
        for(Pagamento pagamento : this.ListaDePagamentos){
            Object linha = new Object[]{
                pagamento.getCliente().getNome(),
                pagamento.getUsuario().getNome(),
                this.ConverterData(pagamento.getDataPagemento()),
                "R$"+pagamento.getValorPagamento()
            };
            modelo.addRow((Object[]) linha);
        }
        
        this.view.getTablePagamentos().setModel(modelo);
    }

    public void SetarIcone() {
        this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }

    //OBTENDO A DATA CORRENTE//
    public String ObterData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date hoje = new Date();
        String dt = sdf.format(hoje);

        return dt;
    }
    
    
    public String ConverterData (String data) throws ParseException{
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
       
       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
       
        return format.format(format1.parse(data));
    }
}
