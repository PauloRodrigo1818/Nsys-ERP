package TelasNS3;

import BeansNS.BeanEmpresas;
import BeansNS.BeanGrupoEmpresa;
import FuncoesInternas.AjustarLarguraColunas;
import Parametros.parametrosNS;
import Telas.InformarSenhaSistema;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 @author Tiago e Paulo 09/04/2018 09:32
 */
public class GerenciadorDeValidade extends javax.swing.JFrame {
    //string
    String sql          = "";
    String mensagem     = "";
    String senhaSistema = "";
    
    //long
    long senhaValida = 0;
    long dias        = 0;
    
    //int
    int linha = 0;
    
    //ArrayList
    ArrayList<ArrayList> dadosEmpresas     = new ArrayList();
    ArrayList<ArrayList> dadosGrupoEmpresa = new ArrayList();
    
    //Bean
    BeanEmpresas     be     = new BeanEmpresas();
    BeanGrupoEmpresa bge    = new BeanGrupoEmpresa();
    
    //Especiais
    DefaultTableModel Table_Validade;
    
    //Telas
    InformarSenhaSistema InfSenSis;
    
    public GerenciadorDeValidade(){
        initComponents();
    }
    
    private void PegaEmpresas(String PegaID){
        sql = "select idEmpresa, codigoGrupo, codigoEmpresa, idBancoDados, nomeEmpresa, nomeFantasia, cnpjEmpresa, inscricaoEstadual, dataValidade from ns_empresas ";
        if(PegaID.equals("S")){
            sql += "where codigoGrupo = " + be.CodigoGrupo + " and codigoEmpresa = " + be.CodigoEmpresa + " ";
        }
        sql += "order by codigoGrupo, codigoEmpresa asc;";
        dadosEmpresas = new ArrayList();
        dadosEmpresas = parametrosNS.dao.Consulta(sql);
        if(dadosEmpresas.isEmpty()){
            mensagem = "Não foram encontradas empresas cadastradas!";
            mostraMensagem();
            return;
        }
        PegaDadosEmpresas(PegaID);
    }
    
