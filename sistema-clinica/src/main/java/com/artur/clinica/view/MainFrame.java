
package com.artur.clinica.view;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());

    public MainFrame() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        
        
        contentPanel.add(new HomePanel(), "HOME");
        contentPanel.add(new CadastroPacientePanel(), "PACIENTE");
        contentPanel.add(new CadastroMedicoPanel(), "MEDICO");
        contentPanel.add(new AgendamentoClinicaPanel(), "CLINICA");
        contentPanel.add(new AgendamentoCirurgiaPanel(), "CIRURGIA");
        contentPanel.add(new OperacoesTabelaPanel(), "OPERACOES");
        
        atualizarEstadoMenuAgendamentos();
        
        
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "HOME");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraSuperior = new javax.swing.JPanel();
        BarraSuperiorText = new javax.swing.JLabel();
        BarraLateral = new javax.swing.JPanel();
        Home = new javax.swing.JButton();
        CadastroPaciente = new javax.swing.JButton();
        CadastroMedico = new javax.swing.JButton();
        AgendarConsulta = new javax.swing.JButton();
        AgendarCirurgia = new javax.swing.JButton();
        OperacaoTabela = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        Copyright = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BarraSuperior.setBackground(new java.awt.Color(51, 255, 255));
        BarraSuperior.setToolTipText("");
        BarraSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BarraSuperior.setName(""); // NOI18N
        BarraSuperior.setPreferredSize(new java.awt.Dimension(1000, 70));

        BarraSuperiorText.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        BarraSuperiorText.setText("Clinicativa");
        BarraSuperiorText.setMaximumSize(new java.awt.Dimension(100, 50));

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(BarraSuperiorText, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(835, Short.MAX_VALUE))
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BarraSuperiorText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
        );

        getContentPane().add(BarraSuperior, java.awt.BorderLayout.PAGE_START);

        BarraLateral.setBackground(new java.awt.Color(51, 51, 255));
        BarraLateral.setPreferredSize(new java.awt.Dimension(180, 600));

        Home.setText("Home");
        Home.setBorder(null);
        Home.setFocusPainted(false);
        Home.addActionListener(this::HomeActionPerformed);

        CadastroPaciente.setText("Cadastro Paciente");
        CadastroPaciente.setFocusable(false);
        CadastroPaciente.addActionListener(this::CadastroPacienteActionPerformed);

        CadastroMedico.setText("Cadastro Médico");
        CadastroMedico.setFocusable(false);
        CadastroMedico.addActionListener(this::CadastroMedicoActionPerformed);

        AgendarConsulta.setText("Agendar Consulta");
        AgendarConsulta.setFocusable(false);
        AgendarConsulta.addActionListener(this::AgendarConsultaActionPerformed);

        AgendarCirurgia.setText("Agendar Cirurgia");
        AgendarCirurgia.setFocusable(false);
        AgendarCirurgia.addActionListener(this::AgendarCirurgiaActionPerformed);

        OperacaoTabela.setText("Operação/Tabela");
        OperacaoTabela.setFocusable(false);
        OperacaoTabela.addActionListener(this::OperacaoTabelaActionPerformed);

        Exit.setText("Sair");
        Exit.setFocusable(false);
        Exit.addActionListener(this::ExitActionPerformed);

        Copyright.setText("©2026 Artur Ferreira Sales");

        javax.swing.GroupLayout BarraLateralLayout = new javax.swing.GroupLayout(BarraLateral);
        BarraLateral.setLayout(BarraLateralLayout);
        BarraLateralLayout.setHorizontalGroup(
            BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraLateralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BarraLateralLayout.createSequentialGroup()
                        .addGroup(BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CadastroMedico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgendarConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(AgendarCirurgia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(OperacaoTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(CadastroPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraLateralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
            .addGroup(BarraLateralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Copyright)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        BarraLateralLayout.setVerticalGroup(
            BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraLateralLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadastroPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CadastroMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AgendarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(AgendarCirurgia, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(OperacaoTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Exit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Copyright)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(BarraLateral, java.awt.BorderLayout.LINE_START);

        contentPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        contentPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroMedicoActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "MEDICO");
    }//GEN-LAST:event_CadastroMedicoActionPerformed

    private void AgendarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendarConsultaActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "CLINICA");
    }//GEN-LAST:event_AgendarConsultaActionPerformed

    private void AgendarCirurgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgendarCirurgiaActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "CIRURGIA");
    }//GEN-LAST:event_AgendarCirurgiaActionPerformed

    private void OperacaoTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OperacaoTabelaActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "OPERACOES");
    }//GEN-LAST:event_OperacaoTabelaActionPerformed

    private void CadastroPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroPacienteActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "PACIENTE");
    }//GEN-LAST:event_CadastroPacienteActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "HOME");
    }//GEN-LAST:event_HomeActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
       System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    public void atualizarEstadoMenuAgendamentos(){
        com.artur.clinica.services.ConsultaPostgresDAO dao = new com.artur.clinica.services.ConsultaPostgresDAO();

        boolean liberado = dao.possuiPreRequisitosCadastro();

        AgendarConsulta.setEnabled(liberado);
        AgendarCirurgia.setEnabled(liberado);

        if(!liberado){
            AgendarConsulta.setToolTipText("Cadastre ao menos 1 paciente e 1 médico para habilitar.");
            AgendarCirurgia.setToolTipText("Cadastre ao menos 1 paciente e 1 médico para habilitar.");
        } else {
            AgendarConsulta.setToolTipText(null);
            AgendarCirurgia.setToolTipText(null);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgendarCirurgia;
    private javax.swing.JButton AgendarConsulta;
    private javax.swing.JPanel BarraLateral;
    private javax.swing.JPanel BarraSuperior;
    private javax.swing.JLabel BarraSuperiorText;
    private javax.swing.JButton CadastroMedico;
    private javax.swing.JButton CadastroPaciente;
    private javax.swing.JLabel Copyright;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Home;
    private javax.swing.JButton OperacaoTabela;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
