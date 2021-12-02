/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.ClienteDAO;
import DAO.ItemPedidoDAO;
import DAO.LoginDAO;
import DAO.PedidoDAO;
import DAO.ProdutoDAO;
import DAO.UsuarioDAO;
import MODEL.Cliente;
import MODEL.ItenPedido;
import MODEL.Pedido;
import MODEL.Produto;
import MODEL.Usuario;
import VIEW.FrameLogin;
import VIEW.FrameVendas;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jailton
 */
public class VendaControle {

    private final FrameVendas view;
    private final ProdutoDAO produto_dao;
    private final ClienteDAO cliente_dao;
    private final PedidoDAO pedidodao;
    private final ItemPedidoDAO itemdao;
    private final LoginDAO LoginDao;
    private final UsuarioDAO UsuarioDao;
    private Produto produto;
    int index = 0;
    ArrayList<Produto> ListaDeProdutos;
    ArrayList<Cliente> ListaDeClientes;
    ArrayList<ItenPedido> ListaDeItens = new ArrayList<ItenPedido>();

    public VendaControle(FrameVendas view) {
        this.view = view;
        this.produto_dao = new ProdutoDAO();
        this.cliente_dao = new ClienteDAO();
        this.pedidodao = new PedidoDAO();
        this.itemdao = new ItemPedidoDAO();
        this.LoginDao = new LoginDAO();
        this.UsuarioDao = new UsuarioDAO();

    }

    //METODO QUE CADASTRA UM PEDIDO COMPLETO JUNTO COM TODOS ITEMS//
    public void FecharPedido() {
        int opc = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA FECHAR O PEDIDO ATUAL?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);

