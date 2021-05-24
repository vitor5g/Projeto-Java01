package view;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Servico;
import model.dao.ServicoDAO;

public class ConsultaServico extends javax.swing.JFrame {

    public ConsultaServico() {
        initComponents();
        readJTable();
        ServicoDAO.totalServicos();
        Color cor = new Color(219, 219, 112);
        getContentPane().setBackground(cor);
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/grafica100.png"));
        setIconImage(icon.getImage());
        DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
        jTServicos.setRowSorter(new TableRowSorter(modelo));

        //this.setIconImage(new ImageIcon(getClass().getResource("/imagens/box32.png")).getImage());
    }

    private void readJTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
        modelo.setNumRows(0);
        lblTotalServicos.setText(Integer.toString(ServicoDAO.totalServicos()));

//       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//       Date d = df.parse();
//        lblTotalProdutos.setText("Total:" + Integer.toString(Produto.getTotalProdutos()));
        try {
            for (Servico s : ServicoDAO.read()) {

//                System.out.println(s);
                modelo.addRow(new Object[]{
                    s.getId(),
                    s.getNome_empresa(),
                    s.getNome_responsavel(),
                    s.getCelular(),
                    s.getValor(),
                    s.getData_servico(), //                    Produto.getTotalProdutos()
                });

            }
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaServico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void readJTableBusca(String opcao, String busca) {
        try {

            DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
            modelo.setNumRows(0);
            switch (JCEscolha.getSelectedItem().toString()) {
                case "Nome da Empresa":
                    opcao = "nome_empresa";
                    for (Servico s : ServicoDAO.readBusca(opcao, busca)) {

                        modelo.addRow(new Object[]{
                            s.getId(),
                            s.getNome_empresa(),
                            s.getNome_responsavel(),
                            s.getCelular(),
                            s.getValor(),
                            s.getData_servico(), //                    Produto.getTotalProdutos()
                        });

                    }
                    break;

                case "Nome do Responsável":
                    opcao = "nome_responsavel";
                    for (Servico s : ServicoDAO.readBusca(opcao, busca)) {

                        modelo.addRow(new Object[]{
                            s.getId(),
                            s.getNome_empresa(),
                            s.getNome_responsavel(),
                            s.getCelular(),
                            s.getValor(),
                            s.getData_servico(), //                    Produto.getTotalProdutos()
                        });

                    }
                    break;

                case "Nº Serviço":
                    opcao = "id";
                    for (Servico s : ServicoDAO.readBusca(opcao, busca)) {

                        modelo.addRow(new Object[]{
                            s.getId(),
                            s.getNome_empresa(),
                            s.getNome_responsavel(),
                            s.getCelular(),
                            s.getValor(),
                            s.getData_servico(), //                    Produto.getTotalProdutos()
                        });

                    }
                    break;
            }

//       SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//       Date d = df.parse();
//        lblTotalProdutos.setText("Total:" + Integer.toString(Produto.getTotalProdutos()));
        } catch (ParseException ex) {
            Logger.getLogger(ConsultaServico.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTServicos = new javax.swing.JTable();
        btnDetalhar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnBusca = new javax.swing.JButton();
        JCEscolha = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblTotalServicos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        jTServicos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº", "Nome da Empresa", "Nome do Responsavel", "Celular", "Valor", "Data do Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTServicos.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTServicosAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jTServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTServicosMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTServicosMouseReleased(evt);
            }
        });
        jTServicos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTServicosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTServicos);

        btnDetalhar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnDetalhar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-ver-detalhes-20.png"))); // NOI18N
        btnDetalhar.setText("Detalhar");
        btnDetalhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalharActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CONSULTA SERVIÇOS");

        btnVoltar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-esquerda-30.png"))); // NOI18N
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-cancelar-20.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.setMaximumSize(new java.awt.Dimension(47, 23));
        btnExcluir.setMinimumSize(new java.awt.Dimension(47, 23));
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-propriedade-20.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        txtBusca.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBusca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscaKeyPressed(evt);
            }
        });

        btnBusca.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnBusca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-15.png"))); // NOI18N
        btnBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscaActionPerformed(evt);
            }
        });

        JCEscolha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        JCEscolha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nome da Empresa", "Nome do Responsável", "Nº Serviço", " " }));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Total de Serviços:");

        lblTotalServicos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(211, 211, 211)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnDetalhar)
                        .addGap(26, 26, 26)
                        .addComponent(btnEditar)
                        .addGap(33, 33, 33)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JCEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBusca))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(36, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(50, 50, 50))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lblTotalServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusca)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnDetalhar)
                        .addComponent(btnEditar)
                        .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTServicosAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTServicosAncestorAdded

    }//GEN-LAST:event_jTServicosAncestorAdded

    private void btnDetalharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalharActionPerformed
        if (jTServicos.getSelectedRow() != -1) {

            Servico s = new Servico();
            Servico.setId_pesquisa(Integer.parseInt(jTServicos.getValueAt(jTServicos.getSelectedRow(), 0).toString()));
            ConsultaServicoDetalhado novaTela = new ConsultaServicoDetalhado();
            novaTela.setVisible(true);
            novaTela.setDefaultCloseOperation(ConsultaServicoDetalhado.DISPOSE_ON_CLOSE);

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para detalhar.");

        }
