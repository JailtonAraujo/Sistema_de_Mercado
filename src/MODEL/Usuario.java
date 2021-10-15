/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author Pichau
 */
public class Usuario {

    private int id;
    private String nome;
    private String login;
    private String senha;
    private String divisao;

    public Usuario() {
    }
    
    public Usuario(String Nome) {
        this.nome = Nome;
    }

    public Usuario(int id, String nome, String login, String senha, String divisao) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.divisao = divisao;
    }

    public Usuario(String login, String senha, String divisao) {
        this.login = login;
        this.senha = senha;
        this.divisao = divisao;
    }

    public Usuario(int id) {
        this.id = id;
    }
    

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setDivisao(String divisao) {
        this.divisao = divisao;
    }

    public String getDivisao() {
        return divisao;
    }

}
