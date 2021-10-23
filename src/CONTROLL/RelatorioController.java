/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLL;

import VIEW.FrameRalatorios;
import Servicos.GerarRelatorios;

/**
 *
 * @author Jailton
 */
public class RelatorioController {
    
    private final FrameRalatorios view;
    private GerarRelatorios relatorios;
    
    public RelatorioController (FrameRalatorios view){
        this.view = view;
    }
    
    public void FecharCaixa(){
        this.relatorios.gerarRelatorioDiario();
    }
}