//        readJTable();


    }//GEN-LAST:event_btnDetalharActionPerformed

    private void jTServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTServicosMouseClicked

        Servico s = new Servico();
        DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
        int selectedRow = jTServicos.getSelectedRow();

        if (jTServicos.getSelectedRow() != -1) {
            try {
                s.setId(Integer.parseInt(jTServicos.getValueAt(jTServicos.getSelectedRow(), 0).toString()));
                ServicoDAO.readId(Servico.getId_pesquisa());
//                System.out.println(s.getId());
//            s.setId((int) jTServicos.getValueAt(jTServicos.getSelectedRow(), 0));
            } catch (ParseException ex) {
                Logger.getLogger(ConsultaServico.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

        }
    }//GEN-LAST:event_jTServicosMouseClicked

    private void jTServicosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTServicosKeyReleased
        Servico s = new Servico();
        DefaultTableModel modelo = (DefaultTableModel) jTServicos.getModel();
        int selectedRow = jTServicos.getSelectedRow();
        if (jTServicos.getSelectedRow() != -1) {
            s.setId(Integer.parseInt(jTServicos.getValueAt(jTServicos.getSelectedRow(), 0).toString()));
//            s.setId((int) jTServicos.getValueAt(jTServicos.getSelectedRow(), 0));

        }
    }//GEN-LAST:event_jTServicosKeyReleased

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        try {
            TelaInicial novaTela = new TelaInicial();
            novaTela.setVisible(true);
//            novaTela.setDefaultCloseOperation(AlterarServico.DISPOSE_ON_CLOSE);
            dispose();

        } catch (SQLException ex) {
            Logger.getLogger(ConsultaServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        UIManager.put("OptionPane.yesButtonText", "Sim");
        UIManager.put("OptionPane.noButtonText", "Não");

        if (jTServicos.getSelectedRow() != -1) {

            switch (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?")) {
                case 0:

                    Servico p = new Servico();
//            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//            String calendario = sdf.format(txtJCalendar.getDate());

                    p.setId((int) jTServicos.getValueAt(jTServicos.getSelectedRow(), 0));
                    ServicoDAO.delete(p);

//              Date data = null;
////            txtID.setText("");
//            txtNome.setText("");
//            txtQTD.setText("");
//            txtJCalendar.setDate(data);
//            txtPreco.setText("");
                    readJTable();

                    break;
                default:

                    break;
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");

        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        if (jTServicos.getSelectedRow() != -1) {

            Servico s = new Servico();
            Servico.setId_pesquisa(Integer.parseInt(jTServicos.getValueAt(jTServicos.getSelectedRow(), 0).toString()));
            AlterarServico novaTela = new AlterarServico();
            novaTela.setVisible(true);
            novaTela.setDefaultCloseOperation(AlterarServico.DISPOSE_ON_CLOSE);
//            dispose();
//            novaTela.setDefaultCloseOperation(AlterarServico.DISPOSE_ON_CLOSE);
            readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para editar.");
            readJTable();

        }
        readJTable();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        readJTable();
    }//GEN-LAST:event_formMouseClicked

    private void btnBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscaActionPerformed
        String opcao = "";
        switch (JCEscolha.getSelectedItem().toString()) {
            case "Nome da Empresa":
                opcao = "nome_empresa";
                readJTableBusca(opcao, txtBusca.getText());
                break;

            case "Nome do Responsável":
                opcao = "nome_responsavel";
                readJTableBusca(opcao, txtBusca.getText());
                break;

            case "Nº Serviço":
                opcao = "id";
                readJTableBusca(opcao, txtBusca.getText());
                break;
        }

    }//GEN-LAST:event_btnBuscaActionPerformed

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered

    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
//        readJTable();
    }//GEN-LAST:event_formMouseExited

    private void txtBuscaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaKeyPressed
        if (txtBusca.getText().isEmpty()) {
            readJTable();
        }
    }//GEN-LAST:event_txtBuscaKeyPressed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
//        readJTable();
    }//GEN-LAST:event_formFocusLost

    private void jTServicosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTServicosMouseReleased

    }//GEN-LAST:event_jTServicosMouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
//       readJTable();
    }//GEN-LAST:event_formMouseReleased

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
            java.util.logging.Logger.getLogger(ConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultaServico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaServico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JCEscolha;
    private javax.swing.JButton btnBusca;
    private javax.swing.JButton btnDetalhar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    javax.swing.JTable jTServicos;
    private javax.swing.JLabel lblTotalServicos;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
//public void recebendo(String login, String senha) throws SQLException {
//        setLogin(login);
//        setSenha(senha);
//        UsuarioDAO dao = new UsuarioDAO();
////        lblBemVindo.setText("Olá " + dao.pesquisaNome(dao.pesquisaId(login, senha)) + ", seja bem vindo(a)!");
//        setNome( dao.pesquisaNome(dao.pesquisaId(login, senha)));
//    }
}
