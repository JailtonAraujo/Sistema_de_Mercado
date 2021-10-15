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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
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
        String data = this.view.getTex_data().getText();
        data = this.converterData(data);
        Usuario usuario = new Usuario(this.LoginDao.ReturnUsu());
        Cliente cliente = (Cliente) this.view.getBox_cliente().getSelectedItem();
        float Total_pedido = Float.valueOf(this.view.getTex_valor_total_dos_peididos().getText());
        
        Pedido pedido = new Pedido(data, cliente, usuario, Total_pedido );

        int PedCod = this.pedidodao.AdicionarPedido(pedido);
        pedido.setCodigo(PedCod);

        for (ItenPedido item : this.ListaDeItens) {
            item.setPedido(PedCod);
        }

        for (ItenPedido item : this.ListaDeItens) {
            if (this.itemdao.AdicionatItemPedido(item)) {
                System.out.println("Item " + item.getProduto().getNome() + "adicionado com sucesso");
            } else {
                System.err.println("Erro ao adicionar item");
            }

        }
        JOptionPane.showMessageDialog(null, "PEDIDO FECHADO COM SUCESSO!!");
        this.ListaDeItens.clear();
        this.CarregarTabelaDeItens();
        this.limparCampos();

    }
    
    //METODO QUE BUSCAR UM PRODUTO NO BD ATRAVES DA ENTRADA NO CAMPO CODIGO DO MESMO PELO LEITOR DE CODIGO DE BARRA QUE DISPARA O EVENTO DO TEXTFILD
    //  E CHAMA ESSE METODO//
    public boolean AdicionarPedidoComLeitor(){
        try{
        String procod = this.view.getTex_vencod().getText();  
        this.SetarModeloProduto(this.pedidodao.BuscarProduto(procod));
        this.InserirItemNaTabela();
        
        return true;
        }catch(Exception ex){
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
        String quantidade = this.view.getTex_venquant().getText();
        ItenPedido item = new ItenPedido(this.produto, Integer.parseInt(quantidade));
        if (this.ListaDeItens.add(item)) {
            this.CarregarTabelaDeItens();
            this.limparCampos();
        }

    }

    // Setando o Produto da linha selecionada nos campos
    public void SetarModeloProduto(Produto modelo) {
        this.view.getTex_vencod().setText(modelo.getID());
        this.view.getTex_vennome().setText(modelo.getNome());
        this.view.getTex_venvalor().setText(String.valueOf(modelo.getValorunitario()));
        this.produto = modelo;
    }

    // FUNCIONALIDADE 3 - OBTEM O PRODUTO DA TABELA E SETA O MODELO NOS CAMPOS DE TEXTO
    public void SelecionarProduto() {
        int indexProduto = 0;
        indexProduto = this.view.getTable_Produtos().getSelectedRow();
        this.SetarModeloProduto(this.produto_dao.ListarProdutos().get(indexProduto));
    }

    // METODO QUE CARREGA TODOS OS CLIENTES DO BANCO E LISTA NO COMBO BOX DE CLIENTES.//
    public void PreencherBoxCliente() {
        this.ListaDeClientes = this.cliente_dao.ListarClientes();

        DefaultComboBoxModel boxmodelo = (DefaultComboBoxModel) this.view.getBox_cliente().getModel();

        for (Cliente cliente : this.ListaDeClientes) {
            boxmodelo.addElement(cliente);
        }

    }

    //METODO QUE CARREGA TODOS OS PRODUTOS NO BANCO E LISTA NA TABELA DE PRODUTOS//
    public void CarregarTabelaDeProdutos() {
        this.ListaDeProdutos = this.produto_dao.ListarProdutos();
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
    }

    public void ExcluirItem() {
        this.index = this.view.getTable_itenspedido().getSelectedRow();
        this.ListaDeItens.remove(index);
        this.CarregarTabelaDeItens();
    }
    
   public void teste(){
       String usuario;
       usuario = this.UsuarioDao.BuscarUsuario(this.LoginDao.ReturnUsu());
       
       System.out.println(usuario);
     
   }
}
