/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.ClienteDAO;
import MODEL.Cliente;
import MODEL.Usuario;
import VIEW.FrameClientes;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class ClienteControle {

    private final FrameClientes view;
    private final ClienteDAO dao;
    ArrayList<Cliente> ListaDeClientes;
    int index = 0;

    public ClienteControle(FrameClientes view) {
        this.view = view;
        this.dao = new ClienteDAO();
    }

    //#METODO QUE CADASTRA NO BD O NOVO CLIENTE INFORMADO#//
    public void CadastrarCliente() {
        Cliente cliente = this.ObterModeloCliente("cadastrar");
        this.Mostrardados(cliente);
        if (this.dao.CadastrarCliente(cliente)) {
            JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaClientes();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CADASTRAR O CLIENTE, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }

    }

    //#METODO QUE EXCLUI UM CLIENTE SELECIONADO NA TABELA#//
    public void ExcluirCliente() {
        this.index = this.view.getTable_Clientes().getSelectedRow();
        this.SetarModelo(this.ListaDeClientes.get(index));
        Cliente cliente = this.ObterModeloCliente("excluir");
        int sair = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR O CLIENTE SELECIONADO?", "ATENÇÃO!", +JOptionPane.YES_OPTION);

        if (sair == 0) {
            this.dao.ExcluirCliente(cliente.getID());
            this.ListaDeClientes.clear();
            this.CarregarTabelaClientes();
            this.Limpar();
        }
        this.Limpar();
    }

    //#METODO QUE ATUALIZA OS DADOS DE CLIENTE#//
    public void AtualizarCliente() {
        Cliente cliente = this.ObterModeloCliente("atualizar");
        this.Mostrardados(cliente);
        if (this.dao.AtualizarCliente(cliente.getID(), cliente)) {
            JOptionPane.showMessageDialog(null, "CLIENTE ATUALIZADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaClientes();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL ATUALIZAR O CLIENTE, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }
    }

//#METODO QUE OBTEM AS INFORMAÇÕES ENSERIDAS NOS CAMPOS DO FORMULARIO DE CLIENTES#//
    public Cliente ObterModeloCliente(String comando) {
        String id = this.view.getTex_CliCodigo().getText();
        String nome = this.view.getTex_CliNome().getText();
        String cpf = this.view.getTex_CliCpf().getText();
        String telefone = this.view.getTex_CliTelefone().getText();
        String email = this.view.getTex_CliEmail().getText();
        String cep = this.view.getTex_CliCep().getText();
        String logradouro = this.view.getTex_CliLogradouro().getText();
        String numero = this.view.getTex_CliNumero().getText();
        String complemento = this.view.getTex_CliComplemento().getText();
        String bairro = this.view.getTex_CliBairro().getText();
        String cidade = this.view.getTex_CliCidade().getText();
        String estado = this.view.getTex_CliEstado().getText();
        float debito = Float.parseFloat(this.view.getTextDebito().getText());

        if ("cadastrar".equals(comando)) {
            id = "0";
        }
        if (nome != null && nome.length() > 0 && cpf != null && cpf.length() > 0 && telefone != null && telefone.length() > 0
                && logradouro != null && logradouro.length() > 0) {
            Cliente modelo = new Cliente(Integer.parseInt(id), nome, cpf, telefone, email, cep, logradouro, numero, complemento, bairro, cidade, estado, debito);
            return modelo;
        }
        JOptionPane.showMessageDialog(null, "INFORMAÇÕES INVALIDAS, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        return null;
    }

    //#METODO QUE IMPRIMO NO CONSOLE AS INFORMAÇÕERS DO CLIENTE CADASTRADO#//
    public void Mostrardados(Cliente modelo) {
        System.out.println(modelo.getNome());
        System.out.println(modelo.getCPF());
        System.out.println(modelo.getTelefone());
        System.out.println(modelo.getEmail());
        System.out.println(modelo.getCEP());
        System.out.println(modelo.getLogradouro());
        System.out.println(modelo.getNumero());
        System.out.println(modelo.getComplemento());
        System.out.println(modelo.getBairro());
        System.out.println(modelo.getCidade());
        System.out.println(modelo.getEstado());

    }

    //#METODO QEU LIMPAR OS CAMPOS DO FORMULARIO DE USUARIOS#//
    public void Limpar() {
        this.view.getTex_CliCodigo().setText("");
        this.view.getTex_CliNome().setText("");
        this.view.getTex_CliCpf().setText("");
        this.view.getTex_CliTelefone().setText("");
        this.view.getTex_CliEmail().setText("");
        this.view.getTex_CliCep().setText("");
        this.view.getTex_CliLogradouro().setText("");
        this.view.getTex_CliNumero().setText("");
        this.view.getTex_CliComplemento().setText("");
        this.view.getTex_CliBairro().setText("");
        this.view.getTex_CliCidade().setText("");
        this.view.getTex_CliEstado().setText("");
        this.view.getTextDebito().setText("0.0");
        this.view.getBnt_CliCadastro().setEnabled(true);
        this.view.getBnt_CliLimpar().setEnabled(true);
        this.view.getBnt_CliEditar().setEnabled(true);
        this.view.getBnt_CliExcluir().setEnabled(true);
        this.view.getBnt_CliAtualizar().setEnabled(false);

    }

    //#METODO QUE CARREGA A TABELA DE CLIENTES COM TODOS OS CLIENTES CADASTRADOS#//
    public void CarregarTabelaClientes() {
        this.ListaDeClientes = this.dao.ListarClientes("");

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Nome", "CPF", "Telefone", "Logradouro"}, 0);
        for (int i = 0; i < this.ListaDeClientes.size(); i++) {
            Object linha[] = new Object[]{
                this.ListaDeClientes.get(i).getNome(),
                this.ListaDeClientes.get(i).getCPF(),
                this.ListaDeClientes.get(i).getTelefone(),
                this.ListaDeClientes.get(i).getLogradouro()
            };
            modelo.addRow(linha);
        }
        this.view.getTable_Clientes().setModel(modelo);
        this.view.getBnt_CliAtualizar().setEnabled(false);
    }

    //#QUE SETA NOS CAMPOS DE CLIENTE AS INFORMAÇÕES DE UM CLIENTE PASSADO POR PARAMETRO#//
    public void SetarModelo(Cliente modelo) {
        this.view.getTex_CliCodigo().setText(String.valueOf(modelo.getID()));
        this.view.getTex_CliNome().setText(modelo.getNome());
        this.view.getTex_CliCpf().setText(modelo.getCPF());
        this.view.getTex_CliTelefone().setText(modelo.getTelefone());
        this.view.getTex_CliEmail().setText(modelo.getEmail());
        this.view.getTex_CliCep().setText(modelo.getCEP());
        this.view.getTex_CliLogradouro().setText(modelo.getLogradouro());
        this.view.getTex_CliNumero().setText(modelo.getNumero());
        this.view.getTex_CliComplemento().setText(modelo.getComplemento());
        this.view.getTex_CliBairro().setText(modelo.getBairro());
        this.view.getTex_CliCidade().setText(modelo.getCidade());
        this.view.getTex_CliEstado().setText(modelo.getEstado());
        this.view.getTextDebito().setText(String.valueOf( modelo.getDebito()));
        this.view.getBnt_CliCadastro().setEnabled(false);
        this.view.getBnt_CliEditar().setEnabled(false);
        this.view.getBnt_CliExcluir().setEnabled(false);
        this.view.getBnt_CliLimpar().setEnabled(false);
        this.view.getBnt_CliAtualizar().setEnabled(true);

    }

    //#FUNÇÃO QUE SETA AS INFORMAÇÕES DE UM CLIENTE SELECIONADO NA TABELA NOS CAMPOS DO FORMULARIO#//
    public void Editar() {
        this.index = this.view.getTable_Clientes().getSelectedRow();
        this.SetarModelo(this.dao.ListarClientes("").get(index));
        this.view.getBnt_CliCadastro().setEnabled(false);
        this.view.getBnt_CliEditar().setEnabled(false);
        this.view.getBnt_CliExcluir().setEnabled(false);
        this.view.getBnt_CliLimpar().setEnabled(false);
        this.view.getBnt_CliAtualizar().setEnabled(true);
    }

    //#METODO QUE CANSELA UMA AÇÃO NO ATO DO CADASTRAMENTO OU ATUALIZAÇÃO#//
    public void Cancelar() {
        this.Limpar();
        this.view.getBnt_CliCadastro().setEnabled(true);
        this.view.getBnt_CliLimpar().setEnabled(true);
        this.view.getBnt_CliAtualizar().setEnabled(false);
    }
    
   
public void SetarIcone(){
   this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
