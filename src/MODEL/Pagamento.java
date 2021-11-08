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
public class Pagamento {

    private int ID;
    private float ValorPagamento;
    private Cliente cliente;
    private Usuario usuario;
    private String DataPagamento;

    public Pagamento() {
    }

    public Pagamento(int ID, float ValorPagamento, Cliente cliente, Usuario usuario, String DataPagamento) {
        this.ID = ID;
        this.ValorPagamento = ValorPagamento;
        this.cliente = cliente;
        this.usuario = usuario;
        this.DataPagamento = DataPagamento;
    }

    public Pagamento(float ValorPagamento, Cliente cliente, Usuario usuario, String DataPagamento) {
        this.ValorPagamento = ValorPagamento;
        this.cliente = cliente;
        this.usuario = usuario;
        this.DataPagamento = DataPagamento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public float getValorPagamento() {
        return ValorPagamento;
    }

    public void setValorPagamento(float ValorPagamento) {
        this.ValorPagamento = ValorPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getDataPagemento() {
        return DataPagamento;
    }

    public void setDataPagamento(String DataPagamento) {
        this.DataPagamento = DataPagamento;
    }
}
