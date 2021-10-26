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
public class Conta {
    private int ID;
    private float debito;
    private Cliente cliente;
    private Pedido pedido;

    public Conta() {
    }

    public Conta(int ID, float debito, Cliente cliente) {
        this.ID = ID;
        this.debito = debito;
        this.cliente = cliente;
    }

    public Conta(int ID, float debito, Cliente cliente, Pedido pedido) {
        this.ID = ID;
        this.debito = debito;
        this.cliente = cliente;
        this.pedido = pedido;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getDebito() {
        return debito;
    }

    public void setDebito(float debito) {
        this.debito = debito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(int clicod) {
        this.cliente = new Cliente(clicod);
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(int pedcod) {
        this.pedido = new Pedido(pedcod);
    }
    
    
    
    
    
}
