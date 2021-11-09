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
public class Pedido {

    private int codigo;
    private String data;
    private Cliente cliente;
    private Usuario usuario;
    private float Valor_total;
    private String FormaDePagamento;
    private String comentario;

    public Pedido (){}
    
    public Pedido(int codigo) {
        this.codigo = codigo;
    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pedido(String data, Cliente cliente,Usuario usuario, float Valor_total,String FormaDePagamento, String comentario) {
        this.data = data;
        this.cliente = cliente;
        this.usuario = usuario;
        this.Valor_total = Valor_total;
        this.FormaDePagamento = FormaDePagamento;
        this.comentario = comentario;
    }

    public Pedido(int codigo, String data, Cliente cliente, Usuario usuario, float Valor_total, String FormaDePagamento,String comentario) {
        this.codigo = codigo;
        this.data = data;
        this.cliente = cliente;
        this.usuario = usuario;
        this.Valor_total = Valor_total;
        this.FormaDePagamento = FormaDePagamento;
        this.comentario = comentario;
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(int id) {
        this.cliente = new Cliente(id);
    }
    public void setNomeCliente(String nome){
        this.cliente = new Cliente(nome);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(int id) {
        this.usuario = new Usuario(id);
    }
    public void setNomeUsuario(String nome) {
        this.usuario = new Usuario(nome);
    }

    public float getValor_total() {
        return Valor_total;
    }

    public void setValor_total(float Valor_total) {
        this.Valor_total = Valor_total;
    }

    public String getFormaDePagamento() {
        return FormaDePagamento;
    }

    public void setFormaDePagamento(String FormaDePagamento) {
        this.FormaDePagamento = FormaDePagamento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
   
    
    
    

}
