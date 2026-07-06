package com.artur.clinica.view;

import java.awt.CardLayout;

import com.artur.clinica.Controller.ClinicativaController;

public class EditarRegistroDialog extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(EditarRegistroDialog.class.getName());

    public EditarRegistroDialog(java.awt.Frame parent, boolean modal, String tipo, String ticket, String paciente) {
        
        super(parent, modal); 
        
        
        initComponents();
        carregarMedicosNoCombo();
        
        
        Ticket.setText(ticket);
        NomePaciente.setText(paciente);
        
        
        CardLayout cl = (CardLayout) EditarDialogPanel.getLayout();
        if (tipo.equals("Cirurgia")) {
            cl.show(EditarDialogPanel, "CARD_CIRURGIA");
        } else {
            cl.show(EditarDialogPanel, "CARD_CLINICA");
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Ticket = new javax.swing.JTextField();
        NomePaciente = new javax.swing.JTextField();
        TicketText = new javax.swing.JLabel();
        NomePacienteText = new javax.swing.JLabel();
        EditarDialogPanel = new javax.swing.JPanel();
        CARD_CIRURGIA = new javax.swing.JPanel();
        Salvar1 = new javax.swing.JButton();
        DataCirurgiaText = new javax.swing.JLabel();
        HorarioCirurgia = new javax.swing.JFormattedTextField();
        HorarioCirurgiaText1 = new javax.swing.JLabel();
        TipoAnestesia = new javax.swing.JComboBox<>();
        TipoAnestesiaText = new javax.swing.JLabel();
        MedicoText1 = new javax.swing.JLabel();
        Medico1 = new javax.swing.JComboBox<>();
        TipoCirurgia = new javax.swing.JTextField();
        CARD_CLINICA = new javax.swing.JPanel();
        DataConsulta = new javax.swing.JFormattedTextField();
        Salvar = new javax.swing.JButton();
        DataConsultaText = new javax.swing.JLabel();
        HorarioConsulta = new javax.swing.JFormattedTextField();
        HorarioConsultaText1 = new javax.swing.JLabel();
        TipoConsulta = new javax.swing.JComboBox<>();
        TipoConsultaText1 = new javax.swing.JLabel();
        Medico = new javax.swing.JComboBox<>();
        MedicoText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editar");
        setBackground(new java.awt.Color(248, 250, 252));

        Ticket.setEditable(false);
        Ticket.setBackground(new java.awt.Color(248, 250, 252));
        Ticket.setEnabled(false);
        Ticket.addActionListener(this::TicketActionPerformed);

        NomePaciente.setEditable(false);
        NomePaciente.setBackground(new java.awt.Color(248, 250, 252));
        NomePaciente.setEnabled(false);

        TicketText.setText("Ticket");

        NomePacienteText.setText("Nome Paciente");

        EditarDialogPanel.setBackground(new java.awt.Color(248, 250, 252));
        EditarDialogPanel.setLayout(new java.awt.CardLayout());

        CARD_CIRURGIA.setBackground(new java.awt.Color(248, 250, 252));

        Salvar1.setBackground(new java.awt.Color(248, 250, 252));
        Salvar1.setText("Salvar");
        Salvar1.setFocusable(false);
        Salvar1.addActionListener(this::Salvar1ActionPerformed);

        DataCirurgiaText.setText("Data da Cirurgia ");

        HorarioCirurgia.setBackground(new java.awt.Color(248, 250, 252));
        HorarioCirurgia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        HorarioCirurgia.setToolTipText("Exemplo: 15:00");
        HorarioCirurgia.addActionListener(this::HorarioCirurgiaActionPerformed);

        HorarioCirurgiaText1.setText("Horário da Cirurgia");

        TipoAnestesia.setBackground(new java.awt.Color(248, 250, 252));
        TipoAnestesia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Local" }));

        TipoAnestesiaText.setText("Tipo da Anestesia");

        MedicoText1.setText("Médico");

        Medico1.setBackground(new java.awt.Color(248, 250, 252));
        Medico1.setEditable(true);
        Medico1.addActionListener(this::Medico1ActionPerformed);

        TipoCirurgia.setBackground(new java.awt.Color(248, 250, 252));
        TipoCirurgia.setText("Digite o tipo da Cirurgia...");
        TipoCirurgia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TipoCirurgiaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TipoCirurgiaFocusLost(evt);
            }
        });
        TipoCirurgia.addActionListener(this::TipoCirurgiaActionPerformed);

        javax.swing.GroupLayout CARD_CIRURGIALayout = new javax.swing.GroupLayout(CARD_CIRURGIA);
        CARD_CIRURGIA.setLayout(CARD_CIRURGIALayout);
        CARD_CIRURGIALayout.setHorizontalGroup(
            CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARD_CIRURGIALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CIRURGIALayout.createSequentialGroup()
                            .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CIRURGIALayout.createSequentialGroup()
                                    .addComponent(TipoAnestesiaText)
                                    .addGap(17, 17, 17)
                                    .addComponent(TipoAnestesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CARD_CIRURGIALayout.createSequentialGroup()
                                    .addGap(28, 28, 28)
                                    .addComponent(MedicoText1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Medico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Salvar1))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CIRURGIALayout.createSequentialGroup()
                            .addComponent(DataCirurgiaText)
                            .addGap(69, 69, 69)
                            .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(HorarioCirurgiaText1)
                                .addComponent(HorarioCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(TipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        CARD_CIRURGIALayout.setVerticalGroup(
            CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARD_CIRURGIALayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CARD_CIRURGIALayout.createSequentialGroup()
                        .addComponent(HorarioCirurgiaText1)
                        .addGap(4, 4, 4)
                        .addComponent(HorarioCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CARD_CIRURGIALayout.createSequentialGroup()
                        .addComponent(DataCirurgiaText)
                        .addGap(26, 26, 26)))
                .addGap(18, 18, 18)
                .addComponent(TipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoAnestesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoAnestesiaText))
                .addGap(18, 18, 18)
                .addGroup(CARD_CIRURGIALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MedicoText1)
                    .addComponent(Salvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        EditarDialogPanel.add(CARD_CIRURGIA, "card3");

        CARD_CLINICA.setBackground(new java.awt.Color(248, 250, 252));

        DataConsulta.setBackground(new java.awt.Color(248, 250, 252));
        DataConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        DataConsulta.setToolTipText("Exemplo: 09/09/2026");
        DataConsulta.addActionListener(this::DataConsultaActionPerformed);

        Salvar.setBackground(new java.awt.Color(248, 250, 252));
        Salvar.setText("Salvar");
        Salvar.addActionListener(this::SalvarActionPerformed);

        DataConsultaText.setText("Data da Consulta ");

        HorarioConsulta.setBackground(new java.awt.Color(248, 250, 252));
        HorarioConsulta.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        HorarioConsulta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        HorarioConsulta.setToolTipText("Exemplo: 15:00");
        HorarioConsulta.addActionListener(this::HorarioConsultaActionPerformed);

        HorarioConsultaText1.setText("Horário da Consulta");

        TipoConsulta.setBackground(new java.awt.Color(248, 250, 252));
        TipoConsulta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Conveniado", "Particular" }));
        TipoConsulta.addActionListener(this::TipoConsultaActionPerformed);

        TipoConsultaText1.setText("Tipo da Consulta");

        Medico.setBackground(new java.awt.Color(248, 250, 252));
        Medico.addActionListener(this::MedicoActionPerformed);

        MedicoText.setText("Médico");

        javax.swing.GroupLayout CARD_CLINICALayout = new javax.swing.GroupLayout(CARD_CLINICA);
        CARD_CLINICA.setLayout(CARD_CLINICALayout);
        CARD_CLINICALayout.setHorizontalGroup(
            CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARD_CLINICALayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CLINICALayout.createSequentialGroup()
                        .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CLINICALayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(MedicoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CLINICALayout.createSequentialGroup()
                                .addComponent(TipoConsultaText1)
                                .addGap(17, 17, 17)
                                .addComponent(TipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salvar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, CARD_CLINICALayout.createSequentialGroup()
                        .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DataConsultaText)
                            .addComponent(DataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HorarioConsultaText1)
                            .addComponent(HorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        CARD_CLINICALayout.setVerticalGroup(
            CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CARD_CLINICALayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CARD_CLINICALayout.createSequentialGroup()
                        .addComponent(HorarioConsultaText1)
                        .addGap(4, 4, 4)
                        .addComponent(HorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CARD_CLINICALayout.createSequentialGroup()
                        .addComponent(DataConsultaText)
                        .addGap(4, 4, 4)
                        .addComponent(DataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoConsultaText1))
                .addGap(18, 18, 18)
                .addGroup(CARD_CLINICALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MedicoText)
                    .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        EditarDialogPanel.add(CARD_CLINICA, "CARD_CLINICA");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EditarDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Ticket)
                                .addComponent(NomePaciente, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
                            .addComponent(TicketText)
                            .addComponent(NomePacienteText))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(TicketText, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ticket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NomePacienteText)
                .addGap(3, 3, 3)
                .addComponent(NomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditarDialogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TicketActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TicketActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        String ticketStr = Ticket.getText();
        String dataStr = DataConsulta.getText();
        String horarioStr = HorarioConsulta.getText();
        Object medicoObj = Medico.getSelectedItem();
        String tipoConsulta = TipoConsulta.getSelectedItem().toString();

        boolean sucesso = ClinicativaController.processarAlteracaoConsulta(this, ticketStr, dataStr, horarioStr, medicoObj, tipoConsulta);

        if(sucesso){ 
            this.dispose();
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void HorarioConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioConsultaActionPerformed

    private void Salvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Salvar1ActionPerformed
        String ticketStr = Ticket.getText();
        String dataStr = DataConsulta.getText();
        String horarioStr = HorarioConsulta.getText();
        Object medicoObj = Medico.getSelectedItem();
        String tipoAnestesia = TipoAnestesia.getSelectedItem().toString();
        String tipoCir = TipoCirurgia.getText();

        boolean sucesso = ClinicativaController.processarAlteracaoCirurgia(this, ticketStr, dataStr, horarioStr, medicoObj, tipoAnestesia, tipoCir);

        if(sucesso){ 
            this.dispose();
        }
    }//GEN-LAST:event_Salvar1ActionPerformed

    private void HorarioCirurgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioCirurgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioCirurgiaActionPerformed

    private void TipoCirurgiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoCirurgiaFocusGained
        if (TipoCirurgia.getText().equals("Digite o tipo da Cirurgia...")) {
            TipoCirurgia.setText("Digite o tipo da Cirurgia...");
            TipoCirurgia.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_TipoCirurgiaFocusGained

    private void TipoCirurgiaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoCirurgiaFocusLost
        if (TipoCirurgia.getText().trim().isEmpty()) {
            TipoCirurgia.setText("Digite o tipo da Cirurgia...");
            TipoCirurgia.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_TipoCirurgiaFocusLost

    private void TipoCirurgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoCirurgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoCirurgiaActionPerformed

    private void TipoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoConsultaActionPerformed

    private void MedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicoActionPerformed

    private void Medico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Medico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Medico1ActionPerformed

    private void DataConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataConsultaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataConsultaActionPerformed
    
    private void limparCampos(){
        HorarioConsulta.setValue(null);
        DataConsulta.setValue(null);
        Medico.setSelectedIndex(0);
        TipoConsulta.setSelectedIndex(0);
    }

    public void carregarMedicosNoCombo(){
        Medico.removeAllItems();

        Medico.setRenderer(new javax.swing.DefaultListCellRenderer() {
        @Override
        public java.awt.Component getListCellRendererComponent(
                javax.swing.JList<?> list, Object value, int index, 
                boolean isSelected, boolean cellHasFocus) {
            
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        
            if (value instanceof com.artur.clinica.model.Medico) {
                com.artur.clinica.model.Medico med = (com.artur.clinica.model.Medico) value;
                setText(med.getNome() + " (CRM: " + med.getCrm() + ")");
            }
            
            return this;
            }
        });

        com.artur.clinica.services.ConsultaPostgresDAO dao = new com.artur.clinica.services.ConsultaPostgresDAO();
        java.util.List<com.artur.clinica.model.Medico> lista = dao.listarMedicos();

        for(com.artur.clinica.model.Medico med : lista){
            Medico.addItem(med);
        }
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CARD_CIRURGIA;
    private javax.swing.JPanel CARD_CLINICA;
    private javax.swing.JLabel DataCirurgiaText;
    private javax.swing.JFormattedTextField DataConsulta;
    private javax.swing.JLabel DataConsultaText;
    private javax.swing.JPanel EditarDialogPanel;
    private javax.swing.JFormattedTextField HorarioCirurgia;
    private javax.swing.JLabel HorarioCirurgiaText1;
    private javax.swing.JFormattedTextField HorarioConsulta;
    private javax.swing.JLabel HorarioConsultaText1;
    private javax.swing.JComboBox<com.artur.clinica.model.Medico> Medico;
    private javax.swing.JComboBox<com.artur.clinica.model.Medico> Medico1;
    private javax.swing.JLabel MedicoText;
    private javax.swing.JLabel MedicoText1;
    private javax.swing.JTextField NomePaciente;
    private javax.swing.JLabel NomePacienteText;
    private javax.swing.JButton Salvar;
    private javax.swing.JButton Salvar1;
    private javax.swing.JTextField Ticket;
    private javax.swing.JLabel TicketText;
    private javax.swing.JComboBox<String> TipoAnestesia;
    private javax.swing.JLabel TipoAnestesiaText;
    private javax.swing.JTextField TipoCirurgia;
    private javax.swing.JComboBox<String> TipoConsulta;
    private javax.swing.JLabel TipoConsultaText1;
    // End of variables declaration//GEN-END:variables
}
