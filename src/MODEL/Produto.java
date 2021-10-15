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
public class Produto {
    private String ID;
    private String nome;
    private String descricao;
    private String unidademedida;
    private float valorunitario;
    private Fornecedor fornecedor;

    public Produto() {
    }

    public Produto(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto(String ID) {
        this.ID = ID;
    }
      
    
    public Produto(String ID, String nome, String descricao, String unidademedida, float valorunitario) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.unidademedida = unidademedida;
        this.valorunitario = valorunitario;
    }

    public Produto(String ID, String nome, String descricao, String unidademedida, float valorunitario, Fornecedor fornecedor) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.unidademedida = unidademedida;
        this.valorunitario = valorunitario;
        this.fornecedor = fornecedor;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidademedida() {
        return unidademedida;
    }

    public void setUnidademedida(String unidademedida) {
        this.unidademedida = unidademedida;
    }

    public float getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(float valorunitario) {
        this.valorunitario = valorunitario;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int forcod ) {
        this.fornecedor = new Fornecedor(forcod);
    }
    
    public void setNomeFornecedor(String Nome){
        this.fornecedor = new Fornecedor(Nome);
    }
    
    
    @Override
    public String toString(){
        return nome;
    }
}