    private void PegaDadosEmpresas(String PegaID){
        String Seq           = "";
        String dataSistema   = "";
        String diasRestantes = "";
        String status        = "";
        
        if(!PegaID.equals("S")){
            tabela_validade.getColumnModel().getColumn(0).setCellRenderer(parametrosNS.tableEsquerda);
            tabela_validade.getColumnModel().getColumn(1).setCellRenderer(parametrosNS.tableEsquerda);
            tabela_validade.getColumnModel().getColumn(2).setCellRenderer(parametrosNS.tableEsquerda);
            tabela_validade.getColumnModel().getColumn(3).setCellRenderer(parametrosNS.tableCentralizado);
            tabela_validade.getColumnModel().getColumn(4).setCellRenderer(parametrosNS.tableEsquerda);
            tabela_validade.getColumnModel().getColumn(5).setCellRenderer(parametrosNS.tableEsquerda);
            
            Table_Validade.setNumRows(0);
        }
        for(int i = 0; i < dadosEmpresas.size(); i++){
            be = new BeanEmpresas();
            be.NomeEmpresa  = "--------------------";
            be.NomeFantasia = "--------------------";
            if(dadosEmpresas.get(i).get(0) != null){be.IdEmpresa            = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(0)));}
            if(dadosEmpresas.get(i).get(1) != null){be.CodigoGrupo          = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(1)));}
            if(dadosEmpresas.get(i).get(2) != null){be.CodigoEmpresa        = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(2)));}
            if(dadosEmpresas.get(i).get(3) != null){be.IdBancoDados         = Integer.parseInt(String.valueOf(dadosEmpresas.get(i).get(3)));}
            if(dadosEmpresas.get(i).get(4) != null){be.NomeEmpresa          =                  String.valueOf(dadosEmpresas.get(i).get(4));}
            if(dadosEmpresas.get(i).get(5) != null){be.NomeFantasia         =                  String.valueOf(dadosEmpresas.get(i).get(5));}
            if(dadosEmpresas.get(i).get(6) != null){be.CnpjEmpresa          =                  String.valueOf(dadosEmpresas.get(i).get(6));}
            if(dadosEmpresas.get(i).get(7) != null){be.InscricaoEstadual    =                  String.valueOf(dadosEmpresas.get(i).get(7));}
            if(dadosEmpresas.get(i).get(8) != null){be.DataValidade         =                  String.valueOf(dadosEmpresas.get(i).get(8));}
            
            PegaGrupo();
            if(PegaID.equals("S")){return;}
            
            if(be.dataValidade.equals("null")){be.dataValidade = "";}
            
            Seq = parametrosNS.fc.FormataCampo(String.valueOf(i + 1), 6, 0);
            
            bge.NomeGrupo   = parametrosNS.fc.FormataCampo(String.valueOf(bge.CodigoGrupo), 2, 0)  + "-" + bge.NomeGrupo;
            be .NomeEmpresa = parametrosNS.fc.FormataCampo(String.valueOf(be.CodigoEmpresa), 3, 0) + "-" + be .NomeEmpresa;
            
            senhaSistema = parametrosNS.crpt. Criptografa(be.DataValidade, "Descriptografar");
            senhaValida  = parametrosNS.Tssed.TransformarSenhaSistemaEmData(be.DataValidade);
            dataSistema  = parametrosNS.invdata.inverterData(String.valueOf(senhaValida), 1);
            
            dias = parametrosNS.cdr.RetornaDias(parametrosNS.cdh.CapturarData(), dataSistema);
            if(dias <  1){diasRestantes = "";status = "Expirado";}
            if(dias == 1){diasRestantes = dias + " dia  restante";status = "Á expirar em " + dias + " dia";}
            if(dias >  1){
                diasRestantes = dias + " dias restante";
                if(dias < 10){
                    status = "Á expirar em " + dias + " dias";
                }else{
                    status = "Atualizado";
                }
            }
            
            Table_Validade.addRow(new Object [] {Seq, bge.NomeGrupo, be.NomeEmpresa, dataSistema, diasRestantes, status});
        }
        new AjustarLarguraColunas(tabela_validade);
    }
    
    private void PegaGrupo(){
        bge.CodigoGrupo     = be.CodigoGrupo;
        sql = "select codigoGrupo, nomeGrupo from ns_grupoempresa where codigoGrupo = " + bge.CodigoGrupo + ";";
        dadosGrupoEmpresa = new ArrayList();
        dadosGrupoEmpresa = parametrosNS.dao.Consulta(sql);
        if(dadosGrupoEmpresa.isEmpty()){
            mensagem = "Não foi encontrado o grupo de código: " + bge.CodigoGrupo + "!";
            mostraMensagem();
            return;
        }
        PegaDadosGrupo();
    }
    
    private void PegaDadosGrupo(){
        for(int i = 0; i < dadosGrupoEmpresa.size(); i++){
            bge = new BeanGrupoEmpresa();
            bge.NomeGrupo = "--------------------";
            if(dadosGrupoEmpresa.get(i).get(0) != null){bge.CodigoGrupo = Integer.parseInt(String.valueOf(dadosGrupoEmpresa.get(i).get(0)));}
            if(dadosGrupoEmpresa.get(i).get(1) != null){bge.NomeGrupo   =                  String.valueOf(dadosGrupoEmpresa.get(i).get(1));}
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_validade = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciador de Validade");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabela_validade.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabela_validade.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Seq", "Nome do Grupo", "Nome da Empresa", "Data de Validade", "Dias Restantes", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela_validade.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabela_validade.getTableHeader().setReorderingAllowed(false);
        tabela_validade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_validadeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_validade);
        if (tabela_validade.getColumnModel().getColumnCount() > 0) {
            tabela_validade.getColumnModel().getColumn(0).setResizable(false);
            tabela_validade.getColumnModel().getColumn(1).setResizable(false);
            tabela_validade.getColumnModel().getColumn(2).setResizable(false);
            tabela_validade.getColumnModel().getColumn(3).setResizable(false);
            tabela_validade.getColumnModel().getColumn(4).setResizable(false);
            tabela_validade.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Validade do Sistema");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 872, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                .addContainerGap())
        );

        jButton2.setText("Sair");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Table_Validade = (DefaultTableModel)tabela_validade.getModel();
        PegaEmpresas("N");
    }//GEN-LAST:event_formWindowOpened

    private void tabela_validadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_validadeMouseClicked
        if(evt.getClickCount() < 2){
            return;
        }
        if(InfSenSis != null)if(InfSenSis.isVisible()){
            if(InfSenSis.isVisible()){
                InfSenSis.setState(JFrame.NORMAL);
                return;
            }
        }
        linha = tabela_validade.getSelectedRow();
        if(linha < 0){
            mensagem = "Item não selecionado!";
            mostraMensagem();
            return;
        }
        be.CodigoGrupo   = Integer.parseInt(String.valueOf(tabela_validade.getValueAt(linha, 1)).substring(0, 2));
        be.CodigoEmpresa = Integer.parseInt(String.valueOf(tabela_validade.getValueAt(linha, 2)).substring(0, 3));
        PegaEmpresas("S");
        InfSenSis = new InformarSenhaSistema("", be.IdEmpresa, bge.CodigoGrupo, bge.NomeGrupo, be.CodigoEmpresa, be.NomeEmpresa);
        InfSenSis.setVisible(true);
    }//GEN-LAST:event_tabela_validadeMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela_validade;
    // End of variables declaration//GEN-END:variables
    
    private void mostraMensagem(){
        JOptionPane.showMessageDialog(null, mensagem);
    }
    
}
