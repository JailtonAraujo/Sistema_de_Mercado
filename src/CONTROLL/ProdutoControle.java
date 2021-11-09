/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.FornecedorDAO;
import DAO.ProdutoDAO;
import MODEL.Fornecedor;
import MODEL.Produto;
import VIEW.Frame_Produtos;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jailton
 */
public class ProdutoControle {

    private final Frame_Produtos view;
    private final FornecedorDAO forncedordao;
    private final ProdutoDAO produtodao;
    ArrayList<Produto> ListaDeProdutos;
    int index = 0;

    public ProdutoControle(Frame_Produtos view) {
        this.view = view;
        this.forncedordao = new FornecedorDAO();
        this.produtodao = new ProdutoDAO();
    }

    public void CadastrarProduto() {
        Produto produto = this.ObterModeloProduto("cadastrar");
        this.MostrarDados(produto);
        if (this.produtodao.CadastrarProduto(produto)) {
            JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaProdutos();

        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CADASTRAR O PRODUTO, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }

    }

    //#METODO QUE EXCLUI UM FORNECEDOR SELECIONADO NA TABELA#//
    public void ExcluirProduto() {
        this.index = this.view.getTabel_Produtos().getSelectedRow();
        this.SetarProduto(this.ListaDeProdutos.get(index));
        Produto produto = this.ObterModeloProduto("excluir");
        int sair = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR O PRODUTO SELECIONADO?", "ATENÇÃO!", +JOptionPane.YES_OPTION);

        if (sair == 0) {
            this.produtodao.ExcluirProduto(produto.getID());
            this.ListaDeProdutos.clear();
            this.CarregarTabelaProdutos();
            this.Limpar();
        }
        this.Limpar();
    }

    //#METODO QUE ATIALIZA OS DADOS DE UM PRODUTO#//
    public void AtualizarProduto() {
        Produto produto = this.ObterModeloProduto("Atualizar");
        this.MostrarDados(produto);
        if (this.produtodao.AtualizarProduto(produto)) {
            JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO!");
            this.Limpar();
            this.CarregarTabelaProdutos();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CADASTRAR O PRODUTO, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }
    }

