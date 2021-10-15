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
public class Fornecedor {
    
    private int ID;
    private String nome;
    private String CNPJ;
    private String telefone;
    private String email;
    private String site;
    private String fax;
    
    public Fornecedor(){
    }
    
    public Fornecedor(String Nome){
        this.nome = Nome;
    }
    
    public Fornecedor(int ID, String nome, String CNPJ, String telefone, String email, String site, String fax){
        this.ID = ID;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.telefone = telefone;
        this.email = email;
        this.site = site;
        this.fax = fax;
    }

    public Fornecedor(int ID) {
        this.ID = ID;
    }
    
    
    
    public void setID(int ID){
        this.ID = ID;
    }
    
    public int getID(){
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }
    
    @Override
    public String toString(){
        return nome;
    }
}
