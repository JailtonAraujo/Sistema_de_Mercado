/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.PedidoDAO;
import MODEL.ItenPedido;
import MODEL.Pedido;
import MODEL.Produto;
import VIEW.Frame_movimentacao;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jailton
 */
public class MovimentacaoControle {

    private final Frame_movimentacao view;
    private ArrayList<Pedido> ListaDePedidos = null;
    private ArrayList<Produto> Pedido_produto = null;
    private ArrayList<ItenPedido> Pedido_Iten = null;
    private PedidoDAO pedDAO;

    public MovimentacaoControle(Frame_movimentacao view) {
        this.view = view;
        this.pedDAO = new PedidoDAO();
    }

    //#CARREGANDO TABELA DE DE PEDIDOS COM TODOS OS REGISTROS DO BD#//
    public void CarregarTabelaPedidos() {
        this.ListaDePedidos = new ArrayList<Pedido>();
        this.ListaDePedidos = this.pedDAO.Listar();
        DefaultTableModel modelo = (DefaultTableModel) this.view.getTable_pedidos().getModel();

        for (Pedido pedido : this.ListaDePedidos) {
            Object linha[] = new Object[]{
                pedido.getCodigo(),
                pedido.getCliente().getNome(),
                pedido.getUsuario().getNome(),
                pedido.getData(),
                "R$" + pedido.getValor_total(),
                pedido.getFormaDePagamento()
            };

            modelo.addRow(linha);
        }
        this.view.getTable_pedidos().setModel(modelo);

    }

    //#METODO QUE CARREGA A TABELA DE PEDIDO_ITEM#//
    public void CarregarTabelaItemPedido() {
        int Total_itens = 0;
        int index = this.view.getTable_pedidos().getSelectedRow();

        this.Pedido_produto = this.pedDAO.RetornaPedidoPorduto(this.ListaDePedidos.get(index).getCodigo());
        this.Pedido_Iten = this.pedDAO.RetornaPedido_Item(this.ListaDePedidos.get(index).getCodigo());

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"Codigo", "Nome", "Quantidade", "Valor Unitario"}, 0);

        for (int i = 0; i < this.Pedido_produto.size(); i++) {
            Object linha[] = new Object[]{
                this.Pedido_produto.get(i).getID(),
                this.Pedido_produto.get(i).getNome(),
                this.Pedido_Iten.get(i).getQuantidade(),
                "R$" + this.Pedido_produto.get(i).getValorunitario()

            };
            Total_itens = Total_itens + this.Pedido_Iten.get(i).getQuantidade();
            modelo.addRow(linha);
        }
        this.view.getTable_itens_pedido().setModel(modelo);
        this.SetarCampos(this.ListaDePedidos.get(index), Total_itens);

    }

    //#SETANDO O PEDIDO SELECIONANDO NOS CAMPOS#//
    public void SetarCampos(Pedido pedido, int quant) {
        this.view.getTex_pedcod().setText(String.valueOf(pedido.getCodigo()));
        this.view.getTex_clicod().setText(pedido.getCliente().getNome());
        this.view.getTex_vendcod().setText(pedido.getUsuario().getNome());
        this.view.getTex_data().setText(pedido.getData());
        this.view.getTex_valor_total().setText(String.valueOf(pedido.getValor_total()));
        this.view.getTex_total_itens().setText(String.valueOf(quant));
        this.view.getTextFormaPagaemento().setText(pedido.getFormaDePagamento());
    }

    public void SetarIcone() {
        this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