    //#METODO QUE PEGA TODAS AS INFORMAÇÕES DE UM PRODUTO NOS CAMPOS NO MESMO#//
    public Produto ObterModeloProduto(String comando) {
        String codigo = this.view.getTex_ProCod().getText();
        String codigoForncedor = this.view.getTex_ProForCod().getText();
        String nome = this.view.getTex_ProNome().getText();
        String descricao = this.view.getTex_ProDescricao().getText();
        String uni = this.view.getTex_ProUnidadeMedida().getText();
        String valorUni = this.view.getTex_ProValorUnitario().getText();

        if ("cadastrar".equals(comando)) {

        }
        if (nome != null && nome.length() > 0 && valorUni != null && valorUni.length() > 0) {
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setID(Integer.parseInt(codigoForncedor));
            Produto modelo = new Produto(codigo, nome, descricao, uni, Float.parseFloat(valorUni), fornecedor);
            return modelo;
        }
        JOptionPane.showMessageDialog(null, "INFORMAÇÕES INVALIDAS, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        return null;
    }

    //#METODO QUE CARREGA O COMBOBOX DE FORNCEDORES#//
    public void CarregarForncedor() {

        ArrayList<Fornecedor> ListaDeFornecedor = this.forncedordao.ListarFornecedores("");

        DefaultComboBoxModel comboxModelo = (DefaultComboBoxModel) this.view.getBox_ProForNome().getModel();

        for (Fornecedor fornecedor : ListaDeFornecedor) {
            comboxModelo.addElement(fornecedor);
        }

    }

    //#METODO QUE SETA NOS CAMPOS DE CODIGO E CNPJ DE FORNCEDOR REFERENTE AO FORNECEDOR SELECIONADO NO COMBOBOX#//
    public void ObterForncedor() {
        Fornecedor forncedor = (Fornecedor) this.view.getBox_ProForNome().getSelectedItem();
        this.view.getTex_ProForCNPJ().setText(forncedor.getCNPJ());
        this.view.getTex_ProForCod().setText(Integer.toString(forncedor.getID()));

    }

    //#MOSTRAR DADOS DO PRODUTO#//
    public void MostrarDados(Produto modelo) {
        System.out.println(modelo.getNome());
        System.out.println(modelo.getDescricao());
        System.out.println(modelo.getUnidademedida());
        System.out.println(modelo.getValorunitario());
        System.out.println(modelo.getFornecedor().getID());
    }

    //#CARREGA A TEBELA DE PRODUTOS COM TODOS OS PRODUTOS DO BANCO DE DADOS#//
    public void CarregarTabelaProdutos() {
        String Search = "";
        Search = this.view.getTextSearch().getText();
        this.ListaDeProdutos = this.produtodao.ListarProdutos(Search);

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Nome", "Descrição", "Valor Unitario", "Codigo do Fornecedor"}, 0);
        for (int i = 0; i < this.ListaDeProdutos.size(); i++) {
            Object linha[] = new Object[]{
                this.ListaDeProdutos.get(i).getNome(),
                this.ListaDeProdutos.get(i).getDescricao(),
                "R$" + this.ListaDeProdutos.get(i).getValorunitario(),
                this.ListaDeProdutos.get(i).getFornecedor().getNome()

            };
            modelo.addRow(linha);
        }
        this.view.getTabel_Produtos().setModel(modelo);
        this.view.getBtn_atalizar().setEnabled(false);
    }

    //#LIMPAR CAMPOS#//
    public void Limpar() {
        this.view.getTex_ProCod().setText("");
        this.view.getTex_ProNome().setText("");
        this.view.getTex_ProDescricao().setText("");
        this.view.getTex_ProNome().setText("");
        this.view.getTex_ProUnidadeMedida().setText("");
        this.view.getTex_ProValorUnitario().setText("");
        this.view.getBtn_cadastrar().setEnabled(true);
        this.view.getBtn_Limpar().setEnabled(true);
        this.view.getBtn_editar().setEnabled(true);
        this.view.getBtn_excluir().setEnabled(true);
        this.view.getBtn_atalizar().setEnabled(false);
    }

    //#QUE SETA NOS CAMPOS DE PRODUTOS AS INFORMAÇÕES DE UM PRODUTO PASSADO POR PARAMETRO#//
    public void SetarProduto(Produto produto) {
        this.view.getTex_ProCod().setText(produto.getID());
        this.view.getTex_ProNome().setText(produto.getNome());
        this.view.getTex_ProDescricao().setText(produto.getUnidademedida());
        this.view.getTex_ProValorUnitario().setText(Float.toString(produto.getValorunitario()));
        this.view.getTex_ProForCod().setText(Integer.toString(produto.getFornecedor().getID()));
        this.view.getTex_ProUnidadeMedida().setText(produto.getUnidademedida());

        this.view.getBtn_cadastrar().setEnabled(false);
        this.view.getBtn_editar().setEnabled(false);
        this.view.getBtn_excluir().setEnabled(false);
        this.view.getBtn_Limpar().setEnabled(false);
        this.view.getBtn_atalizar().setEnabled(true);
    }

    //#METODO QUE SETA AS INFORMAÇÕES DE UM PRODUTO SELECIONADO NA TABELA NOS CAMPOS DO FORMULARIO#//
    public void Editar() {
        this.index = this.view.getTabel_Produtos().getSelectedRow();
        this.SetarProduto(this.ListaDeProdutos.get(index));
        this.view.getBtn_cadastrar().setEnabled(false);
        this.view.getBtn_Limpar().setEnabled(false);
        this.view.getBtn_Limpar().setEnabled(true);

    }

    //CAMCELA UMA AÇÃO//
    public void Cancelar() {
        this.Limpar();
        this.view.getBtn_cadastrar().setEnabled(true);
        this.view.getBtn_excluir().setEnabled(true);
        this.view.getBtn_atalizar().setEnabled(false);

    }

    public void SetarIcone() {
        this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
