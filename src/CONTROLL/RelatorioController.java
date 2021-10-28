/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import VIEW.FrameRalatorios;
import Servicos.GerarRelatorios;
import javax.swing.ImageIcon;

/**
 *
 * @author Jailton
 */
public class RelatorioController {
    
    private final FrameRalatorios view;
    private GerarRelatorios relatorios;
    
    public RelatorioController (FrameRalatorios view){
        this.view = view;
        this.relatorios = new GerarRelatorios();
    }
    
    //METODO QUE IRA PEGAR O CHAMAR O METODO DE RELATORIOS E ATRIBUIR A DATA DIGITADA DO CAMPO DA VIEW//
    public void RelatorioMensal(){
        //PASSANDO O MÊS DIGITADO PELO USUARIO NO CAMPO MES COMO CLAURA DE CONSULTA NO BANCO DE 
        this.relatorios.GerarRelatorioMensal(this.view.getTextMes().getText());
    }
    
    public void SetarIcone(){
   this.view.setFrameIcon(new ImageIcon(getClass().getResource("/Icons/Icon_Frame_Main.png")));
    }
}
