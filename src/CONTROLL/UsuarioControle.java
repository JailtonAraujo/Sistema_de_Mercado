/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import DAO.UsuarioDAO;
import MODEL.Usuario;
import VIEW.FrameCadastroUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class UsuarioControle {

    private final FrameCadastroUsuario view;
    private final UsuarioDAO dao;
    private ArrayList<Usuario> ListaDeUsuario;
    int index = 0;

    public UsuarioControle(FrameCadastroUsuario view) {
        this.view = view;
        this.dao = new UsuarioDAO();
    }

    //#METODO QUE CADASTRA NO BD O NOVO USUARIO INFORMADO#//
    public void cadastrar() {
        Usuario usuario = this.ObterModelo("cadastrar");
        this.MostrarDados(usuario);
        if (this.dao.CadastrarUsuario(usuario)) {
            JOptionPane.showMessageDialog(null, "USUARIO CADASTRADO COM SUCESSO!");
            this.Limpar();
            this.CarreTabelaDeUsuarios();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL CADASTRAR O USUARIO, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }

    }

    //#METODO QUE EXCLUI UM USUARIO SELECIONADA NA TABELA#//
    public void ExcluirUsuario() {
        this.index = this.view.getTable_Usuario().getSelectedRow();
        this.SetarUsuario(this.ListaDeUsuario.get(index));
        Usuario usuario = this.ObterModelo("excluir");
        int sair = JOptionPane.showConfirmDialog(null, "TEM CERTEZA QUE DESEJA EXCLUIR O USUARIO SELECIONADO?", "ATENÇÃO!", +JOptionPane.YES_OPTION);

        if (sair == 0) {
            this.dao.EscluirUsuario(usuario.getId());
            this.ListaDeUsuario.clear();
            this.CarreTabelaDeUsuarios();
            this.Limpar();
        }
        this.Limpar();
    }

    //#METODO QUE ATUALIZA OS DADOS DE USUARIO#//
    public void AtualizarUsuario() {
        Usuario usuario = this.ObterModelo("atualizar");
        this.MostrarDados(usuario);

        if (this.dao.AtualizarUsuario(usuario.getId(), usuario)) {
            JOptionPane.showMessageDialog(null, "USUARIO ATUALIZADO COM SUCESSO COM SUCESSO!");
            this.ListaDeUsuario.clear();
            this.CarreTabelaDeUsuarios();
            this.Limpar();
        } else {
            JOptionPane.showMessageDialog(null, "NÃO FOI POSSIVEL ATUALIZAR O USUARIO, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        }
    }

    //#METODO QUE CAPTURA OS VALORES DOS CAMPOS DO FORMULARIO USUARIO!#//
    public Usuario ObterModelo(String comando) {
        String id = this.view.getTex_UsuId().getText();
        String nome = this.view.getTex_UsuNome().getText();
        String login = this.view.getTex_UsuLogin().getText();
        String senha = this.view.getTex_UsuSenha().getText();
        String divisao = this.view.getBox_UsuDivisao().getSelectedItem().toString();
        if ("cadastrar".equals(comando)) {
            id = "0";
        }
        if (nome != null && nome.length() > 0 && login != null && nome.length() > 0 && senha != null && senha.length() > 0) {
            Usuario modelo = new Usuario(Integer.parseInt(id), nome, login, senha, divisao);
            return modelo;
        }
        JOptionPane.showMessageDialog(null, "INFORMAÇÕES INVALIDAS, VERIFIQUE OS DADOS DIGITADOS E TENTE NOVAMENTE!");
        return null;
    }

    //#METODO QUE IMPRIMO NO CONSOLE AS INFORMAÇÕERS DO USUARIO CADASTRADO#//
    public void MostrarDados(Usuario modelo) {
        System.out.println(modelo.getId());
        System.out.println(modelo.getNome());
        System.out.println(modelo.getLogin());
        System.out.println(modelo.getSenha());
        System.out.println(modelo.getDivisao());
    }

    //#METODO QEU LIMPAR OS CAMPOS DO FORMULARIO DE USUARIOS#//
    public void Limpar() {
        this.view.getTex_UsuId().setText("");
        this.view.getTex_UsuNome().setText("");
        this.view.getTex_UsuLogin().setText("");
        this.view.getTex_UsuSenha().setText("");
        this.view.getBnt_UsuCadastrar().setEnabled(true);
        this.view.getBnt_UsuLimpar().setEnabled(true);
        this.view.getBnt_UsuEditar().setEnabled(true);
        this.view.getBnt_UsuExcluir().setEnabled(true);
        this.view.getBnt_UsuAtualizar().setEnabled(false);
    }

    //#METODO QUE CARREGA A TABELA DE USUARIO COM TODOS OS USUARIO CADASTRADOS#//
    public void CarreTabelaDeUsuarios() {
        this.ListaDeUsuario = this.dao.ListarUsuario();

        DefaultTableModel modelo = new DefaultTableModel(
                new Object[]{"ID", "Nome", "Login", "Divisão"}, 0);
        for (int i = 0; i < this.ListaDeUsuario.size(); i++) {
            Object linha[] = new Object[]{
                this.ListaDeUsuario.get(i).getId(),
                this.ListaDeUsuario.get(i).getNome(),
                this.ListaDeUsuario.get(i).getLogin(),
                this.ListaDeUsuario.get(i).getDivisao()};
            modelo.addRow(linha);
        }
        this.view.getTable_Usuario().setModel(modelo);
        this.view.getBnt_UsuAtualizar().setEnabled(false);
    }

    //#QUE SETA NOS CAMPOS DE USUARIO AS INFORMAÇÕES DE UM USUARIO PASSADO POR PARAMETRO#//
    public void SetarUsuario(Usuario modelo) {
        this.view.getTex_UsuId().setText(String.valueOf(modelo.getId()));
        this.view.getTex_UsuNome().setText(modelo.getNome());
        this.view.getTex_UsuLogin().setText(modelo.getLogin());
        this.view.getTex_UsuSenha().setText(modelo.getSenha());
        this.view.getBnt_UsuCadastrar().setEnabled(false);
        this.view.getBnt_UsuEditar().setEnabled(false);
        this.view.getBnt_UsuExcluir().setEnabled(false);
        this.view.getBnt_UsuLimpar().setEnabled(false);
        this.view.getBnt_UsuAtualizar().setEnabled(true);
    }

    //#FUNÇÃO QUE SETA AS INFORMAÇÕES DE UM USUARIO SELECIO NA TABELA NOS CAMPOS DO FORMULARIO#//
    public void EditarUsuario() {
        this.index = this.view.getTable_Usuario().getSelectedRow();
        this.SetarUsuario(this.dao.ListarUsuario().get(index));
        this.view.getBnt_UsuCadastrar().setEnabled(false);
        this.view.getBnt_UsuEditar().setEnabled(false);
        this.view.getBnt_UsuExcluir().setEnabled(false);
        this.view.getBnt_UsuLimpar().setEnabled(false);
        this.view.getBnt_UsuAtualizar().setEnabled(true);
    }

//#METODO QUE CANSELA UMA AÇÃO NO ATO DO CADASTRAMENTO OU ATUALIZAÇÃO#//
    public void Canselar() {
        this.Limpar();
        this.view.getBnt_UsuCadastrar().setEnabled(true);
        this.view.getBnt_UsuLimpar().setEnabled(true);
        this.view.getBnt_UsuAtualizar().setEnabled(false);
    }

}
