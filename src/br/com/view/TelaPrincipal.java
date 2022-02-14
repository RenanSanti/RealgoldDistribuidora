/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.view;

import br.com.control.DAOCliente;
import br.com.control.DAOServico;
import br.com.model.ComboItens;
import br.com.model.Cliente;
import br.com.model.Servico;
import br.com.util.Util;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Renan
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        initMaximizado();
        Show_Products_In_JTable();
        Show_jComboBoxNomeCliente();
    }

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal(JTextField jTextNomeUsuario) {
        initComponents();
        initMaximizado();
        Show_Products_In_JTable();
        Show_jComboBoxNomeCliente();
        jMenuNomeUsuario.setText(jTextNomeUsuario.getText());

    }

    private void initMaximizado() {
        int inset = 5;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(inset, inset, screenSize.width - inset * 2, screenSize.height - inset * 2);
        this.setVisible(true);
        this.setExtendedState(MAXIMIZED_BOTH);

        /*try {
            MaskFormatter mask =  new MaskFormatter("##/##/####");
            mask.install(dataSaida);
        } catch (ParseException ex) {
           JOptionPane.showMessageDialog(null, "Campo data erro");
        }*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cdServico = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonConsultar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonInserir = new javax.swing.JButton();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jComboBoxNomeCliente = new javax.swing.JComboBox<>();
        dtSaida = new com.toedter.calendar.JDateChooser();
        dtEntrada = new com.toedter.calendar.JDateChooser();
        jButtonIncluirCliente = new javax.swing.JButton();
        jBotaoRelatorio = new javax.swing.JButton();
        Venda = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuCadastroCliente = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuNomeUsuario = new javax.swing.JMenu();
        jMenuItem12 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu4.setText("jMenu4");

        jMenuItem1.setText("jMenuItem1");

        jMenu6.setText("jMenu6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Código do Serviço");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel1.setOpaque(true);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nome Cliente");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.setOpaque(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código do Serv.", "Nome Cliente", "Data Entrada", "Tipo de Lente", "Status", "Numero Bandeja", "Pago", "Data Saida", "Obs:", "Lente da Casa", "Montagem", "Surfacagem"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setCellSelectionEnabled(true);
        jTable1.setFillsViewportHeight(true);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jButtonConsultar.setText("Consultar");
        jButtonConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarActionPerformed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Data Saída");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.setOpaque(true);

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Data da Entrada");
        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setOpaque(true);

        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jComboBoxNomeCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeClienteActionPerformed(evt);
            }
        });

        jButtonIncluirCliente.setText("Cliente");
        jButtonIncluirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirClienteActionPerformed(evt);
            }
        });

        jBotaoRelatorio.setText("Relatorio");
        jBotaoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoRelatorioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIncluirCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBotaoRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cdServico, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxNomeCliente, 0, 200, Short.MAX_VALUE)
                            .addComponent(dtSaida, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))))
                .addContainerGap(166, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cdServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(dtSaida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultar)
                    .addComponent(jButtonInserir)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonIncluirCliente)
                    .addComponent(jBotaoRelatorio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel6, jLabel8});

        jMenu2.setText("File");

        jMenuCadastroCliente.setText("Cadastrar Cliente");
        jMenuCadastroCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCadastroClienteActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuCadastroCliente);

        jMenuItem3.setText("Cadastrar Produto");
        jMenu2.add(jMenuItem3);

        jMenuItem7.setText("Sair");
        jMenu2.add(jMenuItem7);

        Venda.add(jMenu2);

        jMenu5.setText("Venda");

        jMenuItem8.setText("Solicitação de venda");
        jMenu5.add(jMenuItem8);

        jMenuItem11.setText("Vendas efetuadas");
        jMenu5.add(jMenuItem11);

        jMenuItem9.setText("Estornar venda");
        jMenu5.add(jMenuItem9);

        Venda.add(jMenu5);

        jMenu3.setText("Relatório");

        jMenuItem4.setText("Relatório de vendas por Cliente");
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Relatário de vendas por Produto");
        jMenu3.add(jMenuItem5);

        jMenuItem6.setText("Relatório de vendas por Período");
        jMenu3.add(jMenuItem6);

        Venda.add(jMenu3);

        jMenu7.setText("Estoque");

        jMenuItem10.setText("Cadastro de estoque");
        jMenu7.add(jMenuItem10);

        Venda.add(jMenu7);

        jMenuNomeUsuario.setText("Usuário");
        jMenuNomeUsuario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jMenuNomeUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jMenuNomeUsuario.setMargin(new java.awt.Insets(0, 0, 0, 10));
        jMenuNomeUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNomeUsuarioActionPerformed(evt);
            }
        });

        jMenuItem12.setText("Deslogar");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenuNomeUsuario.add(jMenuItem12);

        Venda.add(jMenuNomeUsuario);

        setJMenuBar(Venda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuNomeUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNomeUsuarioActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuNomeUsuarioActionPerformed

    private void jMenuCadastroClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCadastroClienteActionPerformed
        TelaCliente telaCliente = new TelaCliente();
        telaCliente.setVisible(true);
        //this.dispose();
    }//GEN-LAST:event_jMenuCadastroClienteActionPerformed

    private void jBotaoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoRelatorioActionPerformed
        
    }//GEN-LAST:event_jBotaoRelatorioActionPerformed

    private void jButtonIncluirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirClienteActionPerformed
        TelaCliente telaCliente = new TelaCliente();
        telaCliente.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonIncluirClienteActionPerformed

    private void jComboBoxNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxNomeClienteActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed

    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        Servico servico = new Servico();
        if (cdServico.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor preencher o código do serviços!");
        } else {

            try {
                String strCdServico = cdServico.getText();
                servico.setCodigoServico(strCdServico);

                TelaAlterar telaAlterar = new TelaAlterar(servico);
                telaAlterar.setVisible(true);
                this.dispose();
            } catch (ParseException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    /**
     * Método reponsável por chamar a tela de inclusão
     *
     * @param evt
     */
    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        TelaInserirServico telaInserirServico = new TelaInserirServico();
        telaInserirServico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonInserirActionPerformed

    /**
     * Método reponsável por chama a tela de consulta passando como parametro do
     * filtro.
     *
     * @param evt
     */
    private void jButtonConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarActionPerformed
        String stComboBoxNomeCliente = "";
        Servico servico = new Servico();
        Object comboSelecionadoCliente = null;
        SimpleDateFormat formatada = new SimpleDateFormat("yyyy-MM-dd");

        comboSelecionadoCliente = jComboBoxNomeCliente.getSelectedItem();
        //stComboBoxIdCliente = ((ComboItens)comboSelecionadoCliente).key;
        stComboBoxNomeCliente = ((ComboItens) comboSelecionadoCliente).getValue();

        if (!cdServico.getText().equals("")) {
            servico.setCodigoServico(cdServico.getText());
        } else if (!stComboBoxNomeCliente.equals("")) {
            servico.setNmclienteServico(stComboBoxNomeCliente);
        }
        if (dtEntrada.getDate() != null) {
            String strDataEntradaFormatada = formatada.format(dtEntrada.getDate());
            servico.setDiaEntradaServico(strDataEntradaFormatada);
        }
        if (dtSaida.getDate() != null) {
            String strDataSaidaFormatada = formatada.format(dtSaida.getDate());
            servico.setDiaSaidaServico(strDataSaidaFormatada);
        }

        TelaConsultaServico telaConsultaServico = new TelaConsultaServico(servico);
        telaConsultaServico.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonConsultarActionPerformed

    private void checkCampo() {
        if (cdServico.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor preencher o CNPJ!");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    /**
     * Carrega a tabela com todos os registro de serviços
     */
    public void Show_Products_In_JTable() {
        ArrayList<Servico> listServico = DAOServico.consultarServicoCompleto();

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // clear jtable content
        model.setRowCount(0);

        Object[] row = new Object[14];
        for (int i = 0; i < listServico.size(); i++) {
            Servico servicoLista = listServico.get(i);

            //Endereco endereco = getEnderecoPorCliente(clienteLista.getIdEndereco());
            row[0] = listServico.get(i).getCodigoServico();
            row[1] = listServico.get(i).getNmclienteServico();
            String dataEntradaFormatada = Util.formatadorData(servicoLista.getDiaEntradaServico().substring(0, 10));
            row[2] = dataEntradaFormatada;
            //row[3] = listServico.get(i).getDiaSaidaServico();
            row[3] = listServico.get(i).getDescricaoTipoLenteServico();
            row[4] = listServico.get(i).getStatusServico();
            row[5] = listServico.get(i).getNumeroBandejaServico();
            row[6] = listServico.get(i).getPagoServico();
            if(servicoLista.getDiaSaidaServico()!= null){
                row[7] = Util.formatadorData(servicoLista.getDiaSaidaServico().substring(0, 10));
            }else{
                row[7] = " - ";
            }
            row[8] = listServico.get(i).getObs();
            row[9] = servicoLista.getIsLenteCasa();
            row[10] = servicoLista.getIsMontagem();
            row[11] = servicoLista.getIsSurfacagem();

            model.addRow(row);
        }
    }

    /*
    Carrega o select de nome de Cliente
     */
    private void Show_jComboBoxNomeCliente() {
        ArrayList<Cliente> list = DAOCliente.consultarCliente();
        jComboBoxNomeCliente.removeAllItems();
        DefaultComboBoxModel model = new DefaultComboBoxModel();

        //Object[] row = new Object[14];
        for (int i = 0; i < list.size(); i++) {
            Cliente clienteLista = list.get(i);
            //jComboBoxNomeCliente.addItem(clienteLista.getNmNomeFantasia());
            model.addElement(new ComboItens(Integer.toString(clienteLista.getIdCliente()), clienteLista.getNmNomeFantasia()));

        }
        jComboBoxNomeCliente.setModel(model);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Venda;
    private javax.swing.JTextField cdServico;
    private com.toedter.calendar.JDateChooser dtEntrada;
    private com.toedter.calendar.JDateChooser dtSaida;
    private javax.swing.JButton jBotaoRelatorio;
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonConsultar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonIncluirCliente;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JComboBox<String> jComboBoxNomeCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuItem jMenuCadastroCliente;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenu jMenuNomeUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
