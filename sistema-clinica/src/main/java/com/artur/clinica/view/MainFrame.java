package com.artur.clinica.view;

public class MainFrame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(MainFrame.class.getName());
    private com.artur.clinica.view.OperacoesTabelaPanel painelOperacoes;

    public MainFrame() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        javax.swing.JButton[] botoesMenu = {Home, CadastroPaciente, CadastroMedico, AgendarConsulta, AgendarCirurgia, OperacaoTabela, Exit};
        for (javax.swing.JButton btn : botoesMenu) {
            btn.setContentAreaFilled(false);
            btn.setOpaque(true);           
            btn.setBorderPainted(false);     }
        
        try {
            java.net.URL url = getClass().getResource("/assets/programIcon.png");
            if (url != null) {
                java.awt.Image icone = new javax.swing.ImageIcon(url).getImage();
                this.setIconImage(icone); 
            }
        } catch (Exception e) {
             System.err.println("Erro ao carregar o ícone: " + e.getMessage());
        }
        
        contentPanel.add(new HomePanel(), "HOME");
        contentPanel.add(new CadastroPacientePanel(), "PACIENTE");
        contentPanel.add(new CadastroMedicoPanel(), "MEDICO");
        contentPanel.add(new AgendamentoClinicaPanel(), "CLINICA");
        contentPanel.add(new AgendamentoCirurgiaPanel(), "CIRURGIA");
        contentPanel.add(new OperacoesTabelaPanel(), "OPERACOES");
        
        atualizarEstadoMenuAgendamentos();
        
        javax.swing.Timer timer = new javax.swing.Timer(1000, e -> {
            java.time.LocalDateTime agora = java.time.LocalDateTime.now();
            java.time.format.DateTimeFormatter formatador = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy    HH:mm");
            Data.setText(agora.format(formatador));
        });

        timer.start();
        java.awt.CardLayout cl = (java.awt.CardLayout) contentPanel.getLayout();
        cl.show(contentPanel, "HOME");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BarraSuperior = new javax.swing.JPanel();
        LogoBarraSuperior = new javax.swing.JLabel();
        Data = new javax.swing.JLabel();
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
        setTitle("Medical Appointment Manager - Clinicativa v1.0");

        BarraSuperior.setBackground(new java.awt.Color(2, 132, 199));
        BarraSuperior.setToolTipText("");
        BarraSuperior.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BarraSuperior.setName(""); // NOI18N
        BarraSuperior.setPreferredSize(new java.awt.Dimension(1000, 70));

        LogoBarraSuperior.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        LogoBarraSuperior.setForeground(new java.awt.Color(15, 23, 42));
        LogoBarraSuperior.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/ClinicaBarraSuperior.png"))); // NOI18N
        LogoBarraSuperior.setMaximumSize(new java.awt.Dimension(100, 50));

        Data.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Data.setForeground(new java.awt.Color(15, 23, 42));

        javax.swing.GroupLayout BarraSuperiorLayout = new javax.swing.GroupLayout(BarraSuperior);
        BarraSuperior.setLayout(BarraSuperiorLayout);
        BarraSuperiorLayout.setHorizontalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BarraSuperiorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(LogoBarraSuperior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 539, Short.MAX_VALUE)
                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BarraSuperiorLayout.setVerticalGroup(
            BarraSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(LogoBarraSuperior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(BarraSuperior, java.awt.BorderLayout.PAGE_START);

        BarraLateral.setBackground(new java.awt.Color(30, 41, 59));
        BarraLateral.setPreferredSize(new java.awt.Dimension(180, 600));

        Home.setBackground(new java.awt.Color(14, 165, 233));
        Home.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Home.setForeground(new java.awt.Color(15, 23, 42));
        Home.setText("Home");
        Home.setBorder(null);
        Home.setFocusPainted(false);
        Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                HomeMouseExited(evt);
            }
        });
        Home.addActionListener(this::HomeActionPerformed);

        CadastroPaciente.setBackground(new java.awt.Color(14, 165, 233));
        CadastroPaciente.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CadastroPaciente.setForeground(new java.awt.Color(15, 23, 42));
        CadastroPaciente.setText("Cadastro Paciente");
        CadastroPaciente.setFocusable(false);
        CadastroPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CadastroPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CadastroPacienteMouseExited(evt);
            }
        });
        CadastroPaciente.addActionListener(this::CadastroPacienteActionPerformed);

        CadastroMedico.setBackground(new java.awt.Color(14, 165, 233));
        CadastroMedico.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        CadastroMedico.setForeground(new java.awt.Color(15, 23, 42));
        CadastroMedico.setText("Cadastro Médico");
        CadastroMedico.setFocusable(false);
        CadastroMedico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CadastroMedicoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CadastroMedicoMouseExited(evt);
            }
        });
        CadastroMedico.addActionListener(this::CadastroMedicoActionPerformed);

        AgendarConsulta.setBackground(new java.awt.Color(14, 165, 233));
        AgendarConsulta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AgendarConsulta.setForeground(new java.awt.Color(15, 23, 42));
        AgendarConsulta.setText("Agendar Consulta");
        AgendarConsulta.setFocusable(false);
        AgendarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AgendarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AgendarConsultaMouseExited(evt);
            }
        });
        AgendarConsulta.addActionListener(this::AgendarConsultaActionPerformed);

        AgendarCirurgia.setBackground(new java.awt.Color(14, 165, 233));
        AgendarCirurgia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        AgendarCirurgia.setForeground(new java.awt.Color(15, 23, 42));
        AgendarCirurgia.setText("Agendar Cirurgia");
        AgendarCirurgia.setFocusable(false);
        AgendarCirurgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                AgendarCirurgiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                AgendarCirurgiaMouseExited(evt);
            }
        });
        AgendarCirurgia.addActionListener(this::AgendarCirurgiaActionPerformed);

        OperacaoTabela.setBackground(new java.awt.Color(14, 165, 233));
        OperacaoTabela.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        OperacaoTabela.setForeground(new java.awt.Color(15, 23, 42));
        OperacaoTabela.setText("Operação/Tabela");
        OperacaoTabela.setFocusable(false);
        OperacaoTabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                OperacaoTabelaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                OperacaoTabelaMouseExited(evt);
            }
        });
        OperacaoTabela.addActionListener(this::OperacaoTabelaActionPerformed);

        Exit.setBackground(new java.awt.Color(14, 165, 233));
        Exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Exit.setForeground(new java.awt.Color(15, 23, 42));
        Exit.setText("Sair");
        Exit.setFocusable(false);
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExitMouseExited(evt);
            }
        });
        Exit.addActionListener(this::ExitActionPerformed);

        Copyright.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Copyright.setForeground(new java.awt.Color(248, 250, 252));
        Copyright.setText("©2026 Turzimm");

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
                            .addComponent(OperacaoTabela, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CadastroPaciente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BarraLateralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(BarraLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Copyright)
                            .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45))))
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
                .addContainerGap(147, Short.MAX_VALUE))
        );

        getContentPane().add(BarraLateral, java.awt.BorderLayout.LINE_START);

        contentPanel.setBackground(new java.awt.Color(248, 250, 252));
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
        if (this.painelOperacoes == null) {
            this.painelOperacoes = new com.artur.clinica.view.OperacoesTabelaPanel();
            contentPanel.add(this.painelOperacoes, "OPERACOES");
        }

        this.painelOperacoes.atualizarTabela();
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

    private void HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseEntered
        Home.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_HomeMouseEntered

    private void HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeMouseExited
        Home.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_HomeMouseExited

    private void CadastroPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastroPacienteMouseEntered
        CadastroPaciente.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_CadastroPacienteMouseEntered

    private void CadastroPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastroPacienteMouseExited
        CadastroPaciente.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_CadastroPacienteMouseExited

    private void CadastroMedicoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastroMedicoMouseEntered
        CadastroMedico.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_CadastroMedicoMouseEntered

    private void CadastroMedicoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CadastroMedicoMouseExited
        CadastroMedico.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_CadastroMedicoMouseExited

    private void AgendarCirurgiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgendarCirurgiaMouseEntered
        AgendarCirurgia.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_AgendarCirurgiaMouseEntered

    private void AgendarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgendarConsultaMouseExited
        AgendarConsulta.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_AgendarConsultaMouseExited

    private void AgendarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgendarConsultaMouseEntered
       AgendarConsulta.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_AgendarConsultaMouseEntered

    private void AgendarCirurgiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AgendarCirurgiaMouseExited
        AgendarCirurgia.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_AgendarCirurgiaMouseExited

    private void OperacaoTabelaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OperacaoTabelaMouseEntered
        OperacaoTabela.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_OperacaoTabelaMouseEntered

    private void OperacaoTabelaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OperacaoTabelaMouseExited
        OperacaoTabela.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_OperacaoTabelaMouseExited

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
        Exit.setBackground(new java.awt.Color(2,132,199));
    }//GEN-LAST:event_ExitMouseEntered

    private void ExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseExited
        Exit.setBackground(new java.awt.Color(14,165,233));
    }//GEN-LAST:event_ExitMouseExited

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
    private javax.swing.JButton CadastroMedico;
    private javax.swing.JButton CadastroPaciente;
    private javax.swing.JLabel Copyright;
    private javax.swing.JLabel Data;
    private javax.swing.JButton Exit;
    private javax.swing.JButton Home;
    private javax.swing.JLabel LogoBarraSuperior;
    private javax.swing.JButton OperacaoTabela;
    private javax.swing.JPanel contentPanel;
    // End of variables declaration//GEN-END:variables
}
