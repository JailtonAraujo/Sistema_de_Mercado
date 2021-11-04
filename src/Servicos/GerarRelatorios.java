/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicos;

import DAO.ConectionFactory;
import com.mongodb.util.Hash;
import java.io.InputStream;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Jailton
 */
public class GerarRelatorios {


        //METODO QUE GERA RELATORIO DE FECHAMENTO DE CHAIXA//
        public void GerarRelatorioDiario() {
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

        public void GerarRelatorioMensal(String data){
            try{
            
            InputStream CaminhoDoRelatorio = this.getClass().getClassLoader().getResourceAsStream("Relatorios/Relatorio_de_Vendas_Clausura.jasper");
            
            //CLAUSURA QUE IRÁ CONTER O MES OBTIDO ATRAVEZ DA ENTRADA NA VIEW E PASSADA PARA O DOCUMENTO JASPER//
            HashMap clausura = new HashMap();
            clausura.put("mes", data.substring(0,2));
            clausura.put("Ano", data.substring(3,7));
            
            
            //BUSCANDO, MONTANDO E PASSANDO A CLAUSURA PARA O REALATORIO
            JasperPrint print = JasperFillManager.fillReport(CaminhoDoRelatorio, clausura, ConectionFactory.getConnection());
            
            //IMPRIMINDO O RELATORIO MONTADO ATRAVEZ DO JASPERVIEW//
            JasperViewer.viewReport(print, false);
            
            }catch(Exception ex){
                throw new RuntimeException("Erro ao imprimir relatorio: "+ex);
            }
        }
        
        
    }
