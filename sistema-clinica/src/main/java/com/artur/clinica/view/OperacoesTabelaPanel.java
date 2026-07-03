package com.artur.clinica.view;

public class OperacoesTabelaPanel extends javax.swing.JPanel {
    private java.util.List<com.artur.clinica.model.Consulta> cacheConsultas = null;
    private String ticketSelecionado = null;
    
    public OperacoesTabelaPanel() {
        initComponents();
        NotFoundSearch.setVisible(false);
        TabelaRegistros.getTableHeader().setReorderingAllowed(false);

        atualizarTabela();
        didUserUsedSearchTextBox();
        
        Deletar.setEnabled(false); 
        Editar.setEnabled(false);  

        
        TabelaRegistros.getSelectionModel().addListSelectionListener(e -> {
            
            boolean temSelecao = TabelaRegistros.getSelectedRow() >= 0;

            
            Deletar.setEnabled(temSelecao);
            Editar.setEnabled(temSelecao);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ConfirmarDelete = new javax.swing.JDialog();
        ConfirmarText = new javax.swing.JLabel();
        Confirmar = new javax.swing.JButton();
        Cancelar = new javax.swing.JButton();
        TabelaScroll = new javax.swing.JScrollPane();
        TabelaRegistros = new javax.swing.JTable();
        RegistrosSalvosText = new javax.swing.JLabel();
        Editar = new javax.swing.JButton();
        Deletar = new javax.swing.JButton();
        BarraBusca = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();
        NotFoundSearch = new javax.swing.JLabel();

        ConfirmarDelete.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        ConfirmarDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ConfirmarDelete.setLocation(new java.awt.Point(0, 0));
        ConfirmarDelete.setMinimumSize(new java.awt.Dimension(400, 200));
        ConfirmarDelete.setResizable(false);

        ConfirmarText.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ConfirmarText.setText("Confirmar a Deleção da Consulta");

        Confirmar.setText("Confirmar");
        Confirmar.setFocusable(false);
        Confirmar.addActionListener(this::ConfirmarActionPerformed);

        Cancelar.setText("Cancelar");
        Cancelar.setFocusable(false);
        Cancelar.addActionListener(this::CancelarActionPerformed);

        javax.swing.GroupLayout ConfirmarDeleteLayout = new javax.swing.GroupLayout(ConfirmarDelete.getContentPane());
        ConfirmarDelete.getContentPane().setLayout(ConfirmarDeleteLayout);
        ConfirmarDeleteLayout.setHorizontalGroup(
            ConfirmarDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmarDeleteLayout.createSequentialGroup()
                .addGroup(ConfirmarDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ConfirmarDeleteLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(ConfirmarText))
                    .addGroup(ConfirmarDeleteLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(Confirmar)
                        .addGap(73, 73, 73)
                        .addComponent(Cancelar)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        ConfirmarDeleteLayout.setVerticalGroup(
            ConfirmarDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmarDeleteLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(ConfirmarText)
                .addGap(53, 53, 53)
                .addGroup(ConfirmarDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Confirmar)
                    .addComponent(Cancelar))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 1, 1));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        TabelaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Ticket", "Paciente", "Data", "Horário", "Médico"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TabelaScroll.setViewportView(TabelaRegistros);
        TabelaRegistros.getAccessibleContext().setAccessibleDescription("");

        RegistrosSalvosText.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        RegistrosSalvosText.setText("Registros Salvos");

        Editar.setText("Editar");
        Editar.setFocusable(false);
        Editar.addActionListener(this::EditarActionPerformed);

        Deletar.setText("Deletar");
        Deletar.setFocusable(false);
        Deletar.addActionListener(this::DeletarActionPerformed);

        BarraBusca.addActionListener(this::BarraBuscaActionPerformed);

        BuscarButton.setText("🔍");
        BuscarButton.setFocusable(false);
        BuscarButton.addActionListener(this::BuscarButtonActionPerformed);

        NotFoundSearch.setForeground(new java.awt.Color(255, 84, 84));
        NotFoundSearch.setText("Não foi possível Encontrar nenhum registro com os termos pesquisados!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NotFoundSearch)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TabelaScroll, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                                .addComponent(RegistrosSalvosText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 268, Short.MAX_VALUE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BarraBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Deletar)
                        .addGap(18, 18, 18)
                        .addComponent(Editar)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(RegistrosSalvosText)
                .addGap(18, 18, 18)
                .addComponent(TabelaScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Editar)
                    .addComponent(Deletar)
                    .addComponent(BarraBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NotFoundSearch)
                .addGap(92, 92, 92))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        int selected = TabelaRegistros.getSelectedRow();
    
        if (selected >= 0) {

            String ticket = TabelaRegistros.getValueAt(selected, 0).toString();
            String paciente = TabelaRegistros.getValueAt(selected, 1).toString();

            String tipo = ticket.startsWith("CC") ? "Clinica" : "Cirurgia";

            java.awt.Frame parentFrame = (java.awt.Frame) javax.swing.SwingUtilities.getWindowAncestor(this);

            EditarRegistroDialog dialog = new EditarRegistroDialog(parentFrame, true, tipo, ticket, paciente);

            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);

            atualizarTabela();

            }
    }//GEN-LAST:event_EditarActionPerformed

    private void DeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletarActionPerformed

        int selected = TabelaRegistros.getSelectedRow();
    
        if (selected >= 0) {
     
            Object valorCelula = TabelaRegistros.getValueAt(selected, 0);
 
            if (valorCelula != null) {
                this.ticketSelecionado = valorCelula.toString(); 


                ConfirmarDelete.setLocationRelativeTo(null);
                ConfirmarDelete.setVisible(true);
            }
        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecione uma consulta na tabela para deletar.", "Aviso", javax.swing.JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_DeletarActionPerformed

    private void BarraBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarraBuscaActionPerformed

    }//GEN-LAST:event_BarraBuscaActionPerformed

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        ConfirmarDelete.dispose();
    }//GEN-LAST:event_CancelarActionPerformed

