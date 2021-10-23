/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import DAO.ConectionFactory;
import java.io.InputStream;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jailton
 */
public class GerarRelatorios {


        //METODO QUE GERA RELATORIO DE FECHAMENTO DE CHAIXA//
        public void gerarRelatorioDiario() {
            try {

                //GERANDO CAMINHO DO RELATORIO JASPER// 
                InputStream caminhoralatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/Relatorio_de_Vendas.jasper");

                //BUSCANDO E MONTANDO O RELATORIO// 
                JasperPrint print = JasperFillManager.fillReport(caminhoralatorio, null, ConectionFactory.getConnection());

                //IMPRIMINDO O RELATORIO ATRAVEZ DO JASPERVIEWER//
                JasperViewer.viewReport(print, false);

            } catch (Exception ex) {
                throw new RuntimeException("Erro ao imprimir relatorio: " + ex);
            }
        }

    }
