package Telas;

import FuncoesInternas.InverterData;
import FuncoesInternas.TransformarSenhaSistemaEmData;
import BeansNS.BeanEmpresas;
import Dao.DaoMySQL;
import TelasDeConfiguracoes.daoSQLITE;
import FuncoesInternas.*;
import Main.BarraInicial;
import Main.ProcessoInicial;
import Telas.Login;
import Parametros.parametrosNS;
import java.sql.*;
import java.util.*;
import javax.swing.*;

/*
 @author Tiago e Paulo
 */
public class InformarSenhaSistema extends javax.swing.JFrame {
    //String's
    String Tipo              = "";
    String Mensagem          = "";
    String sql               = "";
    String sqlstate          = "";
    String valorSenhaSistema = "";
    String nomeGrupo         = "";
    String nomeEmpresa       = "";
    
    //Outros
    Login lg;
    
    //int
    int idEmpresa     = 0;
    int codigoGrupo   = 0;
    int codigoEmpresa = 0;
    
    //long's
    long   SenhaSistema                     = 0;
    
    //Especiais
    InverterData                    invdata = new InverterData();
    CapturarDataHora                cdh     = new CapturarDataHora();
    TestarData                      Test    = new TestarData();
    BeanEmpresas                    be      = new BeanEmpresas();
    Criptografia                    crpt    = new Criptografia();
    TransformarSenhaSistemaEmData   Tssed   = new TransformarSenhaSistemaEmData();
    
    //Telas
    BarraInicial                    Bar;
    ProcessoInicial                 ProIni;
    
    public InformarSenhaSistema(String tipo, int IdEmpresa, int CodigoGrupo, String NomeGrupo, int CodigoEmpresa, String NomeEmpresa){
        initComponents();
        
        Tipo            = tipo;
        idEmpresa       = IdEmpresa;
        codigoGrupo     = CodigoGrupo;
        nomeGrupo       = NomeGrupo;
        codigoEmpresa   = CodigoEmpresa;
        nomeEmpresa     = NomeEmpresa;
        
        txt_empresa.setText(parametrosNS.fc.FormataCampo(String.valueOf(CodigoGrupo), 2, 0) + "-" + nomeGrupo + "\n" + parametrosNS.fc.FormataCampo(String.valueOf(CodigoEmpresa), 3, 0) + "-" + nomeEmpresa);
        
        if(idEmpresa != 0){
            setSize(413, 150);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel_1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bt_confirma = new javax.swing.JButton();
        txt_senhasistema = new javax.swing.JTextField();
        bt_sair = new javax.swing.JButton();
        painel_2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_empresa = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        painel_1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seu período de uso do sistema");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("expirou, entre em contato");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("com a NS3 - Informática");

        javax.swing.GroupLayout painel_1Layout = new javax.swing.GroupLayout(painel_1);
        painel_1.setLayout(painel_1Layout);
        painel_1Layout.setHorizontalGroup(
            painel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        painel_1Layout.setVerticalGroup(
            painel_1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Senha do Sistema:");

        bt_confirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Tick.png"))); // NOI18N
        bt_confirma.setText("Confirma");
        bt_confirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_confirmaActionPerformed(evt);
            }
        });

        txt_senhasistema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txt_senhasistema.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        bt_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/18x18/Exit.png"))); // NOI18N
        bt_sair.setText("Sair");
        bt_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_sairActionPerformed(evt);
            }
        });

        painel_2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Nextel: 35*30*49735");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Paulo: (11) 95288-9046");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Tiago: (11) 98465-1807");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nextel: 35*53*14877");

        javax.swing.GroupLayout painel_2Layout = new javax.swing.GroupLayout(painel_2);
        painel_2.setLayout(painel_2Layout);
        painel_2Layout.setHorizontalGroup(
            painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painel_2Layout.createSequentialGroup()
                .addGroup(painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        painel_2Layout.setVerticalGroup(
            painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_2Layout.createSequentialGroup()
                .addGroup(painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Empresa:");

        txt_empresa.setEditable(false);
        txt_empresa.setColumns(20);
        txt_empresa.setRows(5);
        txt_empresa.setFocusable(false);
        jScrollPane1.setViewportView(txt_empresa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bt_confirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bt_sair))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_senhasistema)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
            .addComponent(painel_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painel_2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_senhasistema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_confirma, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_sair))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel8, txt_senhasistema});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel9, jScrollPane1});

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_confirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_confirmaActionPerformed
        valorSenhaSistema = txt_senhasistema.getText();
        SenhaSistema = Tssed.TransformarSenhaSistemaEmData(valorSenhaSistema);
        if(SenhaSistema == 0){
            return;
        }
        AtualizaSenha();
    }//GEN-LAST:event_bt_confirmaActionPerformed

    private void bt_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_sairActionPerformed
        Tipo = "";
        Sair();
    }//GEN-LAST:event_bt_sairActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        if(parametrosNS.dao.sqlstate.equals("08S01") || parametrosNS.dao.sqlstate.equals("08003")){dispose();}
    }//GEN-LAST:event_formWindowGainedFocus

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if(idEmpresa != 0){
            painel_1.setVisible(false);
            painel_2.setVisible(false);
//            return;
        }
    }//GEN-LAST:event_formWindowOpened
    
    public void AtualizaSenha(){
        if(idEmpresa == 0){
            idEmpresa = parametrosNS.be.IdEmpresa;
        }
        sql = "update ns_empresas set dataValidade = '" + valorSenhaSistema + "' where idEmpresa = " + idEmpresa + ";";
        sqlstate = parametrosNS.dao.AlterarRegistroOuConsultaSeTabelaExiste(sql, "S");
        if(!sqlstate.equals("00000")){
            Mensagem = "Erro ao atualizar Senha!!!";
            new MostraMensagem(Mensagem);
            return;
        }
        Sair();
    }
    
    private void Sair(){
        dispose();
        if(!Tipo.equalsIgnoreCase("Login"))return;
        Logar();
    }
    
    public void Logar(){
        Bar     = new BarraInicial();
        ProIni  = new ProcessoInicial(Bar);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_confirma;
    private javax.swing.JButton bt_sair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painel_1;
    private javax.swing.JPanel painel_2;
    private javax.swing.JTextArea txt_empresa;
    private javax.swing.JTextField txt_senhasistema;
    // End of variables declaration//GEN-END:variables
    
}
