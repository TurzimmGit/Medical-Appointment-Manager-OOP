package com.artur.clinica.view;


public class CadastroMedicoPanel extends javax.swing.JPanel {

    public CadastroMedicoPanel() {
        initComponents();
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Especialidades = new javax.swing.JTextField();
        CRMText = new javax.swing.JLabel();
        Salvar = new javax.swing.JButton();
        MedicoNome = new javax.swing.JTextField();
        CRM = new javax.swing.JFormattedTextField();
        CadastarNovoMedicoText = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(248, 250, 252));
        setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 1, 1));

        Especialidades.setBackground(new java.awt.Color(248, 250, 252));
        Especialidades.setText("Digite a Especialidade do Médico...");
        Especialidades.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                EspecialidadesFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                EspecialidadesFocusLost(evt);
            }
        });
        Especialidades.addActionListener(this::EspecialidadesActionPerformed);

        CRMText.setText("CRM");

        Salvar.setBackground(new java.awt.Color(248, 250, 252));
        Salvar.setText("Salvar");
        Salvar.addActionListener(this::SalvarActionPerformed);

        MedicoNome.setBackground(new java.awt.Color(248, 250, 252));
        MedicoNome.setText("Digite o nome do Médico...");
        MedicoNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                MedicoNomeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                MedicoNomeFocusLost(evt);
            }
        });
        MedicoNome.addActionListener(this::MedicoNomeActionPerformed);

        CRM.setBackground(new java.awt.Color(248, 250, 252));
        try {
            CRM.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("########-#/UU")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        CRM.setText("");
        CRM.setToolTipText("Exemplo: 00000000-0/MT");
        CRM.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        CRM.addActionListener(this::CRMActionPerformed);

        CadastarNovoMedicoText.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CadastarNovoMedicoText.setText("Cadastrar Novo Médico");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(MedicoNome, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(CRM, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(CRMText))
                        .addComponent(Especialidades, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE))
                    .addComponent(Salvar))
                .addContainerGap(699, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CadastarNovoMedicoText)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CadastarNovoMedicoText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(MedicoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CRMText)
                .addGap(7, 7, 7)
                .addComponent(CRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Especialidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Salvar)
                .addContainerGap(397, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void EspecialidadesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EspecialidadesFocusGained
        if (Especialidades.getText().equals("Digite a Especialidade do Médico...")) {
            Especialidades.setText("");
            Especialidades.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_EspecialidadesFocusGained

    private void EspecialidadesFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EspecialidadesFocusLost
        if (Especialidades.getText().trim().isEmpty()) {
            Especialidades.setText("Digite a Especialidade do Médico...");
            Especialidades.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_EspecialidadesFocusLost

    private void EspecialidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EspecialidadesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EspecialidadesActionPerformed

    private void SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalvarActionPerformed
        String nome = MedicoNome.getText();
        String crm = CRM.getText();
        String esp = Especialidades.getText();
        
        boolean cadastro = com.artur.clinica.Controller.ClinicativaController.processarCadastroMedico(this, nome, crm, esp);
        
        if(cadastro){
            limparCampos();
        }
    }//GEN-LAST:event_SalvarActionPerformed

    private void MedicoNomeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MedicoNomeFocusGained
        if (MedicoNome.getText().equals("Digite o nome do Médico...")) {
            MedicoNome.setText("");
            MedicoNome.setForeground(java.awt.Color.BLACK);
        }
    }//GEN-LAST:event_MedicoNomeFocusGained

    private void MedicoNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_MedicoNomeFocusLost
    
        if (MedicoNome.getText().trim().isEmpty()) {
            MedicoNome.setText("Digite o nome do Médico...");
            MedicoNome.setForeground(java.awt.Color.GRAY);
        }
    }//GEN-LAST:event_MedicoNomeFocusLost
    
    private void limparCampos(){
        MedicoNome.setText("");
        CRM.setValue(null);
        Especialidades.setText("");
        
        MedicoNome.setText("Digite o nome do Médico...");
        MedicoNome.setForeground(java.awt.Color.GRAY);
        
        Especialidades.setText("Digite a Especialidade do Médico...");
        Especialidades.setForeground(java.awt.Color.GRAY); 
    }
    
    private void MedicoNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MedicoNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MedicoNomeActionPerformed

    private void CRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CRMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CRMActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CRM;
    private javax.swing.JLabel CRMText;
    private javax.swing.JLabel CadastarNovoMedicoText;
    private javax.swing.JTextField Especialidades;
    private javax.swing.JTextField MedicoNome;
    private javax.swing.JButton Salvar;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