    private void ConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmarActionPerformed
     
        if (this.ticketSelecionado != null) {
            try {
                com.artur.clinica.services.ConsultaPostgresDAO dao = new com.artur.clinica.services.ConsultaPostgresDAO();
                dao.deletarPorTicket(this.ticketSelecionado);

                javax.swing.JOptionPane.showMessageDialog(this, "Agendamento " + this.ticketSelecionado + " removido com sucesso!", "Sucesso", javax.swing.JOptionPane.INFORMATION_MESSAGE);

                atualizarTabela();
                
            } catch (Exception e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Erro ao deletar do banco:\n" + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
            }
    }
    
    ConfirmarDelete.dispose(); 
    this.ticketSelecionado = null;
    }//GEN-LAST:event_ConfirmarActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        String termoBusca = BarraBusca.getText().toLowerCase();
        popularTabelaComFiltro(termoBusca);
    }//GEN-LAST:event_BuscarButtonActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.requestFocusInWindow();
    }//GEN-LAST:event_formMouseClicked

    public void atualizarTabela(){
        this.cacheConsultas = null; 

        if (BarraBusca != null) {
            BarraBusca.setText(""); 
        }
    
    
        popularTabelaComFiltro("");
    }

    private void popularTabelaComFiltro(String termo) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) TabelaRegistros.getModel();
        modelo.setNumRows(0); 
        
        try {
            if (this.cacheConsultas == null) {
                com.artur.clinica.services.ConsultaPostgresDAO dao = new com.artur.clinica.services.ConsultaPostgresDAO();
                this.cacheConsultas = dao.listarTodas();
                System.out.println("💾 [DISCO] Dados carregados do PostgreSQL.");
            }
            
            boolean encontrouAlgum = false;
            java.time.format.DateTimeFormatter fmtBr = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
            
            for (com.artur.clinica.model.Consulta c : this.cacheConsultas) {
                
                String dataBr = c.getData().format(fmtBr);
                
                String ticket = c.getCodTicket().toLowerCase();
                String paciente = c.getPaciente().getNome().toLowerCase();
                String dataBusca = dataBr.toLowerCase(); 
                String horario = c.getHorario().toString().toLowerCase();
                String medico = c.getMedico().getNome().toLowerCase();
                
            
                if (termo.isEmpty() || 
                    ticket.contains(termo) || 
                    paciente.contains(termo) || 
                    dataBusca.contains(termo) || 
                    horario.contains(termo) || 
                    medico.contains(termo)) {
                    
                    modelo.addRow(new Object[]{
                        c.getCodTicket(),
                        c.getPaciente().getNome(),
                        dataBr, 
                        c.getHorario(),
                        c.getMedico().getNome()
                    });
                    
                    if (!termo.isEmpty()) {
                        encontrouAlgum = true;
                    }
                }
            }
            
            if (!termo.isEmpty() && !encontrouAlgum) {
                NotFoundSearch.setVisible(true);
            } else {
                NotFoundSearch.setVisible(false);
            }
            
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Erro ao processar dados da tabela: " + e.getMessage(), "Erro", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }

    public void didUserUsedSearchTextBox(){
        BarraBusca.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        private void verificarExclusao() {
            if (BarraBusca.getText().trim().isEmpty()) {
                java.awt.EventQueue.invokeLater(() -> {
                    atualizarTabela();
                });
            }
        }

        @Override
        public void insertUpdate(javax.swing.event.DocumentEvent e) {
        }

        @Override
        public void removeUpdate(javax.swing.event.DocumentEvent e) {
            verificarExclusao(); 
        }

        @Override
        public void changedUpdate(javax.swing.event.DocumentEvent e) {
            verificarExclusao();
        }
    });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarraBusca;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Confirmar;
    private javax.swing.JDialog ConfirmarDelete;
    private javax.swing.JLabel ConfirmarText;
    private javax.swing.JButton Deletar;
    private javax.swing.JButton Editar;
    private javax.swing.JLabel NotFoundSearch;
    private javax.swing.JLabel RegistrosSalvosText;
    private javax.swing.JTable TabelaRegistros;
    private javax.swing.JScrollPane TabelaScroll;
    // End of variables declaration//GEN-END:variables
}