        if (opc == 0) {

            String data = this.view.getTex_data().getText();
            data = this.converterData(data);
            Usuario usuario = new Usuario(this.LoginDao.ReturnUsu());
            Cliente cliente = (Cliente) this.view.getBox_cliente().getSelectedItem();
            float Total_pedido = Float.valueOf(this.view.getTex_valor_total_dos_peididos().getText());
            String FormaDePagamento = this.view.getBoxFormaPagamento().getSelectedItem().toString();
            String comentario = this.view.getTextComentario().getText();

            Pedido pedido = new Pedido(data, cliente, usuario, Total_pedido, FormaDePagamento, comentario);

            int PedCod = this.pedidodao.AdicionarPedido(pedido);
            pedido.setCodigo(PedCod);

            if ("Debito".equals(this.view.getBoxFormaPagamento().getSelectedItem().toString())) {
                this.AdicionarNaConta(cliente, Total_pedido);
            } else if ("Credito".equals(this.view.getBoxFormaPagamento().getSelectedItem().toString())) {
                this.view.getBox_cliente().setToolTipText("COMPRAS A VISTA");
            }

            for (ItenPedido item : this.ListaDeItens) {
                item.setPedido(PedCod);

            }

            for (ItenPedido item : this.ListaDeItens) {
                if (this.itemdao.AdicionatItemPedido(item)) {
                    System.out.println("Item " + item.getProduto().getNome() + "adicionado com sucesso");
                } else {
                    System.err.println("Erro ao adicionar item");
                }

                this.BaixaNoEstoque(ListaDeItens);

            }
            JOptionPane.showMessageDialog(null, "PEDIDO FECHADO COM SUCESSO!!");
            this.ListaDeItens.clear();
            this.CarregarTabelaDeItens();
            this.limparCampos();
        }

    }

    //METODO QUE BUSCAR UM PRODUTO NO BD ATRAVES DA ENTRADA NO CAMPO CODIGO DO MESMO PELO LEITOR DE CODIGO DE BARRA QUE DISPARA O EVENTO DO TEXTFILD
    //  E CHAMA ESSE METODO//
    public boolean AdicionarPedidoComLeitor() {
        try {
            String procod = this.view.getTex_vencod().getText();
            this.SetarModeloProduto(this.pedidodao.BuscarProduto(procod));
            this.InserirItemNaTabela();

            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "PRODUTO NÃO CADASTRADO!");
            return false;
        }

    }

    //METODO QUE CARREGA A TABELA COM OS ITENS DO PEDIDO//
    public void CarregarTabelaDeItens() {
        float ValorTotalPedido = 0;
        int TotalDeItens = 0;

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Codigo", "Nome", "Quantidade", "Valor Unitario"}, 0);

        for (ItenPedido item : this.ListaDeItens) {
            float valortotal = item.getProduto().getValorunitario()
                    * item.getQuantidade();

            Object linha = new Object[]{
                item.getProduto().getID(),
                item.getProduto().getNome(),
                item.getQuantidade(),
                item.getProduto().getValorunitario()
            };
            modelo.addRow((Object[]) linha);
            ValorTotalPedido = ValorTotalPedido + valortotal;
            TotalDeItens = TotalDeItens + item.getQuantidade();
        }
        this.view.getTable_itenspedido().setModel(modelo);
        this.view.getTex_valor_total_dos_peididos().setText(String.valueOf(ValorTotalPedido));
        this.view.getTex_quanttotaldeiten().setText(String.valueOf(TotalDeItens));
    }

    //METODO QUE INSERE TA TABELA DE INTEM O PRODUTO SELECIONADO!//
    public void InserirItemNaTabela() {

       
        if (this.produto.getQuantidade() >= 1) {
             if (this.produto.getQuantidade() < 5) {
            JOptionPane.showMessageDialog(view, "ATENÇÃO, PRODUTO COM POUCAS UNIDADES EM ESTOQUE, RECOMEDAVEL REABASTECER!");
        }
            
            String quantidade = this.view.getTex_venquant().getText();
            ItenPedido item = new ItenPedido(this.produto, Integer.parseInt(quantidade));
            if (this.ListaDeItens.add(item)) {
                this.CarregarTabelaDeItens();
                this.limparCampos();
            }

        }else{
            JOptionPane.showMessageDialog(view, "PRODUTO SEM ESTOQUE!!!");
        }

    }

    // Setando o Produto da linha selecionada nos campos
    public void SetarModeloProduto(Produto modelo) {
        this.view.getTex_vencod().setText(modelo.getID());
        this.view.getTex_vennome().setText(modelo.getNome());
        this.view.getTex_venvalor().setText(String.valueOf(modelo.getValorunitario()));
        this.view.getTextEstoque().setText(String.valueOf(modelo.getQuantidade()));
        this.produto = modelo;
    }

    // FUNCIONALIDADE 3 - OBTEM O PRODUTO DA TABELA E SETA O MODELO NOS CAMPOS DE TEXTO
    public void SelecionarProduto() {
        int indexProduto = 0;
        indexProduto = this.view.getTable_Produtos().getSelectedRow();
        this.SetarModeloProduto(this.ListaDeProdutos.get(indexProduto));
    }

    // METODO QUE CARREGA TODOS OS CLIENTES DO BANCO E LISTA NO COMBO BOX DE CLIENTES.//
    public void PreencherBoxCliente() {
        this.ListaDeClientes = this.cliente_dao.ListarClientes("");

        DefaultComboBoxModel boxmodelo = (DefaultComboBoxModel) this.view.getBox_cliente().getModel();

        for (Cliente cliente : this.ListaDeClientes) {
            boxmodelo.addElement(cliente);
        }

    }

    //METODO QUE CARREGA TODOS OS PRODUTOS NO BANCO E LISTA NA TABELA DE PRODUTOS//
    public void CarregarTabelaDeProdutos() {
        String Search = this.view.getTextSearch().getText();
        this.ListaDeProdutos = this.produto_dao.ListarProdutos(Search);
        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Codigo", "Nome", "Unidade", "Valor Unitario"}, 0);

        for (Produto produto : this.ListaDeProdutos) {
            Object linha = new Object[]{
                produto.getID(),
                produto.getNome(),
                produto.getUnidademedida(),
                produto.getValorunitario()
            };
            modelo.addRow((Object[]) linha);
        }
        this.view.getTable_Produtos().setModel(modelo);
    }

    public String converterData(String passaData) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(passaData, formato);
        System.out.println(data);
        return (data + "");
    }

    public void SetarData() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        String dt = sdf.format(hoje);
        this.view.getTex_data().setText(dt);

    }

    //BOTÃO LIMPAR CAMPOS
    public void limparCampos() {
        this.view.getTex_vencod().setText("");
        this.view.getTex_vennome().setText("");
        this.view.getTex_venvalor().setText("");
        this.view.getTex_venquant().setText("1");
        this.view.getTextDesconto().setText("0.0");
    }

    public void ExcluirItem() {
        this.index = this.view.getTable_itenspedido().getSelectedRow();
        this.ListaDeItens.remove(index);
        this.CarregarTabelaDeItens();
    }

    public void teste() {
        String usuario;
        usuario = this.UsuarioDao.BuscarUsuario(this.LoginDao.ReturnUsu());

        System.out.println(usuario);

    }

    //METODO QUE IRA SOMAR O VALOR TOTAL DA COMPRA AO DEBITO JA EXISTENTE DO CLIENTE//
    public void AdicionarNaConta(Cliente cliente, float ValorCompra) {
        //PEGANDO O DEBITO ATUAL DO CLIENTE//
        float debito = this.cliente_dao.BuscarDebito(cliente.getID());

        //ATRIBUINDO O VALOR DA COMPRA//
        float debitototal = debito + Float.parseFloat(this.view.getTex_valor_total_dos_peididos().getText());

        //ALTERANDO O DEBITO DO CLIENTE NO BD//
        this.cliente_dao.AlterarDebito(debitototal, cliente.getID());
    }

    //METODO QUE IRA ALTERAR O VALOR TOTAL DO PEDIDO CASO O CLIENTE COMPRE NO DEBITO E QUERIA PAGAR UMA PARTE DO VALOR//
    public void Descontar() {

        float ValorTotal = Float.parseFloat(this.view.getTex_valor_total_dos_peididos().getText());
        float ValorDescontar = Float.parseFloat(this.view.getTextDesconto().getText());

        int opc = JOptionPane.showConfirmDialog(null, "DESEJA FAZER O DESCONTO DE R$ " + ValorDescontar + " NO PEDIDO ATUAL?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);

        if (opc == 0) {
            this.view.getTex_valor_total_dos_peididos().setText(String.valueOf(ValorTotal - ValorDescontar));
        }
    }

    public void BaixaNoEstoque(List<ItenPedido> itens) {/*RECEBENDO A LLISTA DE ITEM DO PEDIDO*/
        for (ItenPedido item : itens) {
            
            int quant = 0;
            if(item.getProduto().getQuantidade() >= item.getQuantidade()){
                quant = item.getProduto().getQuantidade() - item.getQuantidade();/*SUBTRAINDO A QUANTIDADE DE INTENS DO INTEM_PEDIDO NA QUANTIDADE DO PRODUTO*/
            item.getProduto().setQuantidade(quant);

            }else{ 
                quant = 0;
                item.getProduto().setQuantidade(quant);
            }
     

            produto_dao.AtualizarProduto(item.getProduto());/*SALVANDO O PRODUTO ALTERADO*/
        }
    }

    public void SetarIcone() {
        this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }

}
