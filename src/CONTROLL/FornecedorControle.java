/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.FornecedorDAO;
import MODEL.Fornecedor;
import VIEW.FrameFornecedores;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jailton
 */
public class FornecedorControle {

    private final FrameFornecedores view;
    private final FornecedorDAO dao;
    ArrayList<Fornecedor> ListaDeFornecedores;
    int index = 0;

    public FornecedorControle(FrameFornecedores view) {
        this.view = view;
        this.dao = new FornecedorDAO();
    }

    //#METODO QUE CADASTRA NO BD O NOVO FORNECEDOR INFORMADO#//
    public void CadastrarFornecedor() {
        Fornecedor fornecedor = this.ObterModelo("cadastrar");
        this.MostrarDados(fornecedor);
        if (this.dao.CadastrarFornecedor(fornecedor)) {
            JOptionPane.showMessageDialog(null, "FORNECEDOR CADASTRADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaFornecedor();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CADASTRAR O FORNECEDOR, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }

    }
    
    //#METODO QUE ATIALIZA OS DADOS DE UM PRODUTO#//
    public void AtualizarFornecedor(){
        Fornecedor fornecedor = this.ObterModelo("atualizar");
        this.MostrarDados(fornecedor);
        if (this.dao.AtualizarFornecedor(fornecedor.getID(),fornecedor)) {
            JOptionPane.showMessageDialog(null, "FORNECEDOR ATUALIZADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaFornecedor();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL ATUALIZAR O FORNECEDOR, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }
    }
    
    //#METODO QUE EXCLUI UM FORNECEDOR SELECIONADO NA TABELA#//
    public void ExcluirFornecedor() {
        this.index = this.view.getTable_Fornecedores().getSelectedRow();
        this.SetarModelo(this.ListaDeFornecedores.get(index));
        Fornecedor fornecedor = this.ObterModelo("excluir");
        int sair = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR O FORNECEDOR SELECIONADO?", "ATENÇÃO!", +JOptionPane.YES_OPTION);

        if (sair == 0) {
            this.dao.ExcluirFornecedor(fornecedor.getID());
            this.ListaDeFornecedores.clear();
            this.CarregarTabelaFornecedor();
            this.Limpar();
        }
        this.Limpar();
    }

    //#METODO QUE OBTEM AS INFORMAÇÕES ENSERIDAS NOS CAMPOS DO FORMULARIO DE FOENCEDORES#//
    public Fornecedor ObterModelo(String comando) {
        String ID = this.view.getTex_ForCodigo().getText();
        String nome = this.view.getTex_ForNome().getText();
        String CNPJ = this.view.getTex_ForCNPJ().getText();
        String telefone = this.view.getTex_ForTelefone().getText();
        String email = this.view.getTex_ForEmail().getText();
        String site = this.view.getTex_ForSite().getText();
        String fax = this.view.getTex_ForFax().getText();

        if ("cadastrar".equals(comando)) {
            ID = "0";
        }
        if (nome != null && nome.length() > 0 && CNPJ != null && CNPJ.length() > 0 && telefone != null && telefone.length() > 0) {
            Fornecedor modelo = new Fornecedor(Integer.parseInt(ID), nome, CNPJ, telefone, email, site, fax);
            return modelo;
        }
        JOptionPane.showMessageDialog(null, "INFORMAÇÕES INVALIDAS, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        return null;
    }

    //#METODO QUE IMPRIMO NO CONSOLE AS INFORMAÇÕERS DO FORNECEDOR CADASTRADO#//
    public void MostrarDados(Fornecedor fornecedor) {
        System.out.println(fornecedor.getNome());
        System.out.println(fornecedor.getCNPJ());
        System.out.println(fornecedor.getTelefone());
        System.out.println(fornecedor.getEmail());
        System.out.println(fornecedor.getSite());
        System.out.println(fornecedor.getFax());

    }

    //#METODO QEU LIMPAR OS CAMPOS DO FORMULARIO DE FORNECEDORES#//
    public void Limpar() {
        this.view.getTex_ForCodigo().setText("");
        this.view.getTex_ForNome().setText("");
        this.view.getTex_ForCNPJ().setText("");
        this.view.getTex_ForTelefone().setText("");
        this.view.getTex_ForSite().setText("");
        this.view.getTex_ForEmail().setText("");
        this.view.getTex_ForFax().setText("");
        this.view.getBnt_ForCadastrar().setEnabled(true);
        this.view.getBnt_ForLimpar().setEnabled(true);
        this.view.getBnt_ForEditar().setEnabled(true);
        this.view.getBnt_ForExcluir().setEnabled(true);
        this.view.getBnt_ForAtualizar().setEnabled(false);

    }

    //#METODO QUE CARREGA A TABELA DE FORNECEDORES COM TODOS OS FORNECEDORES CADASTRADOS#//
    public void CarregarTabelaFornecedor() {
        this.ListaDeFornecedores = this.dao.ListarFornecedores();

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Codigo", "Nome", "CNPJ", "Telefone"}, 0);
        for (int i = 0; i < this.ListaDeFornecedores.size(); i++) {
            Object linha[] = new Object[]{
                this.ListaDeFornecedores.get(i).getID(),
                this.ListaDeFornecedores.get(i).getNome(),
                this.ListaDeFornecedores.get(i).getCNPJ(),
                this.ListaDeFornecedores.get(i).getTelefone(),
               
            };
            modelo.addRow(linha);
        }
        this.view.getTable_Fornecedores().setModel(modelo);
        this.view.getBnt_ForAtualizar().setEnabled(false);
    }
    
    //#QUE SETA NOS CAMPOS DE FORNECEDOR AS INFORMAÇÕES DE UM FORNECEDOR PASSADO POR PARAMETRO#//
    public void SetarModelo(Fornecedor modelo){
        this.view.getTex_ForCodigo().setText(String.valueOf(modelo.getID()));
        this.view.getTex_ForNome().setText(modelo.getNome());
        this.view.getTex_ForCNPJ().setText(modelo.getCNPJ());
        this.view.getTex_ForTelefone().setText(modelo.getTelefone());
        this.view.getTex_ForSite().setText(modelo.getSite());
        this.view.getTex_ForFax().setText(modelo.getFax());
        this.view.getTex_ForEmail().setText(modelo.getEmail());
        this.view.getBnt_ForCadastrar().setEnabled(false);
        this.view.getBnt_ForEditar().setEnabled(false);
        this.view.getBnt_ForExcluir().setEnabled(false);
        this.view.getBnt_ForLimpar().setEnabled(false);
        this.view.getBnt_ForAtualizar().setEnabled(true);
    }
    
    //#METODO QUE SETA AS INFORMAÇÕES DE UM FORNECEDOR SELECIONADO NA TABELA NOS CAMPOS DO FORMULARIO#//
    public void Editar(){
        this.index = this.view.getTable_Fornecedores().getSelectedRow();
        this.SetarModelo(this.dao.ListarFornecedores().get(index));
        this.view.getBnt_ForCadastrar().setEnabled(false);
        this.view.getBnt_ForLimpar().setEnabled(false);
        this.view.getBnt_ForAtualizar().setEnabled(true);
        
    }
    
    //#CANCELA UMA AÇÃO#//
    public void Cancelar(){
        this.Limpar();
        this.view.getBnt_ForCadastrar().setEnabled(true);
        this.view.getBnt_ForExcluir().setEnabled(true);
        this.view.getBnt_ForAtualizar().setEnabled(false);
        
        
    }

}
