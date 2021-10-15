/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Jailton
 */
public class ItenPedido {
    private Pedido pedido;
    private Produto produto;
    private int quantidade;

    public ItenPedido(){}
    
    public ItenPedido(Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
    }

    public ItenPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ItenPedido(Pedido pedido, Produto produto, int quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(int pedcodigo) {
        this.pedido = new Pedido(pedcodigo);
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(String procodigo) {
        this.produto = new Produto(procodigo);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
