
package com.artur.clinica.view;

public class AgendamentoCirurgiaPanel extends javax.swing.JPanel {

    public AgendamentoCirurgiaPanel() {
        initComponents();
        carregarMedicosNoCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MedicoText = new javax.swing.JLabel();
        CPFPaciente = new javax.swing.JFormattedTextField();
        CPFText = new javax.swing.JLabel();
        PacienteNome = new javax.swing.JTextField();
        DataCirurgia = new javax.swing.JFormattedTextField();
        Salvar = new javax.swing.JButton();
        DataCirurgiaText = new javax.swing.JLabel();
        HorarioCirurgia = new javax.swing.JFormattedTextField();
        HorarioCirurgiaText1 = new javax.swing.JLabel();
        TipoAnestesia = new javax.swing.JComboBox<>();
        TipoAnestesiaText = new javax.swing.JLabel();
        Medico = new javax.swing.JComboBox<>();
        TipoCirurgia = new javax.swing.JTextField();
        AgendarNovaCirurgiaText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(248, 250, 252));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 1, 1));
        setName("Medical Appointment Manager - Clinicativa v1.0"); // NOI18N

        MedicoText.setText("Médico");

        CPFPaciente.setBackground(new java.awt.Color(248, 250, 252));
        try {
            CPFPaciente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CPFPaciente.setText("");
        CPFPaciente.setToolTipText("Exemplo: 000.000.000-00");
        CPFPaciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CPFPaciente.addActionListener(this::CPFPacienteActionPerformed);

        CPFText.setText("CPF");

        PacienteNome.setBackground(new java.awt.Color(248, 250, 252));
        PacienteNome.setText("Digite o nome do paciente...");
        PacienteNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PacienteNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PacienteNomeFocusLost(evt);
            }
        });
        PacienteNome.addActionListener(this::PacienteNomeActionPerformed);

        DataCirurgia.setBackground(new java.awt.Color(248, 250, 252));
        DataCirurgia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        DataCirurgia.setToolTipText("Exemplo: 09/09/2026");
        DataCirurgia.addActionListener(this::DataCirurgiaActionPerformed);

        Salvar.setBackground(new java.awt.Color(248, 250, 252));
        Salvar.setText("Salvar");
        Salvar.setFocusable(false);
        Salvar.addActionListener(this::SalvarActionPerformed);

        DataCirurgiaText.setText("Data da Cirurgia ");

        HorarioCirurgia.setBackground(new java.awt.Color(248, 250, 252));
        HorarioCirurgia.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance(java.text.DateFormat.SHORT))));
        HorarioCirurgia.setToolTipText("Exemplo: 15:00");
        HorarioCirurgia.addActionListener(this::HorarioCirurgiaActionPerformed);

        HorarioCirurgiaText1.setText("Horário da Cirurgia");

        TipoAnestesia.setBackground(new java.awt.Color(248, 250, 252));
        TipoAnestesia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Geral", "Local" }));

        TipoAnestesiaText.setText("Tipo da Anestesia");

        Medico.setBackground(new java.awt.Color(248, 250, 252));

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

        AgendarNovaCirurgiaText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        AgendarNovaCirurgiaText.setText("Agendar Nova Cirurgia");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(PacienteNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CPFPaciente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(CPFText)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(TipoAnestesiaText)
                            .addGap(17, 17, 17)
                            .addComponent(TipoAnestesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(MedicoText)
                            .addGap(12, 12, 12)
                            .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(Salvar))
                    .addComponent(AgendarNovaCirurgiaText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TipoCirurgia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(DataCirurgiaText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DataCirurgia, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HorarioCirurgiaText1)
                            .addComponent(HorarioCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AgendarNovaCirurgiaText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(PacienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CPFText)
                .addGap(7, 7, 7)
                .addComponent(CPFPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(HorarioCirurgiaText1)
                        .addGap(4, 4, 4)
                        .addComponent(HorarioCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DataCirurgiaText)
                        .addGap(4, 4, 4)
                        .addComponent(DataCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(TipoCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TipoAnestesia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TipoAnestesiaText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Medico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MedicoText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CPFPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CPFPacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CPFPacienteActionPerformed

    private void PacienteNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PacienteNomeFocusGained
        if (PacienteNome.getText().equals("Digite o nome do paciente...")) {
            PacienteNome.setText("");
            PacienteNome.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_PacienteNomeFocusGained

    private void PacienteNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PacienteNomeFocusLost

        if (PacienteNome.getText().trim().isEmpty()) {
            PacienteNome.setText("Digite o nome do paciente...");
            PacienteNome.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_PacienteNomeFocusLost

    private void PacienteNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PacienteNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PacienteNomeActionPerformed

    private void DataCirurgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataCirurgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DataCirurgiaActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        String cpf = CPFPaciente.getText(); 
        Object medicoSelecionado = Medico.getSelectedItem();
        String data = DataCirurgia.getText(); 
        String horario = HorarioCirurgia.getText(); 
        String tipoAnestesia = TipoAnestesia.getSelectedItem().toString();
        String tipoCirurgia =  TipoCirurgia.getText();
    
        boolean agendadoComSucesso = com.artur.clinica.Controller.ClinicativaController.processarCadastroCirurgia(
            this, cpf, medicoSelecionado, data, horario, tipoAnestesia, tipoCirurgia
        );
        
        if (agendadoComSucesso) {
            limparCampos(); 
        }
    
    }//GEN-LAST:event_SalvarActionPerformed

    private void HorarioCirurgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HorarioCirurgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HorarioCirurgiaActionPerformed

    private void TipoCirurgiaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TipoCirurgiaFocusGained
        if (TipoCirurgia.getText().equals("Digite o tipo da Cirurgia...")) {
            TipoCirurgia.setText("");
            TipoCirurgia.setForeground(java.awt.Color.BLACK);
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
    
    private void limparCampos(){
        PacienteNome.setText("Digite o nome do paciente...");
        PacienteNome.setForeground(java.awt.Color.GRAY);
        CPFPaciente.setValue(null);
        HorarioCirurgia.setValue(null);
        DataCirurgia.setValue(null);
        Medico.setSelectedIndex(0);
        TipoAnestesia.setSelectedIndex(0);
        TipoCirurgia.setText("Digite o tipo da Cirurgia...");
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
    
    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
        if (aFlag) {
            carregarMedicosNoCombo();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AgendarNovaCirurgiaText;
    private javax.swing.JFormattedTextField CPFPaciente;
    private javax.swing.JLabel CPFText;
    private javax.swing.JFormattedTextField DataCirurgia;
    private javax.swing.JLabel DataCirurgiaText;
    private javax.swing.JFormattedTextField HorarioCirurgia;
    private javax.swing.JLabel HorarioCirurgiaText1;
    private javax.swing.JComboBox<com.artur.clinica.model.Medico> Medico;
    private javax.swing.JLabel MedicoText;
    private javax.swing.JTextField PacienteNome;
    private javax.swing.JButton Salvar;
    private javax.swing.JComboBox<String> TipoAnestesia;
    private javax.swing.JLabel TipoAnestesiaText;
    private javax.swing.JTextField TipoCirurgia;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
